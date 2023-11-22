package com.cf.file.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.cf.file.dao.repository.FileSystemRepository;
import com.cf.file.domain.FilePrefixHandler;
import com.cf.file.domain.FileSystem;
import com.cf.file.response.UploadFileResult;
import com.cf.file.service.FileSystemService;
import com.cf.framework.domain.file.response.FileSystemCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.BeanUtils;
import com.cf.framework.utils.FileUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.domain.CfSystemConfig;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.request.CfSystemConfigQuery;
import com.cf.ucenter.service.CfSystemConfigService;
import com.cf.ucenter.service.CfWeixinConfigService;
import com.cf.ucenter.wxtools.WeiXinConfigUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.poi.ss.formula.functions.T;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
public class FileSystemServiceImpl implements FileSystemService {

    @Autowired
    FileSystemRepository fileSystemRepository;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfWeixinConfigService cfWeixinConfigService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfSystemConfigService cfSystemConfigService;

    private String endpoint;
    private String keyId;
    private String keySecret;
    private String bucketName;
    @Autowired
    private IdWorker idWorker;


    @Override
    public FileSystem upload(byte[] fileByte, String originalFilename, String contentType, String filetag, String businesskey, String metadata) throws Exception {
        return upload(fileByte, originalFilename, contentType, filetag, businesskey, metadata, "fastdfs");
    }

    @Override
    public FileSystem upload(byte[] fileByte , String originalFilename, String contentType, String filetag, String businesskey, String metadata, String platform) throws Exception {
        if(fileByte ==null){
            ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_FILEISNULL);
        }
        String fileId = null;

        CfSystemConfigQuery cfSystemConfigQuery = new CfSystemConfigQuery();
        cfSystemConfigQuery.setEnName("file_upload_platform");
        List<CfSystemConfig> cfSystemConfigs = cfSystemConfigService.getListByQuery(cfSystemConfigQuery);
        if(cfSystemConfigs!=null && cfSystemConfigs.size()>0){
            platform = cfSystemConfigs.get(0).getValue();
        }

        switch (platform){
            case "fastdfs":
                //第一步：将文件上传到fastDFS中，得到一个文件id
                fileId = fdfs_upload(fileByte, originalFilename);

                break;
            case "ali_oss":
                fileId = aliOssUpload(fileByte, originalFilename);
                break;
            default:
                ExceptionCast.cast(FileSystemCode.FILE_PLATFORM_INVALID);
        }

        if(StringUtils.isEmpty(fileId)){
            ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_SERVERFAIL);
        }

        //第二步：将文件id及其它文件信息存储到mongodb中。
        FileSystem fileSystem = new FileSystem();
        fileSystem.setFileId(fileId);
        fileSystem.setFilePath(fileId);
        fileSystem.setFiletag(filetag);
        fileSystem.setBusinesskey(businesskey);
        fileSystem.setFileName(originalFilename);
        fileSystem.setFileType(contentType);
        if(StringUtils.isNotEmpty(metadata)){
            try {
                Map map = JSON.parseObject(metadata, Map.class);
                fileSystem.setMetadata(map);
            } catch (Exception e) {
                CommonCode commonCode = CommonCode.FAIL;
                commonCode.setMessage(e.getMessage());
                ExceptionCast.cast(commonCode);
            }
        }
//        fileSystemRepository.save(fileSystem);
        return fileSystem;
    }

    @Override
    public Object dynamicHandleFileSourcePrefix(FilePrefixHandler filePrefixHandler) throws Exception {

        String fileSourceAddress = "http://file.cfeng.wang/";

        CfSystemConfigQuery cfSystemConfigQuery = new CfSystemConfigQuery();
        cfSystemConfigQuery.setEnName("file_source_address");
        List<CfSystemConfig> cfSystemConfigs = cfSystemConfigService.getListByQuery(cfSystemConfigQuery);
        if(cfSystemConfigs!=null && cfSystemConfigs.size()>0){
            fileSourceAddress = cfSystemConfigs.get(0).getValue();
        }

        if(filePrefixHandler.getSourceList()!=null && filePrefixHandler.getSourceList().size()>0){
            for (Object object: filePrefixHandler.getSourceList()){
                if(filePrefixHandler.getSourceFields()!=null && filePrefixHandler.getSourceFields().size()>0){
                    for (String sourceField: filePrefixHandler.getSourceFields()){
                        FileUtils.handleFileSourcePrefix(object, fileSourceAddress, sourceField);
                    }
                }
            }
            return filePrefixHandler.getSourceList();
        }else if(filePrefixHandler.getSource()!=null){
            if(filePrefixHandler.getSourceFields()!=null && filePrefixHandler.getSourceFields().size()>0){
                for (String sourceField: filePrefixHandler.getSourceFields()){
                    FileUtils.handleFileSourcePrefix(filePrefixHandler.getSource(), fileSourceAddress, sourceField);
                }
            }
            return filePrefixHandler.getSource();
        }
        return null;
    }

    /**
     *
     * @param bytes
     * @param originalFilename
     * @return
     */
    private String fdfs_upload(byte[] bytes, String originalFilename){
        //初始化fastDFS的环境
        initFdfsConfig();
        //创建trackerClient
        TrackerClient trackerClient = new TrackerClient();
        try {
            TrackerServer trackerServer = trackerClient.getConnection();
            //得到storage服务器

            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
            //创建storageClient来上传文件
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storeStorage);
            //上传文件
            //得到文件扩展名
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String fileId = storageClient1.upload_file1(bytes, ext, null);
            return fileId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //初始化fastDFS环境
    private void initFdfsConfig(){
        //获取配置
        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("fastdfs");
        String trackerServers = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("tracker_servers", cfWeixinConfigs);
        String charset = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("charset", cfWeixinConfigs);
        int networkTimeoutInSeconds = Integer.parseInt(WeiXinConfigUtils.getWeiXinConfigragtionByEnName("network_timeout_in_seconds", cfWeixinConfigs));
        int connectTimeoutInSeconds = Integer.parseInt(WeiXinConfigUtils.getWeiXinConfigragtionByEnName("connect_timeout_in_seconds", cfWeixinConfigs));
        //初始化tracker服务地址（多个tracker中间以半角逗号分隔）
        try {
            ClientGlobal.initByTrackers(trackerServers);
            ClientGlobal.setG_charset(charset);
            ClientGlobal.setG_network_timeout(networkTimeoutInSeconds);
            ClientGlobal.setG_connect_timeout(connectTimeoutInSeconds);
        } catch (Exception e) {
            e.printStackTrace();
            //抛出异常
            ExceptionCast.cast(FileSystemCode.FS_INITFDFSERROR);
        }
    }

    //初始化阿里oss
    private void initAliOssConfig(){

        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("ali_oss");
        endpoint = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("endpoint", cfWeixinConfigs);
        keyId = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("key_id", cfWeixinConfigs);
        keySecret = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("key_secret", cfWeixinConfigs);
        bucketName = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("bucket_name", cfWeixinConfigs);
    }

    private String aliOssUpload(byte[] bytes, String originalFilename) throws Exception{

        initAliOssConfig();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);

        //上传文件的输入流
        InputStream inputStream = new ByteArrayInputStream(bytes);

        // 创建PutObjectRequest对象。
        //第一个参数 Bucket名称
        //第二个参数 上传到oss文件路径和文件名称
        //第三个参数 上传文件输入流

        String filename = null;
        String[] split = originalFilename.split("\\.");
        if(split.length==0){
            ExceptionCast.cast(FileSystemCode.FILE_NAME_INVALID);
        }else{
            filename = idWorker.nextId() + "." + split[split.length - 1];
        }

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filename, inputStream);

        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);

        // 上传文件。
        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();
        return filename;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKeySecret() {
        return keySecret;
    }

    public void setKeySecret(String keySecret) {
        this.keySecret = keySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}

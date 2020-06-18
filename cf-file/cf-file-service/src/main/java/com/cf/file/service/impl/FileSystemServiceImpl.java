package com.cf.file.service.impl;

import com.alibaba.fastjson.JSON;
import com.cf.file.dao.repository.FileSystemRepository;
import com.cf.file.domain.FileSystem;
import com.cf.file.response.UploadFileResult;
import com.cf.file.service.FileSystemService;
import com.cf.framework.domain.file.response.FileSystemCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service(version = "1.0.0")
public class FileSystemServiceImpl implements FileSystemService {

    @Value("${cf.fastdfs.tracker_servers}")
    String tracker_servers;
    @Value("${cf.fastdfs.connect_timeout_in_seconds}")
    int connect_timeout_in_seconds;
    @Value("${cf.fastdfs.network_timeout_in_seconds}")
    int network_timeout_in_seconds;
    @Value("${cf.fastdfs.charset}")
    String charset;

    @Autowired
    FileSystemRepository fileSystemRepository;

    @Override
    public UploadFileResult upload(byte[] fileByte , String originalFilename, String contentType, String filetag, String businesskey, String metadata) {
        if(fileByte ==null){
            ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_FILEISNULL);
        }
        //第一步：将文件上传到fastDFS中，得到一个文件id
        String fileId = fdfs_upload(fileByte, originalFilename);
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
        fileSystemRepository.save(fileSystem);
        UploadFileResult uploadFileResult = new UploadFileResult(CommonCode.SUCCESS, fileSystem);
        return uploadFileResult;
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
        //初始化tracker服务地址（多个tracker中间以半角逗号分隔）
        try {
            ClientGlobal.initByTrackers(tracker_servers);
            ClientGlobal.setG_charset(charset);
            ClientGlobal.setG_network_timeout(network_timeout_in_seconds);
            ClientGlobal.setG_connect_timeout(connect_timeout_in_seconds);
        } catch (Exception e) {
            e.printStackTrace();
            //抛出异常
            ExceptionCast.cast(FileSystemCode.FS_INITFDFSERROR);
        }
    }
}

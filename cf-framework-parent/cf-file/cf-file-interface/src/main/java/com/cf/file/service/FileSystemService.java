package com.cf.file.service;

import com.cf.file.domain.FilePrefixHandler;
import com.cf.file.domain.FileSystem;

public interface FileSystemService {

    FileSystem upload(byte[] fileByte , String originalFilename, String contentType, String filetag, String businesskey, String metadata) throws Exception;

    /**
     * 文件上传
     * @param fileByte 文件流
     * @param originalFilename  原始文件名称
     * @param contentType   内容类型
     * @param filetag   文件标识符
     * @param businesskey   商业key
     * @param metadata  元数据
     * @param platform  平台(fastdfs/ali_oss)
     * @return
     */
    FileSystem upload(byte[] fileByte , String originalFilename, String contentType, String filetag, String businesskey, String metadata, String platform) throws Exception;

    /**
     * 动态处理文件前缀地址(数据库动态获取)
     * @param filePrefixHandler
     * @return
     * @throws Exception
     */
    Object dynamicHandleFileSourcePrefix(FilePrefixHandler filePrefixHandler) throws Exception;
}

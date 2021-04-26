package com.cf.file.service;

import com.cf.file.response.UploadFileResult;

public interface FileSystemService {
    //可轻松改造升级支持阿里云oss
    public UploadFileResult upload(byte[] fileByte , String originalFilename, String contentType,String filetag,String businesskey,String metadata);

}

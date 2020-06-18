package com.cf.file.service;

import com.cf.file.response.UploadFileResult;

public interface FileSystemService {

    public UploadFileResult upload(byte[] fileByte , String originalFilename, String contentType,String filetag,String businesskey,String metadata);

}

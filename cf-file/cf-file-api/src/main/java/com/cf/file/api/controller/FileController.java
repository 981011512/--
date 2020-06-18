package com.cf.file.api.controller;

import com.cf.file.api.swagger.FileSwagger;
import com.cf.file.service.FileSystemService;
import com.cf.framework.domain.file.response.FileSystemCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.exception.ExceptionCast;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("file/")
@Validated
public class FileController implements FileSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private FileSystemService fileSystemService;

    @Override
    @RequestMapping(value = "upload", method = RequestMethod.POST, headers = "content-type=multipart/form-data;charset=utf-8")
    public ResponseResult upload(
            @RequestParam(value = "file", required = true)
            MultipartFile file,
            @RequestParam(value = "filetag", required = false, defaultValue = "")
            String filetag,
            @RequestParam(value = "businesskey", required = true)
            String businesskey,
            @RequestParam(value = "metadata", required = false, defaultValue = "")
            String metadata) {

        try {
            byte[] fileByte = file.getBytes();
            return fileSystemService.upload(fileByte, file.getOriginalFilename(), file.getContentType(), filetag, businesskey, metadata);
        } catch (IOException e) {
            FileSystemCode fsDeletefileDbfail = FileSystemCode.FS_DELETEFILE_DBFAIL;
            fsDeletefileDbfail.setMessage(e.getMessage());
            ExceptionCast.cast(fsDeletefileDbfail);
            return null;
        }
    }
}

package com.cf.file.response;

import com.cf.file.domain.FileSystem;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.response.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by admin on 2018/3/5.
 */
@Data
@ToString
public class UploadFileResult extends ResponseResult implements Serializable {
    @ApiModelProperty(value = "文件信息", example = "true", required = true)
    FileSystem fileSystem;

    public UploadFileResult() {
    }

    public UploadFileResult(ResultCode resultCode, FileSystem fileSystem) {
        super(resultCode);
        this.fileSystem = fileSystem;
    }

}

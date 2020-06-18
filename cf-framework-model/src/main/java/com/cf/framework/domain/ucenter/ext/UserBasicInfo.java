package com.cf.framework.domain.ucenter.ext;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by mrt on 2018/5/21.
 */
@Data
@ToString
@NoArgsConstructor
public class UserBasicInfo implements Serializable {

    private String id;
    private String username;
    private String userpic;
    private String name;
    private String utype;
    //所属企业信息
    private String companyId;
    //jwt令牌
    private String jwt_token;

    private Long exp;

}

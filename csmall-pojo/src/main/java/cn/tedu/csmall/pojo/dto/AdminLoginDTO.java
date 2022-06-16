package cn.tedu.csmall.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Lmy
 */
@Data
public class AdminLoginDTO implements Serializable {

    private String username;
    private String password;
}

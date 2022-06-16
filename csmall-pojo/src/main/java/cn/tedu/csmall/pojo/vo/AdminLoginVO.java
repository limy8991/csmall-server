package cn.tedu.csmall.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lmy
 */
@Data
public class AdminLoginVO implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Integer isEnable;
    private List<String> permissions;
}

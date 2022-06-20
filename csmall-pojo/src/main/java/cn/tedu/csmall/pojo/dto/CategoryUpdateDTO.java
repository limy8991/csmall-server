package cn.tedu.csmall.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Lmy
 */
@Data
public class CategoryUpdateDTO implements Serializable {
    private Long id;
    private String name;
    private String keywords;
    private String icon;
    private Integer sort;
}

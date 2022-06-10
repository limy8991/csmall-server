package cn.tedu.csmall.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class CategoryAddNewDTO implements Serializable {

    private String name;
    private Long parentId;
    private String keywords;
    private Integer sort;
    private String icon;
    private Integer isDisplay;
}

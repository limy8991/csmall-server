package cn.tedu.csmall.pojo.vo;

import lombok.Data;

@Data
public class CategorySimpleVO {
    private Long id;
    private String name;
    private Integer depth;
    private Integer isParent;
}

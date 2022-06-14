package cn.tedu.csmall.pojo.vo;

import lombok.Data;

@Data
public class CategorySimpleListItemVO {

    private Long id;
    private String name;
    private Integer sort;
    private String icon;
    private Integer isParent;
}

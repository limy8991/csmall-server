package cn.tedu.csmall.pojo.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class CategoryDetailsVO implements Serializable {
    private Long id;
    private String name;
    private Integer depth;
    private Integer parentId;
    private String keywords;
    private Integer sort;
    private Integer enable;
    private Integer isParent;
    private Integer isDisplay;
}

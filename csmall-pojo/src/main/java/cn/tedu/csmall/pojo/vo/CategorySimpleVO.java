package cn.tedu.csmall.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Lmy
 */
@Data
public class CategorySimpleVO implements Serializable {

    private Long id;
    private Integer depth;
    private Integer isParent;
    private Integer isEnable;

}
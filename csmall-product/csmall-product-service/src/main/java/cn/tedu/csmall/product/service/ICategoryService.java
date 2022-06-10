package cn.tedu.csmall.product.service;

import cn.tedu.csmall.pojo.dto.CategoryAddNewDTO;

/**
 * @author Lmy
 */
public interface ICategoryService {

    /**
     * 添加"类别"
     * @param categoryAddNewDTO
     */
    void addNew(CategoryAddNewDTO categoryAddNewDTO);
}

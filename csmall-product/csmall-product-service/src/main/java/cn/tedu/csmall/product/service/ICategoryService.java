package cn.tedu.csmall.product.service;

import cn.tedu.csmall.pojo.dto.CategoryAddNewDTO;

public interface ICategoryService {

    /**
     * 添加“类别”
     * @param categoryAddNewDTO 类别
     */
    void addNew(CategoryAddNewDTO categoryAddNewDTO);

}

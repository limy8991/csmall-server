package cn.tedu.csmall.product.service;

import cn.tedu.csmall.pojo.dto.CategoryAddNewDTO;
import org.springframework.transaction.annotation.Transactional;


public interface ICategoryService {

    /**
     * 添加“类别”
     * @param categoryAddNewDTO 类别
     */
    @Transactional
    void addNew(CategoryAddNewDTO categoryAddNewDTO);

}

package cn.tedu.csmall.product.service;

import cn.tedu.csmall.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.pojo.vo.CategorySimpleListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ICategoryService {

    /**
     * 添加“类别”
     * @param categoryAddNewDTO 类别
     */
    @Transactional
    void addNew(CategoryAddNewDTO categoryAddNewDTO);

    List<CategorySimpleListItemVO> listByParentId(Long parentId);

}

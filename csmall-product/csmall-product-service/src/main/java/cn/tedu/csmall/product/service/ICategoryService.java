package cn.tedu.csmall.product.service;

import cn.tedu.csmall.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.pojo.dto.CategoryUpdateDTO;
import cn.tedu.csmall.pojo.vo.AdminLoginVO;
import cn.tedu.csmall.pojo.vo.CategoryDetailsVO;
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

    /**
     * 根据“类别”id查询“类别”的详细信息
     *
     * @param id “类别”id
     * @return “类别”的详细信息，如果没有匹配的数据，将抛出异常
     */
    CategoryDetailsVO getDetailsById(Long id);

    /**
     * 根据父级"类别"查询其所有子级"类别"
     *
     * @param parentId 父级"类别"的id
     * @return 此父级"类别"下的所有子级"类别"的列表
     */
    List<CategorySimpleListItemVO> listByParentId(Long parentId);

    /**
     * 根据id 修改是否禁用
     * @param id
     */
    void updateEnableById(Long id);

    /**
     * 根据id 修改隐藏
     * @param id
     */
    void updateDisplayById(Long id);

    void deleteById(Long id);

    void updateCategoryById(Long id, CategoryUpdateDTO categoryUpdateDTO);





    /**
     * 预热类别数据的缓存
     */
    void preloadCache();





}

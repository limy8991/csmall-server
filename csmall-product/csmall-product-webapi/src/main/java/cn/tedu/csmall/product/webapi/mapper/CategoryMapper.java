package cn.tedu.csmall.product.webapi.mapper;

import cn.tedu.csmall.pojo.entity.Category;
import cn.tedu.csmall.pojo.vo.CategorySimpleListItemVO;
import cn.tedu.csmall.pojo.vo.CategorySimpleVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理“类别”数据的持久层接口
 * @author Lmy
 */
@Repository
public interface CategoryMapper {

    /**
     * 插入“类别”数据
     * @param category 类别
     * @return 受影响的行数
     */
    int insert(Category category);

    /**
     * 根据“类别”id修改“是否为父级类别”
     * @param id “类别”id
     * @param isParent 是否为父级类别，1=是，0=否
     * @return 受影响的行数
     */
    int updateIsParentById(@Param("id") Long id, @Param("isParent") Integer isParent);

    /**
     * 根据“类别”id查询“类别”的简单信息
     * @param id “类别”id
     * @return “类别”的简单信息
     */
    CategorySimpleVO getById(Long id);

    /**
     * 根据“类别”名称查询“类别”的简单信息
     * @param name “类别”名称
     * @return “类别”的简单信息
     */
    CategorySimpleVO getByName(String name);

    /**
     * 根据"父级"类别查询所有"子级"类别
     * @param parentId
     * @return
     */
    List<CategorySimpleListItemVO> listByParentId(Long parentId);

}

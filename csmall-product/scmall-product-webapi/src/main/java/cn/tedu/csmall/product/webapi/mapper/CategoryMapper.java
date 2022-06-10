package cn.tedu.csmall.product.webapi.mapper;

import cn.tedu.csmall.pojo.entity.Category;
import cn.tedu.csmall.pojo.vo.CategorySimpleVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 处理"类别"数据的持久层接口
 * @author Lmy
 */
@Repository
public interface CategoryMapper {
    /**
     * 插入"类别"数据
     * @param category 类别
     * @return 受影响的行数
     */
    int insert(Category category);

    /**
     * 按照名字查找类别
     * @param name
     * @return
     */
    CategorySimpleVO getByName(String name);

    CategorySimpleVO getById(Long id);

    /**
     * 根据"类别"id修改是否为父级类别
     * @param id
     * @param isParent
     * @return
     */
    int updateIsParentById(@Param("id") Long id, @Param("isParent") Integer isParent);
}

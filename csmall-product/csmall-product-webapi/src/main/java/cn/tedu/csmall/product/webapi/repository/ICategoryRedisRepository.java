package cn.tedu.csmall.product.webapi.repository;

import cn.tedu.csmall.pojo.vo.CategoryDetailsVO;

/**
 * @author Lmy
 */
public interface ICategoryRedisRepository {

    String KEY_CATEGORY_ITEM_PREFIX = "categories:item:";

    /**
     * 根据类别id获取类别详情
     * @param id
     * @return
     */
    CategoryDetailsVO getDetailsById(Long id);

    /**
     * 将类别详情存入到redis中
     * @param category
     */
    void save(CategoryDetailsVO category);
}

package cn.tedu.csmall.product.webapi.repository.impl;

import cn.tedu.csmall.pojo.vo.CategoryDetailsVO;
import cn.tedu.csmall.product.webapi.repository.ICategoryRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class CategoryRedisRepositoryImpl implements ICategoryRedisRepository {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public void save(CategoryDetailsVO category) {
        String key = KEY_CATEGORY_ITEM_PREFIX + category.getId();
        redisTemplate.opsForValue().set(key, category);
    }

    @Override
    public CategoryDetailsVO getDetailsById(Long id) {
        String key = KEY_CATEGORY_ITEM_PREFIX + id;
        Serializable result = redisTemplate.opsForValue().get(key);
        if (result == null) {
            return null;
        } else {
            CategoryDetailsVO category = (CategoryDetailsVO) result;
            return category;
        }
    }
}

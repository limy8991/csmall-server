package cn.tedu.csmall.product.webapi;

import cn.tedu.csmall.pojo.entity.Category;
import cn.tedu.csmall.pojo.vo.CategoryDetailsVO;
import cn.tedu.csmall.product.webapi.mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class MybatisCacheTests {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    @Sql({"classpath:truncate.sql", "classpath:insert_data.sql"})
    public void testL1Cache() {
        // Mybatis的一级缓存默认是开启的
        // 必须是同一个SqlSession、同一个Mapper、同样的SQL、同样的参数，才具有缓存效果
        // 无论是关闭SqlSession，还是清空缓存，还是表中的数据发生变化，都会清空原缓存数据
        Long id = 1L;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        CategoryDetailsVO category1 = mapper.getDetailsById(id);
        Category category = new Category();
        category.setName("test");
        mapper.insert(category);
        CategoryDetailsVO category2 = mapper.getDetailsById(id);
        id = 2L;
        CategoryDetailsVO category3 = mapper.getDetailsById(id);
        CategoryDetailsVO category4 = mapper.getDetailsById(id);
        CategoryDetailsVO category5 = mapper.getDetailsById(id);
        System.out.println(category1.hashCode());
        System.out.println(category2.hashCode());
        System.out.println(category3.hashCode());
        System.out.println(category4.hashCode());
        System.out.println(category5.hashCode());
    }

}

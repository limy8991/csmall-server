package cn.tedu.csmall.product.webapi.service;

import cn.tedu.csmall.common.ex.ServiceException;
import cn.tedu.csmall.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.pojo.vo.CategorySimpleListItemVO;
import cn.tedu.csmall.product.service.ICategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CategoryServiceTests {

    @Autowired
    ICategoryService service;

    @Test
    @Sql("classpath:truncate.sql")
    public void testAddNewSuccessfully() {
        // 测试数据
        CategoryAddNewDTO category = new CategoryAddNewDTO();
        category.setName("薯片");
        category.setParentId(0L);
        category.setIcon("未上传类别图标");
        category.setKeywords("未设置关键字");
        category.setSort(88);
        category.setIsDisplay(1);
        // 断言不会抛出异常
        assertDoesNotThrow(() -> {
            // 执行测试
            service.addNew(category);
        });
    }

    @Test
    @Sql({"classpath:truncate.sql", "classpath:insert_data.sql"})
    public void testAddNewFailBecauseNameDuplicate() {
        // 测试数据
        CategoryAddNewDTO category = new CategoryAddNewDTO();
        category.setName("类别001");
        // 断言不会抛出异常
        assertThrows(ServiceException.class, () -> {
            // 执行测试
            service.addNew(category);
        });
    }

    @Test
    @Sql({"classpath:truncate.sql"})
    public void testAddNewFailBecauseParentNotFound() {
        // 测试数据
        CategoryAddNewDTO category = new CategoryAddNewDTO();
        category.setName("类别001");
        category.setParentId(-1L);
        // 断言不会抛出异常
        assertThrows(ServiceException.class, () -> {
            // 执行测试
            service.addNew(category);
        });
    }

    @Test
    //@Sql({"classpath:truncate.sql", "classpath:insert_data.sql"})
    public void testGetDetailsByIdSuccessfully() {
        // 测试数据
        Long id = 16000L;
        // 断言不抛出异常
        // assertDoesNotThrow(() -> {
        service.getDetailsById(id);
        // });
    }

    @Test
    @Sql({"classpath:truncate.sql"})
    public void testGetDetailsByIdFailBecauseNotFound() {
        // 测试数据
        Long id = -1L;
        // 断言抛出异常
        assertThrows(ServiceException.class, () -> {
            service.getDetailsById(id);
        });
    }

    @Test
    @Sql({"classpath:truncate.sql", "classpath:insert_data.sql"})
    public void testListByParentId() {
        // 测试数据
        Long parentId = 1L;
        // 执行测试，获取查询结果
        List<CategorySimpleListItemVO> list = service.listByParentId(parentId);
        // 查看结果
        System.out.println("查询结果数量：" + list.size());
        for (CategorySimpleListItemVO item : list) {
            System.out.println(item);
        }
    }

}

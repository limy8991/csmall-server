package cn.tedu.csmall.admin.webapi.mapper;

import cn.tedu.csmall.pojo.vo.AdminVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdminMapperTests {
    @Autowired(required = false)
    AdminMapper mapper;

    @Test
    @Sql("classpath:truncate.sql")
    public void testInsert(){
        AdminVO adminVO = new AdminVO();
        adminVO.setUsername("张三");
        assertDoesNotThrow(()->{
            int rows = mapper.insert(adminVO);
            assertEquals(1, rows);
            assertEquals(1, adminVO.getId());
        });
    }


}

package cn.tedu.csmall.product.webapi;

import cn.tedu.csmall.pojo.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

@SpringBootTest
public class CsmallProductWebapiApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {

    }

    @Test
    void testConnection() {
        Assertions.assertDoesNotThrow(() ->
        {
            dataSource.getConnection();
        });
    }



}

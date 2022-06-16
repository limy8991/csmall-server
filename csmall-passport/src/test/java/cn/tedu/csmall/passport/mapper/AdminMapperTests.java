package cn.tedu.csmall.passport.mapper;

import cn.tedu.csmall.pojo.vo.AdminLoginVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdminMapperTests {

    @Autowired
    AdminMapper adminMapper;

    @Test
    @Sql({"classpath:truncate.sql","classpath:insert_data.sql"})
    public void LoginInfoByUsernameSuccessfully() {
        //测试数据
        String username = "root";
        //断言不会抛出异常
        Assertions.assertDoesNotThrow(() -> {
            //执行查询
            AdminLoginVO loginInfoByUsername = adminMapper.getLoginInfoByUsername(username);
            System.out.println("loginInfoByUsername = " + loginInfoByUsername);
           Assertions.assertNotNull(loginInfoByUsername);
        });

    }
    @Test
  //  @Sql({"classpath:truncate.sql","classpath:insert_data.sql"})
    public void LoginInfoByUsernameFailBecauseNotFound() {
        //测试数据
        String username = "root";
        //断言不会抛出异常
        Assertions.assertDoesNotThrow(() -> {
            //执行查询
            AdminLoginVO loginInfoByUsername = adminMapper.getLoginInfoByUsername(username);
            System.out.println("loginInfoByUsername = " + loginInfoByUsername);
            Assertions.assertNull(loginInfoByUsername);
        });

    }
}

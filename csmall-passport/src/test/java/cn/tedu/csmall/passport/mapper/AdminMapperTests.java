package cn.tedu.csmall.passport.mapper;

import cn.tedu.csmall.pojo.vo.AdminLoginVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdminMapperTests {

    @Autowired(required = false)
    AdminMapper adminMapper;

    @Test
    public void LoginInfoByUsernameSuccessfully() {
        String username = "root";
        Assertions.assertDoesNotThrow(() -> {
            AdminLoginVO loginInfoByUsername = adminMapper.getLoginInfoByUsername(username);
            System.out.println("loginInfoByUsername = " + loginInfoByUsername);
            assertNotNull(loginInfoByUsername);
        });
    }
}

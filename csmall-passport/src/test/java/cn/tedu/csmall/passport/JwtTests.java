package cn.tedu.csmall.passport;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTests {

    @Test
    public void testGenerateJwt() {
        // 密钥
        String secretKey = "fjdasflkdjslkffdfadsjlkdsaf";

        // Claims
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 9527);
        claims.put("name", "星星");

        // JWT的组件部分：Header（头），Payload（载荷），Signature（签名）
        String jwt = Jwts.builder()
                // Header：指定算法与当前数据类型
                // 格式为： { "alg": 算法, "typ": "jwt" }
                .setHeaderParam(Header.CONTENT_TYPE, "HS256")
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                // Payload：通常包含Claims（自定义数据）和过期时间
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                // Signature：由算法和密钥（secret key）这2部分组成
                .signWith(SignatureAlgorithm.HS256, secretKey)
                // 打包生成
                .compact();

        // eyJjdHkiOiJIUzI1NiIsInR5cCI6IkpXVCIsImFsZyI6IkhTMjU2In0.eyJuYW1lIjoi5pif5pifIiwiaWQiOjk1MjcsImV4cCI6MTY1NTM2NTY3N30.QwBYVgdkdibEpD-pjX4sKfNu3tw8hBLcJy4-UcN1F3c
        System.out.println(jwt);
    }
}

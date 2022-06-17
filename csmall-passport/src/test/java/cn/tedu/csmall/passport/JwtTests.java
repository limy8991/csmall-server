package cn.tedu.csmall.passport;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTests {

    // 密钥
    String secretKey = "fgfdsfadsfadsafdsafdsfadsfadsfdsafdasfdsafdsafdsafds4rttrefds";

    @Test
    public void testGenerateJwt() {
        // Claims
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 9527);
        claims.put("name", "星星");

        // JWT的组成部分：Header（头），Payload（载荷），Signature（签名）
        String jwt = Jwts.builder()
                // Header：指定算法与当前数据类型
                // 格式为： { "alg": 算法, "typ": "jwt" }
                .setHeaderParam(Header.CONTENT_TYPE, "HS256")
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                // Payload：通常包含Claims（自定义数据）和过期时间
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                // Signature：由算法和密钥（secret key）这2部分组成
                .signWith(SignatureAlgorithm.HS256, secretKey)
                // 打包生成
                .compact();

        // eyJjdHkiOiJIUzI1NiIsInR5cCI6IkpXVCIsImFsZyI6IkhTMjU2In0.eyJuYW1lIjoi5pif5pifIiwiaWQiOjk1MjcsImV4cCI6MTY1NTM2NTY3N30.QwBYVgdkdibEpD-pjX4sKfNu3tw8hBLcJy4-UcN1F3c
        // eyJjdHkiOiJIUzI1NiIsInR5cCI6IkpXVCIsImFsZyI6IkhTMjU2In0.eyJuYW1lIjoi5pif5pifIiwiaWQiOjk1MjcsImV4cCI6MTY1NTM2NzMwMn0.qBBHearv8iHPNjtDGtO2ci_-KAL4CALHnwzaG_ljsQg
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        String jwt ="eyJjdHkiOiJIUzI1NiIsInR5cCI6IkpXVCIsImFsZyI6IkhTMjU2In0.eyJwZXJtaXNzaW9ucyI6W3siYXV0aG9yaXR5IjoiL2Ftcy9hZG1pbi9kZWxldGUifSx7ImF1dGhvcml0eSI6Ii9hbXMvYWRtaW4vcmVhZCJ9LHsiYXV0aG9yaXR5IjoiL2Ftcy9hZG1pbi91cGRhdGUifSx7ImF1dGhvcml0eSI6Ii9wbXMvcHJvZHVjdC9kZWxldGUifSx7ImF1dGhvcml0eSI6Ii9wbXMvcHJvZHVjdC9yZWFkIn0seyJhdXRob3JpdHkiOiIvcG1zL3Byb2R1Y3QvdXBkYXRlIn1dLCJleHAiOjE2NTU0MzE5MTUsInVzZXJuYW1lIjoicm9vdCJ9.J_FCacI9O5CwLFrAOfGbluKZw-IHkGd7lJAgJaub5iE";
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();

        String username = claims.get("username").toString();
        Collection<GrantedAuthority> permissions = (Collection<GrantedAuthority>) claims.get("permissions");

        System.out.println("username=" + username);
        System.out.println("permissions=" + permissions);
    }

}

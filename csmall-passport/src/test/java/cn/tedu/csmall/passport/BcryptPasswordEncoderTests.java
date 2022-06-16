package cn.tedu.csmall.passport;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordEncoderTests {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void testEncode() {
        for (int i = 0; i < 10; i++) {
            String rawPassword = "123456";
            String encodePassword = passwordEncoder.encode(rawPassword);
            System.out.println("rawPassword = " + rawPassword);
            System.out.println("encodePassword = " + encodePassword);
        }
//        rawPassword = 123456
//        encodePassword = $2a$10$Bxwg20VjcwWybrbVnjqKo.NNC48xc2EsHlS2hF3tAZfw30DkEK6XG
//        encodePassword = $2a$10$w5PQkFtifpPpdsyPQuFGQO4GK4CVJCSFhESi3wp9EYRT6q6ACIX2u
//        encodePassword = $2a$10$8NXQ06vsrgbmVD0WYPAHgOkjsPziEH789PiavhEtwp9cKLRX7o8Bu
//        encodePassword = $2a$10$pWUWCM6VdGfrTDtF8QcxJefn/2yxX0P.oYye/PscMENZutzF.87Yy
//        encodePassword = $2a$10$.oOU2WBaDNKIegcTeKcOve1xhxDeSc9AYJ5Vz0UMZJfOFIEfSDTtu
//        encodePassword = $2a$10$jUNeDWar.4Nz9FH6OH6Nd.oKEkWXjfa3zmZEzBkjFAchUql1BUcsm
//        encodePassword = $2a$10$LAAYU3GgY2E.ebjHi3Y/ieCFPy8oOnPOqG.BfuJ2BTSaakHEO6EMO
//        encodePassword = $2a$10$TKcf/eTt.I5RNFJKuxax1utOfsjX0kClfd4Glqi0z9tZE0NtggyVC
//        encodePassword = $2a$10$IofXykApr/8MbcJoD3zRV.y8sDHGn9k/0q1Boi2Rj9WpeKduJ0I5.
//        encodePassword = $2a$10$UvJ9bDSLHwBh48.BpffygOPGGnCN8PoRPTbMYwufxjmBSyGiI48iq

    }

    @Test
    public void testMatch() {
        String rawPassword = "123456";
        String encodePassword = "$2a$10$LAAYU3GgY2E.ebjHi3Y/ieCFPy8oOnPOqG.BfuJ2BTSaakHEO6EMO";
        boolean matchResult = passwordEncoder.matches(rawPassword, encodePassword);
        System.out.println("matcheResult = " + matchResult);
    }
}

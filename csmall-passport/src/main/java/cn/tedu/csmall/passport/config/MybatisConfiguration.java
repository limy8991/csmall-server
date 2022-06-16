package cn.tedu.csmall.passport.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lmy
 */
@Configuration
@MapperScan("cn.tedu.csmall.passport.mapper")
public class MybatisConfiguration {
}

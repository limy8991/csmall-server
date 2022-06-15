package cn.tedu.csmall.admin.webapi.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.csmall.admin.webapi.mapper")
public class MybatisConfiguration {
}

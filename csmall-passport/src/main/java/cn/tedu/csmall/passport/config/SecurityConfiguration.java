package cn.tedu.csmall.passport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Lmy
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //禁用防跨域攻击
        http.csrf().disable();

        //URL白名单
        String[] urls = {"/admins/login"};
        //对请求需要授权才可以访问
        http.authorizeRequests()
                //匹配一些路径
                .antMatchers(urls)
                //允许直接访问
                .permitAll()
                //匹配除了以上配置的其他请求
                .anyRequest()
                //都需要认证
                .authenticated();


    }
}

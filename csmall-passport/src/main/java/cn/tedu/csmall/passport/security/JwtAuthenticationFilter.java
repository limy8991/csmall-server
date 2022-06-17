package cn.tedu.csmall.passport.security;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JwtAuthenticationFilter.doFilterInternal()");
        // 客户端提交请求时，必须在请求头的Authentication中添加JWT数据，这是当前服务器程序的规定，客户端必须遵守
        // 尝试获取JWT数据
        String jwt = request.getHeader("Authentication");
        System.out.println("从请求头中获取到的JWT=" + jwt);
        // 判断是否不存在jwt数据
        if (!StringUtils.hasText(jwt)) {
            // 不存在jwt数据，则放行，后续还有其它过滤器及相关组件进行其它的处理，例如未登录则要求登录等
            // 此处不宜直接阻止运行，因为“登录”、“注册”等请求本应该没有jwt数据
            System.out.println("请求头中无JWT数据，当前过滤器将放行");
            filterChain.doFilter(request, response); // 继续执行过滤器链中后续的过滤器
            return; // 必须
        }

        System.out.println("请求头中包含JWT，准备解析此数据……");
        // 注意：此时执行时，如果请求头中携带了Authentication，日志中将输出，且不会有任何响应，因为当前过滤器尚未放行
    }

}

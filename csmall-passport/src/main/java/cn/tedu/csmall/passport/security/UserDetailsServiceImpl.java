package cn.tedu.csmall.passport.security;

import cn.tedu.csmall.passport.mapper.AdminMapper;
import cn.tedu.csmall.pojo.vo.AdminLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("根据用户名查询尝试登录的管理员信息，用户名=" + s);
        AdminLoginVO admin = adminMapper.getLoginInfoByUsername(s);
        System.out.println("通过持久层进行查询，结果=" + admin);

        if (admin == null) {
            System.out.println("根据用户名没有查询到有效的管理员数据，将抛出异常");
            throw new BadCredentialsException("登录失败，用户名不存在！");
        }

        System.out.println("查询到匹配的管理员数据，需要将此数据转换为UserDetails并返回");
        UserDetails userDetails = User.builder()
                .username(admin.getUsername())
                .password(admin.getPassword())
                .accountExpired(false)
                .accountLocked(false)
                .disabled(admin.getIsEnable() != 1)
                .credentialsExpired(false)
                .authorities(admin.getPermissions().toArray(new String[] {}))
                .build();
        System.out.println("转换得到UserDetails=" + userDetails);
        return userDetails;
    }

}

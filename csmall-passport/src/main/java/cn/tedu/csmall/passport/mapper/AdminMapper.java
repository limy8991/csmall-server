package cn.tedu.csmall.passport.mapper;

import cn.tedu.csmall.pojo.vo.AdminLoginVO;
import org.springframework.stereotype.Repository;

/**
 * @author Lmy
 */
@Repository
public interface AdminMapper {

    AdminLoginVO getLoginInfoByUsername(String username);
}

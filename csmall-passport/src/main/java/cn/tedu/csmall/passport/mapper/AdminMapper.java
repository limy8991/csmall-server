package cn.tedu.csmall.passport.mapper;

import cn.tedu.csmall.pojo.vo.AdminLoginVO;

public interface AdminMapper {

    AdminLoginVO getLoginInfoByUsername(String username);
}

package cn.tedu.csmall.admin.webapi.mapper;

import cn.tedu.csmall.pojo.entity.Admin;
import cn.tedu.csmall.pojo.vo.AdminVO;
import org.springframework.stereotype.Repository;

/**
 * 处理"管理员"数据的持久层接口
 */
@Repository
public interface AdminMapper {

    /**
     * 插入"管理员数据"
     * @param adminVO
     * @return
     */
    int insert(AdminVO adminVO);
}

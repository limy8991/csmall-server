package cn.tedu.csmall.common.web;

/**
 * @author Lmy
 */
public enum State {
    /**
     * 成功
     */
    OK(20000),
    /**
     * 客户端引起的--请求参数格式错误
     */
    ERR_BAD_REQUEST(40000),
    /**
     * 客户端引起的--类别--名称冲突（被占用）
     */
    ERR_CATEGORY_NAME_DUPLICATE(40100),
    /**
     * 客户端引起的--类别--数据不存在（查询参数值不正确）
     */
    ERR_CATEGORY_NOT_FOUND(40101),
    /**
     * 类别未找到
     */
    ERR_CATEGORY_DISABLE(40102),
    /**
     * 客户端引起的--JWT--过期
     */
    ERR_JWT_EXPIRED(40900),
    /**
     * 客户端引起的--JWT--数据无效
     */
    ERR_JWT_MALFORMED(40901),
    /**
     * 客户端引起的--JWT--签名错误
     */
    ERR_JWT_SIGNATURE(40902),
    /**
     * 服务端引起的--插入数据错误
     */
    ERR_INSERT(50000),
    /**
     * 服务端引起的--更新数据错误
     */
    ERR_UPDATE(50001),
    /**
     * 服务端引起的--服务器内部错误
     */
    ERR_INTERNAL_SERVER_ERROR(50100);

    private Integer value;

    State(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
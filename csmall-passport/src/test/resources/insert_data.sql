-- 权限表：插入测试数据
insert into ams_permission (name, value, description) values
('商品-商品管理-读取', '/pms/product/read', '读取商品数据，含列表、详情、查询等'),
('商品-商品管理-编辑', '/pms/product/update', '修改商品数据'),
('商品-商品管理-删除', '/pms/product/delete', '删除商品数据'),
('后台管理-管理员-读取', '/ams/admin/read', '读取管理员数据，含列表、详情、查询等'),
('后台管理-管理员-编辑', '/ams/admin/update', '编辑管理员数据'),
('后台管理-管理员-删除', '/ams/admin/delete', '删除管理员数据');

-- 角色表：创建数据表
drop table if exists ams_role;
create table ams_role (
                          id bigint unsigned auto_increment,
                          name varchar(50) default null comment '名称',
                          description varchar(255) default null comment '描述',
                          sort tinyint unsigned default 0 comment '自定义排序序号',
                          gmt_create datetime default null comment '数据创建时间',
                          gmt_modified datetime default null comment '数据最后修改时间',
                          primary key (id)
) comment '角色表' charset utf8mb4;

-- 角色权限关联表：插入测试数据
insert into ams_role_permission (role_id, permission_id) values
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6),
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6),
(3, 1), (3, 2), (3, 3);


-- 注意:管理员的测试数据中,插入的密码值应该为密文
-- 管理员表：插入测试数据
insert into ams_admin (username, password, nickname, email, description, is_enable) values
('root', '$2a$10$Bxwg20VjcwWybrbVnjqKo.NNC48xc2EsHlS2hF3tAZfw30DkEK6XG', 'root', 'root@tedu.cn', '最高管理员', 1),
('super_admin', '$2a$10$w5PQkFtifpPpdsyPQuFGQO4GK4CVJCSFhESi3wp9EYRT6q6ACIX2u', 'administrator', 'admin@tedu.cn', '超级管理员', 1),
('nobody', '$2a$10$8NXQ06vsrgbmVD0WYPAHgOkjsPziEH789PiavhEtwp9cKLRX7o8Bu', '无名', 'liucs@tedu.cn', null, 0);

-- 管理员角色关联表：插入测试数据
insert into ams_admin_role (admin_id, role_id) values
(1, 1), (1, 2), (1, 3), (2, 2), (2, 3), (2, 4), (3, 3);

-- 注意：该页面对应的前台目录为views/xy文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


-- 主菜单
INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external)
VALUES ('176846766803701', NULL, '测试用户表', '/xy/testDemoList', 'xy/TestDemoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2026-01-15 17:01:08', NULL, NULL, 0);

-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('176846766803702', '176846766803701', '添加测试用户表', NULL, NULL, 0, NULL, NULL, 2, 'xy:test_demo:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-15 17:01:08', NULL, NULL, 0, 0, '1', 0);

-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('176846766803703', '176846766803701', '编辑测试用户表', NULL, NULL, 0, NULL, NULL, 2, 'xy:test_demo:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-15 17:01:08', NULL, NULL, 0, 0, '1', 0);

-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('176846766803704', '176846766803701', '删除测试用户表', NULL, NULL, 0, NULL, NULL, 2, 'xy:test_demo:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-15 17:01:08', NULL, NULL, 0, 0, '1', 0);

-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('176846766803705', '176846766803701', '批量删除测试用户表', NULL, NULL, 0, NULL, NULL, 2, 'xy:test_demo:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-15 17:01:08', NULL, NULL, 0, 0, '1', 0);

-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('176846766803706', '176846766803701', '导出excel_测试用户表', NULL, NULL, 0, NULL, NULL, 2, 'xy:test_demo:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-15 17:01:08', NULL, NULL, 0, 0, '1', 0);

-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('176846766803707', '176846766803701', '导入excel_测试用户表', NULL, NULL, 0, NULL, NULL, 2, 'xy:test_demo:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-01-15 17:01:08', NULL, NULL, 0, 0, '1', 0);

-- 角色授权（以 admin 角色为例，role_id 可替换）
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('176846766803708', 'f6817f48af4fb3af11b9e8bf182f618b', '176846766803701', NULL, '2026-01-15 17:01:08', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('176846766803709', 'f6817f48af4fb3af11b9e8bf182f618b', '176846766803702', NULL, '2026-01-15 17:01:08', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('176846766803710', 'f6817f48af4fb3af11b9e8bf182f618b', '176846766803703', NULL, '2026-01-15 17:01:08', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('176846766803711', 'f6817f48af4fb3af11b9e8bf182f618b', '176846766803704', NULL, '2026-01-15 17:01:08', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('176846766803712', 'f6817f48af4fb3af11b9e8bf182f618b', '176846766803705', NULL, '2026-01-15 17:01:08', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('176846766803713', 'f6817f48af4fb3af11b9e8bf182f618b', '176846766803706', NULL, '2026-01-15 17:01:08', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('176846766803714', 'f6817f48af4fb3af11b9e8bf182f618b', '176846766803707', NULL, '2026-01-15 17:01:08', '127.0.0.1');
package com.kkb.mybatis.mapper.xml;

import com.kkb.mybatis.mapper.po.User;

import java.util.List;

/**
 * 主键返回 
 * 批量查询 
 * 查询缓存 
 * 多表关联查询 
 * 延迟加载 
 * PegeHelper分页插件
 * 
 * @author think
 *
 */
public interface UserMapper {
	// 源码分析
	List<User> findUserByUsername(String username);
	
}
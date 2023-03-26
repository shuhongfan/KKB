package com.kkb.mybatis.mapper.annotation;

import com.kkb.mybatis.mapper.po.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AnnotationUserMapper {
	// 查询
	@Select("SELECT * FROM user WHERE id = #{id}")
	public User findUserById(int id);

	// 模糊查询用户列表
	@Select("SELECT * FROM user WHERE username LIKE '%${value}%'")
	public List<User> findUserList(String username);

	// 添加并实现主键返回
	@Insert("INSERT INTO user (username,birthday,sex,address) VALUES (#{username},#{birthday},#{sex},#{address})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", resultType = int.class, before = false)
	public void insertUser(User user);



	// 使用Results注解完成结果映射
	@Results({ @Result(column = "id", property = "id"), @Result(column = "username", property = "username"),
			@Result(column = "sex", property = "sex"), @Result(column = "address", property = "address") })
	@Select("SELECT * FROM user WHERE id = #{id}")
	public User findUserByIdWithResultMap(int id);

}
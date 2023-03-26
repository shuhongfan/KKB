package com.kkb.mybatis.mapper.test;

import com.kkb.mybatis.mapper.annotation.AnnotationUserMapper;
import com.kkb.mybatis.mapper.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AnnotationUserMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	/**
	 * @Before注解的方法会在@Test注解的方法之前执行
	 * 
	 * @throws Exception
	 */
	@Before
	public void init() throws Exception {
		// 指定全局配置文件路径
		String resource = "mybatis-config.xml";
		// 加载资源文件（全局配置文件和映射文件）
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 还有构建者模式，去创建SqlSessionFactory对象
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AnnotationUserMapper AnnotationUserMapper = sqlSession.getMapper(AnnotationUserMapper.class);

		User user = AnnotationUserMapper.findUserById(1);
		System.out.println(user);
	}

	@Test
	public void testFindUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AnnotationUserMapper AnnotationUserMapper = sqlSession.getMapper(AnnotationUserMapper.class);

		List<User> list = AnnotationUserMapper.findUserList("小明");
		System.out.println(list);
	}



}

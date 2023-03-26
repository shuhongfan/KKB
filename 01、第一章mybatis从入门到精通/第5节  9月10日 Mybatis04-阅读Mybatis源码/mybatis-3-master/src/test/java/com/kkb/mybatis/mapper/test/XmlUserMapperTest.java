package com.kkb.mybatis.mapper.test;

import com.kkb.mybatis.mapper.po.User;
import com.kkb.mybatis.mapper.xml.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 基于XML的mapper代理开发方式
 * 
 * @author think
 *
 */
public class XmlUserMapperTest {

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
	public void testStatement() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<Object> list = sqlSession.selectList("com.kkb.mybatis.mapper.xml.UserMapper.findUserByUsername", "詹哥");
		System.out.println(list);
		
	}
	@Test
	public void testProxyStatement() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		List<User> list = mapper.findUserByUsername("詹哥");
		System.out.println(list);

	}
}

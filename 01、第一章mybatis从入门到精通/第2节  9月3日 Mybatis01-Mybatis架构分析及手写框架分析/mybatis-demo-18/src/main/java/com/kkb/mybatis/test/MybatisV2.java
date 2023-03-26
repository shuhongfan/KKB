
package com.kkb.mybatis.test;


import com.kkb.mybatis.framework.config.Configuration;
import com.kkb.mybatis.framework.config.MappedStatement;
import com.kkb.mybatis.po.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;


/**
 * 1.properties配置文件升级为XML配置文件
 * 2.使用面向过程思维去优化代码
 * 3.使用面向对象思维去理解配置文件封装的类的作用
 * 
 * @author 灭霸詹
 *
 * 暗号：天王盖地虎
 *
 */

public class MybatisV2 {
    private Configuration configuration;

    // 根据用户参数（不止一个），查询用户信息集合
    @Test
    public void test(){
        // 加载全局配置文件（会级联加载映射文件）
        loadXML("mybatis-config.xml");

        // 执行业务查询
        Map map = new HashMap();
        map.put("username","千年老亚瑟");
        map.put("sex","男");
        List<User> users2 = selectList("queryUserByParams", map);
        System.out.println(users2);
    }

    private <T> List<T> selectList(String statementId, Object param) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        List<T> results = new ArrayList<>();

        try {
            MappedStatement mappedStatement = configuration.getMappedStatementById(statementId);
            // 获取连接
            connection = getConnection();
            // TODO 执行SqlSource中的方法获取SQL语句
            String sql = getSql(mappedStatement);
            // 获取StatementType,创建Statement
            statement = createStatement(mappedStatement.getStatementType(),connection,sql);
            // 设置参数
            parameterize(statement,param);
            // 执行Statement
            results = query(statement,mappedStatement);
            // 结果映射
            return results;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 8、释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    private <T> List<T> query(Statement statement, MappedStatement mappedStatement) throws Exception{
        List<Object> results = new ArrayList<>();

        if (statement instanceof PreparedStatement){
            PreparedStatement preparedStatement = (PreparedStatement) statement;
            ResultSet rs = preparedStatement.executeQuery();
            Object result = null;

            String resultType = mappedStatement.getResultType();
            Class clazz = Class.forName(resultType);
            while (rs.next()) {
                Constructor constructor = clazz.getConstructor();
                result = constructor.newInstance();
                ResultSetMetaData metaData = rs.getMetaData();
                // 结果集中列的数量
                int columnCount = metaData.getColumnCount();
                for (int i = 0;i<columnCount ;i++){
                    String columnName = metaData.getColumnName(i + 1);
                    // 给对象赋属性值
                    // 查询结果中的列名和要映射的对象的属性名必须一致
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(result,rs.getObject(i+1));
                }

                results.add(result);
            }
        }
        return (List<T>) results;
    }

    private void parameterize(Statement statement, Object param) throws Exception{
        if (statement instanceof PreparedStatement){
            PreparedStatement preparedStatement = (PreparedStatement) statement;

            if (param instanceof Integer){
                preparedStatement.setObject(1,param);
            }else if (param instanceof String){
                preparedStatement.setObject(1,param);
            }else if (param instanceof Map){
                Map map = (Map) param;

                //TODO 需要进行SQL解析之后，才会处理该部分内容
//                String columnnames = properties.getProperty("db.sql." + statementId + ".columnnames");
//                String[] nameArray = columnnames.split(",");
//                for (int i = 0 ; i<nameArray.length ;i++) {
//                    String name = nameArray[i];
//                    Object value = map.get(name);
//
//                    preparedStatement.setObject(i+1,value);
//                }
            }
        }
    }

    private Statement createStatement(String statementType, Connection connection, String sql) throws Exception{

        if (statementType.equals("prepared")){
            return connection.prepareStatement(sql);
        }else if (statementType.equals("callable")){
            return connection.prepareCall(sql);
        }else{
            return connection.createStatement();
        }
    }

    private String getSql(MappedStatement mappedStatement) {
        return null;
    }

    private Connection getConnection() throws Exception{
        DataSource dataSource = configuration.getDataSource();
        return dataSource.getConnection();
    }

    private void loadXML(String location) {
        configuration = new Configuration();

        // 获取配置文件对应的流对象
        InputStream inputStream = getResourceAsStream(location);
        // 获取配置文件对应的Document对象
        Document document = createDocument(inputStream);
        // 按照指定的语义去解析Document文档对象
        parseCofiguration(document.getRootElement());
    }

    /**
     *
     * @param rootElement <configuration></configuration>
     */
    private void parseCofiguration(Element rootElement) {
        Element environments = rootElement.element("environments");
        parseEnvironments(environments);

        Element mappers = rootElement.element("mappers");
        parseMappers(mappers);
    }

    private void parseMappers(Element mappers) {
        List<Element> mapperList = mappers.elements("mapper");
        for (Element mapper : mapperList) {
            String resource = mapper.attributeValue("resource");

            // 获取配置文件对应的流对象
            InputStream inputStream = getResourceAsStream(resource);
            // 获取配置文件对应的Document对象
            Document document = createDocument(inputStream);
            // 按照指定的语义去解析Document文档对象
            parseMapper(document.getRootElement());
        }
    }


    /**
     *
     * @param rootElement <mapper></mapper>
     *
     */
    private void parseMapper(Element rootElement) {
        String namespace = rootElement.attributeValue("namespace");

        List<Element> selectElements = rootElement.elements("select");
        for (Element selectElement : selectElements) {
            parseStatement(namespace,selectElement);
        }
    }

    private void parseStatement(String namespace, Element selectElement) {
        String id = selectElement.attributeValue("id");
        String statementId = namespace+","+id;
        String resultType = selectElement.attributeValue("resultType");
        String statementType = selectElement.attributeValue("statementType");

        // TODO 封装SqlSource数据
        MappedStatement mappedStatement = new MappedStatement();
        // TODO 封装MappedStatement

        configuration.addMappedStatement(statementId,mappedStatement);
    }

    private void parseEnvironments(Element environments) {
        String aDefault = environments.attributeValue("default");

        List<Element> environmentList = environments.elements("environment");
        for (Element environment : environmentList) {
            String id = environment.attributeValue("id");
            if (aDefault.equals(id)){
                parseDataSource(environment);
            }
        }
    }

    private void parseDataSource(Element environment) {
        Element dataSource = environment.element("dataSource");
        String type = dataSource.attributeValue("type");
        if ("DBCP".equals(type)){
            BasicDataSource ds = new BasicDataSource();

            Properties properties = parseProperties(dataSource);

            ds.setDriverClassName(properties.getProperty("db.driver"));
            ds.setUrl(properties.getProperty("db.url"));
            ds.setUsername(properties.getProperty("db.username"));
            ds.setPassword(properties.getProperty("db.password"));

            configuration.setDataSource(ds);
        }
    }

    private Properties parseProperties(Element dataSource) {
        List<Element> propertyList = dataSource.elements("property");
        Properties properties = new Properties();
        for (Element property : propertyList) {
            String name = property.attributeValue("name");
            String value = property.attributeValue("value");
            properties.put(name,value);
        }
        return properties;
    }

    private Document createDocument(InputStream inputStream) {
        try {
            SAXReader saxReader = new SAXReader();
            return saxReader.read(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private InputStream getResourceAsStream(String location) {

        return this.getClass().getClassLoader().getResourceAsStream(location);
    }
}

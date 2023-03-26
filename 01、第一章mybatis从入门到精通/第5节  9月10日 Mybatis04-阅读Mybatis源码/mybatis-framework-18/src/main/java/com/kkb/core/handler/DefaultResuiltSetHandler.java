package com.kkb.core.handler;

import com.kkb.core.config.MappedStatement;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultResuiltSetHandler implements ResultSetHandler{
    @Override
    public <T> List<T> handleResult(Statement statement , ResultSet rs, MappedStatement mappedStatement) throws Exception{
        List<Object> results = new ArrayList<>();

        if (statement instanceof PreparedStatement){
            PreparedStatement preparedStatement = (PreparedStatement) statement;
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
}

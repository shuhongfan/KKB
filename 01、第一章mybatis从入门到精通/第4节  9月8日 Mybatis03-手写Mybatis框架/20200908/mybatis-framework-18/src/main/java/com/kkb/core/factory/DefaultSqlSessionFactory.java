package com.kkb.core.factory;

import com.kkb.core.config.Configuration;
import com.kkb.core.sqlsessoin.DefaultSqlSession;
import com.kkb.core.sqlsessoin.SqlSession;

/**
 * 使用的是工厂方法设计模式
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}

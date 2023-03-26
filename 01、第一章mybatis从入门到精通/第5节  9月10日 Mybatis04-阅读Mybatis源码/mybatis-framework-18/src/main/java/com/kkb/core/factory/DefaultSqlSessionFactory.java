package com.kkb.core.factory;

import com.kkb.core.config.Configuration;
import com.kkb.core.executor.Executor;
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
        // 获取Executor
        // 一种是默认simple
        // 一种是全局的配置
        // 一种是制定的ExecutorType
        Executor executor = configuration.newExecutor(null);
        return new DefaultSqlSession(configuration,executor);
    }
}

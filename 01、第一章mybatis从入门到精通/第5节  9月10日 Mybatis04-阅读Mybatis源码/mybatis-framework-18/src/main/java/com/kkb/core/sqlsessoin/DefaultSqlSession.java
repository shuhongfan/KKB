package com.kkb.core.sqlsessoin;

import com.kkb.core.config.Configuration;
import com.kkb.core.config.MappedStatement;
import com.kkb.core.executor.Executor;

import java.util.List;

public class DefaultSqlSession implements SqlSession{
    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration,Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> List<T> selectList(String statementId, Object param) {
        // 获取MappedStatement
        MappedStatement mappedStatement = configuration.getMappedStatementById(statementId);

        // 调用Executor的方法
        return executor.query(configuration,mappedStatement,param);
    }

    @Override
    public <T> T selectOne(String statementId, Object param) {
        List<T> list = this.selectList(statementId, param);
        if (list != null && list.size() == 1){
            return list.get(0);
        }else{
            // TODO 抛出异常
        }
        return null;
    }
}

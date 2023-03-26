package com.kkb.core.sqlsessoin;

import com.kkb.core.config.Configuration;

import java.util.List;

public class DefaultSqlSession implements SqlSession{
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> List<T> selectList(String statementId, Object param) {
        return null;
    }

    @Override
    public <T> T selectOne(String statementId, Object param) {
        return null;
    }
}

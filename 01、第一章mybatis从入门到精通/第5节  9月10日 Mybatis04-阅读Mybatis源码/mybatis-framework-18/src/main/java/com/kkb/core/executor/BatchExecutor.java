package com.kkb.core.executor;

import com.kkb.core.config.Configuration;
import com.kkb.core.config.MappedStatement;
import com.kkb.core.sqlsource.BoundSql;

import java.util.List;

public class BatchExecutor extends BaseExecutor{
    @Override
    protected <T> List<T> queryFromDataBase(Configuration configuration, MappedStatement mappedStatement, BoundSql boundSql, Object param) {
        return null;
    }
}

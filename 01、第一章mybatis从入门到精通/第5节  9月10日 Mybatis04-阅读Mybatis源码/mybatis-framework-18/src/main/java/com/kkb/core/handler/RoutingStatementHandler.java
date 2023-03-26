package com.kkb.core.handler;

import com.kkb.core.config.Configuration;
import com.kkb.core.config.MappedStatement;
import com.kkb.core.sqlsource.BoundSql;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class RoutingStatementHandler implements StatementHandler{
    private StatementHandler delegate;

    public RoutingStatementHandler(String statementType, Configuration configuration) {
        switch (statementType){
            case "prepared":
                delegate = new PreparedStatementHandler(configuration);
                break;
            case "callable":
                delegate = new CallableStatementHandler(configuration);
                break;
            case "simple":
                delegate = new SimpleStatementHandler(configuration);
            default:
                delegate = new PreparedStatementHandler(configuration);
        }

    }

    @Override
    public Statement prepare(Connection connection, String sql) throws Exception {
        return delegate.prepare(connection,sql);
    }

    @Override
    public void parameterize(Statement statement, Object param, BoundSql boundSql)  throws Exception{
        delegate.parameterize(statement,param,boundSql);
    }

    @Override
    public <T> List<T> query(Statement statement, MappedStatement mappedStatement)  throws Exception{
        return delegate.query(statement,mappedStatement);
    }
}

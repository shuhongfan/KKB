package com.kkb.core.handler;

import com.kkb.core.config.MappedStatement;
import com.kkb.core.sqlsource.BoundSql;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public interface StatementHandler {
    Statement prepare(Connection connection, String sql) throws Exception;

    void parameterize(Statement statement, Object param, BoundSql boundSql) throws Exception;

    <T> List<T> query(Statement statement, MappedStatement mappedStatement) throws Exception;
}

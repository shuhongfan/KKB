package com.kkb.core.handler;

import com.kkb.core.config.Configuration;
import com.kkb.core.config.MappedStatement;
import com.kkb.core.sqlsource.BoundSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class PreparedStatementHandler implements StatementHandler{
    private ParameterHandler parameterHandler;
    private ResultSetHandler resultSetHandler;

    public PreparedStatementHandler(Configuration configuration) {
        this.parameterHandler = configuration.newParameterHandler();
        this.resultSetHandler = configuration.newResultSetHandler();
    }

    @Override
    public Statement prepare(Connection connection, String sql) throws Exception{
        return connection.prepareStatement(sql);
    }

    @Override
    public void parameterize(Statement statement, Object param, BoundSql boundSql)  throws Exception{
        PreparedStatement preparedStatement = (PreparedStatement) statement;
        // 真正进行参数处理的是ParameterHandler
        parameterHandler.setPatameter(preparedStatement,param, boundSql);
    }

    @Override
    public <T> List<T> query(Statement statement, MappedStatement mappedStatement)  throws Exception{
        PreparedStatement preparedStatement = (PreparedStatement) statement;
        ResultSet rs = preparedStatement.executeQuery();

        return resultSetHandler.handleResult(statement,rs,mappedStatement);
    }
}

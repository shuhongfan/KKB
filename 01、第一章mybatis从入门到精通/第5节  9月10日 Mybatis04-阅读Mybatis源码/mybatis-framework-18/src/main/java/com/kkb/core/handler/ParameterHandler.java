package com.kkb.core.handler;

import com.kkb.core.sqlsource.BoundSql;

import java.sql.PreparedStatement;

public interface ParameterHandler {
    void setPatameter(PreparedStatement statement, Object param, BoundSql boundSql) throws Exception;
}

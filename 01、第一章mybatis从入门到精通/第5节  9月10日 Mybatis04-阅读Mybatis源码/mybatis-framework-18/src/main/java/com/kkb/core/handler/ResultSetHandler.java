package com.kkb.core.handler;

import com.kkb.core.config.MappedStatement;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public interface ResultSetHandler {
    <T> List<T> handleResult(Statement statement , ResultSet rs, MappedStatement mappedStatement)  throws Exception ;
}

package com.kkb.core.executor;

import com.kkb.core.config.MappedStatement;

import java.util.List;

public interface Executor {

    <T> List<T> query(MappedStatement mappedStatement, Object param);
}

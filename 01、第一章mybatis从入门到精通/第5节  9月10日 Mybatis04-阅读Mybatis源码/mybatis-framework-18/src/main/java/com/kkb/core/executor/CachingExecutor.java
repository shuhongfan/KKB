package com.kkb.core.executor;

import com.kkb.core.config.Configuration;
import com.kkb.core.config.MappedStatement;

import java.util.List;

public class CachingExecutor implements Executor{
    // 真正干活的执行器
    private Executor delegate;

    public CachingExecutor(Executor delegate) {
        this.delegate = delegate;
    }

    @Override
    public <T> List<T> query(Configuration configuration, MappedStatement ms, Object param) {
        // TODO 二级缓存的处理
        // 可以从ms中获取它的二级缓存对象

        // 如果没有配置二级缓存，则走真正的处理器
        return delegate.query(configuration,ms,param);
    }
}

package com.kkb.core.executor;

import com.kkb.core.cache.PerpetualCache;
import com.kkb.core.config.Configuration;
import com.kkb.core.config.MappedStatement;
import com.kkb.core.sqlsource.BoundSql;
import com.kkb.core.sqlsource.SqlSource;

import java.util.List;

// 抽象出来一级缓存的处理逻辑
public abstract class BaseExecutor implements Executor{

    private PerpetualCache cache = new PerpetualCache();

    @Override
    public <T> List<T> query(Configuration configuration, MappedStatement mappedStatement, Object param) {
        // 先从一级缓存中获取数据
        SqlSource sqlSource = mappedStatement.getSqlSource();
        BoundSql boundSql = sqlSource.getBoundSql(param);

        String cacheKey = crateCacheKey(boundSql);
        List<T> list = (List<T>) cache.get(cacheKey);
        // 没有再查询数据库
        if ( list== null){
            list = queryFromDataBase(configuration, mappedStatement,boundSql,param);

            cache.put(cacheKey,list);
        }

        return list;
    }

    protected abstract <T> List<T> queryFromDataBase(Configuration configuration, MappedStatement mappedStatement, BoundSql boundSql, Object param);

    protected String crateCacheKey(BoundSql boundSql){
        return boundSql.getSql();
    }
}

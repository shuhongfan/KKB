package com.kkb.core.factory;

import com.kkb.core.sqlsessoin.SqlSession;

public interface SqlSessionFactory {

    SqlSession openSession();
}

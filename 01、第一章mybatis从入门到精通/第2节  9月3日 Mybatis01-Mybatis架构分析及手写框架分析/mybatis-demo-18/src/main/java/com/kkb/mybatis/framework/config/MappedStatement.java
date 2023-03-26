package com.kkb.mybatis.framework.config;

/**
 * 存储映射文件中的crud标签的内容
 */
public class MappedStatement {
    private String id;

    private String resultType;

    private String statementType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getStatementType() {
        return statementType;
    }

    public void setStatementType(String statementType) {
        this.statementType = statementType;
    }
}

package com.example.designpatternpractice.proxy;

public class QueryExcecutorImpl implements QueryExecutor {
    public QueryExcecutorImpl() {

    }

    @Override
    public void execute(String sql) {
        System.out.println("sql: " + sql);
    }
}

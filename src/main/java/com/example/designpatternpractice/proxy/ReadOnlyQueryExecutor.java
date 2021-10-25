package com.example.designpatternpractice.proxy;

public class ReadOnlyQueryExecutor implements QueryExecutor {
    private final QueryExecutor queryExecutor;
    public ReadOnlyQueryExecutor(QueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
    }

    @Override
    public void execute(String sql) {
        if (!isSelectQuery(sql)) {
            System.out.println("읽기 전용이므로 CUD 쿼리는 수행되지 않습니다. : " + sql);
            return;
//            throw new RuntimeException("읽기 전용이므로 CUD 쿼리는 수행되지 않습니다. : " + sql);
        }

        queryExecutor.execute(sql);
    }

    private boolean isSelectQuery(String sql) {
        return sql.startsWith("select");
    }

}

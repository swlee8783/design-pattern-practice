package com.example.designpatternpractice;


import com.example.designpatternpractice.proxy.QueryExcecutorImpl;
import com.example.designpatternpractice.proxy.QueryExecutor;
import com.example.designpatternpractice.proxy.ReadOnlyQueryExecutor;
import org.springframework.context.annotation.Bean;

public class Main {
    private QueryExecutor readOnlyQueryExecutor;

    public Main(QueryExecutor readOnlyQueryExecutor){
        this.readOnlyQueryExecutor = readOnlyQueryExecutor;
    }

    public void query(String sql){
        readOnlyQueryExecutor.execute(sql);
    }

    public static void main(String[] args) {
        /*
        Decorator

        Beverage water = new Water();
        water.printPrice();

        Beverage milk = new Milk();
        milk.printPrice();

        Beverage espresso = new Espresso();
        espresso.printPrice();

        Beverage americano = new Americano(espresso, water);
        americano.printPrice();

        Beverage caffeLatte = new CaffeLatte(espresso, milk);
        caffeLatte.printPrice();

        Beverage mocha = new CaffeMocha(caffeLatte, 500);
        mocha.printPrice();
        */

        /*
        Proxy


        QueryExecutor queryExecutor = new QueryExcecutorImpl();
        QueryExecutor readOnlyQueryExecutor = new ReadOnlyQueryExecutor(queryExecutor);

        readOnlyQueryExecutor.execute("select * from user where id = 1");
        readOnlyQueryExecutor.execute("update user set name = 'hello' where id = 1");
        readOnlyQueryExecutor.execute("delete from user where id = 2");

         */

    }

    @Bean
    public QueryExecutor queryExecutor() {
        return new QueryExcecutorImpl();
    }

    @Bean
    public ReadOnlyQueryExecutor readOnlyQueryExecutor(QueryExecutor queryExecutor) {
        return new ReadOnlyQueryExecutor(queryExecutor);
    }
}

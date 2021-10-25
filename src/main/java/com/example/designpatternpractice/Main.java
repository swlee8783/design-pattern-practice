package com.example.designpatternpractice;


import com.example.designpatternpractice.proxy.QueryExcecutorImpl;
import com.example.designpatternpractice.proxy.QueryExecutor;
import com.example.designpatternpractice.proxy.ReadOnlyQueryExecutor;
import com.example.designpatternpractice.strategy.CouponService;
import com.example.designpatternpractice.template.key.AlphabetKey;
import com.example.designpatternpractice.template.key.KeyboardKey;
import com.example.designpatternpractice.template.keyboard.Keyboard;
import com.example.designpatternpractice.template.keyboard.LoggingKeyboard;
import org.springframework.context.annotation.Bean;

public class Main {
    private QueryExecutor readOnlyQueryExecutor;

    // 실제 Spring 사용시 new 하지 말고 Bean 사용
    private static CouponService couponService = new CouponService();

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

        /*
        Strategy

//        Coupon discountCoupon = new DiscountCoupon(2000);
//        System.out.println(discountCoupon.calc(3000));
//
//        Coupon percentageCoupon = new PercentageCoupon(15);
//        System.out.println(percentageCoupon.calc(3000));

        int productPrice = 1000;

        Product iPadPro = new Product("아이패드 프로", 15000000);

        Coupon percentageCoupon = couponService.getCoupon(10L);
//        System.out.println(percentageCoupon.calc(productPrice));

        int discountAmount = iPadPro.discount(percentageCoupon);
        System.out.println("최종 가격: " + discountAmount);

//        Coupon discountCoupon = couponService.getCoupon(500L);
//        System.out.println(discountCoupon.calc(productPrice));

         */

        /*
        template method
         */

//        Keyboard keyboard = new LoggingKeyboard();

        Keyboard keyboard = new EscKeyMonitoringKeyboard();
        keyboard.press(new AlphabetKey("A"));
        keyboard.press(new AlphabetKey("B"));
        keyboard.press(new AlphabetKey("C"));
        keyboard.press(new AlphabetKey("ESC"));
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

package com.example.designpatternpractice;


import com.example.designpatternpractice.decorator.*;

public class Main {
    public static void main(String[] args) {
        /*
        Decorator

         */

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
    }
}

package com.example.designpatternpractice.decorator;

public interface Beverage {
    default String getName() {
        return getClass().getSimpleName();
    }

    int getPrice();

    default void printPrice() {
        System.out.println(getName() + " 가격은 " + getPrice() + "원");
    }
}

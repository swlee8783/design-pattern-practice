package com.example.designpatternpractice;

public class PercentageCoupon implements Coupon {
    private int ratio;

    public PercentageCoupon(int ratio) {
        this.ratio = ratio;
    }

    @Override
    public int calc(int produceAmount) {
        int discountedAmount = (int) (produceAmount * (double) ratio / 100);

        return Math.max(produceAmount - discountedAmount, 0);
    }
}

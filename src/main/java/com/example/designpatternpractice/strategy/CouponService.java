package com.example.designpatternpractice.strategy;

public class CouponService {

    private CouponRepository couponRepository = new MockCouponRepository();

    public Coupon getCoupon(long couponId) {
        /*
        기존 사용 방식
        couponRepository.findById(1L)
                .map();

         */
        return couponRepository.findById(couponId)
                .orElseThrow(RuntimeException::new);
    }
}

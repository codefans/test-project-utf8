package com.codefans.interview.algorithm.practise;

import com.codefans.basicjava.java6.math.BigDecimalUtils;

import java.math.BigDecimal;

/**
 * @Author: codefans
 * @Date: 2019-06-13 23:43
 */

public class CycleInterest {

    /**
     * 本金,单位分
     */
    private Long principal;

    /**
     * 利息,单位分
     */
    private Long interest;

    /**
     * 利率,年利率
     */
    private BigDecimal rate;

    private BigDecimalUtils bigDecimalUtils = new BigDecimalUtils();

//    public CycleInterest(Long principal, BigDecimal rate) {
//        this.principal = principal;
//        this.rate = rate;
//    }

    public BigDecimal getInterest(Long principal, BigDecimal rate, Long days) {
        BigDecimal principalAmount = new BigDecimal(principal);
        BigDecimal tmp = bigDecimalUtils.multiplyWithoutRound(principalAmount, rate);
        tmp = bigDecimalUtils.divide(tmp, new BigDecimal(365), 8);
        return bigDecimalUtils.multiplyWithoutRound(tmp, new BigDecimal(days));
    }

    public static void main(String[] args) {
        CycleInterest cycleInterest = new CycleInterest();
//        cycleInterest.basicCal();
        cycleInterest.cycleCal();
    }

    public void basicCal() {
        Long principal = 100000L;
        BigDecimal rate = new BigDecimal("0.0385");
        Long days = 93L;
        BigDecimal interest = getInterest(principal, rate, days);
        System.out.println("本金=" + principal + ", 利率=" + rate + ", 期限=" + days + ", 利息" + interest.setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    public void cycleCal() {

        Long principal = 500000L;
        Long calPrincipal = 0L;
        Long addedPrincipal = 0L;

        BigDecimal totalPrincipal = new BigDecimal(principal);
        BigDecimal rate = new BigDecimal("0.0385");
        Long days = 30L;

        int months = 100;
        BigDecimal interest = new BigDecimal(0);
        BigDecimal totalInterest = new BigDecimal(0);

        for(int i = 0; i < months; i ++) {
            calPrincipal = principal + addedPrincipal;
            interest = getInterest(calPrincipal, rate, days);
            totalInterest = bigDecimalUtils.add(totalInterest, interest);
            addedPrincipal = addedPrincipal(totalInterest);
//            principal += addedPrincipal;
            totalPrincipal = bigDecimalUtils.add(totalPrincipal, interest);
            System.out.println("interest=" + interest + ", principal=" + calPrincipal + ", totalInterest=" + totalInterest + ", addedPrincipal=" + addedPrincipal + ", totalPrincipal=" + totalPrincipal);
        }


    }

    public Long addedPrincipal(BigDecimal interest) {
        Long tmp = bigDecimalUtils.multiply(interest, new BigDecimal(100), 0).longValue();
        return (tmp / (1000 * 100)) * 1000;
    }

}

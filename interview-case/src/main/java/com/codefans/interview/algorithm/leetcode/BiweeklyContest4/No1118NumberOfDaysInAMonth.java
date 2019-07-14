package com.codefans.interview.algorithm.leetcode.BiweeklyContest4;

import java.util.Calendar;
import java.util.Date;

/**
 * @author: codefans
 * @date: 2019-07-13 22:34
 */
public class No1118NumberOfDaysInAMonth {

    public static void main(String[] args) {
        No1118NumberOfDaysInAMonth no1118NumberOfDaysInAMonth = new No1118NumberOfDaysInAMonth();
        int year = 1900;
        int month = 2;
        int days = no1118NumberOfDaysInAMonth.getDays(year, month);
        System.out.println(days);
    }

    public int getDays(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maxDay;
    }



}

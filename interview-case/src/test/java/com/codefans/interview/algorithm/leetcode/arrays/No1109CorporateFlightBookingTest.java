package com.codefans.interview.algorithm.leetcode.arrays;

import com.codefans.reusablecode.util.ArrayUtils;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2022-04-20 0:22
 */

public class No1109CorporateFlightBookingTest {


    @Test
    public void flightBookingTest() {
        int[][] bookings = new int[][]{
            {1,2,10},
            {2,3,20},
            {2,5,25},
        };
        int n = 5;
        No1109CorporateFlightBooking flightBooking = new No1109CorporateFlightBooking();
        int[] resArr = flightBooking.corpFlightBookings(bookings, n);
        ArrayUtils.print(resArr);

    }

    @Test
    public void flightBookingTest2() {
        int[][] bookings = new int[][]{
                {1,2,10},
                {2,2,15},
        };
        int n = 2;
        No1109CorporateFlightBooking flightBooking = new No1109CorporateFlightBooking();
        int[] resArr = flightBooking.corpFlightBookings(bookings, n);
        ArrayUtils.print(resArr);

    }
}

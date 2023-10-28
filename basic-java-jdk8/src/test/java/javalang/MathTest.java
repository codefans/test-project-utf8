package javalang;

import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2023-10-28 15:39
 */

public class MathTest {

    /**
     * 求平方根
     */
    @Test
    public void sqrtTest() {
        double num = Math.sqrt(16);
        System.out.println(num);
    }

    /**
     * 向下取整
     */
    @Test
    public void floorTest() {
        System.out.println(Math.floor(1.3)); //输出1.0
        System.out.println(Math.floor(1.5)); //输出1.0
        System.out.println(Math.floor(1.9)); //输出1.0
        System.out.println(Math.floor(-1.9)); //输出-2.0
    }

    /**
     * 向上取整
     */
    @Test
    public void ceilTest() {
        System.out.println(Math.ceil(1.3)); //输出2.0
        System.out.println(Math.ceil(1.5)); //输出2.0
        System.out.println(Math.ceil(1.9)); //输出2.0
        System.out.println(Math.ceil(-1.9)); //输出-1.0
    }

    /**
     * 接近取整
     */
    @Test
    public void rintTest() {
        System.out.println(Math.rint(1.3)); //输出1.0
        System.out.println(Math.rint(1.5)); //输出2.0
        System.out.println(Math.rint(1.9)); //输出2.0
        System.out.println(Math.rint(-1.9)); //输出-2.0
    }

    /**
     * 四舍五入
     */
    @Test
    public void roundTest() {
        System.out.println(Math.round(1.3)); //输出1
        System.out.println(Math.round(1.5)); //输出2
        System.out.println(Math.round(1.9)); //输出2
        System.out.println(Math.round(-1.9)); //输出-2
    }


}

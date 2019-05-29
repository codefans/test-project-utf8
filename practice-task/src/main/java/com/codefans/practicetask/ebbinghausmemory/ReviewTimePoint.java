package com.codefans.practicetask.ebbinghausmemory;

/**
 * @author: codefans
 * @date: 2019-05-27 14:59:09
 * 复习时间点
 *    5分钟、30分钟、12小时、1天、2天、4天、7天、15天
 */
public class ReviewTimePoint {

    /**
     * 5分钟
     */
    private String fiveMinute;

    /**
     * 30分钟
     */
    private String thirtyMinute;

    /**
     * 12小时
     */
    private String twelveHour;

    /**
     * 1天
     */
    private String oneDay;

    /**
     * 2天
     */
    private String twoDay;

    /**
     * 4天
     */
    private String fourDay;

    /**
     * 7天
     */
    private String sevenDay;

    /**
     * 15天
     */
    private String fifteenDay;

    public String getFiveMinute() {
        return fiveMinute;
    }

    public void setFiveMinute(String fiveMinute) {
        this.fiveMinute = fiveMinute;
    }

    public String getThirtyMinute() {
        return thirtyMinute;
    }

    public void setThirtyMinute(String thirtyMinute) {
        this.thirtyMinute = thirtyMinute;
    }

    public String getTwelveHour() {
        return twelveHour;
    }

    public void setTwelveHour(String twelveHour) {
        this.twelveHour = twelveHour;
    }

    public String getOneDay() {
        return oneDay;
    }

    public void setOneDay(String oneDay) {
        this.oneDay = oneDay;
    }

    public String getTwoDay() {
        return twoDay;
    }

    public void setTwoDay(String twoDay) {
        this.twoDay = twoDay;
    }

    public String getFourDay() {
        return fourDay;
    }

    public void setFourDay(String fourDay) {
        this.fourDay = fourDay;
    }

    public String getSevenDay() {
        return sevenDay;
    }

    public void setSevenDay(String sevenDay) {
        this.sevenDay = sevenDay;
    }

    public String getFifteenDay() {
        return fifteenDay;
    }

    public void setFifteenDay(String fifteenDay) {
        this.fifteenDay = fifteenDay;
    }

    public String print() {
        return "" + fiveMinute + "\n" +
                "" + thirtyMinute + "\n" +
                "" + twelveHour + "\n" +
                "" + oneDay + "\n" +
                "" + twoDay + "\n" +
                "" + fourDay + "\n" +
                "" + sevenDay + "\n" +
                "" + fifteenDay + "\n";
    }

    @Override
    public String toString() {
        return "ReviewTimePoint{" +
                "fiveMinute='" + fiveMinute + '\'' +
                ", thirtyMinute='" + thirtyMinute + '\'' +
                ", twelveHour='" + twelveHour + '\'' +
                ", oneDay='" + oneDay + '\'' +
                ", twoDay='" + twoDay + '\'' +
                ", fourDay='" + fourDay + '\'' +
                ", sevenDay='" + sevenDay + '\'' +
                ", fifteenDay='" + fifteenDay + '\'' +
                '}';
    }


}

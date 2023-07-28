package cn.edu.guet.insuranceandmove.bean;

import java.math.BigDecimal;

/**
 * @Author huangzhouyu
 * @Data 2023/7/26 19:28
 */
public class InsuranceStatistics {
    private Integer prefecture;
    private Integer count;
    private Integer January;
    private Integer February;
    private Integer March;
    private Integer April;
    private Integer May;
    private Integer June;
    private Integer July;
    private Integer August;
    private Integer September;
    private Integer October;
    private Integer November;
    private Integer December;
    private BigDecimal totalMoney;

    public Integer getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(Integer prefecture) {
        this.prefecture = prefecture;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getJanuary() {
        return January;
    }

    public void setJanuary(Integer january) {
        January = january;
    }

    public Integer getFebruary() {
        return February;
    }

    public void setFebruary(Integer february) {
        February = february;
    }

    public Integer getMarch() {
        return March;
    }

    public void setMarch(Integer march) {
        March = march;
    }

    public Integer getApril() {
        return April;
    }

    public void setApril(Integer april) {
        April = april;
    }

    public Integer getMay() {
        return May;
    }

    public void setMay(Integer may) {
        May = may;
    }

    public Integer getJune() {
        return June;
    }

    public void setJune(Integer june) {
        June = june;
    }

    public Integer getJuly() {
        return July;
    }

    public void setJuly(Integer july) {
        July = july;
    }

    public Integer getAugust() {
        return August;
    }

    public void setAugust(Integer august) {
        August = august;
    }

    public Integer getSeptember() {
        return September;
    }

    public void setSeptember(Integer september) {
        September = september;
    }

    public Integer getOctober() {
        return October;
    }

    public void setOctober(Integer october) {
        October = october;
    }

    public Integer getNovember() {
        return November;
    }

    public void setNovember(Integer november) {
        November = november;
    }

    public Integer getDecember() {
        return December;
    }

    public void setDecember(Integer december) {
        December = december;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "InsuranceStatistics{" +
                "prefecture=" + prefecture +
                ", count=" + count +
                ", January=" + January +
                ", February=" + February +
                ", March=" + March +
                ", April=" + April +
                ", May=" + May +
                ", June=" + June +
                ", July=" + July +
                ", August=" + August +
                ", September=" + September +
                ", October=" + October +
                ", November=" + November +
                ", December=" + December +
                ", totalMoney=" + totalMoney +
                '}';
    }
}

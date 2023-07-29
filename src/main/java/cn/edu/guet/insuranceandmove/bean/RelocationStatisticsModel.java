package cn.edu.guet.insuranceandmove.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author huangzhouyu
 * @Data 2023/7/29 18:14
 */
@Data
@HeadRowHeight(80)
@ContentRowHeight(30)
@ColumnWidth(15)
public class RelocationStatisticsModel {
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(value = "填写时间")
    @ColumnWidth(20)
    private Date submitTime;

    @TableId(type = IdType.AUTO)
    @ExcelProperty(value = "序号")
    @ExcelIgnore
    private Integer id;

    @ExcelProperty(value = "地州")
    private String domainName;

    @ExcelProperty(value = "改赔补数")
    private Integer count;

    @ExcelProperty(value = "1月")
    private Integer january;

    @ExcelProperty(value = "2月")
    private Integer february;

    @ExcelProperty(value = "3月")
    private Integer march;

    @ExcelProperty(value = "4月")
    private Integer april;

    @ExcelProperty(value = "5月")
    private Integer may;

    @ExcelProperty(value = "6月")
    private Integer june;

    @ExcelProperty(value = "7月")
    private Integer july;

    @ExcelProperty(value = "8月")
    private Integer august;

    @ExcelProperty(value = "9月")
    private Integer september;

    @ExcelProperty(value = "10月")
    private Integer october;

    @ExcelProperty(value = "11月")
    private Integer november;

    @ExcelProperty(value = "12月")
    private Integer december;

    @ExcelProperty(value = "合计金额（万元）")
    private BigDecimal totalMoney;

    public String getDomainName(){
        if (this.domainName == null){
            return "全部";
        }
        return domainName;
    }

    public void setDomainName(String domainName){
        if (domainName.equals("0")){
            this.domainName = "全部";
        }else if(domainName.equals("1")){
            this.domainName="乌鲁木齐";
        }else if (domainName.equals("2")){
            this.domainName = "克拉玛依";
        }else if (domainName.equals("3")){
            this.domainName = "吐鲁番";
        }else if (domainName.equals("4")){
            this.domainName = "哈密";
        }else if (domainName.equals("5")){
            this.domainName = "阿克苏";
        }else if (domainName.equals("6")){
            this.domainName = "喀什";
        }else if (domainName.equals("7")){
            this.domainName = "和田";
        }else if (domainName.equals("8")){
            this.domainName = "昌吉";
        }else if (domainName.equals("9")){
            this.domainName = "博尔塔拉";
        }else if (domainName.equals("10")){
            this.domainName = "巴音郭楞";
        }else if (domainName.equals("11")){
            this.domainName = "克孜勒苏柯尔克孜";
        }else if (domainName.equals("12")){
            this.domainName = "伊犁";
        }else if (domainName.equals("13")){
            this.domainName = "塔城";
        }else if (domainName.equals("14")){
            this.domainName = "阿勒泰";
        }else if (domainName.equals("15")){
            this.domainName = "总计";
        }
    }
}

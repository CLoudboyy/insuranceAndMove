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
 * @Data 2023/7/29 11:11
 */

@Data
@HeadRowHeight(80)
@ContentRowHeight(30)
@ColumnWidth(15)
public class RelocationModel {

    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(value = "填写时间")
    @ColumnWidth(20)
    private Date submitTime;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    @ExcelProperty(value = "序号")
    @ExcelIgnore
    private Integer id;

    /**
     * 地州名称
     */
    @ExcelProperty(value = "地州")
    private String prefecture;

    /**
     * 区县名称
     */
    @ExcelProperty(value = "区县")
    private String county;

    /**
     * 市政迁改项目名称
     */
    @ExcelProperty(value = "市政迁改项目名称")
    private String modifyProjectName;

    /**
     * 预计开工时间
     */
    @ExcelProperty(value = "预计开工时间")
    private Date expectedBeginTime;

    /**
     * 预计完工时间
     */
    @ExcelProperty(value = "预计完工时间")
    private Date expectedCompletionTime;

    /**
     * 预计管线维修总费用（不含税）万元
     */
    @ExcelProperty(value = "预计管线维修总费用（不含税）万元")
    private BigDecimal estimatedMaintainTotalCost;

    /**
     * 政府接口人
     */
    @ExcelProperty(value = "政府接口人")
    private String governmentInterfacer;

    /**
     * 政府接口人联系方式
     */
    @ExcelProperty(value = "政府接口人联系方式")
    private String governmentInterfacerCif;

    /**
     * 我方接口人
     */
    @ExcelProperty(value = "我方接口人")
    private String ourInterfacer;

    /**
     * 我方接口人联系方式
     */
    @ExcelProperty(value = "我方接口人联系方式")
    private String ourInterfacerCif;

    /**
     * 签谈进展
     */
    @ExcelProperty(value = "签谈进展")
    private String discussSchedule;

    /**
     * 实际完成时间
     */
    @ExcelProperty(value = "实际完成时间")
    private Date actualCompletionTime;

    /**
     * 通过赔补解决的费用（不含税）万元
     */
    @ExcelProperty(value = "通过赔补解决的费用（不含税）万元")
    private BigDecimal compensationCosts;

    /**
     * 赔补对应的其他费用支出预算名称
     */
    @ExcelProperty(value = "赔补对应的其他费用支出预算名称")
    private String otherBudgetName;

    /**
     * 赔补对应的其他费用支出预算编号：
     */
    @ExcelProperty(value = "赔补对应的其他费用支出预算编号")
    private String otherBudgetId;

    /**
     * 无法通过赔补解决需要通过管线维修解决的费用（不含税）万元
     */
    @ExcelProperty(value = "无法通过赔补解决需要通过管线维修解决的费用")
    private BigDecimal wireMaintainCosts;

    /**
     * 管线维修费预算名称
     */
    @ExcelProperty(value = "管线维修费预算名称")
    private String maintainBudgetName;

    /**
     * 赔付比例
     */
    @ExcelProperty(value = "赔付比例")
    private Double compensationRatio;

    /**
     * 赔补进度
     */
    @ExcelProperty(value = "赔补进度")
    private String compensationSchedule;

    public String getPrefecture() {
        if (this.prefecture == null) {
            return "全部";
        }
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        if (prefecture.equals("0")) {
            this.prefecture = "全部";
        } else if (prefecture.equals("1")) {
            this.prefecture = "乌鲁木齐";
        } else if (prefecture.equals("2")) {
            this.prefecture = "克拉玛依";
        } else if (prefecture.equals("3")) {
            this.prefecture = "吐鲁番";
        } else if (prefecture.equals("4")) {
            this.prefecture = "哈密";
        } else if (prefecture.equals("5")) {
            this.prefecture = "阿克苏";
        } else if (prefecture.equals("6")) {
            this.prefecture = "喀什";
        } else if (prefecture.equals("7")) {
            this.prefecture = "和田";
        } else if (prefecture.equals("8")) {
            this.prefecture = "昌吉";
        } else if (prefecture.equals("9")) {
            this.prefecture = "博尔塔拉";
        } else if (prefecture.equals("10")) {
            this.prefecture = "巴音郭楞";
        } else if (prefecture.equals("11")) {
            this.prefecture = "克孜勒苏柯尔克孜";
        } else if (prefecture.equals("12")) {
            this.prefecture = "伊犁";
        } else if (prefecture.equals("13")) {
            this.prefecture = "塔城";
        } else if (prefecture.equals("14")) {
            this.prefecture = "阿勒泰";
        }
    }

    public String getCounty() {
        if (this.county == null) {
            return "全部";
        }
        return county;
    }

    public void setCounty(String county) {
        if (county.equals("0")) {
            this.county = "全部";
        } else if (county.equals("1")) {
            this.county = "独山子";
        } else if (county.equals("2")) {
            this.county = "水磨沟";
        } else if (county.equals("3")) {
            this.county = "白碱滩";
        } else if (county.equals("4")) {
            this.county = "伊宁";
        } else if (county.equals("5")) {
            this.county = "达坂城";
        } else if (county.equals("6")) {
            this.county = "乌尔禾";
        } else if (county.equals("7")) {
            this.county = "沙依巴克";
        }
    }

    public String getCompensationSchedule() {
        if (this.compensationSchedule == null) {
            return "全部";
        }
        return compensationSchedule;
    }

    public void setCompensationSchedule(String compensationSchedule){
        if (compensationSchedule.equals("0")){
            this.compensationSchedule = "全部";
        }else if(compensationSchedule.equals("1")){
            this.compensationSchedule = "已赔付";
        }else if(compensationSchedule.equals("2")){
            this.compensationSchedule = "待赔付";
        }else if(compensationSchedule.equals("3")){
            this.compensationSchedule = "PICC不予赔付";
        }
    }

}

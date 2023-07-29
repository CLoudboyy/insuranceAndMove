package cn.edu.guet.insuranceandmove.bean;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.*;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @TableName t_insurance
 */
@TableName(value ="t_insurance")
@Data
@HeadRowHeight(80)
@ContentRowHeight(30)
@ColumnWidth(15)
public class InsuranceModel implements Serializable {

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
    private Integer insuranceId;

    /**
     * 地州id
     */
    @ExcelIgnore
    private Long domainId;

    /**
     * 地州名称
     */
    @ExcelProperty(value = "地州")
    private String domainName;

    /**
     * 区县id
     */
    @ExcelIgnore
    private Long subdomainId;

    /**
     * 区县名称
     */
    @ExcelProperty(value = "区县")
    private String subdomainName;


    /**
     * 保险案件发生时间
     */
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(value = "保险报案时间或事件发生时间（报保险的以保险台账为准，没报保险的以发生时间为准）")
    @ColumnWidth(20)
    private Date caseOccurTime;

    /**
     * 网络层级 0=全部，1=国际政企，2=一干，3=二干， 4=干线OP，5=本地网核心，6=本地网汇聚，7=本地网接入，99=其他全部，默认0
     */
    @ExcelProperty(value = "网络层级（填写最高层级）")
    private String networkLayer;

    /**
     * 案件名称
     */
    @ExcelProperty(value = "案件名称（案件内容简要概括）")
    private String caseName;

    /**
     * 保险报案内容或事件详细说明
     */
    @ExcelProperty(value = "保险报案内容或事件详细说明(包含报保险的和没报保险的所有案件，相当于含保险的全集，总规模)")
    private String caseDetailedStatement;

    /**
     * 案件进展情况 0=全部，1=已到账，2=资料完成待赔付，3=资料收集发送中，4=资料收集中，5=第三方赔付协商中，默认0
     */
    @ExcelProperty(value = "案件进展情况")
    private String caseProgress;

    /**
     * 保险报案原因分类 0=全部，1=被盗案件，2=自然灾害，3=火灾，4=第三者责任市政施工挖断，5=第三者责任市政施工剪断，6=第三者责任大车挂断，7=第三者责任其他  默认0
     */
    @ExcelProperty(value = "保险报案原因分类")
    @ColumnWidth(40)
    private String caseClassificationReason;

    /**
     * 现场报案人
     */
    @ExcelProperty(value = "现场报案人")
    private String spottedInformant;

    /**
     * 自维人员负责人
     */
    @ExcelProperty(value = "自维人员负责人")
    private String selfMaintainResponsibility;

    /**
     * 预估损失金额（元）
     */
    @ExcelProperty(value = "预估损失金额（元）")
    private BigDecimal previewLossAmount;

    /**
     *  赔付类型 0=全部，
     *  1=保险公司赔付，
     *  2=第三方或个人赔付
     */
    @ExcelProperty(value = "赔付类型")
    private String paidType;

    /**
     * 赔付已到账金额
     */
    @ExcelProperty(value = "赔付已到账金额（元）（三方个人赔付分公司填报，保险类由保险公司填报）")
    private BigDecimal payAccountAmount;

    /**
     * 赔付到账具体时间
     */
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(value = "赔付到账具体时间（三方个人赔付分公司填报，保险类由保险公司填报）")
    @ColumnWidth(20)
    private Date payAccountTime;

    /**
     * 保险公司台账登记名称
     */
    @ExcelProperty(value = "保险公司台账登记名称")
    private String insuranceBillRegisterName;

    /**
     * 保险公司报案号
     */
    @ExcelProperty(value = "保险公司报案号")
    private String insuranceReportNo;

    /**
     * 保险公司估损赔付金额
     */
    @ExcelProperty(value = "保险公司估损赔付金额（元）")
    private BigDecimal insuranceEstimatePayAmount;

    /**
     *  赔付进度  0=全部
     ，1=已赔付
     ，2=待赔付
     ，3=PICC不予赔付
     */
    @ExcelProperty(value = "赔付进度")
    private String payProgress;

    /**
     * 赔付情况备注
     */
    @ExcelProperty(value = "备注")
    private String payStatusRemark;

    /**
     * 案件完结确认
     */
    @ExcelProperty(value = "案件完结确认")
    private String completionConfirmed;

    /**
     * 保险备注
     */
    @ExcelProperty(value = "备注")
    private String insuranceRemark;


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
        }
    }

    public String getSubdomainName(){
        if (this.domainName == null){
            return "全部";
        }
        return subdomainName;
    }

    public void setSubdomainName(String subdomainName){
        if (subdomainName.equals("0")){
            this.subdomainName = "全部";
        }else if (subdomainName.equals("1")){
            this.subdomainName = "独山子";
        }else if (subdomainName.equals("2")){
            this.subdomainName = "水磨沟";
        }else if (subdomainName.equals("3")){
            this.subdomainName = "白碱滩";
        }else if (subdomainName.equals("4")){
            this.subdomainName = "伊宁";
        }else if (subdomainName.equals("5")){
            this.subdomainName = "达坂城";
        }else if (subdomainName.equals("6")){
            this.subdomainName = "乌尔禾";
        }else if (subdomainName.equals("7")){
            this.subdomainName = "沙依巴克";
        }
    }

    public String getNetworkLayer() {
        if(this.networkLayer == null){
            return "全部";
        }
        return networkLayer;
    }

    public void setNetworkLayer(Integer networkLayerNum) {
        switch (networkLayerNum){
            case 0: {
                this.networkLayer = "全部";
                break;
            }
            case 1: {
                this.networkLayer = "国际政企";
                break;
            }
            case 2: {
                this.networkLayer = "一干";
                break;
            }
            case 3: {
                this.networkLayer = "二干";
                break;
            }
            case 4: {
                this.networkLayer = "干线OP";
                break;
            }
            case 5: {
                this.networkLayer = "本地网核心";
                break;
            }
            case 6: {
                this.networkLayer = "本地网汇聚";
                break;
            }
            case 7: {
                this.networkLayer = "本地网接入";
                break;
            }
            case 99: {
                this.networkLayer = "其他全部";
                break;
            }
        }
    }

    public String getCaseProgress() {
        if(this.caseProgress == null){
            return "全部";
        }
        return caseProgress;
    }

    public void setCaseProgress(Integer caseProgressNum) {
        switch (caseProgressNum){
            case 0: {
                this.caseProgress = "全部";
                break;
            }
            case 1: {
                this.caseProgress = "已到账";
                break;
            }
            case 2: {
                this.caseProgress = "资料完成待赔付";
                break;
            }
            case 3: {
                this.caseProgress = "资料收集发送中";
                break;
            }
            case 4: {
                this.caseProgress = "第三方赔付协商中";
                break;
            }
        }
    }

    public String getCaseClassificationReason() {
        if(this.caseClassificationReason == null){
            return "全部";
        }
        return caseClassificationReason;
    }

    public void setCaseClassificationReason(Integer caseClassificationReasonNum) {
        switch (caseClassificationReasonNum){
            case 0: {
                this.caseClassificationReason = "全部";
                break;
            }
            case 1: {
                this.caseClassificationReason = "被盗案件";
                break;
            }
            case 2: {
                this.caseClassificationReason = "自然灾害";
                break;
            }
            case 3: {
                this.caseClassificationReason = "火灾";
                break;
            }
            case 4: {
                this.caseClassificationReason = "第三者责任市政施工挖断";
                break;
            }
            case 5: {
                this.caseClassificationReason = "第三者责任市政施工剪断";
                break;
            }
            case 6: {
                this.caseClassificationReason = "第三者责任市政打车挂断";
                break;
            }
            case 7: {
                this.caseClassificationReason = "第三者责任其他";
                break;
            }
        }
    }

    public String getPaidType() {
        if(this.paidType == null){
            return "全部";
        }
        return paidType;
    }

    public void setPaidType(Integer paidTypeNum) {
        switch (paidTypeNum) {
            case 0: {
                this.paidType = "全部";
                break;
            }
            case 1: {
                this.paidType = "保险公司赔付";
                break;
            }
            case 2: {
                this.paidType = "第三方或个人赔付";
                break;
            }
        }
    }

    public String getPayProgress() {
        if(this.payProgress == null){
            return "全部";
        }
        return payProgress;
    }

    public void setPayProgress(Integer payProgressNum) {
        switch (payProgressNum){
            case 0: {
                this.payProgress = "全部";
                break;
            }
            case 1: {
                this.payProgress = "已赔付";
                break;
            }
            case 2: {
                this.payProgress = "待赔付";
                break;
            }
            case 3: {
                this.payProgress = "PICC不予赔付";
                break;
            }
        }
    }

}
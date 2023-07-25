package cn.edu.guet.insuranceandmove.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 保险清单表;保险清单表
 * @TableName t_insurance_list
 */
@TableName(value ="t_insurance_list")
public class InsuranceList implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地州
     */
    @TableField(value = "prefecture")
    private Integer prefecture;

    /**
     * 区县
     */
    @TableField(value = "county")
    private Integer county;

    /**
     * 案件名称
     */
    @TableField(value = "case_name")
    private String caseName;

    /**
     * 保险案件发生时间
     */
    @TableField(value = "case_occurrence_time")
    private Date caseOccurrenceTime;

    /**
     * 网络层级
     */
    @TableField(value = "network_hierarchy")
    private Integer networkHierarchy;

    /**
     * 案件进展情况
     */
    @TableField(value = "case_progress_situation")
    private Integer caseProgressSituation;

    /**
     * 保险报案原因分类
     */
    @TableField(value = "reporting_reasons_type")
    private Integer reportingReasonsType;

    /**
     * 现场报案人
     */
    @TableField(value = "case_reporter")
    private String caseReporter;

    /**
     * 自维人员负责人
     */
    @TableField(value = "maintenance_manager")
    private String maintenanceManager;

    /**
     * 预估损失金额（元）
     */
    @TableField(value = "estimated_loss_amount")
    private BigDecimal estimatedLossAmount;

    /**
     * 赔付类型
     */
    @TableField(value = "compensation_type")
    private Integer compensationType;

    /**
     * 案件完结确认
     */
    @TableField(value = "case_completion_confirm")
    private Integer caseCompletionConfirm;

    /**
     * 保险报案内容或事件详细说明
     */
    @TableField(value = "insurance_content_description")
    private String insuranceContentDescription;

    /**
     * 赔付已到账金额（元）
     */
    @TableField(value = "compensation_received_amount")
    private BigDecimal compensationReceivedAmount;

    /**
     * 赔付到账具体时间
     */
    @TableField(value = "compensation_received_time")
    private Date compensationReceivedTime;

    /**
     * 赔付情况备注
     */
    @TableField(value = "compensation_situation_remark")
    private String compensationSituationRemark;

    /**
     * 保险公司台账登记名称
     */
    @TableField(value = "IC_ledger_registration_name")
    private String icLedgerRegistrationName;

    /**
     * 保险公司报案号
     */
    @TableField(value = "IC_insurance_report_no")
    private String icInsuranceReportNo;

    /**
     * 保险公司估损赔付金额（元）
     */
    @TableField(value = "IC_estimated_reparation_amount")
    private BigDecimal icEstimatedReparationAmount;

    /**
     * 赔付进度
     */
    @TableField(value = "compensation_progress")
    private Integer compensationProgress;

    /**
     * 保险备注
     */
    @TableField(value = "insurance_remarks")
    private String insuranceRemarks;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 地州
     */
    public Integer getPrefecture() {
        return prefecture;
    }

    /**
     * 地州
     */
    public void setPrefecture(Integer prefecture) {
        this.prefecture = prefecture;
    }

    /**
     * 区县
     */
    public Integer getCounty() {
        return county;
    }

    /**
     * 区县
     */
    public void setCounty(Integer county) {
        this.county = county;
    }

    /**
     * 案件名称
     */
    public String getCaseName() {
        return caseName;
    }

    /**
     * 案件名称
     */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    /**
     * 保险案件发生时间
     */
    public Date getCaseOccurrenceTime() {
        return caseOccurrenceTime;
    }

    /**
     * 保险案件发生时间
     */
    public void setCaseOccurrenceTime(Date caseOccurrenceTime) {
        this.caseOccurrenceTime = caseOccurrenceTime;
    }

    /**
     * 网络层级
     */
    public Integer getNetworkHierarchy() {
        return networkHierarchy;
    }

    /**
     * 网络层级
     */
    public void setNetworkHierarchy(Integer networkHierarchy) {
        this.networkHierarchy = networkHierarchy;
    }

    /**
     * 案件进展情况
     */
    public Integer getCaseProgressSituation() {
        return caseProgressSituation;
    }

    /**
     * 案件进展情况
     */
    public void setCaseProgressSituation(Integer caseProgressSituation) {
        this.caseProgressSituation = caseProgressSituation;
    }

    /**
     * 保险报案原因分类
     */
    public Integer getReportingReasonsType() {
        return reportingReasonsType;
    }

    /**
     * 保险报案原因分类
     */
    public void setReportingReasonsType(Integer reportingReasonsType) {
        this.reportingReasonsType = reportingReasonsType;
    }

    /**
     * 现场报案人
     */
    public String getCaseReporter() {
        return caseReporter;
    }

    /**
     * 现场报案人
     */
    public void setCaseReporter(String caseReporter) {
        this.caseReporter = caseReporter;
    }

    /**
     * 自维人员负责人
     */
    public String getMaintenanceManager() {
        return maintenanceManager;
    }

    /**
     * 自维人员负责人
     */
    public void setMaintenanceManager(String maintenanceManager) {
        this.maintenanceManager = maintenanceManager;
    }

    /**
     * 预估损失金额（元）
     */
    public BigDecimal getEstimatedLossAmount() {
        return estimatedLossAmount;
    }

    /**
     * 预估损失金额（元）
     */
    public void setEstimatedLossAmount(BigDecimal estimatedLossAmount) {
        this.estimatedLossAmount = estimatedLossAmount;
    }

    /**
     * 赔付类型
     */
    public Integer getCompensationType() {
        return compensationType;
    }

    /**
     * 赔付类型
     */
    public void setCompensationType(Integer compensationType) {
        this.compensationType = compensationType;
    }

    /**
     * 案件完结确认
     */
    public Integer getCaseCompletionConfirm() {
        return caseCompletionConfirm;
    }

    /**
     * 案件完结确认
     */
    public void setCaseCompletionConfirm(Integer caseCompletionConfirm) {
        this.caseCompletionConfirm = caseCompletionConfirm;
    }

    /**
     * 保险报案内容或事件详细说明
     */
    public String getInsuranceContentDescription() {
        return insuranceContentDescription;
    }

    /**
     * 保险报案内容或事件详细说明
     */
    public void setInsuranceContentDescription(String insuranceContentDescription) {
        this.insuranceContentDescription = insuranceContentDescription;
    }

    /**
     * 赔付已到账金额（元）
     */
    public BigDecimal getCompensationReceivedAmount() {
        return compensationReceivedAmount;
    }

    /**
     * 赔付已到账金额（元）
     */
    public void setCompensationReceivedAmount(BigDecimal compensationReceivedAmount) {
        this.compensationReceivedAmount = compensationReceivedAmount;
    }

    /**
     * 赔付到账具体时间
     */
    public Date getCompensationReceivedTime() {
        return compensationReceivedTime;
    }

    /**
     * 赔付到账具体时间
     */
    public void setCompensationReceivedTime(Date compensationReceivedTime) {
        this.compensationReceivedTime = compensationReceivedTime;
    }

    /**
     * 赔付情况备注
     */
    public String getCompensationSituationRemark() {
        return compensationSituationRemark;
    }

    /**
     * 赔付情况备注
     */
    public void setCompensationSituationRemark(String compensationSituationRemark) {
        this.compensationSituationRemark = compensationSituationRemark;
    }

    /**
     * 保险公司台账登记名称
     */
    public String getIcLedgerRegistrationName() {
        return icLedgerRegistrationName;
    }

    /**
     * 保险公司台账登记名称
     */
    public void setIcLedgerRegistrationName(String icLedgerRegistrationName) {
        this.icLedgerRegistrationName = icLedgerRegistrationName;
    }

    /**
     * 保险公司报案号
     */
    public String getIcInsuranceReportNo() {
        return icInsuranceReportNo;
    }

    /**
     * 保险公司报案号
     */
    public void setIcInsuranceReportNo(String icInsuranceReportNo) {
        this.icInsuranceReportNo = icInsuranceReportNo;
    }

    /**
     * 保险公司估损赔付金额（元）
     */
    public BigDecimal getIcEstimatedReparationAmount() {
        return icEstimatedReparationAmount;
    }

    /**
     * 保险公司估损赔付金额（元）
     */
    public void setIcEstimatedReparationAmount(BigDecimal icEstimatedReparationAmount) {
        this.icEstimatedReparationAmount = icEstimatedReparationAmount;
    }

    /**
     * 赔付进度
     */
    public Integer getCompensationProgress() {
        return compensationProgress;
    }

    /**
     * 赔付进度
     */
    public void setCompensationProgress(Integer compensationProgress) {
        this.compensationProgress = compensationProgress;
    }

    /**
     * 保险备注
     */
    public String getInsuranceRemarks() {
        return insuranceRemarks;
    }

    /**
     * 保险备注
     */
    public void setInsuranceRemarks(String insuranceRemarks) {
        this.insuranceRemarks = insuranceRemarks;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "InsuranceList{" +
                "id=" + id +
                ", prefecture=" + prefecture +
                ", county=" + county +
                ", caseName='" + caseName + '\'' +
                ", caseOccurrenceTime=" + caseOccurrenceTime +
                ", networkHierarchy=" + networkHierarchy +
                ", caseProgressSituation=" + caseProgressSituation +
                ", reportingReasonsType=" + reportingReasonsType +
                ", caseReporter='" + caseReporter + '\'' +
                ", maintenanceManager='" + maintenanceManager + '\'' +
                ", estimatedLossAmount=" + estimatedLossAmount +
                ", compensationType=" + compensationType +
                ", caseCompletionConfirm=" + caseCompletionConfirm +
                ", insuranceContentDescription='" + insuranceContentDescription + '\'' +
                ", compensationReceivedAmount=" + compensationReceivedAmount +
                ", compensationReceivedTime=" + compensationReceivedTime +
                ", compensationSituationRemark='" + compensationSituationRemark + '\'' +
                ", icLedgerRegistrationName='" + icLedgerRegistrationName + '\'' +
                ", icInsuranceReportNo='" + icInsuranceReportNo + '\'' +
                ", icEstimatedReparationAmount=" + icEstimatedReparationAmount +
                ", compensationProgress=" + compensationProgress +
                ", insuranceRemarks='" + insuranceRemarks + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
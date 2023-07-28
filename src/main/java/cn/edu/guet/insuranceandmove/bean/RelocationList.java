package cn.edu.guet.insuranceandmove.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * modify_basic_info
 * @TableName modify_basic_info
 */
@TableName(value ="modify_basic_info")
public class RelocationList implements Serializable {
    /**
     * 主键id
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
     * 市政迁改项目名称
     */
    @TableField(value = "modify_project_name")
    private String modifyProjectName;

    /**
     * 预计管线维修总费用（不含税）万元
     */
    @TableField(value = "estimated_maintain_total_cost")
    private BigDecimal estimatedMaintainTotalCost;

    /**
     * 预计开工时间
     */
    @TableField(value = "expected_begin_time")
    private Date expectedBeginTime;

    /**
     * 预计完工时间
     */
    @TableField(value = "expected_completion_time")
    private Date expectedCompletionTime;

    /**
     * 政府接口人
     */
    @TableField(value = "government_interfacer")
    private String governmentInterfacer;

    /**
     * 政府接口人联系方式
     */
    @TableField(value = "government_interfacer_cif")
    private String governmentInterfacerCif;

    /**
     * 我方接口人
     */
    @TableField(value = "our_interfacer")
    private String ourInterfacer;

    /**
     * 我方接口人联系方式
     */
    @TableField(value = "our_interfacer_cif")
    private String ourInterfacerCif;

    /**
     * 签谈进展
     */
    @TableField(value = "discuss_schedule")
    private String discussSchedule;

    /**
     * 实际完成时间
     */
    @TableField(value = "actual_completion_time")
    private Date actualCompletionTime;

    /**
     * 通过赔补解决的费用（不含税）万元
     */
    @TableField(value = "compensation_costs")
    private BigDecimal compensationCosts;

    /**
     * 无法通过赔补解决需要通过管线维修解决的费用（不含税）万元
     */
    @TableField(value = "wire_maintain_costs")
    private BigDecimal wireMaintainCosts;

    /**
     * 赔补对应的其他费用支出预算名称
     */
    @TableField(value = "other_budget_name")
    private String otherBudgetName;

    /**
     * 赔补对应的其他费用支出预算编号：
     */
    @TableField(value = "other_budget_id")
    private String otherBudgetId;

    /**
     * 管线维修费预算名称
     */
    @TableField(value = "maintain_budget_name")
    private String maintainBudgetName;

    /**
     * 赔付比例
     */
    @TableField(value = "compensation_ratio")
    private Double compensationRatio;

    /**
     * 赔补进度
     */
    @TableField(value = "compensation_schedule")
    private Integer compensationSchedule;

    /**
     * 项目简介
     */
    @TableField(value = "item_describe")
    private String itemDescribe;

    /**
     * 无法通过赔补解决的原因分析
     */
    @TableField(value = "unresolved_result_analysis")
    private String unresolvedResultAnalysis;

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
     * 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键id
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
     * 市政迁改项目名称
     */
    public String getModifyProjectName() {
        return modifyProjectName;
    }

    /**
     * 市政迁改项目名称
     */
    public void setModifyProjectName(String modifyProjectName) {
        this.modifyProjectName = modifyProjectName;
    }

    /**
     * 预计管线维修总费用（不含税）万元
     */
    public BigDecimal getEstimatedMaintainTotalCost() {
        return estimatedMaintainTotalCost;
    }

    /**
     * 预计管线维修总费用（不含税）万元
     */
    public void setEstimatedMaintainTotalCost(BigDecimal estimatedMaintainTotalCost) {
        this.estimatedMaintainTotalCost = estimatedMaintainTotalCost;
    }

    /**
     * 预计开工时间
     */
    public Date getExpectedBeginTime() {
        return expectedBeginTime;
    }

    /**
     * 预计开工时间
     */
    public void setExpectedBeginTime(Date expectedBeginTime) {
        this.expectedBeginTime = expectedBeginTime;
    }

    /**
     * 预计完工时间
     */
    public Date getExpectedCompletionTime() {
        return expectedCompletionTime;
    }

    /**
     * 预计完工时间
     */
    public void setExpectedCompletionTime(Date expectedCompletionTime) {
        this.expectedCompletionTime = expectedCompletionTime;
    }

    /**
     * 政府接口人
     */
    public String getGovernmentInterfacer() {
        return governmentInterfacer;
    }

    /**
     * 政府接口人
     */
    public void setGovernmentInterfacer(String governmentInterfacer) {
        this.governmentInterfacer = governmentInterfacer;
    }

    /**
     * 政府接口人联系方式
     */
    public String getGovernmentInterfacerCif() {
        return governmentInterfacerCif;
    }

    /**
     * 政府接口人联系方式
     */
    public void setGovernmentInterfacerCif(String governmentInterfacerCif) {
        this.governmentInterfacerCif = governmentInterfacerCif;
    }

    /**
     * 我方接口人
     */
    public String getOurInterfacer() {
        return ourInterfacer;
    }

    /**
     * 我方接口人
     */
    public void setOurInterfacer(String ourInterfacer) {
        this.ourInterfacer = ourInterfacer;
    }

    /**
     * 我方接口人联系方式
     */
    public String getOurInterfacerCif() {
        return ourInterfacerCif;
    }

    /**
     * 我方接口人联系方式
     */
    public void setOurInterfacerCif(String ourInterfacerCif) {
        this.ourInterfacerCif = ourInterfacerCif;
    }

    /**
     * 签谈进展
     */
    public String getDiscussSchedule() {
        return discussSchedule;
    }

    /**
     * 签谈进展
     */
    public void setDiscussSchedule(String discussSchedule) {
        this.discussSchedule = discussSchedule;
    }

    /**
     * 实际完成时间
     */
    public Date getActualCompletionTime() {
        return actualCompletionTime;
    }

    /**
     * 实际完成时间
     */
    public void setActualCompletionTime(Date actualCompletionTime) {
        this.actualCompletionTime = actualCompletionTime;
    }

    /**
     * 通过赔补解决的费用（不含税）万元
     */
    public BigDecimal getCompensationCosts() {
        return compensationCosts;
    }

    /**
     * 通过赔补解决的费用（不含税）万元
     */
    public void setCompensationCosts(BigDecimal compensationCosts) {
        this.compensationCosts = compensationCosts;
    }

    /**
     * 无法通过赔补解决需要通过管线维修解决的费用（不含税）万元
     */
    public BigDecimal getWireMaintainCosts() {
        return wireMaintainCosts;
    }

    /**
     * 无法通过赔补解决需要通过管线维修解决的费用（不含税）万元
     */
    public void setWireMaintainCosts(BigDecimal wireMaintainCosts) {
        this.wireMaintainCosts = wireMaintainCosts;
    }

    /**
     * 赔补对应的其他费用支出预算名称
     */
    public String getOtherBudgetName() {
        return otherBudgetName;
    }

    /**
     * 赔补对应的其他费用支出预算名称
     */
    public void setOtherBudgetName(String otherBudgetName) {
        this.otherBudgetName = otherBudgetName;
    }

    /**
     * 赔补对应的其他费用支出预算编号：
     */
    public String getOtherBudgetId() {
        return otherBudgetId;
    }

    /**
     * 赔补对应的其他费用支出预算编号：
     */
    public void setOtherBudgetId(String otherBudgetId) {
        this.otherBudgetId = otherBudgetId;
    }

    /**
     * 管线维修费预算名称
     */
    public String getMaintainBudgetName() {
        return maintainBudgetName;
    }

    /**
     * 管线维修费预算名称
     */
    public void setMaintainBudgetName(String maintainBudgetName) {
        this.maintainBudgetName = maintainBudgetName;
    }

    /**
     * 赔付比例
     */
    public Double getCompensationRatio() {
        return compensationRatio;
    }

    /**
     * 赔付比例
     */
    public void setCompensationRatio(Double compensationRatio) {
        this.compensationRatio = compensationRatio;
    }

    /**
     * 赔补进度
     */
    public Integer getCompensationSchedule() {
        return compensationSchedule;
    }

    /**
     * 赔补进度
     */
    public void setCompensationSchedule(Integer compensationSchedule) {
        this.compensationSchedule = compensationSchedule;
    }

    /**
     * 项目简介
     */
    public String getItemDescribe() {
        return itemDescribe;
    }

    /**
     * 项目简介
     */
    public void setItemDescribe(String itemDescribe) {
        this.itemDescribe = itemDescribe;
    }

    /**
     * 无法通过赔补解决的原因分析
     */
    public String getUnresolvedResultAnalysis() {
        return unresolvedResultAnalysis;
    }

    /**
     * 无法通过赔补解决的原因分析
     */
    public void setUnresolvedResultAnalysis(String unresolvedResultAnalysis) {
        this.unresolvedResultAnalysis = unresolvedResultAnalysis;
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
}
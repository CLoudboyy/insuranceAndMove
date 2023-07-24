package cn.edu.guet.insuranceandmove.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author huangzhouyu
 * @Data 2023/7/23 15:52
 */
public class InsuranceDTO {
    private Integer prefecture;
    private Integer county;
    private String caseName;
    private List<Timestamp> caseOccurrenceTime;
    private Integer networkHierarchy;
    private Integer caseProgressSituation;
    private Integer reportingReasonsType;
    private Integer compensationType;
    private Integer compensationProgress;
    private Integer size;
    private Integer current;

    public Integer getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(Integer prefecture) {
        this.prefecture = prefecture;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public List<Timestamp> getCaseOccurrenceTime() {
        return caseOccurrenceTime;
    }

    public void setCaseOccurrenceTime(List<Timestamp> caseOccurrenceTime) {
        this.caseOccurrenceTime = caseOccurrenceTime;
    }

    public Integer getNetworkHierarchy() {
        return networkHierarchy;
    }

    public void setNetworkHierarchy(Integer networkHierarchy) {
        this.networkHierarchy = networkHierarchy;
    }

    public Integer getCaseProgressSituation() {
        return caseProgressSituation;
    }

    public void setCaseProgressSituation(Integer caseProgressSituation) {
        this.caseProgressSituation = caseProgressSituation;
    }

    public Integer getReportingReasonsType() {
        return reportingReasonsType;
    }

    public void setReportingReasonsType(Integer reportingReasonsType) {
        this.reportingReasonsType = reportingReasonsType;
    }

    public Integer getCompensationType() {
        return compensationType;
    }

    public void setCompensationType(Integer compensationType) {
        this.compensationType = compensationType;
    }

    public Integer getCompensationProgress() {
        return compensationProgress;
    }

    public void setCompensationProgress(Integer compensationProgress) {
        this.compensationProgress = compensationProgress;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }
}

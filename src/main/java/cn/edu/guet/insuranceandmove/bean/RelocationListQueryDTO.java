package cn.edu.guet.insuranceandmove.bean;

import java.sql.Timestamp;
import java.util.List;

public class RelocationListQueryDTO extends Page {
    private Integer prefecture;
    private Integer county;
    private String modifyProjectName;
    private List<Timestamp> actualCompletionTime;
    private String discussSchedule;
    private Integer compensationSchedule;

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

    public String getModifyProjectName() {
        return modifyProjectName;
    }

    public void setModifyProjectName(String modifyProjectName) {
        this.modifyProjectName = modifyProjectName;
    }

    public List<Timestamp> getActualCompletionTime() {
        return actualCompletionTime;
    }

    public void setActualCompletionTime(List<Timestamp> actualCompletionTime) {
        this.actualCompletionTime = actualCompletionTime;
    }

    public String getDiscussSchedule() {
        return discussSchedule;
    }

    public void setDiscussSchedule(String discussSchedule) {
        this.discussSchedule = discussSchedule;
    }

    public Integer getCompensationSchedule() {
        return compensationSchedule;
    }

    public void setCompensationSchedule(Integer compensationSchedule) {
        this.compensationSchedule = compensationSchedule;
    }

    @Override
    public String toString() {
        return "RelocationListQueryDTO{" +
                "prefecture=" + prefecture +
                ", county=" + county +
                ", modifyProjectName='" + modifyProjectName + '\'' +
                ", actualCompletionTime=" + actualCompletionTime +
                ", discussSchedule='" + discussSchedule + '\'' +
                ", compensationSchedule=" + compensationSchedule +
                '}';
    }
}

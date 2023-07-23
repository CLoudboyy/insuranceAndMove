package cn.edu.guet.insuranceandmove.bean;


/**
 * 查询CAD分析结果封装
 * @Author liwei
 * @Date 2023/5/4 17:00
 * @Version 1.0
 */
public class InsuranceResult {

    private String code;
    private String message;
    private InsuranceData data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InsuranceData getData() {
        return data;
    }

    public void setData(InsuranceData data) {
        this.data = data;
    }
}

package cn.edu.guet.insuranceandmove.handler;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.util.Map;

/**
 * @author bep
 * @create-time 2023/7/24 10:33
 */
public class InsuranceSheetWriteHandler implements SheetWriteHandler {

    // 设置下拉属性,泛型设置为<第n列,选项集合>
    private Map<Integer,String[]> mapDropDown;

    public InsuranceSheetWriteHandler(Map<Integer, String[]> mapDropDown) {
        this.mapDropDown = mapDropDown;
    }

    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

        // 获取工作簿
        Sheet sheet = writeSheetHolder.getSheet();

        // 开始设置下拉框
        DataValidationHelper helper = sheet.getDataValidationHelper();

        // 设置下拉框
        for (Map.Entry<Integer, String[]> entry : mapDropDown.entrySet()) {

            // 参数分别是: 起始行,终止行,起始列,终止列 (起始行为1表示表头不设置,若设置为0)
            // !重要,65535是excel最大行数,如果数据量超过这个数会报错
            CellRangeAddressList addressList = new CellRangeAddressList(1,65535,entry.getKey(),entry.getKey());

            DataValidationConstraint constraint = helper.createExplicitListConstraint(entry.getValue());

            // 参数分别是: 获得列对应下拉数据,获得下拉框位置
            DataValidation dataValidation = helper.createValidation(constraint,addressList);

            // 阻止输入非下拉选项的值
            dataValidation.setErrorStyle(DataValidation.ErrorStyle.STOP);
            dataValidation.setShowErrorBox(true);
            dataValidation.setSuppressDropDownArrow(true);
            dataValidation.createErrorBox("提示","输入值与单元格定义格式不符");
            dataValidation.createPromptBox("填写说明","填写内容只能为下拉数据集中的类型");

            // 将下拉框装填进模板
            sheet.addValidationData(dataValidation);
        }
    }
}

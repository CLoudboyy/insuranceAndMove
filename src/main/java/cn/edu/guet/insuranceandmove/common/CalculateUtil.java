package cn.edu.guet.insuranceandmove.common;

import cn.edu.guet.insuranceandmove.bean.InsuranceList;
import cn.edu.guet.insuranceandmove.bean.InsuranceStatistics;
import cn.edu.guet.insuranceandmove.bean.RelocationList;
import cn.edu.guet.insuranceandmove.bean.RelocationStatistics;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author huangzhouyu
 * @Data 2023/7/29 16:44
 */
public class CalculateUtil {
    public static InsuranceStatistics calculateInsuranceCounts(List<InsuranceStatistics> insuranceStatisticsList) {
        int allCount = 0;
        int countJanuary = 0;
        int countFebruary = 0;
        int countMarch = 0;
        int countApril = 0;
        int countMay = 0;
        int countJune = 0;
        int countJuly = 0;
        int countAugust = 0;
        int countSeptember = 0;
        int countOctober = 0;
        int countNovember = 0;
        int countDecember = 0;

        for (int i = 0; i < insuranceStatisticsList.size()-1; i++) {
            allCount += insuranceStatisticsList.get(i).getCount();
            countJanuary += insuranceStatisticsList.get(i).getJanuary();
            countFebruary += insuranceStatisticsList.get(i).getFebruary();
            countMarch += insuranceStatisticsList.get(i).getMarch();
            countApril += insuranceStatisticsList.get(i).getApril();
            countMay += insuranceStatisticsList.get(i).getMay();
            countJune += insuranceStatisticsList.get(i).getJune();
            countJuly += insuranceStatisticsList.get(i).getJuly();
            countAugust += insuranceStatisticsList.get(i).getAugust();
            countSeptember += insuranceStatisticsList.get(i).getSeptember();
            countOctober += insuranceStatisticsList.get(i).getOctober();
            countNovember += insuranceStatisticsList.get(i).getNovember();
            countDecember += insuranceStatisticsList.get(i).getDecember();
        }

        InsuranceStatistics totalStatistics = new InsuranceStatistics();
        totalStatistics.setPrefecture(15);
        totalStatistics.setCount(allCount);
        totalStatistics.setJanuary(countJanuary);
        totalStatistics.setFebruary(countFebruary);
        totalStatistics.setMarch(countMarch);
        totalStatistics.setApril(countApril);
        totalStatistics.setMay(countMay);
        totalStatistics.setJune(countJune);
        totalStatistics.setJuly(countJuly);
        totalStatistics.setAugust(countAugust);
        totalStatistics.setSeptember(countSeptember);
        totalStatistics.setOctober(countOctober);
        totalStatistics.setNovember(countNovember);
        totalStatistics.setDecember(countDecember);
        totalStatistics.setTotalMoney(BigDecimal.ZERO);

        return totalStatistics;
    }

    public static RelocationStatistics calculateRelocationCounts(List<RelocationStatistics> relocationStatisticsList) {
        int allCount = 0;
        int countJanuary = 0;
        int countFebruary = 0;
        int countMarch = 0;
        int countApril = 0;
        int countMay = 0;
        int countJune = 0;
        int countJuly = 0;
        int countAugust = 0;
        int countSeptember = 0;
        int countOctober = 0;
        int countNovember = 0;
        int countDecember = 0;

        for (int i = 0; i < relocationStatisticsList.size()-1; i++) {
            allCount += relocationStatisticsList.get(i).getCount();
            countJanuary += relocationStatisticsList.get(i).getJanuary();
            countFebruary += relocationStatisticsList.get(i).getFebruary();
            countMarch += relocationStatisticsList.get(i).getMarch();
            countApril += relocationStatisticsList.get(i).getApril();
            countMay += relocationStatisticsList.get(i).getMay();
            countJune += relocationStatisticsList.get(i).getJune();
            countJuly += relocationStatisticsList.get(i).getJuly();
            countAugust += relocationStatisticsList.get(i).getAugust();
            countSeptember += relocationStatisticsList.get(i).getSeptember();
            countOctober += relocationStatisticsList.get(i).getOctober();
            countNovember += relocationStatisticsList.get(i).getNovember();
            countDecember += relocationStatisticsList.get(i).getDecember();
        }

        RelocationStatistics totalStatistics = new RelocationStatistics();
        totalStatistics.setPrefecture(15);
        totalStatistics.setCount(allCount);
        totalStatistics.setJanuary(countJanuary);
        totalStatistics.setFebruary(countFebruary);
        totalStatistics.setMarch(countMarch);
        totalStatistics.setApril(countApril);
        totalStatistics.setMay(countMay);
        totalStatistics.setJune(countJune);
        totalStatistics.setJuly(countJuly);
        totalStatistics.setAugust(countAugust);
        totalStatistics.setSeptember(countSeptember);
        totalStatistics.setOctober(countOctober);
        totalStatistics.setNovember(countNovember);
        totalStatistics.setDecember(countDecember);
        totalStatistics.setTotalMoney(BigDecimal.ZERO);

        return totalStatistics;
    }

    public static void updateInsuranceStatisticsList(List<InsuranceStatistics> insuranceStatisticsList, InsuranceList insuranceList) {
        Integer prefecture = insuranceList.getPrefecture();
        Date occurrenceTime = insuranceList.getCaseOccurrenceTime();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(occurrenceTime);

        int month = calendar.get(Calendar.MONTH) + 1;

        InsuranceStatistics stats = insuranceStatisticsList.get(prefecture - 1);
        switch (month) {
            case 1:
                stats.setJanuary(stats.getJanuary() + 1);
                break;
            case 2:
                stats.setFebruary(stats.getFebruary() + 1);
                break;
            case 3:
                stats.setMarch(stats.getMarch() + 1);
                break;
            case 4:
                stats.setApril(stats.getApril() + 1);
                break;
            case 5:
                stats.setMay(stats.getMay() + 1);
                break;
            case 6:
                stats.setJune(stats.getJune() + 1);
                break;
            case 7:
                stats.setJuly(stats.getJuly() + 1);
                break;
            case 8:
                stats.setAugust(stats.getAugust() + 1);
                break;
            case 9:
                stats.setSeptember(stats.getSeptember() + 1);
                break;
            case 10:
                stats.setOctober(stats.getOctober() + 1);
                break;
            case 11:
                stats.setNovember(stats.getNovember() + 1);
                break;
            case 12:
                stats.setDecember(stats.getDecember() + 1);
                break;
            default:
                break;
        }
        stats.setCount(stats.getCount() + 1);
    }

    public static void updateRelocationStatisticsList(List<RelocationStatistics> relocationStatisticsList, RelocationList relocationList) {
        Integer prefecture = relocationList.getPrefecture();
        Date createTime = relocationList.getCreateTime();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createTime);

        int month = calendar.get(Calendar.MONTH) + 1;

        RelocationStatistics stats = relocationStatisticsList.get(prefecture - 1);
        switch (month) {
            case 1:
                stats.setJanuary(stats.getJanuary() + 1);
                break;
            case 2:
                stats.setFebruary(stats.getFebruary() + 1);
                break;
            case 3:
                stats.setMarch(stats.getMarch() + 1);
                break;
            case 4:
                stats.setApril(stats.getApril() + 1);
                break;
            case 5:
                stats.setMay(stats.getMay() + 1);
                break;
            case 6:
                stats.setJune(stats.getJune() + 1);
                break;
            case 7:
                stats.setJuly(stats.getJuly() + 1);
                break;
            case 8:
                stats.setAugust(stats.getAugust() + 1);
                break;
            case 9:
                stats.setSeptember(stats.getSeptember() + 1);
                break;
            case 10:
                stats.setOctober(stats.getOctober() + 1);
                break;
            case 11:
                stats.setNovember(stats.getNovember() + 1);
                break;
            case 12:
                stats.setDecember(stats.getDecember() + 1);
                break;
            default:
                break;
        }
        stats.setCount(stats.getCount() + 1);
    }

}

package org.example.app;

import org.example.service.impl.ExcelServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.example.util.Util.generateExcel;

public class MainClass {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(
                7, 2, 7, 2, 4, 4, 2, 9, 6, 7, 4, 7, 5, 4, 5, 0, 3, 1, 7, 4, 3, 5, 0,
                1, 4, 8, 5, 10, 3, 4, 2, 9, 4, 10, 3, 1, 7, 4, 7, 4, 6, 9, 7, 7, 5, 4, 6, 7, 8, 10, 1);
        methodCaller(list);
        System.out.println("Baki vaxti ile : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("----");
        System.out.println("The program developed by AI-ZMIU");

    }
    public static void methodCaller(List<Integer> list) {
        ExcelServiceImpl excelService = new ExcelServiceImpl();
        List<Integer> integerList1 = excelService.createValuesListColumn(list);
        List<Integer> integerList2 = excelService.createSortedListColumn(list);
        List<Integer> integerList3 = excelService.createStudentScoresColumn(list);
        List<Integer> integerList4 = excelService.createStudentFrequencyColumn(list);
        List<Integer> integerList5 = excelService.createSumFrequencyColumn(list);

        List<Double> doubleList1 = excelService.createRelativeFrequencyColumn(list);
        List<Double> doubleList2 = excelService.createSumRelativeFrequencyColumn(list);
        List<Integer> integerList6 = excelService.createMeanValueMxColumn(list);
        List<Double> doubleList3 = excelService.createMeanValueWxColumn(list);
        List<Integer> integerList7 = excelService.createMedianColumn(list);

        List<Integer> integerList8 = excelService.createModeColumn(list);
        List<Double> doubleList4 = excelService.createXMeanDeviationColumn(list);
        List<Double> doubleList5 = excelService.createQuadraticXMeanColumn(list);
        List<Double> doubleList6 = excelService.createDispersionColumn(list);
        List<Double> doubleList7 = excelService.createQuadraticMeanDeviationColumn(list);

        List<Double> doubleList8 = excelService.createAssimetricColumn(list);
        List<Double> doubleList9 = excelService.createEksesColumn(list);

        generateExcel(integerList1, integerList2, integerList3, integerList4,
                integerList5, doubleList1, doubleList2, integerList6,
                doubleList3, integerList7, integerList8, doubleList4,
                doubleList5, doubleList6, doubleList7, doubleList8, doubleList9);

    }
}

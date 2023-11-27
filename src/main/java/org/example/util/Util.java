package org.example.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.example.util.enums.NameEnum.*;

public class Util {
    public static void generateExcel(List<Integer> integerList1, List<Integer> integerList2,
                                     List<Integer> integerList3, List<Integer> integerList4, List<Integer> integerList5,
                                     List<Double> doubleList1, List<Double> doubleList2, List<Integer> integerList6,
                                     List<Double> doubleList3, List<Integer> integerList7,
                                     List<Integer> integerList8, List<Double> doubleList4, List<Double> doubleList5,
                                     List<Double> doubleList6, List<Double> doubleList7, List<Double> doubleList8,
                                     List<Double> doubleList9) {

        String[] nameArray = {X_VALUES_NAME.getClaim(), SORTED_VALUES_NAME.getClaim(), STUDENT_SCORES_NAME.getClaim(), STUDENT_COUNT_NAME.getClaim(),
                SUM_FREQUENCY_NAME.getClaim(), RELATIVE_FREQUENCY_NAME.getClaim(), SUM_RELATIVE_FREQUENCY_NAME.getClaim(), MEAN_VALUE_MX_NAME.getClaim(),
                MEAN_VALUE_WX_NAME.getClaim(), MEDIAN_NAME.getClaim(), MODA_NAME.getClaim(), X_MEAN_DEVIATION_NAME.getClaim(), QUADRATIC_X_MEAN_NAME.getClaim(),
                DISPERSION_NAME.getClaim(), QUADRATIC_X_MEAN_DEVIATION_NAME.getClaim(), ASSIMETRIC_NAME.getClaim(), EKSES_NAME.getClaim()};
        String fileName = FILE_NAME.getClaim();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(SHEET_NAME.getClaim());
            createColumn(sheet, integerList1, 0, nameArray[0]);
            createColumn(sheet, integerList2, 1, nameArray[1]);
            createColumn(sheet, integerList3, 2, nameArray[2]);
            createColumn(sheet, integerList4, 3, nameArray[3]);
            createColumn(sheet, integerList5, 4, nameArray[4]);
            createColumn(sheet, doubleList1, 5, nameArray[5]);
            createColumn(sheet, doubleList2, 6, nameArray[6]);
            createColumn(sheet, integerList6, 7, nameArray[7]);
            createColumn(sheet, doubleList3, 8, nameArray[8]);
            createColumn(sheet, integerList7, 9, nameArray[9]);
            createColumn(sheet, integerList8, 10, nameArray[10]);
            createColumn(sheet, doubleList4, 11, nameArray[11]);
            createColumn(sheet, doubleList5, 12, nameArray[12]);
            createColumn(sheet, doubleList6, 13, nameArray[13]);

            createColumn(sheet, doubleList7, 14, nameArray[14]);
            createColumn(sheet, doubleList8, 15, nameArray[15]);
            createColumn(sheet, doubleList9, 16, nameArray[16]);

            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            outputStream.close();

            System.out.println("Fayl ugurla yaradildi - " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createColumn(Sheet sheet, List<?> dataList, int columnIndex, String columnName) {
        boolean hasData = dataList != null && !dataList.isEmpty();

        if (hasData) {
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                headerRow = sheet.createRow(0);
            }
            Cell headerCell = headerRow.createCell(columnIndex);
            headerCell.setCellValue(columnName);

            for (int i = 0; i < dataList.size(); i++) {
                Row dataRow = sheet.getRow(i + 1);
                if (dataRow == null) {
                    dataRow = sheet.createRow(i + 1);
                }
                Cell dataCell = dataRow.createCell(columnIndex);
                if (dataList.get(i) instanceof Double) {
                    dataCell.setCellValue((Double) dataList.get(i));
                } else if (dataList.get(i) instanceof Integer) {
                    dataCell.setCellValue((Integer) dataList.get(i));
                }
            }
        }
    }

}

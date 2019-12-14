package local.utils;

import com.google.common.base.Preconditions;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cuixiaoshuang
 * @date 2019-12-04
 **/
public class ExcelOutput {

    public static void outputAsExcel(List<? extends ExcelModel> data, String outputPath) throws Exception {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(data));
        File file = new File(outputPath);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        List<Pair<Field, ExcelColumn>> infos = parseHeader(data.get(0));

        createHeader(sheet, infos);
        putData(sheet, data, infos);

        try(FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        }
    }

    private static void putData(XSSFSheet sheet, List<? extends ExcelModel> data, List<Pair<Field, ExcelColumn>> infos) throws Exception {
        int rowIndex = 1;
        List<Field> fields = infos.stream().map(Pair::getLeft).collect(Collectors.toList());
        for (ExcelModel datum : data) {
            XSSFRow row = sheet.createRow(rowIndex++);
            int cellIndex = 0;
            for (Field field : fields) {
                field.setAccessible(true);
                String value = String.valueOf(field.get(datum));
                XSSFCell cell = row.createCell(cellIndex++, CellType.STRING);
                cell.setCellValue(value);
            }
        }
    }

    private static void createHeader(XSSFSheet sheet, List<Pair<Field, ExcelColumn>> infos) {
        List<String> headers = infos.stream()
                .map(e -> e.getRight().columnName())
                .collect(Collectors.toList());
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.size(); i++) {
            XSSFCell cell = row.createCell(i, CellType.STRING);
            cell.setCellValue(headers.get(i));
        }
    }

    static List<Pair<Field, ExcelColumn>> parseHeader(ExcelModel model) {
        Field[] fields = model.getClass().getDeclaredFields();
        return Arrays.stream(fields)
                .map(e -> Pair.of(e, e.getAnnotation(ExcelColumn.class)))
                .filter(e -> e.getRight() != null)
                .sorted((o1, o2) -> {
                    ExcelColumn c1 = o1.getRight();
                    ExcelColumn c2 = o2.getRight();
                    int orderCompare = Integer.compare(c1.order(), c2.order());
                    if (orderCompare != 0) {
                        return orderCompare;
                    } else {
                        return c1.columnName().compareTo(c2.columnName());
                    }
                })
                .collect(Collectors.toList());
    }
}

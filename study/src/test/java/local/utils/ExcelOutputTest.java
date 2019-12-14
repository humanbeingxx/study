package local.utils;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

/**
 * @author cuixiaoshuang
 * @date 2019-12-04
 **/
public class ExcelOutputTest {

    class MyModel extends ExcelModel {
        @ExcelColumn(columnName = "抬头1", order = 1)
        private String data1;

        @ExcelColumn(columnName = "抬头2", order = 3)
        private String data2;

        @ExcelColumn(columnName = "抬头3", order = 2)
        private String data3;

        public MyModel(String data1, String data2, String data3) {
            this.data1 = data1;
            this.data2 = data2;
            this.data3 = data3;
        }
    }

    @Test
    public void testOutputAsExcel() throws Exception {
        String path = "/Users/cxs/temp/test_excel_output.xlsx";

        ExcelOutput.outputAsExcel(
                Lists.newArrayList(
                        new MyModel("value1.1", "value1.2", "value1.3"),
                        new MyModel("value2.1", "value2.2", "value2.3"),
                        new MyModel("value3.1", "value3.2", "value3.3")
                ),
                path
        );
    }


}
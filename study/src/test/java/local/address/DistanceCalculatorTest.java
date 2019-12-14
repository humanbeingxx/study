package local.address;

import com.google.common.base.Preconditions;
import com.google.common.io.Files;
import local.utils.ExcelColumn;
import local.utils.ExcelModel;
import local.utils.ExcelOutput;
import lombok.Data;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import org.testng.collections.Maps;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cuixiaoshuang
 * @date 2019-12-04
 **/
public class DistanceCalculatorTest {

    @Test
    public void testCalcByCoordinate() {
        double distance = DistanceCalculator.calcByCoordinate(
                new DistanceCalculator.Coordinate(39.947892, 116.441454),
                new DistanceCalculator.Coordinate(39.938049, 116.448419)
        );
        System.out.println(distance);
    }

    @Data
    class Village {
        private String code;
        private DistanceCalculator.Coordinate coordinate;
    }

    @Data
    class VillageResult extends ExcelModel {
        @ExcelColumn(columnName = "街乡镇A", order = 1)
        private String villageA;

        @ExcelColumn(columnName = "街乡镇B", order = 2)
        private String villageB;

        @ExcelColumn(columnName = "中心距离", order = 3)
        private double distance;

        public VillageResult(String villageA, String villageB, double distance) {
            this.villageA = villageA;
            this.villageB = villageB;
            this.distance = distance;
        }
    }

    @Test
    public void calcVillagesByBD() throws Exception {
        List<Village> data = loadData("/Users/cxs/temp/bd.dat");
        Map<String, String> dict = loadDict("/Users/cxs/temp/village_dict");
        List<VillageResult> result = Lists.newArrayList();
        for (Village village : data) {
            for (Village another : data) {
                if (village.code.equalsIgnoreCase(another.code)) {
                    continue;
                }
                double distance = DistanceCalculator.calcByCoordinate(village.coordinate, another.coordinate);
                Preconditions.checkState(dict.containsKey(village.code));
                Preconditions.checkState(dict.containsKey(another.code));
                result.add(new VillageResult(dict.get(village.code), dict.get(another.code), distance));
            }
        }
        ExcelOutput.outputAsExcel(result, "/Users/cxs/temp/output_bd.xlsx");
    }

    private Map<String, String> loadDict(String path) throws IOException {
        Map<String, String> dict = Maps.newHashMap();

        Files.readLines(new File(path), StandardCharsets.UTF_8)
                .forEach(line -> {
                    String[] split = line.split(",");
                    dict.put(split[0], split[1]);
                });

        return dict;
    }

    private List<Village> loadData(String path) throws Exception {
        return Files.readLines(new File(path), StandardCharsets.UTF_8)
                .stream()
                .map(e -> {
                    String[] split = e.split(",");
                    Village village = new Village();
                    village.code = split[0];
                    village.coordinate = new DistanceCalculator.Coordinate(
                            Double.parseDouble(split[2]), Double.parseDouble(split[1]));
                    return village;
                })
                .collect(Collectors.toList());
    }
}
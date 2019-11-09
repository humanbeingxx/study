package local.address;

import com.google.common.collect.Lists;
import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.NlpAnalysis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-11-04
 **/
public class UseANSJ {

    public static void main(String[] args) throws IOException {
        List<String> withBlank = Lists.newArrayList();
        List<String> withNoBlank = Lists.newArrayList();

        Files.readAllLines(Paths.get("/Users/cxs/work/ml/address/address_part.csv"))
                .forEach(line -> {
                    Result result = NlpAnalysis.parse(line);
                    withBlank.add(result.toString());
                });

        Files.readAllLines(Paths.get("/Users/cxs/work/ml/address/address_part_no_blank.csv"))
                .forEach(line -> {
                    Result result = NlpAnalysis.parse(line);
                    withNoBlank.add(result.toString());
                });

        Files.write(Paths.get("/Users/cxs/work/ml/address/ansj_results_with_blank"),
                withBlank, StandardOpenOption.CREATE);

        Files.write(Paths.get("/Users/cxs/work/ml/address/ansj_results_with_no_blank"),
                withNoBlank, StandardOpenOption.CREATE);
    }
}

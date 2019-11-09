package local.address;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-11-04
 **/
public class UseHanLP {

    public static void main(String[] args) throws IOException {
        Segment segment = HanLP.newSegment().enablePlaceRecognize(true).enableOrganizationRecognize(true);

        Files.readAllLines(Paths.get("/Users/cxs/work/ml/address/address_part_no_blank.csv"))
                .forEach(line -> {
                    List<Term> termList = segment.seg(line);
                    System.out.println(termList);
                });

        Files.readAllLines(Paths.get("/Users/cxs/work/ml/address/address_part.csv"))
                .forEach(line -> {
                    List<Term> termList = segment.seg(line);
                    System.out.println(termList);
                });
    }
}

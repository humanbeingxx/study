package local.address.han;

import com.hankcs.hanlp.model.crf.CRFPOSTagger;
import com.hankcs.hanlp.model.crf.CRFSegmenter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-12-02
 **/
public class TrainPOSUsageTest {

    private String trainingSourcePath = "/Users/cxs/temp/hanlp_training/training_data.txt";

    private String modelPath = "/Users/cxs/temp/hanlp_training/model";

    @Test
    public void testTrain() throws IOException {
        CRFPOSTagger tagger = new CRFPOSTagger(null);
        tagger.train(trainingSourcePath, modelPath);
    }

    @Test
    public void testUse() throws IOException {
        CRFSegmenter segmenter = new CRFSegmenter(modelPath);
        List<String> strings = segmenter.segment("海淀区东升科技园");
        System.out.println(strings);
    }
}

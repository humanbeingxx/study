package local.address;

import com.google.common.collect.Lists;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-11-04
 **/
public class UseIkAnalyzer {
    static Analyzer analyzer = new IKAnalyzer(true);

    public static void main(String[] args) throws IOException {
        List<String> noBlank = Lists.newArrayList();
        List<String> withBlank = Lists.newArrayList();

        Files.readAllLines(Paths.get("/Users/cxs/work/ml/address/address_part_no_blank.csv"))
                .forEach(line -> {
                    try {
                        String result = parse(line);
                        noBlank.add(result);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        Files.readAllLines(Paths.get("/Users/cxs/work/ml/address/address_part.csv"))
                .forEach(line -> {
                    try {
                        String result = parse(line);
                        withBlank.add(result);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        Files.write(Paths.get("/Users/cxs/work/ml/address/ik_results_no_blank"),
                noBlank, StandardOpenOption.CREATE);

        Files.write(Paths.get("/Users/cxs/work/ml/address/ik_results_with_blank"),
                withBlank, StandardOpenOption.CREATE);
    }

    private static String parse(String text) throws IOException {

        StringReader reader = new StringReader(text);

        TokenStream tokenStream = analyzer.tokenStream("", reader);
        tokenStream.reset();
        tokenStream.addAttribute(CharTermAttribute.class);

        List<String> words = Lists.newArrayList();
        try {
            while (tokenStream.incrementToken()) {
                CharTermAttribute term = tokenStream.getAttribute(CharTermAttribute.class);
                words.add(term.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            tokenStream.close();
            reader.close();
        }
        return String.join(",", words);
    }
}

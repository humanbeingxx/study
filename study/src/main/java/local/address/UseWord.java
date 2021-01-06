package local.address;

import com.google.common.collect.Lists;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cuixiaoshuang
 * @date 2019-11-04
 **/
public class UseWord {

    public static void main(String[] args) throws IOException {
        List<String> resultsNoBlankStop = Lists.newArrayList();
        List<String> resultsNoBlankNoStop = Lists.newArrayList();
        List<String> resultsBlankStop = Lists.newArrayList();
        List<String> resultsBlankNoStop = Lists.newArrayList();

        Files.readAllLines(Paths.get("/Users/cxs/work/ml/address/address_part_no_blank.csv"))
                .forEach(line -> {
                    List<Word> words = WordSegmenter.seg(line);
                    List<Word> withStopWords = WordSegmenter.segWithStopWords(line);
                    resultsNoBlankStop.add(withStopWords.stream().map(Word::toString).collect(Collectors.joining(",")));
                    resultsNoBlankNoStop.add(words.stream().map(Word::toString).collect(Collectors.joining(",")));
                });

        Files.readAllLines(Paths.get("/Users/cxs/work/ml/address/address_part.csv"))
                .forEach(line -> {
                    List<Word> words = WordSegmenter.seg(line);
                    List<Word> withStopWords = WordSegmenter.segWithStopWords(line);
                    resultsBlankStop.add(withStopWords.stream().map(Word::toString).collect(Collectors.joining(",")));
                    resultsBlankNoStop.add(words.stream().map(Word::toString).collect(Collectors.joining(",")));
                });

        Files.write(Paths.get("/Users/cxs/work/ml/address/word_results_no_blank_stop"),
                resultsNoBlankStop, StandardOpenOption.CREATE);

        Files.write(Paths.get("/Users/cxs/work/ml/address/word_results_no_blank_no_stop"),
                resultsNoBlankNoStop, StandardOpenOption.CREATE);

        Files.write(Paths.get("/Users/cxs/work/ml/address/word_results_blank_stop"),
                resultsBlankStop, StandardOpenOption.CREATE);

        Files.write(Paths.get("/Users/cxs/work/ml/address/word_results_blank_no_stop"),
                resultsBlankNoStop, StandardOpenOption.CREATE);
    }
}

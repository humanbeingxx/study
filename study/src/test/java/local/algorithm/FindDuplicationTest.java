package local.algorithm;

import com.google.common.collect.Sets;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2019-06-03
 **/
public class FindDuplicationTest {
    Random random = new Random();

    @Test
    public void generateFile() throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/cxs/temp/test_duplication/duplication_A", true))) {
            for (int i = 0; i < 100000; i++) {
                writer.write(randomNumber() + "\n");
            }
            writer.flush();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/cxs/temp/test_duplication/duplication_B", true))) {
            for (int i = 0; i < 1000000; i++) {
                writer.write(randomNumber() + "\n");
            }
            writer.flush();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/cxs/temp/test_duplication/duplication_C", true))) {
            for (long i = 0; i < 10000000000L; i++) {
                writer.write(randomNumber() + "\n");
            }
            writer.flush();
        }
    }

    private String randomNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    @Test
    public void testSmallFiles() throws IOException {
        Set<String> count = Sets.newHashSet();
        List<String> result = Lists.newArrayList();

        long startTime = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/cxs/temp/test_duplication/duplication_A"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count.add(line);
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/cxs/temp/test_duplication/duplication_B"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (count.contains(line)) {
                    result.add(line);
                }
            }
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(result.stream().count());
        System.out.println(result);
    }

    @Test
    public void testBigFiles() throws IOException {
        Set<String> count = Sets.newHashSet();
        List<String> result = Lists.newArrayList();

        long startTime = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/cxs/temp/test_duplication/duplication_B"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count.add(line);
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/cxs/temp/test_duplication/duplication_C"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (count.contains(line)) {
                    result.add(line);
                }
            }
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(result.stream().count());
        System.out.println(result);
    }
}

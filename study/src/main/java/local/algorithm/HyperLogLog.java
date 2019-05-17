package local.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @date 2019-05-07
 **/
public class HyperLogLog {

    //TODO
    public static int estimate(int accuracy, File data) throws IOException {
        int[] buckets = new int[(int) Math.pow(2.0, (double) accuracy)];
        try (BufferedReader reader = Files.newBufferedReader(data.toPath())) {
            String line;
            while ((line = reader.readLine()) != null) {
                int hashCode = line.hashCode();
                int[] ints = cutByAccuracy(hashCode, accuracy);
                int pos = findFirstOne(ints[0]);
                if (pos > buckets[ints[1]]) {
                    buckets[ints[1]] = pos;
                }
            }
        }
        double harmonicMean = harmonicMean(buckets);
        return (int) (harmonicMean * buckets.length);
    }

    static double harmonicMean(int[] buckets) {
        double sum = 0;
        for (int bucket : buckets) {
            if (bucket == 0) {
                continue;
            }
            sum += 1 / (double) bucket;
        }
        double mean = sum / buckets.length;
        return 1 / mean;
    }

    static int findFirstOne(int num) {
        for (int i = 31; i >= 0; i++) {
            if ((num & 1 << i) != 0) {
                return i;
            }
        }
        return -1;
    }

    static int[] cutByAccuracy(int num, int accuracy) {
        int low = 0;
        for (int i = 0; i < accuracy; i++) {
            low |= 1 << i;
        }
        int high = ~low;
        return new int[]{num & high, num & low};
    }
}

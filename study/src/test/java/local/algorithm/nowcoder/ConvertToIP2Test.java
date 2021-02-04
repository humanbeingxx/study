package local.algorithm.nowcoder;

import local.algorithm.nowcoder.yuanfudao.ConvertToIP;
import org.testng.annotations.Test;

import java.util.List;

public class ConvertToIP2Test {

    @Test
    public void testConvert() {
        List<List<String>> result = new ConvertToIP().convertToIP("1111111");
        System.out.println(result);
    }
}
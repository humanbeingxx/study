package local.algorithm.nowcoder;

import local.algorithm.nowcoder.yuanfudao.ConvertToIP;
import org.testng.annotations.Test;

import java.util.List;

public class ConvertToIPTest {

    @Test
    public void testConvertToIP() {
        List<List<String>> result = new ConvertToIP().convertToIP("11111");
        System.out.println(result);
    }
}
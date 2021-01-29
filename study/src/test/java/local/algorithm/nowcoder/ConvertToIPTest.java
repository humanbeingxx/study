package local.algorithm.nowcoder;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ConvertToIPTest {

    @Test
    public void testConvertToIP() {
        List<List<String>> result = new ConvertToIP().convertToIP("11111");
        System.out.println(result);
    }
}
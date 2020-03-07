package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static org.testng.Assert.*;

public class ValidIPAddressTest {

    @Test
    public void testValidIPAddress() {
        ValidIPAddress validIPAddress = new ValidIPAddress();
        System.out.println(validIPAddress.validIPAddress("127.0.0.1"));
        System.out.println(validIPAddress.validIPAddress("127.00.0.1"));
        System.out.println(validIPAddress.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        System.out.println(validIPAddress.validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
    }
}
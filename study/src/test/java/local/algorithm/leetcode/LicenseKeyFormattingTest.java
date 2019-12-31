package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class LicenseKeyFormattingTest {

    @Test
    public void testLicenseKeyFormatting1() {
        String result = new LicenseKeyFormatting().licenseKeyFormatting3("5F3Z-2e-9-w", 4);
        assertEquals(result, "5F3Z-2E9W");
    }

    @Test
    public void testLicenseKeyFormatting2() {
        String result = new LicenseKeyFormatting().licenseKeyFormatting3("5F3Z-2e-9-w", 3);
        assertEquals(result, "5F-3Z2-E9W");
    }

    @Test
    public void testLicenseKeyFormatting3() {
        String result = new LicenseKeyFormatting().licenseKeyFormatting3("5F3Z-2e-9-w", 5);
        assertEquals(result, "5F3-Z2E9W");
    }

    @Test
    public void testLicenseKeyFormatting4() {
        String result = new LicenseKeyFormatting().licenseKeyFormatting3("5F3Z-2e-9-w", 8);
        assertEquals(result, "5F3Z2E9W");
    }

    @Test
    public void testLicenseKeyFormatting5() {
        String result = new LicenseKeyFormatting().licenseKeyFormatting3("5F3Z-2e-9-w", 9);
        assertEquals(result, "5F3Z2E9W");
    }

    @Test
    public void testLicenseKeyFormatting6() {
        String result = new LicenseKeyFormatting().licenseKeyFormatting3("2-5g-3-J", 2);
        assertEquals(result, "2-5G-3J");
    }
}
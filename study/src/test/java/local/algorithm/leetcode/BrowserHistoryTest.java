package local.algorithm.leetcode;

import org.testng.annotations.Test;

public class BrowserHistoryTest {

    @Test
    public void test() {
        // facebook.com, google.com, facebook.com, linkedin.com, google.com, leetcode.com
        BrowserHistory browser = new BrowserHistory("leetcode.com");
        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");
        System.out.println(browser.back(1));
        System.out.println(browser.back(1));
        System.out.println(browser.forward(1));
        browser.visit("linkedin.com");
        System.out.println(browser.forward(2));
        System.out.println(browser.back(2));
        System.out.println(browser.back(7));

    }
}
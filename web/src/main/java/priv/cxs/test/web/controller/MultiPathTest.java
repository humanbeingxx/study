package priv.cxs.test.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paths")
public class MultiPathTest {

    @GetMapping("")
    public String func0() {
        return "func0";
    }

    @GetMapping("s1/*/end")
    public String func1() {
        return "func1";
    }

    @GetMapping("s1/111/end")
    public String func111() {
        return "func111";
    }

    @GetMapping("s1/**/end")
    public String func00() {
        return "func**";
    }

    @GetMapping("s2/*/end")
    public String func21() {
        return "func2.1";
    }

    @GetMapping("s2/**/end")
    public String func22() {
        return "func22";
    }

    @GetMapping("s2/*/*/end")
    public String func23() {
        return "func23";
    }
}

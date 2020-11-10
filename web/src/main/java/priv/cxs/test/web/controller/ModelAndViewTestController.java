package priv.cxs.test.web.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("mav")
@Controller
public class ModelAndViewTestController {

    @RequestMapping()
    public String query(Model model) {
        model.addAttribute("name", "mav");
        return "mav.html";
    }

//    @Getter
    public static class Ret<T> {
        private boolean success;
        private T val;

        public static <T> Ret<T> successWith(T val) {
            Ret<T> ret = new Ret<>();
            ret.success = true;
            ret.val = val;
            return ret;
        }

        public static <T> Ret<T> fail() {
            Ret<T> ret = new Ret<>();
            ret.success = true;
            return ret;
        }
    }

    @ResponseBody
    @RequestMapping("json")
    public Ret<String> json() {
        return Ret.successWith("output json");
    }
}

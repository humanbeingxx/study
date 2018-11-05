package priv.cxs.springboot2.support;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:57
 */
@ControllerAdvice(basePackages = {"priv.cxs.springboot2.controller"})
public class HttpExceptionHandler {

    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseBody
    public String processDuplicationException(Exception e) {
        return "数据重复";
    }

    @ExceptionHandler(value = Exception.class)
    public String processException(Exception e) {
        return "error.html";
    }
}

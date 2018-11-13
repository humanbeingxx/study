package priv.cxs.springboot2.support.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/13 下午4:46
 **/
@ControllerAdvice
@Slf4j
@Order()
public class GlobalControllerAdvice {

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public String notFound(Exception e) {
        log.error("没有对应url", e);
        return "404";
    }

    @ExceptionHandler(value = Exception.class)
    public String processException(Exception e) {
        log.error("system internal error!!!", e);
        return "500";
    }
}

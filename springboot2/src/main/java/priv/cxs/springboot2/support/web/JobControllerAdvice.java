package priv.cxs.springboot2.support.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import priv.cxs.springboot2.controller.view.AddressValidator;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:57
 */
@ControllerAdvice(basePackages = {"priv.cxs.springboot2.controller"}, annotations = Controller.class)
@Slf4j
@Order(1)
public class JobControllerAdvice {

    @InitBinder
    public void bind(WebDataBinder binder) {
        binder.addValidators(new AddressValidator());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String paramMissException(MissingServletRequestParameterException e) {
        log.error("缺失参数", e);
        return "缺失参数 !!! " + e.getMessage();
    }

    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseBody
    public String processDuplicationException(DuplicateKeyException e) {
        return "数据重复";
    }

    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    @ResponseBody
    public String processMaxUploadSizeExceededException(Exception e) {
        return "文件太大";
    }
}

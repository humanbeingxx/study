package priv.cxs.springboot2.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:57
 */
@ControllerAdvice(basePackages = {"priv.cxs.springboot2.controller"})
@Slf4j
public class HttpExceptionHandler {

    @ExceptionHandler(value = DuplicateKeyException.class)
    @ResponseBody
    public String processDuplicationException(Exception e) {
        return "数据重复";
    }

    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    @ResponseBody
    public String processMaxUploadSizeExceededException(Exception e) {
        return "文件太大";
    }

    @ExceptionHandler(value = Exception.class)
    public String processException(Exception e) {
        log.error("system internal error!!!", e);
        return "500.html";
    }
}

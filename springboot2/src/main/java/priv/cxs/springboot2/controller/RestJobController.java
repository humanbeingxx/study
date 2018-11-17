package priv.cxs.springboot2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import priv.cxs.springboot2.controller.view.WebRet;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.service.JobService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/13 下午5:02
 **/
@RestController
@RequestMapping("rest/job")
@Slf4j
public class RestJobController {

    @Resource
    private JobService jobService;

    @GetMapping("{code}")
    public WebRet<Job> getById(@PathVariable("code") int code) {
        try {
            Job byCode = jobService.getByCode(code);
            return WebRet.successWithData(byCode);
        } catch (Exception e) {
            log.error("查询异常", e);
            return WebRet.fail("查询异常", 500);
        }
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public WebRet addMulti(@Valid @RequestBody List<Job> jobs, Errors errors) {
        WebRet valid = valid(errors);
        if (valid != null) {
            return valid;
        }
        try {
            jobService.insertMulti(jobs);
            return WebRet.success();
        } catch (DuplicateKeyException e) {
            log.error("插入重复", e);
            throw e;
        } catch (Exception e) {
            log.error("插入异常", e);
            return WebRet.fail("插入异常", 500);
        }
    }


    @PutMapping("{code}")
    public WebRet modify(@PathVariable int code, @RequestBody Job job) {
        try {
            job.setCode(code);
            jobService.updateByCode(job);
            return WebRet.success();
        } catch (Exception e) {
            log.error("更新异常", e);
            return WebRet.fail("更新异常", 500);
        }
    }

    @DeleteMapping("{code}")
    public WebRet delete(@PathVariable int code) {
        try {
            Job existedJob = jobService.getByCode(code);
            if (existedJob != null) {
                jobService.delete(existedJob);
            }
            return WebRet.success();
        } catch (Exception e) {
            log.error("删除异常", e);
            return WebRet.fail("删除异常", 500);
        }
    }

    private WebRet valid(Errors errors) {
        if (errors.getAllErrors().size() > 0) {
            String errMsg = errors.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
            return WebRet.fail(errMsg, 400);
        }
        return null;
    }
}

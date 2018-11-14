package priv.cxs.springboot2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import priv.cxs.springboot2.controller.view.WebRet;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.service.JobService;

import javax.annotation.Resource;

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
    public WebRet add(@RequestBody Job job) {
        try {
            jobService.insertOne(job);
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
            jobService.delete(code);
            return WebRet.success();
        } catch (Exception e) {
            log.error("删除异常", e);
            return WebRet.fail("删除异常", 500);
        }
    }
}

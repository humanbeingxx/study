package priv.cxs.springboot2.controller;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import priv.cxs.springboot2.controller.view.JobPdfView;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;
import priv.cxs.springboot2.service.JobService;
import priv.cxs.springboot2.support.aop.TimeRecord;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:54
 */
@Controller
@RequestMapping("job")
@Slf4j
public class JobController {

    @Resource
    private JobService jobService;

    @RequestMapping("add")
    @ResponseBody
    public String add(@RequestParam(value = "name") String name,
                      @RequestParam(value = "code") int code,
                      @RequestParam(value = "salary", required = false) int salary,
                      @RequestParam(value = "address", required = false) String address,
                      @RequestParam(value = "level", required = false) int level,
                      @RequestParam("jobType") int jobType) {
        jobService.insertOne(Job.builder().code(code).name(name).salary(salary).address(address).level(level)
                .jobType(JobType.codeOf(jobType)).build());
        return "操作成功";
    }

    @RequestMapping("addPlain")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@Valid Job job, Errors errors) {
        if (errors.getAllErrors().size() > 0) {
            return errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
        }
        jobService.insertOne(job);
        return "操作成功";
    }

    @RequestMapping("addMultiPlain")
    @ResponseBody
    public String addMulti(@RequestParam("jobs") List<Job> jobs) {
        jobService.insertMulti(Lists.newArrayList(jobs));
        return "操作成功";
    }


    @RequestMapping("list")
    @TimeRecord
    public String list(Model model) {
        model.addAttribute("jobs", jobService.getAll());
        return "job";
    }

    @RequestMapping("query")
    @TimeRecord
    public String query(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "code", required = false, defaultValue = "0") int code,
                        Model model) {
        if (code > 0) {
            model.addAttribute("jobs", jobService.getByCode(code));
        } else {
            model.addAttribute("jobs", jobService.getOne(name));
        }
        return "job";
    }

    @RequestMapping("update")
    @ResponseBody
    @TimeRecord
    public String update(@RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "code") int code,
                         @RequestParam(value = "salary", required = false) int salary,
                         @RequestParam(value = "address", required = false) String address,
                         @RequestParam(value = "level", required = false) int level,
                         @RequestParam("jobType") int jobType) {
        Job job;
        if (code > 0) {
            job = jobService.getByCode(code);
        } else if (StringUtils.isNotBlank(name)) {
            job = jobService.getOne(name);
        } else {
            jobService.flushCache(code, name);
            return "操作成功";
        }

        job.setCode(code);
        job.setSalary(salary);
        job.setAddress(address);
        job.setLevel(level);
        job.setJobType(JobType.codeOf(jobType));

        jobService.updateByCode(job);
        return "操作完成";
    }

    @RequestMapping("multiAdd")
    @ResponseBody
    @TimeRecord
    public String multiInsert(@RequestBody List<Job> jobs) {
        log.info("{}", jobs);
        return "操作成功";
    }

    @RequestMapping("show")
    @ResponseBody
    public Job showOne(@RequestParam(value = "code") int code) {
        return jobService.getByCode(code);
    }

    @RequestMapping("download")
    public ModelAndView download(ModelAndView modelAndView) {
        List<Job> jobs = jobService.getAll();
        modelAndView.setView(new JobPdfView());
        modelAndView.addObject("jobs", jobs);
        return modelAndView;
    }

    @RequestMapping("upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("upload/submit")
    @ResponseBody
    public String submitUpload(MultipartFile file, HttpServletRequest request) {
        String submittedFileName = file.getOriginalFilename();
        try {
            file.transferTo(new File(this.getClass().getResource("/tmp").getFile() + submittedFileName));
        } catch (IOException e) {
            log.error("上传异常", e);
            return "上传失败";
        }
        return "上传成功";
    }
}

package priv.cxs.springboot2.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;
import priv.cxs.springboot2.service.JobService;
import priv.cxs.springboot2.support.aop.TimeRecord;

import javax.annotation.Resource;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:54
 */
@Controller
@RequestMapping("job")
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
}

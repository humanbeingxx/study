package priv.cxs.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;
import priv.cxs.springboot2.service.JobServiceImpl;
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
    private JobServiceImpl jobService;

    @RequestMapping("add")
    @ResponseBody
    public String add(@RequestParam(value = "name", required = false) String name,
                      @RequestParam(value = "salary", required = false) int salary,
                      @RequestParam(value = "address", required = false) String address,
                      @RequestParam(value = "level", required = false) int level,
                      @RequestParam("jobType") int jobType) {
        jobService.insertOne(Job.builder().name(name).salary(salary).address(address).level(level)
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
    public String query(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("jobs", jobService.getOne(name));
        return "job";
    }
}

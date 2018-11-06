package priv.cxs.springboot2.controller;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.cxs.springboot2.model.Job;
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
    public String add(@RequestParam(value = "name", required = false) String name,
                    @RequestParam(value = "salary", required = false) int salary,
                    @RequestParam(value = "address", required = false) String address,
                    @RequestParam(value = "level", required = false) int level) {
        jobService.insertOne(Job.builder().name(name).salary(salary).address(address).level(level).build());
        return "操作成功";
    }

    @RequestMapping("list")
    @TimeRecord
    public String list(Model model) {
        model.addAttribute("jobs", jobService.getAll());
        return "job";
    }
}

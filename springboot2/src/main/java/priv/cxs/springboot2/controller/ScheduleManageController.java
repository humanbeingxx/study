package priv.cxs.springboot2.controller;

import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import priv.cxs.springboot2.controller.view.ScheduleJobView;
import priv.cxs.springboot2.controller.view.WebRet;
import priv.cxs.springboot2.schedule.ScheduleManageService;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 21:25
 */
@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduleManageController {

    @Autowired
    private ScheduleManageService manageService;

    @RequestMapping("resume")
    public WebRet enable(@RequestParam("jobName") String jobName) {
        try {
            manageService.resume(jobName);
            return WebRet.success();
        } catch (SchedulerException e) {
            log.error("开启schedule {} 失败", jobName, e);
            return WebRet.fail("操作失败 : " + e.getMessage(), 500);
        }
    }

    @RequestMapping("pause")
    public WebRet disable(@RequestParam("jobName") String jobName) {
        try {
            manageService.pause(jobName);
            return WebRet.success();
        } catch (SchedulerException e) {
            log.error("关闭schedule {} 失败", jobName, e);
            return WebRet.fail("操作失败 : " + e.getMessage(), 500);
        }
    }

    @RequestMapping("reschedule")
    public WebRet reschedule(@RequestParam("jobName") String jobName,
                             @RequestParam("cron") String cron) {
        try {
            manageService.reschedule(jobName, cron);
            return WebRet.success();
        } catch (SchedulerException e) {
            log.error("重新调度 {} 失败", jobName, e);
            return WebRet.fail("操作失败 : " + e.getMessage(), 500);
        }
    }

    @RequestMapping("list")
    public WebRet<List<ScheduleJobView>> list() {
        List<ScheduleJobView> views = manageService.allJobs();
        return WebRet.successWithData(views);
    }

    @RequestMapping("stop")
    public WebRet<List<ScheduleJobView>> stop() throws SchedulerException {
        manageService.stop();
        return WebRet.success();
    }

}

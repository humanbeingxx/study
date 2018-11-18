package priv.cxs.springboot2.controller.view;

import lombok.Data;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/18 22:05
 */
@Data
public class ScheduleJobView {

    private String name;
    private String triggerCron;
    private String triggerState;
}

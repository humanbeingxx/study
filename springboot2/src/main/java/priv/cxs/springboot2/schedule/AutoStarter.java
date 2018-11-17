package priv.cxs.springboot2.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 16:40
 */
@Component
@Slf4j
public class AutoStarter implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private ScheduleService scheduleService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("ContextRefreshedEvent listened, starting init schedule!!!");
        scheduleService.schedule();
    }
}

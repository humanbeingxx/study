package priv.cxs.springboot2.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import priv.cxs.springboot2.model.Job;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/15 下午2:39
 **/
@Service
@Slf4j
public class JobAsyncServiceImpl implements JobAsyncService {


    @Override
    public void notifyInner() {
        notifyJobChange(new Job(), new Job());
    }

    @Override
    @Async
    public void notifyJobChange(Job oldOne, Job newOne) {
        log.info("开始通知job变化");
        if (oldOne == null && newOne != null) {
            log.info("新增job {}", JSON.toJSONString(newOne));
        } else if (oldOne != null && newOne == null) {
            log.info("删除job {}", JSON.toJSONString(oldOne));
        } else if (oldOne != null && newOne != null && !oldOne.equals(newOne)) {
            log.info("修改job {} -> {}", JSON.toJSONString(oldOne), JSON.toJSONString(newOne));
        }
    }
}

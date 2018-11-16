package priv.cxs.springboot2.service;

import priv.cxs.springboot2.model.Job;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/15 下午2:39
 **/
public interface JobAsyncService {

    void notifyInner();

    void notifyJobChange(Job oldOne, Job newOne);
}

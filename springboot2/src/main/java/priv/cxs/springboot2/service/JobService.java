package priv.cxs.springboot2.service;

import org.springframework.stereotype.Service;
import priv.cxs.springboot2.dao.JobDao;
import priv.cxs.springboot2.model.Job;

import javax.annotation.Resource;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:39
 */
@Service
public class JobService {

    @Resource
    private JobDao jobDao;

    public void insertOne(Job job) {
        jobDao.insertOne(job);
    }
}

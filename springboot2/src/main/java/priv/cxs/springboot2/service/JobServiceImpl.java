package priv.cxs.springboot2.service;

import org.springframework.stereotype.Service;
import priv.cxs.springboot2.dao.JobDao;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.support.aop.TimeRecord;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:39
 */
@Service
public class JobServiceImpl implements JobService {

    @Resource
    private JobDao jobDao;

    @Override
    @TimeRecord
    public void insertOne(Job job) {
        jobDao.insertOne(job);
    }

    @Override
    @TimeRecord
    public List<Job> getAll() {
        return jobDao.selectAll();
    }
}

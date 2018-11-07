package priv.cxs.springboot2.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
@EnableAspectJAutoProxy(exposeProxy = true)
public class JobServiceImpl implements JobService {

    @Resource
    private JobDao jobDao;

    @Override
    @TimeRecord
    @CachePut(value = "redisCache", key = "'job_' + #job.getName()")
    public Job insertOne(Job job) {
        jobDao.insertOne(job);
        return job;
    }


    @Override
    @Cacheable(value = "redisCache", key = "'job_' + #name")
    public Job getOne(String name) {
        return jobDao.selectOne(name);
    }


    @Override
    @TimeRecord
    public List<Job> getAll() {
        return jobDao.selectAll();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteTwiceWithNewTransaction(String name) {
        jobDao.deleteByName(name);
        ((JobServiceImpl) AopContext.currentProxy()).deleteTwiceWithNewTransactionInner(name);
    }

    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void deleteTwiceWithNewTransactionInner(String name) {
        jobDao.deleteByName(name);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteTwiceWithNestedTransaction(String name) {
        jobDao.deleteByName(name);
        ((JobServiceImpl) AopContext.currentProxy()).deleteTwiceWithNestedTransactionInner(name);
    }

    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.NESTED)
    public void deleteTwiceWithNestedTransactionInner(String name) {
        jobDao.deleteByName(name);
    }
}

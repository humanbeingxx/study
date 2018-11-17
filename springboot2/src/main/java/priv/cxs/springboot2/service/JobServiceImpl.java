package priv.cxs.springboot2.service;

import com.google.common.collect.Lists;
import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    @TimeRecord
    @CachePut(value = "shortNullCache", key = "'job_@@600@@' + #job.code", cacheManager = "myRedisCacheManager")
    @CacheEvict(value = "shortNullCache", key = "'job_all'", condition = "#result == true", cacheManager = "myRedisCacheManager")
    public Job insertOne(Job job) {
        jobDao.insertOne(job);
        return job;
    }

    /**
     * todo 这里还是需要想办法解决下多条插入的缓存put问题
     */
    @Override
    @CacheEvict(value = "shortNullCache", key = "'job_all'", condition = "#result == true", cacheManager = "myRedisCacheManager")
    public boolean insertMulti(List<Job> jobs) {
        return jobDao.insertMulti(jobs) == jobs.size();
    }

    @Override
    @Cacheable(value = "shortNullCache", key = "'job_@@600@@' + #name", cacheManager = "myRedisCacheManager")
    public Job getOne(String name) {
        return jobDao.selectByName(name);
    }

    @Override
    @Cacheable(value = "shortNullCache", key = "'allowNil_job_@@600@@' + #name", cacheManager = "myRedisCacheManager")
    public Job getOneAllowNil(String name) {
        return jobDao.selectByName(name);
    }

    @Override
    @Cacheable(value = "shortNullCache", key = "'job_@@600@@' + #code", cacheManager = "myRedisCacheManager")
    public Job getByCode(int code) {
        return jobDao.selectByCode(code);
    }

    @Override
    @Cacheable(value = "shortNullCache", key = "'allowNil_job_@@600@@' + #code", cacheManager = "myRedisCacheManager")
    public Job getByCodeAllowNil(int code) {
        return jobDao.selectByCode(code);
    }

    @Override
    @TimeRecord
    @Cacheable(value = "shortNullCache", key = "'job_@@600@@all'", cacheManager = "myRedisCacheManager")
    public List<Job> getAll() {
        return jobDao.selectAll();
    }

    @Override
    @CacheEvict(value = "shortNullCache", key = "#job.generateKey() + '&&&job_all'", cacheManager = "myRedisCacheManager")
    public void delete(Job job) {
        jobDao.deleteByCode(job.getCode());
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

    @Override
    @CacheEvict(value = "shortNullCache", cacheManager = "myRedisCacheManager",
            key = "#job.generateKey() + '&&&job_all'")
    public void updateByCode(Job job) {
        jobDao.updateByCode(job);
    }

    @Override
    public void flushCache(int code, String name) {
        redisTemplate.delete(Lists.newArrayList("job_" + code, "job_" + name));
    }

    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.NESTED)
    public void deleteTwiceWithNestedTransactionInner(String name) {
        jobDao.deleteByName(name);
    }
}

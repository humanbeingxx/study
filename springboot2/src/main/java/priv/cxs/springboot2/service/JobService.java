package priv.cxs.springboot2.service;

import org.springframework.cache.annotation.Cacheable;
import priv.cxs.springboot2.model.Job;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/6 下午3:47
 **/
public interface JobService {

    Job insertOne(Job job);

    Job getOne(String name);

    Job getByCode(int code);

    List<Job> getAll();

    void deleteTwiceWithNewTransaction(String name);

    void deleteTwiceWithNestedTransaction(String name);

    void updateByCode(Job job);

    void flushCache(int code, String name);
}

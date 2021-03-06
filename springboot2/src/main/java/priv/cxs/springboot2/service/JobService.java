package priv.cxs.springboot2.service;

import priv.cxs.springboot2.model.Job;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/6 下午3:47
 **/
public interface JobService {

    Job insertOne(Job job);

    boolean insertMulti(List<Job> jobs);

    Job getOne(String name);

    Job getOneAllowNil(String name);

    Job getByCode(int code);

    Job getByCodeAllowNil(int code);

    List<Job> getAll();

    void delete(Job code);

    void deleteTwiceWithNewTransaction(String name);

    void deleteTwiceWithNestedTransaction(String name);

    void updateByCode(Job job);

    void flushCache(int code, String name);
}

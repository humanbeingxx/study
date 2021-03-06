package priv.cxs.springboot2.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.cxs.springboot2.model.Job;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:39
 */
@Repository
public interface JobDao {

    int insertOne(Job job);

    Job selectByName(@Param("name") String name);

    Job selectByCode(@Param("code") int code);

    List<Job> selectAll();

    void deleteByName(@Param("name") String name);

    void updateByCode(Job job);

    void flushAll();

    int insertMulti(@Param("jobs") List<Job> jobs);

    void deleteByCode(@Param("code") int code);
}

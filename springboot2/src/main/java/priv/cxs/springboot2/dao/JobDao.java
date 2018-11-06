package priv.cxs.springboot2.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import priv.cxs.springboot2.model.Job;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:39
 */
@Repository
public interface JobDao {

    @Insert("insert into tb_job (name, salary, level, address, create_time) values (#{name}, #{salary}, #{level}, #{address}, now())")
    void insertOne(Job job);

    @Select("select name, address, salary, level, job_type from tb_job")
    List<Job> selectAll();
}

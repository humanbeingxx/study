package priv.cxs.springboot2.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import priv.cxs.springboot2.model.Job;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:39
 */
@Repository
public interface JobDao {

    @Insert("insert into tb_job (code, name, salary, level, address, create_time) values (#{code}, #{name}, #{salary}, #{level}, #{address}, now())")
    void insertOne(Job job);

    @Select("select code, name, address, salary, level, job_type from tb_job where name = #{name}")
    Job selectByName(@Param("name") String name);

    @Select("select code, name, address, salary, level, job_type from tb_job where code = #{code}")
    Job selectByCode(@Param("code") int code);

    @Select("select code, name, address, salary, level, job_type from tb_job")
    List<Job> selectAll();

    @Delete("delete from tb_job where name = #{name}")
    void deleteByName(@Param("name") String name);

}

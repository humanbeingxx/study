package priv.cxs.springboot2.controller.view;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import priv.cxs.springboot2.model.Job;
import priv.cxs.springboot2.model.JobType;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/10 20:56
 */
@Component
public class JobConverter implements Converter<String, Job> {

    private static Splitter splitter = Splitter.on("_");

    @Override
    public Job convert(String source) {
        List<String> list = Lists.newArrayList(splitter.split(source));
        Job job = new Job();
        job.setCode(Integer.parseInt(list.get(0)));
        job.setName(list.get(1));
        job.setAddress(list.get(2));
        job.setSalary(Integer.parseInt(list.get(3)));
        job.setLevel(Integer.parseInt(list.get(4)));
        job.setJobType(JobType.codeOf(Integer.parseInt(list.get(5))));
        return job;
    }
}

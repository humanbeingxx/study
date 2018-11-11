package priv.cxs.springboot2.controller.view;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import priv.cxs.springboot2.model.Job;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/10 21:00
 */
public class JobMessageConverter implements HttpMessageConverter<Job> {
    private static Joiner joiner = Joiner.on("_");

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz == Job.class && APPLICATION_JSON.equals(mediaType);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Lists.newArrayList(APPLICATION_JSON);
    }

    @Override
    public Job read(Class<? extends Job> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Job job, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out;
        if (job == null) {
            out = "-";
        } else {
            out = joiner.join(job.getCode(), job.getName(), job.getAddress(), job.getSalary(), job.getLevel(), job.getJobType().name());
        }
        outputMessage.getBody().write(out.getBytes(Charsets.UTF_8));
    }
}

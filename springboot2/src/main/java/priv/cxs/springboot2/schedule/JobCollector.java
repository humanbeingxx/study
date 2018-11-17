package priv.cxs.springboot2.schedule;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobKey;
import org.quartz.TriggerKey;
import org.springframework.context.ApplicationContext;
import priv.cxs.springboot2.schedule.jobs.AbstractCronJob;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 15:50
 */
@Slf4j
public class JobCollector {

    public static final String PATH = JobCollector.class.getPackage().getName() + ".jobs";

    public static List<AbstractCronJob> collectJobClasses(ApplicationContext applicationContext) throws JobInitializeException {
        List<Class<AbstractCronJob>> jobClasses = Lists.newArrayList();

        try {
            ClassLoader classLoader = JobCollector.class.getClassLoader();
            Enumeration<URL> resources = classLoader.getResources(PATH.replace(".", "/"));

            while (resources.hasMoreElements()) {
                URL element = resources.nextElement();

                File file = new File(element.getPath());
                Preconditions.checkState(file.isDirectory());
                //TODO  internal dir not supported now

                for (File oneFile : file.listFiles()) {
                    String className = oneFile.getName().split("\\.")[0];
                    Class<?> aClass = classLoader.loadClass(PATH + "." + className);
                    if (AbstractCronJob.class.isAssignableFrom(aClass) && AbstractCronJob.class != aClass) {
                        jobClasses.add((Class<AbstractCronJob>) aClass);
                    }
                }
            }
        } catch (Exception e) {
            log.error("quartz job init failed !!!", e);
            throw new JobInitializeException(e);
        }

        try {
            List<AbstractCronJob> jobs = Lists.newArrayList();
            for (Class<AbstractCronJob> jobClass : jobClasses) {
                Constructor<AbstractCronJob> constructor = jobClass.getConstructor(ApplicationContext.class);
                AbstractCronJob cronJob = constructor.newInstance(applicationContext);
                jobs.add(cronJob);
            }
            return jobs;
        } catch (Exception e) {
            e.printStackTrace();
            throw new JobInitializeException(e);
        }
    }

    public static TriggerKey generateTriggerKey(String identity) {
        return TriggerKey.triggerKey("trigger::" + identity);
    }

    public static JobKey generateJobKey(String identity) {
        return JobKey.jobKey("job::" + identity);
    }
}

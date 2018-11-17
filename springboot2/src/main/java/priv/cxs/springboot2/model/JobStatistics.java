package priv.cxs.springboot2.model;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 15:24
 */
@Data
public class JobStatistics {

    int count;
    List<String> names;
    int salarySum;

    public static JobStatistics calculate(List<Job> jobs) {
        JobStatistics statistics = new JobStatistics();
        statistics.setCount(jobs.size());
        statistics.setNames(jobs.stream().map(Job::getName).collect(Collectors.toList()));
        statistics.setSalarySum(jobs.stream()
                .map(Job::getSalary)
                .reduce((i1, i2) -> i1 + i2)
                .orElse(0));

        return statistics;
    }
}

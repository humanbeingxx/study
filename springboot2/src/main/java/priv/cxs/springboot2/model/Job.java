package priv.cxs.springboot2.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:37
 */
@Data
@Builder
public class Job {

    private String name;
    private int salary;
    private String address;
    private int level;
}

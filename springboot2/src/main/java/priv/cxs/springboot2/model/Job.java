package priv.cxs.springboot2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 1:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("job")
public class Job implements Serializable {
    private static final long serialVersionUID = 4508600780045372954L;
    private int code;
    private String name;
    private int salary;
    private String address;
    private int level;
    private JobType jobType;
}

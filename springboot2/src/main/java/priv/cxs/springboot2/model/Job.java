package priv.cxs.springboot2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import priv.cxs.springboot2.dao.config.redis.MultiKeyCacheable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
public class Job implements MultiKeyCacheable, Serializable {
    private static final long serialVersionUID = 4508600780045372954L;

    @Min(value = 1, message = "编码不能小于1")
    private int code;

    @NotEmpty
    private String name;

    @Min(value = 1, message = "薪酬不能小于1")
    private int salary;

    @NotEmpty
    private String address;

    @Min(value = 1, message = "级别不能小于1")
    private int level;

    @NotNull
    private JobType jobType;

    @Override
    public String generateKey() {
        return MultiKeyCacheable.MULTI_KEY_JOINER.join("job_" + code, "job_" + name);
    }
}

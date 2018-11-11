package priv.cxs.springboot2.controller.view;


import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import priv.cxs.springboot2.model.Job;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/10 23:08
 */
public class AddressValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Job.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Job job = (Job) target;
        if (StringUtils.isBlank(job.getAddress())) {
            errors.rejectValue("address", null, "address不能为空");
            return;
        }
        if (!job.getAddress().startsWith("北京市")) {
            errors.reject("address", null, "必须是北京市地址");
        }
        if (!job.getAddress().endsWith("区")) {
            errors.rejectValue("address", null, "只能到区");
        }
    }
}

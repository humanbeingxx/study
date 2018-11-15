package priv.cxs.springboot2.controller.view;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import priv.cxs.springboot2.model.Job;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/10 23:08
 */
public class AddressValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof String) {
            validateAddress((String) target, errors);
        } else if (target instanceof List) {
            for (Object o : (List) target) {
                validateOne(o, errors);
            }
        } else {
            validateOne(target, errors);
        }
    }

    private void validateOne(Object target, Errors errors) {
        if (target instanceof Job) {
            Job job = (Job) target;
            String address = job.getAddress();
            validateAddress(address, errors);
        }
    }

    private void validateAddress(String address, Errors errors) {
        if (StringUtils.isBlank(address)) {
            errors.rejectValue("address", null, "address不能为空");
            return;
        }
        if (!address.startsWith("北京市")) {
            errors.reject("address", null, "必须是北京市地址");
        }
        if (!address.endsWith("区")) {
            errors.rejectValue("address", null, "只能到区");
        }
    }
}

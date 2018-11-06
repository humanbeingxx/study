package priv.cxs.springboot2.model;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/6 23:52
 */
public enum JobType {

    JAVA(1), IOS(2), ANDROID(3), DATA(4);

    private int code;

    private static Map<Integer, JobType> typeMap;

    static {
        typeMap = Maps.newHashMap();
        for (JobType value : JobType.values()) {
            typeMap.put(value.code, value);
        }
    }

    JobType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static JobType codeOf(int code) {
        return typeMap.get(code);
    }
}

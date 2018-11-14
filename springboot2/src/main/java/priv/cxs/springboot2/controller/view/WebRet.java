package priv.cxs.springboot2.controller.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/14 0:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebRet<T> implements Serializable {
    private static final long serialVersionUID = 2971368819997575594L;

    private boolean success;
    private String message;
    private int errCode;
    private T data;

    public static WebRet success() {
        return new WebRet<>(true, "操作成功", 0, null);
    }

    public static <V> WebRet<V> successWithData(V data) {
        return new WebRet<>(true, "操作成功", 0, data);
    }

    public static <V> WebRet<V> fail(String message, int errCode) {
        return new WebRet<>(false, message, errCode, null);
    }
}

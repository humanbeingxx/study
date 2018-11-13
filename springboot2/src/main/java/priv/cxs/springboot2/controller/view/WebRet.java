package priv.cxs.springboot2.controller.view;

import lombok.Data;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/14 0:02
 */
@Data
public class WebRet<T> {

    private boolean success;
    private String message;
    private int errCode;
    private T data;

    public WebRet(boolean success, String message, int errCode, T data) {
        this.success = success;
        this.message = message;
        this.errCode = errCode;
        this.data = data;
    }

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

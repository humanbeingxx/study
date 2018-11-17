package priv.cxs.springboot2.schedule;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/17 16:05
 */
public class JobInitializeException extends RuntimeException {

    private static final long serialVersionUID = -6980048026808650688L;

    public JobInitializeException(Exception e) {
        super(e);
    }
}

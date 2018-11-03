package local.before.d1103.event;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 0:02
 */
public interface Event {

    String getMessage();

    Exception getException();

    Object getData();
}

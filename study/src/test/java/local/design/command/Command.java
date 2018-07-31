package local.design.command;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:51
 **/
public interface Command {

    void execute();

    void cancel();
}

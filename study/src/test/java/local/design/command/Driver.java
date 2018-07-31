package local.design.command;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:56
 **/
public interface Driver {

    void prepare();

    void execInsert();

    void execUpdate();

    void execDelete();

    String execQuery();

    void clean();

    void rollBack();
}

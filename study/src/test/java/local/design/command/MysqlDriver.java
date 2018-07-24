package local.design.command;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:54
 **/
public class MysqlDriver implements Driver {

    @Override
    public void prepare() {
        System.out.println("mysql preparing");
    }

    @Override
    public void execInsert() {
        System.out.println("mysql inserting");
    }

    @Override
    public void execUpdate() {
        System.out.println("mysql updating");
    }

    @Override
    public void execDelete() {
        System.out.println("mysql deleting");
    }

    @Override
    public String execQuery() {
        return "mysql query result";
    }

    @Override
    public void clean() {
        System.out.println("mysql cleaning");
    }

    @Override
    public void rollBack() {
        System.out.println("mysql rolling back");
    }
}

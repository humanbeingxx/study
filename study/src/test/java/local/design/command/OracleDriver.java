package local.design.command;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:54
 **/
public class OracleDriver implements Driver {

    @Override
    public void prepare() {
        System.out.println("oracle preparing");
    }

    @Override
    public void execInsert() {
        System.out.println("oracle inserting");
    }

    @Override
    public void execUpdate() {
        System.out.println("oracle updating");
    }

    @Override
    public void execDelete() {
        System.out.println("oracle deleting");
    }

    @Override
    public String execQuery() {
        return "oracle query result";
    }

    @Override
    public void clean() {
        System.out.println("oracle cleaning");
    }

    @Override
    public void rollBack() {
        System.out.println("oracle rolling back");
    }
}

package local.design.command;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:52
 **/
public class InsertCommand implements Command {

    private Driver driver;

    public InsertCommand(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void execute() {
        driver.prepare();
        driver.execInsert();
        driver.clean();
    }

    @Override
    public void cancel() {
        driver.prepare();
        driver.rollBack();
        driver.clean();
    }
}

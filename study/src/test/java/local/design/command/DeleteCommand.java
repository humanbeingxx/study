package local.design.command;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:53
 **/
public class DeleteCommand implements Command {

    private Driver driver;

    public DeleteCommand(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void execute() {
        driver.prepare();
        driver.execDelete();
        driver.clean();
    }

    @Override
    public void cancel() {
        driver.prepare();
        driver.rollBack();
        driver.clean();
    }
}

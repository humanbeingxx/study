package local.design.command;

import org.junit.Test;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:53
 **/
public class Client {

    @Test
    public void invoke() {
        Invoker invoker = new Invoker();

        Driver mysql = Drivers.forName("mysql");
        invoker.addCommand(new InsertCommand(mysql));
        invoker.addCommand(new DeleteCommand(mysql));

        invoker.execute();

        Driver oracle = Drivers.forName("oracle");
        invoker.addCommand(new InsertCommand(oracle));
        invoker.addCommand(new DeleteCommand(oracle));

        invoker.execute();
    }
}

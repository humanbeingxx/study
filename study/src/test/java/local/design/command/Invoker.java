package local.design.command;

import com.google.common.collect.Lists;

import java.util.List;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/24 下午3:53
 **/
public class Invoker {

    private List<Command> commandList = Lists.newArrayList();


    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void execute() {
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}

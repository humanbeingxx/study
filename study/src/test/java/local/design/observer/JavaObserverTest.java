package local.design.observer;

import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/23 下午8:05
 **/
public class JavaObserverTest {

    class MessageSender extends Observable {

        public void send(String msg) {
            System.out.println("sending msg " + msg);
            setChanged();
            notifyObservers(msg);
        }
    }

    class MessageReceiver implements Observer {

        private String name;

        public MessageReceiver(String name) {
            this.name = name;
        }

        @Override
        public void update(Observable o, Object arg) {
            System.out.println(name + " has received message " + arg);
        }
    }

    @Test
    public void test() {
        final MessageSender sender = new MessageSender();
        sender.addObserver(new MessageReceiver("A"));
        sender.addObserver(new MessageReceiver("B"));

        sender.send("first message");
    }
}

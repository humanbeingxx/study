package local.jcore;

import java.io.Serializable;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/5 上午12:10
 **/
public class OverwriteSequenceTest {
    public static void say(Object arg) {
        System.out.println("object");
    }

    public static void say(int arg) {
        System.out.println("int");
    }

    public static void say(char arg) {
        System.out.println("char");
    }

    public static void say(long arg) {
        System.out.println("long");
    }

    public static void say(char... arg) {
        System.out.println("char...");
    }

    public static void say(Character arg) {
        System.out.println("Character");
    }

    public static void say(Serializable arg) {
        System.out.println("Serializable");
    }

    public static void say(char a, char b) {
        System.out.println("say two");
    }

    public static void main(String[] args) {
        say('a');
        say('a', 'b');

    }
}
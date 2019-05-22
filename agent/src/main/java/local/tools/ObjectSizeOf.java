package local.tools;

import java.lang.instrument.Instrumentation;

/**
 * @author cuixiaoshuang
 * @date 2019-05-22
 **/
public class ObjectSizeOf {

    static Instrumentation inst;

    public static void premain(String agentArgs, Instrumentation instP) {
        inst = instP;
    }

    public static long sizeOf(Object o) {
        if(inst == null) {
            throw new IllegalStateException("Can not access instrumentation environment.\n" +
                    "Please check if jar file containing SizeOfAgent class is \n" +
                    "specified in the java's \"-javaagent\" command line argument.");
        }
        return inst.getObjectSize(o);
    }
}

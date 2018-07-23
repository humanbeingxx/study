package local.other;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/7/23 上午11:00
 **/
public class MyObject implements Serializable {
    public String singleValue;
    public InnerObject[] multiValue;
    public ArrayList<InnerObject> listValue;

    @Override
    public String toString() {
        return "MyObject{" +
                "singleValue='" + singleValue + '\'' +
                ", multiValue=" + Arrays.toString(multiValue) +
                ", listValue=" + listValue +
                '}';
    }
}

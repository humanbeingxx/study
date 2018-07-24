package local.other;

import java.io.Serializable;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/7/23 上午11:00
 **/
public class InnerObject implements Serializable {
    public String value;

    public InnerObject() {
    }

    public InnerObject(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "InnerObject{" +
                "value='" + value + '\'' +
                '}';
    }
}

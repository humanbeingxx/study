package local.nio.model;

import java.io.Serializable;

/**
 * @author cuixiaoshuang
 * @date 2019-06-18
 **/
public class TimeRequest implements Serializable {

    private static final long serialVersionUID = -5801407578439101621L;

    private String req;

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    @Override
    public String toString() {
        return "TimeRequest{" +
                "req='" + req + '\'' +
                '}';
    }
}

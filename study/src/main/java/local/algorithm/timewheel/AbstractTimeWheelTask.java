package local.algorithm.timewheel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/9/25 下午10:06
 **/
@Data
@AllArgsConstructor
@EqualsAndHashCode
abstract public class AbstractTimeWheelTask {

    private int id;
    private int timeout;

    abstract void invoke();

    @Override
    public String toString() {
        return "AbstractTimeWheelTask{" +
                "id=" + id +
                ", timeout=" + timeout +
                '}';
    }
}

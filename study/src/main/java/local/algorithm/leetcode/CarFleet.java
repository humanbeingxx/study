package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CarFleet {

    static class Car {
        int pos;
        int speed;
        double arriveTime;

        public Car(int pos, int speed, double arriveTime) {
            this.pos = pos;
            this.speed = speed;
            this.arriveTime = arriveTime;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) {
            return 0;
        }
        List<Car> cars = new ArrayList<>(position.length);
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i], (target - position[i]) / (double) (speed[i])));
        }
        cars.sort((o1, o2) -> Integer.compare(o2.pos, o1.pos));
        int fleet = 1;
        Car leader = cars.get(0);
        for (int i = 1; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (!canCatchup(leader, car)) {
                leader = car;
                fleet++;
            }
        }
        return fleet;
    }

    private boolean canCatchup(Car leader, Car follower) {
        return (follower.speed - leader.speed) * (leader.arriveTime) >= (leader.pos - follower.pos);
    }
}

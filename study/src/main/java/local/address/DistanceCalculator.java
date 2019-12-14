package local.address;

import lombok.Getter;

/**
 * @author cuixiaoshuang
 * @date 2019-12-04
 **/
public class DistanceCalculator {

    // 6371km -> 6371000.0m
    private static final double EARTH_RADIUS = 6371000.0;

    /**
     * 用Haversine公式计算两点距离
     *
     * @return
     */
    public static double calcByCoordinate(Coordinate a, Coordinate b) {
        double latA = convertDegreesToRadians(a.latitude);
        double lonA = convertDegreesToRadians(a.longitude);
        double latB = convertDegreesToRadians(b.latitude);
        double lonB = convertDegreesToRadians(b.longitude);

        double vLat = Math.abs(latA - latB);
        double vLon = Math.abs(lonA - lonB);

        //h is the great circle distance in radians, great circle就是一个球体上的切面，它的圆心即是球心的一个周长最大的圆。
        double h = haversin(vLat) + Math.cos(latA) * Math.cos(latB) * haversin(vLon);

        return 2 * EARTH_RADIUS * Math.asin(Math.sqrt(h));
    }

    static double haversin(double theta) {
        double v = Math.sin(theta / 2);
        return v * v;
    }

    /**
     * 将角度换算为弧度
     */
    static double convertDegreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    @Getter
    public static class Coordinate {
        private double longitude;
        private double latitude;

        private Coordinate() {
        }

        public Coordinate(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}

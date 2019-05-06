package local.algorithm;

import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang@ktzh.lvwan.com
 * @date 2019-04-24
 **/
public class CoordinateTest {

    private static double EARTH_RADIUS = 6378.137;

    @Test
    public void testDistance() {
        double distance = getDistance(39.8987572, 116.7179847, 39.9051226, 116.7187034);
        System.out.println(distance);
    }

    private double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }

    private double rad(double d) {
        return d * Math.PI / 180.0;
    }
}

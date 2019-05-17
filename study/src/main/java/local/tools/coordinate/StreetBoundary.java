package local.tools.coordinate;

import com.google.common.collect.Lists;
import lombok.Data;

import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @date 2019-05-14
 **/
@Data
public class StreetBoundary {

    private String name;
    private String districtName;
    private GeneralPath boundary;

    public static List<StreetBoundary> read(String resourcePath) throws IOException {
        List<StreetBoundary> streets = Lists.newArrayList();
        Files.readAllLines(Paths.get(resourcePath)).forEach(line -> {
            String[] split = line.split("\t");
            StreetBoundary streetBoundary = new StreetBoundary();
            streetBoundary.setName(split[0]);
            streetBoundary.setDistrictName(split[1]);

            GeneralPath path = new GeneralPath();
            List<Point2D.Double> points = Lists.newArrayList();
            for (String point : split[2].split(",")) {
                String[] pointSplit = point.split(" ");
                points.add(new Point2D.Double(Double.parseDouble(pointSplit[0]), Double.parseDouble(pointSplit[1])));
            }
            path.moveTo(points.get(0).x, points.get(0).y);
            points.remove(0);
            for (Point2D.Double point : points) {
                path.lineTo(point.x, point.y);
            }
            streetBoundary.setBoundary(path);
            streets.add(streetBoundary);
        });
        return streets;
    }
}

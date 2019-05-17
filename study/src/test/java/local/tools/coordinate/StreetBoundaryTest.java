package local.tools.coordinate;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang@ktzh.lvwan.com
 * @date 2019-05-14
 **/
public class StreetBoundaryTest {

    @Test
    public void testRead() throws IOException {
        List<StreetBoundary> streetBoundaries = StreetBoundary.read("/Users/cxs/temp/villages_boundary.txt");
        System.out.println(streetBoundaries);
    }
}
package local.other;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : cuixiaoshuang@ktzh.lvwan.com
 * @date : 2019-02-15
 **/
public class TimeAdjustTest {

    @Test
    public void testInitDate() {
        List<String> strings = initDate("2018-09-23", "2019-02-12");
        System.out.println(strings);
    }

    private List<String> initDate(String start, String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        List<String> dateList = new ArrayList<>();
        while (!startDate.isAfter(endDate)){
            if (startDate.equals(startDate.with(TemporalAdjusters.firstDayOfMonth()))){
                dateList.add(startDate.toString());
            }
            startDate = startDate.with(TemporalAdjusters.firstDayOfNextMonth());
        }
        Collections.reverse(dateList);
        return dateList;
    }
}

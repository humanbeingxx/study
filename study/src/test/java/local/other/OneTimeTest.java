package local.other;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2019-06-27
 **/
public class OneTimeTest {

    @Test
    public void testSplitEmpty() {
        System.out.println("".split("#").length);

        List<String> list = Arrays.asList("".split("#"));
        System.out.println(list);
        System.out.println(list.get(0));

        System.out.println(Arrays.toString(new String[]{""}));
    }

    @Test
    public void testSplit() {
        System.out.println(Arrays.toString("123&abc".split("&")));

        System.out.println(Math.abs("12".hashCode()));
    }

    @Test
    public void testGenerateTmpSql() {
        String base = "hive -e \"insert into user_fgw.user_base_info_1903 select imsi, iot_account_label, msisdn, 'mme' from loc_crypt.i_mme_ext_1903 where p >= 201903%02d00 and p <= 201903%02d23 group by imsi, iot_account_label, msisdn;\"";

        for (int i = 1; i <= 31; i++) {
            System.out.println(String.format(base, i, i));
            System.out.println(String.format("echo \"finish mme 201903%02d\"", i));
            System.out.println();
        }

        String base2 = "hive -e \"insert into user_fgw.user_base_info_1903 select imsi, iot_account_label, phone_label, 'mc' from loc_crypt.i_mc_ext_1903 where p >= 201903%02d00 and p <= 201903%02d23 group by imsi, iot_account_label, phone_label;\"";

        for (int i = 1; i <= 31; i++) {
            System.out.println(String.format(base2, i, i));
            System.out.println(String.format("echo \"finish mc 201903%02d\"", i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(0);
    }
}

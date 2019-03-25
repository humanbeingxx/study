package local.querydsl;

import com.querydsl.core.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

import static com.querydsl.collections.CollQueryFactory.from;

/**
 * @author : cuixiaoshuang@ktzh.lvwan.com
 * @date : 2019-02-21
 **/
public class QSpaceInfoTest {

    private static Logger logger = LoggerFactory.getLogger(QSpaceInfoTest.class);

    private List<SpaceInfo> data = Lists.newArrayList();

    @BeforeMethod
    public void setUp() {
        SpaceInfo spaceInfo1 = new SpaceInfo();
        spaceInfo1.setId(1);
        spaceInfo1.setName("海淀区");
        spaceInfo1.setLevel(2);
        spaceInfo1.setArea(123456789L);
        spaceInfo1.setParentId(99);
        spaceInfo1.setParentName("北京市");

        SpaceInfo spaceInfo2 = new SpaceInfo();
        spaceInfo2.setId(2);
        spaceInfo2.setName("丰台区");
        spaceInfo2.setLevel(2);
        spaceInfo2.setArea(123456789L);
        spaceInfo2.setParentId(99);
        spaceInfo2.setParentName("北京市");

        SpaceInfo spaceInfo3 = new SpaceInfo();
        spaceInfo3.setId(99);
        spaceInfo3.setName("丰台区");
        spaceInfo3.setLevel(2);
        spaceInfo3.setArea(1234567899L);
        spaceInfo3.setParentId(0);
        spaceInfo3.setParentName("");

        data.add(spaceInfo1);
        data.add(spaceInfo2);
        data.add(spaceInfo3);
    }

    @Test
    public void testQuery() {

        for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();
            QSpaceInfo spaceInfo = QSpaceInfo.spaceInfo;

            List<Tuple> fetch = from(spaceInfo, data)
                    .select(spaceInfo.id, spaceInfo.name, spaceInfo.level, spaceInfo.area)
                    .where(spaceInfo.parentId.eq(99))
                    .fetch();
            fetch.forEach(tuple -> System.out.println(tuple.get(spaceInfo.name)));
            logger.info("cost {}", System.currentTimeMillis() - startTime);
        }
    }
}
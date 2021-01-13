package local.mysql;

import com.google.common.collect.Lists;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DeadLockTest {

    volatile boolean flag = false;

    private Connection[] connections = new Connection[10];

    @BeforeMethod
    public void init() throws Exception {
        flag = false;
        for (int i = 0; i < 10; i++) {
            connections[i] = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/local", "root", "");
            connections[i].setAutoCommit(false);
        }
    }

    @AfterMethod
    public void close() {
        for (int i = 0; i < 10; i++) {
            try {
                connections[i].close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Test
    public void insertData() throws Exception {
        Statement statement = connections[0].createStatement();
        for (int i = 0; i < 10000; i++) {
            statement.execute("insert into test_page_size (text) values (repeat('A', 8000));");
            statement.execute("commit");
        }
    }

    @Test
    public void testDuplicationKeyUpdate() throws Exception {
        for (int i = 0; i < 10; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    Statement statement = connections[index].createStatement();
                    statement.execute("begin");
                    while (!flag) {

                    }
                    statement.execute("insert into temp (code) values (10) on duplicate key update code = code+1;");
                    statement.execute("rollback;");
                } catch (Exception e) {
                    throw new Error(e);
//                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(50);
        flag = true;
        Thread.sleep(1000);
    }

    @Test
    public void testInsert() {
        testSql(Lists.newArrayList("insert into temp2 (id) values (7)"), false, 6);
    }

    @Test
    public void testInsertUnique() {
        testSql(Lists.newArrayList("insert into temp (code) values (20)"), false, 10);
    }

    @Test
    public void testDeleteUnique() {
        testSql(Lists.newArrayList(
                "delete from temp where code = 0",
                "delete from temp where code = 1",
                "delete from temp where code = 2",
                "delete from temp where code = 3",
                "delete from temp where code = 4",
                "delete from temp where code = 5",
                "delete from temp where code = 6",
                "delete from temp where code = 7",
                "delete from temp where code = 8"
        ), false, 10);
    }

    private void testSql(List<String> sqls, boolean commit, int threadCount) {
        List<Thread> threads = Lists.newArrayList();
        try {
            for (int i = 0; i < threadCount; i++) {
                int index = i;
                Thread thread = new Thread(() -> {
                    try {
                        Statement statement = connections[index].createStatement();
                        statement.execute("begin");
                        while (!flag) {

                        }
                        for (String sql : sqls) {
                            statement.execute(sql);
                        }
                        Thread.sleep(500);
                        statement.execute(commit ? "commit" : "rollback");
                        System.out.println(Thread.currentThread().getName() + " executed");
                    } catch (Exception throwables) {
                        throwables.printStackTrace();
                    }

                });
                thread.start();
                threads.add(thread);
            }
            flag = true;
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

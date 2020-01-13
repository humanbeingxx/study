package local.utils;

import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-11
 **/
public class SFTPClientTest {

    static String userName;
    static String password;

    @BeforeClass
    public static void init() {
        userName = System.getProperty("userName");
        password = System.getProperty("password");
    }

    @Test
    public void testListFiles() {
        SFTPClient client = new SFTPClient(userName, password, "127.0.0.1", 22);
        client.login();
        List<String> listFiles = client.listFiles("/Users/cxs/temp");
        for (String listFile : listFiles) {
            String[] split = listFile.split(" +");
            System.out.println(split[split.length - 1]);
        }

        client.logout();
        client.login();
        listFiles = client.listFiles("/Users/cxs/temp");
        for (String listFile : listFiles) {
            String[] split = listFile.split(" +");
            System.out.println(split[split.length - 1]);
        }
    }

    @Test
    public void testCd() {
        SFTPClient client = new SFTPClient(userName, password, "127.0.0.1", 22);
        client.login();
        client.cd("/Users/cxs/temp123");
        System.out.println(client.pwd());
        client.logout();

        client.login();
        System.out.println(client.pwd());
        client.logout();
    }

    @Test
    public void testUpload() {
        SFTPClient client = new SFTPClient(userName, password, "127.0.0.1", 22);
        client.login();
        client.upload("/Users/cxs/temp/test", "/Users/cxs/temp/ftp_upload");
        client.logout();
    }

    @Test
    public void testUploadDirectory() {
        SFTPClient client = new SFTPClient(userName, password, "127.0.0.1", 22);
        client.login();
        client.upload("/Users/cxs/temp/ftp_local", "/Users/cxs/temp/ftp_upload");
        client.logout();
    }

    @Test
    public void testDownload() {
        SFTPClient client = new SFTPClient(userName, password, "127.0.0.1", 22);
        client.login();
        client.download("/Users/cxs/temp/ftp_download", "/Users/cxs/temp/ftp_upload/test");
        client.logout();
    }

    @Test
    public void testStat() throws SftpException {
        SFTPClient client = new SFTPClient(userName, password, "127.0.0.1", 22);
        client.login();
        SftpATTRS stat = client.sftp.stat("abc");
        System.out.println(stat);
        client.logout();
    }
}
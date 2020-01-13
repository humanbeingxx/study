package local.utils;

import com.google.common.collect.Lists;
import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 * @author cuixiaoshuang
 * @date 2020-01-11
 **/
public class SFTPClient {

    private static Logger log = LoggerFactory.getLogger(SFTPClient.class);
    private String userName;
    private String password;
    private String host;
    private int port;

    private Session session;
    ChannelSftp sftp;

    public SFTPClient(String userName, String password, String host, int port) {
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    public void login() {
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(userName, host, port);
            session.setPassword(password);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();

            sftp = (ChannelSftp) channel;

        } catch (JSchException e) {
            throw new RuntimeException(e);
        }
    }

    public void logout() {
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect();
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }

    public List<String> listFiles(String path) {
        try {
            Vector ls = sftp.ls(path);
            List<String> files = Lists.newArrayList();
            for (Object f : ls) {
                files.add(f.toString());
            }
            return files;
        } catch (SftpException e) {
            throw new RuntimeException(e);
        }
    }

    public void cd(String path) {
        try {
            sftp.cd(path);
        } catch (SftpException e) {
            throw new RuntimeException(e);
        }
    }

    public String pwd() {
        try {
            return sftp.pwd();
        } catch (SftpException e) {
            throw new RuntimeException(e);
        }
    }

    public void upload(String local, String remote) {
        try {
            sftp.cd(remote);
            File file = new File(local);
            if (file.isFile()) {
                sftp.put(local, remote);
            } else {
                File[] subFiles = file.listFiles();

                for (File subFile : subFiles) {
                    uploadRec(subFile, remote);
                }
            }
        } catch (SftpException e) {
            throw new RuntimeException(e);
        }
    }

    private void uploadRec(File subFile, String remote) throws SftpException {
        if (subFile.isDirectory()) {
            String subPath = remote + "/" + subFile.getName();
            SftpATTRS stat = null;
            try {
                stat = sftp.stat(subPath);
            } catch (SftpException e) {
                log.warn("file {} not exists", subPath);
            }
            if (stat == null) {
                sftp.mkdir(subPath);
            } else if (!stat.isDir()) {
                sftp.rm(subPath);
                sftp.mkdir(subPath);
            }
            for (File file : subFile.listFiles()) {
                uploadRec(file, subPath);
            }
        } else {
            sftp.put(subFile.getAbsolutePath(), remote);
        }
    }

    public void download(String local, String remote) {
        try {
            sftp.get(remote, local);
        } catch (SftpException e) {
            throw new RuntimeException(e);
        }
    }
}

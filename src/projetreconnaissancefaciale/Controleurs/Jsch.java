package projetreconnaissancefaciale.Controleurs;

import com.jcraft.jsch.*;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author Perraudeau
 */
public class Jsch {

    public void send(String fileName) {
        String SFTPHOST = "host:192.168.1.100";
        int SFTPPORT = 22;
        String SFTPUSER = "admin";
        String SFTPPASS = "Beetlejuice8627";
        String SFTPWORKINGDIR = "/";

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
        System.out.println("preparing the host information for sftp.");
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            System.out.println("Host connected.");
            channel = session.openChannel("sftp");
            channel.connect();
            System.out.println("sftp channel opened and connected.");
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            File f = new File(fileName);
            channelSftp.put(new FileInputStream(f), f.getName());
        } catch (Exception ex) {
            System.out.println("Exception found while tranfer the response.");
        } finally {
            channelSftp.exit();
            System.out.println("sftp Channel exited.");
            channel.disconnect();
            System.out.println("Channel disconnected.");
            session.disconnect();
            System.out.println("Host Session disconnected.");
        }
    }

    public void download(String fileName) {
        String SFTPHOST = "host:192.168.1.100";
        int SFTPPORT = 22;
        String SFTPUSER = "admin";
        String SFTPPASS = "Beetlejuice8627";
        String SFTPWORKINGDIR = "/";

        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            System.out.println("Host connected.");
            channel = session.openChannel("sftp");
            channel.connect();
            System.out.println("sftp channel opened and connected.");
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            channelSftp.get(fileName,fileName);
        } catch (Exception ex) {
            System.out.println("Exception found while tranfer the response.");
        } finally {
            channelSftp.exit();
            System.out.println("sftp Channel exited.");
            channel.disconnect();
            System.out.println("Channel disconnected.");
            session.disconnect();
            System.out.println("Host Session disconnected.");
        }
    }
}

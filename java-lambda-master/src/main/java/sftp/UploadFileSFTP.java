package sftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
/**
 * 
 * @author javagists.com
 *
 */
public class UploadFileSFTP {
 
 public static void main(String[] args) throws Exception {

  JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession("admin", "127.0.0.1", 22);
            //session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("pass");
            jsch.addIdentity(".ssh/id_rsa");
            session.connect();
            
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.put("/tmplocal/testUpload.txt", "/tmpremote/testUpload.txt");  
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();  
        } catch (SftpException e) {
            e.printStackTrace();
        }

 }

}
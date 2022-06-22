import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
/**
 * ��ȡ�ʼ�Session�Ѿ������ʼ�
 * @author KevinBlandy 
 **/
public class MailUtils
{
	/**
	 * ��ȡSession
	 * ������,�û���,����
	 * */
	public static Session createSession(String host, final String username, final String password) 
	{
		Properties prop = new Properties();
		prop.setProperty("mail.host", host);// ָ������
		prop.setProperty("mail.smtp.auth", "true");// ָ����֤Ϊtrue
		// ������֤��
		Authenticator auth = new Authenticator() 
		{
			public PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(username, password);
			}
		};
		// ��ȡsession����
		return Session.getInstance(prop, auth);
	}
	/**
	 * ����ָ���ʼ�
	 * */
	public static void send(Session session, final Mail mail) throws MessagingException,IOException
	{

		MimeMessage msg = new MimeMessage(session);// �����ʼ�����
		msg.setFrom(new InternetAddress(mail.getFrom()));// ���÷�����
		msg.addRecipients(RecipientType.TO, mail.getToAddress());// �����ռ���
		// ���ó���
		String cc = mail.getCcAddress();
		if (!cc.isEmpty()) 
		{
			msg.addRecipients(RecipientType.CC, cc);
		}

		// ���ð���
		String bcc = mail.getBccAddress();
		if (!bcc.isEmpty()) 
		{
			msg.addRecipients(RecipientType.BCC, bcc);
		}
		msg.setSubject(mail.getSubject());// ��������
		MimeMultipart parts = new MimeMultipart();// ��������������
		MimeBodyPart part = new MimeBodyPart();// ����һ������
		part.setContent(mail.getContent(), "text/html;charset=utf-8");// �����ʼ��ı�����
		parts.addBodyPart(part);// �Ѳ�����ӵ���������
		//////////////////////����/////////////////////
		List<AttachBean> attachBeanList = mail.getAttachs();// ��ȡ���и���
		if (attachBeanList != null) 
		{
			for (AttachBean attach : attachBeanList) 
			{
				MimeBodyPart attachPart = new MimeBodyPart();// ����һ������
				attachPart.attachFile(attach.getFile());// ���ø����ļ�
				attachPart.setFileName(MimeUtility.encodeText(attach.getFileName()));// ���ø����ļ���
				String cid = attach.getCid();
				if(cid != null)
				{
					attachPart.setContentID(cid);
				}
				parts.addBodyPart(attachPart);
			}
		}
		msg.setContent(parts);// ���ʼ���������
		Transport.send(msg);// ���ʼ�
	}
}

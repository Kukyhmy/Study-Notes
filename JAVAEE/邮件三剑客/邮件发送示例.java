import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;

public class Demo
{
	public static void main(String[] args) throws MessagingException, IOException
	{
		send();//������ͨ�ʼ�
		sendWithFile();//���ʹ��������ʼ�
	}
	/**
	 * ������ͨ�ʼ�ʾ��
	 * */
	public static void send() throws MessagingException, IOException
	{
		/**
		 * �õ�session
		 * */
		Session session = MailUtils.createSession("smtp.qq.com","747692844","xxxx");
		/**
		 * ����mail����
		 * ������,�ռ���,����,����
		 * */
		Mail mail = new Mail("747692844@qq.com", "948593493@qq.com","����","<a href='http://www.kevinblandy.com'>����һ�������ʼ�</a>");
		/**
		 * ����utils�����ʼ�
		 * */
		MailUtils.send(session, mail);
	}
	/**
	 * ���ʹ��������ʼ�ʵ��
	 * @throws IOException 
	 * @throws MessagingException 
	 * */
	public static void sendWithFile() throws MessagingException, IOException
	{
		/**
		 * �õ�session
		 * */
		Session session = MailUtils.createSession("smtp.qq.com","747692844","xxxxx");
		/**
		 * ����mail����
		 * ������,�ռ���,����,����
		 * */
		Mail mail = new Mail("747692844@qq.com", "948593493@qq.com","���������ʼ�","<a href='http://www.kevinblandy.com'>����������Բ�</a>");
		/**
		 * ����Bean��,(һ��Bean��ʾһ������,�����ж��)
		 * �ϴ����ļ�,��ʾ���ռ��˵��ļ�����
		 **/
		AttachBean ab1 = new AttachBean(new File("D:\\china.xml"),"xml�����ļ�c.xml");
		AttachBean ab2 = new AttachBean(new File("D:\\Demo.xml"),"xml�����ļ�d.xml");
		/**
		 * �Ѹ�����ӵ��ʼ�(mail)������
		 * */
		mail.addAttach(ab1);
		mail.addAttach(ab2);
		/**
		 * ����utils�����ʼ�
		 * */
		MailUtils.send(session, mail);
	}
}
package com.kevin.mail;
import java.io.File;
import java.io.IOException;
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
public class Demo1
{
	public static void main(String[] args) throws Exception
	{
		test1();
		test2();
	}
	//������ͨ�ʼ�
	public static void test1()
	{
		//�õ�Session
		Properties prop = new Properties();
		//���÷�����������
		prop.setProperty("mail.host", "smtp.qq.com");
		//������Ҫ��֤
		prop.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				PasswordAuthentication pass = new PasswordAuthentication("747692844@qq.com","Direct19931209");
				return pass;
			}
		};
		Session session = Session.getInstance(prop,auth);
		//����MimeMessage
		MimeMessage msg = new MimeMessage(session);
		try 
		{
			//���÷�������Ϣ
			msg.setFrom(new InternetAddress("747692844@qq.com"));
			//�����ռ�����Ϣ
			msg.setRecipients(RecipientType.TO, "948593493@qq.com");
			//���ó���
			msg.setRecipients(RecipientType.CC, "747692844@qq.com");
			//��������
			msg.setRecipients(RecipientType.BCC,"10086@qq.com");
			msg.setSubject("��������KevinBlandy�Ĳ����ʼ�");//���ñ���
			msg.setContent("�����һ�������ʼ�,����","text/html;charset=utf-8");//���������Լ�����,����
			//�����ʼ�
			Transport.send(msg);
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
	}
	//���ʹ��и������ʼ�
	public static void test2() throws IOException
	{
		//�õ�Session
		Properties prop = new Properties();
		//���÷�����������
		prop.setProperty("mail.host", "smtp.qq.com");
		//������Ҫ��֤
		prop.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				PasswordAuthentication pass = new PasswordAuthentication("747692844@qq.com","Direct19931209");
				return pass;
			}
		};
		Session session = Session.getInstance(prop,auth);
		//����MimeMessage
		MimeMessage msg = new MimeMessage(session);
		try 
		{
			//���÷�������Ϣ
			msg.setFrom(new InternetAddress("747692844@qq.com"));
			//�����ռ�����Ϣ
			msg.setRecipients(RecipientType.TO, "948593493@qq.com");
			//���ó���
			msg.setRecipients(RecipientType.CC, "747692844@qq.com");
			//��������
			msg.setRecipients(RecipientType.BCC,"10086@qq.com");
			msg.setSubject("��������KevinBlandy�Ĳ����ʼ�");//���ñ���
			/***********************��������**************************************/
			/**
			 * �����Ͱ����������ʼ�ʱ,�ʼ����Ϊ�ಿ����ʽ
			 * */
			//�����ಿ������
			MimeMultipart list = new MimeMultipart();
			//����MimeBodyPart
			MimeBodyPart part1 = new MimeBodyPart();
			//���ò���������
			part1.setContent("����һ����и������ʼ�","text/html;charset=utf-8");
			//�Ѳ����岿����ӵ�������
			list.addBodyPart(part1);
			//�ڴ���һ��MimeBodyPart
			MimeBodyPart part2 = new MimeBodyPart();
			//���ò��������� --- �����ļ�
			part2.attachFile(new File("D:\\test.txt"));
			//��ʾ�ڸ�����,���Ҵ���������������
			part2.setFileName(MimeUtility.encodeText("�ļ�����.txt"));
			//�ٴΰ������岿��,��ӵ�������
			list.addBodyPart(part2);
			//���ø��ʼ���Ϊ�ʼ�������
			msg.setContent(list);
			/******************************************************************/
			//�����ʼ�
			Transport.send(msg);
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
	}
}

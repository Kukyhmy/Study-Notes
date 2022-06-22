package com.kevin.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Demo
{
	public static void main(String[] args) 
	{
		test1();
	}
	public static void test1()
	{
		//�õ�Session
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.qq.com");
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
}

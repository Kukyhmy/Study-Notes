package com.kevin.demo;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * ������ע����ʾ(application�������ڼ���)
 * */
@WebListener
public class AListener implements ServletContextListener
{
	public void contextDestroyed(ServletContextEvent arg0) 
	{
		System.out.println("Tomcat,�ر�����Ҳϵ3.0");
	}
	public void contextInitialized(ServletContextEvent arg0) 
	{
		System.out.println("Tomcat,������ϵ3.0");
	}
}

package com.kevin;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;
public class MyFirstServlet implements Servlet
{
	//��ʼ��Servlet--���ǰѸ�Serveletװ�ص��ڴ��С��ú���ֻ�ᱻ����һ�Ρ�
	public void init(ServletConfig config)throws ServletException
	{
		
	}
	//�õ�ServletConfig����
	public ServletConfig getServletConfig()
	{
		return null;
	}
	//�ú������Ƿ����������ǵ�ҵ���߼����롣����д������ġ��ú���ÿ�ζ��ᱻ���á�
	public void service(ServletRequest req,ServletResponse res)throws ServletException,java.io.IOException
	{
		//System.out.println("Hello World"+new SimpleDateFormat("yyyy��MM��dd��").format(new Date()));
		res.getWriter().println("Hello World	"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
	//�ú����ǵõ�Servlet��һЩ������Ϣ��
	public java.lang.String getServletInfo()
	{
		return null;
	}
	//�������Servlet�����ڴ�����������ú���������������ֻ�ᱻ����һ�Ρ�
	public void destroy()
	{
	
	}
}
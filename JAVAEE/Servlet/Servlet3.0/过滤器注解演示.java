package com.kevin.demo;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
 * Filterע����ʾ
 * */
@WebFilter(urlPatterns={"/AServlet","/AAServlet"})
public class AFilter implements Filter
{
	public void destroy() 
	{
		
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,FilterChain arg2) throws IOException, ServletException
	{
		System.out.println("����3.0��ע��,��������");
		arg2.doFilter(arg0, arg1);
	}
	public void init(FilterConfig arg0) throws ServletException 
	{

	}
}
/***
 * ��ͳ�����þͲ���ʾ��....����
 * */

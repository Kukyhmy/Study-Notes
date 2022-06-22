package com.kevin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet 
{
	/**
	 * ��get��ʽ����ҳ��ʱִ�иú���.
	 * ִ��doGetǰ����ִ��getLastModified��
	 * ������������getModified����ֵ����ֵ���ϴη���ʱ���ص���ֵ��ͬ
	 * ����Ϊ���ĵ�û�и��¡���������û��档����ִ��doGet
	 * ���getLastModified����-1������Ϊ��ʱ�̸��µġ�����ִ��doGet
	 * */
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		this.log("ִ��doGet����");//����servlet�Դ�����־�����Ϣ������̨
		this.execute(request,response);//����doGet
	}
	/**
	 * ��pos��ʽ����ҳ��ʱִ��doPost������ִ��ǰ����ִ��getLastModified
	 * */
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		this.log("ִ��doPost����");//����servlet�Դ�����־�����Ϣ������̨
		this.execute(request,response);
	}
	/**
	 * ���ظ�servlet���ɵ��ĵ�����ʱ�䡣��Get��ʽ������Ч�����ص�ʱ�������1970-1-1 08:00:00 �ĺ�����
	 * ���Ϊ-1�����ʾ��ʱʱ���¡�Ĭ�ϵ���-1
	 * */
	public long getLastModified(HttpServletRequest request)
	{
		this.log("ִ��getLastModified����");
		return -1;
	}
	/**
	 * ִ�з���
	 * */
	private void execute(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setCharacterEncoding("UTF-8");//����response�ַ�����
		request.setCharacterEncoding("UTF-8");//����request�ַ�����
		String requestURI = request.getRequestURI();//��ȡ-���ʸ�servlet��URI
		String method = request.getMethod();//��ȡ-���ʸ�servlet�ķ�ʽ.Get����Post
		String param = request.getParameter("param");//��ȡ-�ͻ����ύ��"param"ֵ
		response.setContentType("text/html");//����response���ĵ�����Ϊhtml����
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>FirstServlet</title></head>");
		out.println("<body>");
		out.println("��"+method+"�������ʸ�ҳ�档�յ���param����Ϊ"+param+"<br/>");
		out.println("<from action='"+requestURI+"'method='GET'>");
		out.println("<input type='text' name='param' value='param String'/>");
		out.println("<input type='submit' value='��Get��ʽ��ѯҳ��"+requestURI+"'/><br/>");
		out.println("</from>");
		out.println("<from action='"+requestURI+"' method='POST'>");
		out.println("<input type='text' name='param' value='param String'/>");
		out.println("<input type='submit' value='��post������ѯҳ��"+requestURI+"'/><br/>");
		out.println("</from>");
		//�ɿͻ����������ȡ���ĵ��ĸ���ʱ��
		out.println("<script>document.write('��ҳ�����µ�ʱ��:'+document.lastModified);</script>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
}

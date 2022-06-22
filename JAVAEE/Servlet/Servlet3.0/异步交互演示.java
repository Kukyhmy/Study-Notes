package com.kevin.demo;
import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet3.0֮,�첽������ʾ.
 * */
@WebServlet(urlPatterns="/NewServlet",asyncSupported=true)
public class NewServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, final HttpServletResponse response)throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=utf-8");//��������ñ���,���������첽ʧ��
		for(int x = 0;x <= 512 ;x++)
		{
			response.getWriter().print("a");
		}
		response.getWriter().flush();
		final AsyncContext ac = request.startAsync(request,response);
		ac.start(new Runnable()//�����ڲ���
		{
			public void run() 
			{
				println("���Ͽ�ʼ����<br/>",response);
				sleep(3000);//�߳�����
				for(char c = 'A';c <= 'Z';c++ )//���26��Ӣ����ĸ
				{
					println(c+",",response);
					sleep(250);//�߳�����
				}
				//֪ͨ������,�����Ѿ�������,Ҳ���ڲ�����ʾֲ�����,��Ҫ����final
				ac.complete();
			}
		});
	}
	/**
	 * ר����������ķ���
	 * */
	private void println(String str,HttpServletResponse response)
	{
		try 
		{
			response.getWriter().print(str);//��Ϊ�ڲ�����ʾֲ�����,�ֲ�������Ҫfinal����
			response.getWriter().flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void sleep(long l)
	{
		try 
		{
			Thread.sleep(l);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}

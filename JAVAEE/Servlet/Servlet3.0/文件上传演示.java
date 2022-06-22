package com.kevin.demo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 * Servlet3.0֮,�ϴ���ʾ
 * */
@WebServlet(urlPatterns="/NewServlet")
@MultipartConfig
public class NewServlet extends HttpServlet 
{
	/**
	 * ������doPost���� 
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");//������������,��Ҫ��Ҫ��ȡ�ַ���(�ļ�����)��ԭ��
		//1,getParameter();����ʹ����.��ȡ��ͨ����
		String username = request.getParameter("username");
		//2,��ȡ�ļ�����,���ֶ�
		Part p = request.getPart("pic");//���������ļ����ֶε�����,�ن���һ��,���Բ����ļ�������
		//3,��p�л�ȡ��Ҫ������
		System.out.println(p.getContentType());//��ȡ�ļ�����
		System.out.println(p.getSize());//��ȡ�ϴ��ļ��Ĵ�С,�ֽ���
		System.out.println(p.getName());//��ȡ�ϴ��ļ��ֶε�����
		String fileName = p.getHeader("Content-Disposition");//��ȡָ������ͷ��Ϣ,�������ϴ��ļ�������..ע��,��������ļ�������
		//�ļ����ƽ�ȡ
		int index = fileName.lastIndexOf("filename=\"")+10;
		fileName.substring(index, fileName.length()-1);
		//4,�����ļ�
		p.write("c:\\demo.jpg");
	}
}

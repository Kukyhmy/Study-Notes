/*
	��ʾ�ͻ��˺ͷ����
һ
	1���ͻ��ˣ������
	2������ˣ��Զ���
��
	1���ͻ��ˣ������
	2������ˣ�Tomcat������
��
	1���ͻ��ˣ��Զ���
	2������ˣ�Tomcat������
*/
import java.io.*;
import java.net.*;
class ServerDemo
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(11000);
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress());
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("<font color='read' size='70'>��ã��ͻ���</font>");
		s.close();
		ss.close();
	}
}
//����������뱾��IP��ַ:�˿ں�

//192.168.131.166
//GET / HTTP/1.1
//Host: 192.168.131.166:11000
//Connection: keep-alive
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0
/*.8
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko)
Chrome/32.0.1700.107 Safari/537.36
Accept-Encoding: gzip,deflate,sdch
Accept-Language: zh-CN,zh;q=0.8,en;q=0.6*/

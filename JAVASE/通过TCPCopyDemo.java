/*
	���ı��ļ��ϴ�����������Ȼ����������и��Ʊ���󡣷�����Ϣ���ͻ���
*/
import java.io.*;
import java.net.*;
class TextClient
{
	public static void main(String[] args)throws Exception
	{
		Socket s = new Socket("192.168.126.156",10006);
		BufferedReader bufr = new BufferedReader(new FileReader("Demo.java"));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		String line = null;
		while ((line = bufr.readLine())!=null)
		{
			out.println(line);
		}
		s.shutdownOutput();//�رտͻ�����������൱�ڸ����м�����һ��������ǣ� -1
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = bufIn.readLine();
		System.out.println(str);
		bufr.close();
		s.close();
	}
}
class TextServer
{
	public static void main(String[] args)throws Exception
	{
		ServerSocket ss = new ServerSocket(10006);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"����ing....");
		DataInputStream dis = new DataInputStream(s.getInputStream());
		long l = dis.readLong();
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(new FileWriter("server.txt"),true);
		String line = null;
		while ((line = bufIn.readLine()) != null)
		{
			out.println(line);
		}
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		pw.println("�ϴ��ɹ�");
		out.close();
		s.close();
		ss.close();
	}
}
class CopyDemo 
{
	public static void main(String[] args) 
	{
		
	}
}

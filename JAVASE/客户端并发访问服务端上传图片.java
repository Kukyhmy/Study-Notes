/*
 *�ͻ��ˣ�
 *1������˵�
 *2����ȡ�ͻ������е�ͼƬ���� 
 *3��ͨ�� socket ��������͸������
 *4����ȡ������˷�����Ϣ
 * */
import java.io.*;
import java.net.*;
class PicClient
{
	public static void main(String[] args)throws Exception
	{
		if(args.length != 1)
		{
			System.out.println("��ѡ��һ��jpg��ʽ��ͼƬ");
			return;
		}
		File file = new File(args[0]);
		if (!(file.exists() && file.isFile()))
		{
			System.out.println("���ļ�Ҫô�����ڣ�Ҫô��Ŀ¼");
			return;
		}
		if (!(file.getName().endsWith(".jpg")))
		{
			System.out.println("�ļ���ʽ���󡣲���jpg");
			return;
		}
		if (file.length() > 1024*1024*5)
		{
			System.out.println("�ļ����󡣲�����");
			return;
		}

		Socket s = new Socket("192.168.131.166",10000);//����socket����ָ�����ӵ�ַ
		FileInputStream fis = new FileInputStream(file);//�����ֽ�����������ȡӲ���ļ�
		OutputStream out = s.getOutputStream();//��ȡsocket�е������
		byte[] buf = new byte[1024];//����������
		int len = 0;
		while((len = fis.read(buf)) != -1)
		{
			out.write(buf,0,len);
		}
		s.shutdownOutput();//�������
		InputStream in = s.getInputStream();
		byte[] bufIn = new byte[1024];
		int num = in.read(bufIn);
		System.out.println(new String(bufIn,0,num));
		fis.close();
		s.close();
	}
}
/*
	�˷�����о����ԡ���A�ͻ��������ϣ��Ժ󡣱�����˻�ȡ���������ִ�о������̡������ʱB�ͻ������ӽ�����
	��ôֻ�еȴ����ͻ�A���߼����ﴦ����󡣲Ż���տͻ���B�Ĵ�������
	Ϊ�˿����ö���ͻ���ͬʱ�������ʷ����
	��ô�������þ��ǰ�ÿ���ͻ��˷�װ��һ���������߳��С���Ҳ�Ϳ���ͬ�´������ͻ�������

	��ζ����̣߳�
	ֻҪ��ȷ��ÿ���ͻ���Ҫ�ڷ����ִ�еĴ��뼴�ɡ����ô������run�����С�
*/
class PicThread implements Runnable
{
	private Socket s;
	PicThread(Socket s)
	{
		this.s = s;
	}
	public void run()
	{
		int counmt = 1;
		String ip = s.getInetAddress().getHostAddress();
		try
		{
			System.out.println(ip+"connected... ...");
			InputStream in = s.getInputStream();//��ȡ�ͻ��˵�socket�еĶ�ȡ������

			File file = new File("C:\\"+ip+"("+counmt+")"+".jpg");
			while(file.exists())
			{
				 file = new File("C:\\"+ip+"("+counmt+++")"+".jpg");
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = in.read(buf)) != -1)
			{
				fos.write(buf,0,len);
			}
			OutputStream out = s.getOutputStream();
			out.write("�ϴ��ɹ�".getBytes());
			fos.close();
			s.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(ip+"�ϴ�ʧ��");
		}
	}
}
class PicServer
{
	public static void main(String[] args)throws Exception
	{
		ServerSocket ss = new ServerSocket(10000);
		while(true)
		{
			Socket s = ss.accept();//�õ��ͻ���Socket����
			new Thread(new PicThread(s)).start();
		}
		//ss.close();
	}
}
public class Demo
{
	public static void main(String[] args)
	{
		
	}
}
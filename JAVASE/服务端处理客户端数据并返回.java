/*
	����˽��ͻ��˴��͵����ݡ�ת���ɴ�д�����ء�
	���ҿͻ��˿��Խ��в��ϵķ��͡����ͻ�������overʱ��ת��������
������
�ͻ��ˣ�
	�ͻ��˼�Ȼ�ǲ����豸�ϵ����ݣ���ô�Ϳ���ʹ��IO��������IO�Ĳ���������˼����
  Դ������¼��
Ŀ�ģ����������(�����豸)�����Ҳ��������ı����ݡ��ǾͿ���ѡ���ַ�����
���裺
1����������
2����ȡ����¼��
3�������ݷ��͸������
4����ȡ����˷��صĴ�д����
5���������ر���Դ
*/
import java.io.*;
import java.net.*;
class TransClient
{
	public static void main(String[] args)throws Exception
	{
		Socket s = new Socket("192.168.126.156",10005);
		//�����ȡ�������ݵ�������
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		//����Ŀ�ĵء�������д�� socket������������ͻ���
		BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		//����һ�� socket��ȡ������ȡ����˷��صĴ�д��Ϣ��
		BufferedReader bufin = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
			{
				break;
			}
			bufwOut.write(line);
			bufwOut.newLine();
			bufwOut.flush();
			String str = bufin.readLine();
			System.out.println("������"+str);
		}
		bufr.close();
		s.close();
	}
}
/*
����ˣ�
Դ��socket ��ȡ��
Ŀ�ģ�socket �����
�����ı�������װ���ࡣ
*/
class TransServer
{
	public static void main(String[] args)throws Exception
	{
		ServerSocket ss = new ServerSocket(10005);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"------����ing");
		//��ȡsocket��ȡ���е�����
		BufferedReader bufin = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//Ŀ�� socket�����������д����д�뵽socket������������͸��ͻ���
		BufferedWriter bufout = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		String line = null;
		while ((line = bufin.readLine()) != null)
		{
			bufout.write(line.toUpperCase());
			bufout.newLine();
			bufout.flush();
		}
		s.close();
		ss.close();
	}
}
class Demo1 
{
	public static void main(String[] args) 
	{
		
	}
}
//��������ֵ�����
/*
	���󣺿ͻ��˺ͷ���˶���Ī���ĵȴ���
	��Ϊ���ͻ��˺ͷ���˶�������ʽ��������Щ����û�ж�����ǡ��ͻ�һֱ���ڵȴ�״̬���������˶��ڵȴ���
*/

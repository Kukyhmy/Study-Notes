import java.io.*;
import java.util.*;
public class Demo
{
	static Scanner s = new Scanner(System.in);
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args)
	{
		start();
	}
	public static void start()
	{
		sop("**************��ӭʹ���ռ�ϵͳ**************");
		sop("����write[��ʼд�ռǻس�����]quite[�˳�ϵͳ]look[�鿴�ռ�]");
		while (true)
		{	
			String s1 = s.next();
			if(s1.equals("write"))
			{
				sop("�����ϴε��ռ�?[yes |   no]");
				String s2 = s.next();
				if(s2.equals("yes"))
				{
					start1();
				}
				else if(s2.equals("no"))
				{
					start2();
				}
				else
				{
					sop("�������");
				}
				
			}
			else if(s1.equals("look"))
			{
				look();
			}
			else if(s1.equals("quite"))
			{
				sop("��ӭ�´�ʹ��");
				break;
			}
			else
			{
				sop("������������������");
			}
		}
	}
	public static void start1()
	{
		BufferedWriter bufw = null;
		Scanner s = new Scanner(System.in);
		try
		{
			bufw = new BufferedWriter(new FileWriter("D:\\�ռ�.txt"));
			sop("�뿪ʼ�����ռ����ݰ�.����exit�˳���¼ϵͳ");
			while(true)
			{
				String riji = s.next();
				if(riji.equals("exit"))
				{
					break;
				}
				bufw.write(riji);
				bufw.newLine();
				bufw.flush();
			}
			sop("��¼��ϡ��˳���¼ϵͳ");
			start();
		}
		catch (IOException e)
		{
			sop(e.toString());
		}
		finally
		{
			try
			{
				if(bufw != null)
				{
					bufw.close();
				}
			}
			catch (IOException e)
			{
				sop(e.toString());
			}
		}
	}
	public static void start2()
	{
		BufferedWriter bufw = null;
		Scanner s = new Scanner(System.in);
		try
		{
			bufw = new BufferedWriter(new FileWriter("D:\\�ռ�.txt",true));
			sop("�뿪ʼ�����ռ����ݰ�.����exit�˳���¼ϵͳ");
			while(true)
			{	
				String riji = s.next();
				if(riji.equals("exit"))
				{
					break;
				}
				bufw.write(riji);
				bufw.newLine();
				bufw.flush();
			}
			sop("��¼��ϡ��˳���¼ϵͳ��");
			start();
		}
		catch (IOException e)
		{
			sop(e.toString());
		}
		finally
		{
			try
			{
				if(bufw != null)
				{
					bufw.close();
				}
			}
			catch (IOException e)
			{
				sop(e.toString());
			}
		}
	}
	public static void look()
	{
		BufferedReader bufr = null;
		try
		{
			bufr = new BufferedReader(new FileReader("D:\\�ռ�.txt"));
			String s = null;
			while ((s = bufr.readLine()) != null)
			{
				sop(s);
			}
			sop("--------�ռ���ʾ���---------");
			start();
		}
		catch (IOException e)
		{
			sop(e.toString());
		}
		finally
		{
			try
			{
				if (bufr != null)
				{
					bufr.close();
				}
			}
			catch (IOException e)
			{
				sop(e.toString());
			}
		}
	}
}
/*
1,��ָ����Ŀ¼���еݹ�
2,��ȡ�ݹ�������е�java�ļ�·��
3,����Щ·���洢��������
4,�������е�����д�뵽һ���ļ���
*/
import java.io.*;
import java.util.*;
public class Demo
{
	public static void main(String[] args)throws IOException
	{
		//�������ڱ����¼���ļ���
		File fi = new File("D:\\TXT�ļ�����.txt");
		if(fi.exists())
		{
			System.out.println("�ļ��Ѵ��ڣ���������");
			throw new RuntimeException();
		}
		else
		{
			fi.createNewFile();
		}
		//������Ҫ���������ҵ��ļ���
		File f = new File("D:\\Program Files");
		//���������������ڱ����Ѿ��ҵ���File���͵��ļ�
		ArrayList<File> al = new ArrayList<File>();
		fileToList(f,al);
		writeToFile(al,fi);
		
	}
	public static void writeToFile(List<File> list,File f)throws IOException
	{
		BufferedWriter bufw = null;
		try
		{
			bufw = new BufferedWriter(new FileWriter(f));
			for (File fis : list )
			{
				String str = fis.getAbsolutePath();
				bufw.write(str);
				bufw.newLine();
				bufw.flush();
			}
		}
		catch (IOException e)
		{
			throw e;
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
				throw e;
			}
		}
	}
	public static void fileToList(File dir,List<File> list)
	{
		File[] files = dir.listFiles();
		for (File file : files )
		{
			if (file.isDirectory())
			{
				fileToList(file,list);
			}
			else
			{
				if(file.getName().endsWith(".txt"))
				{
					list.add(file);
				}
			}
		}
	}
}
import java.io.*;
import java.util.*;
public class Demo
{
	public static void main(String[] args)
	{
		File f = new File("F:\\�ʼ�");
		File[] files = f.listFiles();
		ArrayList al = new ArrayList();
		String e = ".sql";
		int num = 0;
		for(File fie : files)
		{
			String s = fie.getName();
			if(s.endsWith(e))
			{
				num++;
				al.add(fie);
			}
		}
		System.out.println(e+"���͵��ļ�һ����"+num+"��,�ֱ�����");
		for(int x = 0;x < al.size();x++)
		{
			File fil = (File)al.get(x);
			System.out.print(fil.getName()+"	");
		}
	}
}
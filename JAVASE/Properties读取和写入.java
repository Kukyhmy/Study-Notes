package Demo;
import java.io.*;
import java.util.*;
public class Demo
{
	public static void main(String[] args) throws IOException
	{
		Properties prop = new Properties();
		File file = new File("D:\\Connt.ini");//���������ļ�
		if(!(file.exists()))//�ж�Ŀ���ļ��Ƿ���ڡ���������ھͽ�����ȷ�������IO�����ᱨ�쳣
		{
			file.createNewFile();
		}
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);//��ȡ�����ļ���Ϣ
		int count = 0;
		String value = prop.getProperty("time");//����time������ȡ��Ӧ��ֵ��
		if(value!=null)
		{
			count = Integer.parseInt(value);
			if(count >= 5)
			{
				System.out.println("��ã��������ʹ�ô����ѵ�����Ǯ");.//������ʹ�ô����Ĳ�����
				return;
			}
		}
		count++;
		prop.setProperty("time",count+"");//�޸�ָ������ֵ��
		FileOutputStream fos = new FileOutputStream(file);
		prop.store(fos,"ע����Ϣ");//д�������(�����ļ������)--Դ�ļ��Ѿ����޸Ĺ���
		fos.close();
		fis.close();
	}
}
import java.io.*;
import java.util.*;
public class Demo
{
	public static void main(String[] args) throws IOException
	{
		splitFile();	//�и��ļ�
		merge();		//�ϲ��ļ�
	}
	public static void splitFile() throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\aaa.ppt");//һ���ֽڶ�ȡ����Դ�ļ��������
		FileOutputStream fos = null;//����һ���ֽ��������
		int num = 1;//����һ����������֤�ļ��Ķ����ԣ���������
		byte[] buf = new byte[1024*1024];//������
		int len = 0;//��ȡ�����ݳ���
		while((len = fis.read(buf)) != -1)
		{
			fos = new FileOutputStream("C:\\"+(num++)+".part");//����һ���ļ������и����Ƭ��
			fos.write(buf,0,len);//д���ļ�
			fos.close();
		}
		fis.close();
	}
	public static void merge()throws IOException
	{
		Vector<InputStream> v = new Vector<InputStream>();//��������
		v.add(new FileInputStream("D:\\1.part"));//����Ƭ�Ķ�ȡ����ӵ�����
		v.add(new FileInputStream("D:\\2.part"));
		v.add(new FileInputStream("D:\\3.part"));
		v.add(new FileInputStream("D:\\4.part"));
		v.add(new FileInputStream("D:\\5.part"));
		v.add(new FileInputStream("D:\\6.part"));
		v.add(new FileInputStream("D:\\7.part"));
		v.add(new FileInputStream("D:\\8.part"));
		Enumeration<InputStream> en = v.elements();//������ȡ������
		SequenceInputStream  sis = new SequenceInputStream(en);//�ѵ�������Ϊ�������ݸ��ϲ���
		
		OutputStream fos = new FileOutputStream("C:\\text.ppt");//����Ŀ���ļ�
		byte[] buf = new byte[1024];//������
		int len = 0;
		while((len = sis.read(buf)) != -1)
		{
			fos.write(buf,0,len);//д������
			fos.flush();//ˢ��
		}
		fos.close();
		sis.close();
	}
}
import java.util.*;
import java.util.concurrent.*;
public class Demo
{
	public static void main(String[] args)
	{
		//�����̳߳ض���,����Ĳ�����Լ����Ҫ���Ƶ��߳�����
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.submit(new Runnable(){public void run(){}});//�����ڲ���ʵ��Runnable�ӿڵ�����-�߳�1
		pool.submit(new Runnable(){public void run(){}});//�����ڲ���ʵ��Runnable�ӿڵ�����-�߳�2
		pool.shutdown();//�ر��̳߳ء��������µ��߳��Լ�����
	}
}
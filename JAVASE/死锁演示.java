
/*
 *�����������������ϵ��̡߳���������Դ�Ĺ����С�������һ���໥�ȴ������� 
 */
public class DieLockDemo extends Thread
{
	private boolean flag;
	public DieLockDemo(boolean flag)
	{
		this.flag = flag;
	}
	public void run()
	{
		if(flag)
		{
			synchronized(MyLock.objA)
			{
				System.out.println("IF��䣬OBJA��");
				synchronized(MyLock.objB)
				{
					System.out.println("IF��䣬OBJB��");
				}
			}
		}
		else
		{
			synchronized(MyLock.objB)
			{
				System.out.println("ELSE��䣬OBJB��");
				synchronized(MyLock.objA)
				{
					System.out.println("ELSE��䣬OBJA��");
				}
			}
		}
	}
	public static void main(String[] args)
	{
		DieLockDemo d1 = new DieLockDemo(true);
		DieLockDemo d2 = new DieLockDemo(false);
		d1.start();
		d2.start();
	}
}
class MyLock //����������
{
	public static final Object objA = new Object();
	public static final Object objB = new Object();
}


/*class MainBoard
{
	public void run()
	{
		System.out.println("��������");
	}
	public void useNetCard(NetCard c)
	{
		c.open();
		c.close();
	}
}
class NetCard
{
	public void open()
	{
		System.out.println("��������");
	}
	public void close()
	{
		System.out.println("�����ر�");
	}
}*/
interface PCI
{
	public void open();
	public void close();
}
class MainBoard
{
	public void run()
	{
		System.out.println("��������");
	}
	public void usePCI(PCI p)//�ӿ�������ָ���Լ����������
	{
		if (p!=null)
		{
			p.open();
			p.close();
		}
	}
}
class NetCard implements PCI
{
	public void open()
	{
		System.out.println("��������");
	}
	public void close()
	{
		System.out.println("�����ر�");
	}
}
class SoundCard implements PCI
{
	public void open()
	{
		System.out.println("��������");
	}
	public void close()
	{
		System.out.println("�����ر�");
	}

}
public class Demo
{
	public static void main(String[] args)
	{
		MainBoard mb = new MainBoard();
		mb.run();
		mb.usePCI(null);
		mb.usePCI(new NetCard());
		mb.usePCI(new SoundCard());
	}
}
package myjava;
interface Inter
{
	void method();
}
class Test 
{
	static class Inner implements Inter   //����������ֵ��ڲ���
	{
		public void method()
		{
			System.out.println("�����ֵ��ڲ���");
		}
	}
	static public Inter function()
	{
		return new Inter(){				//���ruturn������һ���������ڲ��ࡣ
			public void method()
			{
				System.out.println("�����ڲ���");
			}
		};
	}
}
public class Demo
{
	public static void main(String[] args)
	{
		new Test.Inner().method();//�����ֵ��ڲ��෽������
		Test.function().method();//�����ڲ���ķ�������
		//���ȡ�������롣����Ȼ��Test���ڵ���һ��static��Ա�����ҡ�
		//���������.method();����Ȼ������������һ��������Ϊ�ڵ������������
	}
}
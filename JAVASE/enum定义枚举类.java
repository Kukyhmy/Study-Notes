enum Season implements Info //��ö����ʵ�ֽӿ�
{	
	//�������󣬶������֮����,���������һ����;��β��
	SPRING("����","��ů����")
	{
		public void show()
		{
			System.out.println("����");
		}
	},
	SUMMER("����","��������")
	{
		public void show()
		{
			System.out.println("����");
		}
	},
	AUTUME("����","�����ˬ")
	{
		public void show()
		{
			System.out.println("����");
		}
	},
	WINTER("����","�캮�ض�")
	{
		public void show()
		{
			System.out.println("����");
		}
	};
	private final String name ;
	private final String desc;
	private Season(String name,String desc)
	{
		this.name = name;
		this.desc = desc;
	}

	public String getName() 
	{
		return name;
	}
	public String getDesc() 
	{
		return desc;
	}
	public void get()
	{
		System.out.println(this.name);
	}
}
interface Info//������һ���ӿ�
{
	abstract void show();
}
public class Demo
{
	public static void main(String[] args)
	{
		//��ȡ��ö��������ж���.�Ը����������ʽ���ڡ�
		Season[] s1 = Season.values();
		for(Season s : s1)
		{
			System.out.println(s);
		}
		//��ȡָ�����ƵĶ���Ҫ����Ĳ�����Ҳ���Ƕ�����Ҫ���Ǵ��ڵġ�����֮�䱨��
		Season s2 = Season.valueOf("SPRING");
		s2.show();
		s2.get();
		Season s3 = Season.valueOf("SUMMER");
		s3.get();
	}
}
class Season//������
{
	//ö���࣬�������е����ơ�
	//1,�ṩ�����ѧ������final,private
	private final String name ;//����
	private final String desc;//����
	private Season(String name,String desc)
	{
		//2�ڹ������н��г�ʼ����һ����ʼ�����ܱ��޸ġ�
		this.name = name;
		this.desc = desc;
	}
	//3����ö����Ķ���
	public static final Season SPRING = new Season("����","��ů����");
	public static final Season SUMMER = new Season("����","��������");
	public static final Season AUTUME = new Season("����","�����ˬ");
	public static final Season WINTER = new Season("����","�캮�ض�");
	//4ͨ�������������������ԡ�
	public String getName() 
	{
		return name;
	}
	public String getDesc() 
	{
		return desc;
	}
	public void show()
	{
		System.out.println("����һ������");
	}
}
public class Demo
{
	public static void main(String[] args)
	{
		Season s = Season.SPRING;
		System.out.println(s.getDesc());
	}
}
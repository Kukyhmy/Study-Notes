
import java.lang.reflect.*;
class Person 
{
	public String name;
	int id;
	private int age;
	Person(String name,int id,int gae)
	{
		this.name = name;
		this.id = id;
		this.age = age;
	}
	Person()
	{
		
	}
	private void pri()
	{
		System.out.println("����privateȨ�޷���");
	}
	public static void sta()
	{
		System.out.println("����һ����̬�ķ���");
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public void show()
	{
		System.out.println("Im man");
	}
	public void display(String nation)
	{
		System.out.println("������"+nation);
	}
	public String toString()
	{
		return "Person[name="+this.name+",age="+this.age+",id="+this.id+"]";
	}
}

public class Demo
{
	public static void main(String[] args) throws Exception
	{
//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
		test6();
	}
	//�������������˼ά��ȡ���Ա
	public static void test1()
	{
		Person p = new Person();
		p.setAge(21);
		p.setName("kevin");
		System.out.println(p.toString());
		p.show();
		p.display("�쳯"); 
	}
	//ͨ�������ȡ���Ա
	public static void test2() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException
	{
		//���� cla  ��Ӧ������ʱ��Person��Ķ���
		Class cla = Person.class;
		Person p = (Person)cla.newInstance();
		System.out.println(p);
		Field f1 = cla.getField("name");
		f1.set(p, "Litch");
		System.out.println(p);
		
		Field f2 = cla.getDeclaredField("age");
		f2.setAccessible(true);//����˽�б���
		f2.set(p, 22);
		System.out.println(p);
		
		
		Method m1 = cla.getMethod("show");//��ȡ����
		m1.invoke(p);
		Method m2 = cla.getMethod("display",String.class);
		m2.invoke(p,"����");
	}
	public static void test3()
	{
		Person p = new Person();
		Class cl = p.getClass();//ͨ������ʱ��Ķ��󡣵�����getClass����������������ʱ����ࡣ
		System.out.println(cl);
	}
	//��ȡ�������
	public static void test4() throws Exception
	{
		ClassLoader loader1 = ClassLoader.getSystemClassLoader();//��ȡ�������
		System.out.println(loader1);
		ClassLoader loader2 = loader1.getParent();//��ȡ���ĸ���
		System.out.println(loader2);
		ClassLoader loader3 = loader2.getParent();//��ȡ������������---ֱ����null��ϵͳ�������ģ�
		System.out.println(loader3);	
		Class cls = Person.class;
		ClassLoader loader4 = cls.getClassLoader();//��ȡ�����Զ����࣬�����������
		System.out.println(loader4);
		String className="java.lang.Object";	
		Class cla = Class.forName(className);	
		ClassLoader loader5 = cla.getClassLoader();//��ȡObject��ļ�����
		System.out.println(loader5);				//����Ȼ��Object�����ں����ࡣ���ò��������������ص��Ǹ�null��
	}
	//��ȡ������ġ��������ԣ������и�ֵ�����ȣ�
	public static void test5()throws Exception
	{
		Class cls = Person.class;
		Person p = (Person)cls.newInstance();//�½�class�ļ�����
		//��ȡpublic���Եĳ�Ա�����и�ֵ������
		Field name = cls.getField("name");//��ȡname���ԡ������Ե�Ȩ�޵��� public
		name.set(p,"Kevin");//ָ������ʱp��������name���Ը�ֵ.
		System.out.println(p);//��ӡ�������
		//��ȡprivate���Եĳ�Ա�����и�ֵ������
		Field age = cls.getDeclaredField("age");//��ȡage���ԡ�ע�������age����private .��ȡ��ʽ������������ͬ
		age.setAccessible(true);//����˽������Ϊ�ɷ��ʵġ�
		age.set(p, 21);//�ٸ�p�����age���Ը�ֵ��������������ÿɷ��ʡ���ô��ֵ���׳��쳣��
		System.out.println(p);//��ӡ�������
		//��ȡĬ�����Եĳ�Ա�����и�ֵ������
		Field id = cls.getDeclaredField("id");  //������ΪĬ��Ȩ�ޡ�ҲҪͨ��ר�� ��ȡprivate���ε����Եķ�������ȡ��
		id.setAccessible(true);	//ҲҪ�������ã��ɷ��ʡ�
		id.set(p,1);//��p�����  id ���и�ֵ������ͬ��Ҳ��Ҫ��һ�������ò�������Ȼ�ᱨ�����쳣��
		System.out.println(p);//��ӡ������ΪP����������Ѿ���д��toString();���������лᰴ���Զ��巽�������д�ӡ��
	}
	//��ȡ������ġ����󡣷��������в���
	public static void test6()throws Exception
	{
		Class cls = Person.class;
		Person p = (Person)cls.newInstance();//����Class����������������
		Method m1 = cls.getMethod("show");//��ȡ����������ֽ���show�ķ�����������������Ǹ��ղ�����
		Object returnValue = m1.invoke(p);//���������������Ϊû�в�������ô��ָ��������������Ķ�������ˡ������ٺ�����ϲ����������û�з���ֵ����ô���صľ���һ��null����
		System.out.println(returnValue);//��ӡ����ֵ��null����Ϊ��������������void�޷���ֵ
		Method m2 = cls.getMethod("toString");//��ȡ����з���ֵ�ķ�����û�в���
		String s = (String)m2.invoke(p);//���е�ʱ�򣬻᷵��һ��String���͵ķ���ֵ
		System.out.println(s);//��ӡ����ֵ��
		Method m3 = cls.getMethod("sta");//��ȡ������еľ�̬����(static)���ղ���
		m3.invoke(Person.class);//��Ϊ��һ����̬�ġ����е����߿���ֱ��������࣡��Ȼ��Ҳ�����Ƕ���
		Method m4 = cls.getDeclaredMethod("pri");//��ȡ������е�һ��˽�л����� private������ȡ˽�л���Ա����һ������Ҫ�ض��ķ�����
		m4.setAccessible(true);//�������˽�л����������Ա����ʡ�
		m4.invoke(p);//ָ��һ������ȥ�������˽�л�������
		//һ�㣬�����֪�������õķ������������Եķ���Ȩ�ޣ���ô�Ϳ���ֱ��ʹ�õڶ��֡�ר�����˽�л���Ա�Ĳ������������в�����
	}
	//ָ����Ĺ��캯����ʵ��������
	public static void test7()throws Exception
	{
		
	}
}
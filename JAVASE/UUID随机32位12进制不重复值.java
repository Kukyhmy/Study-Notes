import java.util.UUID;

/**
 * UUID
 * */
public class Demo
{
	public static void main(String[] args)
	{
		run();
	}
	public static void run()
	{
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString();
		s = s.replace("-", "");//��Ϊ���ɳ�������"-"������š������滻�ɿ��ַ���
		System.out.println(s);
	}
}
/*
  ȥ���ַ������˵Ŀո� 
  ��ת�ַ���
  ��תıһ�����ַ���
 */
public class Demo
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args)
	{
		String str = "   abcde    ";
		sop("["+str+"]");	
		//str = myTrim(str);
		//sop("["+str+"]");
		str = fanZhuan(str);
		sop("["+str+"]");
		str = fanZhuan(str,4,6);
		sop("["+str+"]");
	}
	public static String myTrim(String str)//ȥ���ո�
	{
		int start = 0,end = str.length() - 1;
		while(start <= end && str.charAt(start)==' ')
		{
			start++;
		}
		while(start <= end && str.charAt(end)==' ')
		{
			end--;
		}
		return str.substring(start,end+1);
	}
	public static String fanZhuan(String str)//��ת�ַ���
	{
		char[] ch = str.toCharArray();
		reverse(ch);
		return new String(ch);
	}
	private static void reverse(char[] ch)//�����ַ�����
	{
		for(int start = 0,end = ch.length-1;start < end;start++,end--)
		{
			swap(ch,start,end);
		}
	}
	public static void swap(char[] ch,int x,int y)//���������Ա
	{
		char temp = ch[x];
		ch[x] = ch[y];
		ch[y] = temp;
	}
	public static String fanZhuan(String str ,int start,int end)//ֻ��ת�����ַ�����������
	{
		char[] ch = str.toCharArray();
		reverse(ch,start,end);
		return new String(ch);
	}
	private static void reverse(char[] ch,int x,int y)//���������ַ����顣��������
	{
		for(int start = x,end = y-1;start < end;start++,end--)
		{
			swap(ch,start,end);
		}
	}
}

































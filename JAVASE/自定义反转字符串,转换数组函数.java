/*
���ַ�����ת����
1�����ַ����������
2�������鷴ת
3�����������ַ���
*/
public class Demo
{
	public static void sop(String s)
	{
		System.out.println(s);
	}
	public static void main(String[] args)
	{
		String s = "KevinBlandy";
		sop("["+s+"]");
		sop("["+getString(s)+"]");
		String s1 = getString(s);
		sop("["+getString(s1)+"]");//�ٶȰ�s1���з�ת����
	}
	public static String getString(String s)
	{
		char[] chs = s.toCharArray();
		reverse(chs);
		return new String(chs);
	}
	private static void reverse(char[] arr)
	{
		for(int start = 0,end = arr.length-1;start<end;start++,end--)
		{	
			swap(arr,start,end);
		}
	}
	private static void swap(char[] arr,int x,int y)
	{
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
/*
 * ��ӡ�����ַ�����ÿ����ĸ���ֵĴ�����
 * ���ҽ��������ӡ(����Ȼ����������-TreeMap)
 * Ҳ��ʾ��һ�����⡣ʲôʱ��ʹ��Map���ϡ�
 * 	����������֮�����ӳ���ϵʱ���Ϳ���ʹ��Map���ϡ�
 * */
import java.util.*;
public class Demo
{
	public static void main(String[] args)
	{
		String str = "asdiwqindiowndinlkandkandjuwqbfkfnaknfwiqn";
		String s = charCount(str);
		System.out.println(s);
	}
	public static String charCount(String str)
	{
		char[] chs = str.toCharArray();
		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();
		int count = 0;
		for(int x = 0;x < chs.length;x++)
		{
			if(!(chs[x] >= 'a' && chs[x] <= 'z'|| chs[x] >= 'A' && chs[x]<='Z'))
			{
				//�ж��Ƿ�Ϊ���š�����ǲ��ǣ��Ƿ���(���Ƿ���)ֱ�Ӽ�����һ��ѭ����
				continue;
			}
			Integer value = tm.get(chs[x]);
			if(value != null)
			{
				count = value;
			}
			count++;
			tm.put(chs[x], count);
			count = 0;
			/*
			if(value==null)
			{
				tm.put(chs[x],1);
			}
			else
			{
				value = value + 1;
				tm.put(chs[x],value);
			}*/
		}
		System.out.println(tm);
		StringBuilder sb = new StringBuilder();
		Set<Map.Entry<Character,Integer>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Character, Integer>> it = entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<Character, Integer> me = it.next();
			Character ch = me.getKey();
			Integer value = me.getValue();
			sb.append(ch+"("+value+")");
		}
		return sb.toString();
	}
}
import java.util.*;
class PockerDemo 
{
	public static void main(String[] args) 
	{
		HashMap<Integer,String> hs = new HashMap<Integer,String>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		String[] colors = {"����","����","÷��","����"};
		String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2",};
		int index = 0;
		for (String number : numbers )
		{
			for(String color : colors)
			{
				String poker = color.concat(number);
				hs.put(index,poker);
				al.add(index);
				index++;
			}
		}
		hs.put(index,"С��");
		al.add(index);
		index++;
		hs.put(index,"����");
		al.add(index);
		Collections.shuffle(al);
		TreeSet<Integer> kevin = new TreeSet<Integer>();
		TreeSet<Integer> rocco = new TreeSet<Integer>();
		TreeSet<Integer> litch = new TreeSet<Integer>();
		TreeSet<Integer> three = new TreeSet<Integer>();
		for (int x = 0;x < al.size() ;x++ )
		{
			if(x > al.size() - 4)
			{
				three.add(al.get(x));
			}
			else if (x%3 == 0)
			{
				kevin.add(al.get(x));
			}
			else if (x%3==1)
			{
				rocco.add(al.get(x));
			}
			else if(x%3==2)
			{
				litch.add(al.get(x));
			}
		}
		showPoker("Kevin",kevin,hs);
		showPoker("Rocco",rocco,hs);
		showPoker("Litch",litch,hs);
		showPoker("����",three,hs);
	}
	public static void showPoker(String name,TreeSet<Integer> ts,HashMap<Integer,String> hs)
	{
		System.out.print(name+"������:");
		for (Integer key : ts )
		{
			String value = hs.get(key);
			System.out.print(value+" ");
		}
		System.out.println();
	}
}

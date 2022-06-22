abstract class Animal
{
	abstract void eat();
}
class Cat extends Animal
{
	public void eat()
	{
		System.out.println("Cat�าд����ĳ��󷽷�.�����Լ���eat��ʽ");
	}
	public void catchMose()
	{
		System.out.println("Cat is catchMose");
	}
}
class Dog extends Animal
{
	public void eat()
	{
		System.out.println("Dog�าд����ĳ��󷽷���ʵ���Լ���eat��ʽ");
	}
	public void play()
	{
		System.out.println("Dog is play");
	}
}
class Pig extends Animal
{
	public void eat()
	{
		System.out.println("Pig�าд������󷽷���ʵ���Լ���eat��ʽ");
	}
	public void sleep()
	{
		System.out.println("Pig is sleep");
	}
}
class Test
{
	public void getAnimal(Animal a)
	{
		if (a instanceof Cat)
		{
			Cat c = (Cat)a;
			c.catchMose();
		}
		else if (a instanceof Dog)
		{
			Dog d = (Dog)a;
			d.play();
		}
		else if (a instanceof Pig)
		{
			Pig p = (Pig)a;
			p.sleep();
		}
	}
}
public class Demo
{
	public static void main(String[] args)
	{
		Test t = new Test();
		t.getAnimal(new Pig());
	}
}










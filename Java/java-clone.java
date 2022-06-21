----------------------------
Java�������ǳClone			|
----------------------------
	* ǳclone��ֻ�Ǽ򵥵İɶ��������copy��clone������,���������������ͬ���Զ�ָ����ͬһ����ַ
	* ��clone��clone��������ԣ����´��������ԣ���Դ��������Ը��ƹ���
	*  ��̸̸clone()����
	* ���Ƕ����� Object ����ķ�����Java�����κζ����ܵ��ã��������Ǳ�protected����
		protected native Object clone() throws CloneNotSupportedException;
	*  Ҳ����˵�������Լ������Ķ���û��ֱ�ӵ��ø÷�������Ϊ�Լ��������û����Object��ͬһ������
	*  ����Ҫ��д���÷������ڸ�д�����е���Object�ķ��������clone��cloneϸ�ڲ��ù��ģ���Ϊ����һ��native���ط�����
	* ����clone�������࣬����Ҫʵ��Cloneable�ӿڣ��ýӿڸ�Serializableһ����ֻ��һ����ǽӿڣ����κγ��󷽷�

----------------------------
ǳclone						|
----------------------------
	import java.util.Date;
	class Foo implements Cloneable {
		public Date date;
		Foo(Date date){
			this.date = date;
		}
		@Override
		protected Object clone() throws CloneNotSupportedException {
			//���ø���ı��ط��������ǳclone�Ķ���
			return super.clone();
		}
	}
	public class Main {
		public static void main(String[] args) throws CloneNotSupportedException {
			Foo foo = new Foo(new Date());
			Foo cloneFoo = (Foo) foo.clone();
			System.out.println(foo == cloneFoo);                //false
			System.out.println(foo.date == cloneFoo.date);        //true��ǳclone,�������date��ʵ����ͬһ����
		}
	}
----------------------------
��clone						|
----------------------------
	import java.util.Date;
	class Foo implements Cloneable {
		public Date date;
		Foo(Date date){
			this.date = date;
		}
		@Override
		protected Object clone() throws CloneNotSupportedException {
			//ǳclone Foo����
			Foo cloneFoo = (Foo) super.clone();
			//ǳclone Date�����ԣ�����
			Date cloneDate = (Date) date.clone();
			//��clone���
			cloneFoo.date = cloneDate;
			return cloneFoo;
		}
	}
	public class Main {
		public static void main(String[] args) throws CloneNotSupportedException {
			Foo foo = new Foo(new Date());
			Foo cloneFoo = (Foo) foo.clone();
			System.out.println(foo == cloneFoo);                //false
			System.out.println(foo.date == cloneFoo.date);        //false
		}
	}

�����ģʽԭ��ģ����clone�õö�
��ʵ���ǰ�һ��������и��ƣ����Ƴ����Ķ��󣬾�ӵ����ԭ������������Ժͷ��������ҿ��Ի��ڸö��������ǿ���޸ģ����Ҳ���Ӱ��ԭ����
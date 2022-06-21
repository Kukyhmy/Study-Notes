----------------------------
JAVA8������					|
----------------------------
	* JDK5��һ����̱��ĵ���,��ôJDK8Ҳ����������̱��ĵ�����
	* ������
		1,Lamda���ʽ
		2,Nashorn JavaScript����
		3,�µ�������ʱ��API
		4,һ�׼��������ļ�
		5,��JVM��ȥ����'���ô�(permanent generation)'
		6,��ǿ��ע�⹦��
	* ѧϰ��վ
		http://blog.csdn.net/ioriogami/article/details/12782141/

		http://www.jb51.net/article/48304.htm
	
		http://www.importnew.com/11908.html#methodReferences
	* ֪ʶ��
		* Lambda����,�﷨,ע��
		* Ԥ���� Lambda �����ӿ�
		* ��������
		* ����Lambda���ʽ

----------------------------
Lambda-��ʶ					|
----------------------------
	* Lamda���ʽ,��һ�ֻ��ں����ı������.
	* ���͵Ĵ������Haskell,������Ծ��ǻ��ں����ı������
	* ��JAVA���翪ʼ,�ᳫ�Ķ������������
	  Ҳ����˵,���еĹ��ܶ�����ʼ����,���ǰѹ���д������
	  ����,�ܶ�ϰ���˺�����̵Ŀ����߾;��ò�����.�����ڴ�Լ20���,java���Ƴ���Lamda���ʽ
	* ����Ҫ��ȷ����,����������Ladma���ʽ����֮����л��ں����ı��.��ʵ֮ǰJAVA�;߱�,ֻ��ʵ�ֵķ�ʽ��һ��
	* ��ʵ�����ʵ�ַ�ʽ���Ǵ�˵�е�:�����ڲ���
		interface Test{
			void test(String str);
		}
		public class Main{
			public static void main(String[] args){
				new Test(){
					public void test(String str) {
						System.out.println(str);
					}
				} .test("���");
			}
		}
	* Ladam���ʽ
		package com.kevin.main;
		interface Test{
			void test(String str);
		}
		public class Main{
			public static void main(String[] args){
				Test test = (str)-> System.out.println(str);
				test.test("���");
			}
		}
		* ����Ȼ,ʹ����Ladam���ʽ��,����������
	*��(str)-> System.out.println(str);  ���
		1,(str)			//��������,��������,���Ǹ�������ӿڷ�������ķ���һ��,���ý����������͵�����
			* ׷���������û�,�����ֶ�����������
			* Test test = (String s)-> System.out.println(s);
		2,->			//�̶��﷨,��ʾ�����ǵĲ���ָ�����ǵķ�����
		3,System.out...	//������
			* ��ʵ������û�����ڱ�д�����ڲ���ķ���ʵ�ִ���
			* ������Բ���(����),���������д��ݽ��еı���
			* ��ʹ��Ladma���ʽ��ʱ��,��һ���ǳ���Ҫ��Ҫ��.
	  '�ӿ�����,ֻ�ܶ���һ�����󷽷�'
	* ��ʵLamda���ʽ����Ҫ��Ŀ�ľ��ǽ�������ڲ��������,˳�����յ㿪����Ա

----------------------------
Lambda-���ʽ	���		|
----------------------------
	* Lamda���﷨������������
		1,�����б�
		2,��ͷ����
		3,�����
	* ʹ�� Runnable ����ʾLamda���ʽ
		* ԭʼ��ʽ���Թ���˵��
			public class Main{
				public static void main(String[] args){
					int num = 1;
					Runnable runnable = () -> {
						/*
							Lamda���ʽ����ֱ�ӷ����ⲿ�����еı���
							����������ڲ���,��ô�ñ���������final��
							����Ҫע�����:Lamda���ʽ���ⲿ��������ֻ���Ƕ�ȡ,���ܽ����޸�
							* ���������ִ��num++��ô�ͻᱨ��
						*/
						System.out.println("���:"+num);
					};
					runnable.run();
				}
			}
			* ����Ȼ,ֱ�Ӿ�ִ����

	* ���ڴ��������ŵ�����
		1,���ֻ��һ�л�,��ô���Բ���
		2,������� return �ؼ���,�����
	
	* return �ؼ��ֵ�����
		2,�������ı��ʽ,����һ�仰���,�����ü� return 
			(x,y) -> x + y;

----------------------------
Lambda-Ŀ������				|
----------------------------
	# ����ʶ��
		Runnable run = ()-> {};					
		Object obj = run;						//Ok

		Object obj = () -> {};					//�쳣

		Object obj = (Runnable)() -> {};		//OK
	
	# ��ν��Ŀ�����;���˵,һ�� Lambda���ʽ,���ڵ���,������!
	# һ�� Lambda ���ʽ,�������һ��Ŀ������('�ϻ���,Lambda�Ƿ���,���������������')

----------------------------
Lambda-�����ӿ�				|
----------------------------
	# ���һ���ӿ�,����ֻ��һ����ʽ�����ĺ���,��ô�ýӿڿ��Ա�����Ϊ�����ӿ� 
	# ����ʹ�� @FunctionalInterface ��ʶ�ýӿ�(Ҳ���Բ���ʶ),�����������
	# demo
		@FunctionalInterface
		public interface Runnable{
			void run();
		}

		@FunctionalInterface
		public interface MyRunable{
			void run();
			boolean equals(Object obj);
		}
		* �ýӿ�Ҳ�����ں����ӿ�,��Ȼ����ඨ���˸� equals ,������� equals ������ Object

----------------------------
Lambda-�Ӹ���				|
----------------------------
	

----------------------------
JAVA8-	java.util.functin 	|
----------------------------
	# jdk������N���Ŀ������,��ֹ�����ظ��Ķ��� lanmbda ���ʽ
	# ͳһ�� java.util.functin ����

		@FunctionalInterface	//�����νӿ�
		public interface Function<T, R> {
			R apply(T t);
		}
		* �в���,����Ҫ����ֵ
	
		@FunctionalInterface	//�����νӿ�
			public interface Supplier<T> {

			T get();
		}
		* �޲���,ָ������ֵ����,��������ֻע�ع��̵Ĵ���

		@FunctionalInterface	//�����νӿ�
		public interface Consumer<T> {
			void accept(T t);
		}
		* ����Ҫ����ֵ,�в���,�������ڵ���

		@FunctionalInterface	//�ж��νӿ�
		public interface Predicate<T> {
			boolean test(T t);
		}
		* ���� true/false ���������ж�
	
	# �⼸���඼������һЩ��̬����,��ʹ�� Lambda ���ʽ��ʱ������õ�
	# �����������
	# Ϊ�˱��ⷺ�͵Ĳ�װ��������������ģ�java�ṩ��ԭʼ�������͵ĸ��ֺ����ӿ�
		IntPredicate  // boolean test(int value);
		LongConsumer  // void accept(long value);
		...

		* ��ͬ���������ͣ��Ͳ�ͬ�ĺ����ӿڣ����ж�Ӧ�Ļ����������Ͱ汾ʵ��
	
	# Ϊ�˱����ڷ������ݵ�ʱ���в�װ������⣬���ṩ�˲�ͬ�����������ͷ���ֵ�ĺ����ӿ�
		 ToIntFunction<T> // int applyAsInt(T value);
		 ToDoubleBiFunction<T, U>	// double applyAsDouble(T t, U u);
		 ...
		
	# �������и��ֻ�����������ת���ĺ����ӿ�
		DoubleToLongFunction // long applyAsLong(double value);
		....

	
----------------------------
JAVA8-	��������			|
----------------------------
	# Lambda ���ʽ,��ʵ����һ������,�����������Lambda���﷨��
	# �����Lambda���ʽ���ڵ�����,���ǽ����ǵ�����һ��������ʱ��,���ǿ���ֱ�Ӻ��Ե���� lambda ���ʽ.
	# Ҳ����˵,���ݵĲ���Lambda���ʽ,��ֱ����Ҫ���õ��Ǹ�����,ֻ��˵�������д��ʽ��ͬ
	# ʲôʱ���ʺ���/
		* ��һ��Lambda���ʽ����������һ���Ѵ��ڵķ���
		* ��������з��Ĳ����б��Լ�����ֵҪ�뵱ǰLambda�ӿڷ����Ĳ����б��뷵��ֵһ��

	# ʲôʱ���ʺ���
		* ��������Ҫ�����õķ���������������ʱ�򣬲��ʺϣ�����ʾ����
		IsReferable demo = () -> ReferenceDemo.commonMethod("������������ݲ���");

	# ���ֵ��÷�ʽ
	1,����������
		* ˵����,Labmda������ʵ���Ǵ�������
		* �����Lambda�ӿڵ��β�,ȥ���ö�Ӧ�Ĺ��캯��
		* ��ʽ
			����::new
		* Demo
			Function<Integer,User> fun = User:new;	//Function<Integer,User> fun = (age) -> {return new User(age)};

	2,��̬��������
		* Lambda����ֻ�ǵ���һ����̬����
		* ��ʽ
			����::��̬������
		* Demo
			Consumer<String> consumer = System.out:println;		//Consumer<String> consumer = (str) -> {System.out.println(str)};


	3,�ض���(�������)�ķ�������
		* Lambda���ʽ���ǵ�����һ�����(һ����,�������),�ķ���
		* Lambda�ӿڷ�����,�����һ�������Ƿ����ĵ�����,���ڶ����������ǵ�һ���������÷������β�
		* ��ʽ
			����::ʵ��������
			BiPredicate<String,String> test = String::equals;	//BiPredicate<String,String> test = (s1,s2) -> s1.equals(s2};


	4,�ض�����ķ�������
		* Lambad ����ֻ�ǵ�������һ������,(ָ���˶���)�ķ���
		* ��ʽ
			����::ʵ��������
			Object obj = o::method;
		
		* Demo
			User user = new User();
			Supplier<String> supplier = user::getName;	//Supplier<String> supplier = () -> user.getName();
			String name = supplier.get();
	
	5,��������
		*  lambda�ӿڷ���������ݲ���,�ͻᱻ��������ĳ���
		* ��ʽ
			Type:new
		* Demo
			Function<Integer,String[]> fun = String[]::new; //Function<Integer,String[]> fun = (x) -> {return new String[x]};

----------------------------
JAVA8-	����Lambda���ʽ	|
----------------------------
	# ��ʵ����'�Ѷ���򵥵�Lambda���ʽ��ϳ�Ϊ���ӵı��ʽ'


		

	
	
----------------------------
java9						|
----------------------------
	# 2017-9 �·���
	# �Ƚ���Ҫ��������

	# ģ�黯ϵͳ
	# jshell
	# ��汾����jar
	# �ӿڵ�˽�з���
	# ��ʯ��������ʹ������
		* Java8����
			Set<String> hashSet = new HashSet<>() {};		// �쳣
			Set<String> hashSet = new HashSet<String>() {};	// ����
		* Java9
			Set<String> hashSet = new HashSet<>() {};		// ����

	# �﷨�Ľ�:try ���
		* ֧���� try() ��ֱ����������
			InputStream foo1 = new FileInputStream("");
			InputStream foo2 = new FileInputStream("");
			try (foo1;foo2){
				
			}
		
		* ����ж��, ʹ�÷ֺŷָ�
		* ���������Ķ���, ������ final ��, �����޸�

	# �»���ʹ������
		* java8֧��ʹ�� _ ��Ϊ��ʶ��, java9���쳣
			int _ = 15;
		
	# String �洢�ṹ���
		* jdk9�Ժ�, �ײ�ʹ���ֽ�����, ���洢�ַ���
			private final byte[] value;
		
		* jdk8������ǰ�� char[]
		* һ�� char, ռ�������ֽ�, ʹ�� byte ��, ���Լ�ڴ�ռ�

		* ���� StringBuilder/StringBuffer ��������ͬ�ĸı�
			

	# �����ļ�������:of
		Set<String> set = Set.of("1", "2", "2");
		List<Integer> list = List.of(1, 2, 3);
		Map<String, String> map1 = Map.of("k1", "v1", "k2", "v2", "k3", "v3");
		Map<String, String> map2 = Map.ofEntries(Map.entry("k1", "v1"), Map.entry("k2", "v2"));

		* ���ַ�ʽ��������������ֻ����

	# ��ǿ��Stream API()
		* �����4��ʵ������
			Stream<T> dropWhile(Predicate<? super T> predicate)
				* ��Stream������ɾ������������Ԫ��, ֱ������������Ϊֹ����ɾ��
				
				IntStream.of(12, 4, 3, 6, 8, 9).dropWhile(x -> x % 2 == 0).forEach(System.out::print);
				// 3, 6, 8, 9


			Stream<T> takeWhile(Predicate<? super T> predicate)
				* ��Stream�����λ�ȡ����������Ԫ�أ�ֱ������������Ϊֹ������ȡ

				IntStream.of(12, 4, 3, 6, 8, 9).takeWhile(x -> x % 2 == 0).forEach(System.out::print);
				// 12
				
		
		* �����2����̬����
			static<T> Stream<T> ofNullable(T t)
				* ��������� null,  ���ؿյ���, �����쳣
			
			static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
			static<T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
				* ��һ�����ɵ�Ԫ����UnaryOperator��seedִ��apply��ķ���ֵ
				* ֮���������ɵ�Ԫ�ض���UnaryOperator����һ��apply�ķ���ֵ��ִ��apply, ����ѭ��

				seed
					* ����
				
				hasNext
					* ��ֹ������

				UnaryOperator 
					* һԪ�����
					* �̳��� Function<T, T> 
					* �ṩΨһ��һ��Ψ��̬����
						static <T> UnaryOperator<T> identity() {
							return t -> t;
						}

	# Optional ����
		* �����һЩ, ûɶ�õķ���
		
	# ��ֱ���ͼ��API
	# ȫ�µ� HTTP �ͻ��� API
	# Deprecated ���API
		* ��Ҫɾ���� applet ��ص�һЩapi

	# ����Java���빤��
	# ͳһjvm��־ϵͳ
	# javadoc��HTML5֧��
	# javascript ��������: Nashorn
	# Java�Ķ�̬����
	
	# �ο�����
		https://www.ibm.com/developerworks/cn/java/the-new-features-of-Java-9/index.html
	
	
	# JDK��Ŀ¼�仯
		java
		|-bin			��ִ���ļ�
		|-conf			����
		|-include		c/c++ ͷ�ļ�
		|-jmods			ģ�飨��ԭ����һ��rt.jar���Ϊ��ͬ��ģ��.jar��
		|-legal			��������
		|-lib			��windowsƽ̨�Ķ�̬���ӿ�
		|-release

	
	# �ܵ���˵, Java9��һ���Ƚϴ�ĸ���
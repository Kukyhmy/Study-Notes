
----------------------------
java11						|
----------------------------
	# ����������Դ�����ļ��ķ���
		* �����Ϊ HelloWorld.java ���ļ�����һ����Ϊ hello.World ����, ��ô:
			java HelloWorld.java
		
		* �൱��
			javac HelloWorld.java
			java -cp . hello.World
	
	# ���� Lambda �����ľֲ������﷨
		* Lambda ���ʽ��ʹ�þֲ����������ƶ��� Java 11 �����Ψһ��������ص�����
		* 11 �Ժ�, lambda ���ʽ�βο��Կ���ʹ��  var �ؼ�����

		* Ψһ�����þ���, ������ var �β������ע��

		Function<Integer, Integer> rerval = (@Nullable var x) -> x == null ? 0 : x * x;
	

	# ����ZGC�ռ���
	
	# ���м�¼��
		* ���÷��м�¼����������
			-XX:StartFlightRecording
	
	# ����api
		Collection
			<T> T[] toArray(IntFunction<T[]> generator)

			* ������, ����ʹ���������, ���Զ���ת���߼�

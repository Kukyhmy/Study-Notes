---------------------
					 |
---------------------
	System
	Runtime
	Comparable
	ThreadLocal

---------------------
System				 |
---------------------
	# �� ����ϵͳ��
	# û�й��캯�������ܱ�ʵ����������ķ���ȫ�Ǿ�̬�ġ�
	# ��̬����
		static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
			* ��ָ��Դ�����и���һ�����飬���ƴ�ָ����λ�ÿ�ʼ����Ŀ�������ָ��λ�ý����� 

		long currentTimeMillis() 
			�����Ժ���Ϊ��λ�ĵ�ǰʱ�䡣 

		void exit(int status) 
			��ֹ��ǰ�������е� Java ������� 

		void gc() 
			���������������� 
		


---------------------
Runtime				 |
---------------------
	# û�й��캯�������ܱ�ʵ������
	# ����ʵ��һ����������һ����̬���������Ի�ȡ���Ķ���
	# �÷����� Runtime runtime = Runtime.getRuntime(); 
	# Runtime 

		Process exec("CMD/shell����");
			* ����ִ��һ�ε�ǰ����ϵͳ�����
		long maxMemory() 
			* ���� Java �������ͼʹ�õ�����ڴ�����
		long totalMemory() 
			* ���� Java ������е��ڴ������� 
	
	# Process
		void prop.destroy();
			* ɱ�����̡�(ֻ��Ū���������ĳ���)

		InputStream prop.getInputStream();
			* ���Ի�ȡ��cmd��һ��������,ִ����cmd��������Զ�ȡ��cmd��ʾ����������

		InputStream getErrorStream() 
			*  ��ȡ�ӽ��̵Ĵ�������
			
		InputStream getInputStream()  
			* ��ȡд����

		int exitValue();
			* �� Process �����ʾ���ӽ��̵ĳ���ֵ�����ݹ�����ֵ 0 ��ʾ������ֹ�� 
		int waitFor();
			* �����̻߳�һֱ����,ֱ�� Process �����ʾ�Ľ����Ѿ���

---------------------
Comparable<T>		 |
---------------------
	# int compareTo(T o) 
		* �Ƚϴ˶�����ָ�������˳�� 

--------------------
ThreadLocal			|
--------------------

	�������������ʵ��һ��Map����
	�Ե�ǰ�߳�Ϊ��!
	ÿ���߳�ֻ��ȡ��/�����Լ��̵߳Ķ�����
	Map<Thread,t> map = new HashMap<Thread,t>();
	set();
	get();
	remove();

	ͨ������һ����ĳ�Ա��,����̷߳�����ʱ
	ÿ���̶߳����Լ��ĸ�������������
	Spring��,�� Connection �ŵ��� ThreadLocal �С�

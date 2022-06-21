----------------------------
java10						|
----------------------------
	# �ֲ������ƶ�
	# io��������api
		Reader
			long transferTo(Writer out)

		InputStream
			long transferTo(OutputStream out) 
		
		ByteArrayOutputStream
			String toString(Charset charset)
		
		PrintWriter
			PrintWriter(OutputStream out, boolean autoFlush, Charset charset) 
		
		Scanner
			Scanner(InputStream source, Charset charset) 
			Scanner(File source, Charset charset)
			Scanner(ReadableByteChannel source, Charset charset)
			Scanner(Path source, Charset charset)
		
		* ���������˹������� '�ַ�����' �� 'transferTo' ��api
	
	# ������������̬����
		List
			static <E> List<E> copyOf(Collection<? extends E> coll)
		Set
			static <E> Set<E> copyOf(Collection<? extends E> coll)
		Map
			static <K, V> Map<K, V> copyOf(Map<? extends K, ? extends V> map)
		
		
		* ���ղ����ĵ���˳��, ����copy
		* �� of һ��, ���ص��¼���, �����޸�
	
	# ���ռ���������
		Collectors.toUnmodifiableSet()
		Collectors.toUnmodifiableList():
		Collectors.toUnmodifiableMap(Function, Function):
		Collectors.toUnmodifiableMap(Function, Function, BinaryOperator):

		* �����ռ�Ϊ�����޸ĵļ���

	# �� JDK �Ķ������ֿ�ϲ���һ���������
	# �����ռ����ӿ�, ͨ������һ���ɾ��������ռ���(GC)�ӿ�, ���Ʋ�ͬ�����ռ�����Դ�������
	# �� G1 ���벢�� Full GC
	# �ֲ߳̾��ܿ�, ����ֹͣ�����߳�, ������ֻ�����û�ֹͣ�����߳�
	# �Ƴ� Native-Header Generation Tool (javah)
	# ����� Unicode ���Ա�ǩ��չ��������cu (��������)��fw (ÿ�ܵ�һ��Ϊ���ڼ�)��rg (���򸲸�)��tz (ʱ��) ��
	# �ڱ����ڴ��豸�Ϸ�����ڴ档���� HotSpot ������ڱ����ڴ��豸�Ϸ��� Java �����
	# ���� Java �� JIT ������������汾��
	# ��֤�顣��Դ Java SE Root CA �����еĸ�֤��
	# ����ʱ��İ汾����ģʽ����Feature releases�� �汾�����������ԣ���Update releases�� �汾���޸� Bug


----------------------------
JAVA8������-Stream�ӿ�		|
----------------------------
	* Stream �ӿ�(��Ȼ���¶���,��Editplus��û�����ʾ)
	* ���ṩ���кͲ�������ģʽ���л�۲���������ģʽ�ܹ�������ö�˴����������ƣ�ʹ�� fork/join ���з�ʽ���������ͼ��ٴ�����̡�
	* ͨ����д���д�����Ѷ������׳���, ��ʹ�� Stream API �����дһ�ж��̵߳Ĵ��룬�Ϳ��Ժܷ����д�������ܵĲ�������
	* Stream ������һ���ص��ǣ�����Դ������������޵ġ�
	* �����������ݽṹ,Ҳ��������.����һ������
	* ���Ĳ�����Ϊ����
	Intermediate 
		* һ�������Ժ������������� intermediate ��������Ŀ����Ҫ�Ǵ���������ĳ�̶ֳȵ�����ӳ��/���ˣ�Ȼ�󷵻�һ���µ�����������һ������ʹ�á�����������Ƕ��Ի��ģ�lazy��
		* ����˵���������õ����෽������û��������ʼ���ı�����
		* ����
			map (mapToInt, flatMap ��)�� 
			filter 
			distinct
			sorted
			peek
			limit
			skip
			parallel
			sequential
			unordered
	Terminal
		* һ����ֻ����һ�� terminal ���������������ִ�к����ͱ�ʹ�á��⡱�ˣ��޷��ٱ�������������ض����������һ��������
		* Terminal ������ִ�У��Ż�������ʼ���ı��������һ�����һ�����������һ�� side effect��
		* ����
			forEach
			forEachOrdered
			toArray
			reduce 
			collect
			min
			max
			count
			anyMatch
			allMatch
			noneMatch
			findFirst
			findAny
			iterator
	
	* ���һ�����Ĳ���,û�� Terminal ,������е��κ� Intermediate ����������ִ��

----------------------------
JAVA8������-Stream�Ļ��	|
----------------------------
	1,Collection ���ഴ��
		* ����ֱ�ӵ��� stream();����(����)
		* ����ֱ�ӵ��� parallelStream();����,������ Collection �ӿ��е� default ����

	2,���鴴��
		*  Arrays.stream(T[] array);

	4,Stream ��̬��������
		* Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6);

	5,�ļ�IO����
		* Stream<String> stream = Files.lines(String path,Charset charser);
		* �������Զ��ر�
		
	# �����������ķ���
		* Stream<T> str = Stream.generate(Supplier<T> supplier);
			* ����ÿ��ִ�� foreach ������� supplier �� get ����,Ҳ����˵�ù����������Դ������޴����

		* Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
			* �Ȼ�ȡһ�����޳��ȵ����������ϵ�Stream��Ȼ��ȡ��ǰ10����ӡ��ǧ���סʹ��limit��������Ȼ�����޴�ӡ��ȥ��
	
----------------------------
JAVA8������-Stream�ӿڷ���	|
----------------------------
	parallel();
		* ���ò�����

	filter			(Predicate<? super T> predicate);
		* ���ڹ���,ɸѡ

	map				(Function<? super T, ? extends R> mapper);
		* ����Stream�а�����Ԫ��ʹ�ø�����ת����������ת������,�����еķ���ֵ,����µ���
		* '�����User����(User��),��ȡ���������name����,ת��Ϊһ��Stream����'
		* �����ɵ�Streamֻ����ת�����ɵ�Ԫ�ء�
	
	flatMap			(Function<? super T, ? extends Stream<? extends R>> mapper);
		* ����ľ�����,
		* ��map���ƣ���ͬ���Ǵ����Ԫ��,����һ����
		* ˵����,���Ǵ����ÿһ����,Ȼ��ϲ�������Ϊһ����,����
		* ע��������� Function �ķ���ֵ�� Stream

	mapToInt
	mapToLong
	mapToDouble
		* ����������һ����,�������µ�����ָ��ֵ����(IntStream,LongStream,DoubleStream)��������Զ�װ��/����Ķ������ģ�

	sorted			();
		* Ҳ������,��ҪԪ������ʵ�� Comparable �ӿ�
	sorted			(Comparator<? super T> comparator);
		* ����,�Զ��� Comparator ���������

	peek			(Consumer<? super T> action);
		* ����һ������ԭStream������Ԫ�ص���Stream��ͬʱ���ṩһ�����Ѻ�����Consumerʵ��������Streamÿ��Ԫ�ر����ѵ�ʱ�򶼻�ִ�и��������Ѻ�����
		* �� map ���������,map�Ǵ����µķ���,���������ֱ����ԭ�����ϸ�

	limit			(long maxSize);
		* ������ǰ��ļ���Ԫ��,���ԭStream�а�����Ԫ�ظ���С��N���Ǿͻ�ȡ�����е�Ԫ��
		* Ҳ�������� Set ���ϵ�����,��ô��ȡ������,�������

	skip			(long n);
		* ����(����)��ǰ��ļ���Ԫ��,���ԭStream�а�����Ԫ�ظ���С��N����ô���ؿ�Stream��

	forEach			(Consumer<? super T> action);
		* ����,�ڶ�������Ҳ���ʧȥ˳��
		* �������Ҫ��˱���,��ô��Ҫ���� arr.parallelStream().forEach(System.out::println);  'Collection' �ӿڵ�Ĭ�Ϸ���

	forEachOrdered	(Consumer<? super T> action);
		* ͬ��,����,'�ڶ�������˳�򲻻���Ӱ��'
		
	reduce			(T identity, BinaryOperator<T> accumulator);
		* ��һ�������ǳ�ʼֵ,���� Lambda������ֵ.��ʾҪ����ɶ����,�õ�ɶ���
		* int sum = numbers.stream().reduce(0,(a,b) -> {a + b});			//��һ�鼯�����������ֵĺ�
		* ����� parallelStream(); ����������ִ�еĻ�,���ݸ� Lambda ���ʽ accumulator �����������ܸ���״̬,���Ҳ��������������ɲſ��԰�����˳��ִ��
	
	reduce			();
		* ���������,�޳�ʼֵ
		* ���� Optional<T>,��û��ʼֵ.�����ǿյ�
		* Optional<Integer> max = numbers.stream().reduce(Integer::max);					//�����������е����ֵ

	toArray			();
		* ���� Object[] ����
	
	findFirst		();
		* ����һ�� termimal �� short-circuiting �����������Ƿ��� Stream �ĵ�һ��Ԫ�أ����߿ա�
	
	findAny
		* ͬ��,Ҳ�Ƿ��ص�һ��Ԫ��.�������ţ��֮������,'������'.
		* ����㲻���ⷵ�ص�Ԫ�����ĸ�,����ʹ�����

	distinct		();
		* ȥ���ظ�,������hashCode��equals
	
	count			();
		* ��������Ԫ�صĸ���
	
	min(Comparator com);		
		* ���ݱȽ���,��ȡ���Ԫ��

	max(Comparator com);		
		* ���ݱȽ���,��ȡ����Ԫ��

	collect(Collectors.toList());
		* �ѽ��,ת��Ϊһ������
		* ����һ�� Collectors �ӿڵ�ʵ��,���ڰ�Ԫ���е�����,����һ������
	
	
	//ƥ��ϵ�е�API
	allMatch
		* ����Ƿ�ƥ������Ԫ��,���� boolean
	anyMatch
		* ����Ƿ�����ƥ��һ��Ԫ�� boolean
	noneMath
		* ����Ƿ�δƥ�����κ�Ԫ�� boolean
	findFirst
		* ���ص�һ��Ԫ��
		* �����ǵ������� Optional
	findAny
		* ���ص�ǰ���е�����Ԫ��
		* �����ǵ������� Optional
	
----------------------------
JAVA8������-�����������͵�	|
----------------------------
	* ���ڻ�����ֵ�ͣ�Ŀǰ�����ֶ�Ӧ�İ�װ���� Stream��
		IntStream
		LongStream
		DoubleStream
	* ��Ȼ����Ҳ������ Stream<Integer>��Stream<Long> >��Stream<Double>�����ǲ����װ���ܺ�ʱ�������ر�Ϊ�����ֻ�����ֵ���ṩ�˶�Ӧ�� Stream��
	
	* ���ⷽ��
		min();		//��ȡ���е���Сֵ
		max();		//��ȡ���е����ֵ
		sum();		//��ֵ
		average();	//ƽ��ֵ
		boxed();	//ת���� Stream<T> ��

----------------------------
JAVA8������-������			|
----------------------------
	# ����
		Stream.iterate(0, n -> n+2);
		* 0 ��ʾ��ʼֵ,Ȼ�󲻶ϵ� +2
		* һ����˵˵,��Ҫ��������һϵ��ֵ��ʱ���Ӧ�������
	
	# ����
		Stream<T> str = Stream.generate(Supplier<T> supplier);
		* ����ÿ��ִ�� foreach ������� supplier �� get ����,Ҳ����˵�ù����������Դ������޴����

----------------------------
JAVA8������-����״̬		|
----------------------------
	# ��״̬
	# ��״̬ -> �н�
	# ��״̬ -> �޽�
	
	
----------------------------
JAVA8������-������			|
----------------------------
	# ���̵߳���
		* ͨ�� parallelStream(); ���Ի�ȡ���̵߳���
			list.parallelStream().forEach(System.out::println);			//���̴߳�ӡ,˳�����Ӱ��
		* ��ֱ�ӵ��� parallel(); ����
			Stream<String> stream = Stream.of("1","2","4").parallel();
	
	# �رղ�����
		sequential();

----------------------------
JAVA8������-�ܽ�			|
----------------------------
	# ���Ĵ���,�������Ĵ���
		* list.stream();		//Collection ����
		* Stream.of(1,2,3,4,5,6);
		* Stream.generate(Supplier<T> supplier);
		* Arrays.stream(T[] array);

	# ���Ĳ�����ʽ,����
		* ����
		* ���
	
	# ���̵߳���
		* ͨ�� parallelStream(); ���Ի�ȡ���̵߳���
			list.parallelStream().forEach(System.out::println);			//���̴߳�ӡ,˳�����Ӱ��
		* ��ֱ�ӵ��� parallel(); ����
			Stream<String> stream = Stream.of("1","2","4").parallel();
	
	# ������
		


----------------------------
JAVA8������-collector		|
----------------------------
	# ��һ���ӿ�,�ռ���,������ʹ��API:collect(Collector collecto); 
	# Ԥ������ռ���
	Collectors.toList()
		* �ѽ��ת��Ϊһ������
	Collectors.toSet();
		* �ѽ��ת��Ϊһ��Set
	Collectors.toCollection(Supplier collectionFactory);
		* ת��Ϊ�Զ���� Collection �ӿ�ʵ��
		* ���ǿ���ʹ���Լ���������
		* collect(Collectors.toCollection(HashSet::new));
	Collectors.counting();
		* ���� lang,�ѽ���ռ�Ϊһ������
	Collectors.averagingInt();
	Collectors.averagingLong();
	Collectors.averagingDouble();
		* ������,���ǲ�ͬ�������͵�ƽ��ֵ
	Collectors.summarizingInt();
	Collectors.summarizingLong();
	Collectors.summarizingDouble();
		* ������,���ǲ�ͬ�������͵ĺ�
		* ����
	
	Collectors.maxBy(Comparator<? super T> comparator);
		* ���ݱȽ���,��ȡ���ֵ
	
	Collectors.minBy(Comparator<? super T> comparator);
		* ���ݱȽ���,��ȡ��Сֵ
	
	Collectors.groupingBy(Function<? super T, ? extends K> classifier);
		* ����,���� Map,Lambda�ķ���ֵ,����ΪMap��key
		* Demo
		 Map<String,List<User>> = users.stream().collect(Collectors.groupingBy(item -> {
			return user.getAge() > 20 ? "����" : "����";
		 }));
	
	Collectors.groupingBy(Function function,Collector collector);
		* �Ȱ��� Function �ķ���ֵ���з���
		* �ٰѷ���Ľ��,���� collector �ռ�����
		* Demo	//�Ȱ��Ա����,�ٰ��������
			Map<String,Map<String,List<User>>> = users.stream().collect(
			Collectors.groupingBy(User:getSex,	Collectors.groupingBy((user) - > {
				return user.getAge() > 20 ? "����" : "����";
			}));
	
	Collectors.joining();
		* ���Ӳ���,�ַ�������.û���κ��м����
		* Demo
			String namesss = users.stream()
				.map(User:getName);
				.collect(Collectors.joining());

	Collectors.joining(String a,String b,String c);
		* ͬ��,�����������ӵĿ�ͷ���� b,��β���� c,ÿ�����ӵ�֮����� a

		
			
		



	
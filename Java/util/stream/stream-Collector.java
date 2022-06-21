--------------------
Collector
--------------------
	# �ռ���ʵ��

	# ���󷽷�
		Supplier<A> supplier();
		BiConsumer<A, T> accumulator();
		BinaryOperator<A> combiner();
		Function<A, R> finisher();
		Set<Characteristics> characteristics();
	
	# ��̬����
		static<T, R> Collector<T, R, R> of(Supplier<R> supplier,
                                              BiConsumer<R, T> accumulator,
                                              BinaryOperator<R> combiner,
                                              Characteristics... characteristics)
		static<T, A, R> Collector<T, A, R> of(Supplier<A> supplier,
                                                 BiConsumer<A, T> accumulator,
                                                 BinaryOperator<A> combiner,
                                                 Function<A, R> finisher,
                                                 Characteristics... characteristics)
	
	# �ڲ�ö�� Characteristics
		CONCURRENT
		UNORDERED
		IDENTITY_FINISH
		


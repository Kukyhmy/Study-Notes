--------------------------------------
AtomicIntegerFieldUpdater			  |
--------------------------------------
	# Integer �ֶε�ԭ���޸���
		* ����һ��������
		* ��Ҫ����ͨ�����޸���ȥ�޸�ָ�������ָ�� int �ֶ�ֵ(ʹ�÷���)
		* �ڶ��̻߳�����,�����޸���ԭ���Ե�(CAS�㷨)

	# ��̬�Ĺ�������
		<U> AtomicIntegerFieldUpdater<U> newUpdater(Class<U> tclass, String fieldName)
			* tclass ָ����
			* fieldName �ֶε����Ա����� int,������ Integer,���Ҳ����� static ��
			* ע��,���ֶα���ʹ�� protected �������ϵ�Ȩ�����η�,���ұ������:volatile ���η�

	# ʵ������
		int accumulateAndGet(T obj, int x, IntBinaryOperator accumulatorFunction)
		int addAndGet(T obj, int delta)

		boolean compareAndSet(T obj, int expect, int update)
			* obj ����
			* expect ԭʼֵ
			* update �µ�ֵ
			* ����޸ĳɹ�,���� true

		int decrementAndGet(T obj)

		int get(T obj)
		int getAndAccumulate(T obj, int x,IntBinaryOperator accumulatorFunction)
		int getAndAdd(T obj, int delta)
		int getAndDecrement(T obj)
		int getAndIncrement(T obj)
		int getAndSet(T obj, int newValue)
		int getAndUpdate(T obj, IntUnaryOperator updateFunction)

		int incrementAndGet(T obj)
		void lazySet(T obj, int newValue)
		void set(T obj, int newValue)
		int updateAndGet(T obj, IntUnaryOperator updateFunction)
		boolean weakCompareAndSet(T obj, int expect, int update)
	
	
	# demo
		class Foo {
			protected volatile int value = 0;
			public int getValue() {
				return value;
			}
			public void setValue(int value) {
				this.value = value;
			}
		}

		public static void casUpdate(Foo foo) {
			AtomicIntegerFieldUpdater<Foo> updater = AtomicIntegerFieldUpdater.newUpdater(Foo.class, "value");
			for (int x = 0 ;x < 100 ;x ++) {
				new Thread(() -> {
					while(true) {
						// ԭʼֵ
						int value = foo.getValue();
						// ��ֵ
						int newValue = value + 1;
						// ԭ�Ӹ���
						boolean result = updater.compareAndSet(foo, value, newValue);
						if(result) {
							break;	// ����ʧ��,��������
						}
					}
				}) .start();
			}
		}
	

--------------------------------------
���ṩ�������޸���					  |
--------------------------------------
	# ����������ͬ��aip,��Ҫ����Ե��ֶ����Ͳ�ͬ

	AtomicReferenceFieldUpdater
		<U,W> AtomicReferenceFieldUpdater<U,W> newUpdater(Class<U> tclass, Class<W> vclass,String fieldName) 

		* ���������ֶε�ԭ���޸���

	AtomicLongFieldUpdater
		<U> AtomicLongFieldUpdater<U> newUpdater(Class<U> tclass,String fieldName)

		* long �����ֶε�ԭ���޸���

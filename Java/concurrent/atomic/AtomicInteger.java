---------------------------
AtomicInteger				|
---------------------------
	# ԭ���Եı���
	# ʹ��CAS(Compare And Swap)�㷨��֤���ݵ�ԭ����
	# ��ͬ��API(�������Ͳ�ͬ)
		AtomicLong
		AtomicBoolean
		AtomicLong
		AtomicReference

		AtomicIntegerArray
		AtomicLongArray

	# ����
		AtomicInteger() 
			* �������г�ʼֵ 0 ���� AtomicInteger 
		AtomicInteger(int initialValue)  
			* ����ָ����ʼֵ�� AtomicInteger
	# ����
		void set(int newValue);
			* ������ֵ
		int getAndSet(int newValue);
			* ������ֵ,���ҷ��ؾ�ֵ

		int addAndGet(int delta);
			* ����ָ��ֵ,������Ӻ��ֵ
		int getAndAdd(int delta);
			* ����ָ����ֵ,�������ǰ��ԭʼֵ

		int decrementAndGet() 
			* ��ȥ1,���ؼ����ֵ
		int getAndDecrement();
			* ��ȥ1,���ؼ�ǰ��ֵ
		
		int incrementAndGet(); 
			* ��1,���ؼӺ��ֵ
		int getAndIncrement();
			* ��1,���ؼ�ǰ��ֵ
		
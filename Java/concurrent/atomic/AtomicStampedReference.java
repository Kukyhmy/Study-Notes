------------------------
AtomicStampedReference	|
------------------------
	# jdk1.5�����CAS��,�����ABA������
	# ���캯��
		 AtomicStampedReference(V initialRef, int initialStamp) 
		
	
	# ʵ������
	
		boolean attemptStamp(V expectedReference, int newStamp)
		boolean compareAndSet(V expectedReference, V newReference,int expectedStamp, int newStamp)
			* ���ȼ�鵱ǰ�����Ƿ����Ԥ������,���ҵ�ǰ��־�Ƿ����Ԥ�ڱ�־
			* ���ȫ�����,����ԭ�ӷ�ʽ�������ú͸ñ�־��ֵ����Ϊ�����ĸ���ֵ
			* �����CAS��'ABA'������
		
		V get(int[] stampHolder)
		V getReference()
		int getStamp()
		void set(V newReference, int newStamp)
		boolean weakCompareAndSet(V expectedReference,V newReference,int expectedStamp,int newStamp)


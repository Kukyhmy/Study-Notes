----------------------------------
LinkedBlockingQueue				  |
----------------------------------
	# �ײ�ʹ�õ��������ʽʵ��Queue

	# �����������������뼼��ʵ����ӳ��ӻ�������
			private final ReentrantLock takeLock = new ReentrantLock();
			private final Condition notEmpty = takeLock.newCondition();

			private final ReentrantLock putLock = new ReentrantLock();
			private final Condition notFull = putLock.newCondition();
	
	# ���캯��
		public LinkedBlockingQueue()
		public LinkedBlockingQueue(int capacity)
		LinkedBlockingQueue(Collection<? extends E> c)

		capacity
			* queue��������С, Ĭ��:Integer.MAX_VALUE
		
		c
			* ��ʼ��������
	

	# ʵ������
		
----------------------------------
ArrayBlockingQueue				  |
----------------------------------
	# �ײ�ʹ��������н����
		ArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable
	
	# ͨ��һ����������Condition�������,֪ͨ
		final ReentrantLock lock;
		private final Condition notEmpty;
		private final Condition notFull;

	# ���캯��
		ArrayBlockingQueue(int capacity) 
		ArrayBlockingQueue(int capacity, boolean fair) 
		ArrayBlockingQueue(int capacity, boolean fair, Collection<? extends E> c)

		capacity 
			* ����ָ����С���н����
		fair
			* ָ��Ϊ��ƽ��ǹ�ƽ�� , Ĭ�� false
		c
			* ��ʼ�������ݼ���

	
	# ʵ������
		
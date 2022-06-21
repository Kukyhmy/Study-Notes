----------------------------
Semaphore					|
----------------------------
	# ��Ҫ�����þ��ǿ��Ʒ�����Դ���߳�����

	# ���캯��
		Semaphore(int permits, boolean fair) 
		Semaphore(int permits) 
		
		* permits ��Դͬʱ�����̵߳��������
		* fair �Ƿ��ǹ�ƽ��
	
	# ����
		void acquire()
			* ��ȡһ������,�������,������
		void acquire(int permits) 
			* ���Ի�ȡN������,�������,������
		void acquireUninterruptibly() 
			* ���Ի�ȡһ������
		void acquireUninterruptibly(int permits)
			* ���Ի�ȡN������,���ܻ��׳��ж��쳣

		int availablePermits()
		int drainPermits()
		int getQueueLength()

		boolean hasQueuedThreads()
		boolean isFair()

		void release()
		void release(int permits)

		boolean tryAcquire()
		boolean tryAcquire(int permits)
		boolean tryAcquire(int permits, long timeout, TimeUnit unit)
		boolean tryAcquire(long timeout, TimeUnit unit)
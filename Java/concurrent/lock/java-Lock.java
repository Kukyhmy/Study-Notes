----------------------------
Lock						|
----------------------------
	# һ���ӿ�
	# ���ڽ�����̵߳İ�ȫ����
	# synchronized ����ʽ����
	# Lock ����ʾ����
	# ����
		Lock lock = new ReentrantLock();

----------------------------
Lock-����					|
----------------------------

----------------------------
Lock-����					|
----------------------------
	void lock();
		* ����
	
	void lockInterruptibly() throws InterruptedException;

	boolean tryLock();
	boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

	unlock();
		* ���ͷ�
	
	Condition newCondition();

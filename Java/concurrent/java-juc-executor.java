----------------------------
�̳߳ع���					|
----------------------------
	# ��ϵ
		Executor(�ӿ�)
			|-ExecutorService(�ӿ�)
				|-AbstractExecutorService(������)
					|-ThreadPoolExecutor(ʵ��)
				|-ScheduledExecutorService(�ӿ�,�����̵߳���)
						|-ScheduledThreadPoolExecutor(�̳���ThreadPoolExecutor��ʵ����ScheduledExecutorService)
		Executors(����/������)
	
	# Executor ִ�����ӿ�
		* Ψһ�ĳ��󷽷�
			void execute(Runnable command);
	

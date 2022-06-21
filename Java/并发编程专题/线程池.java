---------------------------
ExecutorService				|
---------------------------
	# �̳߳ع���
	# ��ϵ
		Executor(�ӿ�)
			|-ExecutorService(�ӿ�)
				|-ThreadPoolExecutor(ʵ��)
				|-ScheduledExecutorService(�ӿ�,�����̵߳���)
					|-ScheduledThreadPoolExecutor(�̳��� ThreadPoolExecutor ��ʵ���� ScheduledExecutorService)
	# ����
		ExecutorService pool = Executors.newFixedThreadPool(2);		
			* ����һ�������ù̶��߳������̳߳أ��Թ�����޽���з�ʽ��������Щ�̡߳�
		
		ExecutorService pool = Executors.newCachedThreadPool();
			* ����һ���ɸ�����Ҫ�������̵߳��̳߳�,��������ǰ������߳̿���ʱ���������ǡ�
			* ����ִ�кܶ�����첽����ĳ������,��Щ�̳߳�ͨ������߳������ܡ�
			* �߳��������̶�,���Ը�����������߳�����

		ExecutorService pool =  Executors.newSingleThreadExecutor()
			* ����һ��ʹ�õ��� worker �̵߳� Executor�����޽���з�ʽ�����и��̡߳�
			* ����ֻ��һ���߳�
		
		ScheduledExecutorService es =  Executors.newScheduledThreadPool(10);
			* ���������̳߳�
			* �����̶���С���̳߳�,������ʱ/�ظ���ִ���������

	# ʹ���߳�ִ������
		Future<?> submit(Runnable task);

		<T> Future<T> submit(Callable<T> task);

		void execute(Runnable command);

		* execute��submit������
			1. ���յĲ�����һ��;
			2. submit()�з���ֵ����execute()û��;
				���磬�и�validation��task��ϣ����taskִ��������������ִ�н�����ǳɹ�����ʧ�ܣ�Ȼ���������Ĳ�����
			3. submit()���Խ���Exception����;
				���磬���task����׳�checked����unchecked exception��������ϣ������ĵ������ܹ���֪��Щexception��������ʱ�Ĵ�����ô����Ҫ�õ�submit��ͨ����Future.get()�����׳��쳣�Ĳ���Ȼ�������д���

	
	# �̳߳ص���
		ScheduledExecutorService es =  Executors.newScheduledThreadPool(10);

		ScheduledFuture<?> schedule(Runnable command,long delay, TimeUnit unit);
			* ��ָ���ӳٺ�,ִ��command

		<V> ScheduledFuture<V> schedule(Callable<V> callable,long delay, TimeUnit unit);
			* ��ָ���ӳٺ�,ִ��callable



	# api
		boolean isShutdown()
		void shutdown();
			* ��ȵ�����������ɲŻ�ر�

		List<Runnable> shutdownNow();
			* �����ر��̳߳�

		boolean isTerminated();
			* ��������е��������񶼴�����Ϻ󷵻� true
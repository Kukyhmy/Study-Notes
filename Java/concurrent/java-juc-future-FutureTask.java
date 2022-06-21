------------------------
FutureTask<V> 
------------------------
	# FutureTask<V> implements RunnableFuture<V> 
	
	# ���췽��
		public FutureTask(Callable<V> callable)
		public FutureTask(Runnable runnable, V result)
	
	# ʵ������
		public boolean isCancelled()
		public boolean isDone()
		public boolean cancel(boolean mayInterruptIfRunning) 
		public V get() throws InterruptedException, ExecutionException 
		public V get(long timeout, TimeUnit unit)
		public void run()

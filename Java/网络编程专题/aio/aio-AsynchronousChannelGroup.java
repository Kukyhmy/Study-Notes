----------------------------------
AsynchronousChannelGroup			|
-----------------------------------
	# AsynchronousChannelGroup ��һ��������,ͨ����̬������ȡʵ������

		AsynchronousChannelGroup withThreadPool(ExecutorService executor);
		AsynchronousChannelGroup withCachedThreadPool(ExecutorService executor,int initialSize);
		AsynchronousChannelGroup withFixedThreadPool(int nThreads,ThreadFactory threadFactory);
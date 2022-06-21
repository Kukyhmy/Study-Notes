-----------------------------------
AsynchronousServerSocketChannel		|
-----------------------------------
	# �첽,��������������Socketͨ��
	# AIO
	# AIO�ṩ�������첽�����ļ������ơ�
		* ��һ��ͨ������һ�� Future ������ʵ�֣�������get();��������������ɡ�
			Future<V>
				boolean cancel(boolean mayInterruptIfRunning);
				boolean isCancelled();
				boolean isDone();
				V get() throws InterruptedException, ExecutionException;
				V get(long timeout, TimeUnit unit)throws InterruptedException, ExecutionException, TimeoutException;

		* �ڶ��������ڻص��������ڽ����첽����ʱ������һ�� CompletionHandler �ӿ�ʵ�� ���첽��������ʱ������� ʵ���� complete ����
		* ��������,OS���IO��ص�
			CompletionHandler<V,A>
				void completed(V result, A attachment);
					* ������ɵ�ʱ��ִ��
				void failed(Throwable exc, A attachment);
					* �����쳣��ʱ��ִ��
	
-----------------------------------
AsynchronousServerSocketChannel-API|
-----------------------------------
	# ��̬����
		AsynchronousServerSocketChannel	open();	
			* ��һ���첽��Socketͨ��
		AsynchronousServerSocketChannel	open(AsynchronousChannelGroup group);
			* ʹ�� AsynchronousChannelGroup ����һ���µ�ͨ��

	# ʵ������
		//===================== ����
		AsynchronousServerSocketChannel bind(SocketAddress local);
			* ����ָ���Ķ˿�,���� this 
			* ����ò����� null,���Զ����ڵ�ǰ����Ѱ�ҿ��еĶ˿ڽ��а�
			* demo
				AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(8888));
		AsynchronousServerSocketChannel	bind(SocketAddress local, int backlog)
			* ͬ��,�������������������
		
		//===================== ����
		Future<AsynchronousSocketChannel> accept();
			* �÷���������,ֱ���յ�����
		
		<A> void accept(A attachment,CompletionHandler<AsynchronousSocketChannel,? super A> handler);
			* ����һ������ attachment
			* ���� CompletionHandler �ӿڵ� completed ���� �п��Ի�ȡ���������
		
		
		//===================== ����
		<T> AsynchronousServerSocketChannel setOption(SocketOption<T> name, T value);
			* ��������
		<T> T getOption(SocketOption<T> name);
			* ��ȡ����
		Set<SocketOption<?>> supportedOptions();
			* ��ȡ֧�ֵ�����

		//===================== ����
		void close();
			* �ر�

		SocketAddress getLocalAddress()��
			* ��ȡ��ǰ�ĵ�ַ
		
		AsynchronousChannelProvider	provider();
			* δ֪
	

----------------------------------
AsynchronousChannelGroup			|
-----------------------------------
	# AsynchronousChannelGroup ��һ��������,ͨ����̬������ȡʵ������
		AsynchronousChannelGroup withThreadPool(ExecutorService executor);
		AsynchronousChannelGroup withCachedThreadPool(ExecutorService executor,int initialSize);
		AsynchronousChannelGroup withFixedThreadPool(int nThreads,ThreadFactory threadFactory);
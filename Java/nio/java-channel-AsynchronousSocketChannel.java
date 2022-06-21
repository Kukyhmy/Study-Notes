-----------------------------------
AsynchronousServerSocketChannel		|
-----------------------------------
	# �첽,�������ͻ���Socketͨ��


-----------------------------------
AsynchronousServerSocketChannel-API|
-----------------------------------
	# ��̬����
		AsynchronousSocketChannel open(AsynchronousChannelGroup group);
			* ��һ���첽ͨ��,ʹ��ָ���� ChannelGroup
		AsynchronousSocketChannel open();
			* ��һ���첽ͨ��
	
	# ʵ������
		//==========================��
		AsynchronousSocketChannel	bind(SocketAddress local);
			* �󶨱�����ַ
		

		//==========================����
		Future<Void> connect(SocketAddress remote);
			* ����Զ�̷�����
			* demo
				 asynchronousSocketChannel.connect(new InetSocketAddress("localhost",55));
		
		<A> void connect(SocketAddress remote,A attachment,CompletionHandler<Void,? super A> handler);
			* ����Զ������

		//==========================��ȡ
		Future<Integer>	read(ByteBuffer dst);
		<A> void	read(ByteBuffer[] dsts, int offset, int length, long timeout, TimeUnit unit, A attachment, CompletionHandler<Long,? super A> handler);
		<A> void	read(ByteBuffer dst, A attachment, CompletionHandler<Integer,? super A> handler)
		<A> void	read(ByteBuffer dst, long timeout, TimeUnit unit, A attachment, CompletionHandler<Integer,? super A> handler)

		//==========================д��
		Future<Integer>	write(ByteBuffer src)
		<A> void	write(ByteBuffer[] srcs, int offset, int length, long timeout, TimeUnit unit, A attachment, CompletionHandler<Long,? super A> handler)
		<A> void	write(ByteBuffer src, A attachment, CompletionHandler<Integer,? super A> handler)
		<A> void	write(ByteBuffer src, long timeout, TimeUnit unit, A attachment, CompletionHandler<Integer,? super A> handler)\

		//=========================����
		<T> AsynchronousSocketChannel setOption(SocketOption<T> name, T value);
			* ��������
		
		<T> T getOption(SocketOption<T> name);
			* ��ȡ����

		Set<SocketOption<?>> supportedOptions();
			* ��ȡ֧�ֵ�����
		
		//=========================�ر�
		AsynchronousSocketChannel	shutdownInput()
			* �رն�,��û�йر�����
		AsynchronousSocketChannel	shutdownOutput()
			* �ر�д,��û�йر�����
		void close();
			* �ر�����

		//==========================����
		boolean isOpen();
			* �����Ƿ��
		SocketAddress	getLocalAddress();
			* ���ص�ַ
		SocketAddress	getRemoteAddress()
			* Զ�̵�ַ
		AsynchronousChannelProvider	provider()
			* δ֪

------------------------
ServerSocketChannel		|
------------------------
	# ServerSocketChannel �̳� SelectableChannel ,������Ҳ�߱���������ģʽ,ע���¼��ķ���
	# ���� ServerSocket �Ĵ�����,������Ҳ�� accept() ����

	# �����߱� public �Ĺ��캯��,ֻ��ͨ����̬������������
		ServerSocketChannel.open();

	# ÿ�� ServerSocketChannel ���󶼺�һ�� ServerSocket ����,����ͨ��api��ȡ
		ServerSocket socket();

	# ���� ServerSocketChannel ʵ������
		


------------------------
ServerSocketChannel-api	|
------------------------

	public static ServerSocketChannel open()

	ServerSocket socket();
		* ���ع����� ServerSocket ����,ÿ�� ServerSocketChannel ������һ�� ServerSocket

	<T> ServerSocketChannel setOption(SocketOption<T> name, T value)
	SocketChannel accept()
	SelectionKey register(Selector sel, int ops)
	SelectionKey register(Selector sel, int ops,Object att)
	ServerSocketChannel bind(SocketAddress local)
	ServerSocketChannel bind(SocketAddress local, int backlog)
	SocketAddress getLocalAddress() 
	int validOps()
		* ���� ServerSocketChannel �ܲ������¼�
		* �̶�����:SelectionKey.OP_ACCEPT;(���Ӿ����¼�)

	Object blockingLock()
	void close()
	<T> T getOption(SocketOption<T> name)
	boolean isBlocking()
	boolean isOpen()
	boolean isRegistered()
	SelectionKey keyFor(Selector sel)
	Set<SocketOption<?>> supportedOptions()
	SelectorProvider provider()
	SelectableChannel configureBlocking(boolean block)






----------------------------
SocketChannel				|
----------------------------
	* SocketChannel �� Socket �������,�������� Socket ���и���Ĺ���
	* ���̳� SelectableChannel ʵ���� ByteChannel
	* û�й����Ĺ��캯��,��Ҫͨ����̬�Ĺ�������������ʵ������

----------------------------
SocketChannel ��̬����		|
----------------------------
	static SocketChannel open()
	SocketChannel open(SocketAddress remote)
		
		* open��̬�������ص�ʵ��������ģʽ,��Ҫ�ֶ�������Ϊ������ģʽ

----------------------------
SocketChannel ʵ������		|
----------------------------
	SocketChannel bind(SocketAddress local)
	boolean	connect(SocketAddress remote)
		* ����Զ������
		* ��� SocketChannel ���ڷ�����ģʽ,����������ӳɹ�,�÷������� true
		  ��������������ӳɹ�,���� false,��������������� finishConnection() �������������
		* ��� SocketChannel ��������ģʽ,����������ӳɹ�,�÷������� true
		  ����������ӳɹ�,���������״̬,ֱ�����ӳɹ�,���߳��� IO �쳣


	boolean	finishConnect()
	SocketAddress getRemoteAddress()
	boolean	isConnected()
		* �ײ�� Socket �Ƿ��Ѿ�������Զ������

	boolean	isConnectionPending()
		* �ж��Ƿ����ڽ���Զ������
		* ��Զ�����Ӳ����Ѿ���ʼ,���ǻ�û���,���� true,���򷵻� false
		* Ҳ����˵,�ײ� Socket ��û�п�ʼ����,�����Ѿ����ӳɹ����᷵�� false

	SocketChannel open()
	SocketChannel open(SocketAddress remote)

	int	read(ByteBuffer dst)
		* �� Channel �е����ݶ��뵽 dst Buffer ��
		* ���� r �ֽڱ�ʾ Buffer �� remaining() ֵ
		* ������ģʽ��,read() ��������ȡ��ȡ�� r ���ֽ�,������е����ݲ���r���ֽ�,�ͻ��������״̬
		  ֱ����ȡ��r���ֽ�,���߶�������������ĩβ,���߳�����io�쳣
		* �ڷ�����ģʽ��,read �������еȶ�����������,�Ͷ��������ݵ�ԭ��
		  read ������ȡ��ǰͨ���еĿɶ�����,�п��ܲ��� r ���ֽ�,����Ϊ0���ֽ�,
		  read �����Ƿ���,������ȵ���ȡ�� r ���ֽں��ٷ���
		* read ��������ʵ���Ͽɶ�����ֽ���,�п���Ϊ0,������� -1 �ͱ�ʾ��������ĩβ

	long read(ByteBuffer[] dsts)
	long read(ByteBuffer[] dsts, int offset, int length)

	SocketChannel setOption(SocketOption<T> name, T value)
	SocketChannel shutdownInput()
	SocketChannel shutdownOutput()
	Socket socket()
		* ���� SocketChannel ������ Socket ����

	int	validOps()
		* ���� SocketChannel ֧�ֵ��¼�
		* ���� SelectionKey.OP_CONNECT | SelectionKey.OP_READ |	SelectionKey.OP_WRITE

	int	write(ByteBuffer src)
		* �� src �е�����д�뵽 Channel
		* ������ģʽ��,write ��������ȡ���r�ֽ�,����ײ����绺������������r���ֽ�,�ͻᴦ������״̬
		  ֱ�������r���Լ�,���߳�����io�쳣
		* �ڷ�����ģʽ��,write() ���������ܹ������������,������������ݵ�ԭ��
		  �п��ܲ���r���ֽ�,����Ϊ0���ֽ�,write ����������������,������ȵ����r���ֽں��ٷ���
		* wirte ����ʵ����������ֽ���,����Ϊ0

	long write(ByteBuffer[] srcs)
	long write(ByteBuffer[] srcs, int offset, int length)

	Object blockingLock()
	SelectableChannel configureBlocking(boolean block)
		* ����IOģʽ,Ĭ��Ϊ true,��ʾ����ģʽ

	boolean	isBlocking()
	boolean	isRegistered()
		* �Ƿ��Ѿ�ע��

	SelectionKey keyFor(Selector sel)
		* ��ָ����Selector��ȡ��key

	SelectorProvider provider()
	SelectionKey register(Selector sel, int ops, Object att)
	SelectionKey register(Selector sel,int ops)
	void close()
	boolean isOpen()
	SocketAddress getLocalAddress()
	<T> T getOption(SocketOption<T> name)
	Set<SocketOption<?>> supportedOptions()









------------------------
Channel					|
------------------------
	# Channel �ӿھ�ֻ��������������
		void close();
		boolean isOpen();
	
	# Channel ����Ҫ�������ӽӿ���
		* ReadableByteChannel
			* ������ read(ByteBuffer dst) ����
			* �÷���������Դ�����ݶ������ָ���� ByteBuffer ��������

		* WritableByteChannel
			* ������ writr(ByteBuffer src)
			* �÷����Ѳ��� ByteBuffer �������е�����д�����ݻ���

		* Channel �� Buffer ��ϵ
				|<---------------- ReadableByteChannel ----------------|
			ByteBuffer												����Դ
				|----------------- WritableByteChannel --------------->|
		
		* ByteChannel ��һ�������ӿ�,��չ�� ReadableByteChannel �� WritableByteChannel,����ͬʱ֧�ֶ�д����

-----------------------------------------------
ScatteringByteChannel �� GatheringByteChannel	|
-----------------------------------------------
	# ScatteringByteChannel 
		* �ýӿ���չ�� ReadableByteChannel �ӿ�,�����ɢ�ض�ȡ����
		  ��ɢ��ȡ������ָ������ȡ����,�������������,
		* �ýӿ������� read(ByteBuffer[] dsts)����,�÷����Ѵ�����Դ��ȡ��������������䵽����ָ���� ByteBuffer ����ĸ��� Buffer ��

	# GatheringByteChannel 
		* �ýӿ���չ�� WritableByteChannel �ӿ�,�����е�д������
		  ����д��������ָ����д�����ܰѶ��������������д��һ��(���ݻ�)
		* �ýӿ������� write(ByteBuffer[] srcs)����,�÷������ΰ�srcs�е�ÿ�� Buffer �е�����д�����ݻ�
	
	# ��ɢ��ȡ�ͼ���д����,�ܹ���һ��������������������ٶ�

-----------------------------------------------
FileChannel										|
-----------------------------------------------
	# FileChannel ʵ���˽ӿ� Channel,����һ�����ļ�������ͨ��
	# ���໹ʵ���� ByteChannel,ScatteringByteChannel,GatheringByteChannel
	# ��֧�ֶ�,д,��ɢ��,����д�Ȳ���
	# ��û���ṩ public �Ĺ��췽��,���� new 
	# �� FileInputStream,FileOutputStream,RandomAccessFile ����,�����ṩ getChannel() ����,���ض�Ӧ�� FileChannel ʵ��

-----------------------------------------------
SelectableChannel								|
-----------------------------------------------
	# Ҳ��һ��ͨ��,����֧��������IO����,��֧�ַ�������IO����
	# ������������
		ServerSocketChannel
		SocketChannel
	# ����ʵ���� ByteChannel �ӿ�,���� read(ByteBuffer b); �� write(ByteBuffer src); ����
	# �ڷ�����ģʽ��,��д���ݲ�������,�������������� Selector ע���д�������¼�
	# Selector ��������Щ�¼�,���¼�������ʱ��,����:�����˶��¼�,��ô�ýӿھͿ��Խ��ж�������
	# ��Ҫ�ķ���
		 SelectableChannel configureBlocking(boolean block)
			* ��� block Ϊ true,���ʾ����Ϊ����ģʽ,����Ϊ������ģʽ
			* Ĭ�� true(����)
		
		SelectionKey register(Selector sel, int ops, Object att)
		SelectionKey register(Selector sel, int ops)
			* �� Selector ע���¼�
			* ���ص� SelectionKey,�������ٱ�ע����¼�
			* �ڶ���api��֧��Я��һ������,�ڴ�����¼���ʱ��,���Դ� SelectionKey �л���������
			* SelectionKey ��֧��������ȥ����һ������, attach(Object att)
		

	

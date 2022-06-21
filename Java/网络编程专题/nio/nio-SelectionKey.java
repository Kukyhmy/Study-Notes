----------------------------
SelectionKey				|
----------------------------
	* ServerSocketChannel ���� SocketChannel ͨ�� register() ������ Selector ע���¼���ʱ��
	  register() �����ᴴ��һ�� SelectionKey ����,�ö�������������ע���¼��ľ��
	
	* �� SelectionKey ��Ч��, Selector ��һֱ���������ص��¼�
	  ����¼�����,�ͻ�� SelectionKey ������뵽: selected-keys ������
	
	* �����������,SelectionKey �����ʧЧ,Ҳ��˵˵ Selector ��Ҳ������������ص��¼���
		1,��������� SelectionKey �� cancel() ����
		2,�ر��� SelectionKey ������ Channel
		3,�� SelectionKey ������ Selector ���ر�

----------------------------
SelectionKey �¼�����		|
----------------------------
	SelectionKey.OP_ACCEPT;
		* ������Ӿ���,��ʾ������һ���ͻ�������,���������Խ����������
		* 16

	SelectionKey.OP_CONNECT;
		* ���Ӿ����¼�,��ʾ�ͻ���������������Ѿ������ɹ���
		* 8

	SelectionKey.OP_READ;
		* �������¼�,��ʾ���������Ѿ��пɶ�����,����ִ�ж�������
		* 1

	SelectionKey.OP_WRITE;
		* д�����¼�,��ʾ�Ѿ������������д������
		* 4

----------------------------
SelectionKey-api			|
----------------------------
	void cancel()
		* ʹ SelectionKey ����ʧЧ
		* �÷����� SelectionKey ������뵽����������  Selector ����� cancelled=keys ������
		  ������һ��ִ�� Selector �� select() ����ʱ,�÷������ SelectionKey ��  Selector ����� all-keys,selected-keys.cancelled-keys ��������ɾ��

	Object attach(Object ob)
		* ʹ SelectionKey ����һ����������

	Object attachment()
		* ����  SelectionKey �����Ķ���
		
	SelectableChannel channel()
		* ������֮������ SelectableChannel ����
		
	int interestOps()
		* �������и���Ȥ���¼�

	SelectionKey interestOps(int ops)
		* ���һ������Ȥ���¼�

	boolean isAcceptable()
		* ���������¼��Ƿ����
	boolean isConnectable()
		* ���Ӿ����¼��Ƿ��Ѿ�����
	boolean isReadable()
		* ���¼�
	boolean isWritable()
		* д�¼�
		
	boolean isValid()
		* �жϵ�ǰ SelectionKey �Ƿ���Ч
		* �� SelectionKey ������,����һֱ������Ч״̬
		* ��������� cancel() ,���߹ر��˹����� Channel ����  Selector �رյ�ʱ��,����ʧЧ

	
	int readyOps()
		* ���������Ѿ��������¼�
		* ���緵��ֵ:SelectionKey.OP_WRITE | SelectionKey.OP_READ
		  ��ζ��,��������д�����¼�������,��֮������ SocketChannel ������Խ��ж�������д����

	Selector selector()
		* ���ع����� Selector ����




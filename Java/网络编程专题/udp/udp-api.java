��������������������������������������������
DatagramSocket		  |
��������������������������������������������
	# ���պͷ���UDP����,���Ƿ������ǿͻ���
	# ���캯��
		DatagramSocket()
			* ����˿�
		DatagramSocket(int port)
			* ָ���˿�
		DatagramSocket(int port, InetAddress laddr)
		DatagramSocket(SocketAddress bindaddr)
			*  ָ��ip�Ͷ˿�
	
	# ����
		setReuseAddress(true);
			* �Ƿ�����˿�����

		bind(new InetSocketAddress(1024));	
			* �󶨶˿�

		receive(DatagramPacket p)
			*  ����һ��udp����

		send(DatagramPacket p)
			*  ����һ��udp����
		
		setSoTimeout(int timeout)
			* ���ó�ʱʱ��
		
		close()
			* �ر��ͷ���Դ
		
��������������������������������������������
DatagramPacket		  |
��������������������������������������������
	# UDP���ݰ�ʵ��
	# ���캯��
		DatagramPacket(byte buf[], int length) 
		DatagramPacket(byte buf[], int offset, int length)
		DatagramPacket(byte buf[], int offset, int length,InetAddress address, int port)
		DatagramPacket(byte buf[], int offset, int length, SocketAddress address)
		DatagramPacket(byte buf[], int length,InetAddress address, int port)
		DatagramPacket(byte buf[], int length, SocketAddress address)
	
	# ����
		..����,���ܼ�
		

		
------------------------
StandardSocketOptions	|
------------------------
	# nio����ϵͳԤ�����socketѡ��	 StandardSocketOptions

		IP_MULTICAST_IF
		IP_MULTICAST_LOOP
		IP_MULTICAST_TTL
		IP_TOS
		SO_BROADCAST
		SO_KEEPALIVE
			* ��ʾ���ڳ�ʱ�䴦�ڿ���״̬��Socket�Ƿ�Ҫ�Զ������ر�
		SO_LINGER
			* ��ʾ��ִ��Socket��close()����ʱ,�Ƿ������رյײ��socket
		SO_RCVBUF
			* ��ʾ�������ݵĻ�������С
		SO_REUSEADDR
			* �Ƿ���������socket���󶨵ı��ص�ַ
		SO_SNDBUF
			* ��ʾ�������ݵĻ�������С
		TCP_NODELAY
			* �Ƿ�������������
	
	# ����
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
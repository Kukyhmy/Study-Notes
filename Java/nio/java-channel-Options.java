------------------------------
StandardSocketOptions			|
------------------------------
	# �������̳�,����������ʵ��
	# �� NetworkChannel �ӿڵ�ʵ��������ʹ��
		<T> NetworkChannel setOption(SocketOption<T> name, T value) throws IOException;
		<T> T getOption(SocketOption<T> name) throws IOException;

	# ��̬Ԥ�������
		SO_BROADCAST
		SO_KEEPALIVE
		SO_SNDBUF
		SO_RCVBUF
		SO_REUSEADDR
		SO_LINGER

		IP_TOS
		IP_MULTICAST_IF
		IP_MULTICAST_TTL
		IP_MULTICAST_LOOP

		TCP_NODELAY


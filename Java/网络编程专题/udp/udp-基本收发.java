---------------------------
UDP����						|
---------------------------
	/*
		����udp
	*/
	try(DatagramSocket datagramSocket = new DatagramSocket()){
		byte[] data = "Hello".getBytes();
		DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length, new InetSocketAddress("127.0.0.1", 10086));
		datagramSocket.send(datagramPacket);
	}

	/*
		��ָ���˿ڷ�������,���¸ö˿��Ѿ�������(�˿�����)
	*/
	try(DatagramSocket datagramSocket = new DatagramSocket(null)){
		datagramSocket.setReuseAddress(true);						//����˿�����
		datagramSocket.bind(new InetSocketAddress(1024));			//��Ҫ�ӱ��ص��ĸ��˿ڷ���
		byte[] data = "Hello".getBytes();
		// ��������,Ŀ�Ķ˿�,Ŀ��ip
		DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length, new InetSocketAddress("127.0.0.1", 10086));
		datagramSocket.send(datagramPacket);
	}

---------------------------
UDP����						|
---------------------------
	//����udpsocket����.�����˵�,�����˿�
	try(DatagramSocket datagramSocket = new DatagramSocket(10000)){
		while(true){
			//�������ݰ������ڴ洢����
			byte[] buffer = new byte[1024];//������
			DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length);
			//ͨ��socket����receive�������յ������ݴ������ݰ���(��������)
			datagramSocket.receive(datagramPacket);
			//ͨ�����ݰ��ķ�����ȡ���е�����
			String ip = datagramPacket.getAddress().getHostAddress();						//��ȡIP��
			String data = new String(datagramPacket.getData(),0,datagramPacket.getLength());//��ȡ���ݡ�
			int port = datagramPacket.getPort();											//��ȡ�˿ڡ�
		}
	}
---------------------------
Netty-UDP����				|
---------------------------

	//����udp����,ͨ�� DatagramSocet����,�󶨱����˿�
	DatagramSocket ds = new DatagramSocket(8888);
	//ȷ�����ݣ�����װ�����ݰ�
	byte[] buf = "KevinBlandy".getBytes();//String.getBytes();���ַ���ת�����ֽ����顣
	//�������ݰ�,ָ������,����,��ַ,�˿�
	DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.132.245"),10000);
	//ͨ��socket�������е����ݰ�ͨ�� send���������ͳ�ȥ��
	ds.send(dp);//����ʽ���������û���ݾͻ�һֱ��(�̻߳���)��
	//�ر���Դ
	ds.close();

	/*
		��ָ���˿ڷ�������,���¸ö˿��Ѿ�������(�˿�����)
	*/
	DatagramSocket socket = new DatagramSocket(null);	//��ֵӦ������Ϊnull
	socket.setReuseAddress(true);						//��ֵӦ��Ϊtrue
	socket.bind(new InetSocketAddress(1024));			//��Ҫ�ӱ��ص��ĸ��˿ڷ���
	byte[] bytes = hexStringToBytes(message);
	DatagramPacket p = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress(ip, Integer.parseInt(port)));
	socket.send(p);

---------------------------
Netty-UDP����				|
---------------------------
	//����udpsocket����.�����˵�,�����˿�
	DatagramSocket ds = new DatagramSocket(10000);
	while(true){
		//�������ݰ������ڴ洢����
		byte[] buf = new byte[1024];//������
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		//ͨ��socket����receive�������յ������ݴ������ݰ���(��������)
		ds.receive(dp);
		//ͨ�����ݰ��ķ�����ȡ���е�����
		String ip = dp.getAddress().getHostAddress();			//��ȡIP��
		String data = new String(dp.getData(),0,dp.getLength());//��ȡ���ݡ�
		int port = dp.getPort();								//��ȡ�˿ڡ�
		System.out.println(ip+"::"+data+"::"+port);
		//ds.close();		�ر���Դ
	}


---------------------------
Netty-TCP����				|
---------------------------
	Socket s = new Socket("120.76.182.243",8080);
	OutputStream os = s.getOutputStream();		//��������� OutputStream();�ǳ���ġ�
	InputStream is = s.getInputStream();		//���������� InputStream();�ǳ���ġ�

---------------------------
Netty-TCP����				|
---------------------------
	ServerSocket ss = new ServerSocket(8888);
	while(true){
		Socket s = ss.accept();						//�߳�����
		InputStream is = s.getInputStream();		//��ȡ InputStream
		OutputStream os = s.getOutputStream();		//��ȡ OutputStream
	}
	
UDP���䣬��������
UDP�������		DatagramSocket
��װ���ݶ���	DatagramPacket	//һ������UDP����

TCP�ͻ��˶���	Socket
TCP����������	ServerSocket
����IP����		InetAddress
-------------------------���Ͷ�  //����ÿ������� 64kb
DatagramPacket dp = new DatagramPacket(�ֽ�����,����,IP,�˿�); 
	|--�������׼������
 *ͨ��UDP���䷽ʽ����һ���������ݷ��ͳ�ȥ��
 *1���Ƚ���udpsocket����
 *2���ṩ���ݲ������ݷ�װ�����ݰ���
 *3��ͨ�� socket ����ķ��͹��ܣ������ݷ��ͳ�ȥ
 *4���ر���Դ
-------------------------���ն�
DatagramPacket dp = new DatagramPacket(�ֽ�����,����);
	|--�������ݣ�׼�����
 * 	      ������ն˵�ʱ��ͨ���������һ���˿ڡ���ʵ���Ǹ������������Ӧ�ó��������ֱ�ʾ��
 * 	      ��������ȷ��Щ���ݹ�����Ӧ�ó�����
 *
 * 1������udpsocket����
 * 2������һ�����ݰ�����ΪҪ�洢���յ����ֽ����ݡ���Ϊ���ݰ��������и��๦�ܿ�����ȡ�ֽ������еĲ�ͬ������Ϣ��
 * 3��ͨ��socket�����receive�������յ������ݴ����Ѷ���õ����ݰ��У�
 * 4��ͨ�����ݰ���������й��ܣ�����Щ��ͬ������ȡ������ӡ�ڿ���̨�ϡ�
 * 5���ر���Դ��
DatagramPacket dp = new DatagramPacket();//��ʵ�ϲ�û�пչ��캯��
dp.getAddres();//���ش����ݵ�IP��ַ
dp.getData();//�������ݻ�������Ҳ������������� byte[]
dp.getPort();//��ȡ���ݷ��͵Ķ˿ں�
dp.getLength();//��ȡ�����ݵĳ��ȡ�
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
TCP���䣬��������
tcp���������ӵġ��ڸö�������ʱ����Ҫȥ����ָ��������
��Ϊtcp���������ӵġ������ڽ��� Socket ����ʱ����Ҫ�з���˴��ڲ����ӳɹ����γ�ͨ·���ڸ�ͨ���������ݡ�
1,tcp�ֿͻ��˺ͷ����
2,�ͻ��˶�Ӧ�Ķ����� Socket
  ����˶�Ӧ�Ķ����� ServerSocket

 
-------------------------�ͻ���		Socket
 
�ͻ��ˣ�
1������ socket ����ָ��Ҫ���������˿ڡ�
	|--Socket s = new Socket(IP,�˿�);
2����ȡ socket �е��������������д�������С�ͨ�����緢�͸�����ˡ�
	|--OutputStream os = s.getOutputStream();	//��������� OutputStream();�ǳ���ġ�
3����ȡ socket ���е���������������˷��������ݻ�ȡ��������ӡ��
	|--InputStream is = s.getInputStream();		//���������� InputStream();�ǳ���ġ�
4���رտͻ�����Դ��
	s.close();

-------------------------�����		ServerSocket
1,�������񣬲�����һ���˿�
	|-ServerSocket ss = new ServerSocket(�˿�);
2,��ȡһ�����ӹ����Ŀͻ��˶���
	|--Socket s = ss.accept();//����ʽ������û�����Ӿͻ�һֻ�ȴ���
3,�ͻ�������з������ݣ���ô�����Ҫʹ�ö�Ӧ�Ŀͻ��˶��󡣲���ȡ�ÿͻ��˶���Ķ�ȡ��������ȡ������������
	|--InputStream is = s.getInputStream();
4,����������Ҫ��ͻ��˷������ݣ���ôͬ��ҲҪ��Ҫ��ȡ���ͻ��������������ͻ����������	
	|--OutputStream os = s.getOutputStream();
4,�رշ����(��ѡ�ģ���һ��Ҫ�رա�һ�����������7*24Сʱ����)

-------------------------------
URL/URI(��ʾ��Χ�Ƚϴ�)
URL url = new URL("url��ַ");
url.getProtocol();
	|--��ȡurl��Э�����ơ����� String ���͡�
url.getHost();
	|--��ȡurl��������(����)������ String ���͡�
url.getPath();
	|--��ȡurl��·�������� String ���͡�
url.getPort()
	|--���ش�URL�Ķ˿ںš� int ���͡����δ����˿ںžͷ��� -1.
url.getFile()
	|--��ȡurl���ļ��������ص��ļ�����(����������)�� String ���͡����û���ļ������򷵻ؿ��ַ������������� null.
url.getQuery()
	|--��ȡurl�Ĳ�ѯ���֡����û�У��򷵻� null.��ȡ����·���Ͳ�����
url.openConnection();
	|--�������url�����ص���һ�� URLConnection �����ܹ������ļ�ͷ(������ô���).
								  |--
								  getInputStream();
									|--���شӴ˴򿪵����Ӷ�ȡ���������� �ڶ�ȡ���ص�������ʱ����������ݿɹ���ȡ֮ǰ�ﵽ���볬ʱʱ�䣬����׳� SocketTimeoutException��
								  getOutputStream();
									|--����д�뵽�����ӵ��������
��������
	DNS������
	������Ȼ��ڱ���Ѱ���������������û���ٳ�������DNS����������������������IP��

------------------------
UDP-�����				|
------------------------
	DatagramSocket ds = new DatagramSocket(10005);
	while(true){
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		ds.receive(dp);
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(),0,dp.getLength());
		System.out.println(ip+":"+data);
	}

------------------------
UDP-�ͻ���				|
------------------------
	DatagramSocket ds = new DatagramSocket();
	BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
	String line = null;
	while((line=bufr.readLine())!=null){
		if(line.equals("886")){
			break;
		}
		byte[] buf = line.getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.131.174"), 10005);
		ds.send(dp);
	}
	ds.close();


------------------------
TCP-�����				|
------------------------
		ServerSocket ss = new ServerSocket(10005);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"------����ing");
		//��ȡsocket��ȡ���е�����
		BufferedReader bufin = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//Ŀ�� socket�����������д����д�뵽socket������������͸��ͻ���
		BufferedWriter bufout = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		String line = null;
		while ((line = bufin.readLine()) != null)
		{
			bufout.write(line.toUpperCase());
			bufout.newLine();
			bufout.flush();
		}
		s.close();
		ss.close();
------------------------
TCP-�ͻ���				|
------------------------
		Socket s = new Socket("192.168.126.156",10005);
		//�����ȡ�������ݵ�������
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		//����Ŀ�ĵء�������д�� socket������������ͻ���
		BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		//����һ�� socket��ȡ������ȡ����˷��صĴ�д��Ϣ��
		BufferedReader bufin = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
			{
				break;
			}
			bufwOut.write(line);
			bufwOut.newLine();
			bufwOut.flush();
			String str = bufin.readLine();
			System.out.println("������"+str);
		}
		bufr.close();
		s.close();
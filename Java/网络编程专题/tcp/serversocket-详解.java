------------------------
ServerSocket			|
------------------------
	# �˿ڰ�
		* ����ǰ�  1 - 1023�˿�,����ʹ�ù�����Ȩ��ִ�г���,��������׳��쳣
		* ����������Ϊ0,��ôϵͳ���ѡ��˿ڽ��а�
			ServerSocket(0)

	# ���ÿͻ���������еĳ���,Ĭ��Ϊ50
		* ��������
			ServerSocket(1024,50)
		* �����������������,�µĿͻ������Ӿͻ��׳��쳣
		* ServerSocket ���캯���е� backlog ���������ƶ��г���,�Ḳ��ϵͳ�޶��Ķ�����󳤶�
		* �ڼ��������,��Ȼ����ò���ϵͳ�޶��Ķ�����󳤶�
			* backlog ������ֵ���ڲ���ϵͳ�޶��Ķ��е���󳤶�
			* backlog ������ֵС�ڻ����0
			* ServerSocket ���췽����û������ backlog ����

	# ��������ַ
		* һ������ֻ��һ����ַ,Ĭ�Ͼͻ����
		* ��������߱��������,һ���������Ӿ�������(192.168.3.4),һ���������ӻ�����(59.110.167.11)
		  �����ĳ���,ֻ����������û�����,����Ҫ��ip��������
			new ServerSocket(1024,50,InetAddress.getByName("192.168.3.4"));
		* �����󶨵ĵ�ַ��:0.0.0.0,��ϵͳ������󶨵�һ��ip��ַ
			new ServerSocket(1024,50,InetAddress.getByName("0.0.0.0"));

	# �޲εĹ��췽��
		* ��һ���ޅ��Ĺ��췽��
			ServerSocket();
		* ʹ�����ַ�ʽ������ʵ������,��ô����Ҫͨ�� bind() api ����ɰ�
			 void bind(SocketAddress endpoint)
			 void bind(SocketAddress endpoint, int backlog)
		* ����ޅ������������,����������ڰ󶨵�ָ���˿�֮ǰ,����һЩ Socket ��ѡ������
		  ��Ϊ��Щ����,һ����������˿ڰ���,�Ͳ����ٸ�����

		* ���ö˿�����demo
			ServerSocket serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			serverSocket.bind(new InetSocketAddress("0.0.0.0",1024));
			
		
	# ���տͻ��˵�����
		* ͨ��api accept() ����ȡ�µ�����,��api��һֱ����,ֱ���µ�����
		* ����ͻ�����������Ͽ�������,�������˻��׳�һ��:SocketException,����쳣Ӧ�ñ�����,����Ӱ�����˼���Ϊ�����ͻ����ṩ����
	
	# �ر� ServerSocket
		* ������һ�㲻��ر�,24H * 7 �������ṩ����
		* ��һЩ�����,ϣ����ʱ�ͷŷ������Ķ˿�,�Ա��������ĳ���ռ��,����ִ�� close() api
		* isBound() api�����ж��Ƿ��Ѿ����˶˿�,��ʱ ServerSocket �Ѿ����ر�
		* isClosed() api�����ж��Ƿ�ر�,ֻ����ִ���� close() api ��,�÷������� true.
		* ȷ��һ�� ServerSocket �Ѿ����˶˿�,����û�б��ر�
			boolean isService = serverSocket.isBound() && !serverSocket.isClose();
	
	# ��ȡ ServerSocket ����Ϣ
		* ��ȡ�������󶨵�ip��ַ/�˿�
			InetAddress getInetAddress()
			int getLocalPort()
		
	# ServerSocket ѡ��
		* ServerSocket �߱�����ѡ��
			1,SO_TIMEOUT
				* ��ʾ�ȴ��ͻ������ӵĳ�ʱʱ��
			2,SO_REUSEADDR
				* ��ʾ�Ƿ������ַ�ظ�
			3,SO_RCVBUF
				* ��ʾ�������ݵĻ�������С
		* SO_TIMEOUT
			* accept()�ȴ��ͻ������ӵĳ�ʱʱ��,��λ�Ǻ���
			* api
				void setSoTimeout(int timeout)
				int getSoTimeout()
			* �����ֵΪ:0,����Զ���ǳ�ʱ,��Ҳ��Ĭ��ֵ
		
		* SO_REUSEADDR
			* �������
		
		* SO_RCVBUF
			* api
				void setReceiveBufferSize (int size)
				int getReceiveBufferSize()
			* ���û�������С,�����ڰ󶨶˿�֮ǰ�������ò���Ч
			* setReceiveBufferSize() ����,�൱�ڶ������� accpet()�������ص� Socket ���ý������ݵĻ�������С

	# ��������ʱ��,�ӳ�,����������Ҫ��
		* api
			void setPerformancePreferences(int connectionTime,int latency,int bandwidth)
		* �������
	

		

			
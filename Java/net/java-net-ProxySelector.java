--------------------------------
ProxySelector
--------------------------------
	# ����ѡ����������

	# ��̬����
		static ProxySelector getDefault() 
		static void setDefault(ProxySelector ps)
		static ProxySelector of(InetSocketAddress proxyAddress)


	# ���󷽷�
		abstract List<Proxy> select(URI uri);

		abstract void connectFailed(URI uri, SocketAddress sa, IOException ioe);

		


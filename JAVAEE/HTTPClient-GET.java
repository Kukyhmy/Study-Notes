---------------------
����GET����			 |
---------------------
	public static void main(String[] args) throws Exception {
		// ����Httpclient����		�������Ϊ�������
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// ����http GET����			�������Ϊ�����ַ
		HttpGet httpGet = new HttpGet("http://www.baidu.com/");
		CloseableHttpResponse response = null;
		try {
			// ʹ�� Httpclient ִ������		�������Ϊ��!��!��!
			response = httpclient.execute(httpGet);
			// �жϷ���״̬�Ƿ�Ϊ200
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				//��ȡ��Ӧ����
				HttpEntity entity = response.getEntity();
				//����Ӧ�Ķ���,ת��Ϊ utf8��ʽ���ı��ļ�
				String content = EntityUtils.toString(entity, "UTF-8");
				System.out.println("���ݣ�"+content);
			}
		} finally {
			if (response != null) {
				//�ر��������������
				response.close();
			}
			//�ر�"�����"
			httpclient.close();
		}
	}

---------------------
����GET����			 |
---------------------
	 public static void main(String[] args) throws Exception {
        // ����Httpclient����		�������Ϊ�������
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // ����http GET����		�������Ϊ�����ַ,�����Ǵ������� setParameter(key,value);������N���
        URIBuilder builder = new URIBuilder("http://www.baidu.com");
		/*
			����������صĻ��ǵ�ǰ����,˵����.������������	
		*/
        builder.setParameter("key1", "value1");
        //���ò���n
        builder.setParameter("key2", "value2");
        //ת��ΪURI����
        URI uri = builder.build();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = null;
        try {
            // ʹ�� Httpclient ִ������		�������Ϊ��!��!��!
            response = httpclient.execute(httpGet);
            // �жϷ���״̬�Ƿ�Ϊ200
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            	//��ȡ��Ӧ����
            	HttpEntity entity = response.getEntity();
            	//����Ӧ�Ķ���,ת��Ϊ utf8��ʽ���ı��ļ�
                String content = EntityUtils.toString(entity, "UTF-8");
                System.out.println("���ݣ�"+content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
    }
	//��ʵ��һ�ַ�ʽ,ֱ����URL����ͨ��'?'��Ӳ���Ҳ�ǿ��Դﵽ�����ύ��Ч��.ֻ��˵�ڶ��ֿ������Ƚϵ�����

---------------------
HTTPClient��һЩAPI	 |
---------------------
	httpGet.setHeader("key","value");
		* ��������ͷ,����ģ�������
		* httpPostҲ����ʹ��
	
	Header[] hreaders = response.getAllHeaders();
	for(Header head : hreaders){
		System.out.println(head.getName()+":"+head.getValue());
	}
		* ��ȡ������������Ӧͷ����


---------------------
���ӹ���			 |
---------------------
	  public static void main(String[] args) throws Exception {
			PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
			// �������������
			cm.setMaxTotal(200);
			// ����ÿ��������ַ�Ĳ�����
			cm.setDefaultMaxPerRoute(20);
			doGet(cm);
			doGet(cm);
		}
		public static void doGet(HttpClientConnectionManager cm) throws Exception {
			CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
			// ����http GET����
			HttpGet httpGet = new HttpGet("http://www.baidu.com/");
			CloseableHttpResponse response = null;
			try {
				// ִ������
				response = httpClient.execute(httpGet);
				// �жϷ���״̬�Ƿ�Ϊ200
				if (response.getStatusLine().getStatusCode() == 200) {
					String content = EntityUtils.toString(response.getEntity(), "UTF-8");
					System.out.println("���ݳ��ȣ�" + content.length());
				}
			} finally {
				if (response != null) {
					response.close();
				}
				// �˴����ܹر�httpClient������ر�httpClient�����ӳ�Ҳ������
				// httpClient.close();
			}
		}

		# ���ӳ�-���ַ�ʽ��Ϊ��ѧ,����ÿ�ζ�ȥ����HTTPClient����,�������������


---------------------
�������õ�����		 |
---------------------
	public static void main(String[] args) throws Exception {
        // ����Httpclient����
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // ����http GET����
        HttpGet httpGet = new HttpGet("http://www.baidu.com/");
        // ��������������Ϣ
		RequestConfig config = RequestConfig.custom().setConnectTimeout(1000) 	// �������ӵ����ʱʱ��(����)
                .setConnectionRequestTimeout(500) 								// �����ӳ��л�ȡ�����ӵ��ʱ��(����)
                .setSocketTimeout(10 * 1000) 									// ���ݴ�����ʱ��(����)
                .setStaleConnectionCheckEnabled(true) 							// �ύ����ǰ���������Ƿ����(�Ѿ�����)
                .build();
        // ��������������Ϣ
        httpGet.setConfig(config);
        CloseableHttpResponse response = null;
        try {
            // ִ������
            response = httpclient.execute(httpGet);
            // �жϷ���״̬�Ƿ�Ϊ200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
    }

---------------------
����Spring			 |
---------------------
	# HttpClient����Spring
		* ����Ҫ���ϰ�,ֱ��������������¶�
	

	<!-- �����ⲿ���� -->
	<context:property-placeholder location="classpath:httpclient.properties" ignore-unresolvable="true"/>

	<!-- 
		HTTP�ӹ�����,ָ�����ٷ��� 
	-->
	<bean id="httpClientConnectionManager" class="org.apache.http.impl.conn.PoolingHttpClientConnectionManager" destroy-method="close">
		<!-- ��������� -->	
		<property name="maxTotal" value="${http.maxTotal}"/>
		<!-- ÿ���������������(����)�� -->
		<property name="defaultMaxPerRoute" value="${http.defaultMaxPerRoute}"/>
	</bean>

	<!-- 
		HttpClient ������ 
	-->
	<bean id="httpClientBuilder" class="org.apache.http.impl.client.HttpClientBuilder">
		<!-- ע��HTTP���ӹ����� -->
		<property name="connectionManager" ref="httpClientConnectionManager"/>
	</bean>

	<!-- 
		RequestConfig ������
	 --> 
	<bean id="requestConfigBuilder" class="org.apache.http.client.config.RequestConfig.Builder">
		<!-- �������ӵ����ʱʱ�� -->
	  	<property name="connectTimeout" value="${http.connectTimeout}"/>
	  	<!-- �����ӳ��л�ȡ�����ӵ��ʱ�� -->
	 	<property name="connectionRequestTimeout" value="${http.connectionRequestTimeout}"/>
	 	<!-- ���ݴ�����ʱ�� -->
	 	<property name="socketTimeout" value="${http.socketTimeout}"/>
	 	<!-- �ύ����ǰ���������Ƿ����(API �Ѿ�����) 
	 	<property name="staleConnectionCheckEnabled" value="${http.staleConnectionCheckEnabled}"/>-->
	</bean>

	<!-- 
		RequestConfig �������ÿ�����
		���Bean ���� id Ϊ requestConfigBuilder �� Bean �� build ����������IOC 
		�����Ҫ,��������.��ô�Ͱ����ע�뵽��Ҫ����
	 --> 
	 <bean class="org.apache.http.client.config.RequestConfig" factory-bean="requestConfigBuilder" factory-method="build"/>

	 <!-- 
		HttpClient
		���Bean ���� id Ϊ httpClientBuilder �� Bean �� build ����������IOC 
		����,�������.�����ǵ���.ÿ�λ�ȡ��ͨ�� httpClientBuilder ��� build �õ��µ�ʵ��
		����һ��ִ��:HTTP �����ִ����,������ҪHTTP����,��ע����
	 -->
	<bean class="org.apache.http.impl.client.CloseableHttpClient" factory-bean="httpClientBuilder" factory-method="build" scope="prototype"/>

	<!-- 
		����������Ч���� 
	-->
	<bean class="com.taotao.web.httpclient.IdleConnectionEvictor" destroy-method="shutdown">
		<!--  ������ע��: HTTP�ӹ�����-->
		<constructor-arg index="0" ref="httpClientConnectionManager"/>
	</bean>


	
	
	httpclient.properties
	
		# ���������
		http.maxTotal=1000
		# ÿ���������������(����)��
		http.defaultMaxPerRoute=100
		# �������ӵ����ʱʱ�� 
		http.connectTimeout=2000
		# �����ӳ��л�ȡ�����ӵ��ʱ��
		http.connectionRequestTimeout=500
		# ���ݴ�����ʱ��
		http.socketTimeout=60000
		# �ύ����ǰ���������Ƿ����(�Ѿ�����) 
		http.staleConnectionCheckEnabled=true
	





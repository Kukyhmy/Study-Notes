------------------------
ssl						|
------------------------
	# SSL
		* netscape ��˾���,Server Socket Layer
	
	# Java�İ�ȫ�׽�����չ JSSE(Java Secure Socket Extension)
		* Ϊ����SSL��TLSЭ���Java����Ӧ���ṩ��Java API�Ͳο�ʵ��
		* ֧�����ݼ���,������������,����������,�Լ���ѡ�Ŀͻ����������
	
	# TLS/SSL
		* Ŀǰ��˵TSL1.0��SSL3.0���ǳ�С
	


	# ���
		javax.net
		javax.net.ssl
		java.security.cert

		KeyStore
			* ��Կ֤��洢��ʩ
			* ����������ڴ�Ű�ȫ֤��,��ȫ֤��һ�����ļ���ʽ���
			* KeyStore ����֤����ص��ڴ�

		KeyManagerFactory
		KeyManager
			* ��Կ������
			* ��ѡ������֤ʵ�Լ���ݵİ�ȫ֤��,����ͨ����һ��

		TrustManagerFactory
		TrustManager
			* ���ι�����
			* �����жϾ����Ƿ����ζԷ��İ�ȫ֤��
			
			|-X509TrustManager
			|-X509Certificate
		

		SSLContext
			* ������SSL/TLSЭ��ķ�װ,��ʾ�˰�ȫ�׽���Э���ʵ��
			* ��Ҫ�������ð�ȫͨ�Ź����еĸ�����Ϣ,�����֤����ص���Ϣ
			* ���Ҹ��𹹽� SSLSocketFactory,SSLServerSocketFactory �� SSLEngine �ȹ�����
				  void init(KeyManager[] keyManagers, TrustManager[] trustManagers, SecureRandom secureRandom);

					keyManagers
						* ʹ��֤������֤��,���Ϊnull,ϵͳ�ᴴ��Ĭ�ϵ�KeyManager����,�Լ�������KeyStore����
						* KeyStore�����ϵͳ����:javax.net.ssl.keyStore �л�ȡ��ȫ֤��,��������ڸ�����,��ôKeyStore���������Ϊ��

					trustManagers
						* ���ε�֤��,���Ϊnull,ϵͳ�ᴴ��Ĭ�ϵ�TrustManager����,�Լ�������KeyStore����
						* KeyStore���������²���ȥ��ȡ��ȫ֤��,������²���Ϊ��ʧ��,��KeyStore���������Ϊ��
							1, ���Դ�ϵͳ����: javax.net.ssl.trustStore �����л�ȡ
							2, ���԰� ${JAVA_HOME}/jre/lib/security/jssecacerts �ļ���Ϊ��ȫ֤��
							...

					secureRandom
						* ��ȫ�������,�������Ϊnull,��ʹ��Ĭ�ϵ�


		SSLServerSocketFactory
		SSLServerSocket(ServerSocket����)

		SSLSocketFactory
		SSLSocket(Socket����)

		SSLEngine
			* SSL����������
			* NIOͨ��,ʹ�������,����ͨ������֧�ַ������İ�ȫͨ��
				void setUseClientMode(true);
					* ��ǰ�ǿͻ���ģʽ���Ƿ����ģʽ

				void setNeedClientAuth(false);
					* �Ƿ�ҪУ��ͻ��˵�֤��

				void setWantClientAuth(true);	
					* ϣ���Է�����ȫ֤��,����Է����ṩ,���Ӳ����ж�,ͨ�ż�������

				void setNeedClientAuth(false);	 
					* Ҫ��Է������ṩ��ȫ֤��,����Է����ṩ,�����ж�,ͨ���޷�����

		SSLSession
			* SSL�Ự
			* ��ȫͨ�����ֹ�����Ҫһ���Ự,Ϊ�����ͨ�ŵ�Ч��
			* SSLЭ��������SSLSocket����ͬһ��SSL�Ự,��ͬһ���Ự��,ֻ�е�һ���򿪵� SSLSocket ��Ҫ����SSL����,����������Կ��������Կ,����SSLSocket��������Կ��Ϣ

		
			

		SecureRandom

		CertificateFactory

------------------------
ssl						|
------------------------

// JKS��֤������
char[] password = "123456".toCharArray();

// ����֤���ļ�
KeyStore keyStore = KeyStore.getInstance("JKS");
keyStore.load(Files.newInputStream(Paths.get("")),password);

// KeyManager��ѡ������֤��������ݵ�֤��,���뷢�͸��Է�
KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
keyManagerFactory.init(keyStore,password);
KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();

// TrustManager �����Ƿ����ζԷ���֤��
TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
trustManagerFactory.init(keyStore);
TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

SSLContext sslContext = SSLContext.getInstance("TLS");

// ���õ�ǰsocketʹ�õ�֤��,�Լ����ε�֤��,�������Դ
sslContext.init(keyManagers,trustManagers,null);

// ����nio
SSLEngine sslEngine = sslContext.createSSLEngine();

// ����bio
SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

------------------------
ssl						|
------------------------
/**
 *
 * @param keyPath			��ǰSocketʹ�õ�֤��
 * @param keyPassword		����
 * @param trustPath			����֤��
 * @param trustPassword		����
 * @return
 * @throws Exception
 */
public SSLContext sslContext(InputStream keyPath, String keyPassword, InputStream trustPath, String trustPassword) throws Exception {

	// ����socket֤��
	KeyStore keyStore = KeyStore.getInstance("JKS");
	keyStore.load(keyPath,keyPassword.toCharArray());

	KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
	keyManagerFactory.init(keyStore,keyPassword.toCharArray());
	KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();


	// ����Trust����֤��
	TrustManager[] trustManagers = null;
	if(trustPath != null && trustPassword != null){

		KeyStore trustKeystore = KeyStore.getInstance("JKS");
		trustKeystore.load(trustPath,trustPassword.toCharArray());

		TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
		trustManagerFactory.init(trustKeystore);
		trustManagers = trustManagerFactory.getTrustManagers();
	}

	SSLContext sslContext = SSLContext.getInstance("TLS");
	sslContext.init(keyManagers,trustManagers,new SecureRandom());

	return sslContext;
}



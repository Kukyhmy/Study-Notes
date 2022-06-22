----------------------------
Tomcat-�Ż�					|
----------------------------
	# �����Tomcat7


----------------------------
Tomcat-���ù����˻�			|
----------------------------
	# �� conf/tomcat-users.xml������û�
		<role rolename="manager"/>
		<role rolename="manager-gui"/>
		<role rolename="manager-script"/>
		<role rolename="admin"/>
		<role rolename="admin-gui"/>
		<user username="tomcat" password="a12551255" roles="manager,manager-script,manager-gui,admin,admin-gui"/>
	
	
	# Ȩ��˵��
		manager
		manager-gui
		manager-script
		manager-jmx
		manager-jax
		manager-status
		admin
		admin-gui


----------------------------
Tomcat-����ģʽ				|
----------------------------
	# tomcat�ṩ��������ģʽ
	1,bio
		* Ĭ�ϵ�ģʽ,���ܷǳ�����,û�о����κ��Ż��ʹ���
	2,nio
		* NIO(new IO),��JAVASE1.4�Լ������汾�ṩ��һ���µ�IO������ʽ,Ҳ���� java.nio��,���Ӱ�.java nio�ǻ���һ��������.�����ṩ������IO������JAVAAPI
		* NIOҲ�������� non-blocking IO����д,���ȴ�ͳ��IO(BIO)����,�и��õĲ�������
	3,apr
		* ��װ����������,���ǴӲ���ϵͳ����������첽IO������,����ȵ��������
	

----------------------------
Tomcat-����NIOģʽ			|
----------------------------
	1,�޸�server.xml���Connector�ڵ�,�޸�: protocolΪ:org.apache.coyote.http11.http11NioProtocol
		* protocol="org.apache.coyote.http11.Http11NioProtocol"
		* ��ʵ�����ļ��������һ��ע�͵�����.ֱ�ӿ��� copy
	# ����IOģʽ
		org.apache.coyote.http11.http11NioProtocol
			* NIO
		org.apache.coyote.http11.Http11Nio2Protocol
			* AIO

----------------------------
Tomcat-ִ����(�̳߳�)		|
----------------------------
	# tomcat��,ÿһ���û�������һ���߳�,���Կ���ʹ���̳߳����������
	# Tomcat Ĭ��û�������̳߳�

	1,���̳߳ص�ע��
		<Service name="Catalina">
		<!--The connectors can use a shared executor, you can define one or more named thread pools-->
		<!-- 
			�����ע�� ,�� name="Catalina" ��Service �ڵ���
		-->
		<Executor name="tomcatThreadPool" namePrefix="catalina-exec-"
			maxThreads="150" minSpareThreads="4"/>

		* maxThreads			:(int)���������			
		* minSpareThreads		:(int)��С��Ծ�߳���
		* maxQueueSize			:(int)���ȴ�������,����������ܾ�
		* prestartminSpareThreads:(boolean)�Ƿ���������ʱ��,������ minSpareThreads ���߳�

   2,ָ���̳߳�
		<Connector executor="tomcatThreadPool" port="8080" protocol="org.apache.coyote.http11.Http11NioProtocol"
				   connectionTimeout="20000"
				   redirectPort="8443" />

	
	# ���ʵ��
		<Executor name="tomcatThreadPool" namePrefix="catalina-exec-"
			maxThreads="800" minSpareThreads="100" maxQueueSize="100" prestartminSpareThreads="true"/>

----------------------------
Tomcat-������(Connecter)	|
----------------------------
	# Connecter��Tomcat������������,ÿ��Connecter�����Լ�ר���ļ����˿�
	# Connecter����:
		HTTP Connector 
		AJP  Connector
	
	# ͨ������(̫TM����... ...�Լ�ȥ��)
		* ����������ҵ���Ѳ���˵��?
		* http://localhost:8080/docs/config/http.html

		allowTrace
			* ����������ܹ������û���HEAD/TRACE����,���ֵӦ���� true,Ĭ��ֵΪ false
		
		asyncTimeout
			* Ĭ�ϳ�ʱ�Ժ���Ϊ��Ϊ��λ���첽����,���û��ָ��,������ֵĬ�� 10000(10��)
		
		enableLookups
			* Ĭ�� false,����ͨ�� request ��һ��������ȡ�û�������ʱ��,��ȥ����DNS������
		
		maxPostSize
			* ָ�����POST����Ĵ�С,Ĭ��ֵ:2097152(2��),�������Ϊ0,���ʾû������
		
		port
			* �˿�,����˵.�������Ϊ:0,�� Tomcat Ϊ���������ѡ��һ�����ж˿�.
		
		protocol
			* ָ������ģʽ
		
		compression
			* �Ƿ����ı�����ѹ��,ʹ��GZIP
			* ���ܵ�ֵ
				off			//����ѹ��
				on			//����ѹ��
				force		//ǿ�������������ѹ��
		


	# ���ʵ��
		
		<Connector
			executor="tomcatThreadPool"
			port="8080"
			protocol="org.apache.coyote.http11.Http11NioProtocol"
			redirectPort="8443"
			enableLookups="false"
			URIEncoding="UTF-8"
			acceptCount="100"
			acceptorThreadCount="2"
			disableUploadTimeout="true"
			maxConnections="10000"
			SLLEnabled="false"
		/>

----------------------------
Tomcat-����JPA������		|
----------------------------
	AJP��Apache JServer Protocol��
	AJPv13Э����������ġ�WEB��������Servlet����ͨ��TCP������������Ϊ�˽�ʡSOCKET�����İ�����ۣ�WEB�������᳢��ά��һ������TCP���ӵ�servlet�����������ڶ���������Ӧ���ڹ��̻��������ӡ�
	
	# ˵����,����΢�� IIS,������ Apache ������,��Tomcatͨ��
	# ����һ����ʹ��Nginx+tomcat�ļܹ��������ò���AJPЭ�飬���԰�AJP���������á�

	# ֱ��ע�͵�AJP
		<!--
		<Connector port="8009" protocol="AJP/1.3" redirectPort="8443" />
		-->


----------------------------
Tomcat-JVM�����Ż�			|
----------------------------
	 ջ
		* JAVA��ջ�Ǹ�ÿһ���߳���ص�,JVM����һ���̵߳�ʱ��,�ͻ������̷߳���һ��ջ�ռ�.
		* ��Ҫ�洢,�߳�����ʱ��ľֲ�����,��������ֵ.�Լ��������õ�������,ջ�ռ������̵߳���ֹ���ͷ�
	
	��
		* JAVA�еĶ�,�������̹߳����һ���ڴ�����.�����������JAVA����,����,�̵߳�
	
	
	�ѷ���
		* JAVA�Ķ�,���Է�Ϊ��������
		1,Young
			* ������
			* new һ������,��������
			* GC������������Ķ���
			* ���˵����GC�˼��ζ�û����,�ͻ�������������

		2,Tenured
			* ������
			* �����������ڳ��Ķ���,һ�㲻�ᱻGC����,��Ҳ���Ǿ���

		3,Perm
			* ������
			* ����һ��Ӧ�õ�ʱ��,Class ����,��ı���
			* ������Ķ���,�ǲ��ᱻ���յ�
		
	# JVM��������

		-Xms
			* JVM��ʼ�������Ժ��ʼ�ڴ�
		-Xmx
			* JVM�ѵ�����ڴ�,JVM������,����� -Xmx����ָ����С���ڴ��JVM,���ǲ�һ��ȫ��ʹ��.
			* JVM�����Xms����������������JVM�ڴ�

		* �������,������Virtual�ռ��С
			
		-XX:PermSize=116M -XX:MaxPermSize=64M
	# Tomcat �����õĳ��ò���
		* �޸������ļ�:bin/catalina.sh
		* ע��,�������ŵ�
		JAVA_OPTS="-Dfile.encoding=UTF-8 -server -Xms1024m -Xmx2048m -XX:NewSize=512m -XX:MaxNewSize=1024m -XX:PermSize=256m -XX:MaxPermSize=256m -XX:MaxTenuringThreshold=10 -XX:NewRatio=2 -XX:+DisableExplicitGC"

		file.encoding
			* Ĭ���ļ��б���
		-Xmx1024m
			* ����JVM�������ڴ�Ϊ1024
		-Xms1024m
			* ����JVM��С�ڴ�Ϊ1024
			* ���ֵ�������������ͬ,�Ա���ÿ���������պ�JVM���·����ڴ�
		-XX:NewSize
			* �����������С
		XX:MaxNewSize
			* ���������������С
		-XX:PermSize
			* �������ô���С
		-XX:MaxPermSize
			* ����������ô���С
		-XX:NewRatio=4	
			* ��������������ô��ı�ֵ...

		-XX:MaxTenuringThreshold=0
			* ���������������
		-XX:+DisableExplicitGC
			* ������û�����ֶ���GC����
	
	* ������������ java -XmxXXXXM -version ���������в��ԣ�Ȼ���𽥵�����XXXX��ֵ�����ִ�������ͱ�ʾָ�����ڴ��С���ã�������ӡ������Ϣ��ʾ�����£� 
		java -Xmx3072M -version��
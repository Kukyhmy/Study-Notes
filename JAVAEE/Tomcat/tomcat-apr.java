--------------------
apr					|
--------------------
	# ����������Դ������Tomcat�Ծ�̬�ļ��Ĵ�������,ͬʱ�����ʹ����HTTPS��ʽ����Ļ�,Ҳ��������SSL�Ĵ�������


	# ��������
		* ���ص�ַ:http://apr.apache.org/download.cgi
			apr-1.6.5.tar.gz
			apr-util-1.6.1.tar.gz
			apr-iconv-1.2.2.tar.gz
			tomcat-native.tar.gz
				* �� ${TOMCAT_HOME}/lib Ŀ¼��,����Ҫ����
	
	# ��ѹ��װ apr-1.6.5.tar.gz  
		tar -xvf apr-1.6.5.tar.gz   
��������cd apr-1.5.2   
		./configure   
		make && make install
	
	# ��ѹ��װ tomcat-native.tar.gz
		tar -xvf tomcat-native.tar.gz
		cd tomcat-native-1.2.17-src/native
		./configure --with-apr=/usr/local/apr --with-java-home=/usr/local/java/jdk1.8.0_181
		make && make install

		* --with-apr �ǰ�װapr�Զ����ɵİ�װĿ¼
		* --with-java-home ���Լ�������JavaĿ¼
	
	# ��������
		vim /etc/profile   
		export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/usr/local/apr/lib   
		source /etc/profile
	
	# �޸�Tomcat����
		* �޸�server.xml�����ļ�
		* Connector �ڵ�� protocol ����
			protocol="org.apache.coyote.http11.Http11AprProtocol"

--------------------
apr-windows			|
--------------------
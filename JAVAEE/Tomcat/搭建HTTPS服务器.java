----------------------------
Tomcat-�HTTPS������		|
----------------------------
	# ����HTTPS,���ڱ���.
	
	1,Ϊ��վ��������֤��
		
		* ʹ�õ���$JAVA_HOME/bin/keytool ����(JAVA�����Դ��Ĺ���)

		* keytool -genkey -alias tomcat -validity 36500 -keystore D:\home\tomcat.keystore -keyalg RSA

			* -genkey		:��ʾ������Կ��
			* -alias		:��ʾ�������
			* -keyalg		:ָ����Կ�㷨
			* -validity		:��Կ��Чʱ��,Ĭ��Ϊ90��,36500.��ʾ100��
			* -keystore		:ָ����Կ�����·��

		
	
		* ���� keystore ����
			������֤��,ϵͳ��ʹ��һ����Կ��������,�������������Կ�������
		
		* ����������������ʲô?
			��һ������Ҫ,��ʾΪ�ĸ���վ��������֤��,��д����
		
		* ������֯��λ������ʲô��
			* ����
		
		* ������֯������ʲô��
			* ����
		
		* �����ڵĳ��л�������������ʲô?
			* ����
		
		* �����ڵ���,��ʡ����ʲô?
			* ����
		
		* �õ�λ������ĸ���Ҵ�����ʲô?
			* ����
		
		* CN=localhost,OU=Unknow,O=Unknow,L=Unknow,ST=Unknow,C=Unknow ��ȷ��?
			* ȷ������: y
		
		* ���� <tomcat> ��������(����� keystore ������ͬ,ֱ�ӻس�)
			* ����֤�����Կ,����Կ��������Ƿ���ͬ.
			* �����Ϊ��Ҫ������tomcat�����ļ���ʹ�ã�����������keystore������һ�£�������������Ҳ����
		
		* OK,��~Ŀ¼��,������ .keystore һ��֤���ļ�
			* ����,֤�鴴���ɹ�
		
		*  JKS ��Կ��ʹ��ר�ø�ʽ,Ǩ�Ƶ���ҵ��׼��ʽ PKCS12
			keytool -importkeystore -srckeystore [name].keystore -destkeystore [name].keystore -deststoretype pkcs12

����Դ��Կ�����:
�ѳɹ�������� localhost ����Ŀ��
	
	2,���÷�����
		* �� .keystore �ļ����Ƶ� $TOMCAT_HOME/conf Ŀ¼��
		* �޸�server.xml,�����ж��Ѿ�ע�͵���
			  <Connector
				port="8443" 
				protocol="org.apache.coyote.http11.Http11NioProtocol"
				maxThreads="150" 
				SSLEnabled="true" 
				scheme="https" 
				secure="true"
				clientAuth="false" 
				sslProtocol="TLS"  
				keystoreFile="conf/.keystore"		//ָ����Կ�ļ�
				keystorePass="123456"/>				//ָ����Կ�������
			

			
	3, ������Կ
		keytool -export -alias [alias] -file [name].cer -keystore [name].keystore -storepass [����]
			alias			:����֤��ʱʹ�õı���
			[name].cer		:�����Ĺ�Կ�ļ�(�����˹�Կ��֤��)
			[name].keystore	:key.keystore

	4,�����������Կ
		* ͨѶ˫������ΪA��B,A�������Լ���֤�鲢�����˹�Կ,B���о���A�Ĺ�Կ���ܵı��ķ��͸�A��,A������ȷ����,���A��B���ͱ���,A��˽Կ���ܣ�B�����ù�Կ����
		* ��������һ��������ǹ�Կ�ǹ�����,A���͸�B�ı���,�κ��й�Կ���˶����Խ���,���ܱ�֤A��B������Ϣ�İ�ȫ��
		* ����BҲ��Ҫ�����Լ���֤��,����A�����Լ��Ĺ�Կ,����A��B������Ϣ����B�Ĺ�Կ����,����B�Ϳ�����˽Կ����,�������ػ���Ϣ������Ϊû��˽ԿҲ���ܽ���
		* A��Ҫ��B�Ĺ�Կ�����Լ���֤���

		 keytool -import -file [name].cer -keystore [name].keystore -storepass [����]
			* [name].cer �������Ĺ�Կ
			* [name].keystore ���ص�keystore
			*  [����] ����keystore������

		 * ��ʾ�Ƿ����������֤,y
		 * �س��󼴿ɵ���Ȼ��鿴֤����е�֤����Ŀ
			 keytool -list -v -keystore [name].keystore -storepass [����]
	
	5,ɾ���������Ĺ�Կ
		keytool -delete -alias [��Կ] -keystore [keystore�ļ�]

----------------------------
Tomcat-������				|
----------------------------
	


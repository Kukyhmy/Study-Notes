---------------------
maven-����web��Ŀ	 |
---------------------
	1,Eclipse����Maven��Ŀ
	2,Archtypeѡ��webapp
	3,����޷�����mavenĿ¼�ṹ������
		* �һ���Ŀ --> buildpass --> Source --> remove�����е�Դ�ļ���
		* �ֶ�����OK
	4,�޸�web.xml(web-app��������ռ�Լ��)
	5,����classes�ļ������·��
		* �һ���Ŀ --> buildpass --> Source --> output folder...
		* ȷ��main·���µ�classesĿ¼����:target/classes��
		* ȷ��test·���µ�classesĿ¼����:target/test-classes��
	6,�޸�web��Ŀ������
		* �һ���Ŀ --> peoperties --> Project Facets
		* Dynamic Web Module ��
	7,�޸Ĳ���ʱ��Ĭ������
		* �һ���Ŀ --> peoperties --> Deployment Assembly
		* remove��:/src/test/java
		* remove��:/stc/test/resources


	
	8,���tomcat�Ĳ��
		* ��build��ǩ�����
		<plugins>
			<plugin>
	          <groupId>org.apache.tomcat.maven</groupId>
	          <artifactId>tomcat7-maven-plugin</artifactId>
	          <version>2.2</version>
			  <configuraion>
				<!-- �˿� -->
				<port>80</port>
				<!-- ·�� -->
				<path>/<path>>
			  </configuraion>
	        </plugin>
        </plugins>
	

	
	* ����Eclipse��maven����jar����ʱ���Դ��
		* windows --> preferences --> Maven
		* �ұ�Download Artifact Sources
		* ��,Maven���������Դ����





	9,SVN���뱾�غ��MAVEN
		* һ��SVN�����ϴ�MAVEN�Ľṹ��POM
		1,ת��ΪMAVEN��Ŀ
		2,����JAVA�汾,�Լ������ַ���ΪUTF-8
		3,ת��ΪWEB��Ŀ
			* �һ���Ŀ --> peoperties --> Project Facets
			* Dynamic Web Module ��(ע��ѡ��汾������)
			* JAVA���Ϲ�
		4,��ʱ�ᱨ��,��Ϊxml����!���һ���һ��webContentĿ¼
			* ֱ�Ӹɵ�webContentĿ¼
			* �һ���Ŀ --> peoperties --> Deployment Assembly
			* remove��:/src/test/java
			* remove��:/stc/test/resources
			* add --> Folder --> src/main/webapp
			* add --> Java Build Path Entries --> Maven Depend....
		5,OK,��ʱPOM������б���
			web.xml is missing and <failOnMissingWebXml> is set to true
			* �������һ���µ�����,����ɾ��һ����������Ӿ�OK��

	
	10,�޸Ķ�̬WEB�汾
		��Navigator�´���Ŀ.settingsĿ¼��org.eclipse.wst.common.component.org.eclipse.wst.common.project.facet.core.xml��
		��  <installed facet="jst.web" version="3.0"/>�ĳ�  <installed facet="jst.web" version="2.5"/>

	
---------------------
maven-���Maven����	 |
---------------------

	���˵����Maven����ʧ��,�������һ��catlog,��������
	http://repo1.maven.org/maven2/archetype-catalog.xml

	# �޷�������Ŀ֮���
		* ��Ϊ��������,�����������߲��û�гɹ�����.���ڱ�������.lastUpdated�ļ�,��Ҫɾ��
		* ���뱾��maven�ֿ�,ִ��cmd����
			for /r %i in (*.lastUpdated)do del %i
		* ֱ������ɾ��
		* Ȼ������Ŀ��ִ��maven update

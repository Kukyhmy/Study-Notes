--------------------
Nexus˽���İ�װ		|
--------------------
	# ˽���ĸ���Ͳ��ض�˵��,ֱ��˵��װ
		* �Ŷӿ���,��Ҫ�໥����
		* �Ŷӿ���,û��˽��,������������ֿ�.�п��ܻᱻ����(ͬһIP����)
		* ˽�������
	
	# ����
		wget --no-check-certificate https://sonatype-download.global.ssl.fastly.net/nexus/oss/nexus-2.14.1-01-bundle.tar.gz
			* ע����HTTPS,��Ҫ��Ӳ���:--no-check-certificate
			* ����ʵ��ʹ�õ�ʱ��,Ҫע��汾
		
	# Nexus������,�������汾
		1,war
			* WEB�汾,������Tomcat,WEB��������
		2,Jetty
			* �Դ�һ��Jetty����
	
	# Ŀ¼�ṹ
		nexus-2.12.0-01
			bin			//ִ�нű�
			conf		//�����ļ�
			lib			//��������
			logs		//��־
			nexus		//Nexus�������(WEB��Ŀ)
			tmp
		
		sonatype-work
			
--------------------
Nexus-��װ			|
--------------------
	* ǰ���ǰ�װ�� maven
	1,��ѹ������Ŀ¼
		nexus-2.12.0-01
			* ����
		sonatype-work
			* ˽�п�Ŀ¼

	2,�����ļ�(���㿴��,���ñ༭)
		/nexus-2.12.0-01/conf/nexus.properties
		
		# Jetty section				//jetty������
		application-port=8888
			* ���ʶ˿�(WEB)
		application-host=0.0.0.0
			* ��������IP����
		nexus-webapp=${bundleBasedir}/nexus
			* nexus��Ŀ¼
		nexus-webapp-context-path=/nexus
			* WEB���ʵ�·��(URI)

		# Nexus section				//˽��������
		nexus-work=${bundleBasedir}/../sonatype-work/nexus
			* ����Ŀ¼
		runtime=${bundleBasedir}/nexus/WEB-INF
			* 

	3,�༭�ű�
		nexus-2.12.0-01/bin/nexus
	
		RUN_AS_USER=root
			* �޸������û�Ϊroot
		
	
		
	4,����Nexus
		nexus start

		jps
		 * ������:JswLauncher

	5,����������
		http://123.207.122.145:8888/nexus/
		* Ĭ�ϵ��û���������
			admin
			admin123
	
	6,�޸�����
		* ������ʼ�

	7,�������Ч
		����Proxy�ֿ�����Զ������
		* ѡ�� ���е� Proxy ���� �ֿ�
		* configuration ѡ�
		* Download Remote Indexes ֵ,����Ϊ true

	# ��������
		nexus start		//����
		nexus stop		//�ر�
		nexus restart	//����
		nexus install	//��װ������
		nexus unistall	//�ӷ���ж��
	

--------------------
Nexus-�ֿ����		 |
--------------------
	Views/Repository
		repositories	//�ֿ�
			type:
				* group
					* ���ֿ�
					* ��ʵ���ǰ�������������вֿ�
					* �������㿪����Ա�������õĲֿ�

				* hosted	- ���	
					* ֻҪ��hosted(�����ֿ�)�ֿ�,�������������ڲ���Ŀ�ķ����ֿ�,һ������ô��������
					* 3rd party		//�����������Ĳֿ�,��������Ҫ���ڲ���Ա�������غ󷢲���ȥ(һЩ�޷�������ֿ����ص�����)
					* Releases		//�ڲ���Ŀ�� releases��Ŀ�ķ����ֿ�
					* Snapshots		//ͬ��,���� Snapshots ��Ŀ�ķ����ֿ�

				* proxy
					* Nexus��ȡ�ⲿ��Ϣ�Ĳֿ�,��Զ������ֿ���Ѱ�����ݵĲֿ�
					* Apache Snapshots	//Apache�Ŀ��հ汾�ֿ�
					* Central			//Maven������ֿ�

				* virtual //�����maven1��һ��ת�Ӳֿ�,ûɶ����

	# ����Proxy�ֿ�����Զ������
		* ѡ�� ���е� Proxy ���� �ֿ�
		* configuration ѡ�
		* Download Remote Indexes ֵ,����Ϊ true

	
	# ֱ���ϴ�����
		* ѡ��ָ���Ĳֿ�
		* Artifact Uploadѡ�
			GAV Definition  = GAV Parameters
				* ѡ�� GAV Parameters
			Group:
			Artifact:
			Version:
			Packaging:
				* ����������������
			
			Select Artifact(s) to Upload
				* ѡ������
			Add Artifact
				* ��ӵ��ϴ�����
			Upload Artifact(s)
				* ��ʼ�ϴ�
			
		
	# ����Զ�ֿ̲������
		* ѡ��ָ���ֿ�,�һ�:Repari Index
	


--------------------
Nexus-�˻�����		 |
--------------------
	# ����Admin��ȫ����,���������������һ�
		Administration/Server

		Hostname
			* SMTP��������ַ
			* smtp.qq.com
		Port
			* SMTP����˿�
			* 25
		Username
			* �û���
			* 747692844@qq.com
		Password
			* ����
			* xxxxxxx
			* '�������Ѷ����,����SMTP����Ȩ��'
		Connection
			* Ĭ�Ͼͺ�
		System Email
			* �� Username һ��
			* 747692844@qq.com
	
	# �û�����
		Security/Users

		* ����Ĭ���������û�
		admin
			* �����޸�Ϊ�Լ���
		deployment
		anonymous
	
	# �޸�admin����

--------------------
Nexus-ʹ��˽��		 |
--------------------
	//setting.xml����
	<?xml version="1.0" encoding="UTF-8"?>
	<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" 
			  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
			  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">

		<localRepository>E:/apache-maven-3.1.0/.m2/repository</localRepository>
		<interactiveMode>true</interactiveMode>
		<offline>false</offline>
		<pluginGroups>
			<pluginGroup>org.mortbay.jetty</pluginGroup>
			<pluginGroup>org.jenkins-ci.tools</pluginGroup>
		</pluginGroups>
		
		//���¿�ʼ
		<!--����Ȩ��,ʹ��Ĭ���û�-->
		<servers>
			<server>
				<id>nexus-releases</id>
				<username>deployment</username>
				<password>deployment123</password>
			</server>
			<server> 
				<id>nexus-snapshots</id>
				<username>deployment</username>
				<password>deployment123</password>
			</server>
		</servers>

		<mirrors>

		</mirrors>

		<profiles>
			<!-- ����Զ�ֿ̲� -->
			<profile>
			   <id>demo</id>
					<activation>
						<activeByDefault>false</activeByDefault>
						<jdk>1.6</jdk>
					</activation>
					<repositories>
						<!-- ˽�п��ַ-->
						<repository>
							<id>nexus</id>
							<url>http://192.168.4.221:8081/nexus/content/groups/public/</url>
							<releases>
								<enabled>true</enabled>
							</releases>
							<snapshots>
								<enabled>true</enabled>
							</snapshots>
						</repository>
					</repositories>      
					<pluginRepositories>
						<!--������ַ-->
						<pluginRepository>
							<id>nexus</id>
							<url>http://192.168.4.221:8081/nexus/content/groups/public/</url>
							<releases>
								<enabled>true</enabled>
							</releases>
							<snapshots>
								<enabled>true</enabled>
						   </snapshots>
						</pluginRepository>
					</pluginRepositories>
				</profile>
		</profiles>
		<!--����profile-->
		<activeProfiles>
			<!-- ����ָ��IP��profile -->
			<activeProfile>demo</activeProfile>
		</activeProfiles>
	</settings>
	

	//pom.xml����,��������òſ��԰���Ŀ����Զ�ֿ̲�
	<distributionManagement>
		<!-- Release �ֿ� -->
		<repository>
			<id>nexus-releases</id>
			<name>Nexus Release Repository</name>
			<url>http://123.207.122.145:8888/nexus/content/repositories/releases/</url>
		</repository>
		<!-- snapshot �ֿ� -->
		<snapshotRepository>
			<id>nexus-snapshots</id>
			<name>Nexus Snapshot Repository</name>
			<url>http://123.207.122.145:8888/nexus/content/repositories/snapshots/</url>
		</snapshotRepository>
	</distributionManagement>







	
	
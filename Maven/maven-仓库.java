������������������������������������������������
1,maven�ֿ�				|
������������������������������������������������
	* ��maven��װ�ú�,Ĭ�ϵĲֿ�λ������:C:\Users\KevinBlandy\.m2\repository
	* ��maven��Ŀִ�е�ʱ��,����ȥ���λ�õ���û�ж�Ӧ��jar��,
	* ����о�ʹ��,���û�о�ȥ����,���ұ��������λ��
	* ���صĵ�ַ��:����ֿ�repository

������������������������������������������������
2,���ñ���maven�ֿ�		|
������������������������������������������������
	* ��ΪһЩԭ��,�����ǲ�����'�ֿ�'������C��,����Ӧ�ú���İ���ЩJAR�����õ�������λ��
	* ��confĿ¼���и�settings.xml�ļ�
	* �и��ڵ�,�Ǳ�ע�͵���,����,����һ��Ŀ¼
		* <localRepository>D:/maven/repository</localRepository>
	* ���Ұ�settings.xml����(�޸ĺ�),ճ�������õ�Ŀ���ļ��е�'���ļ���'��
		* ��������,��Ӧ��ճ����:maven�ļ�����,��ôjar�����Զ������ص�repository�ļ�����
	* ִ��һ��:mvc compile,���ر�Ҫ�Ĳ��
	

	 <!-- ���زֿ� -->
	 <localRepository>D:/maven/repository</localRepository>
	 * ��ʵֱ�ӿ�����mavenĿ¼��settings.xml������,ȫ�ֵ�!�������û�����Ч
������������������������������������������������
3,mavon����ֿ�			|
������������������������������������������������
	* �����زֿ����Ҳ�����Ҫ��jar����ʱ��,�ͻ�ȥ����ֿ����
	* ��maven�ļ���,һ��jar������ʵ�Ͷ���������ֿ�ĵ�ַ
		C:\apache-maven-3.3.9\lib\maven-model-builder-x.x.x.jar\org\apache\maven\model\pom-4.0.0.xml
	* ��xml�ļ�
		<repositories>
			<repository>
			  <id>central</id>
			  <name>Central Repository</name>
			  <!-- '����ֿ��ַ' -->
			  <url>https://repo.maven.apache.org/maven2</url>
			  <layout>default</layout>
			  <snapshots>
				<enabled>false</enabled>
			  </snapshots>
			</repository>
		</repositories>

	* ���ù��ڵľ���վ��,��Ϊ����ֿ����ڹ���,�������Щ�ӳ�
	* ������һЩ����վ�����ʹ��
	* ��:oschina(��Դ�й��ṩ)
		<mirror>
			<id>nexus-osc</id>
			<mirrorOf>*</mirrorOf>
			<name>Nexus osc</name>
			<url>http://maven.oschina.net/content/groups/public/</url>
		</mirror>

		* ������settings.xml�ļ��е�<mirrors>��ǩ�ڵ���
	* mirrorOf:��������е�'*',��ʾ:ֻҪ��ʹ�õ�����,ȫ����ȥ����ֿ���

	* ��pom.xml�����õ�
	<repositories>
		<repository>
			<id>github-releases</id>
			<url>http://oss.sonatype.org/content/repositories/github-releases/</url>
		</repository>
		<repository>
			<id>maven-restlet</id>
			<name>Public online Restlet repository</name>
			<url>http://maven.restlet.org</url>
		</repository>
		<repository>
			<id>ibiblio.org</id>
			<name>ibiblio Mirror of http://repo1.maven.org/maven2/</name>
			<url>http://mirrors.ibiblio.org/pub/mirrors/maven2</url>
		</repository>
		<repository>
			<id>jboss-public-repository-group</id>
			<name>JBoss Public Repository Group</name>
			<url>http://repository.jboss.org/nexus/content/groups/public</url>
		</repository>
	</repositories>


--------------------------
�� mavenĿ¼�µ�libĿ¼�µ�:maven-model-builder-3.3.9.jar\org\apache\maven\model����һ��pom�ļ�
	pom-4.0.0.xml
		* maven��Ŀ�е�����pom,����̳���
		<repositories>
			<repository>
			<id>central</id>
			<name>Central Repository</name>					
			<url>https://repo.maven.apache.org/maven2</url>		//Ĭ�ϵĲֿ��ַ
			<layout>default</layout>							//ʹ��Ĭ�ϵĲ���
			<snapshots>
			<enabled>false</enabled>							//��ֹ����Ϊ���յİ汾�ؼ�
			</snapshots>
			</repository>
		</repositories>
	
	* ���þ���ֿ�
		* maven����ֿ�,�ڹ���.�㶮��!
		* �޸���conf�е�setting�ļ�
		<mirrors>
			<mirror>
				<id>nexus-osc</id>			//�þ���ֿ��id
				<mirrorOf>*</mirrorOf>		//Ϊ�ĸ��ֿ����þ���,����ֱ��ָ���ֿ�����,����ֱ��ʹ��ͨ���:*
				<name>Nexus osc</name>
				<url>http://maven.oschina.net/content/groups/public/</url>
			</mirror>
		</mirrors>

ʵ�ʿ�������Ҫ���ó�һ��˽�вֿ�(�Լ��Ĳֿ�)
	����ʹ��:Sonatype Nexus



������pom.xml(��)�ļ������þ���ֿ�ĵ�ַ



������Ҫ�ѱ��ص�jar������˽���ϻ���Ҫ����
	<server>
		<id>...
		<username>...
		<password>...
	</server>
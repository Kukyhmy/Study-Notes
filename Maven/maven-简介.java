������������������������������������������������
1,maven���				|
������������������������������������������������
	* maven��һ����Ŀ������,������һ����Ŀ����ģ��(POM)
	* һ���׼����,һ����Ŀ��������,һ����������ϵͳ
	* ����������Ӧ�����������ڽ׶��в��Ŀ����߼�
	* maven��ѭԼ���������õ�ԭ��
	* ��νԼ����������:
		maven,��Ȼ֧�����÷�ʽ,������Լ���õ�Ĭ��ֵ.����Լ���õ�Ŀ¼�����

������������������������������������������������
2,maven��װ				|
������������������������������������������������
	1,��װJDK(�ⶫ����ʹ�õ�JAVA_HOME)
	2,���ص�ַ:http://maven.apache.org.download.html
	3,��apache-maven-x.x.x-bin.zip���н�ѹ,�ѽ�ѹ����ļ���ŵ�����Ŀ¼
	4,����ϵͳ��������:MAVEN_HOME
		* ָ��apache-maven-x.x.x��ַ
		* C:\apache-maven-3.3.9
	5,����path
		* ��path�������:%MAVEN_HOME%\bin
	6,���鰲װ�Ƿ�ɹ�
		* ��CMD,����:mvn -v
		* ���������汾��,��ô��ʾ��װ�����óɹ�
	7,IDE���Maven���
		* MyEclipse
	
������������������������������������������������
3,maven-Hello,World		|
������������������������������������������������
	1,��ĳ���̷�����һ���հ��ļ���
	2,���ļ����д���pom.xml(����ȥ������Ŀ͵),������ȷ�Ľ�������
	3,��pom.xml�����ļ����д������ļ�Ŀ¼
		* src\main\java
	4,��javaĿ¼�д���java�����ļ�(����Ǵ�pacakge��java�ļ�,����Ҫ��java�ļ��д�������packageĿ¼)
	5,��pom.xml�����ļ����д�cmd����:mvn compile
	6,������Ϻ����pom.xml�����ļ����д���һ���ļ���:target
	7,���ļ�������һ��classesĿ¼
	8,classes�о���java�����package�ṹ,�Լ��Ѿ��������class�ļ�.
	9,�������ڼ�,maven���Զ���ȥ������������jar��

������������������������������������������������
4,mavenĿ¼�ṹ			|
������������������������������������������������
	bin
		* Ҫ���е�����
		* mvn.bat/mvnDebug.bat
	boot
		* plexus-classworlds-x-x.jar
		* maven�Լ�������һ���������
	conf
		* setting.xml
		* �����ṩ��һ������ĵ������ļ�,���������ı�����,��ô�ͻ������ϵͳ�û�����Ч
		* ͨ��,���������,һ��ֻ���õ�ǰ�û�
	lib
		* ��������Ҫ��jar��
	
	* ���������ļ�,���Ե�ǰ�û���Ч
		1,��C��:AdministratorĿ¼�´���:.m2�ļ���,���Ұ�setting.xml�ļ����ƽ�ȥ
		2,�޸Ĵ�Ŀ¼�е������ļ�,��ô�ͽ����Ե�ǰAdministrator�û���Ч

������������������������������������������������
5,maven-Eclipse����		|
������������������������������������������������
	* ��װEclipse���
		* ������ƽ���:m2eclipse
		* www.sonatype.org/m2eclipse/
		* ��ʵ�ܶ�Eclipse���Ѿ�������Maven�����
		* ������ôװ,�Ͳ���˵��
	* ����Eclipse�е�Maven
		1,ȡ�����ɵ�Maven,ʹ���Լ���Maven
		windows-->preferences-->maven-->Installation-->Add
		* Ҫ�ǵð�ԭ���ļ̳е�mavenǰ��Ĺ�ȥ��,Ȼ�����Լ���mavenǰ���
		2,����UserSetting
		windows-->preferences-->maven-->User Setting-->User Settings-->Browes
		* ѡ���Լ����õĲֿ��ַ��settings�ļ�
		* Ĭ�ϵ�Ҳ����C:\Users\KevinBlandy\.m2\repository
	* ����Maven��Ŀ
		1,�½�maven��Ŀ,ֱ����һ��
		2,����Archetype,ѡ��
			* org.apache.wicket   wicket-archetype-quickstart
		3,����
			groupId			//��Ŀ����:com.zhiku
			ArifactId		//ģ������:user
			Version			//�Լ�ѡ��汾��
			URL				//�Զ�����
		4,ֱ�����


	* ��eclipse�İ�װĿ¼���ҵ�ini�����ļ�,���
		-vm
		C:\Program Files\Java\jdk1.8.0_77\bin\javaw.exe

������������������������������������������������
6,maven-��Ŀ�ṹ		|
������������������������������������������������
	src/main/java			//Դ��
	src/main/resources		//Դ�������ļ�(spring,hibernate,struts2,mybatis,springmvc,c3p0,lo4j... ...)
	src/test/java			//���Դ���
	src/test/resources		//���������ļ�(spring,hibernate,struts2,mybatis,springmvc,c3p0,lo4j... ...)
	src
	target
	pom.xml


������������������������������������������������
7,maven-����			|
������������������������������������������������
	* ���� & ����
	* 
	<dependency>
		<groupId>com.kevin</groupId>			//com.��Ŀ��
		<artifactId>kevin-demo</artifactId>		//��Ŀ��-ģ����
		<version>0.0.1SNAPSHOT</version>		//�汾
	</dependency>

������������������������������������������������
7,maven-�ֿ�			|
������������������������������������������������
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
	* �ֿ�Ļ�������pom.xml�н�������
������������������������������������������������
7,maven-��������		|
������������������������������������������������
	* ��ص��������ڲ��
	* ��Щ�����������໥������
		clean
			* ������Ŀ
			1,pre-clean		//ִ������ǰ�Ĺ���
			2,clean			//������һ�ι������ɵ������ļ�
			3,post-clean	//ִ���������ļ�
		default
			* ������Ŀ
			1,compil
			2,text
			3,package
			4,install
		site
			* ����POM��Ϣ,������Ŀվ��
			1,pre-site		//��������Ŀվ��ǰҪ��ɵĹ���
			2,site			//������Ŀ��վ���ĵ�
			3,post-site		//��������Ŀվ���Ҫ��ɵĹ���
			3,site-deploy	//�������ɵ�վ�㵽��������

		
	clean
	compile
	test
	package		//��ִ��package��ʱ��,test��compile���Զ���ִ��
	instal


������������������������������������������������
7,maven-�����ķ�Χ		|
������������������������������������������������
	<dependency>
			<groupId></groupId>
			<artifactId></artifactId>
			<version></version>
			<type></type>
			<scope>
				
			</scope>
	</dependency>
	* spoce,������������ʲôʱ��
	* maven�ڲ�ͬ��ʱ����в�ͬ��classpath
	* scope,��ȷ������Щ������������Щclasspath
	1,compile[Ĭ��]
		* ����,����,����
	2,provided
		* ����,����
		* ServletAPI
	3,runtime
		* ����,����
		* JDBC
	4,test
		* ����
		* Junit
	5,system
		* ����,����
		* ���������
	6,import
		* ����ķ�Χ,����ʹ����dependencyManagerment��,��ʾ,��������pom�е���dependecy������

������������������������������������������������
7,maven-�����Ĵ���		|
������������������������������������������������
	* ɽ�������º���,�º�������B��
	* ɽ����B����Ǵ���������
	* �ų�����
		* ɽ��ֻ���ϸ��,����B���,���ǾͿ�����������ȥ����B�������
	<dependency>
	 <exclusions>
	  	<exclusion>
	  		<groupId>com.kevin.maven</groupId>
			<artifactId>maven-one</artifactId>
	  	</exclusion>
	  </exclusions>
    </dependency>

������������������������������������������������
7,maven-�����ĳ�ͻ		|
������������������������������������������������
	* ��·����
		A->B->C->X(jar)

		A->D->X(jar)
		*���������Ƚ������X
	* ·����ͬ
		������,������

����������������������������������������������
7,maven-�ۺϺͼ̳�		|
������������������������������������������������
	* ��������������<dependencyManagement>
	* ����:<packaging>pom</packaging>
		<dependencyManagement>
		<dependencies>
			<dependency>
			  <groupId>junit</groupId>
			  <artifactId>junit</artifactId>
			  <version>3.8.1</version>
			  <scope>test</scope>
			</dependency>
			</dependencies>
	   </dependencyManagement>
	   * ʹ�������ǩ���������й���Ļ�,�����Ŀ����������Ŀ������
	   * <properties>
			<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
			<junit.version>3.8.1</junit.version>
		  </properties>
		  * ����һЩ����,�����ڸ�ҳ�������һЩ�ڵ�ʹ��
		  * ${junit.version},�е���EL���ʽ

	* ����Ŀ�̳�
	<parent>
		<groupId>com.kevin.maven</groupId>
		<artifactId>maven-parant</artifactId>
		<version>0.0.1-SNAPSHOT</version>
	</parent>
		* �ҵ�����Ŀ������,д��parent��ǩ


����������������������������������������������
7,maven-����WEB��Ŀ		|
������������������������������������������������
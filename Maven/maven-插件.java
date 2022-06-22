-------------------------------
������						|
-------------------------------
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<version>3.7.0</version>
		<configuration>
			<!-- ������� -->
			<compilerArgs>
				<arg>-parameters</arg>
			</compilerArgs>
			<source>1.8</source>
			<target>1.8</target>
			<encoding>UTF-8</encoding>
		</configuration>
	</plugin>

-------------------------------
��Դ������					|
-------------------------------
<dependency>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-resources-plugin</artifactId>
	<version>3.1.0</version>
</dependency>

# ʹ��maven�еı���,�滻�������ļ��ı���
	* �ڴ��ʱ,ʹ��pom����ı������滻�����ļ��еı���
	* pom����
		<foo.name>Kevin</foo.name>
		...
		<configuration>	
			<outputDirectory>target/classes</outputDirectory>							
			<useDefaultDelimiters>false</useDefaultDelimiters>							
			<delimiters>								
				<delimiter>$</delimiter>
			</delimiters>
		</configuration>

	* yum����
		name: $foo.name$
	
	* ֻҪ��pom������ʹ�õı���,�������滻

-------------------------------
Զ�̲�����					|
-------------------------------
	1,tomcat�����û���Ȩ��
		* �������
		* ./conf/tomcat-users.xml
			<role rolename="manager-script"/>
			<user username="admin" password="password" roles="manager-script"/>
		* ����tomcat9��˵������ͬʱ�����û�manager-script��manager-gui��ɫ��
		* Զ�̲���,������Ҫ�� manager-script ��ɫ
	
	2,�޸�IP����
		* �޸�����
		* �������޶���Զ�̷���manager��IP
		* webapps/manager/META-INF/context.xml
			<Context antiResourceLocking="false" privileged="true" >
				<!--
			  <Valve className="org.apache.catalina.valves.RemoteAddrValve"
					 allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1" />
				-->
			</Context>
		* ע�͵��ӱ�ǩ

	
	3,��Ӳ��
		<plugin>
			<groupId>org.apache.tomcat.maven</groupId>
			<artifactId>tomcat7-maven-plugin</artifactId>
			<version>2.2</version>
			<configuration>
				<url>http://59.110.143.96/manager/text</url>			/*/
				<username>KevinBlandy</username>
				<password>F8575532</password>
				<update>true</update>
				<!-- ע��,��·�������ظ� -->
				<path>/teach</path>	
			</configuration>
		</plugin>
	
	4,����
		tomcat7:deploy
		tomcat7:redeploy
		tomcat7:undeploy

		* ����ǵ�һ�β�������mvn tomcat7:deploy�����Զ�����(����tomcat8,9��Ҳ��ʹ��tomcat7����)��
		* ����Ǹ����˴�������²�����£�����mvn tomcat7:redeploy��
		* �����һ�β���ʹ��mvn tomcat7:redeploy����ֻ��ִ���ϴ�war�ļ��������������Զ���ѹ����
		* ���·����tomcat���������Ѵ��ڲ���ʹ��mvn tomcat7:deploy����Ļ��������������һ��Ҫ����<update>true</update>����Ȼ�ᱨ��
	

	5,����ڴ�й©����
		* ��managerҳ���е��:[find leaks] ��ť
		* ��������������ڴ�й©��Ϣ,���Ƿ������ڴ�й©
			The following web applications were stopped (reloaded, undeployed), but their
			classes from previous runs are still loaded in memory, thus causing a memory
			leak (use a profiler to confirm):

		* ��Ŀ�������
			* Servlet2
				<dependency>
					<groupId>se.jiderhamn.classloader-leak-prevention</groupId>
					<artifactId>classloader-leak-prevention-servlet</artifactId>
					<version>2.2.0</version>
				</dependency>
			* Servlet3
				<dependency>
					<groupId>se.jiderhamn.classloader-leak-prevention</groupId>
					<artifactId>classloader-leak-prevention-servlet3</artifactId>
					<version>2.2.0</version>
				</dependency>


		* ����Ŀ��web.xml�����һ��Listener�������ô�Listener��Ϊweb.xml�еĵ�һ��Listener�����������ã�
			<listener>
				<listener-class>se.jiderhamn.classloader.leak.prevention.ClassLoaderLeakPreventorListener</listener-class>
			</listener>

		*��ע��
			1,������Listener��Ĭ����tomcat�ر�5s��jvm������ڴ���յĲ���������ʱ�����ÿ���������������ҵ������ԣ��ڹرպ��5s�ڣ��ٴ�����tomcat�����ܻ�������⣬����������Ч���������tomcat��������־��ʾ�������Ƿ������������Ļ�����һ���ǲ���������⣩��
				* https://github.com/mjiderhamn/classloader-leak-prevention
				<!-- ������ֹͣ��,�ȵȶ�ý����������� -->
				<context-param>
					<param-name>ClassLoaderLeakPreventor.threadWaitMs</param-name>
					<param-value>1000</param-value>
				</context-param>
			2,���Listenerֻ���������ڴ�й©���������⣨��jdbc�ȣ��������ڴ�й©����Ҫ�Լ����


	# ���Tomcat��̨�����ϴ�����war����С����
		* �༭:webapps/manager/WEB-INF/web.xml,��Լ50�д�
		* Ĭ����50MB,�޸�.�Ĵ�㡣�Ӹ�0
			<multipart-config>
				<!-- 50MB max -->
				<max-file-size>524288000</max-file-size>
				<max-request-size>524288000</max-request-size>
				<file-size-threshold>0</file-size-threshold>
			</multipart-config>

	# ����ɾ��ROOT��Ŀ



-------------------------------
�Զ���Ӱ�Ȩ����				|
-------------------------------
<plugin>
	<groupId>com.mycila.maven-license-plugin</groupId>
	<artifactId>maven-license-plugin</artifactId>
	<version>${maven-license-plugin.version}</version>
	<configuration>
		<basedir>${basedir}</basedir>
		<header>src/main/resources/etc/header.txt</header>
		<quiet>false</quiet>
		<failIfMissing>true</failIfMissing>
		<aggregate>true</aggregate>
		<strictCheck>true</strictCheck>
		<includes>
			<include>**/src/*/java/**/*.java</include>
			<include>**/src/*/webapp/js/*.js</include>
			<include>**/src/*/webapp/css/*.css</include>
			<include>**/src/*/webapp/scss/*.scss</include>
			<include>**/src/*/resources/*.properties</include>
			<include>**/src/*/webapp/WEB-INF/*.xml</include>
			<include>**/src/*/webapp/*.xml</include>
			<include>gulpfile.js</include>
		</includes>
		<excludes>
			<exclude>**/src/main/java/**/package-info.java</exclude>
			<exclude>**/src/main/java/**/Pangu.java</exclude>
			<exclude>**/src/*/webapp/js/lib/*.js</exclude>
			<exclude>**/src/*/webapp/js/*.min.js</exclude>
			<exclude>**/src/*/webapp/css/*.css</exclude>
		</excludes>

		<useDefaultExcludes>true</useDefaultExcludes>
		<mapping>
			<java>SLASHSTAR_STYLE</java>
			<scss>SLASHSTAR_STYLE</scss>
		</mapping>
		<useDefaultMapping>true</useDefaultMapping>
		<properties>
			<year>2012-2018</year>
			<devTeam>b3log.org &amp; hacpai.com</devTeam>
		</properties>
		<encoding>UTF-8</encoding>
	</configuration>
	<executions>
		<!-- 
		eclipse sucks!!
		<execution>
			<phase>generate-resources</phase>
			<goals>
				<goal>format</goal>
			</goals>
		</execution>
		-->
	</executions>
</plugin>
--------------------------------
Jetty ���						|
--------------------------------
	<plugin>
		<groupId>org.eclipse.jetty</groupId>
		<artifactId>jetty-maven-plugin</artifactId>
		<version>9.4.14.v20181114</version>
		<configuration>
			<httpConnector>
				<!-- jetty�˿� -->
				<port>80</port>
			</httpConnector>
			<webApp>
				<!-- �����ķ���·�� -->
				<contextPath>/foo</contextPath>
			</webApp>
		</configuration>
	</plugin>
	
	# ������Mavenָ��
		jetty:run
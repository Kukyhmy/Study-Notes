--------------------
�����ִ��jar		|
--------------------
	* ���ַ�ʽ����������ࡣ�������Ƴ���,���Ƶ�jar���渴�ƺ��Լ�����һ��
	* �����,����Ŀ¼�����ɣ�xxxx-1.0.0-SNAPSHOT-jar-with-dependencies.jar �ļ�

	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-assembly-plugin</artifactId>
		<version>3.1.0</version>
		<configuration>
			<descriptorRefs>
				<descriptorRef>jar-with-dependencies</descriptorRef>
			</descriptorRefs>
			<archive>
				<manifest>
					<!--  main���� -->
					<mainClass>io.javaweb.excute.Main</mainClass>
				</manifest>
			</archive>
		</configuration>
		<executions>
			<execution>
				<id>make-assembly</id>
				<phase>package</phase>
				<goals>
					<goal>single</goal>
				</goals>
			</execution>
		</executions>
	</plugin>
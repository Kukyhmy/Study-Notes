<build>
	<plugins>
		<!-- jar������ -->
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-jar-plugin</artifactId>
			<version>3.1.1</version>
			<configuration>
				<classesDirectory>target/classes/</classesDirectory>
				<archive>
					<manifest>
						<!-- main������ -->
						<mainClass>io.javaweb.cas.Main</mainClass>
						<!-- MANIFEST.MF�ļ�����¼��ʱ����汾 -->
						<useUniqueVersions>false</useUniqueVersions>
						<!-- ��ӵ�classpath -->
						<addClasspath>true</addClasspath>
						<!-- classpath Ŀ¼ -->
						<classpathPrefix>lib/</classpathPrefix>
					</manifest>
					<!-- ���ӵ�ǰĿ¼ -->
					<manifestEntries>
						<Class-Path>.</Class-Path>
					</manifestEntries>
				</archive>
			</configuration>
		</plugin>

		<!-- ���������� -->
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-dependency-plugin</artifactId>
			<version>3.1.1</version>
			<executions>
				<execution>
					<id>copy-dependencies</id>
					<phase>package</phase>
					<goals>
						<!-- �������� -->
						<goal>copy-dependencies</goal>
					</goals>
					<configuration>
						<!-- ���jar�ļ� -->
						<type>jar</type>
						<includeTypes>jar</includeTypes>
						<!-- ���Ƶ�Ŀ¼ -->
						<outputDirectory>
							${project.build.directory}/lib
						</outputDirectory>
					</configuration>
				</execution>
			</executions>
		</plugin>
	</plugins>
</build>
-----------------------
����spring				|
-----------------------
	# ��Ҫ����
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context-support -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context-support</artifactId>
			<version>${spring.version}</version>
		</dependency>

	
	# xml����
	   <!-- ����FreeMark��ͼ -->
		<bean id="freeMarkerViewResolver" class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
			<property name="contentType" value="text/html;charset=UTF-8"/>      
			<property name="viewClass" value="org.springframework.web.servlet.view.freemarker.FreeMarkerView"/>
			<property name="suffix" value=".ftl"/>

			<!-- ����freemarker -->
			<property name="cache" value="true"/>

			<!-- �Ƿ�¶�������� -->
			<property name="exposeSessionAttributes" value="true"/>
			<property name="exposeRequestAttributes" value="true"/>     
			<property name="exposeSpringMacroHelpers" value="true"/>

			<!-- request���� -->
			<property name="requestContextAttribute" value="request"/>
			<property name="order" value="0"/>
		</bean>
		 
		
		<!-- freemarker�����ļ� -->
		<bean id="freemarkConfig" class="org.springframework.beans.factory.config.PropertiesFactoryBean">
			<!-- һЩ���ã�����:datetime_format=yyyy-MM-dd HH:mm:ss -->
			<property name="location" value="classpath:freemark.properties"/>
		</bean>
		 
		<bean id="fmXmlEscape" class="freemarker.template.utility.XmlEscape"/>
		 
		<bean id="FreeMarkerConfigurer" class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">
			<property name="templateLoaderPaths">
				<array>
					<value>/WEB-INF/templates/include</value>
					<value>/WEB-INF/templates/macro</value>
					<value>/WEB-INF/templates/views</value>
				</array>
			</property>
			<property name="defaultEncoding" value="UTF-8"/>
			<property name="freemarkerSettings" ref="freemarkConfig"/>
			<property name="freemarkerVariables">
				<map>
					<!-- �����Զ��庯���� -->
					<entry key="xml_escape" value-ref="fmXmlEscape"/>
				</map>
			</property>
		</bean>


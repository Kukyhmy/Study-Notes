-------------------
servlet ����		|
--------------------
	# �ٷ��ṩһ�����....�������
	<servlet>
	  <servlet-name>freemarker</servlet-name>
	  <servlet-class>freemarker.ext.servlet.FreemarkerServlet</servlet-class>
		
	  <!-- FreemarkerServlet settings: -->
	  <init-param>
		<param-name>TemplatePath</param-name>
		<param-value>/</param-value>
	  </init-param>
	  <init-param>
		<param-name>NoCache</param-name>
		<param-value>true</param-value>
	  </init-param>
	  <init-param>
		<param-name>ContentType</param-name>
		<param-value>text/html; charset=UTF-8</param-value> <!-- Forces UTF-8 output encoding! -->
	  </init-param>
		
	  <!-- FreeMarker settings: -->
	  <init-param>
		<param-name>incompatible_improvements</param-name>
		<param-value>2.3.22</param-value>
		<!-- Recommended to set to a high value. For the details, see the Java API docs of
			 freemarker.template.Configuration#Configuration(Version). -->
	  </init-param>
	  <init-param>
		<param-name>template_exception_handler</param-name>
		<!-- Use "html_debug" instead during development! -->
		<param-value>rethrow</param-value>
	  </init-param>
	  <init-param>
		<param-name>template_update_delay</param-name>
		<!-- ATTENTION, 0 is for development only! Use higher value otherwise. -->
		<param-value>0</param-value>
	  </init-param>
	  <init-param>
		<param-name>default_encoding</param-name>
		<!-- The encoding of the template files. -->
		<param-value>UTF-8</param-value>
	  </init-param>
	  <init-param>
		<param-name>locale</param-name>
		<!-- Influences number and date/time formatting, etc. -->
		<param-value>en_US</param-value>
	  </init-param>
	  <init-param>
		<param-name>number_format</param-name>
		<param-value>0.##########</param-value>
	  </init-param>

	  <load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
	  <servlet-name>freemarker</servlet-name>
	  <url-pattern>*.ftl</url-pattern>
	</servlet-mapping>

	...

	<!--
	  Prevent the visiting of MVC Views from outside the servlet container.
	  RequestDispatcher.forward/include should, and will still work.
	  Removing this may open security holes!
	-->
	<security-constraint>
	  <web-resource-collection>
		<web-resource-name>FreeMarker MVC Views</web-resource-name>
		<url-pattern>*.ftl</url-pattern>
	  </web-resource-collection>
	  <auth-constraint>
		<!-- Nobody is allowed to visit these directly. -->
	  </auth-constraint>
	</security-constraint>


-------------------
servlet �Զ���		|
--------------------
		this.configuration = new Configuration(Configuration.VERSION_2_3_28);

		//����ģ��·��
		configuration.setServletContextForTemplateLoading(super.getServletContext()	, "/WEB-INF/templates");
		
		//���ö�ȡĬ�ϵı���
		configuration.setDefaultEncoding("UTF-8");
		
		//�����������
		configuration.setOutputEncoding("UTF-8");
		
		//����ģ���쳣������,�׳��쳣,�ɳ�����
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		
		try {
			//����ģ������仯���ļ��ʱ��
			configuration.setSetting(Configuration.TEMPLATE_UPDATE_DELAY_KEY_SNAKE_CASE, "0ms");
		} catch (TemplateException e) {
			e.printStackTrace();
		}
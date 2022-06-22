-------------------
HttpServletMapping |
-------------------
	# ��̬�Ļ�ȡ·��
		* ͨ����⣬����Ϊ�˻�ȡͨ���ӳ���URI
		* restFull

	# �����ȡ
		HttpServletMapping httpServletMapping = request.getHttpServletMapping();

	# �ӿڷ���
		// ����ƥ�䵽��value��Ҳ����URI��ӳ��ֵ
		public String getMatchValue();
		
		// ���ش��������Servlet��pattern
		public String getPattern();
		
		// ����Servlet������
		public String getServletName();

		// ����ƥ��ģʽ
		public MappingMatch getMappingMatch();
	
	# MappingMatch ö��
		CONTEXT_ROOT
			* ƥ����Ǹ�·��

		DEFAULT
			* ƥ�����Ĭ��·��

		EXACT
			* ��׼ƥ��

		EXTENSION
			* ��չ��ƥ��
				xx.do
		PATH
			* ͨ��(*)·��ƥ��
	
	# Demo
		 <servlet>
			 <servlet-name>MyServlet</servlet-name>
			 <servlet-class>MyServlet</servlet-class>
		 </servlet>
		 <servlet-mapping>
			 <servlet-name>MyServlet</servlet-name>
			 <url-pattern>/MyServlet</url-pattern>
			 <url-pattern>""</url-pattern>
			 <url-pattern>*.extension</url-pattern>
			 <url-pattern>/path/*</url-pattern>
		 </servlet-mapping>


		URI					Path (in quotes)	matchValue	pattern	mappingMatch
		""					""					""			CONTEXT_ROOT
		"/index.html"		""					/			DEFAULT
		"/MyServlet"		MyServlet			/MyServlet	EXACT
		"/foo.extension"	foo					*.extension	EXTENSION
		"/path/foo"			foo					/path/*		PATH
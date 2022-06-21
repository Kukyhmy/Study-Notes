--------------------
freemarker - ����	|
--------------------
	# �ĵ�
		http://freemarker.foofun.cn/toc.html

	# Maven
		<dependency>
			<groupId>org.freemarker</groupId>
			<artifactId>freemarker</artifactId>
			<version>2.3.28</version>
		</dependency>
	
	
	# Demo
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

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
			//Date��datetimeĬ�ϸ�ʽ��
			configuration.setSetting(Configuration.DATETIME_FORMAT_KEY_SNAKE_CASE, "yyyy-MM-dd HH-mm-ss ");
			//���ñ��ػ�ģ�����
			configuration.setLocalizedLookup(false);
		} catch (TemplateException e) {
			e.printStackTrace();
		}

		//��ģ��
		Template template = this.configuration.getTemplate("index/index.ftl");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		Map<String,Object> hashMap = new HashMap<>();
		hashMap.put("x", 1);
		try {
			//����������Ⱦ��Ŀ�� OutputStream
			template.process(hashMap, resp.getWriter());
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	
	# �����ؼ���
		true������ֵ"true"
		false������ֵ"false"
		gt���Ƚ������"����"
		gte���Ƚ������"���ڻ����"
		lt���Ƚ������"С��"
		lte���Ƚ������"С�ڻ����"
		as��������ָ��ʹ��
		in��������ָ��ʹ��
		using��������ָ��ʹ��
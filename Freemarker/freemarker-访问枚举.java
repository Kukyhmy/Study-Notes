----------------------------------
ʹ��BeansWrapper����ö��		  |
----------------------------------
	# �����ʾ�̬����һ��
		this.configuration.setSharedVariable("_enum", new BeansWrapper(freemarker.template.Configuration.VERSION_2_3_29).getEnumModels());
	
	# ģ������
		${_enum['org.springframework.http.HttpMethod'].GET}
		
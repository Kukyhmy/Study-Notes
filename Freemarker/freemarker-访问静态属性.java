----------------------------------
ʹ��BeansWrapper���ʾ�̬����	  |
----------------------------------
	# ��������
		BeansWrapper wrapper = new BeansWrapper(freemarker.template.Configuration.VERSION_2_3_28);
        TemplateHashModel templateHashModel = wrapper.getStaticModels();

        this.configuration.setSharedVariable("static", templateHashModel);
	
		* wrapper.getStaticModels() �᷵��һ�� TemplateHashModel
		* �������÷��乫�����еľ�̬�����;�̬��Ա����, ���� final �� ��final ��

		* ����� HashModel ��ӵ�ȫ�ֹ������
	
	# ����ͼ�е��þ�̬����
		${static['org.springframework.context.i18n.LocaleContextHolder'].getLocale()}
		
		* ʹ�÷���hash�ķ���ȥ���ʵ���, Ȼ���ٵ������ľ�̬����/����

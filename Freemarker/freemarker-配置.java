-----------------------
freemarker-����			|
-----------------------
	# ʵ����
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

		*  ��Ӧ����һ����������
	

	# �������
		* ��Ϊ����ģ�嶨��ı���,����ʹ�� setSharedVariable ��������������ӹ������
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
			cfg.setSharedVariable("warp", new WarpDirective());
			cfg.setSharedVariable("company", "Foo Inc.");
		
		* �û��Զ����ͬ�������Ḳ��ȫ�ֱ���
		* �ڶ��̻߳�����ʹ��,��Ҫʹ�� TemplateModel ʵ��������Ϊ�������, ��Ϊ���ǲ����̰߳�ȫ��

		* ���������ݵ����ԣ���������ļ��ϳ�ʼ��ʱ (���Ƕ����µ� Configuration ʵ����˵)����Ϊ��, �����������û��Զ���ָ��(�û��Զ���ָ��ʹ��ʱ��Ҫ�� @ ������#)

			capture_output		freemarker.template.utility.CaptureOutput
			compress			freemarker.template.utility.StandardCompress
			html_escape			freemarker.template.utility.HtmlEscape
			normalize_newlines	freemarker.template.utility.NormalizeNewlines
			xml_escape			freemarker.template.utility.XmlEscape
	
	# ������Ϣ������
		* ������Ϣ���Ա������3��(Configuration, Template,Environment), �����ɵ͵���,�߼���Ḳ�ǵͼ��������
		* Configuration ������
			* ԭ��������������Ϣʱʹ�� Configuration �����setter����
			*  ������ʹ�� Configuration ���� (ͨ���ڳ�ʼ��Ӧ�ó���ʱ)֮ǰ��������,������뽫����Ϊֻ���Ķ���

		* Template ������
			
		* Environment ������
			* ʹ��Java API:ʹ�� Environment �����setter����
			* ��Ȼ��Ҫ��ģ��ִ��֮ǰ����,Ȼ�󵱵��� myTemplate.process(...) ʱ����������, ��Ϊ���ڲ����� Environment �����������ִ��ģ����, ����û�л�������������
			* �������Ľ�����������������������
				Environment env = myTemplate.createProcessingEnvironment(root, out);	//����env
				env.setLocale(java.util.Locale.ITALY);			//��������
				env.setNumberFormat("0.####");		
				env.process();  // ��Ⱦģ��

			* ��ģ����(ͨ���ⱻ��Ϊ�ǲ��õ�����)ֱ��ʹ�� setting ָ��
				<#setting locale="it_IT">
				<#setting number_format="0.####">

	
	# ģ�����
		*  ���ļ�·������
			void setDirectoryForTemplateLoading(File dir);
		
		* ��classpath·������
			void setClassForTemplateLoading(Class cl, String prefix);

			* �����class�����ᱻ Class.getResource() �������÷������ҵ�ģ��
			* prefix �Ǹ�ģ�����������ǰ׺��
			* ����ػ�������ѡ��������ģ��ķ���,ͨ�������,����·���¼����ļ������ֻ���,Ҫ�ȴ��ļ�ϵͳ���ض�Ŀ¼λ�ü��ذ�ȫ���Ҽ�
			* �����յ�Ӧ�ó�����,���д��붼ʹ�� .jar �ļ����Ҳ�ǲ����, �����û��Ϳ���ֱ��ִ�а���������Դ�� .jar �ļ���
			* ��� prefix ��"/"��ͷ,���classpath��·����ʼ����,�����Ե�ǰ���·����ʼ����

			* ���ʵ��
				//����
				configuration.setClassForTemplateLoading(this.getClass(), "templates/");
				//ģ��Ŀ¼
				{this.getClass()..getName()}/templates/
				//��ȡģ��
				Template template = this.configuration.getTemplate("foo.ftl");


				//����
				configuration.setClassForTemplateLoading(this.getClass(), "/templates/");
				//ģ��Ŀ¼
				{classpath}/templates/
				//��ȡģ��
				Template template = this.configuration.getTemplate("foo.ftl");



		* �����WEBӦ�õ�'/WEB-INFĿ¼���ϼ�Ŀ¼'(��Ŀ·��)��·������
			void setServletContextForTemplateLoading(Object servletContext, String path);

			* ��ҪWebӦ�õ������ĺ�һ����·����Ϊ����, �����·����WebӦ�ø�·��(WEB-INFĿ¼���ϼ�Ŀ¼)�����·��
			* �ü��ط����Է�war���ĳ���û��,��Ϊ��ʹ���� ServletContext.getResource() ����������ģ��
			* ��������˵ڶ�������(��ʹ����""),��ô�Ϳ��Ի�ϴ洢��̬�ļ�(.html.jpg��) �� .ftl �ļ�,ֻ��ֻ�� .ftl �ļ��ᱻģ����Ⱦ
				* ��Ȼ������ WEB-INF/web.xml ������һ��Servlet������URI��ʽΪ *.ftl ���û�����,����ͻ����޷���ȡ��ģ��
				
			* ���ʵ��
				//����
				configuration.setServletContextForTemplateLoading(super.getServletContext()	, "/WEB-INF/templates");
				//ģ��Ŀ¼
				/WEB-INF/templates
				//��ȡģ��
				Template template = this.configuration.getTemplate("foo.ftl");

		
		* �Ӷ��λ�ü���ģ��
			* TODO
		
		*  ��URL����ģ��
			* TODO
		
	#  ģ�建��
		* �Ỻ��ģ���(����ʹ�� Configuration ����ķ��������� Template ����)
		* �����˵������ getTemplate����ʱ,FreeMarker���������� Template ����,���һ��Ὣ���洢�ڻ�����
		* ����һ��������ͬ(�����)·������ getTemplate ����ʱ, ��ô��ֻ���ػ���� Template ʵ��, �������ٴμ��غͽ���ģ���ļ���
		
		* ���������ģ���ļ�,���´ε���ģ��ʱ��FreeMarker �����Զ���������ͽ���ģ��
		* Ȼ��,Ҫ���ģ���ļ��Ƿ�ı�����������Ҫʱ��,�����������ʱ�� ��Ĭ��ֵ��5��,�����Ҫ����ģ���������µ�Ч��,��ô��Ҫ��������Ϊ0
			configuration.setSetting(Configuration.TEMPLATE_UPDATE_DELAY_KEY_SNAKE_CASE, "0ms");

		* ĳЩģ�������Ҳ����ģ�����ʱ���ܻ�������, ����,���͵����Ӿ����ڻ������������ģ��������Ͳ���ע�⵽ģ���ļ����ݵĸı�
		

		* ��һ������ģ�������ʵ��Ӧ�ò����������õ����� cache_storage ��ȷ����
			//TODO configuration.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250))		?��������

		* ������ʹ�� Configuration ����� clearTemplateCache �����ֶ���ջ���
			configuration.clearTemplateCache();

	
	# �������
		*  FreeMarker �������쳣,���Է�Ϊ���¼���
		
		* ��ʼ���쳣
		* ���ؽ���ģ���쳣
			* ������ Configuration.getTemplate(...) ����,FreeMarker��Ҫ��ģ���ļ����ص��ڴ���Ȼ���������� (����ģ���Ѿ��� Configuration �����б� ���� ��)��
			* �����ڼ�,�������쳣���ܷ���:
				- ��ģ���ļ�û���ҵ��������� IOException �쳣,���ڶ�ȡ�ļ�ʱ����������I/O����,����û�ж�ȡ�ļ���Ȩ��,�����Ǵ��̴���
				- ����FTL���ԵĹ���,ģ���ļ������﷨����ʱ�ᵼ�� freemarker.core.ParseException �쳣
		* ��Ⱦģ���쳣
			* �ǵ������� Template.process(...) ����ʱ�ᷢ���������쳣
				- ����ͼд���������ʱ������������µ� IOException �쳣
				- ��ִ��ģ��ʱ������������������µ� freemarker.template.TemplatException �쳣
					* ����,һ��Ƶ�������Ĵ���,���ǵ�ģ������һ�������ڵı���
		
		* Ĭ�������,�� TemplatException �쳣����ʱ,FreeMarker������ͨ�ı���ʽ������д�ӡ��FTL�Ĵ�����Ϣ�Ͷ�ջ������Ϣ, Ȼ���ٴ��׳� TemplatException �쳣����ֹģ���ִ�� 
		* ���Բ�׽�� Template.process(...) �����׳����쳣,��������Ϊ�ǿ��Զ��Ƶ�,FreeMarkerҲ�ᾭ��д TemplatException �쳣�� ��־

		*  FreeMarker ���������ЩԤ�ȱ�д�Ĵ��������

			TemplateExceptionHandler.DEBUG_HANDLER
				* ��ӡ��ջ������Ϣ(����FTL������Ϣ��FTL��ջ������Ϣ)�������׳����쳣
				* ����Ĭ�ϵ��쳣������(Ҳ����˵,�������µ� Configuration ������,���ǳ�ʼ���õ�)
				* '��ӡҳ��'

			TemplateExceptionHandler.HTML_DEBUG_HANDLER
				* �� DEBUG_HANDLER ��ͬ�����������Ը�ʽ����ջ������Ϣ, ��ô�Ϳ�����Web����������Ķ�������Ϣ
				* ����������HTMLҳ��ʱ������ʹ���������� DEBUG_HANDLER��
				* '��ӡhtmlҳ��'

			TemplateExceptionHandler.IGNORE_HANDLER
				* �򵥵�ѹ�������쳣(����Ҫ��ס��FreeMarker ��Ȼ��д��־)�� ���Դ����쳣û���κ����ã�Ҳ���������׳��쳣��
				* '������,���׳�'

			TemplateExceptionHandler.RETHROW_HANDLER
				* �������׳������쳣������������������, �����������WebӦ�ó���(�������ڷ����쳣֮�������ִ��ģ��)��˵�ǳ���, ��Ϊ�������ɵ�ҳ�淢������������,������ܶ��WebӦ�ó���Ŀ���Ȩ (��ΪFreeMarker��������д�ӡ�κι��ڸô������Ϣ)
				* '�ٴ��׳��쳣,���Ա������߲�����Զ����߼�'
			
		
-----------------------
freemarker-������		|
-----------------------

# ����� GenericFilter �� HttpFilter ������
	* ��Щ������ͨ������޶ȵ�ʵ���������ڷ��� init() �� destroy() 
	* ���˱�д������

# ServletContext �ӿڲ�����һЩ�·���

	ServletRegistration.Dynamic addJspFile(String servletName, String jspFile);
		* �ɽ����и��� JSP �ļ��� servlet ��ӵ� servlet ��������
	
	int getSessionTimeout();
	void setSessionTimeout(int sessionTimeout);
		* ���úͶ�ȡsession��ʱʱ��

	String getRequestCharacterEncoding();
	void setRequestCharacterEncoding(String encoding);
		* ���úͶ�ȡĬ�ϵ�request�ı���
------------------------
System					|
------------------------
	# ϵͳ����,���ܴ���ʵ��,���Ǿ�̬����

------------------------
System-��̬����			|
------------------------
	void setProperty(String key,String value);
		* ����ϵͳ��������
	
	void setProperties(Properties props)
		* ����ϵͳ��������
	
	String getProperty(String key);
		* ��ϵͳ���������ж�ȡ����
	
	String getProperty(String key, String def);
		* ��ϵͳ���������ж�ȡ����
		* ���������,��ʹ��Ĭ��ֵ
	

------------------------
System-��ʽ�����		|
------------------------
	System.out.printf(str,Object... fmt)
		* System.out.printf("���,���� %s ���� %s ��","KevinBlandy",15);//���,���� KevinBlandy ���� 15 ��

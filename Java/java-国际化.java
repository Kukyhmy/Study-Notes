---------------------------
���ʻ�						|
---------------------------
	Locale locale = Locale.CHINA;
	//������������ļ�
	//res_zh_CN.properties
	//res_en_US.properties
	ResourceBundle rb = ResourceBundle.getBundle("res", locale);
	//��ȡ�������������
	System.out.println(rb.getString("name"));

---------------------------
��ȡ����֧�ֵĹ��ҵ���		|
---------------------------
	//��ȡ��֧�ֵĹ��Һ�����
	Locale[] localeList = Locale.getAvailableLocales();
	for (int i = 0; i < localeList.length; i++) {
		// ��ӡ����֧�ֵĹ��Һ�����
		System.out.println(localeList[i].getDisplayCountry() + "=" + localeList[i].getCountry() + " " + localeList[i].getDisplayLanguage() + "=" + localeList[i].getLanguage());
	}
	/*
		����������������=AE ��������=ar
		Լ��=JO ��������=ar
	*/
--------------------------------
PropertyDescriptor				|
--------------------------------
	# JavaBean��������������
	
	# ���캯��
		PropertyDescriptor(String propertyName, Class<?> beanClass)
		PropertyDescriptor(String propertyName, Class<?> beanClass, String readMethodName, String writeMethodName)
		PropertyDescriptor(String propertyName, Method readMethod, Method writeMethod)

	
	# ʵ������
		Method getReadMethod()
		Method getWriteMethod()
			* ��ȡ���ԵĶ�ȡ����
		
		Class<?> getPropertyType() 
			* ��ȡ��������
		
		String getName()
		String getDisplayName()
		boolean isExpert()

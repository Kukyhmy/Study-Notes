------------------------
Introspector			|
------------------------
	# Java ��ʡ, �ṩN��ľ�̬����

	# ��̬����
		String decapitalize(String name)
		void flushCaches()
		void flushFromCaches(Class<?> clz)
			* ʹ�� Introspector, �����һ��ϵͳ����Ļ���(WeakCache<Class<?>, Method[]> declaredMethodCache = new WeakCache<>())
			* ����ʡ������, Ҫ�ǵ�ˢ������
	

		BeanInfo getBeanInfo(Class<?> beanClass)
		BeanInfo getBeanInfo(Class<?> beanClass, int flags)
		BeanInfo getBeanInfo(Class<?> beanClass, Class<?> stopClass)

		String[] getBeanInfoSearchPath()
		void setBeanInfoSearchPath(String[] path)

	
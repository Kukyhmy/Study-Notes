---------------------
java.reflect.Field	 |
---------------------


---------------------
ʵ������			 |
---------------------
	setAccessible(boolean b);
		* �����ֵΪ true, �������ֶε�����Ϊ�ɱ����ʡ�������и�ֵ������ʱ����ֶ��� private ��ô����Ҫ����һ����
		* ��֮����������������������ʡ�

	set(Object obj,Object value);
		* ��ָ�����������ֶν��и�ֵ����

	get(Object obj);
		* ��ȡָ���Ե�����ֶ�ֵ
	
	<T extends Annotation>  getAnnotation(Class<T> annotationClass) 
		* ������ڸ�Ԫ�ص�ָ�����͵�ע�ͣ��򷵻���Щע�ͣ����򷵻� null�� 

	Annotation[] getDeclaredAnnotations();  
		* ��ȡ���ֶ������е�ע��

	boolean isAnnotationPresent(Class<? extends Annotation> annotationClass);
		* �ж��Ƿ���ָ�����͵�ע���ʶ�ڸ�����

	Class<?> getType()
		* ��������������
	
	int getModifiers()
		* ����Ȩ�����εı�ʾ��ֵ(public,private,native,final....)
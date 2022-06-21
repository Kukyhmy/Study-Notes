
---------------------
java.reflect.Method	 |
---------------------

---------------------
ʵ������			 |
---------------------
	invoke(Object obj,Object value...);
		* �Է���ķ���ִ�з�������,��һ��������ʾ���ĸ�����Ĵ˷���,�ڶ���������ʾ��������,���û��ֱ�����Ӽ���

	<T extends Annotation>  getAnnotation(Class<T> annotationClass) 
		* ������ڸ�Ԫ�ص�ָ�����͵�ע�ͣ��򷵻���Щע�ͣ����򷵻� null�� 

	Annotation[] getDeclaredAnnotations();  
		* ��ȡ�÷������е�ע��

	boolean isAnnotationPresent(Class<? extends Annotation> annotationClass);
		* �ж��Ƿ���ָ�����͵�ע���ʶ�ڸ÷���
	
	int getModifiers()
		* ����Ȩ�����εı�ʾ��ֵ(public,private,native,final....)
	
	 Class<?> getReturnType()
		* ���� return ��Class������
	
	boolean isBridge()
		* �Ƿ��Ƿ����Žӷ���
		* �Žӷ����� JDK 1.5 ���뷺�ͺ�,Ϊ��ʹJava�ķ��ͷ������ɵ��ֽ���� 1.5 �汾ǰ���ֽ��������
		* �ɱ������Զ����ɵķ���
			interface Parent<T> {
				void foo(T t);
			}

			class Sub implements Parent<String> {
				@Override
				public void foo(String s) {
					System.out.println(s);
				}
			//	JVM���������ɵ��Žӷ���
			//	public void foo(Object s) {
			//		this.foo((String) s);
			//	}
			}

			Method bridgeMethod = Sub.class.getMethod("foo",Object.class);
			System.out.println(bridgeMethod.isBridge());		// true

			Method method = Sub.class.getMethod("foo",String.class);
			System.out.println(method.isBridge());				// false
	

----------------------------
ParameterizedType			|
----------------------------
	# �ӿ�,������ Type
	# ���󷽷�
		 Type[] getActualTypeArguments();
			* ���ط����б�
				
		 Type getRawType();
		 Type getOwnerType();
		

----------------------------
��ȡ�����б�				|
----------------------------
	abstract class  Parent<T,R> {
		abstract void foo(T t,R r);
	}

	class Sub extends Parent<String,Integer> {
		@Override
		public void foo(String s,Integer i) {
			System.out.println(s + ":" + i);
		}
	}

	Class<? extends Sub> clazz = Sub.class;

	Type type = clazz.getGenericSuperclass();
	// ���͸���
	if(type instanceof ParameterizedType){

		ParameterizedType parameterizedType = (ParameterizedType) type;

		// ��ȡ������ķ����б�
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

		Stream.of(actualTypeArguments).forEach(System.out::println);
		//class java.lang.String
		//class java.lang.Integer
	}
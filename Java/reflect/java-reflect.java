

---------------------
���䷺����Ϣ		 |
---------------------
	# �����ȡ���ഫ�ݵķ�����Ϣ

		Class ���Ƿ���ı���,ʲô���䶼�ô�����ʼ
		����һ������
		Type	getGenericSuperclass();//���ر�ʾ�� Class ����ʾ��ʵ�壨�ࡢ�ӿڡ��������ͻ� void����ֱ�ӳ���� Type�� 


		Type ��һ���ӿ�,����һ������ӿ�--ParameterizedType
		Type ---- > ParameterizedType(���ǵõ����Type,��ǿ��ת�����������)
		ParameterizedType
			> ����������  ��ʵ���� Demo<String>
			> ������,�������Ͳ���,�����ͷ���
			> getActualTypeArguments()//��ȡ��ʵ�����Ͳ�����,����һ��Type[] 
			> ����ķ�������һ��Type[]����,��ô����������������Ҫ��Class[]

		ʾ������
			> !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			Class c = (Class) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			> �⴮����д����ķ���������
			> ���д�ڹ��캯��,��ô���c,�������������ഫ�������ķ������͵�Class����
			> ������ഫ��String  ..��ô���c ����String.class
			> ������ഫ��Integer ..��ô���c ����Integer.class

		��ȡ���ഫ�ݵ�����(������һ��)
			ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
			clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
JavaBean
   ����ҪΪ��Ա�ṩget/set����(����ֻ�ṩһ��Ҳ�ǿ��Ե�)
   ����Ҫ��һ���޲ι�����
   һ��Ծ���get/set�����ĳ�Ա������֮Ϊ����
   ��ʵ����һ������û�ж�Ӧ�ĳ�Ա����,ֻ��get/set����Ҳ�ǿ��Ե�
   ��ʵ���Ե�����,����get/set����ȥ��get/set��,������ĸСд�ˣ�

-------------
JavaBean�淶
1,����Ҫ���޲ι�����
2,�����ṩget/set����.���ֻ��get����,��ô���������ֻ������!
3,����:��get/set�����ĳ�Ա.������û�г�Ա,ֻ��get/set����������������get/set���������������ǳ�Ա����
4,��������������һ���Ĺ淶,��ô���������ԣ�boolean���͵�����,���ķ���������is��ͷ,Ҳ������get��ͷ

��ʡ����ͨ������������javaBean,�����ȷ���Ҫ����һЩ��
������Ҫ�ṩjavaBean�࣡
--------------------------------------BeanInfo
BeanInfo��һ��javaBean���͵���Ϣ��

BeanInfo  info = Introspector.getBeanInfo(����);
ͨ��BeanInfo���Եõ�������������������
PropertyDiscriptor[] a = info.getPropertyDiscriptor();
����ͨ��PropertyDiscriptor�õ�һ�����ԵĶ�/д������
getReadMethod();
getWriteMethod();
����ͨ������д����������javaBean������

introspector//��ʡ�ӿ�,����һ��JAVABean������,���Ϳ��Ը�����JAVABean��BeanInfo!
	�ײ���Ƿ���,����õ�����JAVABean�淶������
��:BeanInfo info = Intro spector.getBeanInfo(User.class);//User.class���Ƿ���javaBean�淶
BeanInfo//JAVABean����Ϣ
	getMethodDescriptors();//����MethodDescriptor[]--����������
	getPropertyDescriptors();//����PropertyDescriptor[]--����������
PropertyDescriptor
	|--getReadMethod();��ȡ������get
	|--getWriteMethod();��ȡд����set

��ʡ��-->Bean��Ϣ-->����������-->���Ե�get/set��Ӧ��Method-->����... ...  
-----------------------------------------
��ʡ
	��ʡ��-->Bean��Ϣ-->����������-->���Ե�get/set��Ӧ��Method-->����... ...  
commons-beanutils;��������ʡ���(��ʡ��������)
�������ṩ�ġ�
1,����			(���ϵĲ�������,�Ѿ����˰�����ʵ����--�������ṩ��)
   > commons-beantils.jar	//����������ʡ��ɵģ�
   > commons-logging.jar	
	

		 /**
		 * beanutils����ʾ
		 * */
		Class clazz = Class.forName(className);
		Object bean = clazz.newInstance();
		/**��ֵ����**/
		BeanUtils.setProperty(bean, "userName", "Kevin");//��userName���Ը�ֵ
		BeanUtils.setProperty(bean, "passWord", "123456");//��passWord���Ը�ֵ
		BeanUtils.setProperty(bean, "age", 22);//��age���Ը�ֵ,����22��һ���ַ���,Ҳ����ȷ�ĸ�ֵ��ȥ
		BeanUtils.setProperty(bean, "gender", "��");//��gender���Ը�ֵ
		BeanUtils.setProperty(bean, "û�е��ֶ�", "Ϲ��");//�������Ͳ����ڵ����Ը�ֵ,Ҳ�ǲ��ᱨ���
		System.out.println(bean);//����toString���Զ����Ƿ�ֵ�ɹ�
		/**��ȡ����**/
		String userName = BeanUtils.getProperty(bean, "userName");
		String passWord = BeanUtils.getProperty(bean, "passWord");
		String age = BeanUtils.getProperty(bean, "age");	//int���͵��ֶη��ص���String
		String gender = BeanUtils.getProperty(bean, "gender");
		System.out.println(userName+":"+passWord+":"+age+":"+gender);	

---------------
��ҳ�б�����.ͨ��request��ȡmap��Ȼ��Ϳ���ͨ������Ĺ��߰�,ֱ��һ�仰��װ��
��֤��ҳ�е�name��map�еļ��Լ�������ֶ�������ͬ

	Class clazz = Class.forName(className);
	Object bean = clazz.newInstance();
	Map<String,String> map = new HashMap<String,String>();
	map.put("userName", "Rocco");
	map.put("passWord", "a12551255");
	map.put("age", "23");
	map.put("gender", "��");
	BeanUtils.populate(bean, map);//ֱ�Ӱ�Map�е�����ֱ�ӷ�װ��������
	System.out.println(bean);
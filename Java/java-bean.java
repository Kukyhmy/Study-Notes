-----------------------------
��ȡBean�е����������������� |
-----------------------------
	BeanInfo info = Introspector.getBeanInfo(xxx.class);
	PropertyDescriptor pds[] = info.getPropertyDescriptors();

-----------------------------
��ȡBean��ָ�����Ե��������� |
-----------------------------
	PropertyDescriptor pd = new PropertyDescriptor("userName", User.class);

-----------------------------
������������				 |
-----------------------------
	# PropertyDescriptor//������������
	getName();			
		* ��ȡ��������(userName)
	getPropertyType();
		* ��ȡ���Ե�����(java.lang.String)
	getWriteMethod();
		* ����Method��,��д�����Ե�Mehtod,������
	getReadMethod();
		* ����Method��,�Ƕ�ȡ���Ե�Method,����




Method
	invoke(����,����);//�ĸ�������ִ�б�����,�������п�������Ǿ�̬�Ĳ���д�������û����ֵ���صľ���null�����,����ֵ��Object.
	----------javaBean�������Զ����ȡ
public static void test() throws Exception
	{
		 User user = new User();//��������
		 //1.ͨ��Introspector����ȡbean�����beaninfo
		 BeanInfo bif = Introspector.getBeanInfo(User.class);
		 //2.ͨ��beaninfo���������������(propertyDescriptor)
		 PropertyDescriptor pds[] = bif.getPropertyDescriptors();
		 //3.ͨ����������������ö�Ӧ��get/set����
		 for(PropertyDescriptor pd : pds)
		 {
			  //4.��ò�����ֶε�����
			 System.out.println("�ֶε�������:"+pd.getName());
			 //5.��ò�����ֶε�����
			 System.out.println("�ֶε�������:"+pd.getPropertyType());
			 if(pd.getName().equals("userName"))
			 {
				 //6.���PropertyDescriptor�����д����
				 Method md = pd.getWriteMethod();
				  //7.ִ��д����
				  md.invoke(user, "KeivnBlandy");
		     }
		  }
		 		  //8.�������ֵ�ֶε�ֵ
	 		   System.out.println(user.getUserName());
	} 
-----------------javaBean�������Զ����ȡ
 public static void test()throws Exception
	  {
		   User user = new User();//��������
		    //1.ͨ��������������PropertyDescriptor����
		   PropertyDescriptor pd = new PropertyDescriptor("userName", User.class);
		   //2.ͨ���ö��������д����
		    Method method = pd.getWriteMethod();
		   //3.ִ��д����
		    method.invoke(user, "KevinBlandy");
		   //4.��������ֶε�ֵ
		   System.out.println(user.getUserName());
		   //5.ͨ�������ö�����
		    method = pd.getReadMethod();
		   //6.ִ�ж�������������������䷵��ֵ��ǿ������
		    String name = (String) method.invoke(user, null);
		   //7.������κ��ֵ
		   System.out.println(name); 
	 }
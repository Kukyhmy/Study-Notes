��̬����:
1,ֻѧһ��������
	���������� : ������ʱ,��̬����һ��ָ���ӿڵ�ʵ�������(�����е�ʱ�򴴽�ʵ����һ��ӿڵĶ���)
	interface A{}
	interface B{}
	Object o =  ���� (new Class[]{A.class,B.class})
	o����,ʵ����A��B�������ӿ�(��������o����������ʵ����A��B��������ӿ�)
------------
Object proxObject = Proxy.newProxyInstance(ClassLoader loader,Class[] clazz,InvocationHandler handler);
	ClassLoader--�������
	Class[]    --һ��Interface��Ա
	InvocationHandler -- ���ô�����
��������:��̬������ʵ����Class[]������Interface��Ա��ʵ�������.
����
1,ClassLoader:�������
	* ���������������,��.class�ļ����ص��ڴ���,�γ�Class����
	JVM�ڴ��Ϊ�������:��,ջ,������,���ط�����,���ؼĴ���
2,̫��,ֱ����
3,InvocationHandler
	����Ƕ���һ���ӿ�,ֻ��һ��������
	InvocationHandler h = new InvocationHandler()
	{
		public Object invoke(Object proxy, Method method, Object[] args)throws Throwable 
		{
			return null;
		}
	};
	* �����������з�����������������invoke();(����֧��,����:getClass();)
�������ʵ�ֵ����еĽӿ��еķ���,���ݶ��ǵ���InvocationHandler��invoke������ ( 484ɵ��˵��)
------------

InvocationHandler -- ��̸
��һ���ӿ�,ֻ��һ�� invoke����.
public Object invoke(Object proxy,Method method,Object[] args)(){}
���invoke������ʲôʱ�򱻵���? -- ��ȷ��2
1,�ڴ�����󱻴�����ʱ��X
2,�ڵ��ô��������ʵ�ֽӿ��еķ���ʱ?��
	proxy :��ǰ����,Ҳ���Ǵ������,�ڵ���˭�ķ���
	megthod:��ǰ�����õķ���,Ҳ����Ŀ�귽��
	args:ʵ��





2,��̬���������
	������ѧϰ:AOP(����������/��������),����װ�������ģʽ�е�����,��������װ����ģʽ�������
	
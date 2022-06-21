
---------------------------
��ȡ��̬�������			|
---------------------------
	Object obj = Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) 
		1,classLoader
			��Ҫ��̬����һ����,�����Ҳ��Ҫ���ص���������,˭������?����classLoader
		2,interfaces
			��ʵ����Class����,Ҫʵ�ֵĽӿ���
		3,Invocationhandler
			���ô�����..
	
	# Class ����� getInterfaces(); ���Ի�ȡ��������ʵ�ֵĽӿ�

---------------------------
InvocationHandler			|
---------------------------
	# �ӿ�
	# Ψһ���󷽷�
		Object invoke(Object proxy, Method method, Object[] args)  
		
		# proxy,	��ǰִ�еĶ���
		# method,	Ϊִ�еķ���
		# args,		Ϊִ�з�������
	

---------------------------
Demo	1					|
---------------------------
	import java.lang.reflect.InvocationHandler;
	import java.lang.reflect.Method;
	import java.lang.reflect.Proxy;
	//���Խӿ�A
	interface A{
		public void a();
		public void aa();
		public Object aaa(String s1,int i);
	}
	//���Խӿ�B
	interface B{
		public void b();
		public void bb();
	}
	//����������
	public class Demo {
		public static void main(String[] args){
			/**
			 * 1,classLoader
			 * �������,���������Ҫ����������̬����һ����,�����ʵ����A,B�ӿ�,Ȼ�󴴽������Ķ���
			 * ��Ҫ����һ����,�����Ҳ��Ҫ���ص���������,˭������?����classLoader
			 * 2,interfaces
			 * ��ʵ����Class����,Ҫʵ�ֵĽӿ���
			 * 3,Invocationhandler
			 * ���ô�����..
			 * */
			InvocationHandler h = new InvocationHandler(){
				public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
					return "xxx";
				}	
			};
			//ʹ��������������������
			Object obj = Proxy.newProxyInstance(Demo1.class.getClassLoader(), new Class[]{A.class,B.class}, h);
			A a = (A)obj;					//ǿת�ɹ�,����Ȼ���Ѿ�ʵ����A�ӿ�
			Object o = a.aaa("hello",100);	//��ʵ���ǵ���invoke����
			System.out.println(o);			//o.���Ƿ���xxx
			B b = (B)obj;					//ǿת�ɹ�,����Ȼ���Ѿ�ʵ����B�ӿ�
		}
	}

---------------------------
Demo	2					|
---------------------------
	import java.lang.reflect.InvocationHandler;
	import java.lang.reflect.Method;
	import java.lang.reflect.Proxy;
	public class ProxyFactory {
		private Object targetObject;	//Ŀ�����
		/**
		 * ���ɴ������,��Ϊ��Ҫ��һ������
		 * Ҳ����Ϊ���ӵ�һ������
		 * ����̬��������
		 */
		public Object createProxy(){
			//��ȡ�������
			ClassLoader loader = this.getClass().getClassLoader();
			//��ȡĿ�������ʵ�ֵ����нӿ�(ע�Ⱑ)
			Class[] interfaces = targetObject.getClass().getInterfaces();
			//InvocationHandler
			InvocationHandler h = new InvocationHandler(){
				public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
					try{
						//��ִ��֮ǰ������һЩ����
						Object result = method.invoke(targetObject, args);	//����Ŀ������Ŀ�귽��
						//��ִ��֮�������һЩ����
						return result;										//����Ŀ����󷽷�ִ�еĽ��					
					}catch(Exception e){
						//���쳣��ʱ�������һЩ����
						return null;
					}
									
				}
			};
			//�õ��������
			Object obj = Proxy.newProxyInstance(loader, interfaces, h);
			//��֮
			return obj;
		}
		//��ȡ��ǿ����
		public Object getTargetObject()					{
			return targetObject;
		}
		//������ǿ����
		public void setTargetObject(Object targetObject) {
			this.targetObject = targetObject;
		}
	}

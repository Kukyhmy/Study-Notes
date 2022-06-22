package com.kevin.demo;
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

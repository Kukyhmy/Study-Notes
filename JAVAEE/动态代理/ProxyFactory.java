package com.kevin.demo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class ProxyFactory {
	private Object targetObject;//Ŀ�����
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
				Object result = method.invoke(targetObject, args);//����Ŀ������Ŀ�귽��
				return result;//����Ŀ����󷽷�ִ�еĽ��
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

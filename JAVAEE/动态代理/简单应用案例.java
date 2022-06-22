package com.kevin.demo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * �������,��Ҫ����
 * */
public class Demo 
{
	public static void main(String[] args) 
	{
		Waiter waiter = new ManWaiter();	//Ŀ�����
		waiter.serve();//��ͨ�ĵ���,ֻ��һ�����:������...
		/** ������ǿ **/
		WaiterInvocationHandler wih = new WaiterInvocationHandler(waiter);//�����Ǳ���ǿ�Ķ���
		Waiter w = (Waiter) Proxy.newProxyInstance(waiter.getClass().getClassLoader(), new Class[]{Waiter.class}, wih);
		w.serve();//��ǿ�����,�����仰���
		//hello
		//������... ...
		//Bye
	}
}
/**
 * InvocationHandlerʵ����,���������Ϊ�������ݸ�newProxyInstance������Ϊ����
 * */
class WaiterInvocationHandler implements InvocationHandler
{
	private Waiter waiter;	//Ŀ�����
	public WaiterInvocationHandler(Waiter waiter)
	{
		this.waiter = waiter;
	}
	//��ʵ���invoke������ǿ�ĵص�
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable
	{
		System.out.println("hello");
		this.waiter.serve();	//����Ŀ������Ŀ�귽��
		System.out.println("Bye");
		return null;	
	}
}

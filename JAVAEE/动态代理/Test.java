package com.kevin.demo;
/**
 * Ŀ����,��Ŀ��������ǿ����,�������л�... ...
 * */
public class Test 
{
	public static void main(String[] args)
	{
		show();
	}
	/**
	 * ��̬����������ʾ
	 * */
	public static void show()
	{
		Waiter w = new ManWaiter();//����ǿ����,Ŀǰֻ��һ�����
		/**
		 * ǰ����ǿ���� ,��ʵ��һ���ӿ�����д����������
		 * */
		BeforeAdvice be = new BeforeAdvice()
		{
			public void befor() 
			{
				System.out.println("ǰ����ǿ:���,��ӭ����");	
			}
		};
		/**
		 * ������ǿ���� ,��ʵ��һ���ӿ�����д����������
		 * */
		AfterAdvice af = new AfterAdvice()
		{
			public void after() 
			{
				System.out.println("������ǿ: �ټ�,��");
			}
		};
		ProxyFactory factory = new ProxyFactory();//�õ����������
		factory.setBeforeAdvice(be);//����ǰ����ǿ
		factory.setTargetObject(w);//������ǿ�Ķ���
		factory.setAfterAdvice(af);//���ú�����ǿ
		Waiter newWaiter = (Waiter) factory.createProxy();//�����ǿ�Ĵ������
		newWaiter.serve();//��ǿ������,���仰��....
	}
}

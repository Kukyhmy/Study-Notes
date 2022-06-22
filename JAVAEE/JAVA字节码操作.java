----------------------------
1,Java�ֽ������			|
----------------------------
	# JAVA��̬�Ե�����һ��ʵ��
		1,�ֽ������
		2,����
	
	# ����ʱ�����ֽ���,����ʵ�����¹���
		1,��̬�����µ���
		2,��̬�ı�ĳ����Ľṹ(���/ɾ��/�޸� �µ�����/����)
	
	# ����
		1,�ȷ��俪��С,���ܸ�
		2,Javaasist	���ܸ��ڷ���,����ASM
	

	# �������ֽ���������
		BCEL
			* Byte Code Engineering Library(BCEL)
			* �� Apache Software Foundation��Jakarta ��Ŀ��һ����
			* BCEL�� Java Classworking �㷺ʹ�õ�һ�ֿ��.���������� JVM�������,�����������ϸ��
			* BCEL�� Javaassist�в�ͬ�Ĵ����ֽ���ķ���,BCEL,��ʵ��JVMָ����,�Ͻ��в���(BCELӵ�зḻ��JVMָ�֧��),��Javassistǿ������Դ�뼶��Ĺ���
		
		
		ASM
			* ��һ��������JAVA�ֽ���������,ֱ���漰��JVM�ײ�Ĳ�����ָ��
		
		CGLIB
			* ��һ��ǿ��,������.��������Code�������,����ASMʵ��
		
		Javassist
			* ��һ����Դ�ķ���,�༭�ʹ���Java�ֽ�������,���ܱ�ASM��,��CGLIB���,���Ǻܼ�,�ܶ࿪Դ��ܶ���ʹ��
			* Dubbo
				<groupId>org.javassist</groupId>
				<artifactId>javassist</artifactId>
		
		* BCEL��ASMֱ�Ӳ�������JVM�Ļ��ָ��.����ѧ
	

----------------------------
2,Javassist-API				|
----------------------------
	# Javassist���������ձ�������ѧ�Ķ���
	# Javassist��������API��JAVA�ķ�����е�API��Ϊ����.
	# ����Ҫ����:CtClass,CtMethod,CtField �������
	# ����ִ�к�JDK����API�еļ�������ͬ����
		java.lang.Class
		java.lang.reflect.Method
		java.lang.reflect.Field
	
	# �ṩ��������ε�API
		Source			//Դ�뼶��
		Bytecode		//�ֽ���ָ���
	

----------------------------
3,Javassist-����			|
----------------------------
	1,ͨ������̬�Ĵ���һ����
		/**
		 * �������
		 */
		ClassPool pool = ClassPool.getDefault();
		/**
		 * 	makeClass		����Class
		 *  makePackage		����Package
		 *  makeInterface	����Interface
		 */
		CtClass demo = pool.makeClass("com.kevin.demo.Demo");
		/**
		 * ��������
		 */
		CtField nameFiled = CtField.make("private String name;", demo);
		CtField numFiled = CtField.make("private String num;", demo);
		/**
		 * ��ӵ�Class
		 */
		demo.addField(nameFiled);
		demo.addField(numFiled);
		/**
		 * ��������
		 */
		CtMethod getName = CtMethod.make("public String getName(){return this.name;}", demo);
		CtMethod setName = CtMethod.make("public void setName(String name){this.name = name;}", demo);
		/**
		 * ��ӵ�Class
		 */
		demo.addMethod(getName);
		demo.addMethod(setName);
		/**
		 * ����������
		 * ָ����������������
		 * ����ǰ˴������������,��Ҫͨ�� CtClass.xxxType;��ȡ
		 * �����String������������������,��Ҫͨ��:pool.get("com.x.x.x.x"); ����ȡ
		 * ������޲ι�����,ֱ�Ӳ����ݲ����ͺ�
		 */
		CtConstructor constructor = new CtConstructor(new CtClass[]{pool.get("java.lang.String"),pool.get("java.lang.String")}, demo);
		/**
		 * ���ù�����������
		 */
		constructor.setBody("{this.name = name;this.num = num;}");
		/**
		 * ��ӹ�������Class
		 */
		demo.addConstructor(constructor);
		/**
		 * �������̬���ɵ�����,���л���Ӳ��
		 */
		demo.writeFile("E:\\CLASSES");

	2,ͨ��Xjad���������
		package com.kevin.demo;
		public class Demo
		{

			private String name;
			private String num;

			public String getName()
			{
				return name;
			}

			public void setName(String s)
			{
				name = s;
			}

			public Demo(String s, String s1)
			{
				name = name;
				num = num;
			}
		}


----------------------------
4,Javassist-API���			|
----------------------------
	
	
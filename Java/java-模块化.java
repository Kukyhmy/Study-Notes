------------------------------
ģ�黯
------------------------------
	# Javaģ��ϵͳ (Jigsaw)
	# û��ģ�黯����������
		* Java���л���Խ��Խ����
		* JVM���� rt.jat, �������е����Ƿ�JVM����, ����jar�ļ����ᱻ���ص��ڴ���ȥ
	
	# ģ�黯���Java
		* ֮ǰ����� tool.jar ����ĺϲ����� jdk.* ��ģ������
		* �滯 rt.jar,tools.jar, �� JDK9/jmods �ļ��� *.jmod �ļ�
	
	# ����
		* ������ package �Ļ�����, ���ṩ��һ�� module �ĸ���
	
	# ����ģ��ĸ���� public �� class �����Ǿ����ܷ��ʵ���
		* exports: ��������Щ�����Ա�����ģ����ʵ�
		* equires: ָ��������ģ������� 
		
		* ���в��������İ�Ĭ�϶�����װ��ģ������
		* ����ģ��Ŀɶ���, ��һ������ģ���ڵĿɷ�����(public)

	
	# ģ�������
		* ������һ��, �����ظ�
		* ����ʽ��ʹ�÷�ת�����ķ�ʽ
		* ģ������־�������������İ���ǰ׺
			module java.sql {
				exports java.sql;
				exports javax.sql;
			}
	
	# ģ�������Ϊһ��ģ�鹤��(��java9�Ժ�), Ҳ������Ϊһ����ͨ��jar�ļ�����(java8������ǰ)
	
	# Java 9ȱʡ�����ֻ�ܷ��ʵ�������public��, �������ֶ�
		* ��ʹʹ�÷�����ʷ� public ��Ա������setAccessible(true), Ҳ���ܳɹ�������Щ��Ա
	

------------------------------
ģ���ƶ�
------------------------------
	# ��classpath�ĸ�Ŀ¼�����ļ�: module-info.java
		module module1 {

			// ��¶һ��java�İ�
			exports io.java.beans;
		}
		
		* module ������ǰģ�������
		* exports ��¶��java��
	
	# ָ��ģ��, ����ʹ�ñ�¶��ģ��
		module module1 {
			exports io.java.beans to com.foo;
		}

		* ͨ�� to �ؼ���ָ��, ���� com.foo ģ�� ��¶��ǰģ���е� io.java.beans ��
		* ����ģ�� requires ��ǰģ���, ���ܷ��� io.java.beans ��
		* to �������ָ�����, ʹ�ö��ŷָ�
	
	# ����������� public ��Ա
		* jdk9֮ǰ, �������ⷴ���ȡ�������е�'˽�г�Ա', �����ƻ��˷�װ
		* ��¶��ȥ��ģ��, ���������'˽�г�Ա'��Ȩ��, ����ģ����ܽ��з������'˽�г�Ա'
		* ֻ�� public Ȩ�޲���Ӱ��
		* ������׳��쳣
			 java.lang.reflect.InaccessibleObjectException: Unable to make field private xxx accessible: xxx does not "xxx" to module xxx
			
		* ����������б�¶��ȥ��ģ���˽�б���, �� module ǰ����� open �ؼ���
			// ���������, ��¶��ȥ��ģ����, �������е�˽�б���
			open module module1 {
				exports io.java.beans;
			}
		
		* ���������¶��ȥģ���е�, ָ�����µ����˽�б���, �� module ����ͨ�� opens ����
			module module1 {
				// ��������� ��¶��ȥ��ģ����,  io.java.beans ���µ����˽�б���
				opens io.java.beans;
			}
		
		* ������ָ����ģ�鱩¶��ɫ����˽�����Ե�Ȩ��,
		* ʹ�� to �ؼ���ָ�����ģ��, ʹ�ö��ŷָ�
			module module1 {
				opens io.java.beans to module2, module3;
			}

		
------------------------------
ģ�鵼��
------------------------------
	# ��classpath�ĸ�Ŀ¼�����ļ�: module-info.java
		module module2 {

			// ����һ��ģ��
			requires module1;
		}

		* requires ����ָ����ģ��
	
	# �������
		* ʹ�� transitive �ؼ������ε�ǰģ�������
		* ����ģ�����ñ�ģ��, ���Զ������� 'transitive' ���ε�ģ��(���������ô���)
			module module1 {
				// ���� model1 ��ģ��, ���Զ����� transitive java.logging ģ��
				requires transitive java.logging;
			}
	
	# ��������
		* ��mavenһ��, ������Ҫ�����ʱ������, �����в�����ʹ��
		* ʹ�� static �ؼ�������
			requires static java.logging;
	
	# java.base ģ����Զ�����
		requires java.base; // �ɲ�д���κ�ģ�鶼���Զ�����java.base

		
------------------------------
ģ��ķ��������ģ��
------------------------------
	# ������
		module module1 {
			// ��¶����ӿ����ڵİ�
			exports io.java.service;

			// ��¶����ӿ�, �Լ��ṩ�����ʵ���ࡣ�����¶�����ʹ�ö��ŷָ�
			provides io.java.service.TestService with TestServiceImpl1, TestServiceImpl2;
		}

		* ����Ľӿ�
			public interface TestService {
				void call();
			}
	
	# ������
		module module2 {
			// ��������
			requires module1;

			// ����ʹ�������б�¶�ķ���ӿ�
			uses io.java.service.TestService;
		}

		* ͨ�� ServiceLoader ��ȡ������ʵ��
			// ͨ�� ServiceLoader ��ȡ������ʵ��
			ServiceLoader<TestService> serviceLoader = ServiceLoader.load(TestService.class);

			// �������е�ʵ��
			serviceLoader.forEach(testService -> {
				testService.call();
			});

			// ��ȡ��һ��ʵ��
			serviceLoader.findFirst().orElseThrow().call();

---------------------------------
���������ģ��
---------------------------------
	# �����Ŀ¼
		|-src
			|-com
				|-foo
					|-main
						|-Main.java
			|-module-info.java
		|-mods
			|-com.foo
				|-com
					|-foo
						|-main
							|-Main.class
				|-module-info.class 
	
	# ����: javac -d [model] [module-info.java] [main.java]
		javac -d mods/com.foo src/module-info.java src/com/foo/main/Main.java
			
			-d					ָ��ģ������ɵ�Ŀ¼��ģ������
			module-info.java	ָ�� model-info ��
			main.java			ָ��main������


			
		
	# ����: java --module-path [path] -m [module]/[main]
		java --module-path mods -m com.foo/com.foo.main.Main

			--module-path	ָ��ģ�����ڵ�Ŀ¼
			-m				ָ��ģ�����ƺ�Main������


---------------------------------
ʹ�� jlink ���� �������л���(���)
---------------------------------
	jlink
		--module-path 
		--add-modules
		--output

---------------------------------
ģ�黯��ԭ��
---------------------------------
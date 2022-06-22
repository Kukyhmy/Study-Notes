-----------------------------------
ServletContainerInitializer			|
-----------------------------------

	# ��Ҫ���������������׶�ͨ����̷��ע��Filter, Servlet�Լ�Listener,��ȡ��ͨ��web.xml����ע��

	# Servlet����������ɨ�裬��ǰӦ������ÿһ��'jar'���� ServletContainerInitializer ��ʵ��
		*  ע��,��jar

	# �ṩ ServletContainerInitializer ��ʵ������������
		* ���봴���ļ�:META-INF/services/javax.servlet.ServletContainerInitializer
		* �ļ������ݾ��� ServletContainerInitializerʵ�����ȫ����
	
	# ���Ը�ServletContainerInitializer ��ʵ������� @HandlesTypes ע��
		* ����onStartup �����ϱ���Եõ����Ǹ���Ȥ����
		* �����Ὣ��ǰӦ����������һ����(�̳л���ʵ��)������� ServletContainerInitializer �ӿڵļ��ϲ���c�д��ݽ�
		* �������崦������,����Ӧ���в�������Ӧ��ʵ����,�򼯺ϲ���cΪ��
	
	# �������� Listenner ִ��

	# Demo
		import java.util.Set;

		import javax.servlet.ServletContainerInitializer;
		import javax.servlet.ServletContext;
		import javax.servlet.ServletException;
		import javax.servlet.annotation.HandlesTypes;

		@HandlesTypes(Foo.class)
		public class ApplicationServletContainerInitializer implements ServletContainerInitializer{

			@Override
			public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
				//c ������� foo���е�����
			}
		}
	
	# SpringBoot ֧��war��ԭ��������


--------------------
ServletContext		|
--------------------

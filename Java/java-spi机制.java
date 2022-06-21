------------------------
spi����					|
------------------------
	# Service Provider Interface
		* �Ҹо����Ƕ�̬�ļ���ʵ����
	
	# ��������
									 -------------------- [ʵ��A]
									|
		[����] -> [�ӿ�] -> [���ط����ּ���]
									|
									 -------------------- [ʵ��B]

	# ʵ��
		* ��jar��Ŀ¼�����ļ�:META-INF/services/<�ӿ�ȫ�޶���>
		* �ļ����ݾ��ǽӿ�ʵ�����ȫ·��
		* ���� mysql-jdbc ��ʵ�֣������ж����ʹ�û��и���
			/META-INF/services/java.sql.Driver
			com.mysql.cj.jdbc.Driver
			

	
	# ͨ�� java.util.ServiceLoder ��̬װ��ʵ��ģ��
		* ��ͨ��ɨ��META-INF/servicesĿ¼�µ������ļ��ҵ�ʵ�����ȫ�޶���, ������ص�JVM4
		* SPI��ʵ�������Я��һ�����������Ĺ��췽��(���䴴��)
	
		
		// ͨ������ָ��SPI�Ľӿ�
		ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
		// ����SPI�ӿڵ�ʵ�֣�������
        Iterator<Driver> driverIterator = serviceLoader.iterator();
        while (driverIterator.hasNext()){
			// ����ÿһ��ʵ��
            Driver driver = driverIterator.next();
            System.out.println(driver);
        }

		/*
			org.postgresql.Driver@5479e3f
			com.alibaba.druid.proxy.DruidDriver@7bfcd12c
			com.alibaba.druid.mock.MockDriver@42f30e0a
			com.mysql.cj.jdbc.Driver@46f5f779
		*/
	
	# ȱ��
		* ��ȻServiceLoaderҲ����ʹ�õ��ӳټ���, ���ǻ���ֻ��ͨ������ȫ����ȡ, Ҳ���ǽӿڵ�ʵ����ȫ�����ز�ʵ����һ��
		* �����������ĳЩʵ����, ��Ҳ�����ز�ʵ������, ���������˷�
		
		* ��ȡĳ��ʵ����ķ�ʽ�������, ֻ��ͨ��Iterator��ʽ��ȡ, ���ܸ���ĳ����������ȡ��Ӧ��ʵ����
		* ����������߳�ʹ��ServiceLoader���ʵ���ǲ���ȫ��
	
	# �鿴 JDBC �ļ��ع���
		DriverManager.setLogWriter(new PrintWriter(System.out));
		DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&allowMultiQueries=true", "root", "root");
		/*
			DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&allowMultiQueries=true")
				trying org.postgresql.Driver
				trying com.alibaba.druid.proxy.DruidDriver
				trying com.alibaba.druid.mock.MockDriver
				trying com.mysql.cj.jdbc.Driver
			getConnection returning com.mysql.cj.jdbc.Driver
		*/

------------------------
ServiceLoader			|
------------------------
	# JDK6�Ķ���
		final class ServiceLoader<S> implements Iterable<S>
	
	# ��̬��������
		<S> ServiceLoader<S> load(Class<S> service)
		<S> ServiceLoader<S> load(Class<S> service, ClassLoader loader)
		<S> ServiceLoader<S> loadInstalled(Class<S> service)
	
	# ʵ������
		Iterator<S> iterator();
		forEach(Consumer<? super T> action)
		void reload();
		Spliterator<T> spliterator()



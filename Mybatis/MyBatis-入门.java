
������������������������������������������������
1,MyBatis����			|
������������������������������������������������
	1,�־ò���
	2,�����˼������е�JDBC����Ͳ������չ�����,�Լ��Խ���ļ�����װ
	3,����ʹ�ü򵥵�'xml'����'ע��',�������ƺ�ԭʼӳ��,��JAVA�е���ͨPOJOӳ������ݿ��еļ�¼
	4,��һЩ��ܵĹ�ϵ
		JDBC --> DButils --> MyBatis --> Hibernate
	5,���������������ϵ�ORM���,��Ҫ�������Լ�ȥ��дSQL���
	6,����֪ʶ
		* ����(����)ӳ��
		* ���(���)ӳ��
		* ��̬SQL
	7,MyBatis����DAO�����ַ���
		* ԭʼdao����(��Ҫ�����дdao�ӿ��Լ�daoʵ����)
		* Mybatis�� mapper ����������(ֻ��Ҫдdao�ӿ�)

������������������������������������������������
2,MyBatisĿ¼�ṹ		|
������������������������������������������������
	mybatis-3.2.7.jar
		* ����jar�� -- > '����'

������������������������������������������������
3,MyBatis���Ų���		|
������������������������������������������������
	SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
	//��classpath��ȡ�����ļ�(InputStream),�����Ự����
	SqlSessionFactory sessionFactory = builder.build(Resources.getResourceAsStream("mybatis/SqlMapConfig.xml"));
	//ͨ�������õ�SqlSession
	SqlSession session = sessionFactory.openSession();
	/* ��һ������:�����ռ�.mappedstatementid
	 * �ڶ�������:ָ����ӳ���ļ���,��ƥ��Ĳ�����ֵ.
	 */
	User user = session.selectOne("User.findById","43BCB463B6374BD5960FBFB917D0E2F7");
	System.out.println(user);
	//�ر���Դ
	session.close();

	
	// sql session�ж��API���Ի�ȡ�� sqlSessionʵ��

	SqlSession openSession(boolean autoCommit);
		* �Ƿ��Զ��ύ����
	SqlSession openSession(Connection connection);
		* ��ָ����Connection����session
	SqlSession openSession(TransactionIsolationLevel level);
		* ������뼶��
	SqlSession openSession(ExecutorType execType,TransactionIsolationLevel level)
		* ִ������,��������뼶��
	SqlSession openSession(ExecutorType execType);
		* ִ������
	SqlSession openSession(ExecutorType execType, boolean autoCommit);
		* ִ������
	SqlSession openSession(ExecutorType execType, Connection connection);
		* ִ������
	
	ExecutorType ִ������,��һ��ö��
		SIMPLE, 
		REUSE, 
		BATCH(��ȡһ���������Session)

������������������������������������������������
4,MyBatis XML����Լ��	|
������������������������������������������������
	1,���������ļ�Լ�� & �����ռ�
		<?xml version="1.0" encoding="UTF-8" ?>
		<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
			"http://mybatis.org/dtd/mybatis-3-config.dtd">
		<configuration>
		</configuration>
	2,ӳ���ļ�Լ�� & �����ռ�
		<?xml version="1.0" encoding="UTF-8" ?>
		<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
			"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
		<mapper namespace="User">
		</mapper>

������������������������������������������������
5,MyBatis SQLӳ��ռλ��	|
������������������������������������������������
	1,#{}��ʾһ��ռλ��,#{}�����������,���Ϳ����Ǽ�����,POJO,HashMap
		* ����Ǽ���������,��ô#{}�п���д��value������������
		* �����POJO,��ô������POJO����������

	2,${}��ʾһ��ƴ�ӷ���,ʹ�ò����ᵼ��SQLע��,������ʹ��
		* ���${}�еĲ���,�����κ����ε���ӵ�SQL���
		* ��Ҳ���Խ��պܶ�����,������������յ������Ǽ��������͵Ļ�
		* '����������,${value,���Ʊ�����value}'

	3,${},#{}.���Ƕ���ͨ��OGNL����ȡ�����е�����ֵ
		* ����.����.����... ...

������������������������������������������������
6,MyBatis��־����		|
������������������������������������������������
	1,��ӡSQL���,��ʾ״̬�ȹ���
	2,lo4j.properties����
		# Global logging configuration
		#\u5728\u5f00\u53d1\u73af\u5883\u4e0b\u65e5\u5fd7\u7ea7\u522b\u8981\u8bbe\u7f6e\u6210DEBUG\uff0c\u751f\u4ea7\u73af\u5883\u8bbe\u7f6e\u6210info\u6216error
		log4j.rootLogger=DEBUG, stdout
		# Console output...
		log4j.appender.stdout=org.apache.log4j.ConsoleAppender
		log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
		log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n

		��������:DEBUG
		���ɻ���:info

������������������������������������������������
7,MyBatis һЩ�ܽ�		|
������������������������������������������������
	1,������ݱ��ֶ����Ƹ�POJO��������һ��
		* �������---��!��!��!
		* ��ʵmybatis�ܴ���,һЩ'������'������,���ᱻ�ɹ���ӳ��
		* ������ȫ�������ļ������һ������:<setting name="mapUnderscoreToCamelCase" value="true" />
		* �����շ�����,���ݿ���ֶ�,����Сд���С�POJO���ֶ�,���ǰ����շ������
	
	2,ID����
		* ��ʵ���ǲ���һ������,ID��������,����Ҫ�������Ժ�.�ٻ�ȡ�����ID
		* ���ֵ�ᷴд����mapper�ӿڵ��β���

			<insert id="saveUser" parameterType="User" useGeneratedKeys="true" keyColumn="id" keyProperty="id">
			useGeneratedKeys="true"		//����ID����
			keyColumn="id"				//������
			keyProperty="id"			//POJO��������
	
������������������������������������������������
1,MyBatis-����Spring���|
������������������������������������������������
	1,����˼·
		* mapper,dao������spring���й���
		* ��ҪSpringͨ��������ʽ����SessionFactory
		* spring��mybatis�������ɴ������,ʹ��SqlSessionFactory����SqlSession(����Զ����)
	
	2,��������jar��
		* ����spring��mybatis�ı���jar����.��Ҫ��������ϰ�
		mybatis-spring.x.x.x.jar
			* ���ں�ibatis����,����spring�ṩ���ϰ�,����������MyBatis,������MyBatis�ṩ

	3,����SqlSessionFactory
		<!-- SqlSessionFactory -->
		<bean id="sessionFactoy" class="org.mybatis.spring.SqlSessionFactoryBean">
			<!-- �����ļ���ַ -->
			<property name="configLocation" value="classpath:mybatis/SqlMapConfig.xml"/>
			<!-- ����Դ -->
			<property name="dataSource" ref="dataSource"/>
		</bean>
	
	4,�������������
		<!-- ������� -->
		<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
			<!-- ����Դ -->
			<property name="dataSource" ref="dataSource"/>
		</bean>
		* ��Hibernate��ͬ,Hiernateʹ�õ���ר�ŵ����������,���Ҵ��ݵ���SessionFactory
		* MyBatis�����������,��ʵ����JDBC�����������,��������������ݵ�������Դ

	5,������������
		<!-- ��������,����������Ҫһ����������� -->
		<tx:advice id="txAdvice" transaction-manager="transactionManager">
			<tx:attributes>
				<tx:method name="get*" read-only="true" isolation="READ_COMMITTED" propagation="REQUIRED"/>
				<tx:method name="update*" isolation="READ_COMMITTED" propagation="REQUIRED"/>
				<tx:method name="save*" isolation="READ_COMMITTED" propagation="REQUIRED"/>
				<tx:method name="delete*" isolation="READ_COMMITTED" propagation="REQUIRED"/>
			</tx:attributes>
		</tx:advice>

	6,������������
		<aop:config >
			<!-- ��Ҫʹ������ķ���,����ͨ��� -->
			<aop:pointcut expression="execution(* com.kevin.service.*.*(..))" id="service"/>
			<!-- Ϊָ���ķ���,����ָ������������ -->
			<aop:advisor advice-ref="txAdvice" pointcut-ref="service"/>
		</aop:config>

������������������������������������������������
2,MyBatis-ԭʼDAO����	|
������������������������������������������������
	1,����mapper.xml
	2,SqlMapConfig.xml�е���mapper.xml
	3,�޸�SqlMapConfig.xml�е�һЩ����
		* ɾ������Դ������
	4,DAOע��SqlSessionFactory
		* DAO����ȥ�̳�:SqlSessionDaoSupport��
		* �����Ѿ�������һ��SqlSessionFactory,�����ṩ��set����.
		* ���໹�ṩ��һ��getSqlSession()�ķ���
	5,�Լ���DAO�л�ȡSqlSessionFactory������:SqlSession���в���
	
������������������������������������������������
3,MyBatis-mapper����	|
������������������������������������������������
	1,����mapper�ӿ�
	2,����mapper���������򴴽�mapper.xml
	3,SqlMapConfig.xml�е���mapper.xml
	4,��mapper�ӿڽ���spring����,��spring�����ɴ������
		1,����ע��
			<!-- Mapper -->
			<bean id="mapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
				<!-- ����SqlSessionFactory -->
				<property name="sqlSessionFactory" ref="sessionFactoy"/>
				<!-- ����mapper�ӿ� -->
				<property name="mapperInterface" value="com.kevin.mapper.UserMapper"/>
			</bean>
			* ���ϰ�����һ��������,���������Щmapper�ӿ�:MapperFactoryBean
			* '��ȡ�������Bean':idֵ

		2,����ע��
			<!-- mapper����ɨ����,-->
			<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
				<!-- ָ��ɨ��İ��� -->
				<property name="basePackage" value="com.kevin.dao"/>
				<!-- ָ��SqlSessionFactory -->
				<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
			</bean>
			* ����ָ��id,�������Զ���ȥ�������ͺ�,�����mapper����ɨ���mapper�ӿ�, �Զ��Ĵ����������,������spring������ע��
			* Ҫ��,mapper�����ļ��� mapper�ӿ���ͬһ��Ŀ¼��,��������ͬ!����,�����Ƿ���mapper�������Ĺ淶
			* ָ��SqlSessionFactory��ʱ��,'������ref,����value',Ҫע��.����Ϊ���ʹ��ref�Ļ�.�ᵼ�¶��˵�c3p0ɨ��ʧЧ
				* c3p0����ԴӦ�������ȴ����Ķ���.�������������ref,��ô�ͻ��ȴ�����Щ.������Щ����������c3p0
				* ǧ��Ҫ�м�,value,д����spring�����ļ���.SqlSessionFactory bean��id����!����ref��ָ��
			* ��������ַ�ʽ���õĻ�,�Ͳ����� mybatis �������ļ�������mapper.xml�ļ���·����!
			* '��ȡ�������bean':mapper�ӿ�����,����ĸСд.
			* 'ɨ������',����ʹ��ͨ���.ÿ�����м�ʹ��','���ŷָ�

	5,��DAO�����id��ȡָ����mapper����bean�Ϳ��Խ���ʹ��
	6,ͨ�����ַ�ʽ,��mapper����Bean����IOC����ȥ����,��ô�Ͳ�����SqlMapConfig�н���������
	
������������������������������������������������������������������������
1,MyBatis��Spring�����ܽ�			|
������������������������������������������������������������������������
	1,���Ϻ�,����ȥ�ֶ��ر�SqlSessionFactory

	2,��ͨ��ʽ����
		* SqlSessionFactory,�Ͳ���mybatis����,���������ϰ����Ǹ�.��Sprin����ע���OK
		* SqlSessionFactory,��Ҫע��������,һ�����ⲿ�������ļ�,һ����������Դ
		* ������Ҫ�������ݿ�.�Ͱ����SqlSessionFactoryע����,Ȼ���Լ�ȥ��ȡSqlSession�������ݾ�����
	
	3,mapper����ʽ����
		1,����mapperע��
			* ע��һ����:org.mybatis.spring.mapper.MapperFactoryBean
			* ����Ҫ��������,
				* ����mapper�������淶�Ľӿ�ȫ·����
				* SqlSessionFactory
			* Ȼ��,��ȡ������bean,��ʵ�ǻ�ȡ��ָ���ӿڵĴ�����.�Ϳ���ֱ�Ӳ������ݿ���
		2,����ɨ��
			* ע��һ����:org.mybatis.spring.mapper.MapperScannerConfigurer
			* ����Ҫָ��id,������ֻ��Ҫʵ������OK,�����������ͺ�
			* ��Ҳ��Ҫ��������
				* ����ɨ��淶mapper����ַ(mapper�ӿ���mapper.xml�����ļ�ͬ��ͬλ,�ҷ���mapper�������淶)
				* SqlSessionFactory
					* ע�����,������Բ�������refע���ȥ��.������ vaue,д��SqlSessionFactory bean��idֵ.����ԭ������
			* ָ�����·��Ϲ淶������mapper�������,�ͱ�ע���������.���ǵ�id��:������Сд
			* ɨ��·��,��֧��ͨ���,�������','���Ÿ���.

	4,��ʵ�Ҿ��û���һ�ַ�ʽ,mapper������Spring����.Ҳ����˵����spring������mapper�Ĵ������
			* ���ǰ�����ͨ��ʽ��������
			* ��DAO��ʹ��SqlSession������mapper,�������.���в���
	
	5,�������Բ����ǵ� 1 �ַ�ʽ,���ǵ� 4 �ַ�ʽ,spring����׼ȷ�Ŀ���������
		* ����,���񴫲������е�����
		* ֻҪservice�����쳣�ͻ�ع�,��������:propagation.REQUIRED_NEW �������Բ�������
		* ��������,��һ������û����,���ǵڶ��������쳣.�����ͬ��һ����һ��ع���.
	
	6,�����������spring��ʱ��ʹ��,mapper�������ķ�ʽ.DAO����ô��?
		* ֱ��ע��Mapperô?������е��㶺,����mapper��һ���������Ľӿ�,�������е������.ÿ��DAO���п���ע���mapper��һ��
		* ע��SqlSessionFactory,�Լ���ȡSqlSession,�ٻ�ȡmapper�ӿ�?��,��û��Ҫ��mapper�ӿ�ע�ᵽ������.?
	

	��ͳ��ʽ
		1,ע��SqlSessionFactory
		2,ע��DAO,�Լ���ȡsession
			* ����ʹ��session��ȡmapper�������������ݿ�
			* Ҳ����ֱ��ʹ��session���������ݿ�

	mapper����ʽ
		1,ע��SqlSessionFactory
		2,ע��mapperɨ��
		3,���԰�mapperֱ��ע�뵽dao
			* mapper���ƾ�������Сд,����,DAO������ע��mapper��ʱ��,����xml�ļ����Ҳ���mapper��,����������
		


		
ʵ�ʿ���
	* mapper�ļ��������classpathĿ¼��,������������׺
	* ����ɨ������N���ļ���
		<bean id="sessionFactoy" class="org.mybatis.spring.SqlSessionFactoryBean">
			<property name="configLocation" value="classpath:mybatis/SqlMapConfig.xml"/>
			<property name="dataSource" ref="DruidDataSource"/>
			<property name="mapperLocations">
				<list>
					<!-- 
						mapper�ļ�,ɨ��·��
						Ҳ��������Ϊ:
						classpath:mapper/**/*-mapper.xml
						* ��˼����,����Ŀ¼�㼶.ֻҪ��-mapper��β��,һ�ɼ���
					
					-->
					<value>classpath:/mapper/*Mapper.xml</value>							*/
					<value>classpath:/mapper/*Mapper-etc.xml</value>						*/
				</list>
			</property>
		</bean>
	* dao�ӿ�,���Էֿ�����
	<!-- mapper -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="com.kevin.comm.dao"/>
		<property name="sqlSessionFactoryBeanName" value="sessionFactoy"/>
		<!-- ��������ָ��ע���ʶ��mapper(��ѡ,��д�Ļ�Ĭ�ϼ���basePackage������) -->
		<property name="annotationClass" value="com.zhiku.anywhere.persistence.repository.mybatis.MyBatisRepository"/>
	</bean>


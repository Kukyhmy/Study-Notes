--------------------
MYSQL-JNDI			|
--------------------
	 # JNDI,JAVA�����Ŀ¼�ӿ�.JNDI�����þ���
	 # �ڷ�������������Դ,Ȼ��ͨ��ͳһ�ķ�������ȡ���õ���Դ
	 # ���ｲ������Դ�������ӳ�.�����Ļ�,��Ŀ�п���ͨ��ͳһ�ķ�ʽ����ȡ���ӳض���


--------------------
MYSQL-JNDI��Tomcat	|
--------------------
	1,�ҵ�Tomcat��,confĿ¼�µ�context.xml�ļ��е� Context ��ǩ
		* �Ը��ļ����в���,��ô����Ĭ�϶Է����������е���Ŀ��������ͳһ������
		* ��ʵû�������Ҫ,���ǿ�����:server.xml�ļ��ĵ�Host��ǩ�´���һ�� Context ��ǩ,Ȼ���������
		* Ҳ������Tomcat\conf\Catalina\localhostĿ¼�´���һ��xml�ļ�,���Ƹ���Ŀ������ͬ(�����Ե�ǰ��Ŀ��Ч).Ȼ����������һ��: Context ��ǩ,���������ò����ǿ��Ե�
		
	2,��������
		<Context>
			<Resource 
				name="jdbc/dataSource"							
				type="com.alibaba.druid.pool.DruidDataSource"
				factory="org.apacahe.naming.factory.BeanFactory"
				<!-- 
					��������,Ϊ�������Դ 
					����Ķ���������Դ(DruidDataSource)�Ĳ���
				-->
				url="jdbc:mysql://localhost:3306/kevinblandy?useUnicode=true&characterEncoding=utf8"
				driverClassName="com.mysql.jdbc.Driver"
				username="root"
				password="root"
				maxActive="1000"/>
		</Context>
		# ����JNDI��Դ��Ҫ��<Context>Ԫ��������<Resource>��Ԫ��
		[]name		:ָ����Դ������,������ƿ�������.�ڻ�ȡ��Դ��ʱ�����Ҫ�������
						# ��Դ����
		[]auth		:д��д����ν,����Ŀǰ��˵��������ӵ�
		[]factory	:����������Դ�Ĺ���,���ֵ�ǹ̶���.һ�㲻�ø�
						# ��Դ��˭�����𴴽�
		[]type		:��Դ������,����������������ӳص�����
						# �������õ���һ�����ݿ����ӳ�.Druid�����ӳ�
		[]bar		:��ʾ��Դ������,�����Դ������bar����.��ô������������barֵ.
					 ����Druid���ӳض���,�ǲ���Ҫbar��.������Ҫurl,username,password������.
	
	3,��ȡ��Դ
		������Դ��Ŀ����Ϊ�˻�ȡ��Դ.ֻҪ��������Tomcat,��ô�Ϳ�������Ŀ���κ�����ͨ��JNDI��ȡ��Դ�ķ�ʽ����ȡ��Դ��
		['DEMO']
			//���ȴ��������Ķ���
			Context iniCtx = new InitialContext();
			//ͨ�������Ķ������,�ٴ��ҵ�һ�������Ķ���--java:comp/env:��ֵ�ǹ̶���,���ܸ�
			Context envCtx = (Context)iniCtx.lookup("java:comp/env");
			//Ȼ��ͨ�����������,��ȡָ�����Ƶ���Դ
			DataSource dataSource = (DataSource)envCtx.lookup("jdbc/dataSource");

		# �������ʵ���Լ�д
		   DataSource dataSource = (DataSource)iniCtx.lookup("java:comp/env/jdbc/dataSource");
		   * ϣ�����ܿ���.��˼���ǲ��ز�ѯ����,ֱ��һ�θ㶨.�����ַ�һ���

	4,Spring ��ʹ�� JNDI ����Դ
		# ��һ�ַ�ʽ
			<bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
				<property name="jndiName">
					<value>java:comp/env/jdbc/dataSource</value>
				</property>
			</bean>
			# java:comp/env/jdbc/dataSource
			  java:comp/env/		����Ȼ������
			  jdbc/dataSource	����������xml��name,Ҳ������Դ��

			# ��������ҩ
			  <bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">        
				<property name="jndiName" value="comp/env/jdbc/dataSource"/>        
			  </bean>  
			  * jndiName :���name���Ծ���������
		
		# �ڶ��ַ�ʽ
			<jee:jndi-lookup id="dataSource" jndi-name="java:comp/env/jdbc/dataSource"/>

			* ����ͼ�������

		
--------------------------------
MySQL - ��д����				|
-------------------------------
	# ����
		һ���Ӧ�ö����ݿ����,����"����д��",Ҳ����˵�����ݿ��ȡ��ѹ���ϴ�,��һ��˼·���ǲ�ȡ��Ⱥ�ķ�ʽ
		����һ������Ҫ��,����д������,���ǳ�֮Ϊ:д��
		�����Ķ��Ǵӿ�,�����ȡ����,���ǳ�֮Ϊ:����

	# Ҫ��
		1,������д������ݱ���һ��
		2,д���ݱ�д������
		3.�����ݱ�������ӿ�
	
	# �����д����ķ�����������
		1,Ӧ�ò���	
			* ͨ���������������ݿ�Ķ�д
			
		2,�м�����
	

	# ԭ��
		1,master �����ݸı��¼����������־:binary.log��,Ҳ���������ļ�:log-bin ָ�����ļ�(��Щ��¼������������־�¼�),binary log events
		2,slave �� master �� binary log events �����������м���־(relay log)
		3,slave �����м���־�е��¼�,���ı�,��ӳ���Լ�������(��������)
	
	# ��Ҫע��ĵط�
		1,��DB�İ汾�ʹ�DB�İ汾һ��
		2,��DB�ʹ�BD�����ݿ�����һֱ
			* ���԰����ı����ڴ���ִ��,Ҳ����ֱ�Ӹ�������Ŀ¼
		3,��DB������������־,��DB�ʹ�DB��server_id������Ψһ
	

--------------------------------
MySQL - ���ò���				|
-------------------------------
	* ��ʼִ�����Ӹ��Ƶ�ʱ��,Ҫ��֤�������ݿ��е�������һ��һ����
	* ������ִ���,��Ҫ��.ȥ�鿴������־
	
	# ��������
		1,�޸������ļ�:my.conf
			log_bin=mysql_bin  
				* �����������ļ�
			server-id = 5
				* ָ��������ID(���,����ҪΨһ,һ��ȡIP��һ��)
			binlog-do-db = db
				* �������,����Ҫ�ֶ����.�����ļ��в�����
				* ָ����Щ���ݿ����ͬ��,��дĬ������
		
		2,��������
			
		3,ִ��SQL����ѯ״̬
			show master status
				* ��Ҫ��¼�� File ֵ,�ӿ�ִ�������ʱ���ʹ�õ�
				* ��Ҫ��¼�� Position ֵ,��Ҫ�ڴӿ�������ͬ������ʼֵ
				+------------------+----------+--------------+------------------+-------------------+
				| File             | Position | Binlog_Do_DB | Binlog_Ignore_DB | Executed_Gtid_Set |
				+------------------+----------+--------------+------------------+-------------------+
				| mysql_bin.000001 |      120 |              |                  |                   |
				+------------------+----------+--------------+------------------+-------------------+

		4,�����ⴴ��ͬ���û�
			* ��Ȩ�û� slave01 ʹ�� 123456 �����¼ mysql
				grant replication slave on *.* to 'slave01'@'127.0.0.1' identified by '123456';
				flush privileges
			* ���԰�IPֵ�滻Ϊ'%',��ʾ����������IP����ͬ������
			


	# �ӿ�����
		1,�޸�my.conf
			server-id = ָ��serve ID,ֻҪ���ظ�,��OK.
			* �ӿ�ֻ����һ�������ļ��Ĳ���.�����Ķ���SQL����в������
		
		2,ִ������SQL
			change master to
				master_host='120.76.182.243',
				master_user='slave01',
				master_password='a12551255',
				master_port=1124,
				master_log_file='mysql_bin.000007',			
				master_log_pos=1642315;							

		3,����slave ͬ��
			start slave;		//����ͬ��
			stop slave;			//ֹͣͬ��

		4,�鿴ͬ��״̬
			show slave status\G;
				* ���������ֵ,����YES,�����óɹ�

				Slave_IO_Running:Yes
				Slave_SQL_Running:Yes



-------------------------------
MySQL - �м���Ľ������		|
-------------------------------
	# ���ڿ�������͸����,�м������.���Զ���ȥѡ����

	# �ŵ�
		1,����Ҫ�κεĸĶ�,���ڿ�������͸����
		2,��̬�������Դ����Ҫ��������

	# ȱ��
		1,�����������м��,�ᵼ���л����ݿ�������.
		2,���м��������ת����,���������½�
		3,��ʵĿǰΪֹ.��û��һ���Ƚϳ�����м����Ʒ

	# ��ص��м����Ʒ
		 mysql-proxy
		 Amoeba for MySQL
		
	# ���ﲻ��...��ΪҪѧ�м��.����������


-------------------------------
MySQL - Ӧ�ò�Ľ������		|
-------------------------------
	# ʵ�ó���������,�ڳ����н����ж�,�������ɾ��,���������.����Ƕ�������ӿ�.��
		* ���ַ�ʽ,����������Ҫ׼��N������Դ

	# �ŵ�
		1,������Դ�л�����,�ɳ����Զ����
		2,����Ҫ�����м��
		3,������֧���κ����ݿ�

	# ȱ��
		1,�ɳ������,��ά���벻��
		2,����������̬�����µ�����Դ
	
	# ʹ��Spring����ɶ�д����
		* ԭ��ͼ
			--> Request --> Contoller --> AOP(�л�����Դ) --> Service ---> Dao

		* �ڽ���Service֮ǰ,ʹ��AOP�������ж�,��ʹ�ö���,����д��.
		* ���Ը��ݷ��������������ж�:query,find,get,load ... ...


	# ����
		"DynamicDataSource" ��
			public class DynamicDataSource extends AbstractRoutingDataSource{
				protected Object determineCurrentLookupKey() {
					//ʹ�� DynamicDataSourceHolder�����̰߳�ȫ,���õ���ǰ�߳��е�����Դkey

					/**
						��������ķ���ֵ,��ȥ�����е�һ��Map<String,DataSource>��Ѱ��.ƥ�䵽��key,�ͷ��ض�Ӧ��DataSource
					**/
					return DynamicDataSourceHolder.getDataSourceKey();
				}
			}
			* ����౾�����DataSource������,����,��spring��xml�����е�DataSource��������Ϊ��

		"DynamicDataSourceHolder" ��
			public class DynamicDataSourceHolder {
				/**
				 * д���Ӧ������Դkey
				 * */
				private static final String MASTER = "master";
				/**
				 * �����Ӧ������Դkey
				 * */
				private static final String SLAVE = "slave";
				/**
				 * ʹ��ThreadLocal��¼��ǰ������Դkey
				 * */
				private static final ThreadLocal<String> holder = new ThreadLocal<String>();
				/**
				 * ��������Դkey
				 * */
				private static void putDataSourceKey(String key){
					holder.set(key);
				}
				/**
				 * ��ȡ����Դkey
				 * */
				public static String getDataSourceKey() {
					return holder.get();
				}
				/**
				 * ���д��
				 * */
				public static void markMaster(){
					putDataSourceKey(MASTER);
				}
				/**
				 * ���д��
				 * */
				public static void markSlave(){
					putDataSourceKey(SLAVE);
				}
			}
	
		"DataSourceAspect" ��
		public class DataSourceAspect {
				/**
				 * �������
				 * */
				public void before(JoinPoint point){
					String methodName = point.getSignature().getName();
					if(isSlave(methodName)){
						//ȷ���Ƕ�,����֮
						DynamicDataSourceHolder.markSlave();
					}else{
						//��֮���Ϊд
						DynamicDataSourceHolder.markMaster();
					}
				}
				/**
				 * �ж��Ƿ��Ƕ���
				 * ����ҵ��㷽��������ȷ��
				 * */
				private Boolean isSlave(String methodName){
					//ֻҪ��ָ�����ƿ�ͷ�ķ���,��Ϊ��
					return StringUtils.startsWithAny(methodName, new String[]{"query","get","find","load"});
				}
			}

	# jdbc.properties

		jdbc.master.driver=com.mysql.jdbc.Driver
		jdbc.master.url=jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true																							*/
		jdbc.master.username=root
		jdbc.master.password=123456
		
		# �ӿ������N��
		jdbc.slave01.driver=com.mysql.jdbc.Driver
		jdbc.slave01.url=jdbc:mysql://127.0.0.1:3307/db?useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true						
		jdbc.slave01.username=root
		jdbc.slave01.password=123456
	
	# spring ����
		<bean id="masterDataSource" class="DataSource">
			<!-- �������ӳ������� -->
		</bean>

		<bean id="slaveDataSource01" class="DataSource">
			<!-- �ӿ����ӳ������� -->
		</bean>
		<!-- �����Լ���dataSource,Ҳ�����Զ����"AbstractRoutingDataSource"������ -->
		<bean id="dataSource" class="com.kevin.blog.web.dataSource.DynamicDataSource">
			<!-- ����N������Դ -->
			<property name="targetDataSources">
				<map key-type="java.lang.String">
					<!-- key Ҫ�� DynamicDataSourceHolder��һ��.����� -->
					<entry key="master" value-ref="masterDataSource"/>
					<entry key="slave" value-ref="slaveDataSource01">
				</map>				
			</property>
			<!-- ����Ĭ�ϵ�����Դ,Ĭ��Ϊд�� -->
			<property name="defaultTargetDataSource" ref="masterDataSource">
		</bean>

		<!-- 
			�������� 
			��ʵ������ԭʼ��xml������������������
		-->
		<!-- �Զ����������,Ҳ���������д�������� -->
		<bean class="com.kevin.blog.web.datasource.DatasourceAspect" id="dataSourceAspect"/>
		<aop:config>
			<!-- ������������,�����е�Service������Ч -->
			<aop:pointcut expression="execution(* com.kevin.blog.service.*.*(..))"  id="service"/>
			<!-- 
				Ӧ��������Ե�Service����
			-->
			<aop:advisor pointcut-ref="service"  advice-ref="txAdvice"/>


			<!--
				������Ӧ�õ��Զ�������洦������,-9999��֤���������ȼ����ִ��
			-->
			<aop:aspect ref="dataSourceAspect" order="-9999">
				<aop:before method="before" pointcut-ref="service"/>
			</aop:aspect>
		</aop:config>
	
	# �Ľ�����(����,ʹ��������Թ�����ƥ��,�����Ƿ�����)
	
	# һ�����
-----------------------
jpa
-----------------------
	# JavaEE��ϵ�еļ���֮һ
		<!-- JPA�淶�ӿ� -->
		<dependency>
			<groupId>javax.persistence</groupId>
			<artifactId>javax.persistence-api</artifactId>
			<version>2.2</version>
		</dependency>
	
		<!-- junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>

		<!-- hibernate��jpa��֧�ְ� -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-entitymanager</artifactId>
			<version>${project.hibernate.version}</version>
		</dependency>

		<!-- ���ӳ� -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-c3p0</artifactId>
			<version>${project.hibernate.version}</version>
		</dependency>

		<!-- log��־ -->
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>

		<!-- jdbc -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.6</version>
		</dependency>
	
	# JPA�Ĳ�������
		1.���������ļ�����ʵ�����������
			Persisitence����̬���������ݳ־û���Ԫ���ƴ���ʵ�������������
				createEntityMnagerFactory���־û���Ԫ���ƣ�

			���ã�����ʵ�����������
			
		2.����ʵ�����������������ʵ�������
			EntityManagerFactory ����ȡEntityManager����
			������createEntityManager
			* �ڲ�ά���ĺܶ������
				�ڲ�ά�������ݿ���Ϣ��
				ά���˻�����Ϣ
				ά�������е�ʵ�����������
				�ٴ���EntityManagerFactory�Ĺ����л�������ô������ݿ��
			* EntityManagerFactory�Ĵ������̱Ƚ��˷���Դ

			�ص㣺�̰߳�ȫ�Ķ���
				����̷߳���ͬһ��EntityManagerFactory�������̰߳�ȫ����
			* ��ν��EntityManagerFactory�Ĵ��������˷���Դ����ʱ�������⣿
			˼·������һ��������EntityManagerFactory�Ķ���
			* ��̬��������ʽ����EntityManagerFactory
			
		3.����������󣬿�������
			EntityManager����ʵ���������
				beginTransaction : �����������
				presist �� ����
				merge  �� ����
				remove �� ɾ��
				find/getRefrence �� ����id��ѯ
				
			Transaction ���� �� ����
				begin����������
				commit���ύ����
				rollback���ع�
		
		4.��ɾ�Ĳ����
		5.�ύ����
		6.�ͷ���Դ
	
	# ����ִ�в���
		// ���� META-INF/persistence.xml, ���� persistence-unit ���� EntityManagerFactory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql");
		// ��ȡ��ʵ�������
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// �������������
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		// ��ʼ����
		entityTransaction.begin(); 
		try {
			
			// ִ��ҵ�����
			User user = new User();
			user.setName("KevinBlandy");
			user.setVersion(1);
			
			entityManager.persist(user);
			
			// �ύ����
			entityTransaction.commit();
		}catch (Exception e) {
			// �ع�����
			entityTransaction.rollback();
			throw e;
		}finally {
			// �ͷ���Դ
			entityManager.close();
			entityManagerFactory.close();
		}
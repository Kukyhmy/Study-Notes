--------------------------
Persistence
--------------------------
	# ��̬����
		static EntityManagerFactory createEntityManagerFactory(String persistenceUnitName)
		static EntityManagerFactory createEntityManagerFactory(String persistenceUnitName, Map properties)
			* ���� META-INF/persistence.xml, ���� persistence-unit ���� EntityManagerFactory

		static void generateSchema(String persistenceUnitName, Map map)
		static PersistenceUtil getPersistenceUtil()
			* ����һ��������
			* �ù�����ӿھ�������
				boolean isLoaded(Object entity, String attributeName)
				boolean isLoaded(Object entity);
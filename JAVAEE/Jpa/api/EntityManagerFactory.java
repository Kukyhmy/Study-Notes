-----------------------
EntityManagerFactory
-----------------------
	# ʵ��������Ĺ�����
	# ����ʵ��Ӧ�����̰߳�ȫ��, һ����˵, һ��application, ֻ����һ�� EntityManagerFactory
	# ���󷽷�
		EntityManager createEntityManager();
		EntityManager createEntityManager(Map map);
		EntityManager createEntityManager(SynchronizationType synchronizationType);
		EntityManager createEntityManager(SynchronizationType synchronizationType, Map map);
			* ��ȡEntityManager

		CriteriaBuilder getCriteriaBuilder();
			* ��ȡCriteriaBuilder

		Metamodel getMetamodel();
		boolean isOpen();
		void close();
		Map<String, Object> getProperties();
		Cache getCache();
		PersistenceUnitUtil getPersistenceUnitUtil();
		void addNamedQuery(String name, Query query);
		<T> T unwrap(Class<T> cls);
		<T> void addNamedEntityGraph(String graphName, EntityGraph<T> entityGraph);
	

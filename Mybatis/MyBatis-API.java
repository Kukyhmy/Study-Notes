
InputStream input = Resources.getResourceAsStream("SqlMapConfig.xml");	//��ȡ�����ļ�,����InputStream������

SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();		//�����������ȡ����
		
SqlSessionFactory sessionFactory = builder.build(input);				//��ȡ�����ļ�InputStream��,��ù�����
		
SqlSession session = sessionFactory.openSession();						//��ȡSession�Ự��

-------------------------------------------------------------------------------------
SqlSessionFactory
	openSession();
		//����һ�����Ӷ���,SqlSession,������Ҫ�ֶ��ύ
	openSession(true);
		//����һ�����Ӷ���,SqlSession,�����Զ��ύ
-------------------------------------------------------------------------------------
SqlSession 
	selectOne(�����ռ�.id,�������ļ�ƥ��Ĳ���);
		// ���صľ��������ļ���ָ���������͵Ķ���,ȡ��һ����¼.�����¼��Ψһ,�׳��쳣!���ؽ����Ψһ
	selectList(�����ռ�.id,�������ļ�ƥ��Ĳ���);
		//���ؾ���һ�� List ���͵ļ���,���;���ӳ���ļ���ָ���ķ������Ͷ���.��ѯ��������¼,�򵥸���¼
	getMapper(Class clazz);
		//����һ��������mapper�����淶�Ľӿ���,����һ�����������
	close();
		//�ر�����
	commit();
		//ִ���ύ
	rollback ();
		//ִ�лع�
	getMapper(T.class);
		//���ط���mapper�����淶�Ľӿ�,�������
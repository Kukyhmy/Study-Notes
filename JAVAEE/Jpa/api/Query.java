----------------------
Query
----------------------
	# �����ӿ�
		List getResultList();
		Stream getResultStream()
			* ��ѯ, ���ؼ����б�
			
		Object getSingleResult();
			* ��ѯ, Ψһ�����
			* �������ж���, ���׳��쳣: javax.persistence.NonUniqueResultException
			* ������Ϊnull, ���׳��쳣: javax.persistence.NoResultException

		int executeUpdate();
			* ִ���޸�/ɾ��, �����ܵ�Ӱ�������
		
		Query setFirstResult(int startPosition);
		int getFirstResult();
		Query setMaxResults(int maxResult);
		int getMaxResults();
			* FirstResult ��ʾ��ʼ�ļ�¼, limit �ĵ�һ������
			* MaxResults ��ʾ���Ľ����¼, limit �ĵڶ�������
			

		Query setHint(String hintName, Object value);
		Map<String, Object> getHints();

		<T> Query setParameter(Parameter<T> param, T value);
		Query setParameter(Parameter<Calendar> param, Calendar value, TemporalType temporalType);
		Query setParameter(Parameter<Date> param, Date value, TemporalType temporalType);
		Query setParameter(String name, Object value);
		Query setParameter(String name, Calendar value, TemporalType temporalType);
		Query setParameter(String name, Date value, TemporalType temporalType);
		Query setParameter(int position, Object value);
		Query setParameter(int position, Calendar value, TemporalType temporalType);
		Query setParameter(int position, Date value, TemporalType temporalType);
			* ����ռλ����
			* ����
				name			ָ����������
				position		ָ������λ��
				Parameter		ָ������λ��
				TemporalType	ö��, ָ����������: 
					DATE
					TIME
					TIMESTAMP

		Set<Parameter<?>> getParameters();
		Parameter<?> getParameter(String name);
		<T> Parameter<T> getParameter(String name, Class<T> type);
		Parameter<?> getParameter(int position);
		<T> Parameter<T> getParameter(int position, Class<T> type);

		<T> T getParameterValue(Parameter<T> param);
		Object getParameterValue(String name);
		Object getParameterValue(int position);

		boolean isBound(Parameter<?> param);

		Query setFlushMode(FlushModeType flushMode);
		FlushModeType getFlushMode();
			* ˢ��ģʽ, ö��
				COMMIT
				AUTO

		Query setLockMode(LockModeType lockMode);
		LockModeType getLockMode();
			* ����������
			

		<T> T unwrap(Class<T> cls);
	


----------------------
Query ������ѯ
----------------------
	

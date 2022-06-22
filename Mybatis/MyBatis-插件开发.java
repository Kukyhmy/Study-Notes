-----------------------
�������				|
-----------------------
	# MyBatis���Ĵ����Ĵ���������,�����в�����н���
	# ��������ö�̬�������,һ���İ�װĿ�����,�Ӷ�ʵ����Ŀ�귽��ִ�н������ص�Ч��
	# MyBatis��������ӳ������ִ�й��̵�ĳһ��������ص���
	# Ĭ�������,MyBatis����ʹ�ò�������صķ������ð���
		org.apache.ibatis.executor.Executor
			  int update(MappedStatement ms, Object parameter) throws SQLException;
			  <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, CacheKey cacheKey, BoundSql boundSql) throws SQLException;
			  <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler) throws SQLException;
			  <E> Cursor<E> queryCursor(MappedStatement ms, Object parameter, RowBounds rowBounds) throws SQLException;
			  List<BatchResult> flushStatements() throws SQLException;
			  void commit(boolean required) throws SQLException;
			  void rollback(boolean required) throws SQLException;
			  CacheKey createCacheKey(MappedStatement ms, Object parameterObject, RowBounds rowBounds, BoundSql boundSql);
			  boolean isCached(MappedStatement ms, CacheKey key);
			  void clearLocalCache();
			  void deferLoad(MappedStatement ms, MetaObject resultObject, String property, CacheKey key, Class<?> targetType);
			  Transaction getTransaction();
			  void close(boolean forceRollback);
			  boolean isClosed();
			  void setExecutorWrapper(Executor executor);

		org.apache.ibatis.executor.parameter.ParameterHandler
			 Object getParameterObject();
			 void setParameters(PreparedStatement ps)throws SQLException;
		
		org.apache.ibatis.cursor.Cursor.ResultSetHandler
			<E> List<E> handleResultSets(Statement stmt) throws SQLException;
			<E> Cursor<E> handleCursorResultSets(Statement stmt) throws SQLException;
			void handleOutputParameters(CallableStatement cs) throws SQLException;
		
		org.apache.ibatis.executor.statement.StatementHandler
			Statement prepare(Connection connection, Integer transactionTimeout)
			void parameterize(Statement statement)
			void batch(Statement statement)
			int update(Statement statement)
			<E> List<E> query(Statement statement, ResultHandler resultHandler)
			<E> Cursor<E> queryCursor(Statement statement)
			BoundSql getBoundSql();
			ParameterHandler getParameterHandler();
	
	# ÿ�����������Ķ�����
			
			

1,ӳ�������ڲ����
	MappedStatement
		sqlSource
			boundSql
				sql
				parameterObject
					* ��������
					* ��������ǻ�����������,�ᱻת��Ϊ��������
					* ������ݵ�Object,����� parameterObject
					* ����Ƕ������,�� parameterObject ����һ��Map<String,Object>
						* #{param1}, #{param2}, #{param3}
					* ���ʹ���� @Param ע��,��ômap��key��������ע���ʶ��ֵ
				parameterMappings
					* ����һ��List,ÿһ��Ԫ�ض���:parameterMapping
					* ���������������ǵĲ���,������������,����,���ʽ,javaType,jdbcType,typeHandler����Ϣ
					* һ�㲻��Ҫ�ı�,ͨ��������ʵ�ֲ����� SQL�Ľ��
					* �Ա�,PrparedStatement�ܹ�ͨ�����ҵ�parameterObject��������Բ������ò���


					
		
2,SqlSession �Ĵ����
	Executor
		* ִ����
		* �������:StatementHandler,ParameterHandler,ResultHandler,����ִ�ж�Ӧ��SQL
		* ��������Ҫ,������ִ��Java�����ݿ⽻����,��������ִ����,��������
			1,SIMPLE	����ִ����,Ĭ��
			2,REUSE		ִ��������Ԥ�������
			3,BATCH		ִ��������������������,�������ר�õĴ�����
		* ��ִ��SQL��ȫ����,������װ����,��װ�����,��ִ��SQL���̶���������,�ܹ㷺,�õò���
	
	StatementHandler
		* ������ʹ�����ݿ�� Statement(PreparedStatement) ִ�в���
		* ʵ����
			RoutingStatementHandler
		* �Ĵ����ĺ���,��������
			prepare()			//Ԥ����
			parameterize()		//���ò���,ִ��
			query()				//ִ��SQL
			update()			//ִ��SQL
		* ִ��SQL�Ĺ���,������дSQLִ�й���,�Ƚϳ��õ����ض���
	
	ParameterHandler
		* ����SQL�Բ����Ĵ���
		* ����SQL�Ĳ�����װ,��д��װ����
	
	ResultHandler
		* �ǽ���������ݼ�(ResultSet)�ķ�װ���ش���
		* ����ִ�н��,��д��װ����Ĺ���
	

	

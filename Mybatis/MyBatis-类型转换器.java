--------------------------------
����ת����						|
--------------------------------
	# һ�����,ϵͳԤ���������ת�����Ѿ�����
	# ʵ�ֽӿ�
		public interface TypeHandler<T> 
		void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;
			 * ���ڶ�����Mybatis���ò���ʱ����ΰ�Java���͵Ĳ���ת��Ϊ��Ӧ�����ݿ����� 
			 * @param ps ��ǰ��PreparedStatement���� 
			 * @param i ��ǰ������λ�� 
			 * @param parameter ��ǰ������Java���� 
			 * @param jdbcType ��ǰ���������ݿ�����
				* �ò������� #{}�е� jdbcType ֵ,
				* #{status,jdbcType=TINYINT})
				* ���δָ��,���ΪΪ null
			 * @throws SQLException 
		T getResult(ResultSet rs, String columnName) throws SQLException;
			 * ������Mybatis��ȡ���ݽ����ʱ��ΰ����ݿ�����ת��Ϊ��Ӧ��Java���� 
			 * @param rs ��ǰ�Ľ���� 
			 * @param columnName ��ǰ���ֶ����� 
			 * @return ת�����Java���� 
			 * @throws SQLException 
		T getResult(ResultSet rs, int columnIndex) throws SQLException;
			 * ������Mybatisͨ���ֶ�λ�û�ȡ�ֶ�����ʱ�����ݿ�����ת��Ϊ��Ӧ��Java���� 
			 * @param rs ��ǰ�Ľ���� 
			 * @param columnIndex ��ǰ�ֶε�λ�� 
			 * @return ת�����Java���� 
			 * @throws SQLException 
		T getResult(CallableStatement cs, int columnIndex) throws SQLException;
			 * ����Mybatis�ڵ��ô洢���̺�����ݿ����͵�����ת��Ϊ��Ӧ��Java���� 
			 * @param cs ��ǰ��CallableStatementִ�к��CallableStatement 
			 * @param columnIndex ��ǰ���������λ�� 
			 * @return 
			 * @throws SQLException 
	# ����һ�㶼�Ǽ̳г�����
		BaseTypeHandler
	# �Զ�������ת����
		1,�̳г�����,��д����
			org.apache.ibatis.type.BaseTypeHandler<T>
			public abstract void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;
				* ����ӳ��
				* parameter :����JAVABEAN �Ķ���,�����������һЩ���������� ps �Ӷ�ʵ���Զ������Ϣת��
				* jdbcType :�ò������� #{}�е� jdbcType ֵ,���δ����,���ֵΪnull
				* ps.setObject(i,parameter.getValue(), jdbcType.TYPE_CODE);

			public abstract T getNullableResult(ResultSet rs, String columnName) throws SQLException;
				* ����ӳ��,�����������Ի�ȡ��ֵ,
				* �Լ���ֵ���з�װ�󷵻�,��ֵ������
				*  Integer i = rs.getInt(columnIndex);
				
			public abstract T getNullableResult(ResultSet rs, int columnIndex) throws SQLException;
				* ����ӳ��,���������ڵ�λ�ÿ��Ի�ȡ��ֵ,
				* �Լ���ֵ���з�װ�󷵻�
				*  Integer i = rs.getInt(columnIndex);
				
			public abstract T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException;
				* ����ӳ��,����ڴ洢����.���������ڵ�λ�ÿ��Ի�ȡ��ֵ,
				* �Լ���ֵ���з�װ�󷵻�
				*  Integer i = cs.getInt(columnIndex);
				
		

		2,����
			
			* mybatis.config.xml
				* ȫ������
				* JAVABean <-> ���ݿ�
				<typeHandlers>
					<typeHandler handler="com.jd.jos.application.note.dao.CustomTimeStampHandler" javaType="java.util.Date" jdbcType="VARCHAR"/>
					* handler ָ��Handler������
					* javaType JAVA�Ķ�������
					* jdbcType	ֻ���� JdbcType ö��ֵ����֮һ
				</typeHandlers>

			* �����������
				* ���ݿ� -> JAVABean
				* typeHandler ָ��ת����
				<resultMap type="Note" id="note-base">
					<result property="id" column="id" />
					<result property="updateTime" column="update_time" jdbcType="VARCHAR" javaType="Date" typeHandler="demo.CustomTimeStampHandler"/>
				</resultMap>
			
			* ��CRUD��ǩ��ʹ��ת����
				* JAVABean -> ���ݿ�
				* ͨ�� typeHandler ����ָ����Ϣת����
				<update id="updateRow" parameterType="NoteBook">
					update note
						set update_time=#{updateTime,typeHandler=demo.CustomTimeStampHandler}
					where id=#{id}
				</update>
	


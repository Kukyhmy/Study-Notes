---------------------
annotation
---------------------
	# ע�����ڰ�: javax.persistence

---------------------
һ��ע��
---------------------
	@Entity
		* ��ʾ��, ��EntityManager����
		String name() default "";
			* ʵ�������, ��������JPQL����
			* Ĭ���ǵ�ǰ����

	@Table
		String name() default "";
			* ���ݱ������

		String catalog() default "";

		String schema() default "";

		UniqueConstraint[] uniqueConstraints() default {};

		Index[] indexes() default {};
			* ������������
			* Index ע�������
				String name				��������
				String columnList		��������
				boolean unique			�Ƿ�ΨһԼ��

	@Column
		String name() default "";
			* �ֶε�����, �������������һ��, ����ʡ��

		boolean unique() default false;

		boolean nullable() default true;
			* �Ƿ����Ϊnull

		boolean insertable() default true;
			* ִ�в����ʱ��, �Ƿ������ֶ�

		boolean updatable() default true;
			* ִ�и��µ�ʱ��, �Ƿ���¸��ֶ�

		String columnDefinition() default "";
			* �����������Լ�Լ���Լ�ע��, ����: 
				columnDefinition = "int(20) unsigned COMMENT 'id'"
				columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��'"

		String table() default "";

		int length() default 255;
			* �ֶ�Լ���ĳ���

		int precision() default 0;

		int scale() default 0;
	
	@MapKeyColumn
		String name() default "";
		boolean unique() default false;
		boolean nullable() default false;
		boolean insertable() default true;
		boolean updatable() default true;
		String columnDefinition() default "";
		String table() default "";
		int length() default 255;
		int precision() default 0;
		int scale() default 0;

		* ӳ��map����

	@TemporalType
		TemporalType value();
			* ָ�������ֶε���������
			* ö��ֵ
				DATE
				TIME
				TIMESTAMP

	@Id
		* ��ʶid�ֶ�, ÿ��ʵ���඼����������һ�� @id �ֶ�
	
	@GeneratedValue
		* ��ʶID�ֶ�,����ָ�������ɲ���
		* strategy ,ָ�����ɲ���
			GenerationType.TABLE		ʹ��һ���ض������ݿ��������������� 
			GenerationType.SEQUENCE		���ݵײ����ݿ����������������,���������ݿ�֧������
			GenerationType.IDENTITY		���������ݿ��Զ�����(��Ҫ���Զ������ͣ�)
			GenerationType.AUTO			�����ɳ������

	@Enumerated
		EnumType value() default ORDINAL;
			* ö��
				ORDINAL		ʹ�� ordinal ӳ��Ϊ int
				STRING		ʹ�� ö�ٵ� name() ӳ��Ϊ varchar

		* ����ö���ֶκ����ݿ��ӳ�䷽ʽ
	
	@Lob
		* ӳ���ֶ�Ϊ���ݿ���֧�ֵĴ������������
		* ��֧�����µ�����
			Clob		���ַ�������
			Blob		���ֽ�����

		* Clob �� Blob ռ���ڴ涼�Ƚϴ�, ���Կ������: @Basic(fetch = FetchType.LAZY) �ӳټ���
		


	@Basic
		* ��ʶ�ֶ�, ��ӳ�䵽���ݿ��(����ʶĬ�Ͼ���)

		FetchType fetch() default EAGER;
			* ���ֶε�ץȡ����
				LAZY		�ӳټ���
				EAGER		��������
		boolean optional() default true;
			* ���ֶ��Ƿ����Ϊnull

	@Transient
		* ��ʾ���ֶβ������ݱ��ӳ���ֶ�, ��ӳ���ʱ��������

	@Version
		* ��ʶ�汾���ֶ�
	
	@NamedStoredProcedureQuery
		String name();
			* JPA�ж���Ĵ洢��������
		String procedureName();
			* ���ݿ�����Ĵ洢���̵�����
		StoredProcedureParameter[] parameters() default {};
			* �洢���̵�IN/OUT����
		Class[] resultClasses() default {}; 
		String[] resultSetMappings() default {};
		QueryHint[] hints() default {};

		* �洢���̵Ķ���, �����붨���� Entity ����

	@NamedQuery
		String name();
			* query������:ʵ��.����
		String query();
			* �����JPQL���
		LockModeType lockMode() default NONE;
		QueryHint[] hints() default {};

		* Ԥ�����ѯ, ������ʵ������
		* ����ͨ��	@NamedQueries ע��ͬʱ������
			NamedQuery [] value ();

	@NamedNativeQuery
		String name();
		String query();
		QueryHint[] hints() default {};
		Class resultClass() default void.class; 
		String resultSetMapping() default "";
			* ʹ��ָ���� @@SqlResultSetMapping ��װ�����
			* ָ��@SqlResultSetMapping ��name����

		* ���� @NamedQuery һ��, ֻ��ʹ�õ��Ǳ���SQL
	
	@QueryHint
		 String name(); 
		 String value();

		 * query hint ����
	


	
		

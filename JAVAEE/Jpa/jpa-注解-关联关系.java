---------------------
������ϵ
---------------------
	@JoinColumn
		String name() default "";
			* ����е�����
		String referencedColumnName() default "";
			* ��ǰʵ����ֶ�, �Ǳ���, Ĭ�ϵ����id
		boolean unique() default false;
			* ����Ƿ�Ψһ
		boolean nullable() default true;
			* �Ƿ����Ϊnull
		boolean insertable() default true;
			* �Ƿ����һ������
		boolean updatable() default true;
			* �Ƿ����һ���޸�
		String columnDefinition() default "";
			* ��Լ��
		String table() default "";
		ForeignKey foreignKey() default @ForeignKey(PROVIDER_DEFAULT);
			* ���������, 

		* ��Ҫ��� @OneToOne,@OneToMany,@ManyToOne,@ManyToMany ʹ��, ��Ȼû����

	@JoinColumns
		JoinColumn[] value();
		ForeignKey foreignKey() default @ForeignKey(PROVIDER_DEFAULT);

		* ����ͬʱ������ @JoinColumn
	
	@JoinTable
		String name() default "";
			* �м�������

		String catalog() default "";
		String schema() default "";

		JoinColumn[] joinColumns() default {};
			* ��ǰ�������м���е������Ϣ
				@JoinColumn
					|-name					�м����, ��ǰ�����id�ֶ�����
					|-referencedColumnName	��ǰ�����id�ֶ�����


		JoinColumn[] inverseJoinColumns() default {};
			* �Է��������м���е������Ϣ
				@JoinColumn
					|-name					�м����, �Է������id�ֶ�����
					|-referencedColumnName	�Է������id�ֶ�����

		ForeignKey foreignKey() default @ForeignKey(PROVIDER_DEFAULT);
			@ForeignKey
				|-String name()
				|-ConstraintMode value() default CONSTRAINT;
					CONSTRAINT
					NO_CONSTRAINT
					PROVIDER_DEFAULT
				|-String foreignKeyDefinition() default "";

		ForeignKey inverseForeignKey() default @ForeignKey(PROVIDER_DEFAULT);

		UniqueConstraint[] uniqueConstraints() default {};
			@UniqueConstraint
				|-String name() default "";
				|-String[] columnNames();

		Index[] indexes() default {};
			@Index
				|-String name()
				|-String columnList();
				|-boolean unique() default false;
		
	@OrderBy
		String value() default "";
			
		* һ��� @OneToMany һ��ʹ��
			@OneToMany
			@OrderBy(value = "role_name DESC")
		

	
	@NamedEntityGraph
		String name() default "";
		NamedAttributeNode[] attributeNodes() default {};	

			@NamedAttributeNode
				|-String value();	
					* �����������������
				|-String subgraph() default "";
				|-String keySubgraph() default "";

			* ָ��Ҫjoin����������

		boolean includeAllAttributes() default false;

		NamedSubgraph[] subgraphs() default {};
			@NamedSubgraph
				|-String name();
				|-Class type() default void.class;
				|-NamedAttributeNode[] attributeNodes();
		
		NamedSubgraph[] subclassSubgraphs() default {};
			@NamedSubgraph
					|-String name();
					|-Class type() default void.class;
					|-NamedAttributeNode[] attributeNodes();
		

		* ��ʶ��ʵ������
		* �ڹ���������ʱ��, FetchType��ô����LAZY����EAGER��SQL����ִ�е�ʱ������һ�������ѯ��N���ӱ��ѯ��ɵ�
		* ���ֲ�ѯЧ��һ��Ƚϵ���, �����Ӷ�����N���ͻ�ִ��N+1��SQL

		* ����ͨ�� @NamedEntityGraphs ���ö��
			NamedEntityGraph[] value();
		
	@ForeignKey
		String name() default "";
		ConstraintMode value() default CONSTRAINT;
			CONSTRAINT
			NO_CONSTRAINT
			PROVIDER_DEFAULT
		String foreignKeyDefinition() default "";
		 
		* ������Ĺ�ϵ����
		* �����Ҫ����ʵ��֮����������ϵ, ������������ ConstraintMode ֵΪ NO_CONSTRAINT
			
			@JoinColumn(foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))

			@JoinTable(foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT), inverseForeignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	
	@ElementCollection
		Class targetClass() default void.class;
		FetchType fetch() default LAZY;

	@CollectionTable
		String name() default "";
		String catalog() default "";
		String schema() default "";
		JoinColumn[] joinColumns() default {};
		ForeignKey foreignKey() default @ForeignKey(PROVIDER_DEFAULT);
		UniqueConstraint[] uniqueConstraints() default {};
		Index[] indexes() default {};

	
	@PrimaryKeyJoinColumn
		String name() default "";
		String referencedColumnName() default "";
		String columnDefinition() default "";
		ForeignKey foreignKey() default @ForeignKey(PROVIDER_DEFAULT);

		* �ڹ�����ϵ��, һ��һ��ϵ��, ʹ�öԷ���id, ��Ϊ�Լ�������
---------------------
������ķ�װ
---------------------
	@SqlResultSetMapping
		String name(); 
			* ָ��һ��ӳ��Ĺ��������
		EntityResult[] entities() default {};
			* ָ��ʵ���ӳ����򼯺�
		ConstructorResult[] classes() default {};
			* ָ����������ӳ����򼯺�
		ColumnResult[] columns() default {};
			* ָ�������Ե�ӳ����򼯺�

		* ӳ�����Ķ���, ��������ʵ������
		* ����ͨ�� @SqlResultSetMappings ������
	
	@EntityResult
		Class entityClass(); 
		FieldResult[] fields() default {};
		String discriminatorColumn() default "";

		* ʵ���ӳ������
	
	@ColumnResult
		String name();
		Class type() default void.class;
	
	@ConstructorResult
		Class targetClass();
		ColumnResult[] columns();
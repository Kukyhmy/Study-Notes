---------------------
�̳�
---------------------
	@MappedSuperclass
		* ��ʶ��ʵ����ĸ���, ����JPAע��ļ̳�
		* һ�����ڳ�����, ��ȡ������ʵ���๫�õ��ֶ�, ��ʵ����̳���
		* ʹ�ø�ע���ʶ����, ��������  @Entity ע���ʶ

---------------------
�̳в���
---------------------
	@Inheritance
		* ָ��ʵ��ļ̳в���
			InheritanceType strategy() default SINGLE_TABLE;
				SINGLE_TABLE			���м̳е�ʵ�嶼������ͬһ�����ݿ����
				TABLE_PER_CLASS			�м̳й�ϵ������ʵ���඼�������ڵ����ı���
				JOINED					ÿ��ʵ�����඼��������һ�������ı���
		
	
	* һ������ָ�� entity �� entity ֮��ļ̳й�ϵ

---------------------
@Embedded ���ü̳�
---------------------
	@Embedded
		* ��ʶ��ʵ���������
		* һ�����������һ��������ȡ�����Ķ���, ��ʾҪ�������������Բ�ֿ����ϲ�����ǰ�Ķ���
			class Common{
				Integer id;
				String name;
			}
			class User {
				@Embedded
				Common common;
			}

			user table:
				id int
				name varchar

---------------------
�̳и�д
---------------------
	@AttributeOverride
		String name();
			* �������������

		Column column();
			* ���¶���
		
		* �����ض����ֶ����򳤶ȵ�����
		* ����ͨ�� @AttributeOverrides һ���Զ����� @AttributeOverride ע��
	
	@AssociationOverride
		String name();
		JoinColumn[] joinColumns() default {};
		ForeignKey foreignKey() default @ForeignKey(PROVIDER_DEFAULT);
		JoinTable joinTable() default @JoinTable;


		* ����ͨ�� @AssociationOverrides һ���Զ����� @AssociationOverride ע��
	

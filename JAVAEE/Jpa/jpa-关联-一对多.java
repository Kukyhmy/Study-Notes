-----------------------------
һ�Զ�Ĺ�ϵ
-----------------------------
	# �û�
		@Entity
		@Table(name = "user")
		public class User implements Serializable {
			@Id
			@Column(name = "id", columnDefinition = "INT(11) UNSIGNED COMMENT '�û�id'")
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Integer id;
			
			@Column(columnDefinition = "varchar(20) COMMENT '�ǳ�'")
			private String name;

			@OneToMany(targetEntity = Address.class)
			// �����Է�����ֶ�, ��ǰ����ֶ�
			@JoinColumn(name = "user_id", referencedColumnName = "id")
			private Set<Address> addresses = new HashSet<>();
		}


	# �û���ַ
		@Entity
		@Table(name = "address")
		public class Address implements Serializable{
			
			@Id
			@Column(name = "id", columnDefinition = "INT(11) UNSIGNED COMMENT '��ַid'")
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Integer id;
			
			@Column(columnDefinition = "VARCHAR(500) COMMENT '��ϸ��ַ'")
			private String name;
			
			@ManyToOne(targetEntity = User.class)
			// ��ǰ����ֶ� , �����Է�����ֶ�
			@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
			private User user;
		}
	
	# ���������1
		// �û�
		@OneToMany(targetEntity = Address.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
		@JoinColumn(name = "user_id", referencedColumnName = "id")
		private Set<Address> addresses = new HashSet<>();


		// ��ַ
		@Column(name = "user_id", columnDefinition = "INT(11) unsigned COMMENT '�û�id'", unique = false, nullable = false)
		private Integer userId;

		* ��ʱ, ��ַ����, ������ Foreign Key 
	
	# ���������2
		

		// �����ڵ�ַ����ӳ���ϵ
		@ManyToOne(targetEntity = User.class)
		@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
		private User user;


		* ��ʱ, ��ַ����, ������ Foreign Key 
			
		
-----------------------------
һ�Զ�Ĺ�ϵע��
-----------------------------
	@OneToMany
		Class targetEntity() default void.class;
			* �Է�ʵ������(���һ��������)

		CascadeType[] cascade() default {};
			* ������������, ö��
					ALL				�������в���
					PERSIST			��������
					MERGE			��������
					REMOVE			����ɾ��
					REFRESH			����ˢ��
					DETACH			��������
				* Ĭ��Ϊ��, ���������������
		
		FetchType fetch() default LAZY;
			* �������ݵĻ�ȡ��ʽ, ö��
				LAZY	�ӳټ���
				EAGER	��������
		
		String mappedBy() default "";
			* ������ϵ��˭ά��, һ�㲻����д���ֶ�, ��ʾ��ǰʵ����ά��
			* ���Ҫ����ά��Ȩ, �������ָ����, ��һ����ʵ������ @JoinColumn ���� @JoinTable �������ֶ�����, ���������ݿ��ֶ�, Ҳ����ʵ����������

			* ֻ�й�ϵά�������ܲ������߹�ϵ, ��ά������ʹ������ά�������Խ��д洢Ҳ��������������(���⼶�������ʱ��, ��һ��update����)
			* ��ʹ���˸�ע���ʱ��, ���ֶβ������ @JoinColumn ���� @JoinTable (����ͬʱʹ��)

		boolean orphanRemoval() default false;
			* �Ƿ���ɾ��, �� cascade = CascadeType.REMOVE Ч��һ��
			* ֻҪ�����������������е�����һ��, ���ᱻ����ɾ��
		
		* һ�Զ��ϵ

	@ManyToOne
		Class targetEntity() default void.class;
		CascadeType[] cascade() default {};
		FetchType fetch() default EAGER;
		boolean optional() default true;
			* �Ƿ����Ϊnull
		
		* ���һ��ϵ, ����ͬ��


-----------------------------
һ�Զ�ı���
-----------------------------
	# �ȱ�����, �ٱ����
		// �����û�
		User user = new User();
		user.setName("KevinBlandy");
		
		this.userRepository.save(user);
		
		// ������ַ
		Address address = new Address();
		address.setUser(user);  // user �����Ѿ��Ǳ����л��˵�, ������id����
		address.setName("����");
		
		this.addressRepository.save(address);

		* ֱ��ִ��2��insert���
	
	# �����������
		* ����һ�������˼�������: cascade = CascadeType.PERSIST 
			@OneToMany(targetEntity = Address.class, cascade = CascadeType.PERSIST)
			@JoinColumn(name = "user_id", referencedColumnName = "id")
		
		// �����û�
		User user = new User();
		user.setName("Litch");
		
		// ������ַ
		Address address = new Address();
		address.setName("�Ĵ�");
		
		address.setUser(user);  			// ���ù�ϵ
		user.getAddresses().add(address);  	// ���ù�ϵ
		
		this.userRepository.save(user);		// �����û���ͬʱ, �ᱣ���ַ


		* ��insert��2�����, Ȼ��update�ӱ��¼
	
	# �Ӽ���������
		* �ӵ�һ�������˼�������: cascade = CascadeType.PERSIST 
			@ManyToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
			@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
		
		// ������ַ
		Address address = new Address();
		address.setName("ս��ѧԺ");
		
		// �����û�
		User user = new User();
		user.setName("��������");
		
		
		address.setUser(user);
		user.getAddresses().add(address);
		
		this.addressRepository.save(address); // ������ַ��ͬʱ, �ᱣ���û�

		* ��insert��2�����, Ȼ��update�ӱ��¼
	
	# ������������ʱ������һ�� update ���, �������ά��Ȩ
		@OneToMany(mappedBy = "user", targetEntity = Address.class)
		// @JoinColumn(name = "user_id", referencedColumnName = "id")
		private Set<Address> addresses = new HashSet<>();

-----------------------------
һ�Զ��ɾ��
-----------------------------
	# ɾ������
		* ����ӱ�������, ������������Ϊnull, Ȼ����ɾ������
		* ����ӱ��зǿ�Լ��, ��ô���׳��쳣

		* ��������˷���ά���������Ȩ��, ����ɾ��(������ֶ��Ƿ�����Ϊnull, û�й�ϵ)
		* ��Ϊ��ɾ����ʱ��, ������ȥ���´ӱ������ֶ�

		* ����ӱ�û�й�������, ���ɾ��

	# ɾ���ӱ�
		* ���ɾ��
	
	
	# ɾ������, ����ɾ���ӱ�
		* ���������ü���ɾ��: cascade = {CascadeType.REMOVE}
			@OneToMany(mappedBy = "user", targetEntity = Address.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
		
		this.userRepository.deleteById(8); // ֱ�Ӹ���idɾ������

		* ��ִ��1����ѯ, ��������id, ��ѯ�ӱ�ļ�¼
		* ��ִ��1��ɾ��, ��������idɾ�������¼
		* ��ִ��n��ɾ��, ���ݴӱ�idɾ���ӱ��¼

	# ɾ���ӱ�, ����ɾ������
		* �Ӷ������ü���ɾ��: cascade = {CascadeType.REMOVE}
			@ManyToOne(targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
		
		this.addressRepository.deleteById(7);

		* ��ִ��1����ѯ, ���� inner join �ӱ�, ���ݴӱ�id������¼
		* ��ִ��1����ѯ, ��������id, �����ӱ��¼
		* ��ִ��n��ɾ��, ���ݴӱ�idɾ���ӱ��¼
		* ��ִ��1��ɾ��, ��������idɾ�������¼
		


-----------------------------
��Զ�Ĺ�ϵ
-----------------------------
	# �û�
		@Entity
		@Table(name = "user")
		public class User implements Serializable {
			
			private static final long serialVersionUID = 8175166175439387541L;
			
			@Id
			@Column(name = "id", columnDefinition = "INT(11) UNSIGNED COMMENT '�û�id'")
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Integer id;
			
			@Column(columnDefinition = "varchar(20) COMMENT '�ǳ�'")
			private String name;
			
			@ManyToMany(targetEntity = Role.class)
			@JoinTable(name = "user_role", joinColumns = {
				// ��ǰ�������м���й����ֶε�����, ��ǰ����Ĺ���id����
				@JoinColumn(name = "user_id", referencedColumnName = "id")
			}, inverseJoinColumns = {
				// �Է��������м���й����ֶε�����, �Է�����Ĺ���id����
				@JoinColumn(name = "role_id", referencedColumnName = "id")
			})
			private Set<Role> roles = new HashSet<>();
		}

	# ��ɫ
		@Entity
		@Table(name = "role")
		public class Role {
			@Id
			@Column(name = "id", columnDefinition = "INT(11) UNSIGNED COMMENT '��ɫid'")
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Integer id;
			
			@Column(columnDefinition = "varchar(20) COMMENT '��ɫ����'")
			private String name;
			
			@ManyToMany(targetEntity = User.class)
			@JoinTable(name = "user_role", joinColumns = {
				// ��ǰ�������м���й����ֶε�����, ��ǰ����Ĺ���id����
				@JoinColumn(name = "role_id", referencedColumnName = "id")
			}, inverseJoinColumns = {
				// �Է��������м���й����ֶε�����, �Է�����Ĺ���id����
				@JoinColumn(name = "user_id", referencedColumnName = "id")
			})
			private Set<User> users = new HashSet<>();
		}

	# �м��ṹ
		CREATE TABLE `user_role` (
		  `user_id` int(11) unsigned NOT NULL COMMENT '�û�id',
		  `role_id` int(11) unsigned NOT NULL COMMENT '��ɫid',
		  PRIMARY KEY (`role_id`,`user_id`),
		  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
		  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
		  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
	
	# ����ֻ���������һ��
		// �û�������

		// ��ɫ����
		@ManyToMany(targetEntity = User.class, cascade = CascadeType.PERSIST)
		@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
		}, inverseJoinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
		})
		private Set<User> users = new HashSet<>();

		
		* ��ʱ�����ı�, ���ǻᴴ��FOREIGN KEY���

-----------------------------
��Զ�Ĺ�ϵע��
-----------------------------
	@ManyToMany
		Class targetEntity() default void.class;
		CascadeType[] cascade() default {};
		FetchType fetch() default LAZY;
		String mappedBy() default "";
			* ������ϵ��˭ά��, һ�㲻����д���ֶ�, ��ʾ��ǰʵ����ά��
			* ���Ҫ����ά��Ȩ, �������ָ����, ��һ����ʵ������ @JoinColumn ���� @JoinTable �������ֶ�����, ���������ݿ��ֶ�, Ҳ����ʵ����������

			* ֻ�й�ϵά�������ܲ������߹�ϵ, ��ά������ʹ������ά�������Խ��д洢Ҳ��������������(���⼶�������ʱ��, ��һ��update����)
			* ��ʹ���˸�ע���ʱ��, ���ֶβ������ @JoinColumn ���� @JoinTable (����ͬʱʹ��)
		

-----------------------------
��Զ�ı���
-----------------------------
	# ����ά��Ȩ��һ��, ��Ҫ���ü�������: cascade = CascadeType.PERSIST
		User user = new User();
		user.setName("Vin");
		
		Role role = new Role();
		role.setName("ADC");
		
		// ���ö����ϵ
		role.getUsers().add(user);
		
		this.roleRepository.save(role);

		* ��ִ��3��insert, ��ɫ, �û�, �м��

		* ���˫��ͬʱά���˶����ϵ, ������һ������ά��Ȩ:@ManyToMany(targetEntity = Role.class, mappedBy = "users")
			user.getRoles().add(role);
			role.getUsers().add(user);

		* �������ά��Ȩ, ��ô��ִ�м��������ʱ����׳�key�ظ��쳣, ��Ϊ˫�������Բ�����ͬid�ļ�¼

		

-----------------------------
��Զ��ɾ��
-----------------------------
	# ɾ����¼��ʱ��, �϶���ȥɾ���м��ļ�¼
	# �Ƿ�Ҫɾ����һ���ļ�¼, ��Ҫ��ɾ�����Ƿ������˼���ɾ��: cascade = CascadeType.REMOVE

		@ManyToMany(targetEntity = Role.class, cascade = CascadeType.REMOVE)
		@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
		}, inverseJoinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
		})
		private Set<Role> roles = new HashSet<>();

		this.userRepository.deleteById(6);
	
		

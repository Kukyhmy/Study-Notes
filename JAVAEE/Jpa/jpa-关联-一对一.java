-----------------------------
һ��һ�Ĺ�ϵ
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
			
			@OneToOne(targetEntity = UserSeting.class)
			// ��ǰ����Ĺ����ֶ�, �Է�������ֶ�
			@JoinColumn(name = "id", referencedColumnName = "user_id", unique = true, nullable = false)
			private UserSeting userSeting;
		
		}

	# �û�����
		@Entity
		@Table(name = "user_seting")
		public class UserSeting implements Serializable {
			private static final long serialVersionUID = -1007318207008996614L;
			@Id
			@Column(name = "id", columnDefinition = "INT(11) unsigned COMMENT '����id'")
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Integer id;
			
			@Column(columnDefinition = "TINYINT(1) unsigned COMMENT '�Ƿ����֪ͨ'")
			private Boolean notify;
			
			@OneToOne(targetEntity = User.class)
			// ��ǰ����Ĺ����ֶ�, �Է�������ֶ�
			@JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false)
			private User user;
		}
	
	# ��ϵֻ��һ��1
		// �û�
		@OneToOne(targetEntity = UserSeting.class, cascade = CascadeType.PERSIST)
		@JoinColumn(name = "id", columnDefinition = "user_id", unique = true, nullable = false)
		private UserSeting userSeting;
		

		// �û�����
		@Column(columnDefinition = "INT(11) unsigned COMMENT '�û�id'", unique = true, nullable = false)
		private Integer userId;
		
		* ��ʱ, �û����ñ���, û������ Foreign Key 
	
	# ��ϵֻ��һ��2
		// �û�

		// �û�����
		@OneToOne(targetEntity = User.class)
		@JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false)
		private User user;

		* ��ʱ, �û����ñ���, ������ Foreign Key 



	
-----------------------------
һ��һ�Ĺ�ϵע��
-----------------------------
	@OneToOne
		Class targetEntity() default void.class;
		CascadeType[] cascade() default {};
			* ������������, ö��
				ALL				�������в���
				PERSIST			��������
				MERGE			��������
				REMOVE			����ɾ��
				REFRESH			����ˢ��
				DETACH			��������
			* Ĭ��Ϊ��, ���������������
				
		FetchType fetch() default EAGER;
			* �������ݵĻ�ȡ��ʽ, ö��
				LAZY	�ӳټ���
				EAGER	��������

		boolean optional() default true;
			* �Ƿ�����Ϊ��

		String mappedBy() default "";
			* ������ϵ��˭ά��, һ�㲻����д���ֶ�, ��ʾ��ǰʵ����ά��
			* ���Ҫ����ά��Ȩ, �������ָ����, ��һ����ʵ������ @JoinColumn ���� @JoinTable �������ֶ�����, ���������ݿ��ֶ�, Ҳ����ʵ����������

			* ֻ�й�ϵά�������ܲ������߹�ϵ, ��ά������ʹ������ά�������Խ��д洢Ҳ��������������(���⼶�������ʱ��, ��һ��update����)
			* ��ʹ���˸�ע���ʱ��, ���ֶβ������ @JoinColumn ���� @JoinTable (����ͬʱʹ��)

		boolean orphanRemoval() default false;
			* �Ƿ���ɾ��, �� cascade = CascadeType.REMOVE Ч��һ��
			* ֻҪ�����������������е�����һ��, ���ᱻ����ɾ��
		
		* һ��һ��ӳ���ϵ, ����˫�����, Ҳ����ֻ����һ��

-----------------------------
һ��һ�ı���
-----------------------------
	# �ֱ𱣴�
		* �ȱ�������һ��, �ٱ�������һ��
	
		// �ȴ洢�û�
		User user = new User();
		user.setName("KevinBlandy");
		this.userRepository.save(user);
		
		// �ٴ洢����
		UserSeting userSeting = new UserSeting();
		userSeting.setNotify(Boolean.FALSE);
		userSeting.setUser(user);
		
		this.userSetingRepository.save(userSeting);
		
		* ����insert, ��insert�û�, ��insert����

	# ��������
		* ִ�б����һ����Ҫ�����˼�������: cascade = CascadeType.PERSIST 
			@OneToOne(targetEntity = UserSeting.class, cascade = CascadeType.PERSIST)
			@JoinColumn(name = "id", columnDefinition = "user_id", unique = true, nullable = false)

		// �����û�
		User user = new User();
		user.setName("KevinBlandy");
		
		// ��������
		UserSeting userSeting = new UserSeting();
		userSeting.setNotify(Boolean.FALSE);
		
		
		// ���ù�ϵ
		userSeting.setUser(user);
		user.setUserSeting(userSeting);
		
		this.userRepository.save(user);

		* ����insert, ��insert�û�, ��insert����
	

-----------------------------
һ��һ��ɾ��
-----------------------------
		


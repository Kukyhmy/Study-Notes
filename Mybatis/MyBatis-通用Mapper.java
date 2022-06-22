---------------------------
MyBatis-ͨ��Mapper			|
---------------------------
	# ֻд�ӿ�,��д�����ļ�.ʵ��CRUD
	# maven�ֿ��ַ
		<dependency>
			<groupId>com.github.abel533</groupId>
			<artifactId>mapper</artifactId>
			<version>${abel533.version}</version>
		</dependency>


---------------------------
MyBatis-����Mapper			|
---------------------------
	# һ�������ַ�ʽ������Mapper
	1,JAVA���뷽ʽ

	2,Spring ����('��BUG����')

	3,������
		* ��ʵ����mybatisȫ�������е�һ�����
			<plugins>
				<!--
					ָ����������
				-->
				<plugin interceptor="com.github.abel533.mapperhelper.MapperInterceptor">
					<!--
						����������д����,Ĭ��ֵMYSQL
					-->
					<property name="IDENTITY" value="MYSQL" />
					<property name="mappers" value="com.github.abel533.mapper.Mapper" />
				</plugin>
			</plugins>

---------------------------
MyBatis-mapper�ӿ�,ʵ��		|
---------------------------
	# mapper�ӿ�ʵ��:com.github.abel533.mapper.Mapper<T>	�ӿ�
	# �÷��;���:'��ǰMapperҪ������ʵ�����'
	# һ��ʵ�ִ˽ӿ�,���������һЩ��ʽ
			//����ʵ���಻Ϊnull���ֶν��в�ѯ,����ȫ��ʹ��=��and����
		List<T> select(T record);
			//����ʵ���಻Ϊnull���ֶβ�ѯ����,����ȫ��ʹ��=��and����
		int selectCount(T record);
			//�����������в�ѯ,���뱣֤���Ψһ
			//�����ֶ�������ʱ,����ֱ��д������ֵ
			//��������ʱ,key������ʵ����,Ҳ������Map
		T selectByPrimaryKey(Object key);
			//����һ������
			//֧��Oracle����,UUID,����Mysql��INDENTITY�Զ�����(�Զ���д)
			//����ʹ�ô���Ĳ���ֵ,����ֵ��ʱ,�Ż�ʹ�����С�UUID,�Զ�����
		int insert(T record);
			//����һ������,ֻ���벻Ϊnull���ֶ�,����Ӱ����Ĭ��ֵ���ֶ�
			//֧��Oracle����,UUID,����Mysql��INDENTITY�Զ�����(�Զ���д)
			//����ʹ�ô���Ĳ���ֵ,����ֵ��ʱ,�Ż�ʹ�����С�UUID,�Զ�����
		int insertSelective(T record);
			//����ʵ�������ֶβ�Ϊnull����������ɾ��,����ȫ��ʹ��=��and����
		int delete(T key);
			//ͨ����������ɾ��,�������ֻ��ɾ��һ������
			//�����ֶ�������ʱ,����ֱ��д������ֵ
			//��������ʱ,key������ʵ����,Ҳ������Map
		int deleteByPrimaryKey(Object key);
			//�����������и���,�������ֻ�����һ������
			//����Ϊʵ����
		int updateByPrimaryKey(T record);
			//�����������и���
			//ֻ����²���null������
		int updateByPrimaryKeySelective(T record);
			//����Exmaple������ѯ����
		int selectCountByExample(Object example);
			//����Exmaple����ɾ��
		int deleteByExample(Object example);
			//����Exmaple������ѯ
		List<T> selectByExample(Object example);
			//����Exmaple�������·ǿ�(null)�ֶ�
		int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);
			//����Exmaple��������ȫ���ֶ�
		int updateByExample(@Param("record") T record, @Param("example") Object example);
	
	# ����'Ҫ������ʵ����',����һ��������
		1,��ͱ�����
			@Table(name="tb_user")
		2,���Ժͱ�������
			@Column(name="id")
		3,����ĳ���ֶ�,�����ע���ʶ�����Բ��ᱻ�������ݿ��ֶ���ʹ��
			@Transient
		4,�������ֶ�,�����ж�����γ���������
			@id
		4,ָ��������������ʽ,��ʶ��ID��
			UUID:
				@GeneratedValue(generator = "UUID")
			������:
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				
---------------------------
MyBatis-��ȫ��������ɨ��	|
---------------------------
	<package name="com.kevin.mybatis.mapper"/>
	# ����˵,�㶮

---------------------------
MyBatis-ʵ�ֲ���			|
---------------------------
	# ֱ�ӻ�ȡ��session.getMapper(Mapper�ӿ�.class);
	# Ȼ�����ʹ����Щ�����ڸ���ķ���
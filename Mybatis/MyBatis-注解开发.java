������������������������������������������������
1,MyBatisע�⿪��		|
������������������������������������������������
	
������������������������������������������������
2,ע�⿪�� - SQLӳ��	|
������������������������������������������������
	* ��ʵ���ַ�ʽ,����'mapper������'�ķ���.
	1,�Զ���'�ӿ�',���������Ӧ��ע��
		package com.kevin.mapper;
		import java.util.List;
		import org.apache.ibatis.annotations.Delete;
		import org.apache.ibatis.annotations.Insert;
		import org.apache.ibatis.annotations.Select;
		import org.apache.ibatis.annotations.Update;
		import com.kevin.vo.User;
		/**
		 * UserMapper,ע�⿪��
		 * */
		public interface UserMapper 
		{
			/**
			 * ����һ������
			 * */
			@Insert(value="INSERT INTO user VALUES(#{id},#{name},#{gender})")
			public void save(User user);
			/**
			 * ɾ��һ������
			 * */
			@Delete(value="DELET FROM use WHERE id=#{id}")
			public void delete(User user);
			/**
			 * ����ID��ѯһ������
			 * */
			@Select(value="SELECT * FROM user WHERE id=#{id}")
			public User findById(User user);
			/**
			 * ����ID�޸�һ���û�
			 * */
			@Update(value="UPDATE user as u SET u.name=#{name},u.gender=#{gender} WHERE u.id=#{id}")
			public void updateUser(User user);
			/**
			 * ��ȡ��¼����
			 * */
			@Select(value="SELECT COUNT(*) FROM user")
			public Integer getCount();
			/**
			 * ��ȡ���ж���
			 * */
			@Select(value="SELECT * FROM user")
			public List<User> getAll();
		}

	2,�ں��������ļ�(SqlMapConfig.xml)�����ø���
		<mapper class="com.kevin.mapper.UserMapper"/>

	3,ͨ��SqlSession��'getMapper(T.class);'����,����ӿڵ� Class ��������ȡ�������
		UserMapper userMapper = session.getMapper(UserMapper.class);

	4,ֱ��ִ�з��ؽӿ����ö���ĳ��󷽷�,�����Զ�ִ�нӿڳ��󷽷��϶����SQL���
		User u = userMapper.findById(user);

������������������������������������������������
3,ע�⿪�� - ��ϵӳ��	|
������������������������������������������������
	 @Results(id = "BASE_RESULT_MAP",value = {
        @Result(column = "",property = "",one = @One(select = "")),
        @Result(column = "",property = "",many = @Many(select = ""))
    })

	* @One �� @Many �е� select ������ mapper�����������ռ�,Ҳ����ֱ����SQL���
	
	
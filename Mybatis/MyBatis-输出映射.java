������������������������������������������������
1,MyBatis-���ӳ��		|
������������������������������������������������
	* MyBatis �����ַ�ʽ�����ӳ��
	1,resultType
		���POJO����
		* ʹ��resultType�������ӳ��,ֻ�в�ѯ������������POJO�е�������һ��,��ô���в���ӳ��ɹ�!
		  �����ѯ��������,��������ȫ����һ��,��ô�����Ͳ��ᴴ�����POJO����
		* ֻҪ��ѯ������������POJO��������,������һ����ͬ.��ô�ͻᴴ��POJO����

		���������
		* ��ʵ���ǾۺϺ�����һ��,��ѯ������,ƽ��ֵ��,�ܺͰ�
		* ����ѯ�����Ľ�����ǵ��е��е�ʱ��,����ʹ�ü����������������ӳ��
		<select id="count" resultType="java.lang.Integer">
			SELECT COUNT(*) FROM user;
		</select>

		['�ܽ�']
			* ���������POJO����������һ���б�(������POJO��List)
			  ��ô��mapper.xml�е�resultTypeָ�������Ͷ���һ����,��һ���ĵط�����mapper�ӿ��з����ķ���ֵ��һ��
			* ���ɵĶ�̬�������,�Ǹ���mapper�����ķ���ֵ,��ȷ����selectOne(),����selectList()
		
		���HashMap����
			* �����������͸�Ϊ:java.util.HashMap
			* ������ֶ�����Ϊkey,ֵΪvalue

	2,resultMap
		* MyBatis�п���ʹ��resultMap����ɸ߼���������ӳ��
		* Ҳ������ν��:һ�Զ�,һ��һ... ...�ȵ�
		
		* ���˵��ѯ������������POJO���������Ʋ�һ��,����ӳ���ΪPOJO.��ô�Ϳ��Զ���һ��resultMap����������������֮������һ��ӳ���ϵ
		1,����resultMap
		2,ʹ��resultMap,����Ϊstatement���������
			<!-- �����������
			1,type :ָ����,��ӳ������ӳ������Ľ����������
			2,id:��ʾ����,��ѯ������е�Ψһ��ʶ�Ķ���
				column:��ѯ����������
				property:POJO��������
			* �����,����ֶ���ɵ�Ψһ��ʶ.��ô�Ͷ�����id
			3,result:��ʾ����,��ͨ�еĶ���
				column:��ѯ����������
				property:POJO��������
			 -->
			<resultMap type="com.kevin.domian.User" id="user">
				<id column="userid" property="id"/>
				<result column="name" property="username"/>
			</resultMap>
			<!--�������ӳ���map
				resultMap:ָ��Ҫʹ���ĸ�resultMapӳ����
					* ����ƶ���ӳ�����������ĵ�mapper.xml��,��ô��Ҫ���������ռ�:xxx.xxx
			-->
			<select id="find" parameterType="int" resultMap="user">
				SELECT u.id userid ,u.username name FROM user u WHERE u.id=#{id}
			</select>

������������������������������������������������������������������������
2,resultMap��resultType�ܽ�			|
������������������������������������������������������������������������
	resultType
		* ʵ�ּ�,ֻҪ��֤POJO������,����ѯ������е�����ȫ����Ӧ,��OK,������ʹ�õ�reultMap.
		* ����ʵ���ӳټ���(���ݶ�����һ��װ����������,�ӳټӸ�ë��)
	resultMap
		* ʵ�ֱȽ��鷳,��Ҫ�Լ����� resultMap,���������ӵķ���JAVA���������˼��.
		* ����ʵ���ӳټ���
	

	
	
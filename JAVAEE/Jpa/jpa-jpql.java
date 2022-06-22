-------------------------
jpql
-------------------------
	# �����İ�
		* ͨ��λ�ð�	WHERE id = ?1
		* ͨ�����ư�	WHERE id = :id
	
	# JPQL���޸�Ҫ�������½��з�������쳣: InvalidDataAccessApiUsageException
		 Executing an update/delete query; nested exception is javax.persistence.TransactionRequiredException: Executing an update/delete query

----------------
JPQL�����﷨
----------------
	# �﷨
		* �������Ƕ��� @Entity, ���Ǳ�, �������Ƕ�������, Ҳ�����ֶ�
		* Ĭ��Entity���ƾ��������ƴ�д, Ҳ����ͨ���޸� @Entity ���Ե�ע�����޸�

		* ��֧��ʹ�� `` ����, ��֧����ĩβ��ӷֺ�: ;
		* ֧��ʹ�� AS �ؼ��������

	
	# LIKE
		FROM User u WHERE u.name LIKE :name
			* �������, ��Ҫ�Լ���� % ����
	
	# IN
		FROM User u WHERE u.id in :ids
			* ids��һ������
	
	# COUNT
		SELECT COUNT(1) FROM User
	
	# ORDER BY
		FROM User u WHERE u.id = :id ORDER BY id DESC
	
	# INSERT INTO 
		//TODO
	
	# ʹ�� new �ؼ���������ָ�����͵ķ��ض���
		SELECT new io.springboot.jpa.domain.model.UserModel(u.name) FROM User AS u WHERE u.id = :id
		
			* ͨ�����췽��, ����������
			* ��������Ǳ�EntityManager�����, ����ֻд������, ������Ҫ������������·��
			* ͨ�����ַ�ʽ��������: ����ֻ���������ֶ�
		
	# ʹ��Map��Ϊ�������

		SELECT new map(u.name AS name, u.id AS id) FROM User AS u WHERE id = :id
			* ��Ҫ�Լ�������, ʹ��AS�����, ��Ϊkey������
			* ���ж��з��صĽ��������: List<Map<String, Object>> (�κ����������)
			* ���е��з��صĽ��������: Map<String, Object>

			* ��������ñ���, ���е��е������, key = null, ���е������, key = ���(��0��ʼ)
				{
					"0":"Kevin",
					"1":1
				}
	
	# �������������ֶ�
		SELECT u.name, u.id FROM User AS u
			* ���� List<Object[]>
			* ������ new ���󷽷���ʹ��Map��Ϊ�����Ҳ�������
	
	
	# �������������ֶ�
		SELECT u.name FROM User AS u WHERE u.id = :id

			* ����ֵ����, �͸����ֶε����Ͷ���
	
	# ��������/����ֶε��ܽ�
		* �����ֶε�����¼ʱ, ���� Object 
		* �����ֶζ�����¼ʱ, ���� List<Object>
		* ����ֶ�ʱ, �����Ƕ�����¼���ǵ�����¼, �������Ͷ��� List<Object[]>
	

	# ���峣������
		SELECT new UserModel('unknow' AS name, u.id) FROM User AS u
			
			* ͨ�� Ĭ��ֵ AS ���� ����

	
	# JOIN ��ѯ
		SELECT u.name AS userName, a.name AS addressName FROM User AS u INNER JOIN Address AS a ON u.id = a.userId
		SELECT u.name AS userName, a.name AS addressName FROM User AS u LEFT JOIN Address AS a ON u.id = a.userId
		SELECT u.name AS userName, a.name AS addressName FROM User AS u RIGHT JOIN Address AS a ON u.id = a.userId

		* һ���� inner, left, right

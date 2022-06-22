------------------
criteria
------------------
	# ���ĵĽӿ�
		Predicate
		Root	
			* ��ѯ�ĸ�����, �Ӹ������л�ȡ��Ҫ��ѯ������
			* ͨ�� AbstractQuery <T> ������ķ�����ȡ
				<X> Root<X> from(Class<X> entityClass);
				<X> Root<X> from(EntityType<X> entity);
		
		CriteriaBuilder
			* ��ѯ�Ĺ�����, ��װ�˺ܶ�Ĳ�ѯ��ʽ, ����
			* �� EntityManager �ķ�����ȡ
				CriteriaBuilder getCriteriaBuilder();

		CriteriaQuery
			* �����ѯ����
				�� CriteriaBuilder �ķ�����ȡ
			
			* ������ select, from, where, group by, order by �Ȳ���


---------------------
����
---------------------
	# ��������
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		List<User> users = entityManager.createQuery(criteriaQuery).getResultList();

		select
			user0_.id as id1_0_,
			user0_.create_date as create_d2_0_,
			user0_.version as version3_0_,
			user0_.name as name4_0_ 
		from
			user user0_

	# ���������ϵ
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		// ��������֮���һ���ϵ, ��ϵ��or
		Predicate p1 = criteriaBuilder.or(criteriaBuilder.lt(root.get(User_.id), 1), criteriaBuilder.like(root.get(User_.name), "K"));
		// ��������֮ǰ��һ���ϵ, ��ϵ��and
		Predicate p2 = criteriaBuilder.and(p1, criteriaBuilder.lt(root.get(User_.id), 2));
		List<User> users = entityManager.createQuery(criteriaQuery.where(p2)).getResultList();

		select
			user0_.id as id1_0_,
			user0_.create_date as create_d2_0_,
			user0_.version as version3_0_,
			user0_.name as name4_0_ 
		from
			user user0_ 
		where
			(
				user0_.id<1 
					or 
				user0_.name like ?
			) 
		and 
			user0_.id<2
	
	
	# COUNT ͳ�Ʋ�ѯ
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<User> root = criteriaQuery.from(User.class);
		Expression<Long> expression = criteriaBuilder.count(root);
		criteriaQuery.select(expression);
		Long count = entityManager.createQuery(criteriaQuery).getSingleResult();
	
	# ���������ֶ�
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root.get(User_.name));  // ������ִ�� select, ֻ�����һ����Ч
		criteriaQuery.where(criteriaBuilder.equal(root.get("id"), 1));
		String result = entityManager.createQuery(criteriaQuery).getSingleResult();
	
	# ��������ֶ�, �����װΪ����
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.multiselect(root.get("id"), root.get("name"));
		criteriaQuery.where(criteriaBuilder.equal(root.get("id"), 1));
		User user = entityManager.createQuery(criteriaQuery).getSingleResult();

		select
			user0_.id as col_0_0_,
			user0_.name as col_1_0_ 
		from
			user user0_ 
		where
			user0_.id=1
		
		* �������Ҫ��ָ���Ĺ��캯��(���ݼ��������Զ���)
	
	# ��������ֶ�, �����װΪ List<Object[]>
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.multiselect(root.get("id"), root.get("name"));
		criteriaQuery.where(criteriaBuilder.equal(root.get("id"), 1));
		List<Object> results = entityManager.createQuery(criteriaQuery).getResultList();
	
	# IN ��ѯ
		In<Integer> in = criteriaBuilder.in(root.get("id"));
		in.value(1);		// ��Ӷ���ֶ�
		in.value(2);		// ��Ӷ��in
		

	# �Ӳ�ѯ

	
	

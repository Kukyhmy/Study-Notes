---------------------
Criteriaɾ��
---------------------
	# ɾ���ӿ�
		CommonAbstractCriteria
			|-CriteriaDelete
	
	# ���󷽷�
		Root<T> from(Class<T> entityClass);
		Root<T> from(EntityType<T> entity);
		Root<T> getRoot();
		CriteriaDelete<T> where(Expression<Boolean> restriction);
		CriteriaDelete<T> where(Predicate... restrictions);

		<U> Subquery<U> subquery(Class<U> type);
		Predicate getRestriction();
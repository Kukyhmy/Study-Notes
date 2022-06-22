----------------------
Predicate 
----------------------
	# ���������Ľӿ�
		TupleElement
			|-Selection
				|-Expression
					|-Predicate
	# ���󷽷�
		BooleanOperator getOperator();
			* ö��
				AND, OR
			
		boolean isNegated();
		List<Expression<Boolean>> getExpressions();
		Predicate not();

		Predicate isNull();
		Predicate isNotNull();
		Predicate in(Object... values);
		Predicate in(Expression<?>... values);
		Predicate in(Collection<?> values);
		Predicate in(Expression<Collection<?>> values);
		<X> Expression<X> as(Class<X> type);

		Selection<X> alias(String name);
		boolean isCompoundSelection();
		List<Selection<?>> getCompoundSelectionItems();

		Class<? extends X> getJavaType();
		String getAlias();

	
-------------------------
Comparator<T>			 |
-------------------------
	# ��һ�������ӿ�
	# int compare(Object obj) 
		* �ж϶����Ƿ����,һ����ΪһЩ���Ͽ�ܵıȽ���

		
	# Ĭ�Ϸ���
		Comparator<T> thenComparing(Comparator<? super T> other)
		<U> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator)
		<U extends Comparable<? super U>> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor)
		Comparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor)
		Comparator<T> thenComparingLong(ToLongFunction<? super T> keyExtractor)
		Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor)


	# �ṩ�ľ�̬ʵ��
		static <T extends Comparable<? super T>> Comparator<T> reverseOrder()
			* ��������

		static <T extends Comparable<? super T>> Comparator<T> naturalOrder()
			* ��Ȼ����

		static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator)
		static <T> Comparator<T> nullsLast(Comparator<? super T> comparator)
			* null Ԫ������ͷ����β

		static <T, U> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator)
		static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor)
		static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor)
		static <T> Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor)
		static<T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor)

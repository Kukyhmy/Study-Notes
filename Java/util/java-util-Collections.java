-------------------------
Collections				 |
-------------------------
	# ���ڲ��� Set,List,Map �ľ�̬������


-------------------------
Collections-��̬�ֶ�/����|
-------------------------
	boolean addAll(Collection<? super T> c, T... elements)
		* �ѱ䳤���ݶ�����c
	
	void shuffle(List<?> list);
		* ������Ҽ�������
	
	void shuffle(List<?> list, Random rnd)
		* ͬ��,ָ���� Random
	
	<E> Set<E> newSetFromMap(Map<E, Boolean> map) 
		* ʹ��ָ����Map������һ��Set����
	
	
	<T> Collection<T> unmodifiableCollection(Collection<? extends T> c)
		* �ܶ����ط���, ��һ������, ���һ�������޸ĵļ���
	
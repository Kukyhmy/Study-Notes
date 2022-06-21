
--------------------
List				|
--------------------
	# �ӿ�
	# ʵ����
		ArrayList
			* ����ṹ,������,��ɾ��
		LinkedList
			* ����ṹ,��ɾ��,������
			*
				addFIrst();
					��Ԫ�ط���������һ��λ��,��������
				addLast();
					��Ԫ�ط�����������λ��,�����Ӻ�

				getFirst();
				getLast();
					��ȡԪ�ء����ǲ�ɾ��Ԫ��

				removeFirst();
				removeLast();
					��ȡԪ��,���ǻ�ɾ��Ԫ��,���������û��Ԫ�ػ��׳��쳣

				��JDK1.6���������������

				offerFirst();
				offerLast();
					���Ԫ�ء�ͬ��
				peekFirst();
				peekLast();
					��ȡԪ��,����ɾ��
				pollFirst();
				pollLast();
					��ȡԪ��,ɾ��Ԫ��,���������û��Ԫ��,�����׳��쳣
 	
	��ȡԪ�ء����ǻ�ɾ��Ԫ�ء����������û��Ԫ�ػ᷵�� ����null!
	# ���󷽷�
		boolean add(E e) 
			* ���б��β�����ָ����Ԫ�ء� 
		void add(int index, E element) 
			* ���б��ָ��λ�ò���ָ��Ԫ�ء� 
		void clear() ;
			* ���
		Object[] toArray() 
			* ���ذ��ʵ�˳������б��е�����Ԫ�ص����飨�ӵ�һ��Ԫ�ص����һ��Ԫ�أ��� 
		<T> T[] toArray(T[] a);
			* ת��Ϊ����,���ص�������Ǵ��ݽ�ȥ���Ǹ�����
		E set(int index, E element) 
			* ��ָ��Ԫ���滻�б���ָ��λ�õ�Ԫ�ء� 
		int size() 
			* �����б��е�Ԫ������ 
		ListIterator<E> listIterator() 
			* ���ش��б�Ԫ�ص��б�����������ʵ�˳�򣩡� 
		ListIterator<E> listIterator(int index) 
			* �����б���Ԫ�ص��б�����������ʵ�˳�򣩣����б��ָ��λ�ÿ�ʼ�� 
		Iterator<E> iterator() 
			* ���ذ��ʵ�˳�����б��Ԫ���Ͻ��е����ĵ������� 
	
--------------------
Set					|
--------------------
	# �ӿ�
	# ʵ����
		HashSet
			* Hash��,ͨ�� hasCode �� equals ��ȷ�������Ψһ��
		TreeSet
			* �������ṹ,ͨ�� ����ʵ���� Comparable �ķ������ж϶����Ψһ������
	# ���󷽷�

--------------------
Map					|
--------------------
	# �ӿ�
	# ʵ����
		HashMap
			* Hash��,ͨ�� hasCode �� equals ��ȷ�������Ψһ��
			* �� Hashtable ������
				1,Hashtable �������� null,HashMap ����
				2,Hashtable ��jdk1�Ķ���,HashMap ��jdk2
				3,Hashtable �̰߳�ȫ,HashMap �̲߳���ȫ
		TreeMap
			* �������ṹ,ͨ�� ����ʵ���� Comparable �ķ������ж϶����Ψһ������

	# ���󷽷�
	

	# JDK8��������
			V getOrDefault(Object key,V defaultVlue);
				* ��� key ����,�򷵻� Value,���������,�򷵻� defaultVlue 
			
				
			V compute(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction) 
				* ��ͨ�� key ȥ���� value,�������ֱ�ӷ���
				* ���value ������,������ remappingFunction Lambda ��ȡ value,���Ҵ��� map,Ȼ�󷵻�
			

		

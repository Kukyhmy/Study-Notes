---------------------------
LinkedHashMap				|
---------------------------
	# �̳��� hashMap,ʵ���� Map �ӿ�
	# ˫������(ͷָ��,βָ��)ʵ��

	# ����
		LinkedHashMap(int initialCapacity)
		LinkedHashMap(int initialCapacity, float loadFactor)
		LinkedHashMap(int initialCapacity,float loadFactor,boolean accessOrder)
		LinkedHashMap(Map<? extends K, ? extends V> m)

		initialCapacity
			* ��ʼ����

		loadFactor
			* ��������

		accessOrder
			* �Ƿ�װ����ʱ���������
			* ������ʵ���������ǰ��
			* ��Ԫ�صķ���,��ʹԪ���ƶ���������

	# ����
		protected boolean removeEldestEntry(Map.Entry<K,V> eldest);
			* LinkedHashMap�Դ����ж��Ƿ�ɾ�����ϵ�Ԫ�ط���,Ĭ�Ϸ���false,����ɾ��������
			* ������д�������,������һ������ʱɾ��������(����β)
		

		

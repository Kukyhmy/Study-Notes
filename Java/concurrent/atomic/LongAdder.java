-------------------------
LongAdder				 |
-------------------------
	# �ⶫ��JDK8���еĶ���, �������:AtomicLong
		* �ڲ���ʵ���е����� ConcurrentHashMap �ķֶ���
		* ��õ������, ÿ���̶߳��ж����ļ�����, �������Դ������ٲ�������
	
	# AtomicLong ������
		* Ϊ��ʵ����ȷ���ۼӲ���, ����������ܴ�Ļ�,cpu�Ứ�Ѵ�����ʱ�����Դ�����
		* �൱��һ��spin(����)�Ĳ���, ���������С�����, ��Щ���Ŀ��Ժ��Բ���
		
	
	# ���캯��
		LongAdder()
	
	# ʵ������
		void add(long x) 
		void decrement()
		double doubleValue()
		float floatValue()
		void increment()
		int intValue()
		longValue()
		reset()
		long sum()
		long sumThenReset()
	
	# �ܽ�
		* ���̻߳���, AtomicLong ���ܱ� LongAdder ��
		* һЩ�߲����ĳ���, ��������������, ����ʹ�� LongAdder �滻 AtomicLong, ���ܿ�����������
	
	# JDK���ṩ��һЩ�������͵�ԭ������/�Լ�
		DoubleAdder
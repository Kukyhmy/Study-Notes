
# ����
	* Foo�߳��Ѿ���ȡ��a��,Foo�ٴλ�ȡa��,��OK���Գɹ���ȡ����,�����������
		class Bar{
			public synchronized void test() {
			}
		}
		public class Foo extends Bar{
			public synchronized void test() {
				/*
					��ǰ�߳��Ѿ�������this�����,���ʸ���ķ���,���û���������,��ô�ͻ�һֱ����.��Ϊthis���Ѿ���������

				*/
				super.test();		
			}
		}
	
	* �����ʵ��
		1,Ϊ�����������һ��������,����һ���̳߳������������ʱ��,������ +1
		2,���߳��˳�ͬ��������ʱ��,������ -1,��������Ϊ0��ʱ��,��������ᱻ�ͷ�
	

# ��ԭ���Ե�64λ����
	* jvm�涨,������������ֵ,��һ��ԭ�Ӳ���,���Ǵ���һ������
	* �� volatile ���͵�64λ��ֵ����(double & long),jvm�����64λ�Ķ���д������Ϊ����32λ�Ķ���д
	* ����ȡһ���� volatile �� long ʱ,��д����һ���߳�,��ô�ܿ��ܶ���ĳ��ֵ�ĸ�32λ���ߵ�32λ
	* �ڶ��̻߳�����,ʹ�ù����ҿɱ�� long,double �����а�ȫ�����,Ӧ�ü�������ʹ�� volatile �ؼ�������


# ͬ��������Ҫ����ͬ������
	* ֧�ֿͻ��˼���
	* ����
		public static Object getLast(Vector<String> vector) {
			int index = vector.size();
			return vector.get(index - 1);
		}
		public static Object removeLast(Vector<String> vector) {
			int index = vector.size();
			return vector.remove(index - 1);
		}
		A -> size = 10 -> removeLast()  
		b -> size = 10	-> ʧȥִ��Ȩ ->  getLast();		//�쳣����Խ��
	* ���,�ͻ��˼���
		public static Object getLast(Vector<String> vector) {
			synchronized (vector){
				int index = vector.size();
				return vector.get(index - 1);
			}
			
		}
		public static Object removeLast(Vector<String> vector) {
			synchronized (vector){
				int index = vector.size();
				return vector.remove(index - 1);
			}
		}
	

# �����ϣ���ڵ����ڼ�����ݼ���,��ôһ������������ǿ�¡����,���ڸ����Ͻ��е���
	* ���ڸ���������߳���,��������̲߳����ڵ����ڼ��������޸�
	* ��¡�Ĺ���Ҳ����Ҫ������

# �������hashCode��equals,toString(),contains....�ȵ�Ҳ�����Ե�ִ�е�������
	* ��Щ��ӵĵ����������п��ܻ��׳� ConcurrentModificationException

# һЩ���
	Queue
		BlockingQueue
			LinkedBlockingDeque
			ArrayBlockingQueue
			PriorityBlockingQueue
			SynchronousQueue
		ConcurrentLinkedQueue
		LinkedList
		PriorityQueue

	Deque
		BlockingDeque
			LinkedBlockingDeque
		ArrayDeque
	
	Map
		ConcurrentHashMap
		ConcurrentSkipListMap
	
	Set
		ConcurrentSkipListSet
		CopyOnWriteArraySet
	
	List
		CopyOnWriteArrayList
	
	AtomicReference
	Semaphore
	CountDownLatch
	FutureTask
	CyclicBarrier
	CompletionService
		ExecutorCompletionService
	Executor
		ExecutorService
		ThreadPoolExecutor
		ScheduledExecutorService
		ScheduledThreadPoolExecutor
		
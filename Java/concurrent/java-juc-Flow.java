-------------------
Flow
-------------------
	# ��������, ��Ӧʽ�������������
	# JDK9���¶���, ͬ��������Doug Lea����
	# Դ��
		public final class Flow {
			@FunctionalInterface
			public static interface Publisher<T> {
				public void subscribe(Subscriber<? super T> subscriber);
			}

			public static interface Subscriber<T> {
				public void onSubscribe(Subscription subscription);
					* ��һ�ν������Ĺ�ϵ

				public void onNext(T item);
					* ���ܵ�����

				public void onError(Throwable throwable);
					* �쳣

				public void onComplete();
					* �쳣�������
			}

			public static interface Subscription {
				public void request(long n);
					* ���߷����ߣ���ǰ��������Ҫ���Ѷ�����Դ

				public void cancel();
			}

			public static interface Processor<T,R> extends Subscriber<T>, Publisher<R> {}

			static final int DEFAULT_BUFFER_SIZE = 256;
				* Ĭ�ϻ���صĳ���

			public static int defaultBufferSize() {
				return DEFAULT_BUFFER_SIZE;
			}
		}

	# Publisher
		* �������������ݺͿ����¼��ķ���

	# Subscriber
		* �������������ݺ��¼��ķ���

	# Subscription
		* ����������Publisher��Subscriber�ķ���
		
	# Processor<T,R>
		* ������ת��Publisher��Subscriber�ķ���
			Publisher(T) -> Processor -> Subscriber(R)
		
		* Publisher���������ݣ����Ա�Processor����ת�������˺��ٸ�Subscriber����
		

	# �����, ʵ����
		* Publisher�ӿڵļ�ʵ��, ���Խ������ڼ򵥵���������չ�������Լ�������
		* ��ΪӦ�ó��򿪷���Ա, �ᷢ��ʵ����Щ�ӿںܸ���
		* RxJava����Ӧʽ����Javaʵ��֮һ



-------------------
SubmissionPublisher
-------------------
	# Flow.Publisher ��ʵ��
		class SubmissionPublisher<T> implements Publisher<T>, AutoCloseable
	
		* ������������������, ͬʱ��Reactive Stream����
	
	# ���캯��
		public SubmissionPublisher(Executor executor, int maxBufferCapacity, BiConsumer<? super Subscriber<? super T>, ? super Throwable> handler)
		public SubmissionPublisher(Executor executor, int maxBufferCapacity)
		public SubmissionPublisher()
	
	# ʵ������
		public void subscribe(Subscriber<? super T> subscriber)
			* ����������
		
		public int submit(T item)
			* ��������
		
		public int offer(T item, BiPredicate<Subscriber<? super T>, ? super T> onDrop)
		public int offer(T item, long timeout, TimeUnit unit, BiPredicate<Subscriber<? super T>, ? super T> onDrop)
		public void close()
		public void closeExceptionally(Throwable error)
		public boolean isClosed()
		public Throwable getClosedException()
		public boolean hasSubscribers()
		public int getNumberOfSubscribers()
		public Executor getExecutor()
		public int getMaxBufferCapacity()
		public List<Subscriber<? super T>> getSubscribers()
		public boolean isSubscribed(Subscriber<? super T> subscriber)
		public long estimateMinimumDemand()
		public int estimateMaximumLag()
		public CompletableFuture<Void> consume(Consumer<? super T> consumer)
	

	# Demo
		import java.util.concurrent.Flow;
		import java.util.concurrent.SubmissionPublisher;
		import java.util.concurrent.TimeUnit;

		public class MainTest {
			public static void main(String[] args) {
				// ����������
				SubmissionPublisher<Integer> submissionPublisher = new SubmissionPublisher<>();
				// ����������
				Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<>() {
					private Flow.Subscription subscription;
					@Override
					public void onSubscribe(Flow.Subscription subscription) {
						System.out.println("�������ѹ�ϵ����");
						subscription.request(10); // ��ʼֻ����10������
						this.subscription = subscription;
					}

					@Override
					public void onNext(Integer item) {
						System.out.println("���ѵ������ݣ�" + item);
						if (item.equals(5)) {
							// ���ѵ���5����ʱ�򣬰չ������ˡ�ȡ�����ġ�
							this.subscription.cancel();
						} 

						// ��Ӧʽ�Ĺؼ�ʵ�֣�������������������֮���ٵ���request������������Ҫ����
						// ������������Ϣ������ѹ������
						// subscription.request(1); 
					}
					@Override
					public void onError(Throwable throwable) {
						// onNext�г������쳣
						System.err.println("�쳣�ˣ�" + throwable.getMessage());
						this.subscription.cancel();
					}
					@Override
					public void onComplete() {
						// �����ߵ��ùرյ�ʱ�򣬻ᱻ����
						System.out.println("�������");
					}
				};

				// ������ϵ
				submissionPublisher.subscribe(subscriber);

				// ��������
				for (int i = 0; i < 5; i ++){
					submissionPublisher.submit(i);
				}

				// �رշ����ߣ�һ����finally��
				submissionPublisher.close();

				try {
					// ���߳���ͣ��
					Thread.sleep(TimeUnit.SECONDS.toMillis(10));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}



	
	
------------------------
CyclicBarrier			|
------------------------
	# (ѭ��դ��)�� CountDownLatch �ǳ�����,��Ҳ����ʵ���̼߳�ļ����ȴ�
	# �������Ĺ��ܱ� CountDownLatch ���Ӹ��Ӻ�ǿ��,��ҪӦ�ó����� CountDownLatch ����
		* �������ڶ��̼߳�������,���ϲ���������Ӧ�ó���

	# �� CountDownLatch ������
		CountDownLatch:һ�����߶���߳�,�ȴ���������߳����ĳ������֮�����ִ��
			* �ص���һ���߳�(����߳�_�ȴ�,��������N���߳������ĳ������֮��,������ֹ,Ҳ���Եȴ�
			* �����ظ�ʹ��

		CyclicBarrier:����̻߳���ȴ�,ֱ������ͬһ��ͬ����,�ټ���һ��ִ��
			* �ص��Ƕ���߳�,������һ���߳�û�����,���е��̶߳�����ȴ�
			* �����ظ�ʹ��

	# ��������
		CyclicBarrier(int parties)
		CyclicBarrier(int parties, Runnable barrierAction)

		* ��Ҫͬ�����߳�����:parties
		* barrierAction �̵߳�������(parties)ʱ,����ִ��barrierAction(��ӵ�,���Ҳ������parties)
	
	# ʵ������
		int await()
			* ��ǰ�̵߳ȴ�
			* ���� parties ���̶߳�����await() ״̬ʱ,���һ����

		int await(long timeout, TimeUnit unit)

		int getNumberWaiting()
			* ��ȡ���� await() ���߳�����

		int getParties()

		boolean isBroken()
	
		void reset()
			* �����Ժ󣬿����ظ�ʹ��
	

------------------------
Demo					|
------------------------
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5,() -> {
			System.out.println("====================����ִ��====================");
		}) ;
		
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		
		for(int x = 0 ; x < 10 ; x++) {
			
			final int numer = x;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			threadPool.execute(() -> {
				try {
					System.out.println("�߳�:" + numer + " await");
					cyclicBarrier.await();
					System.out.println("�߳�:" + numer + " notify");
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}); 
		}
		
		threadPool.shutdown();
	}
}
/**
�߳�:0 await
�߳�:1 await
�߳�:2 await
�߳�:3 await
�߳�:4 await
====================����ִ��====================
�߳�:4 notify
�߳�:0 notify
�߳�:2 notify
�߳�:1 notify
�߳�:3 notify
�߳�:5 await
�߳�:6 await
�߳�:7 await
�߳�:8 await
�߳�:9 await
====================����ִ��====================
�߳�:9 notify
�߳�:5 notify
�߳�:7 notify
�߳�:6 notify
�߳�:8 notify
**/
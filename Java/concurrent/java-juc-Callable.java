------------------------
Callable				|
------------------------
	# ��һ���ӿ�
	# ����ִ���̵߳ķ�ʽ��
	# Դ��
		@FunctionalInterface
		public interface Callable<V> {
			V call() throws Exception;
		}

	# ��ʵ�� Runnable ����
		* �з���ֵ
		* ��һ�����ͽӿ�
		* �׳����쳣
		* ��Ҫ FutureTask(Future�ӿ�ʵ��) ֧��(���ڽ���������)

	
	# ��ʵ�����߳̽�����ʱ��,���Ի�ȡ��һ������ֵ
	# Demo	
		public class Main implements Callable<Integer>{
			@Override
			public Integer call() throws Exception {
				Integer sum = 0;
				for(int x = 0; x < 10; x++){
					sum += x;
				}
				return sum;
		}
		public static void main(String[] args) throws Exception{
			//���� callable ʵ��
			Main main = new Main();
			//���� futuretask
			FutureTask<Integer> futureTask = new FutureTask<Integer>(main);
			//�����߳�
			new Thread(futureTask).start();
			//�õ����,��һֱ����,ֱ������ִ�����
			Integer result = futureTask.get();
			System.out.println(result);
		}
	}

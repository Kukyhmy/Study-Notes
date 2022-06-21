--------------------------
Exchanger
--------------------------
	# �����̼߳�Э���Ĺ����ࡣ
		* ���ڽ����̼߳�����ݽ�����
		* ���ṩһ��ͬ���㣬�����ͬ���㣬�����߳̿��Խ����˴˵����ݡ�
		* �������߳�ͨ��exchange�����������ݣ�
		* �����һ���߳���ִ��exchange()����������һֱ�ȴ��ڶ����߳�Ҳִ��exchange������
		* �������̶߳�����ͬ����ʱ���������߳̾Ϳ��Խ������ݣ������߳��������������ݴ��ݸ��Է���
	
	# ���췽��
		public Exchanger()
	
	# ʵ������
		public V exchange(V x) throws InterruptedException
		public V exchange(V x) throws InterruptedException
		public V exchange(V x, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException 
	

	# Demo
		import java.util.concurrent.Exchanger;
		import java.util.concurrent.TimeUnit;

		public class Main {
			public static void main(String[] args) throws InterruptedException {
				Exchanger<String> exchanger = new Exchanger<>();
				Thread t1 = new Thread(() -> {
					int i = 1;
					while (true) {
						System.out.println("�߳�1��" + i ++);
						try {
							TimeUnit.SECONDS.sleep(1);
							if (i == 3) {
								// �������ȴ����߳�2����
								String value = exchanger.exchange("�����߲�1������");
								System.out.println("�߳�1�յ����߳�2������:" + value);
								break;
							}
						} catch (InterruptedException e) {
						}
					}
				});
				t1.start();
				
				Thread t2 = new Thread(() -> {
					int i = 1;
					while (true) {
						System.out.println("�߳�2��" + i ++);
						try {
							TimeUnit.SECONDS.sleep(1);
							if (i == 2) {
								// �������ȴ����߳�1����
								String value = exchanger.exchange("�����߲�2������");
								System.out.println("�߳�2�յ����߳�1������:" + value);
								break;
							}
						} catch (InterruptedException e) {
						}
					}
				});
				t2.start();
			}
		}
		
		// ----------- ���
		�߳�1��1
		�߳�2��1
		�߳�1��2
		�߳�1�յ����߳�2������:�����߲�2������
		�߳�2�յ����߳�1������:�����߲�1������

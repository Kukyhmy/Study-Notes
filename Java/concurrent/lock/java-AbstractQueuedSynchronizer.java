----------------------------
AbstractQueuedSynchronizer	|
----------------------------
	# �������ͬ����, ��˵�е� AQS, ������
		AbstractQueuedSynchronizer extends AbstractOwnableSynchronizer implements java.io.Serializable

	# ���캯��
		protected AbstractQueuedSynchronizer() { }
	
----------------------------
 CLH����(�߳�ͬ������)		|
----------------------------
	# ���е�Node
		static final class Node {
			static final Node SHARED = new Node();
			static final Node EXCLUSIVE = null;

			static final int CANCELLED =  1;
			static final int SIGNAL    = -1;
			static final int CONDITION = -2;
			static final int PROPAGATE = -3;

			volatile int waitStatus;
				 * ��ʾ�ڵ��״̬
					CANCELLED:	ֵΪ 1, ��ʾ��ǰ���̱߳�ȡ��
					SIGNAL:		ֵΪ-1, ��ʾ��ǰ�ڵ�ĺ�̽ڵ�������߳���Ҫ����, Ҳ����unpark
					CONDITION:	ֵΪ-2, ��ʾ��ǰ�ڵ��ڵȴ�condition, Ҳ������condition������
					PROPAGATE:	ֵΪ-3, ��ʾ��ǰ�����º�����acquireShared�ܹ�����ִ��
					0(��ʼֵ):	��ʾ��ǰ�ڵ���sync������, �ȴ��Ż�ȡ��

			volatile Node prev;
			volatile Node next;
				* ˫�������ǰ��ڵ�

			volatile Thread thread;
				* �����ʱ���߳�

			Node nextWaiter;
				* �洢condition�����еĺ�̽ڵ�

			//�Ƿ�Ϊ����ģʽ
			final boolean isShared() {
				return nextWaiter == SHARED;
			}

			// ����ǰһ���ڵ�
			final Node predecessor() throws NullPointerException {
				Node p = prev;
				if (p == null)
					throw new NullPointerException();
				else
					return p;
			}
			//���ڽ�����ʼͷ��SHARED���
			Node() {}    
			// ʹ����addWaiter������
			Node(Thread thread, Node mode) {
				this.nextWaiter = mode;
				this.thread = thread;
			}
			// ʹ����Condition������
			Node(Thread thread, int waitStatus) {
				this.waitStatus = waitStatus;
				this.thread = thread;
			}
		}

	
		* Node ���԰�����������: next/prev ˫������, �� nextWaiter ��������
	

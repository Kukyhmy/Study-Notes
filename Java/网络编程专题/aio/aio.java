-------------------
AIO					|
-------------------
	# jdk7�Ĳ���
	# �����������첽������IO,ѧϰ���� Linux epoll ģʽ
	# API
		AsynchronousServerSocketChannel
			# ����� Channel
			 public abstract <A> void accept(A attachment,CompletionHandler<AsynchronousSocketChannel,? super A> handler);

		AsynchronousSocketChannel
			# �ͻ��� Channel
			public final <A> void read(ByteBuffer dst,A attachment,CompletionHandler<Integer,? super A> handler)
				* 

		AsynchronousChannelGroup
			# �߳���

		ExecutorService
			# �̳߳�,��

		CompletionHandler<V,A>
			# �ӿ�,�����󷽷�
				void completed(V result, A attachment);

				void failed(Throwable exc, A attachment);
	
	
	# ѧϰ,�ο�����
		https://www.ibm.com/developerworks/cn/java/j-lo-nio2/index.html

-------------------
AIO-Server			|
-------------------
	import java.net.InetSocketAddress;
	import java.nio.channels.AsynchronousChannelGroup;
	import java.nio.channels.AsynchronousServerSocketChannel;
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;
	/**
	 * Created by Kevin on 2017/2/16 20:22.
	 */
	public class AioServer {
		//�̳߳�
		private ExecutorService executorService;

		//�߳���
		private AsynchronousChannelGroup asynchronousChannelGroup;

		//������ͨ��
		private AsynchronousServerSocketChannel asynchronousServerSocketChannel;

		public AioServer(int port){
			try {
				//ʵ�����̳߳�
				executorService = Executors.newCachedThreadPool();
				//ʵ�����߳���
				asynchronousChannelGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService,1);
				//��������ͨ��
				asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open(asynchronousChannelGroup);
				//�󶨱��ض˿�
				asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
				System.out.println("���������,port=" + port);
				//��������
				asynchronousServerSocketChannel.accept(this,new AioServerCompletionHandler());
				//һֱ���� ���÷�����ֹͣ
				Thread.sleep(Integer.MAX_VALUE);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		public AsynchronousServerSocketChannel getAsynchronousServerSocketChannel() {
			return asynchronousServerSocketChannel;
		}

		public void setAsynchronousServerSocketChannel(AsynchronousServerSocketChannel asynchronousServerSocketChannel) {
			this.asynchronousServerSocketChannel = asynchronousServerSocketChannel;
		}
	}

-------------------
AIO-AioServerCompletionHandler|
-------------------
	import java.nio.ByteBuffer;
	import java.nio.channels.AsynchronousSocketChannel;
	import java.nio.channels.CompletionHandler;
	import java.util.concurrent.ExecutionException;

	/**
	 * Created by Kevin on 2017/2/16 20:27.
	 */
	public class AioServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AioServer> {

		/**
		 * ���ӳɹ���ʱ��ִ�еĲ���
		 * @param result
		 * @param attachment
		 */
		@Override
		public void completed(AsynchronousSocketChannel result, AioServer attachment) {
			//������һ���ͻ��˽����ʱ�� ֱ�ӵ���Server��accept��������������ִ����ȥ����֤����ͻ��˶���������
			attachment.getAsynchronousServerSocketChannel().accept(attachment,this);
			read(result);
		}

		private void read(final AsynchronousSocketChannel asynchronousSocketChannel) {
			//����������
			ByteBuffer buf = ByteBuffer.allocate(1024);
			asynchronousSocketChannel.read(buf, buf, new CompletionHandler<Integer, ByteBuffer>() {
				/**
				 * resultSize���Ƕ�ȡ�������ݳ���(�ֽ���)
				 * @param resultSize
				 * @param attachment
				 */
				@Override
				public void completed(Integer resultSize, ByteBuffer attachment) {
					//���ж�ȡ֮��,���ñ�ʶλ
					attachment.flip();
					//��ö�ȡ���ֽ���
					System.out.println("Server -> " + "�յ��ͻ��˵����ݳ���Ϊ:" + resultSize);
					//��ȡ��ȡ������
					String resultData = new String(attachment.array()).trim();
					System.out.println("Server -> " + "�յ��ͻ��˵�������ϢΪ:" + resultData);
					String response = "��������Ӧ, �յ��˿ͻ��˷���������: " + resultData;
					write(asynchronousSocketChannel, response);
				}
				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					exc.printStackTrace();
				}
			});
		}

		private void write(AsynchronousSocketChannel asynchronousSocketChannel, String response) {
			try {
				ByteBuffer buf = ByteBuffer.allocate(1024);
				buf.put(response.getBytes());
				buf.flip();
				asynchronousSocketChannel.write(buf).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		/**
		 * �쳣ʱִ��
		 * @param exc
		 * @param attachment
		 */
		@Override
		public void failed(Throwable exc, AioServer attachment) {
			exc.printStackTrace();
		}
	}


-------------------
AIO-AioClient		|
-------------------
	import java.io.UnsupportedEncodingException;
	import java.net.InetSocketAddress;
	import java.nio.ByteBuffer;
	import java.nio.channels.AsynchronousSocketChannel;
	import java.util.concurrent.ExecutionException;

	/**
	 * Created by Kevin on 2017/2/16 20:38.
	 */
	public class AioClient implements Runnable{
		private AsynchronousSocketChannel asc ;

		public AioClient() throws Exception {
			asc = AsynchronousSocketChannel.open();
		}

		public void connect(){
			asc.connect(new InetSocketAddress("127.0.0.1", 1024));
		}

		public void write(String request){
			try {
				asc.write(ByteBuffer.wrap(request.getBytes())).get();
				read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private void read() {
			ByteBuffer buf = ByteBuffer.allocate(1024);
			try {
				asc.read(buf).get();
				buf.flip();
				byte[] respByte = new byte[buf.remaining()];
				buf.get(respByte);
				System.out.println(new String(respByte,"utf-8").trim());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			while(true){

			}
		}
		public static void main(String[] args) throws Exception {
			AioClient c1 = new AioClient();
			c1.connect();

			AioClient c2 = new AioClient();
			c2.connect();

			AioClient c3 = new AioClient();
			c3.connect();

			new Thread(c1, "c1").start();
			new Thread(c2, "c2").start();
			new Thread(c3, "c3").start();

			Thread.sleep(1000);

			c1.write("c1 aaa");
			c2.write("c2 bbbb");
			c3.write("c3 ccccc");
		}
	}
--------------------------------
Pipe							|
--------------------------------
	# jdk4��ǰ�ܵ�����Ҫͨ�� PipedInputStream, PipedOutputStream �����������ͨ��
	# jdk4�Ժ�, �ṩ�� Pipe, ͨ��������������ͨ��
		* Pipe�߱�һ��sourcechannel��һ��sinkchannel
		* sinkchannel�������ܵ�д������,sourcechannel����ӹܵ���ȡ����
		
		* ǧ����ͬһ���̼߳ȶ���д����Ϊ��ȡ�����������̡߳�ͬһ���̲߳����ܵ���������߳�����
	
	# ����
		//��һ���ܵ�
		Pipe pipe = Pipe.open();
		//�ӹܵ���ȡд�����ݵ�channel
		SinkChannel sinkChannel = pipe.sink();
		//�ӹܵ���ȡ��ȡ���ݵ�channel
		SourceChannel sourceChannel = pipe.source();
	
	# ��ʾdemo
		import java.io.IOException;
		import java.nio.ByteBuffer;
		import java.nio.channels.Pipe;
		import java.nio.channels.Pipe.SinkChannel;
		import java.nio.channels.Pipe.SourceChannel;
		import java.nio.charset.StandardCharsets;
		import java.util.Scanner;
		public class Main {
			public static void main(String[] args) throws Exception {
				//��һ���ܵ�
				Pipe pipe = Pipe.open();
				//�ӹܵ���ȡд�����ݵ�channel
				SinkChannel sinkChannel = pipe.sink();
				//�ӹܵ���ȡ��ȡ���ݵ�channel
				SourceChannel sourceChannel = pipe.source();
				//�������߳�ģ���
				new Thread(() -> {
					try {
						ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
						while(true) {
							//����int����ʾ��ȡ���˶����ֽڵ����ݣ�����ܵ�û�����ݣ��÷���������
							sourceChannel.read(byteBuffer);
							//��ȡ��Ϻ�λ����д��Ϊ��
							byteBuffer.flip();
							byte bytes[] = new byte[byteBuffer.remaining()]; 
							byteBuffer.get(bytes);
							System.out.println(Thread.currentThread().getName() + "-�յ���Ϣ:" + new String(bytes,StandardCharsets.UTF_8));
							//��ջ���������д��Ϊ��
							byteBuffer.clear();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}) .start();
				//��ǰ�߳�ģ��д
				try(Scanner scanner = new Scanner(System.in)){
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
					while(true) {
						String line = scanner.nextLine();
						System.out.println(Thread.currentThread().getName() + "-������Ϣ:" + line);
						byteBuffer.put(line.getBytes(StandardCharsets.UTF_8));
						byteBuffer.flip();
						sinkChannel.write(byteBuffer);
						byteBuffer.clear();
					}
				}
			}
		}
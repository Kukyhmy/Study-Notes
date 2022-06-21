------------------------
Pipe					|
------------------------
	# Java NIO �ܵ���2���߳�֮��ĵ����������ӡ�
	# Pipe��һ��'source'ͨ����һ��'sink'ͨ����
	# ���ݻᱻд��sinkͨ������sourceͨ����ȡ��
	# ԭ��ͼ
						------- Pipe -------
		Thread-A ----> |	sink	source	| ----> Thread-B
						-------------------- 

------------------------
Pipe-д��				|
------------------------
	//�����ܵ�
	Pipe pipe = Pipe.open();
	//��ȡ�ܵ��е� sink ͨ��
	Pipe.SinkChannel sinkChannel = pipe.sink();
	//׼������
	String newData = "New String to write to file..." + System.currentTimeMillis();
	//����������
	ByteBuffer buf = ByteBuffer.allocate(48);
	//��ջ�����
	buf.clear();
	//�������
	buf.put(newData.getBytes());
	//��λ,��ΪҪ׼����ȡ���������������д�뵽�ܵ�
	buf.flip();
	//��ȡ������������д�뵽�ܵ�
	while(buf.hasRemaining()) {
		sinkChannel.write(buf);
	}

------------------------
Pipe-��ȡ				|
------------------------
	//�����ܵ�
	Pipe pipe = Pipe.open();
	//�ӹܵ���ȡ source ͨ��
	Pipe.SourceChannel sourceChannel = pipe.source();
	//����������
	ByteBuffer buf = ByteBuffer.allocate(48);
	//�ѹܵ�������д�뻺����,���ض�ȡ�����ֽڳ���
	int bytesRead = sourceChannel.read(buf);


------------------------
Pipe-API				|
------------------------


------------------------
Pipe-Demo				|
------------------------

import java.nio.channels.Pipe; 
import java.nio.ByteBuffer;
import java.util.Scanner;
/**
	ͨ��Demo
*/
public class Demo{
	public static void main(String[] args)throws Exception{
		//��ͨ��
		Pipe pipe = Pipe.open();
		//�����߳�д��
		new Thread(){
			public void run(){
				try{
					//��ͨ����ȡ sikin �ܵ�
					Pipe.SinkChannel sinkChannel = pipe.sink();
					Scanner scanner = new Scanner(System.in);
					String data = null;
					while(true){
						data = scanner.next();
						//����Buffer
						ByteBuffer buf = ByteBuffer.allocate(1024);
						buf.clear();
						buf.put(data.getBytes());
						buf.flip();
						while(buf.hasRemaining()) {
							sinkChannel.write(buf);
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}.start();

		//�����̶߳�ȡ
		new Thread(){
			public void run(){
				try{
					//��ͨ����ȡ source �ܵ�
					Pipe.SourceChannel sourceChannel = pipe.source();
					//����������
					ByteBuffer buf = ByteBuffer.allocate(1024);
					int len = 0;
					while((len = sourceChannel.read(buf)) != -1){
						buf.flip();
						while(buf.hasRemaining()){
							System.out.print((char)buf.get());
						}
						System.out.println();
						buf.clear();
						len = sourceChannel.read(buf);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}.start();
	}
}
	

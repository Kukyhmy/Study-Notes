
----------------------------
�㿽��						|
----------------------------
	# �ڲ���ϵͳ֧�ֵ������,ͨ���÷����������ݲ�����Ҫ��Դ���ݴ��ں�̬�������û�̬,�ٴ��û�̬������Ŀ��ͨ�����ں�̬
	# ͬʱҲ�����������û�̬���ں�̬����������л�,Ҳ��ʹ����"�㿽��"

----------------------------
�ļ���������㿽��			|
----------------------------
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NIOClient {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("192.168.0.2",1234));
		
		// ���io
		RandomAccessFile randomAccessFile = new RandomAccessFile(NIOClient.class.getClassLoader().getResource("test.txt").getFile(),"rw");
		
		// �ļ�channel
		FileChannel fileChannel = randomAccessFile.getChannel();
		// ���ļ�channleֱ�����������channle
		fileChannel.transferTo(0, fileChannel.size(), socketChannel);
		
		// ��Դ�ر�
		fileChannel.close();
		randomAccessFile.close();
		socketChannel.close();
	}
}
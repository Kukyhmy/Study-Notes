------------------------
udp �㲥				|
------------------------
	# �����нڵ㷢����Ϣ
		* ������˵�������е��豸���͹㲥����
		* ���ǻᱻ·��������,����ֻ�ܶԾ�����������豸���й㲥
	

	# ���޹㲥��ַ: 255.255.255.255
	# C���㲥��ַһ����:xxx.xxx.xxx.255 (192.168.1.255)
	
	# �㲥��ַ������
		ip			192.168.127.7
			
		��������	255.255.255.0

		�����ַ	192.168.124.0
		
		�㲥��ַ	192.168.124.255
	

------------------------
udp �㲥				|
------------------------
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Broadcast {
	public static void main(String[] args) throws Exception {
		
		try(DatagramSocket datagramSocket = new DatagramSocket()){
			byte[] buffer = "Hello".getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(buffer, 0,buffer.length);
			// ���ù㲥��ַ
			datagramPacket.setAddress(InetAddress.getByName("255.255.255.255"));
			// ���ö˿�
			datagramPacket.setPort(1024);
			// ���͹㲥��Ϣ
			datagramSocket.send(datagramPacket);
		}
	}
}
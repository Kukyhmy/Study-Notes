------------------------
udp ����				|
------------------------
	# ��Ե�
		* �ͻ��˷������ݵĶ˿�,��ʵ���ǽ��ܷ������Ӧ�Ķ˿�
	

	
------------------------
Server					|
------------------------

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Server {
	public static void main(String[] args) throws Exception {

		try (DatagramSocket datagramSocket = new DatagramSocket(1024)) {

			while (true) {
					
				// ��ȡ�ͻ�������
				byte[] buffer = new byte[1024];
				DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
 				datagramSocket.receive(datagramPacket);

				// �����յ��Ŀͻ�������
				String ip = datagramPacket.getAddress().getHostAddress();
				String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
				int port = datagramPacket.getPort();

				System.out.println("recv: ip=" + ip + ",port=" + port + ",data=" + data);

				// ��Ӧ�ͻ���
				buffer = data.toUpperCase().getBytes();
				datagramSocket.send(new DatagramPacket(buffer, 0, buffer.length, new InetSocketAddress(ip, port)));
			}
		}
	}
}

------------------------
client					|
------------------------


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client {
	public static void main(String[] args) throws Exception {
		
		try(DatagramSocket datagramSocket = new DatagramSocket()){
			
			// ������˷�������
			byte[] data = "Hello".getBytes();
			datagramSocket.send(new DatagramPacket(data, 0, data.length, new InetSocketAddress("127.0.0.1", 1024)));
			
			// ��ȡ�������Ӧ������
			byte[] buffer = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length);
			datagramSocket.receive(datagramPacket);
			System.out.println("recv:" + new String(datagramPacket.getData(),0,datagramPacket.getLength()));
		}
	}
}

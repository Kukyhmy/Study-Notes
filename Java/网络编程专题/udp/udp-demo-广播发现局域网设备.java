
------------------------------
���������豸����			  |
------------------------------
	# Ҫ�������豸������һ��UDP�˿�,�����㲥��Ϣ
	# �յ��㲥��Ϣ��,����Ϣ�����ȡ����������ip,�˿ڵ���Ϣ
	# ��������������������豸id,ip,�ṩ�ķ���(Э������),�˿ڵȵ���Ϣ

------------------------------
ɨ��						  |
------------------------------

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Scanner {
	
	// �ڵ�����
	private static class Endpoint {
		private String id;
		private int port;
		private String ip;
		public Endpoint(String id, int port, String ip) {
			super();
			this.id = id;
			this.port = port;
			this.ip = ip;
		}
		@Override
		public String toString() {
			return "Endpoint [id=" + id + ", port=" + port + ", ip=" + ip + "]";
		}
	}
	
	// ��������
	private static class Listenner implements Runnable  {
		private int port;
		private CountDownLatch countDownLatch;
		private volatile boolean done;
		private List<Endpoint> endpoints;
		public Listenner(int port,CountDownLatch countDownLatch) {
			this.port = port;
			this.countDownLatch = countDownLatch;
			this.done = false;
			this.endpoints = new LinkedList<>();
		}

		@Override
		public void run() {
			DatagramSocket datagramSocket = null;
			try {
				
				this.countDownLatch.countDown();
				
				datagramSocket = new DatagramSocket(null);
				datagramSocket.setReuseAddress(true);
				datagramSocket.bind(new InetSocketAddress("0.0.0.0", this.port));
				
				while(!this.done) {
					byte[] data = new byte[1024];
					DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
					datagramSocket.receive(datagramPacket);
					String[] response = new String(datagramPacket.getData(),0,datagramPacket.getLength()).split(":");
					this.endpoints.add(new Endpoint(response[0], Integer.parseInt(response[1]),datagramPacket.getAddress().getHostAddress()));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(datagramSocket != null) {
					datagramSocket.close();
				}
			}
		}
		
		public List<Endpoint> endpoints(){
			this.done = true;
			return this.endpoints;
		}
	}
	
	public static void broadcast(int port,byte[] data) {
		
		DatagramSocket datagramSocket = null;
		try {
			
			datagramSocket = new DatagramSocket();
			
			DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
			datagramPacket.setAddress(InetAddress.getByName("255.255.255.255"));
			datagramPacket.setPort(port);
			
			datagramSocket.send(datagramPacket);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(datagramSocket != null) {
				datagramSocket.close();
			}
		}
	}
	
	public static void main(String[] args) throws Exception{

		// ��������
		int port = 10086;
		CountDownLatch countDownLatch = new CountDownLatch(1);
		
		Listenner listenner = new Listenner(port, countDownLatch);
		Thread thread = new Thread(listenner);
		thread.setDaemon(true);		// �ػ��߳�
		thread.start();
		
		countDownLatch.await();

		// �㲥��Ϣ
		byte[] data = ("port=" + port).getBytes();
		broadcast(1024, data);
		
		System.in.read();	
		
		// ��ȡ�㲥�����Ӧ
		List<Endpoint> endpoints = listenner.endpoints();
		for(Endpoint endpoint : endpoints) {
			System.out.println(endpoint);
		}
	}
}





------------------------------
�����						  |
------------------------------
import socket

id = '0xFF'
port = 1024

server = socket.socket(family=socket.AF_INET, type=socket.SOCK_DGRAM)
server.bind(('0.0.0.0', port))

while True:
    data, client = server.recvfrom(1024)
    
    print('�յ�����:%s %s'%(data,client))
    
    # �������л�ȡ���������Ķ˿�
    serverPort = int(data.decode().split('=')[1])
    response = socket.socket(family=socket.AF_INET, type=socket.SOCK_DGRAM)
    # �����˱����Լ���id���ṩ����Ķ˿�
    response.sendto((id + ':' + str(port)).encode(),(client[0],serverPort))
    
    



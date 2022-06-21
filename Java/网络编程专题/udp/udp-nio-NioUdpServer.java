----------------------------
�� selector					|
----------------------------
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class NioUdpServer {

    public static void main(String[] args) throws Exception {

        try(DatagramChannel datagramChannel = DatagramChannel.open()){

            datagramChannel.bind(new InetSocketAddress(1024));
            // һЩsocket��ѡ��
            datagramChannel.setOption(StandardSocketOptions.SO_REUSEADDR, Boolean.TRUE);

            // Ԥ���建����
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(65507);

            // ������������
            while (true){
                // �ͻ��˵�ַ��Ϣ
                InetSocketAddress inetSocketAddress = (InetSocketAddress) datagramChannel.receive(byteBuffer);
                String hostName = inetSocketAddress.getHostName();
                int port = inetSocketAddress.getPort();
                String hostString = inetSocketAddress.getHostString();
                System.out.println(hostName + "[" + hostString +"]:" + port);

                // ������Ϣ
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.remaining()];
                byteBuffer.get(bytes);
                byteBuffer.clear();
                System.out.println(new String(bytes, StandardCharsets.UTF_8));

				
				// ���ͻ��˻�д����
				datagramChannel.send(ByteBuffer.wrap("Hello".getBytes()), inetSocketAddress);
            }
        }
    }
}


----------------------------
selector					|
----------------------------
	# udp��selectorֻ��һ������, ������������ѯn���ͻ���/�����
		* udpû������, ����Ҫȥ����״̬, Ҳ�����������ȴ����ݵ����
		* ���ֻ��һ���ͻ���/�����, ��ôʹ�ô�ͳ��:DatagramSocket û����

import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class NioUdpServer {

    public static void main(String[] args) throws Exception {

        Selector selector = Selector.open();
        DatagramChannel datagramChannel = DatagramChannel.open();

        try{
            datagramChannel.bind(new InetSocketAddress(1024));

            // ������ģʽ
            datagramChannel.configureBlocking(false);
            // һЩsocket��ѡ��
            datagramChannel.setOption(StandardSocketOptions.SO_REUSEADDR, Boolean.TRUE);

            datagramChannel.register(selector, SelectionKey.OP_READ);

            // Ԥ���建����
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(65507);

            while (selector.select() > 0){
                Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
                while (selectionKeyIterator.hasNext()){// ���¼�
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    try{
                        if(selectionKey.isReadable()){

                            DatagramChannel channel = (DatagramChannel) selectionKey.channel();

                            // �ͻ��˵�ַ��Ϣ
                            InetSocketAddress inetSocketAddress = (InetSocketAddress) channel.receive(byteBuffer);
                            String hostName = inetSocketAddress.getHostName();
                            int port = inetSocketAddress.getPort();
                            String hostString = inetSocketAddress.getHostString();
                            System.out.println(hostName + "[" + hostString +"]:" + port);

                            // ������Ϣ
                            byteBuffer.flip();
                            byte[] bytes = new byte[byteBuffer.remaining()];
                            byteBuffer.get(bytes);
                            byteBuffer.clear();
                            System.out.println(new String(bytes, StandardCharsets.UTF_8));

                        }else if(selectionKey.isWritable()){
                        }else if(selectionKey.isAcceptable()){
                        }else if(selectionKey.isConnectable()){
                        }else{ }
                    }finally {
                        selectionKeyIterator.remove();
                    }
                }
            }

        }finally {
            selector.close();
            datagramChannel.close();
        }
    }
}

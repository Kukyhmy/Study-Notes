
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class NioClient {
    public static void main(String[] args) throws Exception{

        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.setOption(StandardSocketOptions.SO_REUSEADDR, Boolean.TRUE);
        // �󶨷��Ͷ˿�
        datagramChannel.bind(new InetSocketAddress(7725));


        ByteBuffer byteBuffer = ByteBuffer.allocate(65507);
        byteBuffer.put("Nio UDP".getBytes(StandardCharsets.UTF_8));
        byteBuffer.flip();

        // �����Ѿ��ɹ����͵��ֽ�����, ����һ����û�������
        int count = datagramChannel.send(byteBuffer, new InetSocketAddress("127.0.0.1", 1024));

        System.out.println(count);
    }
}

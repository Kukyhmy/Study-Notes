import java.io.IOException;
import java.net.*;
/*-------------------------���Ͷ�
 *ͨ��UDP���䷽ʽ����һ���������ݷ��ͳ�ȥ��
 *1���Ƚ���udpsocket����
 *2���ṩ���ݲ������ݷ�װ�����ݰ���
 *3��ͨ�� socket ����ķ��͹��ܣ������ݷ��ͳ�ȥ
 *4���ر���Դ
 */
public class Send
{
	public static void main(String[] args) throws IOException
	{
		//����udp����,ͨ�� DatagramSocet����
		DatagramSocket ds = new DatagramSocket(8888);
		//ȷ�����ݣ�����װ�����ݰ�
		byte[] buf = "KevinBlandy".getBytes();//String.getBytes();���ַ���ת�����ֽ����顣
		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.132.245"),10000);
		//ͨ��socket�������е����ݰ�ͨ�� send���������ͳ�ȥ��
		ds.send(dp);//����ʽ���������û���ݾͻ�һֱ��(�̻߳���)��
		//�ر���Դ
		ds.close();
	}
}



















































































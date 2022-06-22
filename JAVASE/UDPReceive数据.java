import java.net.*;
import java.io.IOException;
/*------------------���ն�.
 * 	      ������ն˵�ʱ��ͨ���������һ���˿ڡ���ʵ���Ǹ������������Ӧ�ó��������ֱ�ʾ��
 * 	      ��������ȷ��Щ���ݹ�����Ӧ�ó�����
 *
 * 1������udpsocket����
 * 2������һ�����ݰ�����ΪҪ�洢���յ����ֽ����ݡ���Ϊ���ݰ��������и��๦�ܿ�����ȡ�ֽ������еĲ�ͬ������Ϣ��
 * 3��ͨ��socket�����receive�������յ������ݴ����Ѷ���õ����ݰ��У�
 * 4��ͨ�����ݰ���������й��ܣ�����Щ��ͬ������ȡ������ӡ�ڿ���̨�ϡ�
 * 5���ر���Դ��
 */
public class Receive
{
	public static void main(String[] args)throws IOException
	{
		//����udpsocket����.�����˵�
		DatagramSocket ds = new DatagramSocket(10000);
		while(true)
		{
			//�������ݰ������ڴ洢����
			byte[] buf = new byte[1024];//������
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			//ͨ��socket����receive�������յ������ݴ������ݰ���
			ds.receive(dp);
			//ͨ�����ݰ��ķ�����ȡ���е�����
			String ip = dp.getAddress().getHostAddress();//��ȡIP��
			String data = new String(dp.getData(),0,dp.getLength());//��ȡ���ݡ�
			int port = dp.getPort();//��ȡ�˿ڡ�
			System.out.println(ip+"::"+data+"::"+port);
			//�ر���Դ
			//ds.close();
		}
		//ds.close();
	}
}


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ��֤�������
 * ��Ҫ�õ�����
 * Image ImageIO BufferedImage Icon ImageIncon
 * */
public class Demo
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		//�õ�ͼƬ������(���,�߶ȣ�ͼƬ��ʽ)
		BufferedImage bi = new BufferedImage(150,70,BufferedImage.TYPE_INT_BGR);
		//�õ����ƻ���(�õ���ͼƬ�ı�)
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		//���û��ƻ�����ɫ(��ɫ)
		g2.setColor(Color.WHITE);
		//��������ʹ�С(���������ͼƬ,��ʵ�������ñ���ɫ)
		g2.fillRect(0, 0, 150,70);
		g2.setColor(Color.RED);
		g2.drawRect(0, 0, 150-1, 70-1);
		//���������ʽ����С��
		g2.setFont(new Font("����",Font.BOLD,18));
		//������ɫ
		g2.setColor(Color.BLACK);
		//��ͼƬ��д�ַ�����
		g2.drawString("KevinBlandy",3,40);
		//����ͼƬ--imagerIo
		ImageIO.write(bi, "JPEG", new FileOutputStream("D:/a.jpg"));
	}
}
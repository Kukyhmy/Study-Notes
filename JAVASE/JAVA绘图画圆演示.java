/*
	JAVA��ͼ����
*/
import java.awt.*;
import javax.swing.*;
public class Demo extends JFrame
{
	MyJpanel mp = null;
	public static void main(String[] args)
	{
		Demo d = new Demo();
	}
	public Demo()
	{
		mp = new MyJpanel();
		this.add(mp);
		this.setBounds(400,300,400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
//����һ������ࡣ�̳�JPnel�����ڻ�ͼ����ʾ��ͼ������
class MyJpanel extends JPanel
{
	//��дJPanel�����һ���Ƚ���Ҫ�ķ���--paint
	//Graphice �ǻ�ͼ����Ҫ�ࡣ��������һ֧���ʡ�
	public void paint(Graphics g)
	{
		 //���ø��ຯ����ɳ�ʼ��
		 super.paint(g);//��仰�����١�
		 System.out.println("������");
//		 //��ԲȦ��
//		 g.drawOval(10,10,30,30);
//		 //��ֱ��
//		 g.drawLine(20,20,40,40);
//		 //�����α߿�
//		 g.drawRect(30, 30, 40, 40);
//		 //��������
//		 g.setColor(Color.BLUE);//���������ɫ
//		 g.fillRect(50, 50, 40, 60);
		 //��ͼƬ
//		 Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/3.jpg"));
//		 g.drawImage(im, 0, 0, 1024, 738,this);
		 //����ͬ������
		 g.setColor(Color.green);//����������ɫ
		 g.setFont(new Font("���Ĳ���",Font.BOLD,30));//���������������ʽ����ϸ����С
		 g.drawString("�������Ц", 50, 50);
	}
}
/*
 *BorderLayout(�߽粼��)��ʾ
 *1���̳�JFrame
 *2,������Ҫ�����
 *3���ڹ��캯���С���ʼ�����
 *4��������
 *5,�Դ��壨���������������Խ������á�
 *6����ʾ���塣setVisible(true);
 *---------ע������------------
 *1,����������ֶ�������ӡ�
 *2���в�������Զ����ڴ�С��
 *3,JFrame,JDialogĬ�ϲ��ֹ���������BorderLayout��
 * */
import java.awt.*;
import javax.swing.*;
public class Demo extends JFrame
{
	//�������
	JButton jb1,jb2,jb3,jb4,jb5;//���������JButton��ť��
	public static void main(String[] args)
	{
		Demo d = new Demo();
	}
	Demo()
	{
		//�����齨
		jb1 = new JButton("��");
		jb2 = new JButton("��");
		jb3 = new JButton("��");
		jb4 = new JButton("��");
		jb5 = new JButton("��");
		//������
		this.add(jb1,BorderLayout.CENTER);
		this.add(jb2,BorderLayout.NORTH);
		this.add(jb3,BorderLayout.EAST);
		this.add(jb4,BorderLayout.SOUTH);
		this.add(jb5,BorderLayout.WEST);
		this.setTitle("�߽粼����ʾ");//����������ı���
		this.setBounds(200, 300, 400, 200);//��ʼ��������Ĵ�С���Լ���ʼ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����������˳���JVM��֮�˳�
		this.setVisible(true);//�ô�����ʾ��
	}
}

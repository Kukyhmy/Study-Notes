import java.awt.*;

import javax.swing.*;
public class  Demo extends JFrame
{
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JTextField jt;
	JPasswordField jp;
	JButton jb1,jb2;
	public static void main(String[] args)
	{
		Demo d = new Demo();
	}
	public Demo()
	{
		jp1 = new JPanel(new FlowLayout());
		jp2 = new JPanel(new FlowLayout());
		jp3 = new JPanel(new GridLayout(1,2,10,10));
		
		jlb1 = new JLabel("�û���");//Lable��ǩ
		jlb2 = new JLabel("��   ��");
		
		jt = new JTextField(10);//�ı���ֻ�ܷ���10���ַ�
		jp = new JPasswordField(10);//�����
		
		jb1 = new JButton("��¼");//��ť
		jb2 = new JButton("�˳�");
		//���ò��ֹ���
		this.setLayout(new GridLayout(3,1));
		//����������
		jp1.add(jlb1);
		jp1.add(jt);
		jp2.add(jlb2);
		jp2.add(jp);
		jp3.add(jb1);
		jp3.add(jb2);
		//���뵽JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		//��������������
		this.setTitle("��¼ϵͳ");
		this.setBounds(400,200 , 300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
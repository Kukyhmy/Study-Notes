/*
	���¼��������
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Demo extends JFrame implements ActionListener
{
	//��һ��һ��panel
	JPanel mp = null;
	JButton jb1 = null;
	JButton jb2 = null;
	public static void main(String[] args)
	{
		Demo d = new Demo();
	}
	Demo()
	{
		mp = new JPanel();
		jb1 = new JButton("��ɫ");
		//ָ��action����
		jb1.setActionCommand("��ɫ");
		jb2 = new JButton("��ɫ");
		jb2.setActionCommand("��ɫ");

		this.add(jb1,BorderLayout.NORTH);
		//mp.setBackground(Color.BLACK);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		//ע�����
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		this.setBounds(400,300,200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	//���¼�����ķ���
	public void actionPerformed(ActionEvent e)
	{
		//�ж����ĸ���ť�����
		if (e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("��ɫ��ť");
			mp.setBackground(Color.BLACK);
		}
		else if (e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("��ɫ��ť");
			mp.setBackground(Color.RED);
		}
	}
}
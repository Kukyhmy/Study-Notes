import java.awt.*;
import javax.swing.*;
public class Demo extends JFrame
{
	//�����齨
	JSplitPane jsp;
	JList jlist;
	JLabel jl1;
	public static void main(String[] args)
	{
		Demo d = new Demo();
	}
	Demo()
	{
		//�����齨
		String[] words = {"Kevin","tony","Rocco","Litch","Lenka"};
		jlist = new JList(words);
		jl1 = new JLabel(new ImageIcon("images/2.jpg"));
		//����һ����ִ���Ķ��󡣲����б��ʾ��ˮƽ��֣������Ǳ��齨��
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,jl1);
		//���ò��ֹ���������ΪĬ�ϲ��־�����������Ҫ�Ĳ��֡����Բ�������
		jsp.setOneTouchExpandable(true);
		//����齨
		this.add(jsp);
		this.setBounds(400,200,300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	//	this.setResizable(false);
	}
}
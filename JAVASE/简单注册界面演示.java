import java.awt.*;
import javax.swing.*;
class  Demo extends JFrame
{
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	JCheckBox jcb1,jcb2,jcb3;
	JRadioButton jrb1,jrb2;
	ButtonGroup bg;
	public static void main(String[] args) 
	{
		Demo d = new Demo();
	}
	Demo()
	{
		//��������
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		//����Label
		jlb1 = new JLabel("�ó�");
		jlb2 = new JLabel("�Ա�");
		//������ť
		jb1 = new JButton("ע��");
		jb2 = new JButton("�˳�");
		//������ѡ��
		jcb1 = new JCheckBox("JAVA");
		jcb2 = new JCheckBox("C++");
		jcb3 = new JCheckBox("C");
		//������ѡ��(��ѡ��Ҫ����ButtonGroup����)
		jrb1 = new JRadioButton("��");
		jrb2 = new JRadioButton("Ů");
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		//���ò��ֹ���
		this.setLayout(new GridLayout(3,1));
		//������
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		jp2.add(jlb2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		jp3.add(jb1);
		jp3.add(jb2);
		//��ӵ�������
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		//��������������
		this.setTitle("ע��ҳ��");
		this.setBounds(300,200,300,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

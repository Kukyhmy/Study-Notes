import java.awt.*;
import javax.swing.*;
public class Demo extends JFrame
{
	JTextArea jta;//�����ı����齨
	JPanel jp;//����
	JComboBox jcb;//������
	JTextField jtf;//�ı���
	JButton jb;//��ť
	JScrollPane jsc;//������
	public static void main(String[] args)
	{
		Demo d = new Demo();
	}
	Demo()
	{
		jta = new JTextArea();
		jta.append("���Կ��Ĳ�����-2015��9��13�� 13:26:01");
		jsc = new JScrollPane(jta);//���������������Ұ��ı�����Ϊ��������μ�ȥ��ȥ��
		jp = new JPanel();
		String[] s = {"Kevin","Rocco","Lenka","Licth"};
		jcb = new JComboBox(s);
		jtf = new JTextField(10);
		jb = new JButton("��ť");
		//���ò���
		//����齨
		jp.add(jcb);
		jp.add(jtf);
		jp.add(jb);
		this.add(jsc);//�ѹ������ӽ�ȥ����Ϊ�������Ѿ����ι��˶����ı����ࡣ
		//��������ӵ���������ȥ������ָ�������ڱ߽粼���е�λ��
		this.add(jp,BorderLayout.SOUTH);
		//��������������
		this.setBounds(400,300,300,300);
		//���ı�����ͼ��
		this.setIconImage(new ImageIcon("Images/2.jpg").getImage());
		this.setTitle("������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
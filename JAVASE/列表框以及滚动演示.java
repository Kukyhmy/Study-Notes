import java.awt.*;
import javax.swing.*;
public class Demo extends JFrame
{
	//�������
	JPanel jp1,jp2;
	JLabel jlb1,jlb2;
	JComboBox jcb;
	JList jlist;
	JScrollPane jsp;
	public static void main(String[] args)
	{
		Demo d = new Demo();
	}
	public Demo()
	{
		// ��������
		jp1 = new JPanel();
		jp2 = new JPanel();
		//����Label��ǩ
		jlb1 = new JLabel("����");
		jlb2 = new JLabel("��פ");
		//���������� !!!ע�ⴴ��ʽ
		String[] jg = {"����","����","�Ϻ�","���"};
		jcb = new JComboBox(jg);
		//�����б�����
		String[] dd = {"�������","�ʹ�","��������","��������","̩��","����"};
		jlist = new JList(dd);
		//�����б��չʾ�ĸ���
		jlist.setVisibleRowCount(3);
		//����Ҫ������չʾ���б���������ӵ�����������С�
		jsp = new JScrollPane(jlist);
		//��ӵ����������ò��� 
		this.setLayout(new GridLayout(3,1));
		jp1.add(jlb1);
		jp1.add(jcb);
		jp2.add(jlb2);
		jp2.add(jsp);
		this.add(jp1);
		this.add(jp2);
		//����������Ĵ�С��
		this.setTitle("ע��ҳ��");
		this.setBounds(300,200,300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
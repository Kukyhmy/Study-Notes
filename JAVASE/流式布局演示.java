/*
 * ��ʽ������ʾ
 * FlowLayout��ʾ
 *1���̳�JFrame
 *2,������Ҫ�����
 *3���ڹ��캯���С���ʼ�����
 *4��������
 *5,�Դ��壨���������������Խ������á�
 *6����ʾ���塣setVisible(true);
 *-------ע��----------
 *��ʽ���������Ĭ�����м���롣����ͨ��FlowLayout(intalign);���ı�
 *��������������������С��������������Ѵ�С.
 *������������ʱ�������λ�ÿ��ܱ仯��������Ĵ�С���䡣
 *
 * */
import java.awt.*;
import javax.swing.*;
public class Demo extends JFrame
{
	//������Ҫ�����
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String[] args)
	{
		Demo d = new Demo();
	}
	Demo()
	{
		//�������
		jb1 = new JButton("Kevin");
	//	jb1.setSize(500,500);
		jb2 = new JButton("Tony");
		jb3 = new JButton("Litch");
		jb4 = new JButton("Lenka");
		jb5 = new JButton("Rocco");
		jb6 = new JButton("Celedy");
		//������
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
		//���ô�������
		this.setTitle("��ʽ������ʾ");
		this.setBounds(400, 300, 450, 300);//��ʼ�������С�Լ���ʼ����������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô����˳�JVM��֮�˳���
		//��ʾ����
		this.setVisible(true);
		//���ò��ָ�ʽΪ-��ʽ����(Ĭ�����ж��룬�������õ������)
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		//��ֹ�û��ı䴰���С
		this.setResizable(false);
	}
}





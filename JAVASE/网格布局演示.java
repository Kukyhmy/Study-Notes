/*
 * ���񲼾���ʾ
 * 		�������ֳ��ж���У��С��������䵽ÿ�������С�(������)
 * GrildLayout������ʾ
 *1���̳�JFrame
 *2,������Ҫ�����
 *3���ڹ��캯���С���ʼ�����
 *4��������
 *5,�Դ��壨���������������Խ������á�
 *6����ʾ���塣setVisible(true); 
 *-------ע��--------
 *1����������λ�ò����������������Ŷ��仯�����Ǵ�С�ᷢ���仯��
 *2����������Ĵ�С��ͬ��
 *3������ͨ�����캯�� GridLayout(rows,cols,hgap,vgap);�������������������Լ��м�϶����м�϶��
 * */
import java.awt.*;

import javax.swing.*;
public class Demo extends JFrame
{
	//�������������洢��Ҫ�����
	JButton[] jbs = new JButton[9];
	int size = 9;//�������鳤�ȡ�Ҳ���Ǵ洢�İ�ť����
	public static void main(String[] args)
	{
		Demo d = new Demo();
	}
	public Demo()
	{
		//�����������forѭ������ʼ�����ǡ�
		for(int x = 0;x < size;x++)
		{
			jbs[x] = new JButton(String.valueOf(x));
		}
		//�������񲼾�.��������������������������Լ��м�࣬���м��
		this.setLayout(new GridLayout(3,3,10,10));
		//������
		for(int x = 0;x < size ;x++)
		{
			this.add(jbs[x]);
		}
		//���ô�������
		this.setTitle("���񲼾���ʾ");//���ô������
		this.setBounds(300, 400, 600, 600);//��ʼ����С���Լ���ʼ������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرմ���JVM��֮�˳�
		this.setResizable(false);//��ֹ�û����Ŵ���(�ı䴰���С)
		this.setVisible(true);//��ʾ����
	}
}

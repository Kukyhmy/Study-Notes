import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Demo 
{
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;
	private Dialog d;
	private Label lab;
	private Button okbut;
	Demo()
	{
		init();
	}
	public void init()
	{
		f = new Frame("������Kevin 2015.9.7");
		f.setBounds(300,200,600,500);
		f.setLayout(new FlowLayout());
		tf = new TextField(30);
		but = new Button("ת��");
		ta = new TextArea(15,40);
		d = new Dialog(f,"Ϲ��ɶ��",true);
		d.setBounds(350,250,240,150);
		d.setLayout(new FlowLayout());
		lab = new Label();
		okbut = new Button("������/���ո񣬸Ͻ���");
		d.add(lab);
		d.add(okbut);
		f.add(tf);
		f.add(but);
		f.add(ta);
		myEvent();
		f.setVisible(true);
	}
	private void myEvent()
	{
		okbut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d.setVisible(false);
			}
		});
		d.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				d.setVisible(false);
			}
		});
		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					showDir();
				}
			}
		});
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showDir();
			}
		});
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	private void showDir()
	{
		String dirpath = tf.getText();
		File dir = new File(dirpath);
		if(dir.exists() && dir.isDirectory())
		{
			ta.setText("");
			String[] names = dir.list();
			for (String name : names)
			{
				ta.append(name+"\r\n");
			}
		}
		else
		{
			String info = "�������"+dirpath+"����ļ��е�ַ��";
			lab.setText(info);
			d.setVisible(true);
		}
	}
	public static void main(String[] args)
	{
		new Demo();
	}
}
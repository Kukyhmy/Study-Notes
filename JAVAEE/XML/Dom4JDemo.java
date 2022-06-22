import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 * ʹ��Dom4j����xml��ʾ
 * */
public class Dom4jDemo 
{
	private static File file = new File("D:\\Demo.xml");
	public static void main(String[] args) throws Exception
	{
//		serch();
//		getFirst();
//		getLast();
//		add();
//		delete();
		getProp();
	}
	/**
	 * ��ѯ����ָ��Ԫ���е�ֵ(����nameԪ�ص�ֵ)
	 * */
	public static void serch()throws Exception
	{
		//1,����������
		SAXReader reader = new SAXReader();
		//2,�����ı�
		Document document = reader.read(file);
		//3,�õ����ڵ�
		Element ele = document.getRootElement();
		//4,�õ����е�ָ�����Ƶı�ǩ
		List<Element> list = ele.elements("p");
		//5,�������еı�ǩ
		for(Element e : list)
		{
			//��ȡ��ǩ�µ�ָ�����Ƶı�ǩ�ٴν��б���
			List<Element> l = e.elements("name");
			for(Element ee : l)
			{
				System.out.println(ee.getText());
			}
		}
	}
	/**
	 * ��ȡָ��Ԫ�صĵ�һ��ֵ(name)
	 * */
	public static void getFirst()throws Exception
	{
		//1,����������
		SAXReader reader = new SAXReader();
		//2,�����ı�����
		Document document = reader.read(file);
		//3,��ȡ��Ԫ��
		Element root = document.getRootElement();
		//3,��ȡ��һ��nameԪ�صĸ��ڵ�
		Element ele = root.element("p");
		//4,��ȡ��һ��nameԪ��
		Element name = ele.element("name");
		//5,��ȡ��һ��nameԪ�ص�ֵ
		System.out.println(name.getText());
	}
	/**
	 * ��ȡָ��Ԫ�ص����һ��ֵ(name)
	 * */
	public static void getLast()throws Exception
	{
		//1,��������������
		SAXReader reader = new SAXReader();
		//2,����xml�ļ�
		Document document = reader.read(file);
		//3,��ȡ���ڵ� 
		Element root = document.getRootElement();
		//3,�Ķ����е�p�ڵ�
		List<Element> list = root.elements("p");
		//3,��ȡ���һ��p�ڵ�
		Element ele = list.get(list.size()-1);
		//,��ȡ���һ��p�ڵ��,name�ڵ�
		Element  name = ele.element("name");
		//3,��ȡ���һ��name�ڵ��ֵ
		System.out.println(name.getText());
	}
	/**
	 * ��ӽڵ����(���һ��gender��ǩ)
	 * */
	public static void add()throws Exception
	{
		//ǰ�漸���趼һ��.ʡ��ע����
		Document document = new SAXReader().read(file);
		//��ȡ���ڵ�
		Element element = document.getRootElement();
		//��ȡҪ��ӵĽڵ����,,Ҳ���ǵڶ���p�ڵ�
		Element ele = (Element) element.elements("p").get(1);
		//���һ������gender���ӱ�ǩ
		Element newEle = ele.addElement("gender");
		//Ϊ�±�ǩ����ı�
		newEle.setText("��");
		/**ע��,��д������,��ɾ����һ��Ҫ�ǵû�д**/
		//�����ı���ʽ,��������
		OutputFormat format = OutputFormat.createPrettyPrint();
		//������д�����
		XMLWriter wr = new XMLWriter(new FileOutputStream(file),format);
		//���ڴ��е�Document��д���ļ���
		wr.write(document);
		wr.close();//�ر���Դ
	}
	/**
	 * ɾ���ڵ�Ĳ���(ɾ������һ����ӵ�gender)
	 * */
	public static void delete()throws Exception
	{
		//ǰ�漸���趼һ��.ʡ��ע����
		Document document = new SAXReader().read(file);
		//��ȡ���ڵ�
		Element element = document.getRootElement();
		//��ȡ�ڶ���p�ڵ�
		Element ele = (Element)element.elements("p").get(1);
		//��ȡҪɾ���Ľڵ�
		Element gen = ele.element("gender");
		//�ø��ڵ�ȥɾ��ָ���ڵ�
		ele.remove(gen);
		//��д����
		write(document,file);
	}
	/**
	 * ��ȡָ����ǩ������ֵ(��һ��P��ǩ�ϵ���ΪID������ֵ)
	 * */
	public static void getProp()throws Exception
	{
		//���÷��������в�����
		Document document = getDocument(file);
		//��ø��ڵ�
		Element ele = document.getRootElement();
		//��õ�һ��P�ڵ�
		Element p = ele.element("p");
		//�õ��ýڵ������ֵ
		String id = p.attributeValue("id");
		System.out.println(id);
	}
	/**
	 * ��װר�Ż�ȡDocument���󷽷�
	 * */
	public static Document getDocument(File file)throws Exception
	{
		return new SAXReader().read(file);
	}
	/**
	 * ��װר��ִ�л�д��������
	 * */
	public static void write(Document doc,File f)throws Exception
	{
		XMLWriter writer = new XMLWriter(new FileOutputStream(f),OutputFormat.createPrettyPrint());
		writer.write(doc);
		writer.close();
	}
}
 
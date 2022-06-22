import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
/**
 * ʹ��JAXP��ʵ�ֶ�XML�ļ���CURD
 * */
public class DocumentBuilderDemo
{
	private static File file = new File("D:\\Demo.xml");
	public static void main(String[] args) throws Exception
	{
//		serch1();
//		select();
//		add();
//		change();
//		delete();
//		show();
	}
	/**
	 * ��ѯ����(��ѯ����)
	 * */
	public static void serch1() throws Exception
	{
		//1,��������������
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//2,����xml�ļ�
		Document document = db.parse(file);
		//�õ����е�ָ�����Ƶı�ǩ���󼯺�
		NodeList list = document.getElementsByTagName("name");
		for(int x = 0;x < list.getLength();x++)
		{
			//������ȡ��ǩ
			Node node = list.item(x);
			//��ȡ��ǩ���������
			String str = node.getTextContent();
			System.out.println(str);
		}
	}
	/**
	 * ��ѯ����(ָ����ѯ)
	 * */
	public static void select()throws Exception
	{
		//1,����������
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//2,����xml�ļ�
		Document document = db.parse(file);
		//3,�õ�����ָ�����Ƶ�Ԫ��
		NodeList list = document.getElementsByTagName("name");
		//ʹ���±�����õ�һ��Ԫ��
		Node node = list.item(0);
		System.out.println("��һ��nameԪ�ص�ֵ��:"+node.getTextContent());
	}
	/**
	 * ��ӽڵ����
	 * */
	public static void add()throws Exception
	{
		//1,��������������
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//2,����xml�ļ�
		Document document = db.parse(file);
		//3,��ȡ��Ҫ�����Ľڵ����(��һ���ڵ�)
		Node node = document.getElementsByTagName("p").item(0);
		//4,������Ҫ����ӵı�ǩ����
		Element ele = document.createElement("gender");
		//5,�����ı�
		Text text = document.createTextNode("��");
		//6���ı���ӵ���ǩ��
		ele.appendChild(text);
		//7,�ѱ�ǩ��ӵ��ڵ������
		node.appendChild(ele);
		/**---���ϲ����������ڴ��н���,��û��д���ļ���,������л�д����--**/
		//8,�õ���д��(ͨ������)
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		//9,ִ�л�д(���ڴ��е�Dcoument���󴫵���Ϊ��������Ĳ���)
		tf.transform(new DOMSource(document), new StreamResult(file));
	}
	/**
	 * �޸Ľڵ�����
	 * */
	public static void change()throws Exception
	{
		//1,��������������
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//2,����xml�ļ�
		Document document =db.parse(file);
		//3,��ȡҪ�޸ĵĽڵ����(��һ����Ϊgender�ı�ǩ)
		Node node = document.getElementsByTagName("gender").item(0);
		//4,��ָ���ڵ��ֵ�����޸�
		node.setTextContent("Ů");
		//5,����Ҫ---ִ�л�д
		thrans(document,file);
	}
	/**
	 * ɾ��ָ���ڵ����
	 * */
	public static void delete()throws Exception
	{
		//1,��ȡ����������
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//2,����xml�ļ�
		Document document = db.parse(file);
		//3,��ȡ��Ҫ��ɾ���Ľڵ�(Ҳ���ǵ�һ����Ϊgender�ı�ǩ)
		Node node = document.getElementsByTagName("gender").item(0);
		//4,��ȡ��ɾ���ڵ�ĸ��ڵ�
		Node parNode = node.getParentNode();
		//5,ͨ�����ڵ���ɾ���ӽڵ�
		parNode.removeChild(node);
		//��д,����Ҫ
		thrans(document,file);
	}
	/**
	 * �����ڵ�
	 * */
	public static void show()throws Exception
	{
		//1,�õ�����������
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//2,����xml�ļ�
		Document document = db.parse(file);
		//3,����ר�ű���Document�ķ������б���
		list(document);
	}
	/**
	 * �ݹ�����ڵ㷽��
	 * */
	public static void list(Node node)
	{
		//�ж�����,����ӡ�ո��Լ��س�
		if(node.getNodeType() == Node.ELEMENT_NODE)
		{
			//��ӡԪ������
			System.out.println(node.getNodeName());
		}
		//�õ���һ���ӽڵ�
		NodeList list = node.getChildNodes();
		//����
		for(int x = 0;x < list.getLength();x++)
		{
			Node n = list.item(x);
			list(n);
		}
	}
	/**
	 * ���ݻ�д��
	 * */
	public static void thrans(Document doc,File fie)throws Exception
	{
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult(fie));
	}
}
/*	���Ե�XML�ļ�ԭ��,�������D��,ȡ��Demo(Ҳ�����޸�Դ����)

<?xml version="1.0" encoding="UTF-8"?>
<person>
	<p>
		<name>kevin</name>
		<age>21</age>
	</p>
	<p>
		<name>Litch</name>
		<age>22</age>
	</p>
</person>

*/
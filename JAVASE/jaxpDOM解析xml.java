import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
public class Demo
{
	public static void main(String[] args) throws Exception
	{
//		selectAll();//��ѯ����nameԪ��
//		selectSin();//��ѯָ��Ԫ��
//		addSex();//���"Sex"Ԫ��
//		modifySex();//�޸�ָ��Ԫ��
//		deleteSex();//ɾ��ָ��Ԫ�� 
		showAllElement();//�������нڵ�
	}
	public static void selectAll() throws Exception
	{
		/**
		 * ����
		 *1,��������������
		 *2,���ݽ�������������������
		 *3,����xml����document
		 *4,�õ����е�nameԪ��
		 *5,���ؼ��ϣ��������ϣ��õ�ÿһ��nameԪ�ء�
		 * */
		File file = new File("D:\\Demo.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(file);
		NodeList list = document.getElementsByTagName("name");
		for(int x = 0;x < list.getLength();x++)
		{
			Node node = list.item(x);
			String value = node.getTextContent();
			System.out.println(value);
		}
	}
	public static void selectSin()throws Exception
	{
		/**
		 * ����
		 *1,��������������
		 *2,���ݽ�������������������
		 *3,����xml����document
		 *4,�õ����е�nameԪ��,���ص���һ������
		 *5,ͨ�����ϵ��±�����ȡָ����Ԫ��
		 *6,ͨ��getTextContent();����ȡ�����ֵ��
		 * */
		File file = new File("D:\\Demo.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(file);
		NodeList list = document.getElementsByTagName("name");
		Node node = list.item(0);//��ȡ��һ��Ԫ��
		String value = node.getTextContent();
		System.out.println(value);
	}
	public static void addSex()throws Exception
	{
		/**
		 * ����
		 *1,��������������
		 *2,���ݽ�������������������
		 *3,����xml����document
		 *4,�õ���һ��p1
		 *		--�õ����е�p1,ʹ��item�����õ���һ��
		 *5,����Sex��ǩ-createElement
		 *6,�����ı�-createTextNode
		 *7,���ı���ӵ�Sex����-appendChild
		 *8,�����Sex��ӵ���һ��p1����
		 *9,��д�ļ�
		 *	--���ڴ������ɵı�ǩ�ڵ�д������ļ�
		 * */
		File file = new File("D:\\Demo.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(file);
		NodeList list = document.getElementsByTagName("p1");
		Node node = list.item(0);//�õ���һ��p1�ڵ�
		Element sex1 = document.createElement("sex");//������ǩ
		Text text1 = document.createTextNode("Ů");//�����ı�
		sex1.appendChild(text1);//���ı������ǩ
		node.appendChild(sex1);//�ѱ�ǩ����ڵ�
		/***���ϲ���ֻ��Ӱ���ڴ棬������Ӱ�����xml�ļ�***/
		//����Transformer������
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		//ͨ����������Transformer�Ķ���
		Transformer transformer = transformerFactory.newTransformer();
		//ͨ��transform����д�ļ�����ָ����Ŀ¼
		transformer.transform(new DOMSource(document),new StreamResult("C:\\Demo.xml"));
	}
	public static void modifySex()throws Exception
	{
		/**
		 * ����
		 *1,��������������
		 *2,���ݽ�������������������
		 *3,����xml����document
		 *4,�õ���һ��sex--item����
		 *5,�޸�sex�����е�ֵ-setTextContent
		 *6,��дxml
		 **/
		File file = new File("D:\\Demo.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(file);
		NodeList list = document.getElementsByTagName("sex");
		Node sex = list.item(0);
		sex.setTextContent("��");
		/***���ϲ���ֻ��Ӱ���ڴ棬������Ӱ�����xml�ļ�***/
		//����Transformer������
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		//ͨ����������Transformer�Ķ���
		Transformer transformer = transformerFactory.newTransformer();
		//ͨ��transform����д�ļ�.����ָ����Ŀ¼
		transformer.transform(new DOMSource(document),new StreamResult("C:\\Demo.xml"));
	}
	public static void deleteSex()throws Exception
	{
		/**
		 * ����
		 *1,��������������
		 *2,���ݽ�������������������
		 *3,����xml����document
		 *4,��ȡsexԪ��(��ǩ)
		 *5,�õ�sex�ĸ��ڵ�
		 *6,ʹ�ø��ڵ㣬ɾ��sexԪ��-removeChild();
		 *7,��дxml
		 **/
		File file = new File("D:\\Demo.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(file);
		NodeList list = document.getElementsByTagName("sex");
		Node node = list.item(0);//�õ���һ��sexԪ��
		Node fuNode = node.getParentNode();//�õ����ڵ�
		fuNode.removeChild(node);//ɾ���ӽڵ�
		/***���ϲ���ֻ��Ӱ���ڴ棬������Ӱ�����xml�ļ�***/
		//����Transformer������
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		//ͨ����������Transformer�Ķ���
		Transformer transformer = transformerFactory.newTransformer();
		//ͨ��transform����д�ļ�.����ָ����Ŀ¼
		transformer.transform(new DOMSource(document),new StreamResult("C:\\Demo.xml"));
	}
	public static void showAllElement()throws Exception
	{
		/**
		 * ����
		 *1,��������������
		 *2,���ݽ�������������������
		 *3,����xml����document
		 *4,�õ����ڵ�
		 *5,�õ����ڵ���ӽڵ�
		 *6,�õ����ڵ���ӽڵ���ӽڵ�
		 *... ...-- �ݹ�
		 **/
		File file = new File("D:\\Demo.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(file);
		list1(document);
		//��дһ������(list1)��ʵ�ֵݹ�(����)�Ĳ�����
	}
	public static void list1(Node node)
	{
		//�ж���Ԫ�����͵�ʱ��Ž��д�ӡ
		if(node.getNodeType() == Node.ELEMENT_NODE)
		{
			//��ӡnode
			System.out.println(node.getNodeName());
		}
		//�õ���һ���ӽڵ�
		NodeList list = node.getChildNodes();
		//����list
		for(int x = 0;x < list.getLength();x++)
		{
			//�õ�ÿһ���ڵ�
			Node n = list.item(x);
			//�����õ�n���ӽڵ�
			list1(n);
		}
	}
}



















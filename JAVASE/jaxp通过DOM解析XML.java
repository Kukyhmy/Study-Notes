JAVAXP(java API for xml Processing)
��JAVASE��һ���֡���һ�¼������Լ����Ӱ����
org.w3c.dom
	�ṩDMO��ʽ����XML�ı�׼�ӿ�
org.xml.sax
	�ṩsax��ʽ����xml�ı�׼�ӿ�
javax.xml
	�ṩ�˽���XML�ĵ�����
-----------------
javax.xml.parsers���ж����˼��������ࡣ���ǿ��Ե�����Щ������
�õ���XML�ȶ����н�����DOM��SAX����������

-----���DOM
DocumentBuilder//��������
DocumentBuilderFactory//����������
-----���SAX
SAXParser//��������
SAXParserFactory//����������
-------------------
DocumentBuilder
	|--�����࣬���ܴ�������Ҫͨ�����Ĺ����� DocumentBuilderFactory ��� newDocumentBuilder();����������Ķ���
	|--DocumentBuilderFactory Ҳ��һ�������ࡣ����ͨ������ newInstance();��������ȡ DocumentBuilderFactory ��ʵ����
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder doc = factory.newDocumentBuilder();
--
parse(file);
	|--file��xml�ĵ���·����Ҳ���԰�file���� String ���͵ı�ʾ·���ַ����� 
*	|--���ص���һ�� Document �ӿڣ�����������xml�Ķ���
		|--Document ��� Document ��û���ҵ���Ҫ�ķ���������ȥ���ĸ��� Node ��ȥѰ�ң�
*			|--getElementsByTagName(String tagname)
				|--����ָ������Ԫ�� ��(NodeList ����)���ϣ�
								|--getLength();
									|--���ؽڵ���.int
								|--item(int index);
									|--���ؼ����еĵ�index����.���������� Node
																			|--appendChild(Node newChild);
																				���ڵ� newChild ��ӵ��˽ڵ���ӽڵ��б��ĩβ����� newChild �Ѿ����������У��������Ƴ��������صľ��������ӵ� Node
																			|--node.getTextContent();
																				�� String ���ش˽ڵ㼰�������ı����ݡ�
*			|--createElement(String tagName);
				����ָ�����Ԫ�ء����ص���һ�� Element ���󡣴�����ǩ
*			|--createTextNode(String data);
				��������ָ���ַ����� Text �ڵ㡣 ���� Text ���󡣴����ı�
*			|--appendChild(Node newChild);
				���ı���ӵ���ǩ����
*			|--getParentNode();
				��ȡ���ڵ�
NodeList list
|--getLength();
	�õ����ϵĳ���
|--item(index);
	�õ�ָ��λ�õ�Ԫ��
for (int x=0;x<list.getLength() ;x++ )
{
	Node node = list.item(x);
	String value = node.getTextContent();
	//�����Է��ش˽ڵ㼰�������ı����ݡ�
}
----
DocumentBuilder -- ��DOM����xml�Ķ���
Document -- xml�ļ�����
NodeList -- �ڵ����ļ���
Node -- �ڵ����
---
	
***************************************jaxp����***************************************
								/****ʾ��Demo.xml****/
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<person>
<p1>
	<name>Kevin</name>
	<age>21</age>
	<sex>girl</sex>
</p1>
<p1>
	<name>Litch</name>
	<age>22</age>
	<sex>boy</sex>
</p1>
</person>
***************************************��ѯ���нڵ�***************************************
����
	��ѯxml������nameԪ�ص�ֵ
	����
	1,��������������
	2,���ݽ�������������������
	3,����xml����document
	4,�õ����е�nameԪ��
	5,���ؼ��ϣ��������ϣ��õ�ÿһ��nameԪ�ء�
----------------JAVA����ʵ��
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
/**
 * ʵ��jaxp����xml
 * */
public class TestJaxp 
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
		File file = new File("D:\\person.xml");
		//��������������
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		//����������
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		//����xml����Document
		Document document = builder.parse(file);//�ļ�·��
		//�õ����е�nameԪ�صļ���
		NodeList list = document.getElementsByTagName("name");
		//��������
		for(int x = 0;x < list.getLength();x++)
		{
			Node name = list.item(x);//��ýڵ����
			String value = name.getTextContent();//��ȡ����ڵ������
			System.out.println(value);//��ӡ������̨
		}
	}
}
***************************************��ѯָ���ڵ�***************************************
���裺
	1,��������������
	2,���ݽ������������ؽ�����
	3,����xml���� Document ����
	4,�õ����е�nameԪ��,���ص���һ������
	5,ͨ�����ϵ��±�����ȡָ����Ԫ��
	6,ͨ��getTextContent();����ȡ�����ֵ��
----------------JAVA����ʵ��
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
***************************************��ӽڵ�(Ԫ��)***************************************
ʹ��jaxp��ӽڵ�
	*** �ڵ�һ��p1һ�������<sex>��</sex>����
����
	1,��������������
	2,���ݽ�������������������
	3,����xml����document
	4,�õ���һ��p1
			--�õ����е�p1,ʹ��item�����õ���һ��
	5,����Sex��ǩ-createElement
	6,�����ı�-createTextNode
	7,���ı���ӵ�Sex����-appendChild
	8,�����Sex��ӵ���һ��p1����
	9,��д�ļ�
		--���ڴ������ɵı�ǩ�ڵ�д������ļ�
----------------JAVA����ʵ��
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
	//ͨ��transform����д�ļ�,�����ָ��Ŀ¼
	transformer.transform(new DOMSource(document),new StreamResult("C:\\Demo.xml"));
}

***************************************�޸Ľڵ�(Ԫ��)***************************************
�޸ĵ�һ��p1�����sex����Ϊ�С�
���裺
	1,��������������
	2,���ݽ�������������������
	3,����xml����document
	4,�õ���һ��sex--item����
	5,�޸�sex�����е�ֵ-setTextContent
	6,��дxml
----------------JAVA����ʵ��
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
	sex.setTextContent("��");//�޸Ľڵ�
	/***���ϲ���ֻ��Ӱ���ڴ棬������Ӱ�����xml�ļ�***/
	//����Transformer������
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	//ͨ����������Transformer�Ķ���
	Transformer transformer = transformerFactory.newTransformer();
	//ͨ��transform����д�ļ�.����ָ����Ŀ¼
	transformer.transform(new DOMSource(document),new StreamResult("C:\\Demo.xml"));
	
}
***************************************ɾ���ڵ�(Ԫ��)***************************************
ɾ����һ��sexԪ��
����
	1,��������������
	2,���ݽ�������������������
	3,����xml����document
	4,��ȡsexԪ��(��ǩ)
	5,�õ�sex�ĸ��ڵ�
	6,ʹ�ø��ڵ㣬ɾ��sexԪ��-removeChild();
	7,��дxml
----------------JAVA����ʵ��
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
***************************************�����ڵ�(Ԫ��)***************************************
�ݹ����
����
	1,��������������
	2,���ݽ�������������������
	3,����xml����document
	4,�õ����ڵ�
	5,�õ����ڵ���ӽڵ�
	6,�õ����ڵ���ӽڵ���ӽڵ�
		 ... ...-- �ݹ�
----------------JAVA����ʵ��
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
	//�����ѱ�ǩ֮��Ŀո�/ �س�֮���ȫ����ӡ����
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
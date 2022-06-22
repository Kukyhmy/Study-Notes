JAVA����xml�ĵ�
JAXP������JAVASE��һ����,�����ǽ����������
org.w3c.dom	--	�ṩDOM��ʽ����XML�ı�׼�ӿ�
org.xml.sax	--	�ṩSAX��ʽ����XML�ı�׼�ӿ�
javax.xml	--	�ṩ�˽���XML�ĵ�����

javax.xml.parsers
	> �����DOM����
	DocumentBuilder
	DocumentBuilderFactory
	> �����SAX����	//�ݲ�������
	SAXParser
	SAXParserFactory
-----------------------------------
	DocumentBuilder ��һ��������,��Ҫ��ȡ����ʵ����Ҫ���Ĺ����� DocumentBuilderFactory ��ʵ������ȡ��
���� DocumentBuilderFactory Ҳ��һ�������࣡
�ǳ����ġ���ʱ�Ҿ���Ҫ��ͨ�� DocumentBuilderFactory �ľ�̬����newInstance();����ȡ���������

1,��ȡ����������
DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();//ϣ�����ܿ���
2,���÷�������
Document	parse(File f);//����ָ����xm.�ļ�,����һ��Document����,Dcument�����Ժ����
Document	parse(String url);//����ָ��·����xml�ļ�,����һ��Document����
Document	parse(InputStream in);//����ָ���ļ�,����һ��Document����.������ʽ���ֻ���һЩ,��Ҫ�Լ���ѯAPI����һһ�о�

3,Document �������
Document,��ʵ���Ǵ�����xml����ĵ�����(λ��:org.w3c.dom����,ǧ����ҵ�),��һ���ӿڡ��̳��� Node �ӿڣ�
����� Document ��û���ҵ���Ҫ�ķ���,���Գ���ȥ Node ����ȥѰ��
			getElementById(String elementId);//
NodeList	getElementsByTagName(String tagname);//���ص�������ĵ������е�����ָ�����ı�ǩ,���ص���һ�� NodeList���� 
Element		createElement(String tagName);//����һ����ǩ
Text		createTextNode(String data);//�����ı�
Node		appendChild(Node newChild);//���Ը���Node�ķ���,������ı���ǩ��ӵ���ǩ���� 
Node		removeChild(Node oldChild);//���ӽڵ��б����Ƴ� oldChild ��ָʾ���ӽڵ㣬�����䷵�ء� 
Node		getParentNode();//���ش˽ڵ�ĸ��ڵ�,����մ����ڵ�����δ��ӵ�����������Ѿ��������Ƴ���������ֵΪ null�� 
Node		getFirstChild();//��������ڵ�ĵ�һ���ӽڵ�,���û�ͷ���null
Node		getLastChild();//���������������һ���ڵ�,���û�оͷ���null
Node		cloneNode();//���ش˽ڵ�ĸ��������ʵ��ڵ��һ�㸴�ƹ��췽����

4,Node ���
String		getTextContent();//�õ����Ԫ���е�ֵ
Node		getParentElement();//���ظ��ڵ�Ԫ��
String		getValue();// �������һ�� Text �ڵ㣬�򷵻ش˽ڵ��ֵ�����򷵻ش˽ڵ��ֱ���ӽڵ�ֵ��
void		setTextContent(String stt);//�޸�(����)�˽ڵ��ֵ
Node		removeChild(Node node);//ɾ���ӽڵ�,���������ɾ���Ľڵ�
NodeList	getChildNodes();//��ȡ��һ�����ӽڵ�,��ν�ĵ�һ����ǵ�һ��,���᷵�ص�һ����ӽڵ�,ֻ���ص�һ��

5,NodeList ���
int			getLength();//�����б��еĽڵ���
Node		item(int inde);//���ؼ����еĵ�index���ڵ����

6,Transformer ��дXML�ļ���(���þ���,������ֱ����ʹ�ö�����)
û��,���BҲ��һ�������ࡣҲ��һ������������ȡ TransformerFactory
�Ǻ���,���������Ҳ�������һ��������,��ë������ DocumentBuilder һ������
Transformer ts = TransformerFactory.newInstance().newTransformer();//Ӧ���ܿ���
void		transform(Source s,Result r);//��д�����,��ָ����Document����д�뵽ָ����xml�ļ���
			> Source ��һ���ӿ�,������������� DOMSource.
			* DOMSource ds = new DOMSource(Document doc);//����һ��Document����
			> Result Ҳһ���ӿ�,�������������	StreamResult
			* StreamResult rs = new StreamResult(new File("xml�ļ���ַ"));//����һ���ļ���ַ,Ҳ����ֱ��дurl·��
		
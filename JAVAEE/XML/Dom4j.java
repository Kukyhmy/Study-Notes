Dom4j
	���Ҫ����ѧ,�����ʵ�ʿ�����Ӧ�õñȽ϶�ģ�
	���������Dom4j��֯�ṩ�Ľ���xml���
	��������Dom��Sax���ֽ�������,���Խ�����ɾ�Ĳ���

Dom4j,������JAVASE�����,Ҳ����˵������Ҫ������
Dom4j-1.6.1.jar

1,��������������
SAXReader reader = new SAXReader();
1,����xml�ļ��õ� Document(����w3c���µ�) ����
Document document = reader.read(new File("xml�ļ�"));//�������ֽ���,����ֱ�����ļ�·��




Document --��������(�� Node ���ӽӿ�)
*  Element		getRootElement();//��ȡ���ڵ�Ԫ��,���ص���Element
	
Element --��������(�� Node ���ӽӿ�)
*  Element		getParent();//���ظ��ڵ�
*  Element		addElement();//���һ���ӱ�ǩ,���صľ����������ӵı�ǩ
*  Element		element();//���ظýڵ�����ĵ�һ���ڵ�
*  Element  	element(String name);//����ָ�����Ƶĵ�һ���ӽڵ�
*  List			elements();//��������ڵ�������ӽڵ�,List����
*  List			elements(String name);//��������ڵ��µ�����ָ�����Ƶı�ǩ����Ľ��List
*  String		getText();//���������ǩ���ı�ֵ		
*  ����			setTest();//����ǩ�����ı�ֵ
*  ����			remove(Document doc);//��ָ���ڵ���Լ��ӱ�ǩ��ɾ��(һ��Ҫ�ǵ���ѭ,ɾ���������ɸ��ڵ���ִ��)
*  String		attributeValue(String name);//���ص��Ǹýڵ�ָ���������Ե�ֵ,���û�з���null

XMLWriter --��������(���ڻ�дXML�ļ�����,������,����ֱ�Ӵ�������ʹ��)
	XMLWriter wr = new XMLWriter(OutputStream out,OutputFormat format);
	* out,��ʵ������Ҫ�������ļ�
	* OutputFormat,���Ǹ�ʽ����,��д����ļ����������ȷ���,
	> ����������̬�������Է��ظ������
		-- createPrettyPrint();//���صĶ�����Ư���Ĵ�������
		-- createCompactFormat();//���صĶ�����ѹ����,����������
*  void			write(Document doc);//��ָ����Document����д�뵽Ӳ����(·���ڴ�����д�����ʱ��ָ����)
*  void			close();//�ر���

----------------------Dom4j��XPath��֧��
ʹ��Dom4j,֧�� XPath �Ĳ���,����ֱ�ӻ�ȡ��ĳ��Ԫ��
��ʵ	XPath ����һ�����ʽ

��ʽ����
*  /AAA/BBB/CCC:��ʾһ��--AAA�����BBB�����CCC
*  //BBB:ֻҪ������BBB�����Եõ�,�����޹�
*  /*:��ʾ����Ԫ��
*  /AAA/BBB[1]:��ʾAAA�����BBB����ĵ�һ��Ԫ��
*  /AAA/BBB[last()]:��ʾAAA�����BBB��������һ��Ԫ��
*  //@id:��ȡ����id����
*  //BBB[@ID]:ֻҪ������BBBԪ���ϵ�ID��Ϥ,����ȡ
*  //BBB[@id='b1']��Ԫ��������BBB,����������id��Ϥ,����ֵΪb1
*/
�����ľ��岽��
*  Ĭ�ϵ������Dom4j�ǲ�֧��xpath�ģ������Ҫʹ��
*  ��Ҫ֧��xpath��jar��
	jaxen-1.1-bete-6.jar
*  Dom4j�����ṩ������������֧��xpath
List<Node>		selectNodes();//��ȡ����ڵ�,�������xpath���ʽ
Node			selectSingleNode();//��ȡ�����ڵ�,����xpath���ʽ
-----��
public static void getAll()throws Exception
{
	Document document = new SAXReader().read(file);
	List<Node> ele = document.selectNodes("//name");
	System.out.println(ele.get(1).getText());
}

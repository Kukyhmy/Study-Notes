import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * ʹ��java��SAX����������xml�ĵ�
 * */
public class SAXParserDemo 
{
	private static File file = new File("D://Demo.xml");
	public static void main(String[] args) throws Exception 
	{
		test();
	}
	public static void test()throws Exception 
	{
		//1��������������
		SAXParser sp = SAXParserFactory.newInstance().newSAXParser();//
		//2,�����Զ�����
		MyDefaultHandler mh = new MyDefaultHandler();
		//2����xml�ļ�
		sp.parse(file, mh);
	}
}
//�Զ���DefaultHandler��
class MyDefaultHandler extends DefaultHandler
{
	/**
	 * ��������һ����ʼ��ǩ��ʱ��ִ��
	 * */
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException 
	{
		System.out.print("<"+qName+">");
	}
	/**
	 * ��ִ�е��ı����ݵ�ʱ��,�����ո�ͻ���
	 * */
	public void endElement(String uri, String localName, String qName)throws SAXException 
	{
		System.out.print("</"+qName+">");
	}
	/**
	 * ��ִ�е�������ǩ��ʱ��ִ���������
	 * */
	public void characters(char[] ch, int start, int length)throws SAXException 
	{
		System.out.print(new String(ch,start,length));
	}
}

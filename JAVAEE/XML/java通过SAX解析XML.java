����˵,ֱ�Ӵ���
javax.xml.parsers���е�

SAX�ǻ����¼�����,�߶��߽���
SAX��������ɾ�Ĳ���,ֻ�ܲ�ѯ

SAXParser		
SAXParserFactory

��DOM����һ������, SAXParser ������,Ҳ��Ҫͨ�����󹤳��������ʵ��...����ֱ�Ӵ���ɣ����ܿ���
SAXParser sp = SAXParserFactory.newInstance().newSAXParser();

SAXParser �������
void		parse(File f,DefaultHandler dh);//����xml�ļ�
			*  File ����xm,�ļ���·��
			*  DefaultHandler ��һ���¼�������
void		parse(InputSource is, DefaultHandler dh);//����xml�ļ�,��¥�����س��� 

DefaultHandler �������(���������Զ�ִ��)
void		startElement(String uri, String localName, String qName, Attributes attributes);//����Ԫ�ؿ�ʼ��֪ͨ
			> ����,�������ֻҪ��������ʼ��ǩ��ʱ���ʱ��ִ��
			* qName	:��ʾ��ǩ������
			* 
void		characters(char[] ch, int start, int length);//����Ԫ�����ַ����ݵ�֪ͨ�� 
			> ��ִ�е��ı���ʱ��ͻ�ִ���������
			* ��ʵ����������,�� String ��һ�����췽�� new String(char[] ch,int,length);
			* ���Է����ı�����
void		endElement(String uri, String localName, String qName);//����Ԫ�ؽ�����֪ͨ
			> ��ִ�е�������ǩ��ʱ��ͻ�ִ���������
			* ���ر�ǩ������
--�����ܽỹ��
����������ʼ��ǩ��ʱ��,ִ�� startElement();����,����qName:���ر�ǩ����
���������ı����ݵ�ʱ��,ִ�� characters();����,ͨ��String�Ĺ��췽����������
��������������ǩ��ʱ��,ִ��endElement();����,����qName,���ر�ǩ����

��������
	1,��������������
	2,����������
	3,ִ��parse();����
	4,DefaultHandler ��Ҫ�����Լ�дһ����ȥ�̳�����Ȼ��д������������

�õ�����ָ��Ԫ��ֵ�ķ���
	> ���Զ������д���һ����� boolean flag = false;
	> �ڿ�ʼ�������� equals ���жϵõ��ı�ǩ�ǲ�������Ҫ�ı�ǩ,����� flag = true
	> ��characters(); �ж�flga�ǲ���true,����ǵĻ�����Ȼ��������Ҫ�ı�ǩ��ֵ.Ȼ�����Ҫ���Բ������ֵ,������Ҳ��.ֱ�Ӵ�ӡҲ��
	> ��ִ�е�������ʱ��,��flag = false.
��ȡָ���ĵ�һ����ǩ��ֵ
	> ����һ����Ա���� idx = 1;
	> �ڽ���������ʱ�� idx+1 idx+=
	> ��Ҫ��ӡ����һ��ָ��Ԫ�ص�ֵ
		*  ��characters���������ж�
		--�ж�flag = true && idx == 1
		�ǾͲ�������

����
	�ⶫ�����԰�javaBeanת��(���л�)Ϊxml!


XStream 
	���ɵ������ṩ��jar��
XStream����
����:xstream-1.4.7.jar
����:xpp3_min-1.1.4c.jar(XML Pull Parser --һ���ٶȽϿ��xml������,�����������)

ʹ�÷���

1	XStream xstream = new XStream();
2	String xmlString = xstream.toXML(javaBean);

���������Ľ��.������ȫ·����Ϊ��Ԫ��,Ȼ�����Ա��Ϊ��Ԫ��,������ԱҲ��һ����(����/����������),��ô�ͼ�������Ԫ�أ�



	��һ�����Ǵ�������,�ڶ������ǽ���javaBean,���������ַ�������һ��xml��ʽ���ַ�����
	���������кܶ��ǩ,�Ǹ������Ǵ��������������.����,���ȫ·���������ǲ���Ҫ��
	������Ҫ������ַ��������ĳЩ��������ת��
----һЩ����
xstream.alias("china",List.class);		// �滻��Ԫ��
	��Ϊ�����Ķ����Ǹ�List����,����List��ȫ·���ᱻ������Ԫ�ش���,���������Ŀ����
	�Ѹ���ǩ,Ҳ����List.class�滻��china,��ô���������ĸ���ǩ����china��
xstream.alias("province", Province.class);//��provinceָ������Ϊprovince
	ͬ��,�������������������Province������ȫ·��Ԫ�صĴ���,
	������Province�ַ����������
xstream.useAttributeFor(Province.class,"name");		//��ָ�����Ա��Ϊxml��ǩ���Գ���.�������ӱ�ǩ
	��Ϊ��������ǰ�һ��������Ա����,Ҳ�������Ե����������ӱ�ǩ����,��ĳЩʱ��
	����ϣ����ĳ�Ա��Ϊ�����ǩ�����Դ���,�������ӱ�ǩ.����ͨ���������
	ָ��ĳ�����,ĳ����Ա,��xml�ļ�����Ϊ���Դ���,�������ӱ�ǩ
xstream.addImplicitCollection(Province.class, "citys");		//�����,�����ͱ������д���.
	ȥ��ָ�����е�,��Ϊcitys��list����,��Ϊ��Щ����,���ĳ�Ա��������һ��List,�����ǲ�ϣ�����List����Ϣ������xml�� 
	����ֻ��Ҫ�����Ԫ�ؾͺ�.���ǾͿ���ͨ�����ַ�ʽ������
xstream.omitField(City.class,"description");			//ɾ��ָ�������Ա
	ȥ��ָ�����ָ����Ա,javaBean��,��Щ���Ա���ǲ���������,�Ϳ������������ȥ��
------------��ʾ
Ĭ��
<com.kevin.demo.Province>
    <name>����</name>
    <citys>
      <com.kevin.demo.City>
        <name>�ϰ���</name>
        <description>NanAn</description>
      </com.kevin.demo.City>
      <com.kevin.demo.City>
        <name>������</name>
        <description>JiangBei</description>
      </com.kevin.demo.City>
    </citys>
  </com.kevin.demo.Province>

ͨ���滻(ָ������)��
<province>
    <name>����</name>
    <citys>
      <city>
        <name>�ϰ���</name>
        <description>NanAn</description>
      </city>
      <city>
        <name>������</name>
        <description>JiangBei</description>
      </city>
    </citys>
  </province>

 ͨ��ָ�����Ժ�
   <province name="����">
    <citys>
      <city>
        <name>�ϰ���</name>
        <description>NanAn</description>
      </city>
      <city>
        <name>������</name>
        <description>JiangBei</description>
      </city>
    </citys>
  </province>

 ȥ��ָ����[�����ͳ�Ա]��Ľ��
 [ֻ�ǲ�������������ͳ�����xml��,���������������ǻ���Ҫ��....]
   </province>
  <province name="����">
    <city>
      <name>�ϰ���</name>
      <description>NanAn</description>
    </city>
    <city>
      <name>������</name>
      <description>JiangBei</description>
    </city>
  </province>

 ȥ����ָ�����Ա���Ч��
   <province name="����">
    <city>
      <name>������</name>
    </city>
    <city>
      <name>������</name>
    </city>
  </province>
  <province name="����">
    <city>
      <name>�ϰ���</name>
    </city>
    <city>
      <name>������</name>
    </city>
  </province>
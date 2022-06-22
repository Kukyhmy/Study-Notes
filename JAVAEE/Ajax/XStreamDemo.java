package com.kevin.demo;
import java.util.ArrayList;
import java.util.List;
import com.thoughtworks.xstream.XStream;
/**
 * XStream��ʾ
 * */
public class Demo{
	public static void main(String[] args){
		//alias();
		test3();
	}
	/**
	 * �����Ľ�����ʽ
	 * */
	public static  void demo(){
		List<Province> proList = getProvinceList();
		//����XStream����,����toxml�Ѽ���ת����xml�ַ���
		XStream xstream = new XStream();
		//�����ļ�
		String s = xstream.toXML(proList);
		System.out.println(s);
	}
	/**
	 * ϣ��
	 *  Ĭ�ϵ�List���Ͷ�Ӧ<List>Ԫ��,ϣ����List���Ͷ�ӦChinaԪ��
	 *  Ĭ��Province���Ͷ�Ӧ<com.kevin.Province>,ϣ������ӦProvinceԪ��
	 *  Ĭ��City���Ͷ�Ӧ<con.kevin.City>,ϣ������ӦCityԪ��
	 * */
	public static void alias(){
		List<Province> proList = getProvinceList();
		//����XStream����,����toxml�Ѽ���ת����xml�ַ���
		XStream xstream = new XStream();
		/**
		 * ��ָ��������,ָ������
		 * */
		xstream.alias("china",List.class);//��List����ָ������Ϊchina
		xstream.alias("province", Province.class);//��provinceָ������Ϊprovince
		xstream.alias("city",City.class);//��City����ָ������
		String s = xstream.toXML(proList);
		System.out.println(s);
	}
	/**
	 * Ĭ��javaBean������,����������Ԫ��,����ϣ��ĳЩjavaBean���Բ�������Ԫ��
	 * ����,����
	 * */
	public static void test(){
		List<Province> proList = getProvinceList();
		//����XStream����,����toxml�Ѽ���ת����xml�ַ���
		XStream xstream = new XStream();
		xstream.alias("china",List.class);//��List����ָ������Ϊchina
		xstream.alias("province", Province.class);//��provinceָ������Ϊprovince
		xstream.alias("city",City.class);//��City����ָ������
		/**
		 * ��ָ�����е�ָ�����Ա,�������ӱ�ǩ,���ǳ�Ϊ��������
		 * */
		xstream.useAttributeFor(Province.class,"name");//���������������,Ӧ��Ϊ����xml����,������Ĭ�ϵ���Ԫ��
		String s = xstream.toXML(proList);
		System.out.println(s);
	}
	/**
	 * ȥ��javaBean�������List��Ա��xml�г��ֵ���Ϣ
	 * */
	public static void test2(){
		List<Province> proList = getProvinceList();
		//����XStream����,����toxml�Ѽ���ת����xml�ַ���
		XStream xstream = new XStream();
		xstream.alias("china",List.class);//��List����ָ������Ϊchina
		xstream.alias("province", Province.class);//��provinceָ������Ϊprovince
		xstream.alias("city",City.class);//��City����ָ������
		xstream.useAttributeFor(Province.class,"name");//���������������,Ӧ��Ϊ����xml����,������Ĭ�ϵ���Ԫ��
		/**
		 * ȥ��ĳЩ����Ҫ�ı�ǩ.�������һ��������ĳ�Ա��������һ������,��ô������������Ϣ�����ǲ���Ҫ��ʾ��xml�ļ��е�
		 * ��������������ݱ���
		 * */
		xstream.addImplicitCollection(Province.class, "citys");//ȥ��ָ�����е�,��Ϊcitys��list����
		String s = xstream.toXML(proList);
		System.out.println(s);
	}
	/**
	 * ȥ��ĳЩ����Ҫ��javaBean����
	 * */
	public static void test3()
	{
		List<Province> proList = getProvinceList();
		XStream xstream = new XStream();
		xstream.alias("china",List.class);//��List����ָ������Ϊchina
		xstream.alias("province", Province.class);//��provinceָ������Ϊprovince
		xstream.alias("city",City.class);//��City����ָ������
		xstream.useAttributeFor(Province.class,"name");//���������������,Ӧ��Ϊ����xml����,������Ĭ�ϵ���Ԫ��
		xstream.addImplicitCollection(Province.class, "citys");//ȥ��ָ�����е�,��Ϊcitys��list����
		/**
		 * ȥ��һЩjavaBean������,����������Ԫ��
		 * */
		xstream.omitField(City.class,"description");//ȥ��ָ�����ָ����Ա
		String s = xstream.toXML(proList);
		System.out.println(s);
	}
	//����javaBean����
	public static List<Province> getProvinceList(){
		//����
		Province p1 = new Province();
		p1.setName("����");
		p1.addCity(new City("������","DongChengQu"));
		p1.addCity(new City("������","XiSanQi"));
		//����
		Province p2 = new Province();
		p2.setName("����");
		p2.addCity(new City("�ϰ���","NanAn"));
		p2.addCity(new City("������","JiangBei"));
		List<Province> provinceList = new ArrayList<Province>();
		provinceList.add(p1);
		provinceList.add(p2);
		return provinceList;
	}
}


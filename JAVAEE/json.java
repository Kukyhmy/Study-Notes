JSON

	1,Json��ʲô?
		����js�ṩ��һ�����ݽ�����ʽ,��ͬ����֮������ݽ���.
	2,Ӧ�ó���
		WebService,Ajax�첽����... ...

	
һ,JSON�����﷨

	* ����������/ֵ����
	* ������","���ŷָ�,������'˫����������',�����Ų���
	* �����ű������
	* �����ű�������
		var person = {"name":"kevin","age":"18","gender":"��"};
		alert(person.name+","+person.age+","+person.gender);
	* Json��ֵ
		* ����		����/������
		* �ַ���	��˫������
		* �߼�ֵ	true/false
		* ����		�ڷ�������
		* null
		var p = {"name":"kevin","age":18,"marry":false,"hobby":["LOL","CSOL","CSOL2"]};
		var p = {"name":"kevin","age":18,"marry":false,"hobby":[{"name":"LOL"},{"name":"CSOL"},{"name":"CSOL2"}]};
	

��,Appache��С����--json-lib
	* ������߿��԰�javaBeanת��Ϊjson��!
	* ������jar����
		commons-lang.jar
		commons-beanUtils.jar
		commons-collections.jar
		ezmorph.jar
	
	* ���Ķ���
		JSONObject		--> Map
			put(Object,Object);		//��ʵ�ͼ�ֵ��,���toString()��ת��ΪJson��
			fromObject(Object);		//���صľ���һ�� JSONObject����,����toString();�ͻ���β�javaBeanת��Ϊһ��json�ַ���
			toString();				//���صľ���һ��json��

		JSONArray		--> List
			add(Object);			//���һ������,�����toString();�ͻ��������������еĶ��󶼱��һ��json�ַ���
			fromObject(Object);		//���صĻ���JSONArray,����һ��List����,ֱ�Ӱ�List���������Ԫ�ض�ת����json!
			toString();				//������
			
===========================================================================================================
package com.kevin.json;
import java.util.ArrayList;
import java.util.List;
import com.kevin.domain.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * Appache-Jsonת��������ʾ
 * */
public class Json
{
	/**
	 * ������,���ķ���:
	 * JSONObject		--> Map
	 * 		> toString();
	 *		> fromObject(Object);
	 * JSONArray		--> List
	 * 		> toString();
	 *		> fromObject(Object);
	 * */
	public static void main(String[] args)
	{
		demo1();
		demo2();
		demo3();
		demo4();
	}
	/**
	 * ����Map��ʹ��
	 * */
	public static void demo1()
	{
		JSONObject map = new JSONObject();
		map.put("name","kevin");
		map.put("age",18);
		map.put("marry",false);
		System.out.println(map.toString());
		//{"name":"kevin","age":18,"marry":false}
	}
	/**
	 * ��javaBeanת��ΪJson
	 * */
	public static void demo2()
	{
		User user = new User("F8575532","Kevin",22,false);
		JSONObject map = JSONObject.fromObject(user);
		System.out.println(map.toString());
		//{"age":22,"id":"F8575532","marry":false,"name":"Kevin"}
	}
	/**
	 * ����List��ʹ��
	 * */
	public static void demo3()
	{
		User a = new User("F8575532","Kevin",22,false);
		User b = new User("F8575852","Litch",24,true);
		JSONArray list = new JSONArray();
		list.add(a);
		list.add(b);
		System.out.println(list.toString());
		//[{"age":22,"id":"F8575532","marry":false,"name":"Kevin"},{"age":24,"id":"F8575852","marry":true,"name":"Litch"}]
	}
	/**
	 * ʹ���Զ���List
	 * */
	public static void demo4()
	{
		User a = new User("F8575532","Kevin",22,false);
		User b = new User("F8575852","Litch",24,true);
		List<User> arr = new ArrayList<User>();
		arr.add(a);
		arr.add(b);
		JSONArray list = JSONArray.fromObject(arr);
		System.out.println(list);
		//[{"age":22,"id":"F8575532","marry":false,"name":"Kevin"},{"age":24,"id":"F8575852","marry":true,"name":"Litch"}]
	}
}

========================
jsckson������,springĬ��������json��
private static final ObjectMapper MAPPER = new ObjectMapper();

MAPPER.writeValueAsString(Object obj)				//�Ѷ������л�Ϊjson
MAPPER.readValue(String json, Class<T> clazz);	//��json�����л�Ϊ����



========================
fastjson,����Ͱ͵�����
com.alibaba.fastjson.JSON;		//��̬��


 JSON.toJSONString(Object obj);


//�����л�json����,������
List<Object> result = JSON.parseObject(json,new TypeReference<List<Object>>(){});

	

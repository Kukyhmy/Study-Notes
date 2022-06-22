import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
/**
 * ǿ����Beanutils��ʾ
 * */
public class Demo
{
	private static String className = "User";
	public static void main(String[] args) throws Exception
	{
		test();
		demo();
		useMap();
	}
	public static void test()throws Exception
	{
		/**
		 * ��ͳ���䷽������ʾ
		 * */
		Class clazz = Class.forName(className);
		Object bean = clazz.newInstance();//ͨ�����䴴������
		Method setUserName = clazz.getMethod("setUserName",String.class);//��ȡsetUserName����
		Method setPassWord = clazz.getMethod("setPassWord",String.class);//��ȡsetPassWord����
		Method setAge = clazz.getMethod("setAge",int.class);//��ȡsetAge����
		Method setGender = clazz.getMethod("setGender",String.class);//��ȡsetAge����
		/**��ֵ����**/
		setUserName.invoke(bean, "Litch");
		setPassWord.invoke(bean, "a12551255");
		setAge.invoke(bean, 22);
		setGender.invoke(bean, "��");
		System.out.println(bean);
		/**��ȡ����**/
		Method getUserName = clazz.getMethod("getUserName");
		Method getPassWord = clazz.getMethod("getPassWord");
		Method getAge = clazz.getMethod("getAge");
		Method getGender = clazz.getMethod("getGender");
		String userName = (String) getUserName.invoke(bean);
		String passWord = (String) getPassWord.invoke(bean);
		int age = (Integer) getAge.invoke(bean);
		String gender = (String) getGender.invoke(bean);
		System.out.println(userName+":"+passWord+":"+age+":"+gender);
	}
	public static void demo() throws Exception
	{
		/**
		 * beanutils����ʾ
		 * */
		Class clazz = Class.forName(className);
		Object bean = clazz.newInstance();
		/**��ֵ����**/
		BeanUtils.setProperty(bean, "userName", "Kevin");//��userName���Ը�ֵ
		BeanUtils.setProperty(bean, "passWord", "123456");//��passWord���Ը�ֵ
		BeanUtils.setProperty(bean, "age", 22);//��age���Ը�ֵ,����22��һ���ַ���,Ҳ����ȷ�ĸ�ֵ��ȥ
		BeanUtils.setProperty(bean, "gender", "��");//��gender���Ը�ֵ
		BeanUtils.setProperty(bean, "û�е��ֶ�", "Ϲ��");//�������Ͳ����ڵ����Ը�ֵ,Ҳ�ǲ��ᱨ���
		System.out.println(bean);//����toString���Զ����Ƿ�ֵ�ɹ�
		/**��ȡ����**/
		String userName = BeanUtils.getProperty(bean, "userName");
		String passWord = BeanUtils.getProperty(bean, "passWord");
		String age = BeanUtils.getProperty(bean, "age");	//int���͵��ֶη��ص���String
		String gender = BeanUtils.getProperty(bean, "gender");
		System.out.println(userName+":"+passWord+":"+age+":"+gender);
	}
	public static void useMap()throws Exception
	{
		/**
		 * Map��װ
		 * ��map�е�����ֱ�ӷ�װ��javaBean��,ͨ��beanutils
		 * Ҫ��֤Map����javaBean����������һģһ����
		 * */
		Class clazz = Class.forName(className);
		Object bean = clazz.newInstance();
		Map<String,String> map = new HashMap<String,String>();
		map.put("userName", "Rocco");
		map.put("passWord", "a12551255");
		map.put("age", "23");
		map.put("gender", "��");
		BeanUtils.populate(bean, map);//ֱ�Ӱ�Map�е�����ֱ�ӷ�װ��������
		System.out.println(bean);
	}
}
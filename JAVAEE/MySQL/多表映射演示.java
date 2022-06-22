import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * ����ѯ,�����ӳ����ʾ
 * ��ҪBeanUtils,c3p0���ӳ�,dbutils��֧��
 * */
public class Demo
{
	private static QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
	public static void main(String[] args) throws Exception
	{
		demo();//�����������װ��ʾ
		demo("123456");//����������װ��ʾ
	}
	/**
	 * ���н�����ķ�װ��ʾ
	 * */
	public static void demo() throws Exception
	{
		String s = "1";//��ѯָ��������,Ҳ����ֻ��һ����¼
		String sql = "select * from user ,class where user.cid=class.cid and uid=?";
		Object[] params = {s};
		//�õ�map����
		Map<String, Object> map = qr.query(sql, new MapHandler(),params);
		//��map�еĲ��������ݽ��з�װ
		User user = new User();
		//BeanUtils��һ����װ
		BeanUtils.populate(user, map);
		Class c = new Class();
		BeanUtils.populate(c, map);
		user.setC(c);
		System.out.println(user);
		System.out.println(user.getC());
	}
	/**
	 * ���н�����ķ�װ��ʾ
	 * */
	public static void demo(String param)throws Exception
	{
		String sql = "select * from user,class where user.cid=class.cid and user.password=?";
		//ִ�в�ѯ,���صĵ���һ��map����
		List<Map<String,Object>> list = qr.query(sql, new MapListHandler(),param);
		List<User> userlist = new ArrayList<User>();//��������,����׼������
		for(int x = 0;x < list.size();x++)
		{
			Map<String,Object> map = list.get(x);//�ѵ���mapȡ��
			User u = new User();//��������
			Class c = new Class();//��������
			BeanUtils.populate(u, map);//��װ����
			BeanUtils.populate(c, map);//��װ����
			u.setC(c);//������ϵ,��ʵҲ���ǰ����c�ŵ���u������
			userlist.add(u);//�����յĶ�����õ�����,���Է��ظ�service��
		}
		for (int x = 0; x < userlist.size(); x++) 
		{
			User u = userlist.get(x);
			System.out.println(u.toString());
			System.out.println(u.getC().toString());
		}
	}
}
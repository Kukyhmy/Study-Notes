import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;


/**
 * DBCP���ӳ�
 * */
public class Demo
{
	public static void main(String[] args) throws SQLException
	{
		method1();
	}
	public static void method1() throws SQLException
	{
		/**
		 * �������ӳض���,�����Ĵ����
		 * ���óز���
		 * �õ����Ӷ���
		 * */
		BasicDataSource dataSource = new BasicDataSource();//�������ӳض���
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");//�����Ĵ����
		dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setMaxActive(20);//�������������
		dataSource.setMinIdle(3);//������С�Ŀ�������
		dataSource.setMaxWait(1000);//�������ȴ�ʱ��
		Connection conn = dataSource.getConnection();//�õ����ӳض���
		System.out.println(conn.getClass().getName());
	}
}
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * C3P0���ӳ�
 * */
public class Demo
{
	public static void main(String[] args) throws SQLException, PropertyVetoException
	{
		method1();
	}
	public static void method1() throws SQLException, PropertyVetoException
	{
		/**
		 * �������ӳض���,�����Ĵ����
		 * ���óز���
		 * �õ����Ӷ���
		 * */
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/demo");//����4�����
		ds.setUser("root");
		ds.setPassword("root");
		ds.setDriverClass("com.mysql.jdbc.Driver");
		//���óز���
		ds.setAcquireIncrement(5);//����������������
		ds.setInitialPoolSize(20);//�صĳ�ʼ��С
		ds.setMinPoolSize(2);//��С������
		ds.setMaxPoolSize(50);//���������
		Connection conn = ds.getConnection();
		System.out.println(conn);
		conn.close();
	}
}

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * ����c3p0���ݿ����ӳ�,�����ṩc3p0-copnfig.xml�ļ��Լ���Ӧ��jar��
 * @author KevinBlandy
 **/
public class JDBCUtils
{
	private static DataSource ds = new ComboPooledDataSource();
	/**
	 * ��Ϊnull��ʾû������
	 * ����Ϊnull��ʾ������
	 * ����������ʱ����Ҫ������ֵ
	 * ����������ʱ����Ҫ������ֵΪnull
	 * �����ڿ�������ʱ����dao�Ķ�������������Connection
	 **/
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	public static DataSource getDataSource() 
	{
		return ds;
	}
	/**
	 * daoʹ�ñ���������ȡ����
	 **/
	public static Connection getConnection() throws SQLException 
	{
		/*
		 * ��������񣬷��ص�ǰ�����con
		 * ���û������ͨ�����ӳط����µ�con
		 */
		Connection con = tl.get();//��ȡ��ǰ�̵߳���������
		if(con != null) return con;
		return ds.getConnection();
	}
	/**
	 * ��������
	 **/
	public static void beginTransaction() throws SQLException 
	{
		Connection con = tl.get();//��ȡ��ǰ�̵߳���������
		if(con != null) throw new SQLException("�Ѿ����������񣬲����ظ�������");
		con = ds.getConnection();//��con��ֵ����ʾ����������
		con.setAutoCommit(false);//����Ϊ�ֶ��ύ
		tl.set(con);//�ѵ�ǰ�������ӷŵ�tl��
	}
	/**
	 * �ύ����
	 **/
	public static void commitTransaction() throws SQLException
	{
		Connection con = tl.get();//��ȡ��ǰ�̵߳���������
		if(con == null) throw new SQLException("û���������ύ��");
		con.commit();//�ύ����
		con.close();//�ر�����
		con = null;//��ʾ���������
		tl.remove();
	}
	/**
	 * �ع�����
	 **/
	public static void rollbackTransaction() throws SQLException 
	{
		Connection con = tl.get();//��ȡ��ǰ�̵߳���������
		if(con == null) throw new SQLException("û�������ܻع���");
		con.rollback();
		con.close();
		con = null;
		tl.remove();
	}
	/**
	 * �ͷ�Connection
	 **/
	public static void releaseConnection(Connection connection) throws SQLException 
	{
		Connection con = tl.get();//��ȡ��ǰ�̵߳���������
		if(connection != con) 
		{
			//����������ӣ��뵱ǰ�������Ӳ�ͬ��˵��������Ӳ��ǵ�ǰ���񣬿��Թرգ�
			if(connection != null &&!connection.isClosed())
			{
				//�����������û�йرգ��ر�֮��
				connection.close();
			}
		}
	}
}

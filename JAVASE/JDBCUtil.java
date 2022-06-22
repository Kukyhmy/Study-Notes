package myjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public final class JdbcUtils//������̳�
{
	private static String url = "jdbc:mysql://localhost:3306/demo";//���ӵ�ַ
	private static String user = "root";//�û���
	private static String password = "root";//����
	private JdbcUtils(){};//��ֹ������������̳�
	static//��̬����飬��֤������ֻע��һ��
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			throw new ExceptionInInitializerError(e);
		}
	}
	public static Connection getConnection() throws SQLException//��ȡ���������ӵĶ���
	{
		return DriverManager.getConnection(url,user,password);
	}
	public static void free(ResultSet rs,Statement st,Connection conn)//�ر���Դ
	{
		try
		{
			if(rs != null)
			{
				rs.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(st != null)
				{
					st.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(conn!=null)
				{
					try 
					{
						conn.close();
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}	
}

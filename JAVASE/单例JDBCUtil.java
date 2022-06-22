package myjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcUtilsSingle
{
	private String url = "jdbc:mysql://localhost:3306/demo";
	private String user = "root";
	private String password = "root";
	private static JdbcUtilsSingle instance = null;//�ڲ���������
	private JdbcUtilsSingle(){}//˽�й��캯������ֹ��������
	public static JdbcUtilsSingle getInstance()//��̬��ȡ���󷽷�
	{
		if(instance == null)
		{
			synchronized(JdbcUtilsSingle.class)
			{
				if(instance == null)
				{
					instance = new JdbcUtilsSingle();
				}
			}
		}
		return instance;
	}
	static//��̬ģ�鱣֤����ֻ����һ�Ρ�
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
	public Connection getConnection() throws SQLException//��ȡ���������ӵĶ���
	{
		return DriverManager.getConnection(url,user,password);
	}
	public void free(ResultSet rs,Statement st,Connection conn)//�ر���Դ
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


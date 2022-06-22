import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.kevin.utils.JDBCUtils;
public class UtilsDemo 
{
	public static void main(String[] args) throws SQLException 
	{
		update();
		find();
	}
	public static void update() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());//����QueryRunner���󴫵����ӳض���
		String sql = "insert into users values(?,?,?,?)";//����SQLģ��(��,ɾ����)
		Object[] params ={"Litch","1234",22,"Boy"};//��������
		int u = qr.update(sql,params);//����SQLģ��Ͳ���,ִ�в�ѯ���.���ر�Ӱ��Ĳ�����
	}
	public static void find() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());//����QueryRunner���󴫵����ӳض���
		String sql = "select * from users where userName=?";//����SQLģ��
		Object[] params = {"Kevin"};//��������
		User user = qr.query(sql,new BeanHandler(User.class),params);//����SQLģ��Ͳ���,ִ�в�ѯ��䷵�ض���/���߼��ϸ��ݵڶ�����������
	}
}

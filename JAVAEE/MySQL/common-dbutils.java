common-dbutils.jar����ʹ��

����������� --- QueryRunner
QueryRunner qr = new QueryRunner(���ݿ����ӳض���);
����
-----------��ɾ��
   update(String sql,Object... params);//����int����
	 -- ����ִ����ɾ�����,
	 ��:
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());//����QueryRunner���󴫵����ӳض���
	String sql = "insert into users values(?,?,?,?)";//����SQLģ��(��,ɾ����)
	Object[] params ={"Litch","1234",22,"Boy"};//��������
	int u = qr.update(sql,params);//����SQLģ��Ͳ���,ִ�в�ѯ���.���ر�Ӱ��Ĳ�����
   update(Connection con,String sql,Object... params)
	 -- ��Ҫ�������ṩConnection,˵������������ù���Cconnection
	    * (֧������)���������ʱ����Ҫ��֤��ͬһ������,����������ܱ�֤
-----------��ѯ
   <T>query(String sql,ResultSetHandler rsh,Object... params);
	 -- ����ִ�в�ѯ
	 -- �����ȵõ�ResultSet,Ȼ�����rsh��handle()��rsת������Ҫ������
	  > ResultSetHandler�ӿڵ�ʵ����
��������  * BeanHandler(Class);(����)//��Ҫһ��Class���͵Ĳ���,�����ѽ����ת����ָ�����͵�javaBean����.
���󼯺�  * BeanListHandler(Class);(����)//��Ҫһ��Class���͵Ĳ���,�����ѽ����ת����List���͵Ķ���,һ��javaBean. -- List<User> 
			List<User> list = qr.query(sql,new BeanListHandler<User>(User.class));
Map	  * MapHandler(Class);(����)//��һ�н����ת����һ��Map���� --Map<String, Object>
		-- name age gender
		   kevin 21 ��	
		 Map[name - kevin] [age - 21] [gender - ��]
	    //��ʵ���������й����ı�,��ѯ����һ�м�¼.�������¼�е��������ݶ����map����,���ǿ��Էֱ���ж���ķ�װ
List<Map> * MapListHandler();(����)��ÿ�м�¼��ת����һ��Map,���о��Ƕ��Map ��List<Map>!һ��Map��Ӧһ�м�¼
		List<Map<String, Object>> orderItemList = qr.query(sql, new MapListHandler(),order.getOid());
		����ѯ����
	   //���м�¼,��װ�������,�������֮�仹�й���.
Object	  * ScalarHandler();//���е���,ͨ������:Select count(*) from tb_name;���,������ǵ��е���,����һ��Object
		qr.query(sql, new ScalarHandler());


   <T>query(Connection conn,String sql,ResultSetHandler rsh,Object... params)
	  --  -- ��Ҫ�������ṩConnection,˵������������ù���Cconnection
	    *(֧������)���������ʱ����Ҫ��֤��ͬһ������,����������ܱ�֤
	 ��:
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());//����QueryRunner���󴫵����ӳض���
	String sql = "select * from users where userName=?";//����SQLģ��
	Object[] params = {"Kevin"};//��������,����ǲ�ѯ���� select * from tb_name;��ô���ø�����,ִ�е�ʱ��Ҳ���ø�
	User user = qr.query(sql,new BeanHandler<User>(User.class),params);//����SQLģ��Ͳ���,ִ�в�ѯ��䷵�ض���/���߼��ϸ��ݵڶ�����������;

������ִ�в���

batch(String sql,Object[][] params);

����params�Ƕ��һά����,
ÿ��һά����,������sql�����һ��ִ��һ��,���һά����,��ִ�ж��

public void addOrderItemList(List<OrderItem> orderItemList)
{
	try
	{
		String sql = "insert into orderitem values(?,?,?,?,?)";
		/**
		 * ��orderItemList ת���ɶ�ά����
		 * ��һ��orderItem����,ת����һ��һά����
		 * */
		Object[][] params = new Object[orderItemList.size()][];
		//ѭ������,orderItemListʹ��ÿ������Ϊparams�и�ֵ
		for(int x = 0;x < orderItemList.size();x++)
		{
			OrderItem item = orderItemList.get(x);
			params[x] = new Object[]{item.getIid(),item.getCount(),item.getSubtoltal(),item.getOrder().getOid(),item.getBook().getBid()};
		}
		qr.batch(sql, params);
	}
}

-----------
��һ���������,���������ű�,��������Ҫ�� MapHandler(); �����д���
�������ɶ������
1,�ѽ������װ��map(һ��map����һ����¼)
2,ʹ��map���ɵ�һ��
3,ʹ��map����ڶ�������
4,����������ʵ�彨����ϵ(����ȥ)

���������N���,���Ǿ���ҪMapListHandler();�����д���
�������ɶ������,�����������Լ����з�װ
1,�ѽ������װ��List<Map<String,Object>>,һ��map����һ����¼
2,ѭ������,��ÿ��map�Ķ��󶼴�������
3,�Ѷ�����й���,����ȥ
4,������Ѿ������˹����Ķ���װ��List����

BeanListHandler<T>(T.class)			//���󼯺�

MapListHandler()					//List<Map<String,Object>>

BeanHandler<T>(T.class)				//��������

ScalarHandler<T>()					//���������


����JAVA��JDBC
	IDBC����һЩ�ӿڹ��ɵ�API(Java Data Base Connectivity,java���ݿ�����);
	�������ݿ�Ĳ���
	java,sql   javax,sql   //����
��ע������(ֻ��һ��)
�ڽ�������(Connection)
�۴���ִ��SQL���(Statement)
��ִ�����
�ݴ���ִ�н��(ResultSet)
���ͷ���Դ

DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	|--����ע��.ע����������ʱ���м���:������
System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
	|--����ע�ᡣ
Class.forName("con.mysql.jdbc.Driver");
	|--����ע�ᡣ
�������ӡ���
	Connection conn = DriverManager.getConnection(url,user,password);
MySql����url��ʽ
	JDBC:��Э��:������//������:�˿�/���ݿ���?������=����ֵ&
	��������:"jdbc:mysql:///jdbc";
User,password
	������=����ֵ
��������
	useUnicode=true
----------------------------------------------------------------------------------------------------------------
Connection  -- JAVA�������ݵĶ���ӿڡ�ÿһ�����Ӷ�����һ�� Connection
����һ���ӿ��޷�����������Ҫ�� DriverManager ������ȡ Connection �Ķ���
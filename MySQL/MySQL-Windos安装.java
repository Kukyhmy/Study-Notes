--------------------------------
Winddows ��װMySQL				|
--------------------------------
	# ����windowsѹ����,��ѹ
		https://dev.mysql.com/downloads/mysql/

		* ���Ե��: Looking for previous GA versions? ��������ǰ�İ汾(5.7.x)
	
	# ��ӻ�������
		MYSQL_HOME=D:\mysql-5.7.26-winx64
	
	# ���PATH����
		%MYSQL_HOME%\bin;

	# ����ini�����ļ�
		* ��mysql�Ľ�ѹ��Ŀ¼�����ļ�:my.ini

[mysql]
default-character-set=utf8mb4 

[mysqld]
port = 3306 
basedir=D:\mysql\mysql-5.7.26-winx64
datadir=D:\mysql\mysql-5.7.26-winx64\data
max_connections=200
character-set-server=utf8mb4
collation-server=utf8mb4_unicode_ci

[client]
default-character-set=utf8mb4


	
	# ��ʼ��
		mysqld --initialize-insecure

		* ��ʼ���������root�û�
		* ��¼ʱ��������ֱ�ӻس�
		* ��¼�ɹ����޸�����
			set password for 'root'@'%' = password('root');
	
	# ��װ��ϵͳ����
		mysqld --install

		* ʹ��ϵͳ����ά��
			net start mysql
			net stop mysql
		
		* �������ж�����°�װ
			mysqld --remove mysql





/*****************								RPM								*********************/
------------------------
Linux- MYSQL RPM		|
------------------------
	1,��ѯmysql�Ƿ�װ
		rpm -qa | grep -i mysql
	2,����а�װ,ж��֮
		* yum -y remove mysql-libs*
		* rpm -e [��ѯ������]

	3,�����ļ�
		MySQL-5.6.31-1.el6.i686.rpm-bundle.tar		//���ʼ����������汾
		����ҳ�棺http://dev.mysql.com/downloads/mysql/
		�˴�ѡ��Red Hat Enterprise Linux 6 / Oracle Linux 6 (x86, 32-bit), RPM Bundle������
		������/root/Downloads/Ŀ¼�£������ļ���Ϊ��MySQL-5.6.31-1.el6.i686.rpm-bundle.tar��

		# wget http://ftp.ntu.edu.tw/MySQL/Downloads/MySQL-5.6/MySQL-5.6.31-1.el6.i686.rpm-bundle.tar

	2. ��ѹtar��
		cd /root/Downloads/
		tar -xvf MySQL-5.6.31-1.el6.i686.rpm-bundle.tar

	3. ��RPM��ʽ��װMySQL
		��RHELϵͳ�У������Ȱ�װ��MySQL-shared-compat-5.6.31-1.el6.i686.rpm��������ݰ���Ȼ����ܰ�װserver��client������װʱ�����
		yum install MySQL-shared-compat-5.6.31-1.el6.i686.rpm		# RHEL���ݰ�
		yum install MySQL-server-5.6.31-1.el6.i686.rpm              # MySQL����˳���
		yum install MySQL-client-5.6.31-1.el6.i686.rpm              # MySQL�ͻ��˳���
		yum install MySQL-devel-5.6.31-1.el6.i686.rpm               # MySQL�Ŀ��ͷ�ļ�
		yum install MySQL-embedded-5.6.31-1.el6.i686.rpm			# ��Ҳ��֪����ɶ
		yum install MySQL-shared-5.6.31-1.el6.i686.rpm              # MySQL�Ĺ����

	4. ����MySQL��¼����
		cat /root/.mysql_secret  # ��ȡMySQL��װʱ���ɵ��������
		service mysql start      # ����MySQL����
		mysql -uroot -p          # ����MySQL��ʹ��֮ǰ��ȡ���������
		SET PASSWORD FOR 'root'@'localhost' = PASSWORD('password');  # ��MySQL������������root�˻�������Ϊpassword
		quit  # �˳�MySQL������
		service mysql restart  # ��������MySQL����
	
	5,����rootԶ�̵�¼
		mysql> use mysql;
		mysql> select host,user,password from user;
			+-----------------------+------+-------------------------------------------+
			| host                  | user | password                                  |
			+-----------------------+------+-------------------------------------------+
			| localhost             | root | *6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9 |
			| localhost.localdomain | root | *1237E2CE819C427B0D8174456DD83C47480D37E8 |
			| 127.0.0.1             | root | *1237E2CE819C427B0D8174456DD83C47480D37E8 |
			| ::1                   | root | *1237E2CE819C427B0D8174456DD83C47480D37E8 |
			+-----------------------+------+-------------------------------------------+
		mysql> update user set password=password('����') where user='root';
		mysql> update user set host='%' where user='root' and host='localhost';
		mysql> flush privileges;
		mysql> exit
	
	6,���ÿ�������
		chkconfig mysql on
	-------------------------------------- ����OK
	7,�����ļ���ַ 
		/var/lib/mysql/		#���ݿ�Ŀ¼
		/usr/share/mysql	#�����ļ�Ŀ¼
		/usr/bin			#�������Ŀ¼
		/etc/init.d/mysql	#�����ű�
		/usr/my.cnf			#�����ļ�(�޸��ַ���)
	
	8,�����ַ���
		# 5.6�Ժ�:my.cnf �����ļ�����:/usr/my.cnf ��������/etcĿ¼����
		1,��[mysqld]�����:
			character-set-server=utf8
			collation-server=utf8_general_ci
		2,��[client]�����
			default-character-set=utf8
			* ���û��[client],���Լ����һ��
		Demo ------------------------------------------------------------------
			[mysqld]
			sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES
			character-set-server=utf8
			collation-server=utf8_general_ci

			[client]
			default-character-set=utf8
	
	9,�޸ķ���˿�
		... ...
	


	10,���ŷ���ǽ(�˿�)
		# vim /etc/sysconfig/iptables
		# �ں����
			-A INPUT -m state --state NEW -m tcp -p tcp --dport 3306 -j ACCEPT
		---------------------------------------------------------------------
		-A INPUT -m state --state NEW -m tcp -p tcp --dport 22 -j ACCEPT			//��˼�ǿ�������22�ĳ�
		-A INPUT -m state --state NEW -m tcp -p tcp --dport 3306 -j ACCEPT


/*****************								Դ�밲װ								*********************/

---------------------------
1,��װcmake����				|
---------------------------
	# ����ϵͳ��װ��ʱ����Ѿ��߱�cmake
	# cmake --version ���Բ鿴�汾,ȷ���Ƿ�װcmake
	# yum -y install cmake,���û�а�װ,��� yum Դ��װ
	# Ҳ�����Լ�����Դ�밲װ,�Լ��ٶ�
	# ͨ�õ�һ��
		yum -y install gcc-c++
		yum -y install gdb
		yum -y install ncurses-devel
		yum -y install bison bison-devel
		yum -y install cmake

---------------------------
2,��������û�				|
---------------------------
	useradd -r mysql

---------------------------
2,׼������MySQL				|
---------------------------
	# ����mysql5.6.22Դ���
		wget http://101.110.118.23/dev.mysql.com/get/Downloads/MySQL-5.6/mysql-5.6.22.tar.gz
	
	# ��ѹ��,����Ŀ¼,ִ�б���.��ϸ��������.�����Լ�����������
		cmake   \
			-DCMAKE_INSTALL_PREFIX=/usr/local/mysql   			\ 
				* mysql ��װĿ¼
			-DMYSQL_DATADIR=/usr/local/mysql/db					\ 
				* ���ݿ��ļ�Ŀ¼
			-DSYSCONFDIR=/etc									\ 
				* ����my.cnf����Ŀ¼,Ĭ��Ϊ��װĿ¼
			-DMYSQL_UNIX_ADDR=/tmp/mysql.sock					\ 
				* �����׽���·��,����Ǿ���·��,Ĭ��:/tmp/mysql.sock

			-DWITH_MYISAM_STORAGE_ENGINE=1  					\ 
				* ֧��MyIASM����
			-DWITH_INNOBASE_STORAGE_ENGINE=1   					\ 
				* ֧��InnoDB����
			-DWITH_MEMORY_STORAGE_ENGINE=1						\ 
				* ֧��Memory����
				* �������
			-DWITH_ARCHIVE_STORAGE_ENGINE=1						\ 
				* ֧��Archive����
			-DWITH_BLACKHOLE_STORAGE_ENGINE=1					\ 
				* ֧��Blackhole����

			-DWITH_READLINE=1									\ 
				* ��ݼ�����(û�ù�)
				* �������
			-DMYSQL_TCP_PORT=3306								\ 
				* ���ü����˿�
			-DENABLED_LOCAL_INFILE=1							\ 
				* ���дӱ��ص�������
			-DWITH_PARTITION_STORAGE_ENGINE=1					\ 
				* ��װ֧�����ݿ����
			-DEXTRA_CHARSETS=all								\ 
				* ��װ�����ַ���
			-DDEFAULT_CHARSET=utf8								\ 
				* ����Ĭ���ַ���
			-DDEFAULT_COLLATION=utf8_general_ci					\ 
				* ����Ĭ�ϵ��������(У�����)

			-DENABLE_DOWNLOADS=1								\
				* �Զ����ؿ�ѡ�ļ��������Զ����عȸ�Ĳ��԰�


		* �����������ã���Ҫɾ��CMakeCache.txt�ļ�
		rm CMakeCache.txt

	
	# ����OK��ִ��
		make && make install 
	

	# ʹ�ýű���ʼ�����ݿ�,���밲װĿ¼
		./scripts/mysql_install_db --basedir=/usr/local/mysql --datadir=/usr/local/mysql/db --user=mysql
		* �ֱ�ָ��:��װĿ¼,���ݿ�Ŀ¼,�����û�
	
	# ����my.cnf�ļ�
		cp ./my.cnf /etc/my.cnf
		
	# ���������ű�,��service���Բٿ���
		cp support-files/mysql.server /etc/init.d/mysql

	# Ŀ¼Ȩ������
		chown mysql /usr/local/mysql -R

	# �޸�/etc/profile,��������
		* ĩβ���
			PATH=/usr/local/mysql/bin:/usr/local/mysql/lib:$PATH
			export PATH
		* source /etc/profie
	
	# �޸�/etc/my.cnf�ļ�
		 basedir = /usr/local/mysql
		 datadir = /usr/local/mysql/db
		 port = 3306
		 server_id = 1
		 socket = /tmp/mysql.sock


	# ��������
		conkconfig mysql on

	# ����root����,�Լ�����Զ�̵�¼
		* ��¼MYSQL
		mysql -uroot
		mysql> SET PASSWORD = PASSWORD('����');
		mysql> use mysql;
		mysql> select host,user,password from user;
			+-----------------------+------+-------------------------------------------+
			| host                  | user | password                                  |
			+-----------------------+------+-------------------------------------------+
			| localhost             | root | *6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9 |
			| localhost.localdomain | root | *1237E2CE819C427B0D8174456DD83C47480D37E8 |
			| 127.0.0.1             | root | *1237E2CE819C427B0D8174456DD83C47480D37E8 |
			| ::1                   | root | *1237E2CE819C427B0D8174456DD83C47480D37E8 |
			+-----------------------+------+-------------------------------------------+
		mysql> update user set password=password('����') where user='root';
		mysql> update user set host='%' where user='root' and host='localhost';
		mysql> flush privileges;
		mysql> exit
		service mysql restart
	
	
	# ���ŷ���ǽ(�˿�)
		# vim /etc/sysconfig/iptables
		# �ں����
			-A INPUT -m state --state NEW -m tcp -p tcp --dport 3306 -j ACCEPT
		---------------------------------------------------------------------
		-A INPUT -m state --state NEW -m tcp -p tcp --dport 22 -j ACCEPT			//��˼�ǿ�������22�ĳ�
		-A INPUT -m state --state NEW -m tcp -p tcp --dport 3306 -j ACCEPT
	
	# �޸��ַ���
		* ����ַ�������,���Լ��޸�/etc/my.cnf�ļ�
		1,��[mysqld]�����:
			character-set-server=utf8
			collation-server=utf8_general_ci
		2,��[client]�����
			default-character-set=utf8
			* ���û��[client],���Լ����һ��
		Demo ------------------------------------------------------------------
			[mysqld]
			sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES
			character-set-server=utf8
			collation-server=utf8_general_ci

			[client]
			default-character-set=utf8

	# �󹦸��
������ʾ��

java.sql.SQLException: Incorrect string value: '\xF0\x9F\x90\x82' for column 'content' at row 1

�޸� my.cnf����mysql.ini����������

[client]
default-character-set = utf8mb4

[mysql]
default-character-set = utf8mb4

[mysqld]
character-set-server = utf8mb4
collation-server = utf8mb4_unicode_ci

���ݿ����Ҳ����Ϊutf8mb4

�鿴����

SHOW VARIABLES WHERE Variable_name LIKE 'character%' OR Variable_name LIKE 'collation%';

* ����:character_set_system     | utf8   �����⡣��Ӧ���� utf8mb4
������������������������������������������������
1,maven�ۺ�				|
������������������������������������������������
	* �ڸ�Ŀ¼����pm.xml�����ļ�
	* ��������ģ��
	<packaging>POM</packaging>
	<modules>
		<modul>../user-core</modul>
		<modul>../user-log</modul>
		<modul>../user-service</modul>
	<modules>
	* ����ɶ�Ķ���Ҫ
	* ֻ����GAV
	* �����ʽ��ΪPOM.����jar
	* �ⶫ�����ǿ�����һ���ط�������

------------------------
2,�̳�					|
------------------------
	* Ҳ��ɶ����Ҫ
	* ��������GAV
	* packingΪpom
	* ����һЩ����,���ù���
	* �ڸ�ģ�������������
		<dependenciesManagement>
			<dependencies>
				<dependencies>
					...
				</dependencies>
			</dependencies>
		</dependenciesManagement>
		* ����������ַ�ʽ�Ļ�,��ô������������и��������
		* ���ַ�ʽ,�������ȥ�Լ�'��ѡ'

	����ģ����
		<parent>
			<groupId></groupId>
			<arifactId></aritfactId>
			<version></version>
			<!-- ��POM��·�� -->
			<relativePath>../user-parent/pom.xml</relativePath>
		</parent>
	*����ģ���оͽ�����Ҫд��atifactId,vetsion
	*����ģ����ʹ�ø�POM������
			����ֻ��Ҫ����groupId��artifactId�ͺ�
	

	*�����е�����Ŀ��Ҫ������jar,�����������ļ���ɸѡ�ͺã�

	

* �̳к;ۺ�,���Է�һ�𣡳�������
* �������ۺϵ�,Ҳ�����̳е�


------------------------
3,��̳�				|
------------------------
	<dependencyManagement>
		<dependencies>
			<!-- �˴��̳���a �� b ������Ŀ��typeΪpom��scope Ϊ import -->
			<dependency>
				<groupId>com.cbm.stu</groupId>
				<artifactId>maven-parent-a</artifactId>
				<version>1.0.0</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
			<dependency>
				<groupId>com.cbm.stu</groupId>
				<artifactId>maven-parent-b</artifactId>
				<version>1.0.0</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
	
������������������������������������������������
1,maven����				|
������������������������������������������������	
	mvn archetype:generate		//���� Maven ��Ŀ
	mvn archetype:generate -DarchetypeCatalog=internal
								//��Ҫ��������ģ��,���������㶮�ģ�
	mvn compile					//����Դ���뵽target�ļ���
	mvn test-compile			//������Դ���
	mvn test					//����Ӧ�ó����еĵ�Ԫ����
	mvn site					//������Ŀ�����Ϣ����վ
	mvn clean					//���Ŀ��Ŀ¼�е����ɽ��
		* ɾ��maven���ɵ�Ŀ���ļ�
	mvn package					//������Ŀ���ô���ļ�
	mvn install					//�ڱ��� Repository �а�װ jar
	mvn deploy					//��jar��������Զ�ֿ̲�
		* ������˽��
	mvn eclipse:eclipse			//���� Eclipse ��Ŀ�ļ�
	mvn dependency:list			//�鿴��ǰ��Ŀ�Ѿ�����������
	mvn dependency:tree
������������������������������������������������
1,maven-��������		|
������������������������������������������������
	1,mvn archetype:generate
		* ��ʼ����������jar��
	2,ѡ�� archetype ��ʹ�õİ汾
		* һ��ѡ����ߵİ汾:6
	3,����groupId
	4,����artifactId
	5,����汾
		* 0.0.1-SNAPSHOT
	6,������,��������ֱ�Ӿ�ʹ�ñ�·��
	7,�Ƿ�Ҫ����?����y,�س�.�ͻᴴ��һ��maven�ṹ��Java����
		* ���һᴴ����pom.xml�ļ�
	8,ֱ��һ�������㶨��������
		* mvn archetype:generate -DarchetypeCatalog=internal -DgroupId=com.ans -DartifactId=ans-user -Dversion=0.0.1-SNAPSHOT



* ��Ҫ����������ģ��,Ҫ����

mvn archetype:generate -DarchetypeCatalog=internal -DgroupId=com.ans -DartifactId=ans-user -Dversion=1.0-SNAPSHOT
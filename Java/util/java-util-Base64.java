--------------------
Base64				|
--------------------
	# java.util.Base64
	# ע��,�����JDK8��������,��JDK8��,Base64�Ѿ��� JDK�ı�׼���
	# ����:��������ֽ�����,���ص���String
	# ����:�������String,���ص����ֽ�����


--------------------
Base64ʵ������/�ֶ�	|
--------------------


--------------------
Base64��̬����/�ֶ�	|
--------------------


--------------------
Base64-Demo			|
--------------------
	String text = "Base64 finally in Java 8!";
	String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));		//����
	System.out.println( encoded );	

	String decoded = new String(Base64.getDecoder().decode( encoded ),StandardCharsets.UTF_8 );			//����
	System.out.println( decoded );

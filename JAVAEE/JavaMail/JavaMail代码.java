1,����
mail.jar
activation.jar
-----------������
1,Session(�õ�������鷳)
  * ��HttpSession��һ��
  * �����õ�����,��ʾ�Ѿ����������������,��JDBC��Connection��������
  �õ�Session,��Ҫʹ��Session.getInstance(Properties prop,Authenticator auth);
  -- Properties	-- �����ļ�
     Properties prop = new Properties();
     ������Ҫ������������:prop.setProperty("mail.host","smtp.163.com");//���÷�����������
			 :prop.setProperty("mail.smtp.auth","ture");//������Ҫ��֤

  -- Authenticator(������,��Ҫ�Լ�ʵ��)  -- ����֤��,�ṩ����������Ҫ�����û�����Ϣ
	getPasswordAuthentication();��Ҫʵ���������
	//�����ڲ���������ʽ
	Authenticator auth = new Authenticator()
	{
		protected PasswordAuthentication getPasswordAuthentication()
		{
			PassWordAuthenticationd pass = new PasswordAuthentication("userName","passWord");
			return pass;
		}
	}
	PassWordAuthenticationd pass = new PasswordAuthentication("userName","passWord");
	//������������ʱ��,�������еĵ�һ��������ʾ�����û���,�ڶ���������ʾ��������
	�����ձ�����ʽ��:
	Session session = Session.getInstance(prop,auth);
2,MimeMessage
  * ��ʾһ���ʼ�����,���Ե�������setFrom()֮��ķ���,���÷�����,�����ռ���,���ñ���,��������
  * MimeMessage msg = new MimeMessage(session);//��ҪSession�����������������
  msg.setFrom(Address address);//�����÷�������Ϣ��
	 -- Address�Ǹ�������,���ǿ��Դ�������Ϥ��ʵ�������-InternetAddress()
    ���� -- setFrom(new InternetAddress("747692844@qq.com"));
  msg.setRecipients(type,address);//�������ռ�����Ϣ��
	 -- RecipientType.TO  ��һ��������ʵ��һ����̬��Ա������ʾ���ռ���
	 -- �ڶ�����ʾ����һ���ռ���ַ
    ���� -- msg.setRecipients(RecipientType.TO, "948593493@qq.com");
  msg.setRecipients(RecipientType.CC, "747692844@qq.com");//�����ó��͡�
	 -- RecipientType.CC  ��һ�����Ա��̬�ֶα�ʾ����
    ���� -- msg.setRecipients(RecipientType.CC, "747692844@qq.com")
  msg.setRecipients(RecipientType.CC,"10086@qq.com");//���������͡�
         -- RecipientType.BCC  ��һ�����Ա��̬�ֶα�ʾ����
    ���� --  msg.setRecipients(RecipientType.BCC,"10086@qq.com");
  msg.setSubject("��������KevinBlandy�Ĳ����ʼ�");//�����ñ��⡿
  msg.setContent("�����һ�������ʼ�,����","text/html;charset=utf-8");//�����������Լ�����,���롿
3,Transport
  * ��ֻ��һ������,���Ƿ����ʼ�
  Transport.send(msg);//�����ʼ�,ֱ�Ӿ�̬����,���贴������,��Ҫ�ṩMimeMessage����
  

-----------Transport��ҪMimeMessage,MimeMessage��Ҫsession-----------
���ʹ��и������ʼ�
 * �����Ͱ����������ʼ�ʱ,�ʼ����Ϊ�ಿ����ʽ
	1,����һ���ಿ�����ʼ�����
	MimeMultipart	--��ʵ����һ������,����װ�ض�����岿��
	2,������Ҫ�����������岿��,һ�����ı�����,��һ���Ǹ���
	MimeBodyPart    --��ʾһ������
	3,��MimeMultipart���ø�MimeMessage������

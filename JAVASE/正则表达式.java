-------------------
������ʽ			|
-------------------
	# ����һ������ı��ʽ
	# ����ר�Ų����ַ���
	# ���ض��ķ�������ʾһЩ�������,������д
	Pattern 
	Matcher
-------------------
����-ƥ��			|
-------------------
	boolean matches("������ʽ���ַ���");
		# '�κ��ַ��������Ե��ø÷���',���ƥ��.���� true,��֮ false
		
-------------------
����-�и�			|
-------------------	
	String[] split(String regex);
		# ����һ��'������ʽ',
		# ['DEMO']
			//��ƥ����ַ���
			String str = "zhansan  lisi  wangwu";
			//������ʽ(����һ�����߶���ո�)
			String reg = " +";
			//�������:zhangsanlisiwangwu   �Ǹ�������(һ�����߶���ո�),�������и��
			String[] result = str.split(reg);
			//���ؽ���оͲ�����-�����������ַ���
	# '.',�÷�����������ʽ�б�ʾ'�����ַ�'.�������и�String��ʱ����Ҫת��:'\\.'

-------------------
����-�滻			|
-------------------	
	 String replaceAll(String regex, String replacement);
	 # ['DEMO']
		//����ִ��������ַ���
		String str = "aaa000000aaa";
		//�����滻�����ַ���
		String newStr = "#";
		//������ʽ(ƥ�䵽��������5�����������͵��ַ���)
		String reg = "\\d{5,}";
		str = str.replaceAll(reg, newStr);
		//�������:aaa#aaa			��������(������������������͵��ַ���),�滻Ϊָ�����ַ���
		System.out.print(str);

-------------------
����-��ȡ			|
-------------------	
	# ���ַ����з��Ϲ��������ȡ����
		1,�Ȱ�������ʽ��װ�ɶ���
		2,����������Ҫ�������ַ��������
		3,������,��ȡһ������:'����ƥ������'
		4,ͨ������Է��Ϲ�����Ӵ����в���(����,ȡ��)
	


	API
		Pattern
			# û�й����Ĺ��캯��,ֻ��ͨ����̬�������ظ������.
			Matcher matcher(CharSequence input)  
				* CharSequence �������ַ����нӿ�.String ����������.����.����ֱ�ӷ��ַ�����
			boolean matches(String regex, CharSequence input);
				* ��̬����,��һ��������.�ڶ��������ַ���.���ƥ�䷵��true.��֮����false
			
		Matcher
			# ��˵�е�����,Ҳ����ƥ����
			boolean matches();
				* �ַ����Ƿ�����ָ������������.��ʵ String �ڲ����Ǹ� matches();�ײ������
			boolean find();
				* ����һ��ƥ�����,�����ƥ��ɹ�������.��ô�ͷ��� true,���򷵻� false
			String group();
				* ���ڻ�ȡƥ�������Ľ��,һ��group();��������һ�ε�find();��Ч
				* ˵����,���Ǹ�����������ʹ��.һ��find();����true��.�Ϳ���ִ��һ��grou();�õ���ƥ�䵽���ַ���
			int end();
				* ���سɹ�ƥ�䵽���Ӵ���'����ƫ����'.(����λ��)
				* '������ִ����find();'
				* ������ͷ�±�
			int start();
				* ���سɹ�ƥ�䵽���ִ���'��ʼƫ����'.(����λ��)
				* '������ִ����find();'
				* �������������±�
				

	/*
		 * ���ڱ�ƥ����ַ��� 
		 */
		String string = "aa aaa bbb ccc w aa a";
		/*
		 * ʹ�ù��캯��,������:�������
		 * �����������:3��������Ӣ���ַ���
		 */
		Pattern pattern = Pattern.compile("[a-z]{3}");
		/*
		 * ����������Ҫ���������ַ��������,��ȡ--ִ��ƥ�����������(ƥ����)
		 */
		Matcher matcher = pattern.matcher(string);
		/*
		 * find();����ƥ�����,����ɹ�ƥ�䵽һ������,����true
		 */
		while(matcher.find()){
			/*
			 * ��ȡһ��ƥ��Ľ��.Ҳ���Ǹ��ݹ���ƥ��������ַ���
			 */
			String result = matcher.group();
			/*
			 * �ô��ڸ����еĿ�ʼ�Ǳ�
			 */
			int sta = matcher.start();
			/*
			 * �ô��ڸ����еĽ����Ǳ�
			 */
			int end = matcher.end();
			System.out.println("���ϵ��ַ���:"+result);
			System.out.println("��ʼλ��:"+sta+" ����λ��:"+end);
			/*
			 	���--------------
			 	���ϵ��ַ���:aaa
				��ʼλ��:3 ����λ��:6
				���ϵ��ַ���:bbb
				��ʼλ��:7 ����λ��:10
				���ϵ��ַ���:ccc
				��ʼλ��:11 ����λ��:14
			 */
		}
	


		String string = "aa aaa bbb ccc w aa a";
		Pattern pattern = Pattern.compile("[a-z]{3}");
		Matcher matcher = pattern.matcher(string);
		while(matcher.find()){
			String result = matcher.group();
			int sta = matcher.start();
			int end = matcher.end();
			System.out.println("���ϵ��ַ���:"+result);
			System.out.println("��ʼλ��:"+sta+" ����λ��:"+end);
		}
----------------
BufferedReader
----------------
	# ����
		BufferedReader reader = new BufferedReader(new FileReader(),int length);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		* length	���û������Ĵ�С
	
	# ʵ������
		String reader.readLine();
			* ��ȡһ������(���������س���),������ĩβ������ null.
		
		long transferTo(Writer out)
			* �ѵ�ǰReaderд�뵽ĳ��writer
			* ����д����ֽ���
		

----------------
LineNumberReader
----------------
	# BufferedReader ������,���п��Զ�д�кŵ���

	# ���кŵķ���
		int getLineNumber()
			* ���Ի�ȡ��ȡ���к�

		void setLineNumber(num)
			* ���ó�ʼ���к�, ��ȡ�ĵ�һ�д�num+1��ʼ���
		
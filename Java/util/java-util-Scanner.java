--------------------
Scanner				|
--------------------
	# ɨ����
	# ���õ����ľ��Ƕ�ȡ��Ļ������(�������߳�)
		* ���������ڶ�ȡ�ļ�,�ַ��ȵ�....
	# ���췽��
		Scanner(InputStream in);
		Scanner(Readable source);
		Scanner(InputStream source, String charsetName)	
		Scanner(File source)
	
	# jdk1.5��ǰ��ȡ��Ļ����
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

--------------------
Scanner	- ����		|
--------------------
	int nextInt();			
	String next();
	String line nextLine();
	boolean hasNext()
	useDelimiter(String pattern);
		* ʹ��ָ��������ȥ�ָ�
	useLocale(Locale locale)
		* ʹ��ָ�������Ի���
	
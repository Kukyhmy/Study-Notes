--------------------------
BufferedInputStream			|
--------------------------
	# InputStream װ����,������������
	# ����
		BufferedInputStream(InputStream in) 
		BufferedInputStream(InputStream in, int size) 
          * ��������ָ����������С�� BufferedInputStream ��������������������� in���Ա㽫��ʹ�á� 


--------------------------
����/�ֶ�					|
--------------------------
	int read(byte[] b);
		* ������ȡ��һ���ֽ�����,���ض�ȡ�����ֽ���
	int read()
		* ������ȡһ���ֽڲ��ҷ���
	int available() ;
		* ���ؿ��ԴӴ���������ȡ�������������Ҳ��ܴ��������������ķ������������Ĺ����ֽ�����

--------------------------
��̬����/�ֶ�				|
--------------------------

--------------------------
Demo						|
--------------------------
	FileInputStream fileInputStream = new FileInputStream(PATH);
	BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream,1024);	//������������,ָ����������С
	int len = 0;
	byte[] buf = new byte[1024];
	while (((len = bufferedInputStream.read(buf)) != -1)){
		System.out.println(new String(buf,0,len,"GBK"));
	}
	bufferedInputStream.close();

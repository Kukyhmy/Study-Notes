--------------------------
BufferedOutputStream			|
--------------------------
	# InputStream װ����,������������
	# ����
		BufferedOutputStream(OutputStream out) 
		BufferedOutputStream(OutputStream out, int size) 
          * ��������ָ����������С�� BufferedOutputStream �������������������� out���Ա㽫��ʹ�á� 


--------------------------
����/�ֶ�					|
--------------------------
	void flush() 
		* ˢ�´˻����������� 

	void write(byte[] b);
		* д�������ֽ�����

	void write(byte[] b, int off, int len) 
		* ��ָ�� byte �����д�ƫ���� off ��ʼ�� len ���ֽ�д��˻����������� 

	void write(int b)	
		* д��һ���ֽ�


--------------------------
��̬����/�ֶ�				|
--------------------------

--------------------------
Demo						|
--------------------------
	# �ļ��ֽ�������� Buffer װ����,����������,�������Ч��
	FileOutputStream fileOutputStream = new FileOutputStream("E:\\IOTEST.java");
	BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream,1024);
	bufferedOutputStream.write(new String("������").getBytes());
	bufferedOutputStream.flush();
	bufferedOutputStream.close();
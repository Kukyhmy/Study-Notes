----------------------------------
Process								|
----------------------------------
	# Process ��ʾϵͳ���̵Ľӿ�

		public abstract OutputStream getOutputStream();
			* ���������
		
		public abstract InputStream getInputStream();
			* ����������
		
		public abstract InputStream getErrorStream();
			* �����쳣�����
		
		public abstract int waitFor() throws InterruptedException;
			* �ȴ���ֱ�����̽��������ؽ��̵Ľ���״̬
		
		public boolean waitFor(long timeout, TimeUnit unit)
			* �ȴ��߳̽��������ó�ʱʱ��
		
		public abstract int exitValue();
			* ��ȡ���̽�����״̬
		
		public abstract void destroy();
			* ɱ������
		
		public Process destroyForcibly()
			* ɱ�����̣�ǿ��

		public boolean isAlive()
			* �����Ƿ���


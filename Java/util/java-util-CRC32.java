----------------------------
CRC32						|
----------------------------
	# ѭ��������
		*  �����ݴ洢������ͨѶ����, Ϊ�˱�֤���ݵ���ȷ, ���ò����ü����㷨
	

	# ���캯��
		public CRC32()

	
	# ʵ������
		void update(int b)
		void update(byte[] b, int off, int len)
		void update(byte[] b)
		void update(ByteBuffer buffer)
			* ���У������

		void reset()
			* ����У��

		long getValue()
			* ��ȡ�������crc32ֵ
	
	# demo
		CRC32 crc32 = new CRC32();
		crc32.update(new byte[]{0,0,0,0,0,0});
		long value = crc32.getValue();
		System.out.println(value);
	

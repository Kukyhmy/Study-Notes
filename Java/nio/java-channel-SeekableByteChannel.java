---------------------------------
SeekableByteChannel				 |
---------------------------------
	# ����ָ����ļ�ͨ��,��һ���ӿ�
	# SeekableByteChannel �� FileChannel �ĸ���
	# SeekableByteChannel
	# ʵ����ȡ��ʽ
		SeekableByteChannel newByteChannel(Path path, OpenOption... options);
						* ��ȡ SeekableByteChannel �ܵ�

		SeekableByteChannel newByteChannel(Path path,Set<? extends OpenOption> options,FileAttribute<?>... attrs);
						* ͬ��,������������
	

---------------------------------
SeekableByteChannel-ʵ������	 |
---------------------------------
	 long position();
		* ��ȡָ��
	 SeekableByteChannel position(long newPosition);
		* ����ָ��λ��

	 int read(ByteBuffer dst);
		* ��
	 int write(ByteBuffer src);
		* д

	 long size();
		* �ļ�����

	 SeekableByteChannel truncate(long size);
		* ��ȡһ���ļ�����ȡ�ļ�ʱ���ļ�����ָ�����Ⱥ���Ĳ��ֽ���ɾ��

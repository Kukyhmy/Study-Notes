---------------------------------
FileStore						 |
---------------------------------
	# ����һ������̷���
	# ����
		1,�� Files ʵ����ȡ,������ȡָ����
			FileStore	getFileStore(Path path);

		2,�� FileSystem ��̬������ȡ,��ȡ��������
			Iterable<FileStore>	getFileStores();
			
---------------------------------
FileStore-����					 |
---------------------------------
Object		getAttribute(String attribute);
				# ��ȡָ�����Ƶ�����ֵ
boolean		supportsFileAttributeView(String name)
				# �Ƿ�֧��ָ�����Ƶ�����
boolean		supportsFileAttributeView(Class<? extends FileAttributeView> type)
				# �Ƿ�֧��ָ������/�Զ��������
long		getUnallocatedSpace()
				# ��ȡδ������ֽڴ�С
long		getUsableSpace() 
				# ��ȡ�Ѿ�������ֽڴ�С
long		getTotalSpace()
				# ��ȡ�������ܴ�С
boolean		isReadOnly()
				# �Ƿ���ֻ����
String		type();
				# ��ȡ��������
String		name();
				# ��ȡ��������
FileStoreAttributeView	getFileStoreAttributeView(Class<V> type);
				# ��ȡ���Զ���


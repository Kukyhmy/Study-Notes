--------------------------------
����							|
--------------------------------
	# java.nio.file.attribute
		* ֧�ֺ���ϸ����������,����Ȩ�޵ȵ�
	# ���Ե����ӿ�
	# ��ϵ
		AttributeView
			|-FileAttributeView(�ļ����Խӿ�)
				|-BasicFileAttributeView
					* �����ļ����Խӿ�
					|-PosixFileAttributes
						* �������ļ����Խӿ�
				|-UserDefinedFileAttributeView
					* �û��Զ������Խӿ�
				|-FileOwnerAttributeView
					* �ļ����������Խӿ�
					|-AclFileAttributeView
						* aclȨ�����Խӿ�
			|-FileStoreAttributeView(���̷������Խӿ�)
		
		FileAttribute
			# ���Խӿ�
			# �����󷽷�
				String name();
				T value();

		PosixFilePermission
			# Ȩ������ö����
			# ������Ȩ��
				OWNER_READ,
				OWNER_WRITE,
				OWNER_EXECUTE,
			# ������Ȩ��
				GROUP_READ,
				GROUP_WRITE,
				GROUP_EXECUTE,
			# ������Ȩ��
				OTHERS_READ,
				OTHERS_WRITE,
				OTHERS_EXECUTE;

		PosixFilePermissions
			# Ȩ�����Զ��󹤾���
			# �޷�ʵ��������,���Ǿ�̬����
				Set<PosixFilePermission>	fromString(String perms);
					# ����Linux��Ȩ�������ַ���,������һ�� PosixFilePermission ����
					# "rw-------"
				FileAttribute<Set<PosixFilePermission>>	asFileAttribute(Set<PosixFilePermission> perms);
					# ��һ�� PosixFilePermission ת��Ϊ�ļ����Զ���

--------------------------------
BasicFileAttributeView �ӿڷ���	|
--------------------------------

BasicFileAttributes readAttributes();	
						* ��ȡ�ļ����� 
void				setTimes(FileTime lastModifiedTime,FileTime lastAccessTime, FileTime createTime) 
						* ֱ���������ʱ����ص�����


--------------------------------
BasicFileAttributes				|
--------------------------------
	# �ļ�������������
	# ��ȡ
		 BasicFileAttributes basicFileAttributes = Files.readAttributes(path,BasicFileAttributes.class);
	# ʵ������
		FileTime lastModifiedTime();
		FileTime lastAccessTime();
		FileTime creationTime();
		boolean isRegularFile();
		boolean isDirectory();
		boolean isSymbolicLink();
		boolean isOther();
		long size();
		Object fileKey();


--------------------------------
��ȡ�ļ�����					|
--------------------------------
	Path path = Paths.get("/temp/demo.txt");
	1,ֱ�ӻ�ȡָ��������
		long size = (Long) Files.getAttribute(path, "basic:size", java.nio.file.LinkOption.NOFOLLOW_LINKS);  

	2,���ݽӿ�����,��ȡ����View
		<V extends FileAttributeView> V Files.getFileAttributeView(Path path,Class<V> type,LinkOption... options)
			

--------------------------------
�����ļ�����					|
--------------------------------
	Path path = Paths.get("/temp/demo.txt");
	FileTime fileTime = FileTime.fromMillis(new Date().getTime());  
	Files.setAttribute(path, "basic:lastModifiedTime", fileTime, LinkOption.NOFOLLOW_LINKS);	//����޸�ʱ��
	Files.setAttribute(path, "basic:creationTime", fileTime, LinkOption.NOFOLLOW_LINKS);		//����ʱ��
	Files.setAttribute(path, "basic:lastAccessTime", fileTime, LinkOption.NOFOLLOW_LINKS);		//������ʱ��

--------------------------------
�޸��ļ�����					|
--------------------------------
	long time = System.currentTimeMillis();  
	FileTime fileTime = FileTime.fromMillis(time);  
	BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class); 
	basicFileAttributeView.setTimes(fileTime, fileTime, fileTime); 

---------------------------
Ȩ������					|
---------------------------
	Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-------");  
	FileAttribute<Set<PosixFilePermission>> attrs = PosixFilePermissions.asFileAttribute(perms);
	Files.setPosixFilePermissions(path,attrs)

---------------------------
��ȡACLȨ��					|
---------------------------
	AclFileAttributeView aclview = Files.getFileAttributeView(path, AclFileAttributeView.class);  
	List<AclEntry> acllist = aclview.getAcl();  
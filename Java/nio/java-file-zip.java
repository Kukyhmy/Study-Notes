--------------------------------
����zip�Ĳ���					|
--------------------------------
	# FileSystems ��̬���ȡzip�ļ�ϵͳ����
		FileSystem		FileSystems.newFileSystem(Path path, ClassLoader loader);
							* ʹ�� FileSystems ������,����ѹ������path���� FileSystem ����
							* �ö��������ѹ���ļ��������ļ�
	# Path ����ʵ����ȡzip�ļ�ϵͳ���� 
		FileSystem		getFileSystem();
							* ��ȡ�ļ�ϵͳ����

--------------------------------
��ȡ�ڲ��ļ�					|
--------------------------------
Path	fileSystem.getPath(String filePath);
		* �ļ����·��
		* "/"��ʾѹ�����ĸ�·��

--------------------------------
����zip�ļ�						|
--------------------------------
	 Files.walkFileTree(fileSystem.getPath("/"), new FileVisitor<Path>() {
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			System.out.println(dir);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			System.out.println(file);
			return FileVisitResult.CONTINUE;
		}
		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			return FileVisitResult.CONTINUE;
		}
	});

	

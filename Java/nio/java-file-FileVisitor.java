-----------------------
FileVisitor				|
-----------------------
	# �ļ��ݹ�ӿ�
	# һ�㶼���� Files ��̬����ʹ��
		Path walkFileTree(Path start, FileVisitor<? super Path> visitor);
	# Ԥ����ʵ��
		SimpleFileVisitor
			* ȫ����Ĭ�Ϸ��� CONTINUE
			* ������Ҫ��д��Ҫ�ķ�������

	# ���󷽷�
		FileVisitResult visitFile(Path file, BasicFileAttributes attrs) 
			# ����ʾ���ڷ���ĳ���ļ�
		
		FileVisitResult visitFileFailed(Path file, IOException exc) 
			# ����ʾ����ĳ���ļ���ʱ�������쳣
		
		FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			# �ڷ���һ��Ŀ¼֮ǰִ��,������ǰ�ݹ��Ŀ¼
		
		FileVisitResult postVisitDirectory(Path dir, IOException exc)
			# �ڷ������һ��Ŀ¼֮��ִ��

	# ͨ��ʵ����4���������������������Ӧ�ı���������������Ժ����׵ؿ��������������̣����ڱ����ж�����Ŀ¼�������޸ġ�

-----------------------
FileVisitResult			|
-----------------------
	# �������������������̵���һ��������
	# ö��ֵ
		CONTINUE
			* ��ʾ�������������ı�������
		SKIP_SIBLINGS
			* ��ʾ������ǰĿ¼���ļ����ֵܽڵ�
		SKIP_SUBTREE
			* ��ʾ���ٱ�����ǰĿ¼�е�����
		TERMINATE
			* ��ʾ�������������������̡�


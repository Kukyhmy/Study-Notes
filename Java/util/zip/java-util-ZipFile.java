--------------------
ZipFile
--------------------
	# ѹ���ļ�����
		public class ZipFile implements ZipConstants, Closeable 

	# ���캯��
		ZipFile(File file)
		ZipFile(File file, int mode)
		ZipFile(File file, int mode, Charset charset)
		ZipFile(File file, Charset charset)
		ZipFile(String name)
		ZipFile(String name, Charset charset)
	
	# ʵ������
		String getComment();
		Enumeration<? extends ZipEntry> entries()
		ZipEntry getEntry(String name)
		InputStream getInputStream(ZipEntry entry)
		String getName()
		int size()
		Stream<? extends ZipEntry> stream()

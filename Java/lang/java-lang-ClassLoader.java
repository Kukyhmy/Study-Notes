------------------------
ClassLoader				|
------------------------
	# �������, ��һ��������
	
	# ���캯��
		protected ClassLoader()
		protected ClassLoader(ClassLoader parent)
	
	# ��̬����
		protected static boolean registerAsParallelCapable()
		protected final void resolveClass(Class<?> c) 
		
		public static ClassLoader getSystemClassLoader() 
		public static URL getSystemResource(String name)
		public static InputStream getSystemResourceAsStream(String name)
		public static Enumeration<URL> getSystemResources(String name)
	
	# ʵ������

		@Deprecated
		protected final Class<?> defineClass(byte[] b, int off, int len)
		protected final Class<?> defineClass(String name, byte[] b, int off, int len)
		protected final Class<?> defineClass(String name, byte[] b, int off, int len,ProtectionDomain protectionDomain)
		protected final Class<?> defineClass(String name, java.nio.ByteBuffer b, ProtectionDomain protectionDomain)
			* �����ֽ����ݴ���һ����

		protected Class<?> findClass(String name) 
			* �յķ���, �Լ�ʵ�ֵļ��������鸲д�÷���

		protected Class<?> loadClass(String name, boolean resolve)
		public Class<?> loadClass(String name)
			* ���ط���
				name �෽������
				resolve �Ƿ������ʼ���� 


		protected Package definePackage(String name, String specTitle,String specVersion, String specVendor, String implTitle, String implVersion,String implVendor, URL sealBase)
		protected String findLibrary(String libname) 
		protected final Class<?> findLoadedClass(String name)
		protected URL findResource(String name)
		protected Enumeration<URL> findResources(String name)
		protected final Class<?> findSystemClass(String name)
		protected Object getClassLoadingLock(String className
		protected Package getPackage(String name)
		protected Package[] getPackages()
		
		protected final void setSigners(Class<?> c, Object[] signers)


		public void clearAssertionStatus()
		public final ClassLoader getParent()
		public URL getResource(String name)
		public InputStream getResourceAsStream(String name)
		public Enumeration<URL> getResources(String name) 
		
		public void setClassAssertionStatus(String className, boolean enabled)
		public void setDefaultAssertionStatus(boolean enabled)
		public void setPackageAssertionStatus(String packageName, boolean enabled)

		
		
	



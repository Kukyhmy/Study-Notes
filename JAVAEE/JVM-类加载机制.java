---------------------------
JVM-���к������ȫ����		|
---------------------------
	# �о��ⶫ����ɶ��?
		1,�������˽�JVM���й���
		2,�������˽�Java��̬��(�Ȳ���,��̬����),��߱�̵������
	# java  xxx
		* ����������JVMȥ������
	# ����ػ���
		* JVM��class�ļ����ص��ڴ�,�������ݽ���У������ͳ�ʼ��.�����γ�JVM����ֱ��ʹ�õ�Java���͵Ĺ���
			���� --> ��֤ --> ׼�� --> ���� --> ��ʼ�� --> ʹ�� --> ж��
		* ���·�Ϊ����:���� --> ���� --> ��ʼ��
	# ����
		��class�ļ��ֽ�����ص��ڴ���,������Щ��̬����ת���ɷ������е��������ݽṹ.�ڶ�������һ������������java.lang.Class����,��Ϊ�����������ݵķ������

	# ����
		�Ѷ����ƴ���ϲ���jvm������״̬֮�еĹ���
		* ��֤:ȷ�������ص������jvm�淶,û�а�ȫ���������
		* ׼��:��ʽΪ����(static)�����ڴ沢�����������ʼֵ�Ľ׶�,��Щ�ڴ涼���ڷ������н��з���
		* ����:������������ڷ��������滻Ϊֱ�����õĹ���

	# ��ʼ��
		* ��ʼ���ڵ���ִ���๹�����Ĺ�
	
	# ��ֻ�������õ�ʱ��,�Żᱻ��ʼ��
		1,��������(�ᷢ����ĳ�ʼ��)
			* new һ������
			* ���þ�̬��Ա
			* ʹ�÷�����еĹ�������з��������ʱ��
			* main�������ڵ���,�϶������ȱ����ص�
			* ��ʼ��һ�����ʱ��,�������û�б���ʼ��,���Ȼ��ʼ������

		2,��������(���ᷢ����ĳ�ʼ��)
			* 


---------------------------
JVM-�������				|
---------------------------
	# �����������(Bootstrap Class Loader)
		* ����������java�ĺ��Ŀ��(${java_home}/jre/lib/rt.jar),�� sun.boot.class.path ·���µ�����
		* ��ԭ��������ʵ�ֵ�,�����̳��� java.lang.ClassLoader
		* �����������'��չ��'��'Ӧ�ó����������'.��ָ�����Ǹ��������
		* �ⶫ������C++ʵ�ֵ�
	

	# ��չ�������(Extensions Class Loader)
		* ClassLoader ����
		* sun.misc.Launcher$ExtClassLoader 
		* ��������java����չ��(${java_home}/jre/ext/x*x.jar),�� java.ext.dirs ·���µ�����
	
	# Ӧ�ó����������(Application Class Loader)
		* ClassLoader ����
		* sun.misc.Launcher$AppClassLoader
		* ������javaӦ�õ���·��(classpath,java.class.path)
		* һ��javaӦ����,�����������ص�
	
	# �Զ����������
		* ֱ�Ӽ̳� java.lang.ClassLoader 
		* ʵ���Լ����������,�Ա�����һЩ���������
	
---------------------------
JVM-java.lang.ClassLoader	|
---------------------------
	# ����չ���������Ӧ�ó��������,�Լ��Զ�����������ĸ���
	# ����������Ǹ���һ���������,�ҵ����ֽڴ���,�����һ��java��,Ҳ���� java.lang.Class ��ʵ��
	# ClassLoader ���������javaӦ���������Դ,��,ͼ���ļ��������ļ���
	# ����
		getParent();		
			* ���ظ���ĸ��������,˭���ص���,�Ҿͷ���˭
		loadClass(String name);
			* ����ָ�����Ƶ���,���صĽ���� java.lang.Class ʵ��
		findClass(String name);
			* ����ָ�����Ƶ���,���صĽ���� java.lang.Class ʵ��
		findLoadedClass(String name);
			* �����Ѿ����ع���ָ�����Ƶ���,���� java.lang.Class ʵ��
		defineClass(String name,byte bytes[],int off,int len);
			* ���ֽ������е�����ת��ΪJAVA��,���ؽ���� java.lang.Class ʵ��
			* �÷�����������д, final ����
		resolveClass(Class<?> clazz);
			* ����ָ����JAVA��
	
	# ί�л���
		* ... ... 

---------------------------
JVM-�Զ����������			|
---------------------------
	# ʵ�ֵ�˼·/����
		0,�̳�
			* �̳� ClassLoader
		1,���
			* ���ȼ������������Ƿ��Ѿ����������������ص������ռ�����
			* ����Ѿ�����,ֱ�ӷ���
		2,ί��
			* ί�ɼ�����������������,�������������ܹ����,�򷵻ظ�����������ص�ʵ��
		3,findClass
			* ���ñ���ĵ�findClass����,��ͼ��ȡ��Ӧ���ֽ���
			* �ɹ���ȡ,�����defineClass�������͵�������
			* ��ȡʧ��,�򷵻��쳣��loadClass,loadClass�׳��쳣,��ֹ���ع���

	# ͬһ����,�����������������.JVM����Ϊ�ǲ�ͬ����

	# �ļ��������
		/**
		 * Created by KevinBlandy on 2017/1/25 15:52
		 * �Զ����������,ʵ�� ClassLoader��
		 */
		public class MyClassLoader extends ClassLoader{
			/**
			 * ��·��
			 */
			private String rootDir;
			public MyClassLoader(String rootDir){
				this.rootDir = rootDir;
			}

			/**
			 * ��д findClass����
			 * @param name
			 * @return
			 * @throws ClassNotFoundException
			 */
			@Override
			protected Class<?> findClass(String name)throws ClassNotFoundException{
				/**
				 * 1,�ȼ��������Ƿ񱻼���
				 */
				Class<?> clazz = super.findLoadedClass(name);
				if(null != clazz){
					return clazz;       //�Ѿ�������,ֱ�ӷ���
				}
				/**
				 * 2,ί�и�����������м���
				 */
				ClassLoader parent = this.getParent();
				clazz = parent.loadClass(name);
				if(null != clazz){
					return clazz;       //�������OK,ֱ�ӷ���
				}
				/**
				 * 3,��ȡ�ļ�,ת��Ϊ�ֽ�����
				 */
				byte[] classBytes = loadLoclaClass(name);
				if(null == classBytes){
					//û�гɹ�����,�׳��쳣
					throw new ClassNotFoundException(name+"��δ�ҵ�");
				}
				//�ҵ�OK,���м��ز���
				clazz = super.defineClass(name,classBytes,0,classBytes.length);
				return clazz;
			}
			/**
			 * ���ر���Class�ֽ���
			 * @return
			 */
			private byte[] loadLoclaClass(String classNme){
				BufferedInputStream in;
				ByteArrayOutputStream byteArrayOutputStream;
				String path = rootDir + "/" + classNme.replace(".","/") + ".class";
				try {
					in = new BufferedInputStream(new FileInputStream(path));
					byte[] bytes = new byte[1024];
					int len = 0;
					byteArrayOutputStream = new ByteArrayOutputStream();
					while ((len = in.read(bytes)) != -1){
						byteArrayOutputStream.write(bytes,0,len);
					}
					return byteArrayOutputStream.toByteArray();
				}catch (Exception e){
					return null;
				}finally {
					//�ر���
				}
			}
		}

	# �����������
		
	# ���ܽ����������(ȡ��,DES�ԳƼ��ܽ���)




	



			

		
	
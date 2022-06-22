--------------------
JAVA-��̬����		|
--------------------
	# ��ͳ������JAVA����ķ�ʽ
		1,��дԴ����
		2,����Դ����
		3,����main������ʼִ�г���
	# ʵ����,JAVA�ṩ��API���ڶ�̬����Ĺ���.
	# ��̬�������������
		1,ͨ��Runtime����JAVA,�����µĽ���ȥ����
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec("javac -cp -D:/MyJava/ HelloWorld.java");
		2,ͨ��JavaCompiler��̬�Ľ��б���(6.0�Ժ�������¹���)
public static int compileFile(String sourceFile){
	//ģ��JAVAԴ�ļ���ַ
	sourceFile = "E:/MyJava/HelloWorld.java";
	//��ȡ����������
	JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	/*	ִ�б������
		��һ������inputStream	:ΪJAVA�������ṩ����
		�ڶ�������outputStream	:�õ�JAVA�������������Ϣ
		����������OutputStream	:���ձ������Ĵ�����Ϣ
		���ĸ�����:�ɱ����(String[]),�ܴ���һ�����߶��JAVAԴ�ļ���·��
		����ֵ:0��ʾ�ɹ�����,��0��ʾ����ʧ��
	*/
	int result = compiler.run(null,	System.out, System.out, sourceFile);
	if(result == 0){
		System.out.println("����ɹ�");
	}else{
		System.out.println("����ʧ��");
	}
	return result;
}

--------------------
JAVA-��̬����		|
--------------------
	# �����Ǹ�����,ͨ��JAVA����ȥ����JAVA��class�ļ�
	# ���ְ취
		1,ͨ��RuntimeAPI�����µ��߳�ȥִ��
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec("java -cp -D:/MyJava/ HelloWorld.java");
		2,ͨ������,���б���õ���
			public static void run(String dir,String classFile)throws Exception{
				//Ŀ��Ŀ¼
				dir = "E:/MyJava/";
				//Ŀ��class�ļ�
				classFile = "HelloWorld";
				//����Ŀ¼url��
				URL[] urls = new URL[]{new URL("file:/"+dir)};
				//��ȡurl�������
				URLClassLoader classLoader = new URLClassLoader(urls);
				//����ָ����class�ļ�
				Class clazz = classLoader.loadClass(classFile);
				//��ȡ��main����
				Method mainMethod = clazz.getMethod("main", String[].class);
				/*
					ִ��main����,�����ֿշ��������
					��Ϊmain������static����,���Կ��Բ��ô��ݶ���
					# ǿ��ת����ԭ��
						* �ɱ������jdk5֮��Ķ���
						* ���˵�������String[]ת��ΪObject�Ļ�
						* String[]�����ÿ������,���ᱻ����һ���µ�String[]��main��������
						* ��main�����Ĳ���ֻ��һ��
				*/
				mainMethod.invoke(null, (Object)new String[]{});
			}
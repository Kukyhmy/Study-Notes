-------------------
��汾����jar��
-------------------
	# �� META-INF Ŀ¼�´������ļ���:version
		META-INF
			|-version
				|-8
				|-9
				|-10
		
		* ��versionĿ¼���½� "�汾Ŀ¼", ֧��ʲô�汾���½�һ��ʲô�汾��Ŀ¼

	# META-INF Ŀ¼�� MANIFEST.MF �ļ�������һ������
		Multi-Release: true

-------------------
���
-------------------
	#  ���벻ͬ�汾��Դ��
		javac -d java8 --release 8 src/main/java8/io/java/tester/*.java		*/
		javac -d java9 --release 9 src/main/java9/io/java/tester/*.java		*/
		
		-d			ָ����ű�������Ŀ¼����
		--release	ָ������İ汾��
		���ָ����ǰ����汾��Java�������ڰ�

	
	# ������汾jar��
		
		jar -c --main-class=io.java.Mai -f test.jar -C java8 . --release 9 -C java9.

		--main-class			����ָ��main������
		-f						ָ��jar������
		-C						ָ������õ�javaĿ¼
		--release 9 -C java9	����һ���汾�����jar��ָ���汾���Լ���Ŀ¼
	



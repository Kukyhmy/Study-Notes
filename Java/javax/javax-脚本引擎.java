--------------------
JAVA-�ű�����		|
--------------------
	# ��ʵ������JAVA������ִ��JavaScript�Ĵ���
	# JAVAֻ���ṩ������ӿ�,����û�ṩʵ��,�������Ľű������Լ���дʵ��.
	# ����
		1,�ͻ��˴�����һ���ַ���
			"3 * 4 / 2 + 6 -5"
		2,���ַ���Ӧ�����ڼ������Ľ��
		3,�����ʹ��JAVA�����,�ͱȽϵ��鷳
		4,�����JavaScript�Ǿͼ� eval();�����͸㶨

	# �ű�������JDK6.0�Ժ���ӵ��¹���
		* ��ʵ����,JAVAӦ�ó������ͨ��һ�׹̶��Ľӿ���'���ֽű�����'����
		* �Ӷ��ﵽ��Javaƽ̨�ϵ��ø��ֽű����Ե�Ŀ��
		* Java�ű�API����ͨJavaƽ̨�ýű����Ե�����
		* ���԰�һЩ��������ҵ���߼������ű����Դ���,��Ҳ�������˿���Ч��
		* ��ʵ���ǿ�����java������ִ�������Ľű�����
		* 6.0��javascript-->Rhino����ӵ���JDK
	
	# Java�ű�APIΪ�������ṩ��N�๦��
		* ��ȡ�ű���������,ͨ���ű��������нű����������н��.
		* ���ĵĽӿ� : ScriptEngineFactory
			1,ע��:�ǽӿ�,JAVA����ʹ�ø��ֲ�ͬ��ʵ��,�Ӷ�����js,groovy,python�Ƚű�
			2,JavasScript  -->  RhinoEngineFactory
			3,Rhino ��һ��ʹ��java���Ա�д��javascript���� (jdk.nashorn.api.scripting.NashornScriptEngine)
				* Rhino <<JavaScriptȨ��ָ��>>,�Ȿ��������Rhino

	# ��ȡ�ű�����Manager����
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

	# �鿴֧�ֵĽű�����
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		for (ScriptEngineFactory scriptEngineFactory : scriptEngineManager.getEngineFactories()) {
			System.out.println(scriptEngineFactory.getEngineName() + ":" + scriptEngineFactory.getEngineVersion()); // ִ���������ƺͰ汾��
			ScriptEngine scriptEngine = scriptEngineFactory.getScriptEngine(); // ��ȡ��ִ������
		}
			
	# ��ȡָ�����ƵĽű�����
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
	
	# �����Ը���mineType,��չ����apiȥ��ȡһ��ִ������
		scriptEngineManager.getEngineByMimeType("text/javascript");
		scriptEngineManager.getEngineByExtension("js");

	
	# �򵥵�ʹ��
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");

		scriptEngine.put("name", "KevinBlandy");

		Object result = scriptEngine.eval("\"Hello \" + name");

		System.out.println(result);	// Hello KevinBlandy
	
	

	# JDK11 ��ʼ, �������������
		@Deprecated(since="11", forRemoval=true)
		public final class NashornScriptEngine extends AbstractScriptEngine implements Compilable, Invocable
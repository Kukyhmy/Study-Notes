--------------------
JAVAHTTP-GET		|
--------------------
	public static String getByJava() throws Exception{
		//��������
		StringBuilder sb = new StringBuilder();
		//url
		String youdao = "http://www.baidu.com";
		//��������·��
		URL url = new URL(youdao);
		/*
			����ת��Ϊ:HttpURLConnection
			�Ϳ��Խ��л�ȡ��Ӧ״̬��Ȳ���
		*/
		URLConnection connection = url.openConnection();

		connection.connect();
		//��ݲ���  URLConnection connection = url.openStream();
		//��ȡ��������������,�ֽ���ת��Ϊ�ַ���,װ��ΪBufferdReader
		BufferedReader reader  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = null;
		//ѭ����ȡ��Ӧ����
		while((line = reader.readLine()) != null){
			sb.append(line);
		}
		return sb.toString();
	}
--------------------
JAVAHTTP-POST		|
--------------------
	public static String postByJava() throws Exception{
		//��������
		StringBuilder sb = new StringBuilder();
		/*
			POST�ύ��ʱ��,��������ֱ��д�ں���
		*/
		//׼����ȡ��
		//׼��������
		URL url = new URL("http://www.kevinblandy.com");
		/*
			ע����,����ʹ��POST��ʱ��,ʹ�õ���:HttpURLConnection
			* ������һ��������,�̳��� URLConnection
			* ������Ҫǿת��ΪHttpURLConnection
		*/
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		//���õ�ǰ���ӿ��Դ������ȡ����
		connection.setDoInput(true);
		//POST�Ļ�,Ҫ����Ϊtrue�ſ������������ύ�������
		connection.setDoOutput(true);

		//��������ͷ
		connection.addRequestProperty("encoding", "utf-8");
		//��������ʽ
		connection.setRequestMethod("POST");

		// ����������������ӣ���δ��������
		connection.connect();


		//��ȡout��,������������������
		BufferedWriter writer  = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
		/*
			����һ���Ե�д��N������,��ʽ���ǳ�����ύ��ʽ
		*/
		writer.write("key=value&key=value&key=value");
		//ˢ��
		writer.flush();
		//��ȡ����������Ӧ��״̬��
		int code = connection.getResponseCode();
		//��ȡin��,���ڻ�ȡ����������Ӧ
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line = null;
		while((line = reader.readLine()) != null){
			//�����ȡ��������,ÿ�ζ�ȡһ��
			sb.append(line);
		}
		return sb.toString();
	}



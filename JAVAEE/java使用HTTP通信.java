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
		//���÷������������-�����ʽ
		connection.addRequestProperty("encoding", "utf-8");
		//���õ�ǰ���ӿ��Դ������ȡ����
		connection.setDoInput(true);
		//POST�Ļ�,Ҫ����Ϊtrue�ſ������������ύ�������
		connection.setDoOutput(true);
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

-------------------------------------------------------------------------


--------------------
HTTPClient-GET		|
--------------------
	* ������Apache������
	public static String htppClientGet()throws Exception{
		/*
			����URL,get����,����ֱ����Ӳ���
			��Ҫע��ľ���,��������Ǵ����ĵĻ�,��Ҫע��url����.����򵥾Ͳ��ض�˵��
		*/
		String url = "http://www.kevinblandy.com/doing?pageCode=2";
		/*
			����HttpClient
			ע��,������HttpClient,����̬����:HttpClients
			����,һ����apache���µĶ���,��Ϊsun����Ҳ����ô������
		*/
		HttpClient client = HttpClients.createDefault();
		//ͨ���ַ���url����get����
		HttpGet get = new HttpGet(url);
		/*
			ͨ��HttpClient����,����get����,��ȡ����������Ӧ����HttpResponse
		*/
		HttpResponse response = client.execute(get);
		/*
			ͨ��response,���ǿ��Ի�ȡ��N�ණ��
			* ��Ӧͷ
			* ��ַ
			* ...
			* Entity - ��ʾ���Ķ���
		*/
		HttpEntity entity = response.getEntity();
		/*
			ʹ��Apcahe���µ�EntityUtils�����Ķ���תΪ�ַ���
		 */
		String result = EntityUtils.toString(entity,"utf-8");
		/*
			�ͷ�����	
		*/
		get.releaseConnection();
		return result;
	}

	------��ȡ���е���Ӧͷ

	Header[] hreaders = response.getAllHeaders();
	for(Header head : hreaders){
		//��ȡ�����е���Ӧͷ
		System.out.println(head.getName()+":"+head.getValue());
	}
--------------------
HTTPClient-POST		|
--------------------
	public static String htppClientPost()throws Exception{
		//�������ӵ�url
		String url = "http://www.kevinblandy.com/doing";
		//����HttpClient
		HttpClient client = HttpClients.createDefault();
		//����post�������
		HttpPost post = new HttpPost(url);
		/*
			����һ��BasicNameValuePair���͵ļ���
			BasicNameValuePair�����ʾ�ύ���������������
		*/
		List<NameValuePair> params = new ArrayList<NameValuePair>();  
		/*
			���������N��,ͨ�����췽������������BasicNameValuePair����
			BasicNameValuePair����������Ȼ���� NameValuePair ������
		*/
		params.add(new BasicNameValuePair("pageCode", "1"));  
        /*
        	post�������,����һ��UrlEncodedFormEntity����
        	�ö���ͨ�����캯��ע�뼯��.��������Զ��Ķ���url����url����
        */
        post.setEntity(new UrlEncodedFormEntity(params)); 
		//��ȡ��������Ӧ
		HttpResponse response = client.execute(post);
		//����Ӧ�л�ȡ����
		HttpEntity entity = response.getEntity();
		//ͨ��EntityUtils������ת��Ϊutf-8��ʽ���ַ���
		String result = EntityUtils.toString(entity, "utf-8");
		return result;
	}

	------����һ����Ӳ����ķ�ʽ

	** ��д��,�õ�ʱ��ٶȰ�



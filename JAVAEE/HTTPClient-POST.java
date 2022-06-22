---------------------
����POST����			 |
---------------------	
	 public static void main(String[] args) throws Exception {
        // ����Httpclient����			�������
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // ����http POST����			�����ַ
        HttpPost httpPost = new HttpPost("http://www.oschina.net/");
        CloseableHttpResponse response = null;
        try {
            // ִ������
            response = httpclient.execute(httpPost);
            // �жϷ���״̬�Ƿ�Ϊ200
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
    }
---------------------
����POST����			|
---------------------
	public static void main(String[] args) throws Exception {
        // ����Httpclient����
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // ����http POST����
        HttpPost httpPost = new HttpPost("http://www.oschina.net/search");
        // ����2��post������һ����scope��һ����q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("scope", "project"));
        parameters.add(new BasicNameValuePair("q", "java"));
        // ����һ��form��ʽ��ʵ��
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters,"utf-8");
        // ������ʵ�����õ�httpPost������
        httpPost.setEntity(formEntity);
        CloseableHttpResponse response = null;
        try {
            // ִ������
            response = httpclient.execute(httpPost);
            // �жϷ���״̬�Ƿ�Ϊ200
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
    }


---------------------
����JSON��POST����		|
---------------------
	public HttpResult doPostJson(String url,String json) throws ClientProtocolException, IOException{
        // ����http POST����
        HttpPost httpPost = new HttpPost(url);
        
        httpPost.setConfig(this.config);
        if(json != null){
			/**
				JSON�ı��ʾ����ַ���,��������ʹ��: StringEntity
			*/
			StringEntity entity = new StringEntity(json,"utf-8");
			//��������ͷJSON
			entity.setContentType("application/json");
        	httpPost.setEntity(entity);
        }
        CloseableHttpResponse response = null;
        try {
            // ִ������
            response = httpClient.execute(httpPost);
            HttpResult result = new HttpResult(
            			response.getStatusLine().getStatusCode(),
            			EntityUtils.toString(response.getEntity(),"utf-8"));
            return result;
        } finally {
            if (response != null) {
                response.close();
            }
        }
	}
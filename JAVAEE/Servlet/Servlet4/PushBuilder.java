-------------------
PushBuilder			|
-------------------	
	# ����
		PushBuilder pushBuilder = request.newPushBuilder();

		* ������������Ͳ�����,newPushBuilder() ������ null 
		* ����ͻ���û��ʹ�ð�ȫ����,����������Ҳ����������
	
	# demo
		// push ��ǰҳ����Ҫ�ľ�̬��Դ
		PushBuilder pushBuilder = req.newPushBuilder();
		if (pushBuilder != null) {
			pushBuilder.path("static/images/index.jpg").push();
			pushBuilder.path("static/css/index.css").push();
			pushBuilder.path("static/js/index.js").push();
		}

	# �ӿڷ���
		public PushBuilder method(String method);

		public PushBuilder queryString(String queryString);

		public PushBuilder sessionId(String sessionId);
		
		public PushBuilder setHeader(String name, String value);
	 
		public PushBuilder addHeader(String name, String value);

		public PushBuilder removeHeader(String name);

		public PushBuilder path(String path);

		public void push();
			* push() �����Ƿ�������,��������

		public String getMethod();

		public String getQueryString();

		public String getSessionId();

		public Set<String> getHeaderNames();

		public String getHeader(String name);
	  
		public String getPath();


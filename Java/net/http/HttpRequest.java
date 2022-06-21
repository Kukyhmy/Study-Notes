---------------------------
HttpRequest
---------------------------
	# ��ʾһ�� http ����, ������

	# ��̬����
		HttpRequest.Builder newBuilder(URI uri) 
		HttpRequest.Builder newBuilder()

	# ʵ������
		abstract Optional<BodyPublisher> bodyPublisher()
		abstract String method();
		abstract Optional<Duration> timeout();
			* �����ָ���ĳ�ʱʱ����δ�յ���Ӧ, ����׳�HttpTimeoutException�쳣��

		abstract boolean expectContinue();
			* HTTP������ܰ�����Ϊexpect���ײ��ֶ�, ��ֵΪ "100-Continue",
			* ��������˴��ײ��ֶ�, ��ͻ���ֻ�������������ͷ�ļ�, ����Ԥ�Ʒ����������ش�����Ӧ��100-Continue��Ӧ
			* �յ�����Ӧ��, �ͻ��˽��������巢�͵�������, �ڿͻ��˷���ʵ��������֮ǰ, �ͻ���ʹ�ô˼��������������Ƿ���Ի���������ײ���������
			
			* Ĭ�������, ���ײ��ֶ�δ����, ��Ҫ�������󹹽�����expectContinue(true)���������ô˹���
			* ��ע��, �������󹹽�����header("expect", "100-Continue")�����������ô˹���, ����ʹ��expectContinue(true)����������
				
		abstract URI uri();
		abstract Optional<HttpClient.Version> version();
		abstract HttpHeaders headers();
		
	
	# Request �����ԻḲ�� HttpClient ����ͬ������
		HttpClient.Version
	
---------------------------
Builder
---------------------------
	# Builder������ʽ
		Builder uri(URI uri);
		Builder expectContinue(boolean enable);
		Builder version(HttpClient.Version version);
		Builder header(String name, String value);
		Builder headers(String... headers);
			* ��������ͷ

		Builder timeout(Duration duration);
		Builder setHeader(String name, String value);

		Builder GET();
		Builder POST(BodyPublisher bodyPublisher);
		Builder PUT(BodyPublisher bodyPublisher);
		Builder DELETE();

		Builder method(String method, BodyPublisher bodyPublisher);
		
		HttpRequest build();

		Builder copy();
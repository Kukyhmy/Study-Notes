�첽����
һ,�����첽����
	1,ʲô���첽����,���ǵ�?ԭ���ڷ�������û������Ӧ֮ǰ,�ͻ����������������Ӧ������,ֻ����Ӧ������ʱ�������������ʾ���
	2,�첽���������,�ڷ�������ʼ��Ӧ��,������Ϳ��Կ�����Ӧ����,���õȴ���������Ӧ����

��,ʵ���첽�Ĳ���
1,�õ�AsyncContext,�������첽������
	AsyncContext ac = request.startAsync(request,response);
2,��������һ��Runnable����(��˵����ʶ),������
	final AsyncContext ac = request.startAsync(request,response);
	ac.start(new Runnable()//�����ڲ���
	{
		public void run() 
		{
			//�첽ִ�еĴ���,��ʵҲ���Ƕ��̴߳���
		}
		ac.complete();
	});
	* ac.complete();�������
		> ����������Ǹ��߷�����,���ǵ��첽�����Ѿ�������,����Թرո��ͻ��˵�������
		> ��Ϊ����߳�������������,Tomca���̸߳���û�취֪�����ǲ����Ѿ����������,ֻ��һֱ�ȵȵ�,һֱ�����ӳ�ʱ�ŶϿ�,
		> ��Ҳ��Ϊʲô,�������Ѿ���Ӧ���,�����ǵ��������������״̬,���ڹ¶�����ת!
	* ע��,�����������Ӧ����,�����п��ܻᵼ���첽ʧ��
		> response.setContentType("text/html;charset=utf-8");//��������ñ���,���������첽ʧ��
		> !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		> ����һ�Ÿ�̾��,����������,�ⶫ����������Ļ�ʧ��,���Ѿ��Թ���... ...
		> ��ʵ�����Ҫ�Ĳ��Ǳ���,����Ҫ������text/html
	* �����첽����,IE�и�ë��
		> ��������������С��512KB��ʱ��,���Ͳ�������ʾ,�������,���㷢����,�͸���һ��Ū����
		> �ܶ��˾���ΪIE�첽������,��ʵ����ֻҪ�ڳ����ڲ�,�ȸ���512KB���������ݸ�������ͺ���,���������ܹ��첽��
		> �ⶫ����,ֻ��Ӱ�����.ʵ����Ŀ����������,����ô�����첽��,��512KB��û��?

3,�ǵø�Servlet��ͷ�����һ��ע��
	@WebServlet(asyncSupported=true)
	> ��ע��ֵ==true,��ô��ҳ�����ʹ������첽����

	@WebFilter(asyncSupported=true)
	> ���ʹ����Filter,ҲҪ��Ӹ�ע������

----------------------
AsyncContext	      |
----------------------
	# �ӿڷ���
		ServletRequest getRequest();
		ServletResponse getResponse();
		boolean hasOriginalRequestAndResponse();

		void addListener(AsyncListener listener); 
		void addListener(AsyncListener listener,ServletRequest servletRequest,ServletResponse servletResponse);
			* ��Ӽ�����

		<T extends AsyncListener> T createListener(Class<T> clazz);
			

		void complete();
			* ������
		

		void dispatch();
		void dispatch(String path);
		void dispatch(ServletContext context, String path);

		long getTimeout();

		void setTimeout(long timeout);
			*  ���úͻ�ȡ��ʱʱ��

		void start(Runnable run);

----------------------
AsyncEvent			 |
----------------------
	# �¼�
		 AsyncContext getAsyncContext()
		 ServletRequest getSuppliedRequest()
		 ServletResponse getSuppliedResponse()
		 Throwable getThrowable()


----------------------
Demo				 |
----------------------
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");//��������ñ���,���������첽ʧ��
		AsyncContext asyncContext = req.startAsync(req, resp);
		asyncContext.addListener(new AsyncListener() {
			@Override
			public void onTimeout(AsyncEvent event) throws IOException {
				System.out.println("��ʱ:" + event);
			}
			@Override
			public void onStartAsync(AsyncEvent event) throws IOException {
				System.out.println("��ʼ�첽���:" + event);
			}
			@Override
			public void onError(AsyncEvent event) throws IOException {
				System.out.println("�쳣:" + event);
			}
			@Override
			public void onComplete(AsyncEvent event) throws IOException {
				System.out.println("ִ�����:" + event);
			}
		});
		asyncContext.start(() -> {
			for(int x = 0 ;x < 10 ; x++) {
				try {
					asyncContext.getResponse().getWriter().write(x +  "<br/>");
					asyncContext.getResponse().getWriter().flush();
					Thread.sleep(1000);
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			asyncContext.complete();
		});
	}
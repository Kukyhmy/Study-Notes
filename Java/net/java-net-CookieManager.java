-----------------------
CookieManager
-----------------------
	# Cookie������
		CookieManager extends CookieHandler
	
	# ���췽��
		CookieManager() 
		CookieManager(CookieStore store, CookiePolicy cookiePolicy)
	
	# ʵ������
		void setCookiePolicy(CookiePolicy cookiePolicy)
		CookieStore getCookieStore()

		Map<String, List<String>> get(URI uri, Map<String, List<String>> requestHeaders)

		void put(URI uri, Map<String, List<String>> responseHeaders)
	

-----------------------
CookieStore
-----------------------
	# Cookie�洢���ʵĽӿ�

	# ���󷽷�
		void add(URI uri, HttpCookie cookie);
		List<HttpCookie> get(URI uri);
		List<HttpCookie> getCookies();
		List<URI> getURIs();
		boolean remove(URI uri, HttpCookie cookie);
		boolean removeAll();


-----------------------
CookiePolicy
-----------------------
	# cookie�Ĳ��Խӿ�, ���������Ƿ�Ҫ�ύcookie
	
	# ���󷽷�
		boolean shouldAccept(URI uri, HttpCookie cookie);

	
	# ��̬ʵ��
		static final CookiePolicy ACCEPT_ALL
		static final CookiePolicy ACCEPT_NONE
		static final CookiePolicy ACCEPT_ORIGINAL_SERVER

	
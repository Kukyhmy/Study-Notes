--------------------------
Authenticator
--------------------------
	# �����֤��
	
	# ��̬����
		static Authenticator getDefault()

		static PasswordAuthentication requestPasswordAuthentication(
                                            InetAddress addr,
                                            int port,
                                            String protocol,
                                            String prompt,
                                            String scheme)
		
		static PasswordAuthentication requestPasswordAuthentication(
                                            String host,
                                            InetAddress addr,
                                            int port,
                                            String protocol,
                                            String prompt,
                                            String scheme)
		
		static PasswordAuthentication requestPasswordAuthentication(
                                    String host,
                                    InetAddress addr,
                                    int port,
                                    String protocol,
                                    String prompt,
                                    String scheme,
                                    URL url,
                                    RequestorType reqType)
		


		static PasswordAuthentication requestPasswordAuthentication(
                                    Authenticator authenticator,
                                    String host,
                                    InetAddress addr,
                                    int port,
                                    String protocol,
                                    String prompt,
                                    String scheme,
                                    URL url,
                                    RequestorType reqType)
			
	
	# ʵ������
		public PasswordAuthentication requestPasswordAuthenticationInstance(String host,
                                          InetAddress addr,
                                          int port,
                                          String protocol,
                                          String prompt,
                                          String scheme,
                                          URL url,
                                          RequestorType reqType)
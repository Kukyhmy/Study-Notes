------------------------
Logger					|
------------------------
	* jdk�����logger	
	* ��ϵͼ��(��python���)
		logger				��־��¼��
			|-handler		������
				|formatter	��ʽ����
			|filter			������

	* �漰���
		Logger
			* ��־��¼��
		LogRecord
			* һ����־����,��������Ϣ,ʱ���,��.�ȵ���־����Ϣ
		Filter
			* ��־������,������Щ��־Ҫ���
		Formatter
			* ��־��ʽ��,����Լ���Ҫ����־��Ϣ
		Handler
			* ��־������,���ڿ�����־�����

------------------------
Logger-��̬����/����	|
------------------------
	GLOBAL_LOGGER_NAME = "global"

	Logger getGlobal()
		* ��ȡȫ�ֵ�һ����־��¼������

	Logger getAnonymousLogger()
	Logger getAnonymousLogger(String resourceBundleName)
		
	Logger getLogger(String name) 
		* ��ȡָ�����Ƶ���־��¼��

	Logger getLogger(String name, String resourceBundleName)
		* ��ȡָ�����Ƶ���־��¼��,����ָ����Դ��(���ʻ�)������

------------------------
Logger-ʵ������/����	|
------------------------
	void setLevel(Level newLevel)
		* �����ռǼ���,�������� Level ʵ��
		* ����һ����־����
			
			Level.SEVERE;
			Level.WARNING;
			Level.INFO;
			Level.CONFIG;
			Level.FINE;
			Level.FINER;
			Level.FINEST;
			Level.ALL;
			Level.OFF;
			
		* Ҳ����ʹ�� Level �ľ�̬ parse(String name) api����ȡָ�����Ƶ���־����ʵ��
	
		void fine("");
        void finer("");
        void finest("");
        void config("");
        void info("");
        void severe("");
        void warning("");
			* ����api��ʾ��ͬ�������־���
		
		void log(Level level, String msg)
			* ��ָ������־���������־
		
		void log(LogRecord record)
			* ����־��¼���������ʽ��¼һ����־
			* LogRecord ����/����
				record.getLevel();			//��ȡ��־����
                record.getMessage();		//��ȡ��־����
                record.getMillis();			//��ȡʱ���
                record.getClass();			
				record.getSequenceNumber();	//��ȡ��־��Ψһ���к�
                record.getParameters();
                record.getLoggerName();
                record.getSourceClassName();
		
		throwing(String sourceClass, String sourceMethod, Throwable thrown)
			* һ�������� catch �ڲ�,�����쳣��ʱ�������־��¼

		void setUseParentHandlers(boolean useParentHandlers)
			* �Ƿ�ʹ�ø���logger��hanlder������
		
		void addHandler(Handler handler)
			* ���һ��hanlder��logger
			* handler Ĭ�����һ�� ConsoleHandler ,Ҳ������ System.err ����ʽ�������Ļ
			* ����ͨ����չ Handler/StreamHandler �����Զ��崦����
			* ϵͳԤ�����handler
				FileHandler
					* new FileHandler("c:\\log.xml")
					* ������־��ָ���ļ���handler,��xml��ʽ����
					* FileHandler ʵ���ķ���/����
						void setEncoding(String encoding)
							* �����ַ���
						void setFormatter(Formatter newFormatter)
							* ����һ����־��ʽ��formatter,�����ɲ���ʽ����־
							* Ҳ�����Լ���չ Formatter ��
							* Formatter ֻ��ʵ��һ������,��һ����־��¼����,ת��Ϊ String
								@Override
								public String format(LogRecord record) {
									return null;
								}

						void publish(LogRecord record)
							* ���һ����־��¼����
			
		void setFilter(Filter newFilter) 
			* ����һ��������
			* Filter ��һ���ӿ�,ֻ��һ�����󷽷�,�����ж��Ƿ�Ҫ��¼��־
				public boolean isLoggable(LogRecord record);
		


-----------------------------
ProcessBuilder				 |
-----------------------------
	# �ӽ������񹹽�������
	# ���캯��
		public ProcessBuilder(String... command)
		public ProcessBuilder(List<String> command)
		
	
-----------------------------
ProcessBuilder				 |
-----------------------------

-----------------------------
ProcessBuilder - ʵ������				 |
-----------------------------
	public ProcessBuilder command(String... command)	
	public ProcessBuilder command(List<String> command)
	public List<String> command()
		* ����/����ִ������
		* ���� this

	public Map<String,String> environment() 

	public File directory()
	public ProcessBuilder directory(File directory)
		* ����/���ع���Ŀ¼

	Process start() throws Exception
		* ִ��
	
	public ProcessBuilder redirectInput(Redirect source) 
	public ProcessBuilder redirectOutput(Redirect destination) 
	public ProcessBuilder redirectError(Redirect destination)
		* ����Ĭ��ֵΪfalse���ӽ��̵ı�׼����ʹ�����������͸�����������������Щ������ͨ�� Process.getInputStream() �� Process.getErrorStream() ���������ʡ�
		* �Ƿ�ϲ���׼����ͱ�׼�����trueΪ�ϲ���falseΪ����


	public ProcessBuilder redirectInput(File file)
	public ProcessBuilder redirectOutput(File file)
	public ProcessBuilder redirectError(File file)

	public Redirect redirectInput()
	public Redirect redirectOutput()
	public Redirect redirectError()

	public ProcessBuilder inheritIO()

	public boolean redirectErrorStream() 
	public ProcessBuilder redirectErrorStream(boolean redirectErrorStream) 
	public Process start() throws IOException 



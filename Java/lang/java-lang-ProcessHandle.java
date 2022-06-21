---------------------------
java9���½ӿ�
---------------------------
	
	# ��̬����
		public static Optional<ProcessHandle> of(long pid);
		public static ProcessHandle current();

	# ���󷽷�
		long pid();
		Optional<ProcessHandle> parent();
		Stream<ProcessHandle> children();
		Stream<ProcessHandle> descendants();
		Info info();
			* ������ص���Ϣ�ӿ�
				Optional<String> command();
				Optional<String> commandLine();
				Optional<String[]> arguments();
				Optional<Instant> startInstant();
				Optional<Duration> totalCpuDuration();
				Optional<String> user();

		CompletableFuture<ProcessHandle> onExit();
		boolean supportsNormalTermination();
		boolean destroy();
		boolean destroyForcibly();
		boolean isAlive();

	
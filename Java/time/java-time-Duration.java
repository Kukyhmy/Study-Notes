----------------------------
Duration					|
----------------------------
	# ���ڼ�������ʱ��֮��ļ��
	# ����(ʹ��Duration��̬����)
		Duration between(Instant instant1,Instant instant2);
		Duration between(LocalTtime localTtime1, LocalTtime localTtime2);
		Duration between(Temporal startInclusive, Temporal endExclusive)
			
		
		Duration ofDays(long days)
		Duration ofHours(long hours)
		Duration ofMinutes(long minutes)
		Duration ofSeconds(long seconds)
		Duration ofSeconds(long seconds, long nanoAdjustment)
		Duration ofMillis(long millis)
		Duration ofNanos(long nanos)
		Duration of(long amount, TemporalUnit unit)
		Duration from(TemporalAmount amount)
		Duration parse(CharSequence text)
	
----------------------------
Duration-API				|
----------------------------
	long toMillis();
		* ���غ���ֵ
	
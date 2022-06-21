-------------------------
LocalDateTime			 |
-------------------------
	# ��ʾʱ��+����
	# ����(ͨ����̬����)
		LocalDateTime LocalDateTime.now();
			* ��ȡϵͳ��ǰʱ��
			* 2016-05-24T22:41:30.852

		LocalDateTime LocalDateTime.of(int year,int month,int dayOfMonth,int hour,int minute,int second);
			* ����ָ�������ں�ʱ�䷵��LocalDateTime����
		
		 LocalDateTime parse(CharSequence text, DateTimeFormatter formatter);
			* ���� formatter ����ʽ�� LocalDateTime ����
		
		LocalDateTime of(LocalDate date, LocalTime time)
			* �������ں�ʱ�乹��
			* ���Թ���һ��ָ������(����)����Сʱ������ʱ��
				LocalDateTime.of(LocalDate.now(),LocalTime.MAX);	2019-04-18 23:59:59.999999999
				LocalDateTime.of(LocalDate.now(),LocalTime.MIN);	2019-04-18 00:00
			
		LocalDateTime ofInstant(Instant instant, ZoneId zone)
			* ����ʱ�����ʱ����ת��Ϊ����ʱ��

-------------------------
LocalDateTime-api		 |
-------------------------
	# ��ȡ���
		int getYear();
			* ���������е����
		int getMonth();
			* ���������е��·�
		int getDayOfMonth();
			* �����·��еĵڼ���
		int getHour();
			* ����Сʱ
		int getMinute();
			* ���ط���
		int getSecond();
			* ������
		
		int get(TemporalField field)
			* ���ݲ�����ȡָ��������
			* ����ʹ��ö��:ChronoField

	# �������
		LocalDateTime withDayOfMonth(int num);
			* �������е�����

		LocalDate toLocalDate();
			* ת��Ϊ LocalDate ����

		LocalTime toLocalTime();
			* ת��Ϊ LocalTime ����
		
		LocalDateTime plusYears(int year);
			* ��Ӷ�����

		LocalDateTime plusMonths(int month);
			* ��Ӷ��ٸ���
			* '���кܶ����ʱ�����API,��һ��'
		
		LocalDateTime minusWeeks(long weeks)
			* ����N��֮ǰ������ʱ��
			* '���кܶ����ʱ�����API,��һ��'

	# ��ʽ�����
		String formart(DateTimeFormatter matter);
			* ���� DateTimeFormatter ���ر���ʽ�����ʱ���ַ���
		

-------------------------
��ʱ�����ת��
-------------------------
	#  ת��Ϊʱ����ļ��ַ�ʽ
		LocalDateTime now = LocalDateTime.now();
		
		long timestamp = now.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
		System.out.println(timestamp);
		
		timestamp = now.atOffset(ZoneOffset.of("+08:00")).toInstant().toEpochMilli();
		System.out.println(timestamp);
		
		timestamp = now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		System.out.println(timestamp);
	
	# ʱ���ת��ΪLocalDateTime
		
		LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
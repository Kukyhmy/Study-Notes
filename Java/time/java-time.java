------------------------
java.time				|
------------------------
	# �µ�����API
	# ���ṹ
		java.time
			|-LocalDate				//��������
			|-LocalTime				//����ʱ��
			|-LocalDateTime			//��������ʱ��
			|-Instant				//ʱ���
			|-DayOfWeek
			|-Year
			|-Month
		java.time.chrono
		java.time.format
			|-DateTimeFormatter
			|-DateTimeFormatterBuilder
			|-DecimalStyle
		java.time.temporal
			|-Temporal
			|-ChronoField
			|-ChronoUnit
			|-TemporalAdjuster
		java.time.zone
		

------------------------
java.time demos			|
------------------------

// ���쿪ʼ,����
LocalDateTime minDay = LocalDateTime.of(LocalDate.now(),LocalTime.MIN); // LocalDateTime minDay = LocalDate.now().atStartOfDay();
LocalDateTime maxDay = LocalDateTime.of(LocalDate.now(),LocalTime.MAX);

// ���ܿ�ʼ,����
LocalDateTime minWeak = LocalDateTime.of(LocalDate.now().with(DayOfWeek.MONDAY),LocalTime.MIN);
LocalDateTime maxWeak = LocalDateTime.of(LocalDate.now().with(DayOfWeek.SUNDAY),LocalTime.MAX);

// ���¿�ʼ,����
LocalDateTime minMonth = LocalDateTime.of(LocalDate.now().withDayOfMonth(1),LocalTime.MIN);
LocalDateTime maxMonth = LocalDateTime.of(LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()),LocalTime.MAX);

// ���꿪ʼ,����
LocalDateTime minYear = LocalDateTime.of(LocalDate.now().withDayOfYear(1),LocalTime.MIN);
LocalDateTime maxYear = LocalDateTime.of(LocalDate.now().withDayOfYear(LocalDate.now().lengthOfYear()),LocalTime.MAX);




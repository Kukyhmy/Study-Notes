----------------------------
LocalTime					|
----------------------------
	# ����ʱ��
	# LocalTime��������ʾһ���е�ʱ��
	# �󲿷ַ������� LocalDate ����,��������ҩ
	# ����(ͨ��LocalTime��̬����)
		LocalTime LocalTime.now();
			* ��ȡϵͳ��ǰʱ��
			* '�ᾫȷ�����뼶��'
			* 22:34:43.851

		LocalTime LocalTime.of(int hour,int minute,int second);
			* ����ָ��ʱ�䴴��LocalTime����
		
		LocalTime parse(String time);
			* �����ַ���,������LocalDate����
			* LocalTime time = LocalDate.parse("13:25:11");

		LocalTime parse(String time,DateTimeFormatter matter);
			* �����ַ���,��matter�ĸ�ʽ,������LocalDate����

----------------------------
LocalTime-����				|
----------------------------
	# ��ȡ���
		int getHour();
			* ����Сʱ

		int getMinute();
			* ���ط���

		int getSecond();
			* ������


	# �������
		LocalDateTime atDate(LocalDate date);
			* ���� LocalDate ����,���ϵ�ǰ�� LocalTime 
			* ���Ϊ LocalDateTime
		
		LocalTime plusHours(int year);
			* ��Ӷ���Сʱ
		
		LocalTime plusMinutes(int month);
			* ��Ӷ��ٷ���
			* '���кܶ���ӵ�API,��һ��'
		
		LocalTime minusHours(long hoursToSubtract);
			* ��ȥָ����Сʱ��
			* '���кܶ��ȥ��API,��һ��'

	# ��ʽ�����
		String formar(DateTimeFormatter matter);
			* ���� DateTimeFormatter ���ر���ʽ�����ʱ���ַ���
		



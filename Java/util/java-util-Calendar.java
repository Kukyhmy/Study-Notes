-------------------------
java.util.Calendar		 |
-------------------------
	# �޷�ֱ�Ӵ���,��Ҫͨ����������ȡ
		Calendar calendar = Calendar.getInstance();


-------------------------
ʵ������/�ֶ�			 |
-------------------------
	# �ֶ� 
		YEAR MONTH DAT WEEK
		
	# ����
		int get(Calendar.WEEK_OF_YEAR);
			|--��ȡָ���ֶε�ֵ������ int �������ݡ�
		void add(Calendar.DAY_OF_MONTH,1);
			|--�������Ĺ���Ϊ�����������ֶ���ӻ��ȥָ����ʱ������
		int get(Calendar.DAY_OF_MONTH);
			|--��ȡ���·��еĵڼ��졣���� int ���͡�
		void set(Calendar.DAY_OF_MONTH,23);
			|--�����·��е�����Ϊ23��
		void setTime(Date);
			|--�ѵ�ǰ Calendar ����ΪDate ʱ��
		Date getTime();
			|--��������ת���� Date �ࡣ���ص��� Date ����
		long getTimeInMillis()
			|-ת��Ϊ����ֵ
		
		getActualMaximum(int field)
			|-��ȡָ��'���ݵ�'�����ֵ
			|-���ݿ������·�,(��ȡָ�������ֻ�ж�����)
		getActualMinimum(in field)
			|--��ȡָ��'���ݵ�'����Сֵ
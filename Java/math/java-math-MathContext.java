------------------------
MathContext				|
------------------------
	# ��Ҫ�������Ǵ�����������еľ�������
	# ��̬����
		MathContext UNLIMITED = new MathContext(0, RoundingMode.HALF_UP)
			* �����Ƴ���, ʹ����������ķ�ʽ������С�� 

		MathContext DECIMAL32 = new MathContext(7, RoundingMode.HALF_EVEN)
		MathContext DECIMAL64 = new MathContext(16, RoundingMode.HALF_EVEN)
		MathContext DECIMAL128 = new MathContext(34, RoundingMode.HALF_EVEN)
	
	# ���췽��
		MathContext(int setPrecision)
		MathContext(int setPrecision,RoundingMode setRoundingMode)
		MathContext(String val)

		setPrecision
			* ����,һ������ٳ���(����С��)
		
		setRoundingMode
			* ����ģʽ
	
	# ʵ������

		int getPrecision()
		RoundingMode getRoundingMode()
	
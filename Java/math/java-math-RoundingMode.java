
-------------------------
RoundingMode			 |
-------------------------
	# ����ģʽ
	# ö��ʵ��
		UP(BigDecimal.ROUND_UP)
				 5.5	 6
				 2.5	 3
				 1.6	 2
				 1.1	 2
				 1.0	 1
				-1.0	-1
				-1.1	-2
				-1.6	-2
				-2.5	-3
				-5.5	-6

		DOWN(BigDecimal.ROUND_DOWN)
				 5.5	 5
				 2.5	 2
				 1.6	 1
				 1.1	 1
				 1.0	 1
				-1.0	-1
				-1.1	-1
				-1.6	-1
				-2.5	-2
				-5.5	-5

		CEILING(BigDecimal.ROUND_CEILING)
				 5.5	 6
				 2.5	 3
				 1.6	 2
				 1.1	 2
				 1.0	 1
				-1.0	-1
				-1.1	-1
				-1.6	-1
				-2.5	-2
				-5.5	-5

		FLOOR(BigDecimal.ROUND_FLOOR)
				 5.5	 5
				 2.5	 2
				 1.6	 1
				 1.1	 1
				 1.0	 1
				-1.0	-1
				-1.1	-2
				-1.6	-2
				-2.5	-3
				-5.5	-6

		HALF_UP(BigDecimal.ROUND_HALF_UP) (����,���Ǵ�˵�е���������)
				 5.5	 6
				 2.5	 3
				 1.6	 2
				 1.1	 1
				 1.0	 1
				-1.0	-1
				-1.1	-1	
				-1.6	-2
				-2.5	-3
				-5.5	-6

		HALF_DOWN(BigDecimal.ROUND_HALF_DOWN)
				 5.5	 5
				 2.5	 2
				 1.6	 2
				 1.1	 1
				 1.0	 1
				-1.0	-1
				-1.1	-1
				-1.6	-2
				-2.5	-2
				-5.5	-5

		HALF_EVEN(BigDecimal.ROUND_HALF_EVEN)
				 5.5	 6
				 2.5	 2
				 1.6	 2
				 1.1	 1
				 1.0	 1
				-1.0	-1
				-1.1	-1
				-1.6	-2
				-2.5	-2
				-5.5	-6

		UNNECESSARY(BigDecimal.ROUND_UNNECESSARY)
				 5.5	 throw ArithmeticException
				 2.5	 throw ArithmeticException
				 1.6	 throw ArithmeticException
				 1.1	 throw ArithmeticException
				 1.0	 1
				-1.0	-1
				-1.1	 throw ArithmeticException
				-1.6	 throw ArithmeticException
				-2.5	 throw ArithmeticException
				-5.5	 throw ArithmeticException

	# ��̬����
		RoundingMode valueOf(int rm)
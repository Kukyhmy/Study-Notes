-------------------------
java.util.Random		 |
-------------------------
	# �����
	Random r = new Random();		//δ�����ӡ���ô�Ǹ��ݵ�ǰʱ��ĺ���ֵ����ȡ���������
	Random r = new Random(long);	//�������ӡ�


------------------------
ʵ������/�ֶ�			|
------------------------
	r.nextInt();					//���� 0 - 1 ֮����κ�����
	r.netxInt(int num);				//����0 - num֮���������������� num.
		|--��������֮�󡣷��ص������������ͬ�ġ�
	
	
	IntStream ints()
	IntStream ints(long streamSize)
	IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound)
	IntStream ints(int randomNumberOrigin, int randomNumberBound)
		* ����stream��
		
		streamSize			������󳤶�
		randomNumberOrigin	�������ʼ
		randomNumberBound	���������


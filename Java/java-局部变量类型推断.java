-----------------------------
�ֲ����������ƶ�
-----------------------------
	# java10��������

	# ֻ�ܳ����ھֲ�������

	# �������Ķ���
		var val = "Hello World";
	
	# �������������ķ���ֵ
		public static void main(String[] args) throws Exception {
			var retVal = foo();
		}
		
		public static String foo() {
			return "";
		}
	
	# ѭ���еĶ���
		List<Integer> list = List.of(1, 2, 3);
		for (var item : list) {
			System.out.println(item);
		}
		for (var x = 0 ;x < list.size() ;x ++) {
			var item = list.get(x);
			System.out.println(item);
		}
	
	# �����е�ʹ��
		var list = new ArrayList<>();

		* �����������, ����ӷ��͵Ļ�, ��ô���Ĭ��Ϊ: Object
	


----------------------------
java12
----------------------------
	# ��ǿ�� switch ���ʽ
		switch (val) {
			case "1" -> System.out.println();
			case "2", "3" -> System.out.println();
			default -> System.out.println();
		}

		var reult = switch (val) {
			case "1" -> "1";
			case "2", "3" -> "1";
			default -> "1";
		};

		* ֧������ switch ���ؽ��
		* ������Ҫ����ֵ��switch expression, Ҫô��������ֵҪô�׳��쳣
	
	# ���� JVM ���� API
		* java.lang.constant
			ConstantDesc
				|-Double
				|-DynamicConstantDesc
					|-EnumDesc
					|-VarHandleDesc
				|-Float
				|-Integer
				|-Long
				|-String
				|-ClassDesc
				|-MethodHandleDesc
				|-MethodTypeDesc
	
	
	# ����Api
		String 
			<R> R transform(Function<? super String, ? extends R> f)
				* ���ַ�����ת��Ϊ�����Ķ���

			String indent(int n)
				* ����ÿһ�е�����
		
		Files
			long mismatch(Path path, Path path2)
				* ���Ҳ����������е�һ����ƥ���ֽڵ�λ��
				* ����Ҳ������� -1
		
		Collectors
			static <T, R1, R2, R> Collector<T, ?, R> teeing(Collector<? super T, ?, R1> downstream1,
																  Collector<? super T, ?, R2> downstream2,
																  BiFunction<? super R1, ? super R2, R> merger)
				
				* ���ھۺ�����downstream�Ľ��
		
		CompletionStage
			exceptionallyAsync
			exceptionallyCompose
			exceptionallyComposeAsync
		

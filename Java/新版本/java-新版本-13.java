
----------------------------
java13
----------------------------
	# �滻��java.net.Socket�Լ�java.net.ServerSocket API�ĵײ�ʵ��
		* ��ʹ�� NioSocketImpl ���滻JDK1.0��PlainSocketImpl
		* ���Ҫ����ʹ�þɰ��Socketʵ��, ����ʹ�� -Djdk.net.usePlainSocketImpl �������л����ɰ汾
	

	# �� switch ��ʹ��yield�滻��break����������, ��Ϊbreak��������������תִ������ goto �Ĳ���
		String dayOfWeek = switch(1){
            case 1 -> {
                String day = "Monday";
                yield day;
            }
            case 2 -> {
                String day = "Tuesday";
                yield day;
            }
            default -> "Unknown";
        };
        System.out.println(dayOfWeek);
	
	# �ı���
		* ��py�� ''' ''' �� js�� `` һ��

			String desc = """
				Hello World;
			""";
		
		* ��һ��""" �͵ڶ��� """ ������ͬһ��
	

--------------------
Repeatable ע��
--------------------
	# @Repeatable ע�������ǵ�ע����Զ��Ӧ������ͬ������������
		* JDK 1.8 �Ķ���
	
	# ������ʹ�á����ظ�ע�⡱
	
		1, �������ظ�ע�⡱
			@Repeatable(Schedules.class)
			public @interface Schedule {
				String dayOfMonth() default "first";
				String dayOfWeek() default "Mon";
				int hour() default 12;
			}

			* ͨ�� @Repeatable ע��, ָ����ע��ġ������ࡱ
		
		2, ��������ע��
			@Retention(RetentionPolicy.RUNTIME)
			public @interface Schedules {
				Schedule[] value();
			}
			
			* ��������, ���ǰ���һ�����ظ�ע�⡰�ļ���
		
		3, ����Ҫ�ĵط�, �ظ���ʶע��
			@Schedule(dayOfMonth="last")
			@Schedule(dayOfWeek="Wed", hour=24)
			public class RepetableAnnotation{ 
				....
			}

			* ���Ա�ʶ���
		
		4. �����ȡע��
			if (RepetableAnnotation.class.isAnnotationPresent(Schedules.class)){
				schedules = RepetableAnnotation.class.getAnnotation(Schedules.class);
				for (Schedule schedule: schedules.value()){
					System.out.println(schedule);
				}
			}

			* �����ע���ǡ�����ע�⡱��ͨ������ע������ԣ���ȡ��ԭʼע��
		

			
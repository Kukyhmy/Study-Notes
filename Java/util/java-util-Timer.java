-------------------------
java.util.Timer			 |
-------------------------
	# ��ʱ����ִ����
	# �첽����

-------------------------
ʵ������/�ֶ�			|
-------------------------

	schedule(TimerTask task, Date time) ;
		* ��ָ����ʱ��ִ������
	
	schedule(TimerTask task, Date firstTime, long period) 
		* ��ָ��ʱ��(firstTime)��ʼִ��,ÿ�� period �����ظ�ִ��һ��
	
	schedule(TimerTask task, long delay) 
        * ������ָ���ӳٺ�ִ��ָ��������
	
	schedule(TimerTask task, long delay, long period) 
        * ����ָ���������ָ�����ӳٺ�ʼ�����ظ��Ĺ̶��ӳ�ִ�С�
	
	scheduleAtFixedRate(TimerTask task, Date firstTime, long period) 
        * ����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶�����ִ�С�
		
	scheduleAtFixedRate(TimerTask task, long delay, long period) 
        * ����ָ����������ָ�����ӳٺ�ʼ�����ظ��Ĺ̶�����ִ�С� 

	Timer timer = new Timer();
	timer.schedule(new TimerTask(){
		@Override
		public void run() {
			System.out.println("�����ӡһ��");
		}
	},new Date(),2000);


-------------------------
��̬����/�ֶ�			|
-------------------------
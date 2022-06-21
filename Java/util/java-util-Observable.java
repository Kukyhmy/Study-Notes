------------------
Observable
------------------
	# Java�۲���ģʽ��ʵ��
		* ά����2�����ĵĳ�Ա����
			private boolean changed = false;
			private Vector<Observer> obs;
		
		* ����ͬ������

	# ���췽��
		public Observable()
	
	# ʵ������
		public synchronized void addObserver(Observer o) 
		public synchronized void deleteObserver(Observer o)
		public void notifyObservers()
		public void notifyObservers(Object arg)
			* ��notifyǰ����Ҫ���ֶ�����setChanged
			* ��ʶ�����Ѿ��ı䣬����notify������Ч
			* �����notify�󣬻�Ĭ�ϵ��� clearChanged�����״̬
		
		public synchronized void deleteObservers()

		protected synchronized void setChanged()
		protected synchronized void clearChanged()
			* ���ú�������Ѹı䡱״̬

		public synchronized boolean hasChanged()
		public synchronized int countObservers()
	
	# Observer �ӿ�
		public interface Observer {
			void update(Observable o, Object arg);
		}

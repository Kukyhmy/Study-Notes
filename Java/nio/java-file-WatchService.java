-----------------------
�ļ�����				|
-----------------------
	# ����ĳ��Ŀ¼���ļ���
		* ����
		* ɾ��
		* �޸�
	
	# �漰���
		WatchService
		WatchKey
		WatchEvent<?>
		WatchEvent.Kind
	
	# �¼�
		StandardWatchEventKinds.ENTRY_CREATE	�ļ�����
		StandardWatchEventKinds.ENTRY_DELETE	�ļ�ɾ��
		StandardWatchEventKinds.ENTRY_MODIFY	�ļ��޸�
		StandardWatchEventKinds.OVERFLOW		�¼���ʧ��һ�㲻��ע

-----------------------
WatchService			|
-----------------------
	# �ӿڷ���
		@Override
		void close() throws IOException;
		WatchKey poll();
		WatchKey poll(long timeout, TimeUnit unit) throws InterruptedException;
		WatchKey take() throws InterruptedException;


-----------------------
WatchKey				|
-----------------------
	# �ӿڷ���
		boolean isValid();		
		List<WatchEvent<?>> pollEvents();
		boolean reset();
		void cancel();
		Watchable watchable();

-----------------------
WatchEvent				|
-----------------------	
	# �ӿڷ���
		Kind<T> kind();
		int count();
		T context();
	
	# �ڲ��ӿ�
		public static interface Kind<T> {
			String name();
			Class<T> type();
		}
		public static interface Modifier {
			String name();
		}

-----------------------
Demo					|
-----------------------
	//WatchService ���̰߳�ȫ�ģ������ļ��¼��ķ���һ�����ö����߳���������
    public static void watchRNDir(Path path) throws Exception {
        //���� WatchService ����
        WatchService watchService = FileSystems.getDefault().newWatchService();
        //��path·�������ļ��۲����
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
        // ��ʼ����·��
        while (true) {
            //�߳�����
            final WatchKey key = watchService.take();
            //��ȡ�¼�����
            List<WatchEvent<?>> watchEventList = key.pollEvents();
            //����
            for (WatchEvent<?> watchEvent : watchEventList) {
                // ��ȡ�¼�
                final WatchEvent.Kind<?> kind = watchEvent.kind();
                // handle OVERFLOW event
                if (kind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }
                //�����¼�
                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {

                }
                //�޸��¼�
                if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {

                }
                //ɾ���¼�
                if (kind == StandardWatchEventKinds.ENTRY_DELETE) {

                }
                //�ѵ�ǰ�¼�ǿ��ת������Ϊ Path ���¼�
                final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
                //��ȡ�¼��ļ�����
                final Path filename = watchEventPath.context();
                // print it out
                System.out.println(kind + " -> " + filename);
            }
            // reset the keyf
            boolean valid = key.reset();
            // exit loop if the key is not valid (if the directory was
            // deleted, for
            if (!valid) {
                break;
            }
        }
    }
------------------------------------
WatchService						|
------------------------------------	
	# ����
		WatchService watchService = FileSystems.getDefault().newWatchService();
	# ����
		WatchKey		take();
			* �������Ƴ���һ��watch key����û�пɼ�������������

------------------------------------
WatchKey							|
------------------------------------	
	# ����
		ͨ�� WatchService ʵ���� take()������ȡ
	# ����
		List<WatchEvent<?>>		pollEvents();
			* �������Ƴ����и�watch key

------------------------------------
WatchEvent							|
------------------------------------
	# ����
	# ����
		Kind<?>			kind();
			* �����¼�����
		

------------------------------------
Kind								|
------------------------------------
	# ����
		String	name();
			* �����¼�������
	
------------------------------------
StandardWatchEventKinds				|
------------------------------------	
	# �¼���
	# ��̬�ֶ�
		OVERFLOW
		ENTRY_CREATE	
		ENTRY_DELETE
		ENTRY_MODIFY


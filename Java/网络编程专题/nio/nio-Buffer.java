------------------------------------
Buffer								|
------------------------------------
	# ��һ��������
	# �ӳ�����
		ByteBuffer
		CharBuffer
		DoubleBuffer
		FloatBuffer
		IntBuffer 
		LongBuffer 
		ShortBuffer

	# ������ʽ
		* ʹ���ӳ�����ľ�̬��������
			ByteBuffer buf = ByteBuffer.allocate(48);		//����48�ֽ�capacity��ByteBuffer��
			CharBuffer buf = CharBuffer.allocate(1024);		//����1024�ֽ�capacity��CharBuffer��

------------------------------------
Buffer ����							|
------------------------------------
	# capacity,position,limit
	# ��������������һ�����д�����ݣ�Ȼ����Դ��ж�ȡ���ݵ��ڴ档����ڴ汻��װ��NIO Buffer���󣬲��ṩ��һ�鷽������������ķ��ʸÿ��ڴ档
	# Ϊ�����Buffer�Ĺ���ԭ����Ҫ��Ϥ�����������ԣ�
		capacity
		position
		limit

	# capacity
		* ��Ϊһ���ڴ�飬Buffer��һ���̶��Ĵ�Сֵ��Ҳ��"capacity".��ֻ������дcapacity��byte��long��char�����͡�
		* һ��Buffer���ˣ���Ҫ������գ�'ͨ�������ݻ����������'�����ܼ���д��������д���ݡ�
		* '���ٵ��ڴ��С'
		
	# position
		* ����д���ݵ�Buffer��ʱ��position��ʾ��ǰ��λ�á���ʼ��positionֵΪ0.��һ��byte��long������д��Buffer�� position����ǰ�ƶ�����һ���ɲ������ݵ�Buffer��Ԫ��
		* position����Ϊcapacity �C 1.
		* 'ָ��λ��'

	# limit
		* ��дģʽ�£�Buffer��limit��ʾ���������Buffer��д�������ݡ� дģʽ�£�limit����Buffer��capacity��			
		* ���л�Buffer����ģʽʱ��limit�ᱻ���ó�дģʽ�µ�positionֵ��Ҳ����˵,Ҳ����˵���Զ�ȡ����������
		* 'д��ʱ���ʾ,����д��������'
		* '������hi��ʾ,���Զ���������'


------------------------------------
Buffer �ӿڷ���						|
------------------------------------
	Object		array();
	int			arrayOffset();
	int			capacity();
	Buffer		clear();
	Buffer		flip();
	boolean		hasArray();
	boolean		hasRemaining();
	boolean		isDirect();
	boolean		isReadOnly();
	int			limit();
	Buffer		limit(int newLimit);
	Buffer		mark();
	int			position();
	Buffer		position(int newPosition);
	int			remaining();
	Buffer		reset();
	Buffer		rewind();



HttpServletResponse

	ServletResponse-->��Э���޹ص�����
	HttpServletResponse-->��httpЭ����ص�����
---------------------------
����http״̬��Ĵ���(״̬�뿴http�ʼ�)
sendError(int sc);//���ʹ���״̬��
sendError(int sc,String msg);//���ʹ���״̬��,���ϴ�����Ϣ
setStatus(int sc);//���ͳɹ�״̬��--���Է���302(�ض���)

����http��Ӧͷ�Ĵ���(��ϸͷ��http�ʼ�)
/***��Ӧͷ��һ����ֵ��,���ܴ���[һ������|һ��ֵ]Ҳ���ܴ���[һ������|���ֵ]***/
setHeader(String name,String value);//�����ڵ�ֵ����Ӧͷ����Ҫ��
addHeader(String name,String value);//�����ڶ�ֵ����Ӧͷ
setIntHeader(String name,int value);//�����ڵ�ֵ��int���͵���Ӧͷ
addIntHeader(String name,int value);//�����ڶ�ֵ��int���͵���Ӧͷ
setDateHeader(String name,long value);//�����ڵ�ֵ�ĺ���������Ӧͷ
addDateHeader(String name,long value);//�����ڶ�ֵ�ĺ���������Ӧͷ

���÷���
getOutputStream();//����һ��ServletOutputStream����(OutputStream����)���ֽ��������Է����ֽ���ص����ݡ���getWeiter����ͬʱʹ�á�
getWriter();//����һ��PrintWriter���󡣿��Է����ַ���(ע�����ñ��봦����������)����getOutputStream����ͬʱʹ�á�
setContentType("�ĵ�����");//����response���ĵ�����Ϊָ���ĵ�����(text/html)
sendRedirect("����URL");//�����ض�������.�൱��ͬʱ������302״̬���Լ�locationͷ��
setCharacterEncoding("utf-8");//����������ַ����롣
	
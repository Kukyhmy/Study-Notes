HttpServletRequest
	��װ�˿ͻ����������������----------��������get������ֻ�ܻ�ȡ�����޸ģ�

��ȡhttpЭ������ͷ��
getHeader(String name);//�ʷ���String,���ڵ�ֵͷ
getIntHeader(String name);//����int,�����ڵ�ֵint���͵�����ͷ
getDateHeader(String name);//����longֵ,�����ڵ�ֵDate���͵�ͷ
getHeaders(String name);//����Enumeration<String>�����ڶ�ֵ����ͷ��

��ȡ����URL��
getMethod();//����String����,��������ʽ(GET/POST)
getScheme();//����String����,��ȡЭ��
getServerName();//����String����,��ȡ��������
getServerPort();//����String����,��ȡ�������˿�
getContextPath();//����String����,��ȡ��Ŀ��(������·��)
getServletPath();//����String����,���servlet·��
getQueryString();//����String����,��ò������֡����ʺź����ύ�Ĳ���
getRequestURI();//����String����,�������URI.������Ŀ��+servlet·��
getRequestURL();//����String����,�������URL.���ڲ�������������������·��
getRemoteAddr();//����String����,��ÿͻ��˵�IP��ַ

��ȡ���������
getParameter(String name);//����String,���ָ�����������ֵ�������ڵ�ֵ��������
getParameterValues(String name);//����String[],���ָ�����������ֵ�������ڶ�ֵ��������
getParameterNames();//����String����,��ȡ�����������������
getParameterMap();//����Map<String,String[]>����,��ȡ�����������������keyΪ������,valueΪ����ֵ

����ת�����������
RequestDispatcher rd = request.getRequestDispatcher("/MyServlet");//request��ȡRequestDispatcher���󡣷����Ĳ�����:��ת��,���߱�������servlet·��
rd.forward(request,response);//����ת�������á�
rd.include(request,response);//�������
/**request -- ����,�������������������.����,��servlet֮�䴫��ֵ�õ�(request��) -- **/

�����ַ�����(post)
request.setCharacterEncoding("utf-8");//�÷�������ָ���ı����ʽ������post���ύ������(getPrameter();)
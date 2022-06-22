���ServletContext

ServletContext
  
  ServletContext��Servlet���������֮һ
  ServletContext�ڷ���������ʱ�������ڷ������ر�ʱ���٣�һ��JavaWebӦ��ֻ����һ��ServletContext����!
  
1. ���Ĺ��ܷ��ࣺ
  * ��ȡ����
  * ��ȡweb.xml�е�Ӧ�ó�ʼ������
  * ��ȡӦ����Դ

2. ��ȡServletContext����
   ��HttpServlet�п���ͨ�����·�������ȡServletContext����
  * ServletContext servletContext = this.getServletContext()
  * ServletContext servletContext = this.getServletConfig().getServletContext()

2. ��ȡ����
  ��Ϊ��һ��JavaWebӦ���У�ֻ��һ��ServletContext����������ServletContext�б�������ݿ��Թ�����JavaWebӦ���е�����servlet��̬��Դ����
  ServletContext��Servlet���������֮һ��������ڲ���һ��Map��������������

	------------���÷���------------
	
setAttribute(String name, Object value);
	|--����ֵ��void .������ӻ��滻ServletContext������
		 > servletContext.setAttribute("xxx", "XXX")�����������
		 > servletContext.setAttribute("xxx", "XXXX")�����������ݣ���Ϊ�������Ѿ���������Ϊxxx�����ݣ�������ξ��Ǹ�����

getAttribute(String name);
	|--ע�⣺����ֵ�� Object .ͨ����������ȡ������

getAttributeNames()��
	|--����ֵ��һ��ö�� Enumeration<String> ��ȡ����ServletContext�����ݵ�����

removeAttribute(String name);
	|--����ֵ��void.ͨ�������Ƴ�������

getInitParameter(String name);
	|--����String������������ȡweb.xml�ļ��ж�Ӧ��ֵ

getInitParameterNames();
	|--����һ�� Enumeration<String> ����<Context-param>��ǩ��<param-name>��ǩ��

getResourcePaths(String);
	|--����ֵ��һ�� Set<String> ����.������ָ��Ŀ¼�µ������ļ�·����
		> Set<String> paths = servletContext.getResourcePaths("/WEB-INF");
		���ص�Set�а��������ַ�����
		> /WEB-INF/lib/
		> /WEB-INF/classes/
		> /WEB-INF/web.xml
		> /WEB-INF/a.jpg


getRealPath(String path);
	|--����ֵ��String ��ȡָ��������Դ����ʵ����
		>String path = servletContext.getRealPath("/WEB-INF/a.jpg");
		����ֵΪ/WEB-INF/a.jpg��ʵ·����������·����C:/tomcat6/wabapps/hello/WEB-INF/a.jpg

getMimeType(String path)
	|--��ȡָ���ļ����ļ�����
		> path,��ʾһ������·�����ļ�

getResourceAsStream(String path);
	|--����ֵ�� InputStream.����ָ�����Ƶ���Դ����ȡ��֮�����Ķ�ȡ��
		>InputStream in = servletContext.getResourceAsStream("/WEB-INF/a.jpg");
		���ص���a.jpg�����������󣬿��Դ����еõ�a.jpg������

3. ��ȡweb.xml�����õ�Ӧ�ó�ʼ������

  <context-param>
    <param-name>p1</param-name>
    <param-value>v1</param-value>  	
  </context-param>
  <context-param> 
    <param-name>p2</param-name>
    <param-value>v2</param-value>  	
  </context-param>

  * servletContext.getInitParameter("p1")������v1
  * servletContext.getInitParameter("p2")������v2
  * servletContext.getInitParameterNames()������Enumeration<String>������p1��p2

 ^^ һ��ServletҲ���Ի�ȡ��ʼ���������������Ǿֲ��Ĳ�����Ҳ����˵��һ��Servletֻ�ܻ�ȡ�Լ��ĳ�ʼ�����������ܻ�ȡ���˵ģ�������ʼ������ֻΪһ��Servlet׼��
	ServletConfig	��ȡ
 ^^ �������ù����ĳ�ʼ��������Ϊ���е�Servlet����
	ServletContext	��ȡ
4. ��ȡ��Ŀ��Դ(��Ҫ)
  * String getRealPath(String path)����ȡ��Դ����ʵ����
  * String path = servletContext.getRealPath("/WEB-INF/a.jpg");
  ����ֵΪ/WEB-INF/a.jpg��ʵ·����������·����C:/tomcat6/wabapps/hello/WEB-INF/a.jpg
 
  * InputStream getResourceAsStream(String path)����ȡ��Դ��������
  InputStream in = servletContext.getResourceAsStream("/WEB-INF/a.jpg");
  ���ص���a.jpg�����������󣬿��Դ����еõ�a.jpg������

  * Set<String> getResourcePaths(String path)����ȡָ��Ŀ¼�µ�������Դ·��
  Set<String> paths = servletContext.getResourcePaths("/WEB-INF");
  ���ص�Set�а��������ַ�����
    > /WEB-INF/lib/
    > /WEB-INF/classes/
    > /WEB-INF/web.xml
    > /WEB-INF/a.jpg



�ö�����Ҫ���ڶ�ȡServlet��������Ϣ��
һ����Ŀ��ֻ��һ��ServletConfig   
 ���ǿ���N���Servlet������ȡ���Ψһ�Ķ���ʹ�������Ը����Servlet�������ݡ�
 ����Servlet֮���ǲ���ʶ�ġ���ֻ�п����ˣ��������ͬ�١��������Tomcat����ʱ���֡�Tomcat�ر�ʱ����ʧ��
 ���������������Ŀ��Ψһ�Ŀ��Ա��

?ServletContext��getAttribute��getInitParameter����!
											JSPָ��		

**************************  pageָ��  **************************
<%@ page language="java" contentType="text/html" charset="utf-8" import="java.uti.Properties" %>
��������		ȡֵ��Χ		����	
*language		java			ָ�����͸�JSP�ļ�ʱ���õ�����,һ��Ϊjava,Ĭ��Ϊjava.
*import			�κΰ�.����		�����JSP���õ�����,���ȡ���Ψһ�����Գ��ֶ�ε�pageָ������
*session		boolean			ָ����JSP���Ƿ�����session����true������,��ֱ��ʹ�á�false�����á�Ĭ��Ϊtrue
*autoFlush		boolean			�Ƿ����л���.trueʱ,out.println()�ȷ�������ַ������ȴ��뻺�档�����������ִ��										out.flush()��ˢ�µ��ͻ��ˡ�Ĭ��Ϊtrue
*buffer			none/����kb		ָ�������С(Ĭ��8KB),��autoFlushΪtrueʱ��Ч����:<%@ page buffer="10kb" %>
*isThread		boolean			ָ���߳��Ƿ�ȫ,���Ϊtrue�����ж���߳�ͬʱ���и�JSP��
								����JSP���ɵ�servlet��ȥʵ��һ��'�Ѿ���ʱ'�ı�ǽӿ�SingleThreadNodelֻ������һ���߳�,�����̵߳ȴ���Ĭ��Ϊfalse
*isErrorPage	boolean			ָ����ҳ���Ƿ�Ϊ������ҳ��,���Ϊtrue���JSP����һ��Exception��ʵ������*exception
								���ҳ�������״̬��:500,�ö������ֱ��ʹ�á�����û�С�Ĭ����false
								(web.xml�ļ���Ҳ����ָ������ҳ�档���ַ�ʽ��ʵ��page�޹�)
*errorPage		ĳJSP���·��	ָ��һ��������ʾҳ��,�����JSP�׳�һ��δ��׽���쳣,��ת��errorPageָ��·����
								���ҿͻ��˲��ᱨ500����.״̬��Ϊ200״̬��
								errorPageָ��ҳ��ͨ��pageָ���isErrorPage����Ϊtrue��
*contentType		��Ч�ĵ�����	�ͻ�����������ݸ������ж��ĵ�����,����
								HTML    --	text/html
								���ı�	--	text/plain
								JPG     --	image/jpeg
								GIF	    --	image/gif
								WORD    --	application/msword
*info			�����ַ���		ָ��JSP����Ϣ,����Ϣ����ͨ��Servlet.getServletInfo();������ȡ��
*trimDirective
 Whitespaces	boolean			�Ƿ�ȥ��ָ��ǰ��Ŀհ׷�,Ĭ��false.�ÿհ׻�Ӱ�쵽JSP���ɵ�html���붥�˿ո�
*extends		�κΰ�.����		�ø�JSP���ɵ�Servletȥ�̳�ָ������
*isELgnored		boolean			�Ƿ����el���ʽ,Ĭ��ֵ��false.�������ԣ��ϰ汾(�����ǿ�������)��JSPĬ��ֵ��ture��
*pageEncoding	��Ч�ַ�����	ָ����ǰJSPҳ��ı���,ֻҪ���ı�Ҳ�ǰ������ָ����ʽ���������Ͳ����������
								������Ҫ��JSP�����JAVA�����ʱ��,����Ҫʹ��pageEncoding	
**************************  includeָ��  **************************
<%@ include file="·��" %>
���ã�
   ��ҳ��ֽ�,ʹ�ð����ķ�ʽ�����һ������һ��ҳ���в���Ĳ��֡�����һ��������JSP������ֻ��Ҫ����仯��ҳ�档
   ���JSPҳ���ж�����ͬ���ĵ����ǩ��ÿ������ͬ���ģ�̫�ۡ���ô�ҾͿ����½�һ��jspҳ�浼��������Ҫ���ࡣ������Ҫ�����JSPȥ����(include)���JSP�����ˡ�

   - ��RequestDispatcher��include();�������ƣ��������в�ͬ
   - <%@ include %>  ��ʾJSP�����JAVA�ļ�ʱ��ɵģ����ǹ�ͬ����һ��JAVA�ļ�(servlet),Ȼ��������һ��class��
   - RequestDispatcher��include()��һ�������������ͱ�������������Servlet,����ֻ�ǰ���Ӧ������,������ʱ�ϲ���
* file
	  <%@include file="x.jsp">����file�ͱ�ʾҪ������JSP�ļ������file��ֵ�����Ǳ�������Ϊ����������ڱ����JAVA�ļ��� ʱ��ͺϲ�����һ��Servlet��
	  ����Ǳ���,��ô���class�ļ���ʱ������ã��������,��ôjsp�Ͳ���ʶ��ı��ʽ��ָ����ĸ�jsp�ļ�����Ϊ�Ǹ��������Ǿ����JSPҳ�棡
	  ���ұ�������ҳ��Ҫע�ⲻ�ܸ���ҳ�����ظ�����׸Ԫ��(ֻ�ܵ�һ���ڵ�Ԫ��<html>,<baody>,<head>... ...)

   ------�ܽ�
	�﷨��<%@include file="ҳ��"%>
	includeָ��������ǰ���ָ����ҳ�棡��jsp�������java�ļ�֮ǰ�������jsp�ļ��ϲ���Ȼ���ٱ����һ��java�ļ���

	ע�⣺
	<%@include file="<%=myfile%>" %>
	���ǲ���ͨ������ģ���Ϊmyfile��һ������������ֵֻ����java�����class��ִ��ʱ����ȷ������includeָ����Ҫ��jsp����javaʱ��Ҫȷ�����������ĸ�ҳ�棬����...

**************************  taglibָ��  **************************
<%@ tiglib uri="http://java.sum.com/jsp/jstl/core" prefix="c" %>
* prefix		�����ַ���		ָ����ǩ���ڱ�ҳ���е�ǰ׺,��ֹ��ǩ������
* uri			��֪��ǩ��λ��	��ȡ�����ı�ǩ,����ʹ��




**************************  �ܽ�  **************************
һ��JSPҳ���������0-N��ָ��Ķ���.
JSPָ����ʵ����Ҫ���ڵ�һ��,�������ڷ��ڵ�һ���Ѿ����˹淶����������ֻ�ܷ��ڵ�һ��

��WEB.xml�ļ�������
<jsp-config>
	<jsp-property-group>
		<url-pattern>*.jsp</url-pattern> <!--��ʾ������jsp��������-->
		<el-ignored>true</el-ignored> <!--����EL���ʽ-->
		<page-encoding>UTF-8</page-encoding> <!--����Ϊutf-8-->
		<scripting-invalid>true</scripting-invalid> <!--����java�ű�-->
	</jsp-property-group>
</jsp-config>
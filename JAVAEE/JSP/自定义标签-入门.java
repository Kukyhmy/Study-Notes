------------------------------------
�Զ���JSTL��ǩ						|
------------------------------------
	* �������,ֱ�����Ĳ���.
	һ,���²���
		* ��ǩҲ��һ������,��ô����Ҫ������,ÿһ����ǩ��ʵ����Ӧһ����
		* tld�ļ�,����һ��xml.
		* ҳ����ʹ��<%@taglib>��ָ��tld�ļ���λ��

------------------------------------
��ǩ������							|
------------------------------------
	* ��ʵ�ʼ����һ�� Tag �ӿ�,����д�ú��鷳
	* Ϊ�˽���鷳,����sunŪ�˸�SimpleTag,û��,Ҳ��һ���ӿ�
	* ���ǳ�����Tag��SimpleTage��,�ͳ����˸���ΪӪ�ĳ���,�Ƚ�����
	* ����,Ϊ�˽���������εľ���,sum�����ڳ���һ������:JspTage�Ľӿ�,��Ϊ¥�����İְ�
	* ����Ȼ,��������ʹ��SimpleTage�ӿ�������Զ����ǩ�Ŀ���
	SimpleTage�ӿ��еķ���
		doTag();							//ÿ��ִ�б�ǩ������ø÷���,void����ֵ
			* ���ķ���,��ʵÿ��ִ�б�ǩ����ִ�����������
			* "����������������֮��,��Tomcat����"
		getParent();						//����JspTage
			* ��ȡ����ǩ,Ҳ���Ǻ����İְ�-JspTag
			* <c:when>�ĸ���ǩ����<c:choose>... ...���������?
			* "���������ڱ�ǩ,����û�˵���,���������Լ�����"
		setJspBody(JspFragment jspBody);	//void����ֵ
			* ���ñ�ǩ��
			* JspFragment
				* ��JSP��һ��,��ʵ���Ǳ�ǩ�������
		setJspContext(JspContext pc);		//void����ֵ
			* ����JspContext,��ʵ����PageContext�ĸ���,���������ʵ��Զ���Ǵ��ݵ�PageContext
			* ��ǩ��������"һ�����Ÿ�",��������ɶ�ò����ģ�
		setParent(JspTag parent);			//void����ֵ
			* ���ø���ǩ... ...û��Ҫȥ�˽���,��ʵ����Tomcat�������,�������ٵ���
		
		* ���е�setXxx����������doTagǰ�汻Tomcat������,������doTag�оͿ���ʹ��Tomcat���ݹ�������Щ����,����Ȼ��Ҫ�Լ�д������"�����Ǳ�������"
		* ��ֻ��getParentû��������,��������set����doTag֮ǰ������

------------------------------------
д��ǩ��							|
------------------------------------
	* дһ����,ʵ��SimpleTage�ӿ�,��д����ķ���
		* �������Ա����,ע���̬.Ȼ��洢set�������ݵĲ���
	package com.kevin.tag;
	import java.io.IOException;
	import javax.servlet.jsp.JspContext;
	import javax.servlet.jsp.JspException;
	import javax.servlet.jsp.PageContext;
	import javax.servlet.jsp.tagext.JspFragment;
	import javax.servlet.jsp.tagext.JspTag;
	import javax.servlet.jsp.tagext.SimpleTag;
	/**
	 * �Զ����ǩ
	 * */
	public class MyTag implements SimpleTag{
		private PageContext pageContext;
		private JspFragment jspFragment;
		private JspTag jspTage;
		/**
		 * ���ص�ķ���,ÿ�ε��ö���ִ�еķ���,����������set�������������������ڷ���.˵����,�ⶫ����һ������
		 * */
		public void doTag() throws JspException, IOException {
			//��Ҫ��ҳ��������,����Ҫ��PageContext�л�ȡ
			pageContext.getOut().print("Hello Tag");
		}
		/**
		 * �������һ�㶼����û�Լ�����,�������ǲ���ɵ�
		 * */
		public JspTag getParent() {
			return jspTage;
		}
		/**
		 * ��doTage֮ǰ������������
		 * */
		public void setJspBody(JspFragment fragment) {
			//���·�����������"С����"
			this.jspFragment = fragment;
		}
		/**
		 * ��doTage֮ǰ������������
		 * */
		public void setJspContext(JspContext context) {
			//���·�����������"С����"
			this.pageContext = (PageContext) context;
		}
		/**
		 * ��doTage֮ǰ������������
		 * */
		public void setParent(JspTag jspTage) {
			//���·�����������"С����"
			this.jspTage = jspTage;
		}
	}

------------------------------------
tld�ļ�								|
------------------------------------
	* дtld�ļ�,һ�㶼����/WEB-INFĿ¼��,�Լ�����һ��tlds�ļ�����
	* ���˵�Ҳ���Լ��֮��Ķ���,��ȥC��ǩ������ȥ��һ�°�
		<?xml version="1.0" encoding="UTF-8" ?>
		<taglib xmlns="http://java.sun.com/xml/ns/javaee"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-jsptaglibrary_2_1.xsd"
			version="2.1">
			<!-- �����ǩ,�Զ���İ汾�� -->
			<tlib-version>1.0</tlib-version>
			<!-- �������,д����� -->
			<short-name>kevin</short-name>
			<!-- Ϲд...�Ǻ� -->
			<uri>http://www.kevinblandy.com</uri>
			<!-- �ص�,һ��tld�ļ��п���д���tag,ÿ��tag����һ����ǩ -->
			<tag>
				<!-- ��ǩ����,��д -->
				<name>demo</name>
				<!-- ��ǩ������,����Ȼ������·���� -->
				<tag-class>com.kevin.tag.MyTag</tag-class>
				<!-- ��ǩ������,���û�б�ǩ��(�ձ�ǩ������<br/>,<hr/>),�Ǻ���Ȼ����empty�� -->
				<body-content>empty</body-content>
			</tag>
		</taglib>
------------------------------------
ҳ����ָ��tld�ļ�λ��				|
------------------------------------
	* �����ǩ��,��ʵ����ָ��tld�ļ���λ��
	* <%@ taglib prefix="my" uri="/WEB-INF/tlds/demo.tld"%>
	* ʹ��:<my:demo/>    �ͻ����:Hello Tag


--------------------------------
SimpleTagSupport				|
--------------------------------
	* ������������,��ʵ��Ϊ�о���Ŀ�����ԱҲ���뵽
	* ʵ�ֽӿ���ʵҲ���󷽱�,����:ʵ��Servlet,�����ּ̳�HttpServlet...
	* ����Ϊ�˸��ӵķ���,�ֳ����� SimpleTagSupport
	* SimpleTagSupport
		* �ⶫ��ʵ����SimpleTag�ӿ�,���Ұ����������˳�Ա������������еĶ���
		* ���ǰ�Tomcat���ݵ��������ݶ�����������,���һ��ṩ��get����,���������
		* ����ֻ��Ҫȥ��дdoTag��OK��
	* tld�������������þ�OK
		* ֻ��Ҫ��ԭ����tld�ļ������һ���µ�<tag>��ǩ,���������þ�OK
		* һ��tld�ļ�,�����ж��<tag>ÿ��tag���Ƕ�Ӧ��һ����



* ʵ�ʵĿ�����,�����ڱ�ǩ���л�ȡ:"SpringUtils",����ȡָ����Bean,ͨ��Bean�����ҳ�洫�ݽ�����ֵ�����߼�����

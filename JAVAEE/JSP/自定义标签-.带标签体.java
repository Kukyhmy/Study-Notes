-----------------------
����ǩ��ı�ǩ			|
-----------------------
	* ����Ȼ,�����Ҫ�ǻ��������Ѿ�������.OK����Խ��׵�����
	* ��ʵ����tld��body-contentҪ���õĶ���
		<tag>
			<!-- ��ǩ����,��д -->
			<name>demo</name>
			<!-- ��ǩ������,����Ȼ������·���� -->
			<tag-class>com.kevin.tag.MyTag</tag-class>
			<!-- ��ǩ������,���û�б�ǩ��(�ձ�ǩ������<br/>,<hr/>),�Ǻ���Ȼ����empty�� -->
			<body-content>empty</body-content>
		</tag>
	* body-content,�п�����������ֵ
		1,empty
			* Ҳ���Ǵ�˵�е��ޱ�ǩ��
		2,JSP
			* ��ͳ��ǩ֧����,����SimpleTag(jsp2.0)�Ѿ�����֧��
			* ��ǩ������ݿ������κζ���:EL,JSL,<%=%>,<%%>������html
		3,scriptless
			* ר��Ϊjsp2.0�ṩ��.��ǩ������ݲ�����java�걾,��������EL,JSTL��
			* '��SimpleTag��,�����Ҫ�б�ǩ��,��ô��ʹ����'
		4,tagdependent
			* ��ǩ�����ݲ�������,�ɱ�ǩ���������д���,���۱�ǩ����EL,JSP,JSTL������������
			* ���ѡ�����û�˻�ʹ��
		* ��ʵҪôѡ1,Ҫô��ѡ3
-----------------------
����ǩ���ǩ��			|
-----------------------
	package com.kevin.tag;
	import java.io.IOException;
	import java.io.Writer;
	import javax.servlet.jsp.JspException;
	import javax.servlet.jsp.tagext.JspFragment;
	import javax.servlet.jsp.tagext.SimpleTagSupport;
	/**
	 * ����ǩ��ı�ǩ
	 * */
	public class MyTagB extends SimpleTagSupport{
		public void doTag() throws JspException, IOException {
			//��ȡ��ǰjspҳ��������
			Writer out = this.getJspContext().getOut();
			//��ʵ�ʵ�el���ʽ���֮ǰ����㶫��
			out.write("******һ������<br/>");
			//��ȡ����ǩ��
			JspFragment jspFrament = this.getJspBody();
			/*
				ִ�б�ǩ������(��ʵһ�㶼�ǽ���el���ʽ),�ѽ��ֱ��д��ָ��������
				�����ǩ�����ֱ���Ǹ��ַ�,��ô��ԭ�����.
				<my:demob>${name}</my:demob>	--> �ᱻ���������
				<my:demob>Kevin</my:demob>		--> ԭ�����
			*/
			jspFrament.invoke(out);
			//��ʵ�ʵ�el���ʽ���֮������㶫��
			out.write("<br/>******һ������");
		}
	}
	'�����ݵ��������null,��ʾʹ�õľ��ǵ�ǰҳ���out'
	* jspFrament.invoke(null);		//ֱ�ӿ�����ôд������дout��һ������ʵ

-----------------------
����ǩ��tld�ļ�			|
-----------------------

	<tag>
		<name>demob</name>
		<tag-class>com.kevin.tag.MyTagB</tag-class>
		<!-- ע���Ǵ���ǩ��� -->
		<body-content>scriptless</body-content>
	</tag>

-----------------------
����ǩ���ǩʹ��		|
-----------------------
	* ����
		<%@ taglib prefix="my" uri="/WEB-INF/tlds/demo.tld"%>
	* ʹ��
		<%
			//ģ������,����request��
			request.setAttribute("name", "KevinBlandy");
		%>
		<body>
			<h1><my:demoa/></h1>
			<h1><my:demo/></h1>
			<div>
				<!-- ${name},���Ǳ�ǩ�� -->
				<my:demob>${name }</my:demob>
			</div>
		</body>
	* ����������:
		******һ������
		KevinBlandy
		******һ������

----------------------------
��ִ�б�ǩ�����ҳ������	|
----------------------------
	* ��ʵ����˵,ϣ��ִ����ָ���ı�ǩ��,����ִ�б�ǩ���������,��ô�Ϳ���ʹ��һ���쳣
	* SkipPageException
		package com.kevin.tag;
		import java.io.IOException;
		import javax.servlet.jsp.JspException;
		import javax.servlet.jsp.SkipPageException;
		import javax.servlet.jsp.tagext.SimpleTagSupport;
		/**
		 * ��ִֹ��
		 * */
		public class MyTagB extends SimpleTagSupport{
			public void doTag() throws JspException, IOException {
				this.getJspContext().getOut().write("ֻ�ܿ�����,��ľ����");
				/*
					����쳣�����׳�����,Tomcat�Ჶ����
					Tomcat��ʶ��
				*/
				throw new SkipPageException("���治ִ����");
			}
		}
	* ��ʵ�ⶫ��ȥ����JSP����,�Ϳ��Կ���ԭ����
	* һ��try catch .���쳣����,����ľͲ���ִ����

	
----------------------------
�����Ե��Զ����ǩ			|
----------------------------
	* ��������˵,�е㸴��.
	* <c:if test=""></c:if>
		* test����һ������
	* �����Զ���һ����ifһ�����Զ������Ա�ǩ
	����
		1,����ǩ�������������
		2,��tld�ļ������Խ��в���(����,����)

----------------------------
�����Ե��Զ����ǩ��		|
----------------------------
package com.kevin.tag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * �����Եı�ǩ
 * */
public class MyTagC extends SimpleTagSupport{
	/**
	 * ��ǩҪ������,��ô���������.ע��,������get/set
	 * ��ʵ�����ṩset�ͺ���,get�������ṩ
	 * */
	private boolean test;
	public void doTag() throws JspException, IOException {
		//��ȡ��ǩ��
		JspFragment jspFragment = this.getJspBody();
		//���Ը���ҳ�洫�ݵ������������߼�����,�����true,��ô�Ҿ�ִ�б�ǩ�������,��Ȼ�Ͳ���
		if(test){
			/*
		  		������ݵ��������null,��ʾʹ�õľ��ǵ�ǰҳ���out
			*/
			jspFragment.invoke(null);
		}
	}
	public boolean isTest() {
		return test;
	}
	/**
	 * ����tomcat����,����doTag֮ǰִ��,������û�Ϳ���ʹ�ø�����
	 * */
	public void setTest(boolean test) {
		this.test = test;
	}
}


----------------------------
�����Ե��Զ����ǩtld		|
----------------------------
	<tag>
		<name>democ</name>
		<tag-class>com.kevin.tag.MyTagC</tag-class>
		<body-content>scriptless</body-content>
		<!-- �������� -->
		<attribute>
			<!-- ������ -->
			<name>test</name>
			<!-- �������Ƿ������� -->
			<required>true</required>
			<!--
				runtime expretion value
				Ҳ��������ʱ���ʽֵ,����˵:������Ը���ֵ�Ƿ�Ϊ���ʽ
				һ�㶼��true,��Ȼ��ʧȥ������.if(fasle)ֱ��д�����Լ����Լ�����
			-->
			<rtexprvalue>true</rtexprvalue>
		</attribute>
	</tag>
	* attribute���Կ����ж��,�������ж������
----------------------------
�����Ե��Զ����ǩʹ��		|
----------------------------
	* ����Ͳ�˵��
		<body>
			<%
				//ģ�⸳ֵ
				request.setAttribute("flag", false);
			%>
			<div>
				<my:democ test="${flag }">
					<!-- ֵΪtrue,��ô���true�ͻ�ִ�� -->
					true
				</my:democ>
			</div>
		</body>
	
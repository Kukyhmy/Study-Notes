------------------------
�Զ���EL������			|
------------------------
	# һ�㲻��ȥ����,����д�õľ͹���.
	# ��Ϊ��������,�����Ͱ�������ͺ���
		
------------------------
1,дһ��JAVA��			|
------------------------
	# ����0-N����̬����
		1,������һ����̬����
		2,����Ҫ�з���ֵ

------------------------
2,дTLD�ļ�				|
------------------------
	# ͷ�ļ�,ȥ���е�jar����͵
		<?xml version="1.0" encoding="UTF-8" ?>
		<taglib xmlns="http://java.sun.com/xml/ns/j2ee"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-jsptaglibrary_2_0.xsd"
		version="2.0">
			<!-- ˵�� -->
			<description>MyEl</description>
			<!-- �������� -->
			<display-name>itcast-function</display-name>
			<!-- �汾 -->
			<tlib-version>1.0</tlib-version>
			<!-- �̳�....���� -->
			<short-name>it</short-name>
			<!-- 
				�����ʵ�������д,����Ǵ���jar����Ҫ�ϸ���
			 -->
			<uri>http://www.kevinblandy.com/el/function</uri>
			<!-- ��һ������,дһ������ -->
			<function>
				<!-- ����,���� -->
				<name>fun</name>
				<!-- ��ȫ·�� -->
				<function-class>com.kevin.el.MyEl</function-class>
				<!-- 
					�Է�����������:����ֵ ��������();
				 -->
				<function-signature>java.lang.String test()</function-signature>
				<!-- ����ֱ�ӾͲ��ø� 
				<example></example>-->
			</function>
		</taglib>

------------------------
2,��JSPҳ�������Լ��	|
------------------------
	# <%@ taglib prefix="fn" uri="http://www.kevinblandy.com/el/function" %>
	# ${fn:fun()}
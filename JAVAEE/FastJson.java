--------------------
FastJson			|
--------------------
	# ����Ͱ͵�����



--------------------
FastJson			|
--------------------
	��Ҫ��(��̬)
		com.alibaba.fastjson.JSON
	

1,�Ѷ������л�Ϊjson�ַ���
	String json = JSON.toJSONString(Object obj);
	String json = JSON.toJSONString(Object obj, boolean prettyFormat); // ��JavaBean���л�Ϊ����ʽ��JSON�ı�

2,��json,���л�ΪjavaBean
	T t = parseObject(String text, Class<T> clazz); 

3,��json,���л�ΪjavaBean����
	List<T>  ts = parseArray(String text, Class<T> clazz); 

--------------------
FastJson-ע��		|
--------------------
	@JSONField
		format
			* ��ע��Bean���ֶ�������,���ַ�������ʽָ����ʽ����ʽ
		
		deserialize
			* true/false,�Ƿ����л����ֶ�
	

--------------------
FastJson-����springmvc|
--------------------

 <mvc:annotation-driven>
        <mvc:message-converters register-defaults="true">
            <bean class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter">
                <property name="supportedMediaTypes">
                    <list>
                        <value>text/html;charset=UTF-8</value>
                        <value>application/json</value>
                    </list>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>

    <bean class="com.alibaba.fastjson.support.spring.FastJsonpResponseBodyAdvice">
        <constructor-arg>
            <list>
                <value>callback</value>
                <value>jsonp</value>
            </list>
        </constructor-arg>
    </bean>
		

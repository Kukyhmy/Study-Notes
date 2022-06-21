---------------------
���ú���			 |
---------------------
	# ���ú����ĵ��ö���ͨ�� ?func �����õ�
	

---------------------
�ַ������			 |
---------------------
	boolean
		* ת���ַ���Ϊ boolean ֵ
		* �ַ��������� true �� false (��Сд����)
		* Ҳ����ͨ�� boolean_format ���õ��ض���ʽ
	
	html
		*  ��html�ַ�ת�����
	
	cap_first
		* ����ĸ���ô�д
	
	uncap_first
		* �����ַ��������е��ʵ�����ĸСд
	
	capitalize
		* �ַ��������е��ʵ�����ĸ����д
	
	chop_linebreak
		* ����ַ���ĩβû����,����ӻ��з�
	
	contains
		* �ж��ַ������Ƿ����ָ�����Ӵ�,���� boolean 
	
	trim
		* ȥ����β�ո�

	date, time, datetime
		* ��Date�������ݵĸ�ʽ��
		* ���������Ǹ�ʽ���ĸ�ʽ
		* Ҳ��������Ĭ�ϵĸ�ʽ������
	
	ends_with
		* �ж��ַ����Ƿ���ָ�����Ӵ�����β
	
	ensure_ends_with
		* ����ַ���û����ָ�����ַ�����β
		* ����ָ�����ַ�����ӵ���β

	ensure_starts_with
		* ͬ��,�ַ����Ƿ���ָ�����ַ�����ͷ

		* �����ָ������������,��ô��һ���ͻᱻ����Ϊ'������ʽ'
		* �������ƥ���ַ����Ŀ�ͷ,��ô�ڶ�������ָ�����ַ����ͻ���ӵ��ַ�����ͷ
		* �÷���Ҳ���ܵ�������־λ����,(Ҳ����������ʽģʽ)

	length
		* �ַ���������

	index_of
		* �������ַ�����һ�γ��ֵ�λ��,û�ҵ�����-1
	
	left_pad
		* ����һ������n,����ַ�������n���ȵĻ�,���Զ���ǰ����ӿո�
			${" a"?left_pad(5)}		//"    a"
		
		* ������ڵڶ�����,Ҳ��һ���ַ�, ��ô����ַ��������滻Ĭ�ϵĿո�������
			${" a"?left_pad(5,"-")}		//"--- a"

		* �ڶ�������Ҳ�����Ǹ����ȱ�1����ַ���,��ô����ַ����������ԵĲ���
			${" a"?left_pad(5,"abcd")}		//"abc a"	
	
	right_pad
		* ͬ��,�������ں������

	lower_case
		* ת��ΪСдģʽ
	
	upper_case
		* ת��Ϊ��дģʽ
	
	url
		* �����ݽ���url����
		* ����ת�����б�����URL�ַ� (/,=, &,��...)
			<a href="foo.cgi?x=${x?url}&y=${y?url}">Click here...</a>
		
		* ����URI������ַ���
			<#setting url_escaping_charset="UTF-8">

		* Ҳ�����ڲ�����ָ��
			${x?url('UTF-8')}
	
	url_path
		* ͬ��,��������ת��б��(/)�ַ�
		* Ҳ����ָ���ַ���
			url_path('utf-8')
	
	number
		* ת��Ϊ����
	
	replace
		* ʹ�ò���2,�滻����1���Ӵ���
	
	remove_beginning
		*  �Ƴ�ָ����ͷ���ַ���,�����ͷ���ַ�������ָ����,�򷵻�ԭ����

	remove_ending
		* ͬ��,�Ƴ�β����
	
	split
		* ���ַ�������ָ�����Ӵ����ָ�Ϊ����
	
	starts_with
		* �����ָ�����ַ�����ʼ,���� true
	

---------------------
��ֵ���			 |
---------------------
	abs
		* ����ֵ
	c
		* ���ؼ�����ܿ���������
	
	int
		* ת��Ϊint����
	
	long
		* ת��Ϊlong����
	
	string 
		* ת��Ϊ�ַ���
		* ����ͨ�� number_format �� locale ���õ�Ĭ�ϸ�ʽ
		* ����Ԥ��������ָ�ʽ
			computer
			currency
			number 
			percent

			<#assign x=42>
			${x}
			${x?string}  <#-- ���θ�ʽ������,����� ${x} һ�� -->
			${x?string.number}
			${x?string.currency}
			${x?string.percent}
			${x?string.computer}

		* ������ʹ�� Java ���ָ�ʽ�﷨(ʹ��[]���ñ��ʽ) �е��������ָ�ʽ(DecimalFormat)
			<#assign x = 1.234>
			${x?string["0"]}
			${x?string["0.#"]}
			${x?string["0.##"]}
			${x?string["0.###"]}
			${x?string["0.####"]}

			${1?string["000.00"]}
			${12.1?string["000.00"]}
			${123.456?string["000.00"]}

			${1.2?string["0"]}
			${1.8?string["0"]}
			${1.5?string["0"]} <-- 1.5, rounded towards even neighbor -->
			${2.5?string["0"]} <-- 2.5, rounded towards even neighbor -->

			${12345?string["0.##E0"]}

---------------------
�������			 |
---------------------
	date
		* �����ڲ��֣�û��һ�쵱�е�ʱ�䲿�֡�
	time
		* ��һ�쵱�е�ʱ�䲿�֣�û�����ڲ��֡�
	datetime
		* ���ں�ʱ�䶼��
	
	# ��������������֧��ͨ��������������־�ĸ�ʽ��
	# Ҳ��������ȫ�ֵĸ�ʽ����ʽ
		date_format,time_format,datetime_format

	string
		* Ҳ�������ڸ�ʽ������,�����ò���ָ����ʽ��
		* �����������ָ�ʽ������,��ʶ����
			${time?string('yyyy-MM-dd HH:mm:ss')}

	number_to_date
	number_to_time
	number_to_datetime
		* ���Ϻ����������ڰ���ֵ(Timestamp)ת��Ϊ����

---------------------
boolean				 |
---------------------
	c
		* ���������ܿ�����"true"/"false"
		* ���Ҫ��ȾΪjavascript�Ĵ���,��������

	then
		* ��ʽ��bool�����
			${true?then('true','false')}

---------------------
����				 |
---------------------
	chunk
		* �����зָ�Ϊ���������,ÿ�������еĳ���Ϊ��һ������������ֵ (arr?chunk(3))
			<#assign arr = [0,1,2,3,4,5,6,7,8,9]>
			<#list arr?chunk(3) as subArr>
				<#list subArr as item>
					${item}
				</#list><br/>
			</#list>			
			0 1 2 
			3 4 5 
			6 7 8 
			9 
		* Ҳ����ָ���ڶ�������,������,�����г��Ȳ���ʱ��ʲô����?
			<#assign arr = [0,1,2,3,4,5,6,7,8,9]>
			<#list arr?chunk(3,'-') as subArr>
				<#list subArr as item>
					${item}
				</#list><br/>
			</#list>			
			0 1 2 
			3 4 5 
			6 7 8 
			9 - -	
	
	first
		* ���ص�һ��Ԫ��
	last
		* �������һ��Ԫ��
	
	join
		* ʹ��ָ�����ַ��������������������Ԫ��,�γ�һ���µ��ַ���
			${[0,1,2,3,4,5,6,7,8,9]?join('-')}
			0-1-2-3-4-5-6-7-8-9
	
		* ����������������
			1. �ָ���,�Ǳ����:���뵽ÿһ���м���ַ���
			2. ��ֵ,Ĭ���� "" (���ַ���),�������Ϊ��([]),ʹ�ø�ֵ
			3. �б��β,Ĭ���� "" (���ַ���): ����б����в�Ϊ��,��ֵ�����һ��ֵ�������
		
	reverse
		* ��ת
	
	seq_contains
		* �ж��������Ƿ����ָ����ֵ,���� boolean
		* ʹ�� == ������
			${[1,2,3,4,6]?seq_contains(5)?then('����','������')}
	
	seq_index_of
		* ����ָ��Ԫ�ص�һ�γ��ֵĽǱ�,���δ�ҵ�,���� -1
		* ������ʼ������ֵ�����ɵڶ�����ѡ������ȷ��
	
	seq_last_index_of
		* ����ָ��Ԫ�����һ�γ��ֵĽǱ�,���δ�ҵ����� -1
		* ������ʼ������ֵ�����ɵڶ�����ѡ������ȷ��
	
	size
		* �������еĳ���
	
	sort
		* ��������������,������Ԫ����:��ֵ,�ַ���,boolean,Date ʱ��Ч
		* Ҫʹ�ý�������ʱ,ʹ����֮��ʹ�� reverse �ڽ�����
			<#assign ls = ["whale", "Barbara", "zeppelin", "aardvark", "beetroot"]?sort>
			<#list ls as i>${i} </#list>

	sort_by
		* ��������������,����Ԫ���Ƕ���
		* ͨ��������ָ������������ֶ�
			<#assign ls = [
			  {"name":"whale", "weight":2000},
			  {"name":"Barbara", "weight":53},
			  {"name":"zeppelin", "weight":-200},
			  {"name":"aardvark", "weight":30},
			  {"name":"beetroot", "weight":0.3}
			]>

			<#list ls?sort_by("name") as i>	</#list>
	
		* ����������ӱ����Ĳ�κ��� (Ҳ����˵,�����ӱ������ӱ������ӱ���,�Դ�����), ��ô����ʹ����������Ϊ����,��ָ�����ӱ���������
			<#assign members = [
				{"name": {"first": "Joe", "last": "Smith"}, "age": 40},
				{"name": {"first": "Fred", "last": "Crooger"}, "age": 35},
				{"name": {"first": "Amanda", "last": "Fox"}, "age": 25}]>
			<#list members?sort_by(['name', 'last']) as m></#list>

---------------------
����/Hash			 |
---------------------
	keys
		* �������е�key,��һ������
	
	values
		* �������е�value

---------------------
		����		 |
---------------------
	switch
		* ��������:matchedValue?switch(case1, result1, case2, result2, ... caseN, resultN, defaultResult)
			<#list ['r', 'w', 'x', 's'] as flag>
				${flag?switch('r', 'readable', 'w' 'writable', 'x', 'executable', 'unknown flag: ' + flag)}
			</#list>
			readable
			writable
			executable
			unknown flag: s
		
		* ���һ��������û�ҵ���Ĭ��ֵ
		* result  ��һ���ǳ���,Ҳ�����Ǳ��������������ӵı��ʽ

	has_content
		* �������(����Java�� null) ���ڶ��Ҳ���"��"�ͷ��� true,���򷵻� false
		* ��ֵ
			����Ϊ0���ַ���
			û���ӱ��������л��ϣ��
			һ���Ѿ��������һ��Ԫ�صļ���
		
		${""?has_content?c}		//false
		${[]?has_content?c}		//false


---------------------
���������ж�		 |
---------------------

	is_string		�ַ���
	is_sequence		����
	is_enumerable	���л򼯺�
	is_collection	���� (������չ�ļ���)
	is_collection_ex	��չ�ļ��� (֧�� ?size)
	is_number		����
	is_boolean		����ֵ
	is_hash			��ϣ�� (������չ�Ĺ�ϣ��)
	is_hash_ex		��չ�Ĺ�ϣ�� (֧�� ?keys �� ?values)
	is_indexable	����

	is_date			��Ҫʹ������ʹ�� is_date_like ������, ��������ͬ�ġ�����Ҳ����޸����ĺ���Ϊ date_only��
	is_date_like	����,Ҳ���ƺ�����,ʱ���������-ʱ��, �������δ֪��ȷ���͵�����(�� FreeMarker 2.3.21 �汾��ʼ)
	is_date_only	���� (û��ʱ�䲿��) (�� FreeMarker 2.3.21 �汾��ʼ)
	is_time			ʱ�� (û����-��-�ղ���) (�� FreeMarker 2.3.21 �汾��ʼ)
	is_datetime		����-ʱ�� (������-��-�պ�ʱ������)
	is_unknown_date_like	����������ڻ�ʱ�������-ʱ�������
	is_method		����
	is_transform	�任
	is_macro		�����(��Ȼ,������ʷ����,Ҳ�Ժ�����Ч)
	is_directive	ָ������ (����� �� TemplateDirectiveModel, TemplateTransformModel, ��...), ���ߺ��� (������ʷ����)
	is_node			�ڵ�
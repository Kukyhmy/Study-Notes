--------------------
ȡֵ���ʽ			|
--------------------
	# ȡֵ���ʽ�����ս����"�ַ���"
	# ֱ��ȡֵ
		* model����
			${name}
			${user.name}  ${user["mame"]}
			${user.author.name} ${user["author"].name} ${user["author"]["name"]}

			* ��������������������������,��Ҫʹ��ת���ַ�
				���ʽΪ data\-id,��Ϊ data-id �������ͳ� "data ��ȥ id"
				��Щת����ڱ�ʶ����������,�������ַ����С�
		
		* ����
			${"����һ���ַ���"}

		* �ַ���֧��ת��
			\"		���� (u0022)
			\'		������(�ֳ�ΪƲ��) (u0027)
			\{		��ʼ�����ţ�{
			\\		��б�� (u005C)
			\n		���з� (u000A)
			\r		�س� (u000D)
			\t		ˮƽ�Ʊ��(�ֳ�Ϊtab) (u0009)
			\b		�˸� (u0008)
			\f		��ҳ (u000C)
			\l		С�ںţ�<
			\g		���ںţ�>
			\a		&����&
			\xCode	�ַ���16���� Unicode �� (UCS ��)
		
		
	# �������ı����ʽ��ʹ��
		<#include "/footer/${company}.html">
		
		* <#if ${big}>...</#if>,�﷨�ϵĴ���
	
	# ����
		* ��ȾDate����Ҫʹ�õ����õ����ں���
		* '����Ҫ'ͨ����Щ����������ģ������,Ҫ��ȾDate������Ĳ�������
			date
			time
			datetime
			
			${now?datetime}
		
		* ����ȫ�ֵĸ�ʽ��
			configuration.setSetting(Configuration.DATETIME_FORMAT_KEY_SNAKE_CASE, "yyyy-MM-dd HH-mm-ss ");	//���������� datetime 
			${now?datetime}

		* ����ʹ�� ?string ��ʱ��dateת��Ϊָ������������
			${now?string("yyyy��MM��dd�� HHʱmm��ss��")}

	
	# boolean ֵ
		* ֱ�����booleanֵ���쳣,����ʹ���ڽ����� ?then ��������ֵת��Ϊ�ַ�����
			${married?then("yes", "no")}
		
		* Ҳ����ͨ�� ?c ֱ�����'�����'���Կ����� true/false
			${someBoolean?c}	

		* ����ʹ�����ò��� boolean_format ��Ϊ FreeMarker ����Ĭ�ϵĲ���ֵ��ʽ,�����Ϳ���ֱ����� boolean ���͵ı���:${married}

		* string("true","false") Ҳ�������ڸ�ʽ��bool����,�����Ѿ������ˡ�
	

	
	# Map
		* ���map��key��string������ֱ��ʹ�� . ���� [] ȡֵ

		* ���map��key����string���Ƚ��鷳����Ҫ������

			configuration.setAPIBuiltinEnabled(true);
			DefaultObjectWrapper defaultObjectWrapper = (DefaultObjectWrapper) configuration.getObjectWrapper();
			defaultObjectWrapper.setUseAdaptersForContainers(true);
		
		* ȡֵ���ʽ
			<#list mine?keys as key>
				${key?c} - ${mine?api.get(key)}<br/>
			</#list>

			* ʹ��: ?api.get() ����ȡ���ַ�����value
		

--------------------
ֵ��				|
--------------------
	# ���ڱ�ʾ��һ�������ѭ��
		start..end
			* ָ����ʼ�ͽ�β�Ǳ�
			* ������β��ֵ��,���� 1..4 ���� [1, 2, 3, 4], �� 4..1 ���� [4, 3, 2, 1]
			* ע��, ������β��ֵ������һ��������,���Ϊ�յĻ� 0..length-1 ���Ǵ����,��Ϊ������(length)Ϊ 0 ��,���оͳ��� [0, -1]
		
		start..<end �� start..!end
			* ָ����ʼ�ͽ�β�ĽǱ�(��ͷ����β)
			* ��������β��ֵ��,���� 1..<4 ���� [1, 2, 3],4..<1 ���� [4, 3, 2],
			* �� 1..<1 ��ʾ [],����ʽ�Ľ����������ǿ�����,�� 
			* ..< �� ..! û������,���������ʽ��Ӧ�ó�����ʹ���� < �ַ�����������(��HTML�༭����)
		
		start..*length
			* ָ����ʼ�ĽǱ��Լ�Ҫ��ȡ�ĳ���
			* �޶����ȵ�ֵ��,���� 10..*4 ���� [10, 11, 12, 13],10..*-4 ���� [10, 9, 8, 7]
			* �� 10..*0 ��ʾ [],����Щֵ�������з�ʱ, ����зֺ�����л����ַ�����β��ָ��ֵ�򳤶�֮ǰ,���зֲ���������
		
		start..
			* ���ұ߽�ֵ��,������Ƴ��ȵ�ֵ�����,ֻ�ǳ��������޵�
			* ���� 1.. ���� [1, 2, 3, 4, 5, 6, ... ],ֱ�������
			* ���Ǵ���(�����б���ʾ)����ֵ��ʱҪ���С��,����������ʱ, �Ứ�Ѻܳ�ʱ��,ֱ���ڴ����Ӧ�ó������
			* ���޶����ȵ�ֵ��һ��,�����Ǳ��з�ʱ,�����зֺ�����л��ַ�����βʱ,�з־ͽ�����

--------------------
�ַ����Ĳ���		|
--------------------
	# �ַ�����ƴ��
		<#assign s = "Hello ${name}!"> //x = Kevin
		${s} //Hello Kevin
		
		<#assign s = "Hello " + user + "!">
		${s}//Hello Kevin
		
	
	# ����������ȡ�ַ�
		${user[0]}		//��ȡ�ַ����ĵ�һ���ַ�
		${user[4]}		//��ȡ�ַ����ĵ������ַ�
	
	# �ַ����и�
		<#assign s = "ABCDEF">
		${s[2..3]}		CD		//��ָ���ĽǱ굽ָ���ĽǱ�
		${s[2..<4]}		CD		//��ָ���Ǳ굽ָ���Ǳ�һ��
		${s[2..*3]}		CDE	
		${s[2..*100]}	CDEF
		${s[2..]}		CDEF	//��ָ���Ǳ��Ժ�

		
		* �����ַ��������ú���
			remove_beginning
			remove_ending
			keep_before
			keep_after
			keep_before_last
			keep_after_last


--------------------
���еĲ���			|
--------------------
	# ����ȡֵ
		${user.skills[0].id}

	# ���е�����
		<#list ["Joe", "Fred"] + ["Julia", "Kate"] as user>
			- ${user}
		</#list>	
	
	# �����з�
		<#assert seq = ["A", "B", "C", "D", "E"]>
		<#list seq[1..3] as i>
			${i}		//���BCD
		</#list>	
		
		* seq[1..3] ��ʾ������������1-3�Ǳ��Ԫ��
		* �зֺ������е�����ֵ���˳����ͬ,��ô�����ʾ����,���ֵ���� 3..1 ������� 'DCB'
		* ֵ���е����ֱ��������п�ʹ�õĺϷ�����
			- seq[-1..0]
			- seq[-1]
			- seq[1..5]	�쳣,��Ϊ5���������Ǳ�4
			- seq[100..<100] �Ϸ�
			- seq[100..*0]	�Ϸ�	

--------------------
Hash				|
--------------------
	# ����
		<#assign ages = {"Joe":23, "Fred":25} + {"Joe":30, "Julia":18}>
		- Joe is ${ages.Joe}
		- Fred is ${ages.Fred}
		- Julia is ${ages.Julia}
	
		* �Ҳ�ĻḲ��ǰ���ͬ������

--------------------
����				|
--------------------		
	# ֧�� +-*/%������
	# �ַ�������ֵ���,���Զ�ת����ֵΪ�ַ���
	# �ַ�������ִֵ�г��������������в���,�����쳣
	# �Ƚ�����
		<#if user == "Big Joe">
		  It is Big Joe
		</#if>
		<#if user != "Big Joe">
		  It is not Big Joe
		</#if>
		
		* = �� != ���ߵı��ʽ�Ľ���������Ǳ���,����������������������ͬ���� (Ҳ����˵�ַ���ֻ�ܺ��ַ������Ƚ�,����ֻ�ܺ��������Ƚϵ�)
		
		* �����ֺ��������͵ıȽϣ�Ҳ����ʹ�� <, <=,>= �� >
	
	# �߼����� || ,&&,!

		<#if x < 12 && color == "green">
		  We have less than 12 things, and they are green.
		</#if>
		<#if !hot> <#-- here hot must be a boolean -->
		  It's not hot.
		</#if>

--------------------
�ڽ�����			|
--------------------
	# ���ú����ĵ���
		${����?ִ�з���}
		${����?ִ�з���(��������)}
		${����?ִ�з���1(��������)?ִ�з���2}

		${testString?upper_case}
		${testString?html}
		${testString?upper_case?html}

		${testSequence?size}
		${testSequence?join(", ")}
	
	# �ڽ�������������������ı��ʽ,���������Ǳ�����
		${testSeqence[1]?cap_first}
		${"horse"?cap_first}
		${(testString + " & Duck")?html}	
	
--------------------
��������			|
--------------------
	# �Զ���ķ�������
		${repeat("Foo", 3)}
	
	# ��������Ҳ����ͨ���ʽ,����������һ����
		${repeat(repeat("x", 2), 3) + repeat("Foo", 4)?upper_case}

--------------------
�����ڵ�ֵ����		|
--------------------

	# Ĭ��ֵ������
		unsafe_expr!default_expr					${name!"Ĭ��ֵ"}
		unsafe_expr! or (unsafe_expr)!default_expr	${name!}	${(name)!"Ĭ��ֵ"}
		(unsafe_expr)!								${(name)!}
	
	# Ĭ��ֵ�������κ����͵ı��ʽ,Ҳ���Բ������ַ���
		hits!0 
		colors!["red", "green", "blue"]
		cargo.weight!(item.weight * itemCount + 10)
	
	
	# �����л�չ�ϣ��,�������Ĭ��ֵΪ 0 �� false,����ʡ��Ĭ��ֵ
	
	# �ڷǶ������ʱ,Ĭ��ֵ����������������ʹ�÷�ʽ
		${product.color!"red"}		
			* ��� color ���Բ�����,Ĭ�Ϸ��� red
			* ��� product ���Բ�����,ģ���쳣
		
		${(product.color)!"red"}
			* ��� product ���Բ����ڻ��� color ���Բ�����,���᷵�� red
		
		
		* ���û������,����������ʽ����һ�����Կ���δ������
		

	# ������ֵ��������:unsafe_expr?? �� (unsafe_expr)??
		<#if mouse??>
		  Mouse found
		<#else>
		  No mouse found
		</#if>
		Creating mouse...
		<#assign mouse = "Jerry">
		<#if mouse??>
		  Mouse found
		<#else>
		  No mouse found
		</#if>
	
	# Ĭ��ֵ����Ҳ���������������ӱ���
		<#assign seq = ['a', 'b']>
		${seq[0]!'-'}
		${seq[1]!'-'}
		${seq[2]!'-'}
		${seq[3]!'-'}
				
		a
		b
		-			//�Ǳ겻����,���--
		-
	
		* ������������Ǹ���(���� seq[-1]!'-') Ҳ�ᷢ������,����ʹ�ø�������������������ȥѹ����


--------------------
��ֵ������			|
--------------------
	# �����Ǳ��ʽ,ֻ�Ǹ���ָ���﷨��һ����,���� assign, local �� global
		<#assign x += y> �� <#assign x = x + y> �ļ�д
		<#assign x *= y> �� <#assign x = x * y> �ļ�д
		<#assign x--> �� <#assign x -= 1> �ļ�д
	
		<#assign x++> �� <#assign x += 1>��ͬ,��ֻ�������ӷ����� (��������������ֵĻ��ͻ�ʧ��)
	
--------------------
����				|
--------------------
	//TODO

--------------------
���ʽ�еĿո�		|
--------------------
	# FTL ���Ա��ʽ�еĶ���� �ո�����ı�ʾ����ͬ�ģ�

--------------------
�������			|
--------------------
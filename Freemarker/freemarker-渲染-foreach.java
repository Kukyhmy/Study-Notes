---------------------------
������Ⱦ�е�ѭ��			|
---------------------------
	# �򵥵���Ⱦ
		<#list arr as item>
			...
		<#else>
			... arr Ϊ[]
		</#list>
	
	# ��ѭ����ʼ�ͽ�β��������
		<#list sequence>
			//��ѭ��֮ǰִ��һ��
			<#items as item>
				// ��ʼѭ��ÿһ��Ԫ��
			</#items>
			//��ѭ��֮��ִ��һ��
		<#else>
			//�ռ���
		</#list>
	
	# �ڵ�һ��֮��,���һ��֮ǰ��Ӷ���
		<#list users as user>
			${user}<#sep>, </#sep>
		</#list>

		* ʹ��<#sep>ָ��,��ָ����ַ��ᱻ��ӵ�ÿ�����������
		* ���ǻ�������һ��������ĺ���
		* �ǳ�����
	
	# �ж�ѭ��
		<#list 1..10 as x>
		  ${x}
		  <#if x == 3>
			<#break>
		  </#if>
		</#list>
	
	# ���ʵ���״̬
		* ͨ�����ú�������������
			<#list ['a','b'] as item>
				${item}-${item?index}-${item?has_next?c}<br/>
			</#list>

		* ����ʹ�õĺ���
			counter
				* �����1��ʼ������
			has_next
				* �Ƿ�����һ��
			index
				* ���ش�0��ʼ������
			is_even_item
				* �Ƿ���������
			is_first
				* �Ƿ��ǵ�һ��
			is_last
				* �Ƿ������һ��
			is_odd_item
				* �Ƿ�Ϊż����
			item_cycle
				*  ��ָ����ֵ������ "odd" �� "even", ��Ҳ�����������ֵ��ѭ��
				*  ȡģ�㷨
					<#list ['a', 'b', 'c', 'd', 'e', 'f', 'g'] as i>
					  ${i}-${i?item_cycle('row1', 'row2', 'row3')}</br>
					</#list>
					* ��һ��ֵΪ:row1
					* ���ĸ�ֵΪ:row1
				

			item_parity
				* ���ص�ǰ����������ż��
				*  �����ַ���ֵ "odd" �� "even"

			item_parity_cap
				* ͬ��,���ص��Ǵ�д��ͷ
				* �����ַ���ֵ "Odd" �� "Even"
					
	

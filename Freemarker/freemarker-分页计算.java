<div>
	<#-- �ܼ�¼�� -->
	<#assign total = total/>
	<#-- ��ǰҳ�� -->
	<#assign page = page/>
	<#-- ÿҳ��ʾ���� -->			
	<#assign rows = rows/>
	
	<#-- �������ҳ�� -->
	<#if (total % 10 == 0)>
		<#assign totalPage = (total / rows)?int />
		<#else>
		<#assign totalPage = ((total / rows) + 1)?int />
	</#if>
	
	<#-- Ԥ�����ҳ���� -->
	<#assign begin = 0/>
	<#assign end = 0/>
	
	<#if (totalPage <= 10)>
		<#assign begin = 1/>
		<#assign end = totalPage/>
		<#else>
		<#assign begin = page - 5/>
		<#assign end = page + 4/>
		<#if (begin < 1)>
			<#assign begin = 1/>
			<#assign end = 10/>
		</#if> 
		<#if (end > totalPage)>
			<#assign begin = totalPage - 9/>
			<#assign end = totalPage/>
		</#if>
	</#if>
	
	<#-- ��ʾ��ҳ -->
	<#if (begin > 1)>
		<a href="/test/page?page=1">��ҳ</a>
	</#if>
	
	<#-- ��ʾ��һҳ -->
	<#if (page > 1)>
		<a href="/test/page?page=${page - 1}">��һҳ</a>
	</#if>
	
	<#-- ����ҳ�� -->
	<#list begin..end as val>
		<#if (val == page)>
			<#-- ��ǰҳ������Ⱦ���� -->
			<a>[${val}]</a>
			<#else>
			<#-- �ǵ�ǰҳ -->
			<a href="/test/page?page=${val}">[${val}]</a>
		</#if>
	</#list>
	
	<#-- ��ʾ��һҳ -->
	<#if (totalPage > page)>
		<a href="/test/page?page=${page + 1}">��һҳ</a>
	</#if>
	
	<#-- ��ʾβҳ -->
	<#if (totalPage > end)>
		<a href="/test/page?page=${totalPage}">���һҳ</a>
	</#if>
</div>
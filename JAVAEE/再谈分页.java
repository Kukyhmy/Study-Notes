6������

1,��ǰҳ		pageCode	pc
	> ���ҳ��û�д��ݵ�ǰҳ��,��ôĬ�Ͼ��ǵ�һҳ.
	> �����������ǵڼ�ҳ,�Ҿ͸���ڼ�ҳ
2,��ǰҳ����		totalPages	tp
3,�ܼ�¼��		totalRecored	tr
	> ί��DAO���ȡ���ݿ���Ϣ
	> select count(*) from emp;
4,ÿҳ��¼��	
	> ҵ������,���߽�ϵͳ����.��������û��ϵ,���ǿ�����ô��.������ͻ�һҳ��ʾ����
5,��ҳ��		beanList	bl
	> �ܼ�¼/ÿҳ��¼��
	> Ҳ�������һҳ��ҳ��
6,url		--û��ôŪ��,���������ģ����ѯ��ʱ�����õ�

-------------------------

��Ϊ��������,��Ҫ�ڸ���֮�䴫��.���ǾͿ��Կ���,��װ��javaBaen��.��javaBean�о�Ҫ�߱���6������.��Ҫһ������List��װ�������˾�������,Ҳ�����ṩ��ҳ����ʾ��������javaBean,ϣ��������
��Ϊһ�������ڸ���֮�䴫��.

-------------------------

select * from ���� limit n,m;
	> ��ȡ��ѯ���,��n��ʼ,ȡm��
	* ע��:MYSQL��,��һ�������Ǵ�0��ʼ��,limit���,������Լ�
		Ҳ����n,��СֵΪ0,m�������а����˵�n������.
��ʹ��limit����ʱ,��Ҫ�ο����㷨
	> ��ǰҳ-1 * ÿҳ��¼��
	> �����ǰҳ���ɿͻ����ṩ��,����ͻ���δ�ṩ,���Ǿ�Ĭ����ʾ��һҳ����,
	> ��������ǰҳ�Ǹ���,��ôsql���������,limit ���ĵ�һ����������Ϊ��,��СΪ0;

-------------------------

����ʾҳ����ʾ���ݵ�ʱ��
1,��Ϊ��һҳ��ʱ����ʾ[��һҳ]������/��ť
	> ��ǰҳֻҪ����1,����ʾ		�������1,�Ǿ��ǵ�һҳ��.��û��Ҫ��ʾ��һҳ
2,��Ϊ���ҳ��ʱ����ʾ[��һҳ]������/��ť
	> ��ǰҳС����ҳ��,����ʾ		�����ǰҳ��������ҳ��,��ô�������һҳ��.û��Ҫ��ʾ��һҳ

-------------------------ҳ���б�  [1] [2] [3] [4] [5]
���ֶ���,�����ʾ���ٸ�ҳ��,ȡ������ũ��BOSS.
��ǰҳ��ҳ���б��е�λ��.....[1][2]��3��[4][5] 
	> �ٶȵ�ҳ��λ���ڵ�6��,���ǿ��Բο�����!
	> ֻ��Ҫ��ǰҳ��,���ܶ�����ҳ���б�.
begin
end
	��Ҫʹ��pc���������begin,end...
	begin = pc - 5;
	end   = pc + 4;
���㹫ʽ:
	�����ҳ��С�ڵ����б���.��ôbegin�͵���1,end������ҳ��
	ʹ������ļ��㹫ʽ������
	ͷ���:��beginС��1��ʱ��,begin = 1
	β���:��end > tpʱ,����end =tp

------------------ֱ�Ӵ���,ǧ���ɵ
	<center>
		<%--������ҳ��ص����� --%>
		��${requestScope.pb.pc }ҳ/��${requestScope.pb.tp }ҳ
		<a href="<c:url value='/CustomerServlet?method=findAll&pc=1'/>">��ҳ</a>
		<c:if test="${requestScope.pb.pc > 1 }"><%--��һҳ�ж� --%>
			<a href="<c:url value='/CustomerServlet?method=findAll&pc=${requestScope.pb.pc-1 }'/>">��һҳ</a>
		</c:if>
		<%--���� choose��ǩ�����ڼ��㿪ʼ�����ҳ,�����޶�ҳ���б���Ϊ10,��ǰҳ��Ϊ��6�� --%>
		<c:choose>
			<%--��ҳ������10ҳ,��ô�����е�ҳ������ʾ���� --%>
			<c:when test="${requestScope.pb.tp <=10 }">
				<c:set var="begin" value="1"/>
				<c:set var="end" value="${requestScope.pb.tp }"/>
			</c:when>
			<%--����ҳ������10 ��ʱ��,ͨ����ʽ�����begin��end --%>
			<c:otherwise>
				<c:set var="begin" value="${requestScope.pb.pc - 5 }"/>
				<c:set var="end" value="${requestScope.pb.pc+4 }"/>
				<%-- ͷ���--%>
				<c:if test="${begin < 1 }">
					<c:set var="begin" value="1"/>
					<c:set var="end" value="10"/>
				</c:if>
				<%-- β���--%>
				<c:if test="${end > pb.tp }">
					<c:set var="begin" value="${requestScope.pb.tp - 9 }"/>
					<c:set var="end" value="${requestScope.pb.tp }"/>
				</c:if>
			</c:otherwise>
		</c:choose>
		<%--ҳ�������� --%>
		
		<%-- ѭ������ҳ���б� --%>
		<c:forEach var="x" begin="${begin }" end="${end }">
			<c:choose>
				<c:when test="${x eq pb.pc }"><%--�жϵ�ǰҳ����ʾΪ������ --%>
					[${x }]
				</c:when>
				<c:otherwise><%--�ǵ�ǰҳ,��ʾ������ --%>
					<a href="<c:url value='/CustomerServlet?method=findAll&pc=${x }'/>">[${x }]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<%-- ��һҳ�����һҳ --%>
		<c:if test="${requestScope.pb.pc < requestScope.pb.tp }"><%--���һҳ�ж� --%>
			<a href="<c:url value='/CustomerServlet?method=findAll&pc=${requestScope.pb.pc+1 }'/>">��һҳ</a>
		</c:if>
		<a href="<c:url value='/CustomerServlet?method=findAll&pc=${requestScope.pb.tp }'/>">βҳ</a>
	</center>


======================== js�㷨

//Ԥ���忪ʼ
var begin = 0;

//Ԥ�������
var end = 0;

if(pageInfo.totalPage <= 10){
	begin = 1;
	end = pageInfo.totalPage;
}else{
	begin = pageInfo.page - 5;
	end = pageInfo.page + 4;
	if(begin < 1){
		begin = 1;
		end = 10;
	}
	if(end > pageInfo.totalPage){
		begin = pageInfo.totalPage - 9;
		end = pageInfo.totalPage;
	}	
}

if(begin > 1){
	//������ҳ��ť
}
if(pageInfo.page > 1){
	//������һҳ��ť
}

for(let i = begin ; i <= end; i++){
	//����ҳ����ť
}

if(pageInfo.totalPage > pageInfo.page){
	//������һҳ��ť
}

if(pageInfo.totalPage > end ){
	//����βҳ��ť
}
��ʵ�Ӳ�ѯҲ�����
  * һ��SQL����г��ֶ��select�ؼ���,��ô���������Ӳ�ѯ

�Ӳ�ѯ���Գ��ֵ�λ��
	selet  from �Ӳ�ѯ where �Ӳ�ѯ;
	��ʵ����һЩ��ѯ���Ľ������һ�ű�,���Ƕ��������������2�β�ѯ
	select r.ename,r,empno
	from (select * from emp where deptno=30) as "r"

	���Ӳ�ѯ������where��,�Ǿ�����Ϊ������(���е���)
	���Ӳ�ѯ������from��,�Ǿ�����Ϊ�˱�Ĵ���(���ж���)

Ȼ���Ӳ�ѯ�����Ľ�����ַ�ΪN����,���ݲ�ͬ�Ľ�������Բ��ò�ͬ�������
	
���е���	>,<,=...�Ͼ��Ӳ�ѯ������һ�����.���Խ����ж�
���е���	in,not in,<all(����),>any(����),!=all(������) ��ѯ��������һ�м�¼,Ҫʹ�õ����ϲ�����
���ж���	in	��ѯ�������ǵ��ж��� ��������ʽ,���ǱȽ��ټ���
���ж���	select c.* from �Ӳ�ѯ as c where...  ����Ӳ�ѯ������ʵ����һ�ű����Ѿ�


���е���
	SELECT * FROM user WHERE age=(SELECT MAX(age) FROM user);
	//���Ӳ�ѯ,��ȡ����user������������ֵ.Ȼ��ʹ�ø�ֵ��Ϊ�����ٴν����˲�ѯ
���е���
	SELECT * FROM _user WHERE age in (SELECT age FROM _user WHERE age < 22);
	//���Ӳ�ѯ,��ȡ����user��С��22����������,����ѯ���ж�ֵ�Ƿ�
���ж���
	SELECT c.name FROM (SELECT * FROM user WHERE age=21) AS c;
	//���Ӳ�ѯ,�ǲ�ѯ��user���е�����age����21�ļ�¼,Ȼ���ִ������¼�в�ѯ�����е�name
	//��Ϊ����'��',����ʱ���ɵ�,��ѯ����,�漴�ͷ�.���Ա��������
	

(SELECT * FROM _user WHERE age IN (SELECT age FROM _user WHERE age > 22 )) UNION (SELECT * FROM  _user WHERE age NOT IN (SELECT age FROM _user WHERE age > 22 ));






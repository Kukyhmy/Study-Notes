-------------------------------
���ʹ���ڲ�jQuery				|
-------------------------------
	# ����Layui��������ģ������jQuery,����jQuery1.11���ȶ���һ���汾��Ϊһ�����õ�DOMģ��(Ψһ��һ��������ģ��)
	# ֻ������ʹ�õ�ģ������������,���Ż����,����������ҳ���Ѿ�script������jquery,���������ظ�����
	# ���õ�jqueryģ��ȥ����ȫ�ֵ�$��jQuery,��һ������layui�淶�ı�׼ģ��.���������ͨ�����·�ʽ�õ�:
		//��������jqueryģ��
		layui.use(['jquery', 'layer'], function(){ 
			var $ = layui.jquery;	//�ص㴦
			var layer = layui.layer;

			//����͸���ƽʱʹ��jQueryһ��
			$('body').append('hello jquery');
		});

	# ������õ�ģ�鱾��������jquery,��ô����ȥuse jquery,
		* ���������д����ʵ�����ǣ�
		layui.use('layer', function(){ 
			var $ = layui.jquery;	//����layer��������jQuery,���Կ���ֱ�ӵõ�
			var layer = layui.layer;

			//����
		});

-------------------------------
Ϊʲô������ʾ				|
-------------------------------
	# ʹ�ñ�ʱ,Layui���select,checkbox,radio��ԭʼԪ������,�Ӷ������������δ���
	# ������Ҫ������form���,������������ form,����ִ��һ��ʵ����
	# ֵ��ע�����:������HoverЧ��,Tabѡ���ͬ��(���������� element ģ��)
	# Demo
		layui.use('form', function(){
			var form = layui.form(); //ֻ��ִ������һ�������ֱ�Ԫ�زŻ����γɹ�

			//����
		});      

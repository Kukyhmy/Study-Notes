--------------------------------
layui-ģ��淶					|
--------------------------------

--------------------------------
layui-Ԥ�ȼ���					|
--------------------------------
	# Layui��ģ����ز��ú��ĵ� layui.use(mods, callback)����
	# �� JS ��Ҫ�õ�Layuiģ���ʱ��,�Ƽ�����Ԥ�ȼ���,��Ϊ�������Ա��⵽��дlayui.use���鷳
	# ��Ӧ�����������˶���:
		layui.use(['form', 'upload'], function(){  //���ֻ����һ��ģ�飬���Բ������顣�磺layui.use('form')
			var form = layui.form();	//��ȡformģ��
			var upload = layui.upload;	//��ȡuploadģ��

			//�����ύ��ť
			form.on('submit(test)', function(data){
				console.log(data);
			});

			//ʵ����һ���ϴ��ؼ�
			upload({
				url: '�ϴ��ӿ�url',
				success: function(data){
					console.log(data);
				}
			})
		});

--------------------------------
layui-�������					|
--------------------------------
	# �ٷ����Ƽ�,���Բ�˵��

--------------------------------
layui-ģ�������ռ�				|
--------------------------------
	# Layui��ȫ��ģ����� layui������
	# �ڲ���layui.define()���������,ÿһ��ģ�鶼��һ�����е�����,�����޷���ռ��
	# ���赣��ģ��Ŀռ䱻��Ⱦ,�������� delete layui.mod;
	# ����һ��ģ��Ҳ�������layui����ĸ�ֵ���磺

		layui.use(['layer', 'laypage', 'laydate'], function(){
			var layer = layui.layer;	//���layerģ��
			var laypage = layui.laypage; //���laypageģ��
			var laydate = layui.laydate;//���laydateģ��

			//ʹ��ģ��
		});      
	
	# һ��ģ��һ�����غ�,�ͻ�ע����layui������
	# �����޷�ֱ����ģ���������
	# ����layui����,��ʱ����ܻ�ֱ����Ԫ�ص��¼�������ȥ����һ��ģ��
		<input onclick="layui.laydate()">

--------------------------------
layui-��չһ��Layuiģ��			|
--------------------------------
	# Layui�ٷ��ṩ��ģ����ʱ���ܻ��޷�������
	# ��������ͼ����layer��ģ��淶����չһ��ģ��.
	# ��ô���б�Ҫ��ʶlayui.define()����
	# �ڱʼ�:�ײ�֧��,�����м򵥼���
	# ����
		1,����ģ��
			layui.define(function(exports){ 
				//��ʾ:ģ��Ҳ������������ģ���磺layui.define('layer', callback);
				var obj = {
					hello: function(str){
						alert('Hello '+ (str||'test'));
					}
				};

				//���test�ӿ�
				exports('test', obj);
			});    

		2,�趨ģ�����ڵ�Ŀ¼,Ȼ��Ϳ����ڱ��JS�ļ���ʹ����
			//config��������ȫ�ֵ�
			layui.config({
				base: '/res/js/'		//��������test.js���ڵ�Ŀ¼
			}).extend({					//�趨ģ�����
				test: 'test',			
					//���test.js���ڸ�Ŀ¼(base)��,���Բ����趨����
					//test���ģ��,��baseĿ¼�µ� test Ŀ¼��
				test1: 'admin/test1'	
					//���������baseĿ¼����Ŀ¼
					//test1���ģ��,��baseĿ¼�µ� admin/test1 Ŀ¼��
			}); 

			//ʹ��test
			layui.use('test', function(){
				var test = layui.test;

				test.hello('World!'); //����Hello World!
			});

			//ʹ��test1
			layui.use('test1', function(){
				var test = layui.test1;

				//����
			});
------------------------
1,���ı��༭��			|
------------------------
	1,������Ӧ��css��js�ļ�
		<link href="${pageContext.request.contextPath }/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
		<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
	2,���ö����ı���,�������ÿ��,������
		<td>
			<textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
		</td>
	3,ͨ��js������

		
		var itemAddEditor ;
		$(function(){
			/*	���ɸ��ı��༭��
				createEditor : function(select){
					return KindEditor.create(select, TT.kingEditorParams);
				},

				1,select:ѡ����,ѡ��һ�������ı�
				2,TT.kingEditorParams:���ı��༭����ص�һЩ����.��Ҫ���ļ��ϴ��Ĳ���

					kingEditorParams : {
						filePostName  : "uploadFile",
						uploadJson : '/rest/pic/upload',
						dir : "image"
					},
			*/
			itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]");
			TAOTAO.init({fun:function(node){
				TAOTAO.changeItemParam(node, "itemAddForm");
			}});
		});
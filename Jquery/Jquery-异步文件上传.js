----------------------------
�첽�ļ��ϴ�				|
----------------------------
	# �г��Ϻܶ��첽�ϴ��Ĳ��,���ｲ����

----------------------------
jquery.uploadify.min.js		|
----------------------------
	#  ������ļ���
		jquery.uploadify.min.js			//��js
		uploadify.css					//��ʽ
		uploadify.swf					//�ϴ�����
		uploadify-cancel.png			//�˳�ͼƬ

	<tr>
		<th>ͼƬ</th>
		<td><input name="pic" type="file" id="createUploadImage" accept="image/*"/></td>
	</tr>

	//ʹ��Jquery ���ϴ�����г�ʼ��
	$('#createUploadImage').uploadify({
		uploader : '/upload',  
		fileObjName : 'fileName',			//�ϴ��ļ�������.Ҳ����SpringMVC�� Muti....  
		fileSizeLimit : '0',  
		method:'POST',
		fileSizeLimit:'5MB',
		swf:'/static/upload/uploadify.swf',			//�ϴ�����
		fileTypeExts:'*.jpg;*.png;*.png;*.gif',		//��������
		onUploadSuccess : function(file, data, response){
			var json = JSON.parse(data);			//ע�ⷵ����������Ҫ����JSONת��,�����㱾���صľ���JSON
			$('#imagePath').val(json.data);
			$('#prop_sucreate_img').attr('src',json.data);
		},
		onUploadStart : function(file) {
			//��̬���ݶ����ύ�Ĳ���
			$("#createUploadImage").uploadify("settings", "formData",{'propgruopId':currentPropgrouId});
		},
		onUploadError : function(file, errorCode, errorMsg, errorString){
			$.messager.alert('����','�ϴ��쳣,�볢��ˢ��ҳ�������','error',function(){});
		}
	});

	//��̨����
	public ResponseEntity<Message<Void>> uplod(
											@RequestParam("fileName") MultipartFile uploadFile,
											HttpServletRequest request){
		//�߼�
		return null;
	}
---------------------------------
Jquery-�첽						 |
---------------------------------
	//��ȡ�ļ�����ļ�����
	var files = $('#file')[0].files;
	//����FormData����
	var formData = new FormData();
	//��ӵ�һ���ļ���FormData
	formData.append("file",files[0]);
	//�����ͨ����
	formData.append("name","KevinBlandy");
	$.ajax({
		url : '${ctxPath}/test/upload',
		type : 'POST',
		data : formData,
		xhr: function(){
			//��ȡ��ԭ���� XMLHttpRequest ����
			myXhr = $.ajaxSettings.xhr();
			//ȷ�� �첽�ϴ�������ϴ�����
			if(myXhr.upload){			
				//�����ϴ����Ե��ϴ��¼�,ÿ���ϴ��¼�����ִ�� progressHandlingFunction
				myXhr.upload.addEventListener('progress',progressHandlingFunction, false);
				//myXhr.upload.onprogress = function(){}			Ҳ����
			}
			//���ظ� $.ajax ʹ��
			return myXhr;
		},
		processData : false,
		contentType : false,
		success : function(response) {
			TD.showAlert(response.message);
		},
		error : function(response) {

		},
	});

	function progressHandlingFunction(event) {
		event.total;		//��ȡ�ϴ��ļ����ܴ�С
		event.loaded;		//��ȡ�Ѿ��ϴ����ļ���С
		//��ȡ���ȵİٷֱ�ֵ
		var percent  = (event.loaded / event.total) * 100;
		//�������뱣����λС��
		percent = percent.toFixed(2);
	}


---------------------------------
ԭ��-�첽						 |
---------------------------------
	//��ȡ�ļ�����ļ�����
	var files = document.getElementById("file").files;
	//����FormData����
	var formData = new FormData();
	//��ӵ�һ���ļ���FormData
	formData.append("file",files[0]);
	//�����ͨ����
	formData.append("name","KevinBlandy");
	//�����첽����
	var xhr = createXMLHttpRequest();
	//������
	xhr.open('POST','${ctxPath}/test/upload',true);
	//�����ϴ��¼�
	if(xhr.upload){
		//�����ϴ����Ե��ϴ��¼�,ÿ���ϴ��¼�����ִ�� progressHandlingFunction
		xhr.upload.addEventListener('progress',progressHandlingFunction, false);
		//xhr.upload.onprogress = function(){}			Ҳ����
	}
	//ִ���ϴ�
	xhr.send(formData);
	
	//�ϴ�����
	function progressHandlingFunction(event) {
		event.total;		//��ȡ�ϴ��ļ����ܴ�С
		event.loaded;		//��ȡ�Ѿ��ϴ����ļ���С
		//��ȡ���ȵİٷֱ�ֵ
		var percent  = (event.loaded / event.total) * 100;
		//�������뱣����λС��
		percent = percent.toFixed(2);
	}
        
	<script type="text/javascript">
	function createXMLHttpRequest(){
			try{
				return new XMLHttpRequest();
			}catch(e){
				try{
					return new ActiveXObject("Msxml2.XMLHTTP");}
				catch(e){
					try{
						return new ActiveXObject("Microsoft.XMLHTTP");}
					catch(e){
						alert("Ϊ�˸��õ�����,������������������ʱ�վ");
						throw e;}
				}
			}
		}
	window.onload = function(){
		//��ȡ�ı���,����ʧȥ�����¼�ע�����
		var userEle = document.getElementById("userNameEle");
		userEle.onblur = function(){
			//�õ��첽����
			var xmlHttp = createXMLHttpRequest();
			//������
			xmlHttp.open("POST", "<c:url value='/Aservlet'/>",true);
			//��������ͷ
			xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			//��������,����������
			xmlHttp.send("userName="+userEle.value);
			//��xmlHttp��onreadystatechangeע�����
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
				{
					//��ȡ����������Ӧ,�ж��Ƿ�Ϊ1Ϊspan������� 
					var text = xmlHttp.responseText;
					if(text == "1"){
						//�õ�sapn
						var span = document.getElementById("errorSpan");
						span.innerHTML = "�û����Ѿ���ע��";
					}
					else
					{
						var span = document.getElementById("errorSpan");
						span.innerHTML = "�û�������";
					}
				}
			};
		};
	};
	</script>
  </head>
  
  <body>
	<h1>��ʾ�û����Ƿ�ע��</h1>
	<form action="" method="POST">
		�û���:<input type="text" name="userName" id="userNameEle"/><span id="errorSpan"></span><br/>
		�ܡ���:<input type="text" name="userName" id="userNameEle"/><br/><br/>
		<input type="submit" value="��¼" />
	</form>
  </body>
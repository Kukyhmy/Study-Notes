<script type="text/javascript">
		function createXMLHttpRequest()//�����첽����
		{
			try
			{
				return new XMLHttpRequest();//����������
			}
			catch(e)
			{
				try
				{
					return new ActiveXObject("Msxml2.XMLHTTP");//IE6.0
				}
				catch(e)
				{
					try
					{
						return new ActiveXObject("Microsoft.XMLHTTP");//IE5.5�Լ�����汾
					}
					catch(e)
					{
						alert("Ϊ�˸��õ�����,������������������ʱ�վ");
						throw e;
					}
				}
			}
		}
		window.onload = function()//�ĵ�������Ϻ�ִ��
		{
			var btn = document.getElementById("btn");
			btn.onclick = function()//����ť�ĵ���¼�ע����� 
			{
				/*
					�Ĳ�����,�õ�����������Ӧ
					����Ӧ��ʾ��h1Ԫ����
				*/
				var xmlHttp = createXMLHttpRequest();
				xmlHttp.open("GET", "/WEBDemo/Aservlet", true);
				xmlHttp.send(null);//GET����û��������,����ҲҪ����null,��ȻFireFox�����޷�����
				xmlHttp.onreadystatechange = function()//��xmlHttp״̬�����仯ʱִ��
				{
					if(xmlHttp.readyState == 4 && xmlHttp.status == 200)//˫���ж�
					{
						//��ȡ����������Ӧ���
						var text = xmlHttp.responseText;
						var h1 = document.getElementById("h1");
						h1.innerHTML = text;
					}
				}
			}
		};
	</script>

  </head>
  <body>
	<button id="btn">�������</button>
	<h1 id="h1"></h1>
  </body>

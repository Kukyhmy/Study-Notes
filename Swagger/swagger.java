------------------------
swagger
------------------------
	# ����
		https://swagger.io/
	
	
-----------------------------
swagger - springboot ����
-----------------------------
	# springfox
		http://springfox.github.io/springfox/
		http://springfox.github.io/springfox/docs/current/

	
	# springfox 3
		* Spring Boot ֧�� springfox-boot-starter �����ԣ������ã��Զ�����֧�֣�

		<!-- https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-boot-starter</artifactId>
			<version>3.0.0</version>
		</dependency>

	
	# ���� swagger
		@EnableOpenApi
	
	# ���� Docket
	
	
	# ��ʶע��
		* controoller
			@Api(tags = {"�û�����"})

		* ���󷽷�
			@ApiOperation("����û�")
		
		* �����ѯ����
			@ApiParam("�û����ǳ�")
		
		* ��Ӧ����
			@ApiModel("�û���Ϣ")
		
		* ��Ӧ���������
			@ApiModelProperty("�û�id")

	# ����
		http://localhost/swagger-ui.html
		http://localhost/v2/api-docs

		http://host/context-path/swagger-ui.html
		http://host/context-path/swagger-ui/index.html
		http://host/context-path/swagger-ui/
	


-----------------------------
swagger - springboot ����
-----------------------------
	# controller ����, ����ֵ����Ƕ���, �ͻᱻ swagger ɨ�赽, ����ʶ��Ϊ model


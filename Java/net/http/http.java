------------------------
http
------------------------
	# java9�ṩ��
	# �������
		HttpClient 
		HttpRequest
		HttpResponse
		HttpHeaders
		WebSocket
		
		* ��Щ����е�����, ����'ֻ����', ֻ�ṩ�� getter ����
		* ��ʼ����ʱ����Ҫͨ�� builder ���������Ե� set

------------------------
http - GET
------------------------
	# GET
		

	# ����
		

------------------------
http - POST
-----------------------
	// ���� Http �ͻ���
	HttpClient httpClient = HttpClient.newHttpClient();
	
	// ���������������
	HttpRequest request = HttpRequest
				.newBuilder(new URI("http://localhost/test"))
				.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
				.header("Accept", "application/json")   
				.POST(BodyPublishers.ofString("name=KevinBlandy"))
				.build();
	
	// ������Ӧ������
	BodyHandler<String> bodyHandler = BodyHandlers.ofString(StandardCharsets.UTF_8);
	
	// ִ�����󣬻�ȡ��Ӧ
	HttpResponse<String> responseBody = httpClient.send(request, bodyHandler);
	
	System.out.println(responseBody);

------------------------
http - �ļ�����
-----------------------
	# û���ֳɵ�mutipart����api����Ҫ����
		<!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpmime -->
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpmime</artifactId>
		</dependency>

	# ʵ��
		import java.io.ByteArrayOutputStream;
		import java.io.File;
		import java.net.URI;
		import java.net.http.HttpClient;
		import java.net.http.HttpRequest;
		import java.net.http.HttpRequest.BodyPublishers;
		import java.net.http.HttpResponse;
		import java.net.http.HttpResponse.BodyHandler;
		import java.net.http.HttpResponse.BodyHandlers;
		import java.nio.charset.StandardCharsets;

		import org.apache.http.HttpEntity;
		import org.apache.http.entity.ContentType;
		import org.apache.http.entity.mime.MultipartEntityBuilder;
		import org.apache.http.entity.mime.content.StringBody;
		import org.springframework.web.util.UriUtils;


		public class MainTest {
			public static void main(String[] args) throws Exception {
				
				
				HttpEntity httpEntity = MultipartEntityBuilder.create()
						.addPart("name", new StringBody(UriUtils.encode("SpringBoot��������", StandardCharsets.UTF_8), ContentType.APPLICATION_FORM_URLENCODED))
						.addPart("info", new StringBody("{\"site\": \"https://springboot.io\", \"year\": 2019}", ContentType.APPLICATION_JSON))
						.addBinaryBody("logo", new File("D:\\logo.png"), ContentType.IMAGE_PNG, "logo.png")
						.build();
				
				// ������ݹ��󣬿��Կ���IO�����̶������ڴ�
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) httpEntity.getContentLength());
				httpEntity.writeTo(byteArrayOutputStream);
				
				HttpClient httpClient = HttpClient.newHttpClient();
				
				// ���������������
				HttpRequest request = HttpRequest
							.newBuilder(new URI("http://localhost/upload"))
							// ����ContentType
							.header("Content-Type", httpEntity.getContentType().getValue())
							.header("Accept", "application/json")   
							.POST(BodyPublishers.ofByteArray(byteArrayOutputStream.toByteArray()))
							.build();
				
				// ������Ӧ������
				BodyHandler<String> bodyHandler = BodyHandlers.ofString(StandardCharsets.UTF_8);
				
				// ִ�����󣬻�ȡ��Ӧ
				HttpResponse<String> responseBody = httpClient.send(request, bodyHandler);
				
				System.out.println(responseBody);
			}
		}

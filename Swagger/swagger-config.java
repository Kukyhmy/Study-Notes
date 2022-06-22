-----------------
swagger-config
-----------------
	ApiInfo
	Docket


-----------------
swagger-ApiInfo
-----------------
	# api��Ϣ������
	# ����ͨ�� ApiInfoBuilder �����ٹ���
	# ����
		ApiInfo apiInfo =  new ApiInfoBuilder()
			.version("0.0.0.1")											// �汾��
			.contact(new Contact("KevinBlandy", "https://springboot.io", "kevinblandy.cn@gmail.com"))  // ��ϵ��
			.description("�ÿ����Ե�") // ����
			.extensions(null) // ��Ӷ����չ
			.license("���֤") 	// api���֤
			.licenseUrl("https://springboot.io?license") // api���֤��ַ
			.termsOfServiceUrl("https://springboot.io/service") //  ���������ַ
			.title("swagger �ӿ��ĵ�") //  ����
			.build();
	
	# ��̬����
		// Ĭ����ϵ��
		public static final Contact DEFAULT_CONTACT = new Contact("", "", "");
		// Ĭ�ϵ�ʵ����
		public static final ApiInfo DEFAULT = new ApiInfo("Api Documentation", "Api Documentation", "1.0", "urn:tos",
			DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	
	# ��չ
		* ��Ҫʵ�ֽӿ�: VendorExtension
			public interface VendorExtension<T> {
				String getName();
				T getValue();
			}
			
		* ���е�ʵ��
			ListVendorExtension
			ObjectVendorExtension
			StringVendorExtension

-----------------
swagger-Docket
-----------------
	# һ��Docket��ʾһ���ĵ�
		http://springfox.github.io/springfox/javadoc/2.9.2/springfox/documentation/spring/web/plugins/Docket.html

	# Docket ����

			// �����ĵ����ʹ��� Docket
			Docket docket = new Docket(DocumentationType.SWAGGER_2);
			docket.additionalModels(first, remaining)
			docket.alternateTypeRules(AlternateTypeRule... alternateTypeRules)
				* ���ģ���滻����

			docket.apiDescriptionOrdering(apiDescriptionOrdering)
			docket.apiInfo(apiInfo);
				* ���� apiInfo

			docket.apiListingReferenceOrdering(apiListingReferenceOrdering)
			docket.configure(builder)
			docket.consumes(consumes)
			docket.directModelSubstitute(final Class clazz, final Class with)
				* ֱ�����ṩ���滻���滻ģ����
				* ����:
					directModelSubstitute(LocalDate.class, Date.class)

			docket.enable(externallyConfiguredFlag)
			docket.isEnabled()
					* �Ƿ����ô�swagger
					* Ĭ�� true				

			docket.enableUrlTemplating(enabled)
			docket.extensions(vendorExtensions)
			docket.forCodeGeneration(forCodeGen)
				* ��������Ϊtrue, ��ʹ�� CodeGenGenericTypeNamingStrategy ����Ĭ�ϵ� DefaultGenericTypeNamingStrategy
				* ���Ա�ʹ�ĵ����������Ѻ�		

			docket.genericModelSubstitutes(genericClasses)
			docket.getDocumentationType()
			docket.getGroupName()
			docket.globalOperationParameters(operationParameters)
			docket.globalResponseMessage(requestMethod, responseMessages)
			docket.groupName(groupName)
					* ������ڶ��Docketʵ��, ��ÿ��ʵ����������д˷����ṩ��Ψһ��groupName

			docket.host(host)
			docket.ignoredParameterTypes(classes)
			
			docket.operationOrdering(operationOrdering)
			docket.pathMapping(String path)
				* ����չ�Ի���, ���ڽ�servlet·��ӳ��(�����)��ӵ�api��·��

			docket.pathProvider(pathProvider)
			docket.produces(produces)
			docket.protocols(protocols)
			docket.securityContexts(securityContexts)
			docket.securitySchemes(List<? extends SecurityScheme> securitySchemes)

			docket.select()
				.apis(RequestHandlerSelectors.basePackage("io.springboot.swagger.controller"))
				.paths(PathSelectors.any());

				* ����ɨ�����͹�����

			docket.supports(delimiter)
			docket.tags(first, remaining)
			docket.useDefaultResponseMessages(boolean apply)
				* �Ƿ��Ƿ�Ĭ�ϵ���Ӧ״̬��
				* Ĭ�� true
				
	

	# ɨ�����͹�������ֱ��ʵ��
		RequestHandlerSelectors
			static Predicate<RequestHandler> any()
			static Predicate<RequestHandler> none()
			static Predicate<RequestHandler> withMethodAnnotation(final Class<? extends Annotation> annotation)
			static Predicate<RequestHandler> withClassAnnotation(final Class<? extends Annotation> annotation)
			static Predicate<RequestHandler> basePackage(final String basePackage)
		
		PathSelectors
			static Predicate<String> any()
			static Predicate<String> none()
			static Predicate<String> regex(final String pathRegex)
			static Predicate<String> ant(final String antPattern)
	

	
	# һ�� Swagge�� Docket����, ����һ��ϵ�е��ĵ�, ͨ�� groupName ������

----------------------------------
swagger-Configuration
----------------------------------
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile(value = {"dev", "test"})
public class SwaggerConfiguration {

	@Bean
	public Docket docket() {

		ApiInfo apiInfo = new ApiInfoBuilder().version("0.0.0.1") // �汾��
				.contact(new Contact("KevinBlandy", "https://springboot.io", "kevinblandy.cn@gmail.com")) // ��ϵ��
				.description("�ÿ����Ե�") // ����
				.extensions(null) // ��Ӷ����չ
				.license("���֤") // api���֤
				.licenseUrl("https://springboot.io?license") // api���֤��ַ
				.termsOfServiceUrl("https://springboot.io/service") // ���������ַ
				.title("swagger �ӿ��ĵ�") // ����
				.build();

		// �����ĵ����ʹ��� Docket
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Swagger �ӿ��ĵ�")
				// api info
				.apiInfo(apiInfo)
				// ����
				.enable(true)
				// ɨ����͹���
				.select().apis(RequestHandlerSelectors.basePackage("io.springboot.swagger.controller"))
				.paths(PathSelectors.any()).build();

	}
}
----------------------
ע��
----------------------
@Api
	* ��ʶ��controller

	String value() default "";
		* ���ڼ��ݾɰ�ı�ǩ
	String[] tags() default "";
		* ���ڷ���, һ��controller �������ڶ����
		* ��������� tags ����, ��value���Իᱻ����

	String produces() default "";
	String consumes() default "";
	String protocols() default "";
	Authorization[] authorizations() default @Authorization(value = "");
	boolean hidden() default false;

@ApiImplicitParam
	String name() default "";
	String value() default "";
	String defaultValue() default "";
	String allowableValues() default "";
	boolean required() default false;
	String access() default "";
	boolean allowMultiple() default false;
	String dataType() default "";
	Class<?> dataTypeClass() default Void.class;
	String paramType() default "";
	String example() default "";
	Example examples() default @Example(value = @ExampleProperty(mediaType = "", value = ""));
	String type() default "";
	String format() default "";
	boolean allowEmptyValue() default false;
	boolean readOnly() default false;
	String collectionFormat() default "";

	
	* �����ù� @ApiImplicitParams һ���Զ�����
		ApiImplicitParam[] value();

@ApiKeyAuthDefinition

@ApiModel
	* ��ʵ����, ���ʵ��ע��

	String value() default "";
	String description() default "";
		* ����

	Class<?> parent() default Void.class;
	String discriminator() default "";
	Class<?>[] subTypes() default {};
	String reference() default "";

@ApiModelProperty
	* ʵ������, ���ֶ���ӵ�ע��
	* ���Ա��̳�
	
	String value() default "";
	String name() default "";
	String allowableValues() default "";
	String access() default "";
	String notes() default "";
	String dataType() default "";
	boolean required() default false;
	int position() default 0;
	boolean hidden() default false;
	String example() default "";
	AccessMode accessMode() default AccessMode.AUTO;
		AUTO,
        READ_ONLY,
        READ_WRITE;
	
	String reference() default "";
	boolean allowEmptyValue() default false;
	Extension[] extensions() default @Extension(properties = @ExtensionProperty(name = "", value = ""));

@ApiOperation
	* ��controller������ӵ�ע��

	String value();
		* ����
	String notes() default "";
		* ����
	String[] tags() default "";
		* ��ǩ
	Class<?> response() default Void.class;
		* �ֶ�������Ӧ����
	String responseContainer() default "";
	String responseReference() default "";
	String httpMethod() default "";
	String nickname() default "";
	String produces() default "";
	String consumes() default "";
	String protocols() default "";
	Authorization[] authorizations() default @Authorization(value = "");
	boolean hidden() default false;
	ResponseHeader[] responseHeaders() default @ResponseHeader(name = "", response = Void.class);
	int code() default 200;
	Extension[] extensions() default @Extension(properties = @ExtensionProperty(name = "", value = ""));
	boolean ignoreJsonView() default false;

@ApiIgnore
	
	* ���Ա�ʶ����, ����, ������, �������ĵ��к��Ը�controller, action, param

	String value() default "";

@ApiParam
	* ��controller���������������ӵ�ע��


	String name() default "";
	String value() default "";
	String defaultValue() default "";
	String allowableValues() default "";
	boolean required() default false;
	String access() default "";
	boolean allowMultiple() default false;
	boolean hidden() default false;
	String example() default "";
	Example examples() default @Example(value = @ExampleProperty(mediaType = "", value = ""));
	String type() default "";
	String format() default "";
	boolean allowEmptyValue() default false;
	boolean readOnly() default false;
	String collectionFormat() default "";



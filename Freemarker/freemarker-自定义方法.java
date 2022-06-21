----------------------------
��ǩʵ��					|
----------------------------
	# �﷨
		<#function name param1 param2 ... paramN>
		  ...
		  <#return returnValue>
		  ...
		</#function>
		
		* name ��������
		* ���Զ���������
		* paramN,���һ������, ���Կ�ѡ�İ���һ��β��ʡ��(...)�����ζ�ź���ܿɱ�Ĳ�������,�ֲ����� paramN ���Ƕ������������(��ɲ���)
		* ����������Ĭ��ֵ,���Ǳ���������ͨ�����ĺ���
		* return ָ���Ǳ����
		* �����ڵ�����������ᱻ����
	
	# Demo
		<#function foo v1 v2 v3...>
			<#local x = v1 + v2>
			<#list v3 as i>
				<#local x = i + x>
			</#list>
			<#return x>
		</#function>

		${foo(1,2,3,4,5)}		//15

	# �������͵�ת��
		* �������Ͷ���:TemplateModel ����

		* �ַ������� func('123');
			SimpleScalar simpleScalar = ((SimpleScalar)arguments.get(0));
			simpleScalar.getAsString() //simpleScalar.toString();
		
		* ��ֵ���� func(123);
			SimpleNumber simpleNumber = ((SimpleNumber)arguments.get(0));
			simpleNumber.getAsNumber().intValue();
			simpleNumber.getAsNumber().longValue();
		
		* ���в��� func([1,2,3]);
			SimpleSequence simpleSequence = ((SimpleSequence)arguments.get(0));
			TemplateModel value = param.get(0);	//���value,����������ĳ�������(ȡ������������Ԫ�ص�����)
			int size = param.size();			//���鳤��
			param.add(new Object());			//����µ�Ԫ��

		*  Hash���� func({'v1':'51515','v2':[1,2,3,4]})
			TemplateHashModelEx2 templateHashModelEx2 = (TemplateHashModelEx2)arguments.get(0);
			TemplateModel templateModel = templateHashModelEx2.get("Key");		//��ȡkey
			templateHashModelEx2.size();											//Hash����
			//����
			KeyValuePairIterator keyValuePairIterator = templateHashModelEx2.keyValuePairIterator();
			while(keyValuePairIterator.hasNext()) {
				KeyValuePair keyValuePair = keyValuePairIterator.next();
				TemplateModel key = keyValuePair.getKey();
				TemplateModel value = keyValuePair.getValue();
			}
		
		* Map ���� 
			* ������ HashMap

			SimpleHash simpleHash = (SimpleHash)arguments.get(0);
			TemplateModel templateModel = simpleHash.get("Key");		//��ȡkey
			simpleHash.size();											//Hash����
			simpleHash.containsKey("Key");								//�ж�key�Ƿ����
			simpleHash.put("age", 23);									//���Ԫ�ص�map
			simpleHash.isEmpty();
			//����
			KeyValuePairIterator keyValuePairIterator = simpleHash.keyValuePairIterator();
			while(keyValuePairIterator.hasNext()) {
				KeyValuePair keyValuePair = keyValuePairIterator.next();
				TemplateModel key = keyValuePair.getKey();
				TemplateModel value = keyValuePair.getValue();
			}
		
		*  �������
			* ������Java����
			StringModel stringModel = (StringModel)arguments.get(0);
			TemplateModel templateModel = stringModel.get("");
			TemplateModel templateModel2 = stringModel.getAPI();
			String string = stringModel.getAsString();
			TemplateCollectionModel templateCollectionModel = stringModel.keys();
			int size = stringModel.size();

		*  Date ���� func(.now);
			SimpleDate simpleDate = (SimpleDate)arguments.get(0);
			Date date = simpleDate.getAsDate();		//��ȡ����
			int simpleDate.getDateType();			//��ȡ���ڵ�����

			* dateType ����
				TemplateDateModel.UNKNOWN;	
				TemplateDateModel.TIME;
				TemplateDateModel.DATE;
				TemplateDateModel.DATETIME;

	# ��ͨ��������ȡ��ԭʼJava����
		* ����Ƹо�զ��ô��Ƥ???
		* ������Java����, �ᱻ��װΪFreemarker��������� BeanModel ��,����2������ (BeanModel implements TemplateModel )
			/**
			 * Returns the same as {@link #getWrappedObject()}; to ensure that, this method will be final starting from 2.4.
			 * This behavior of {@link BeanModel} is assumed by some FreeMarker code. 
			 */
			public Object getAdaptedObject(Class<?> hint) {
				return object;  // return getWrappedObject(); starting from 2.4
			}

			public Object getWrappedObject() {
				return object;
			}
	

		* ͨ����������,���Ի�ȡ������ʱ���ݵ�ԭ������
			// ����
			${localDateTimeFormatter(paste.createDate)}

			// ��ȡ
			BeanModel beanModel = (BeanModel) arguments.get(0);
			LocalDateTime localDateTime = (LocalDateTime) beanModel.getAdaptedObject(LocalDateTime.class);
		
		* ��ȡ�� Map ������ԭʼ����
			Map<String, String[]> params = ((SimpleHash)arguments.get(1)).toMap(); // SimpleHash ��һ�� toMap() ����, ���Ի�ȡ��ԭʼ��Map����


----------------------------
����ʵ��					|
----------------------------
	# ʵ�ֽӿ�: TemplateMethodModelEx 
		import java.util.List;

		import freemarker.core.Environment;
		import freemarker.template.TemplateMethodModelEx;
		import freemarker.template.TemplateModelException;

		public class FooFunction implements TemplateMethodModelEx{

			public FooFunction() {
				System.out.println("new");
			}
			
			//arguments ���Ǵ��ݽ����Ĳ���
			@SuppressWarnings("rawtypes")
			@Override
			public Object exec(List arguments) throws TemplateModelException {
				//��ȡ��ǰ���л���
				Environment environment = Environment.getCurrentEnvironment();
				System.out.println(environment);
				return "result";
			}
		}

	
	# �Ѹ�ʵ����ģ������,��Ϊһ����������
		* configuration.setSharedVariable("fooFunc", new FooFunction());
		* ��������Ϊ�������,�Ե�����ʽ����
	
	# ��ģ��������ʹ��
		${fooFunc("123456")}
	




------------------------
��ʹ�� macro ָ��������	|
------------------------
	# ��������
		<#macro greet>
			<font size="+2">Hello Joe!</font>
		</#macro>

		* ָ������ greet
		* ֵ����ָ������:@
		* ʹ��:<@greet></@greet> ���� <@greet/>
	
	# ��������ģ�忪ʼʱ������
		* Ҳ����˵,�����ڵ���ָ��󴴽�ָ��(��ʵָ���ڵ���֮ǰ���ȳ�ʼ��)

	# ָ��֮��Ķ�����ģ��Ƭ��,����ʹ�������ftl�﷨
		* ����Ƕ���������Զ���ָ��

	# �����Ķ�����ʹ��
		<#macro foo var1 var2>
			<font size="+2">${var1} - ${var2}</font>
		</#macro>

		<@foo users[0].name "KevinBlandy"/>
			*  �����ָ������,���������˳�򴫵�

		<@foo var1=users[0].name var2="KevinBlandy"/>
			*  ͨ��ָ����ǩ����������ָ���Ĳ���
		
		* ��������˲���,����붼Ҫ����,�ٴ��ݲ����ᷢ���쳣
		* Ҳ���ܶഫ�ݲ���,���ߴ���ָ��δ����Ĳ���,��ȻҲ�ᷢ���쳣
		
		* ָ����Դ�Ĭ��ֵ,�����Ļ�,ʹ�õ�ʱ��,����ʡ���������
		* û��Ĭ��ֵ�Ĳ�����������Ĭ��ֵ���� (paramName=defaultValue) ֮ǰ
			<#macro foo var1 var2="default">
				<font size="+2">${var1} - ${var2}</font>
			</#macro>
			@foo var1=users[0].name/>
		
		* �Զ���ָ������ʹ�õĲ���,���Ǿֲ�����
	
	# �ɱ����
		* ���һ������,���ܻ���������(...), �����ζ�ź���ܿɱ������Ĳ���
		* ��ƥ�����������Ĳ���������Ϊ���һ������ (Ҳ��������ͳ����)
		* ���걻������������,paramN �����ǰ����������δ�����ļ�/ֵ�ԵĹ�ϣ��
		* ���걻λ�ò�������,paramN ���Ƕ������������ (�ں��ڲ�,Ҫ���Ҳ���,����ʹ�� myCatchAllParam?is_sequence)

		* �ɱ����,����һ��map,Ҳ������һ������
			<#macro foo v1 v2 v3...>
				<#if v3?is_sequence>
					//�Ǽ���
					<#list v3 as i>
						${i}<br/>
					</#list>
					
					//��map
					<#else>
					
					<#list v3?keys as key>
						${v3[key]}<br/>
					</#list>
				</#if>
				
			</#macro>

			<@foo v1="1" v2="2" aa="3" bb="4"></@foo>
				* ���ֵ��÷�ʽ�ɱ������map

			<@foo "1" "2" "3" "4"></@foo>
				* ���ֵ��÷�ʽ�ɱ�����Ǽ���

	
	# ָ����Ĳ���
		<#macro foo>
			Hello<#nested>
		</#macro>

		<@foo>
			<span style="color:red">Java</span>
		</@foo>

		Hello<span style="color:red">Java</span>

		* <#nested> �滻Ϊʹ��ָ��ʱ�ı�ǩ��

		* <#nested> ָ��Ҳ���Զ�α�����
			<#macro foo>
				Hello<#nested>
				<#nested>
				<#nested>
			</#macro>
	
	# ��Ƕ�׵�������,��ľֲ������ǲ��ɼ���
		<#macro repeat count>
			<#local y = "test">			//�ֲ�����
			<#list 1..count as x>		
				${y} ${count}/${x}: <#nested>
			</#list>
		</#macro>

		<@repeat count=3>
			//���ܷ��ʵ�ָ���ڲ�����ı���
			${y!"?"} ${x!"?"} ${count!"?"}<br/>
		</@repeat>
		
		test 3/1: ? ? ?
		test 3/2: ? ? ?
		test 3/3: ? ? ?
	
	# ѭ������
		* <#nested />��������һ��ѭ������
		* ʹ�ñ�ǩ��ʱ��,������Ⱦ�ñ���
			<#macro foo>
				<#nested 1/>
				<#nested 2/>
				<#nested 3/>
			</#macro>
			<@foo ;x>
				name ${x}<br/>
			</@foo>
			name 1
			name 2
			name 3

		* �����������������Զ���ָ��Ŀ�ʼ���(<@...>) �Ĳ�������ͨ���ֺ�ȷ����
		* һ�������ʹ�ö��ѭ������(������˳���Ǻ���Ҫ��)
			<#macro foo count=10>
				<#list 1..count as item>
					<#nested item,item==1,item==count/>
				</#list>
			</#macro>
			
			<@foo ;index,first, last,a>
				${index} ${first?string("��һ��","���ǵ�һ��")} ${last?string("���һ��","�������һ��")}<br/>
			</@foo>

	# ��ָֹ�� #return
		<#macro test>
		  Test text
		  <#return>
		  Will not be printed.	//�ᱻ����
		</#macro>
------------------------
ͨ������������Զ���	|
------------------------
	# ʵ�ֽӿ�:TemplateDirectiveModel
		import java.io.IOException;
		import java.util.Map;

		import freemarker.core.Environment;
		import freemarker.template.TemplateDirectiveBody;
		import freemarker.template.TemplateDirectiveModel;
		import freemarker.template.TemplateException;
		import freemarker.template.TemplateModel;

		public class FooDirective  implements TemplateDirectiveModel{

			/**
			 * @param env				���л���
			 * @param params			����
			 * @param loopVars			ѭ������
			 * @param body				ָ����
			 */
			@SuppressWarnings("rawtypes")
			@Override
			public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)throws TemplateException, IOException {
				//��Ⱦ
				body.render(env.getOut());
			}
		}
	
	# ���ָ�ģ�����
		* configuration.put("foo", new FooDirective());
		* ��������Ϊ�������,�Ե�����ʽ����
	
	# ��ģ��������ʹ��
		<@foo></@foo>



------------------------
demo					|
------------------------
	# һ�� upper ָ��,�ø�ָ��֮����������ɴ�д
		import java.io.IOException;
		import java.io.Writer;
		import java.util.Map;

		import freemarker.core.Environment;
		import freemarker.template.TemplateDirectiveBody;
		import freemarker.template.TemplateDirectiveModel;
		import freemarker.template.TemplateException;
		import freemarker.template.TemplateModel;
		import freemarker.template.TemplateModelException;

		public class UpperDirective implements TemplateDirectiveModel {

			@SuppressWarnings("rawtypes")
			public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
					throws TemplateException, IOException {
				if (!params.isEmpty()) {
					throw new TemplateModelException("��ָ������б�ǩ");
				}
				if (loopVars.length != 0) {
					throw new TemplateModelException("��ָ�������ѭ������");
				}

				if (body != null) {
					body.render(new UpperCaseFilterWriter(env.getOut()));
				} else {
					throw new RuntimeException("δ�����ǩ��");
				}
			}

			private static class UpperCaseFilterWriter extends Writer {

				private final Writer out;

				UpperCaseFilterWriter(Writer out) {
					this.out = out;
				}

				public void write(char[] cbuf, int off, int len) throws IOException {
					char[] transformedCbuf = new char[len];
					for (int i = 0; i < len; i++) {
						transformedCbuf[i] = Character.toUpperCase(cbuf[i + off]);
					}
					out.write(transformedCbuf);
				}

				public void flush() throws IOException {
					out.flush();
				}

				public void close() throws IOException {
					out.close();
				}
			}
		}
# �������ı���Ⱦ
	{{name}}

# ͨ�� v-once ָ��,����Ⱦ������Ӧʽ(������Ⱦһ��,�����޸ĺ���ͼ�����޸�)
	<span v-once>���������ı�: {{ msg }}</span>


# ʹ��v-html���Դ���ԭʼ��html,����,������xss����
	//{{rwaHtml}} ��Ѹ�html���ַ�����ʽ���(ת��)
	<p>Using mustaches: {{ rawHtml }}</p>
	//��� <span> �����ݽ��ᱻ�滻��Ϊ����ֵ rawHtml
	<p>Using v-html directive: <span v-html="rawHtml"></span></p>
	
	* ֱ����Ϊ HTML��������Խ�������ֵ�е����ݰ�
		data:{
			//����ֻ����Ⱦ����ɫ�� {{message}},�������message��ȾΪdata���������
			html:`<span style='color:red'>{{message}}</span>`,
			message : 'Hi'
		}
	* ����ʹ�� v-html �����Ͼֲ�ģ��,��Ϊ Vue ���ǻ����ַ�����ģ�����桢

# html��������
	* {{name}},����������HTML��������,Ӧ��ʹ�� v-bind 
		<div v-bind:id="id">{{id}}</div>
	
	* �������Ե������,���ǵĴ��ڼ���ʾΪ true,v-bind �����������в�ͬ
		<button v-bind:disabled="isButtonDisabled">Button</button>
		
		* ��� isButtonDisabled ��ֵ�� null undefined �� false �� disabled �����������ᱻ��������Ⱦ������ <button> Ԫ����
		* ˵����,���bind��������һ��boolֵ,���Ҹ�ֵΪ:false �Ļ�,������Զ��������html��ǩ����
	

# ʹ�� javascript ���ʽ
	* ģ���ṩ����ȫ�� JavaScript ���ʽ֧��
		{{ number + 1 }}
		{{ ok ? 'YES' : 'NO' }}
		{{ message.split('').reverse().join('') }}
		<div v-bind:id="'list-' + id"></div>
	* ���ʽ�������� Vue ʵ������������������Ϊ JavaScript ������
	* ÿ���󶨶�ֻ�ܰ����������ʽ,������������Ӷ�������Ч
		// ������䣬���Ǳ��ʽ
		{{ var a = 1 }}
		// ������Ҳ������Ч����ʹ����Ԫ���ʽ
		{{ if (ok) { return message } }}
	* ģ����ʽ��������ɳ����,ֻ�ܷ���ȫ�ֱ�����һ��������,�� Math �� Date 
	* ��Ӧ����ģ����ʽ����ͼ�����û������ȫ�ֱ���


		
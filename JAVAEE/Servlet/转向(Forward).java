��ʱ��һ��������Ҫ���ServletЭ��������ɡ�������Ҫ��һ��Servlet������һ��Servlet�ϣ�
	> һ���������servlet,����Ҫʹ��ת���Ͱ���
	> ����ת��:����һ��servlet�����Ӧ��!��ǰservlet����������Ӧͷ��������Ӧ��û��,���п��ܱ���.��ͷ������
	> �������:������servlet��ͬ�����Ӧ��!(����)
	> �����������ǰ���,����һ������Χ��.ʹ��ͬһ��request��response.

RequestDispatcher dispatcher = request.getRequestDispatcher("uri");
dispatcher.forward(request,response);//����ת��,
dispatcher.include(request,response);// ����ת��,
	|--ת����ͨ��:RequestDispatcher ����� forward��������ɵ�
	|--����ת������WEB��������ɡ�ֻ��ת���WEB��Դ�ڲ���Servlet�����ҿͻ����������ַ����һֱͣ���ڵ�һ�η���servlet�ĵ�ַ��
	|--��ִ��forward������ʱ��Ҫ���κ�������ͻ��ˡ�������׳�IllegaState-Exception.Ҳ������forward֮ǰ������Ҫʹ��out.println();�����ͻ�����������
request��
	���������(request,session,application)
	�������������������Եķ���
setAttribute(String name,Object value);//void.�޷���ֵ���ͣ�
getAttribute(String name); //����ֵ��Object.
removeArribute(String name);//����ֵvoid.�Ƴ�ָ��������
[request -- �����������������������,���ԡ���servlet֮�䴫��ֵ�õ�]
> ͬһ����Χ��ʹ��request.setAttribute(),request.getAttribute()����ֵ��
> ǰһ��servlet����setAttribute()����ֵ����һ��servlet����getAttribute()�õ�ֵ��

����ת�����ض���(Redirect)������
 > ����ת����һ������һ����Ӧ.���ض�������������������Ӧ.
 > ����ת��,�ͻ��˵�ַ�����ᷢ���仯.���ض������ʾ��һ������ĵ�ַ.
 > ����ת��ֻ��ת��������Ŀ����servlet,���ض���ֻ���ض�������Ŀ����servlet���ܶ���������Ŀ.
 > ����ת���Ƿ������Ϊ,ֻ��Ҫ����ת����Servlet·��,���ض�����Ҫ����requestURI,��������Ŀ��.
	<>��Ҫ��ַ�������仯,��ô����ʹ���ض���
	<>��Ҫ����һ��serlvet�л�ȡrequest���е�����,����Ҫʹ��ת��.
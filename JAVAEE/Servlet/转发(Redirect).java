�ض��������÷���������http��Ϣ��״̬��ʵ�ֵģ��ͻ��������������ʱ�򡣷������᷵��һ��״̬�롣
�����ͨ��HttpServletResponse��setStatus(int����״̬��);��������״̬��.
301//�����Զ���
302//��ʱ�Զ���
response.setStatus(302);
	|--���÷��ص�״̬��Ϊ302�������������Ҫ���¶�λ��Դ��
response.setHeader("Location","http://www.baidu.com");
	|--��������������¶�λ����Դ��
/**�ض�������״̬��302������Locationͷ�����б仯��ֻ��Location����JAVA�ṩ�˸�Ϊ���ķ���������ض���**/
sendRedirect(String location);//�����ض������ӡ��ڲ���ʵ��װ��-����302״̬��,�Ѳ���String����Ϊlocationͷ.һ����λ��

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		/**
		 * ����ͷ,һ����
		 * 1,Content-Type
		 * 2,Content-Disposition
		 * ��,�����ļ�������
		 * */
		//Ŀ���ļ�
		String fileName = "D:\\PureCodec20150603.exe";
		//Ŀ���ļ�����
		File f = new File(fileName);
		//ͨ���ļ����ƻ�ȡ�ļ�����
		String contentType = this.getServletContext().getMimeType(fileName);
		//���ļ�������ISO���봦��,��ֹ�ͻ������ؿ�����������
		String framName = new String("��װ��.exe".getBytes("GBK"),"ISO-8859-1");
		//�������ؿ��ļ�����
		String contentDisposition = "attachment;filename=" + framName;
		//������Ӧͷ
		response.setHeader("Content-Type",contentType);
		response.setHeader("Content-Disposition",contentDisposition );
		//��ȡͨ��ͻ��˵��ֽ�������
		OutputStream out = response.getOutputStream();
		//���ļ������ֽ�������
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
		IOUtils.copy(in, out);//IO���߰�����Ķ���,���Զ���in�����ݶ�ȡ��out
		in.close();
	}
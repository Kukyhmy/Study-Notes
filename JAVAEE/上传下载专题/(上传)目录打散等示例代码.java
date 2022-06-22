	public  void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		/**
		 * �ϴ�������
		 * 1,�õ�������
		 * 2,ͨ�������ഴ�������� 
		 * 3,���� request�õ�FileItem����
		 * 4,�������ϵ�����API����ļ��ı���
		 * */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try 
		{
			List<FileItem> list = sfu.parseRequest(request);
			FileItem fil = list.get(2);
			/********************/
			//�õ���·��,�����ļ������·��
			String root = this.getServletContext().getRealPath("/WEB-INF/files");
			/**
			 * ��������Ŀ¼
			 * 1,�õ��ļ�����
			 * 2,�õ�hachCode
			 * 3,ת����16��ֹ
			 * 4,��ȡǰ������ĸ��������Ŀ¼
			 * */
			//��ȡ�ļ���
			String fileName = fil.getName();
			//�����ļ����ľ���·������(���������)
			int index = fileName.lastIndexOf("\\");
			if(index != -1)
			{
				fileName = fileName.substring(index+1);
			}
			//���ļ��������UUIDǰ׺,����ͬ������
			String saveName = GetUUID.getUUID()+"_"+fileName;
			//���hashCode
			int hashCode = saveName.hashCode();
			//ת��ʮ������
			String hex = Integer.toHexString(hashCode);
			//ȡʮ������ǰ�����ַ���root����һ����Ϊ���Ŀ¼·��
			File dirFile = new File(root,hex.charAt(0)+"/"+hex.charAt(1));
			// ����Ŀ¼��
			dirFile.mkdirs();
			//����Ŀ��Ŀ¼�ļ�
			File destFile = new File(dirFile,saveName);
			//����
			try 
			{
				fil.write(destFile);
			} 
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}
			/********************/
		} 
		catch (FileUploadException e) 
		{
			e.printStackTrace();
		} 
	}
-------------------------
MimeMultipart
-------------------------
	# ����MimeMultipart����

-------------------------
�����ಿ������
-------------------------
MimeMultipart mimeMultipart = new MimeMultipart(new ByteArrayDataSource(responseEntity.getBody().getInputStream(), responseEntity.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)));
for (int i = 0; i < mimeMultipart.getCount(); i++) {
    BodyPart bodyPart = mimeMultipart.getBodyPart(i);
    
    Enumeration<Header> enumeration = bodyPart.getAllHeaders();
    System.out.println("headers	==============================");
    while (enumeration.hasMoreElements()) {
    	Header header = enumeration.nextElement();
    	System.out.println(header.getName() +  ":" +  header.getValue());
    }
    
    System.out.println("body 	==============================");
    SharedByteArrayInputStream content = (SharedByteArrayInputStream) bodyPart.getContent();
    byte[] body = StreamUtils.copyToByteArray(content);
}
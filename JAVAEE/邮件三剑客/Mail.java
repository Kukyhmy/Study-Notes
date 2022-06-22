
import java.util.ArrayList;
import java.util.List;
/**
 * ��ʾ�ʼ��࣬����Ҫ���ã��˻��������롢�ռ��ˡ�����(��ѡ)������(��ѡ)�����⡢���ݣ��Լ�����(��ѡ)
 * �ڴ�����Mail����֮��
 * ���Ե�������setSubject()��setContent()���������������
 * Ҳ���Ե���setFrom()�͡�addToAddress()�����÷����ˣ�������ռ��ˡ�
 * Ҳ���Ե���addAttch()��Ӹ���
 * ����AttachBean��new AttachBean(new File("..."), "fileName");
 **/
public class Mail
{
	private String from;//������
	private StringBuilder toAddress = new StringBuilder();//�ռ���
	private StringBuilder ccAddress = new StringBuilder();//����
	private StringBuilder bccAddress = new StringBuilder();//����
	private String subject;//����
	private String content;//����
	// �����б�
	private List<AttachBean> attachList = new ArrayList<AttachBean>();
	public Mail() {}
	public Mail(String from, String to)
	{
		this(from, to, null, null);
	}
	public Mail(String from, String to, String subject, String content)
	{
		this.from = from;
		this.toAddress.append(to);
		this.subject = subject;
		this.content = content;
	}
	
	/**
	 * ���ط�����
	 * @return
	 **/
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * ���ط�����
	 * @return
	 **/
	public String getFrom() 
	{
		return from;
	}
	/**
	 * ��������
	 **/
	public String getSubject() 
	{
		return subject;
	}
	/**
	 * ��������
	 **/
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	/**
	 * ��ȡ��������
	 **/
	public String getContent() 
	{
		return content;
	}
	/**
	 * ������������
	 * @param content
	 **/
	public void setContent(String content) 
	{
		this.content = content;
	}
	/**
	 * ��ȡ�ռ���
	 * @return
	 **/
	public String getToAddress()
	{
		return toAddress.toString();
	}
	/**
	 * ��ȡ����
	 * @return
	 **/
	public String getCcAddress()
	{
		return ccAddress.toString();
	}
	/**
	 * ��ȡ����
	 * @return
	 **/
	public String getBccAddress()
	{
		return bccAddress.toString();
	}
	/**
	 * ����ռ���,�����Ƕ���ռ���
	 * @param to
	 **/
	public void addToAddress(String to)
	{
		if(this.toAddress.length() > 0) 
		{
			this.toAddress.append(",");
		}
		this.toAddress.append(to);
	}

	/**
	 * ��ӳ����ˣ������Ƕ��������
	 * @param cc
	 **/
	public void addCcAddress(String cc) 
	{
		if(this.ccAddress.length() > 0)
		{
			this.ccAddress.append(",");
		}
		this.ccAddress.append(cc);
	}
	/**
	 * ��Ӱ����ˣ������Ƕ��������
	 * @param bcc
	 **/
	public void addBccAddress(String bcc) 
	{
		if(this.bccAddress.length() > 0) 
		{
			this.bccAddress.append(",");
		}
		this.bccAddress.append(bcc);
	}
	/**
	 * ��Ӹ�����������Ӷ������
	 * @param attachBean
	 **/
	public void addAttach(AttachBean attachBean)
	{
		this.attachList.add(attachBean);
	}
	/**
	 * ��ȡ���и���
	 * @return
	 **/
	public List<AttachBean> getAttachs() 
	{
		return this.attachList;
	}
}

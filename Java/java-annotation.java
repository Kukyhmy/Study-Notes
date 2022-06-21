------------------------------
Annotation					  |
------------------------------
	# ��������ע��ĸ��඼�� Annotation
	
	# ���Ա�ʶ��λ��
		��
		�෽��
		������
		���Ա����
		��������
		�ֲ�����
		��				-- ����ֱ�ӷ�,Ҫͨ������,��ȻҪ��

	# ��������
	   �˴������������
	   String
	   Enum
	   Class
	   ������ע������(ע�������������;�����һ��ע��)
	   �������͵�һά��������(�����������͵İ�װ����Ҳ������)
	  
	
	# value ������Ȩ
		��ע�����ֻ��һ������,�����־ͽ���Value��ʱ��,����ʡ������,ֱ��дֵ
	
	# Ŀ���޶�,��ע��ı��������޶�
		 @Target 
			* ���ע��,ֻ��һ������,����:ElementType[] value();
			* ���ElementType��ö��,ע����ö����,�����ע�����������������ʽ���ڵ�.�������ֽ���value,������Ѿ�����,ֻ��һ�������ֽ���value,�ǲ���ָ�����ָ�ֵ��
			* ���ö����һЩö�ٶ���:
			> TYPE			--	����ѡ�����,���������������,�ӿ�,ö������
			> FIELD			--	��Ա����
			> METHOD		--	��Ա����
			> PARAMETER		--	
			> CONSTRUCTOR		--	������
			> LOCAL_VARIABLE	--	
			> ANNOTATION_TYPE	--	ע��...
			> PACKAGE		--	��(����ֱ�ӷ�...)
		
		@Retention(RetentionPolicy.RUNTIME)
			* �����ʱ�������Զ��� 'RUNTIME'

	# Demo
		@interface Ann{
			int a();		//int����
			String b();		//�ַ�������
			MyEnum c();		//ö������
			Class d();		//Class����
			MyAnn e();		//Ҳ��ע������
			String[] f();	//��������
		}
		@Ann(		
			a=100,
			b="kevin",
			c=MyEnum.A,
			d=String.class,
			e=@MyAnn("���ע���ֵ"),
			f={"�ַ���","����"}//ע��ע��ע��....��ֻ��һ��Ԫ�ص�ʱ�����ʡ�Դ�����
		)
	
------------------------------
JAVA8����					  |
------------------------------
	# ���ظ�ע��
		* ʾ��
			@MyAnnotation("123456")
			@MyAnnotation("123457")
		
		* ����
			@Repeatable
				Class<? extends Annotation> value();
				* ָ�����Ա��ظ�ע���ע����
			

			@Repeatable(MyAnnotations.class)	//ָ��������
			@MyAnnotation{						//����ע��
				String value;
			}

			@MyAnnotations{						//����������ע��
				@MyAnnotation[] myAnnotation;
			}

		* ��ȡ
			T[]  getAnnotationsByType(T.class);
				* �ظ�������N��ע��,��������ʽ����



	# �������͵�ע��
		@Target 
			> TYPE			--	����ѡ�����,���������������,�ӿ�,ö������
			> FIELD			--	��Ա����
			> METHOD		--	��Ա����
			> PARAMETER		--	
			> CONSTRUCTOR		--	������
			> LOCAL_VARIABLE	--	
			> ANNOTATION_TYPE	--	ע��...
			> PACKAGE		--	��(����ֱ�ӷ�...)
		�µ�
			
			
------------------------------
Inherited 					  |
------------------------------
	# ��������̳и����ע��
		
		import java.lang.annotation.*;
		@Inherited
		@Target(value = {ElementType.TYPE})
		@Retention(value = RetentionPolicy.RUNTIME)
		public @interface Foo {

		}
		
		@Foo
		public class Foo1 {
		}

		public class Foo2 extends Foo1 {
		}

		public class Main {
			public static void main(String[] args) {
				// true
				boolean result = Foo2.class.isAnnotationPresent(Foo.class);
				System.out.println(result);
			}
		}
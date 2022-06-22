----------------------
MyBatis-ö��			|
----------------------
	* MyBatis��ѯ����ӳ��ö�����ͣ�����Ҫ�� EnumTypeHandler ���� EnumOrdinalTypeHandler ��ѡһ����ʹ��
		1. EnumOrdinalTypeHandler	
			* ���ת����ʹ����ö����� ordinal (ö�ٶ����λ��)������Ϊ���ݿ�洢��Ϣ
			* ����ordinal������int���͵ģ����չ�����˵�����ݿ��ж�Ӧ��ԴӦ����int��double���͵�
			* ���Ǹ��˲��Թ�����MYSQL��varchar�ֶ�Ҳ���Դ洢��

		2. EnumTypeHandler			
			* Ĭ�ϵ�
			* �ǰ���ö�ٵ���������ȡ�ģ���Ӧ���ݿ�����Ϊ ֱ��ʹ��ö������
	
	* �޸�Ĭ�ϵ�ö�ٴ�����(mybatis-cofig.xml), ʵ������:defaultEnumTypeHandler
		<settings>
			<setting name="defaultEnumTypeHandler" value="org.apache.ibatis.type.EnumOrdinalTypeHandler"/>
		</settings>

	* �������������,���Կ����Զ�����Ϣ���ʹ����������
	

1,ö����DTO������
	public enum UserStatus {  
		/** ��Ч*/  
		DISABLED(0),  
		/** ��Ч */  
		AVAILABLE(1);  
		private int status;  
		UserStatus(int status){  
			this.status = status;  
		}  
		public int getStatus() {  
			return status;  
		}  
	}  

	<insert id="addUser" parameterType="User">  
		INSERT INTO t_user(USER_ID,USER_NAME,LOGIN_NAME, LOGIN_PASSWORD,USER_STATUS,CREATE_TIME,UPDATE_TIME)  
		VALUES(  
			#{user_id},  
			#{user_name},  
			#{login_name},  
			#{login_password},  
			#{user_status, typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler},  
			#{create_time},  
			#{update_time}  
			)  
	</insert>  

	# ָ��Handler = typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler


----------------------------
MyBatis-�Զ���ͨ��ö���ദ��|
----------------------------
	BaseEnum					
	# �����Ľӿ�
	# ����ö���඼Ӧ��ʵ�ָýӿ�,�Ϳ����������ת��
		public interface BaseEnum<E extends Enum<?>, T>{

			T getValue();

			String getDisplayName();
		}

	UniversalEnumHandler		
	# ͨ��ö���ദ����
		import org.apache.ibatis.type.BaseTypeHandler;
		import org.apache.ibatis.type.JdbcType;
		import xin.suen.teach.base.BaseEnum;
		import java.sql.CallableStatement;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;

		/**
		 * Created by KevinBlandy on 2017/3/29 11:09
		 */
		public class UniversalEnumHandler <E extends BaseEnum<?, ?>> extends BaseTypeHandler<E> {

			private Class<E> type;      //ö��Class

			private E [] enums;         //ö�ٶ���
			

			/**
				�ù��췽��,ϵͳ���Զ���ע�� type ,Ҳ���Ƿ��� E
			*/
			public UniversalEnumHandler(Class<E> type) {
				if (type == null) {
					//����Ϊ��
					throw new IllegalArgumentException("��������Ϊ��");
				}
				this.type = type;
				this.enums = type.getEnumConstants();
				if (this.enums == null || this.enums.length == 0){
					//������ö����,����û���κ�ö��ֵ
					throw new IllegalArgumentException(type.getSimpleName() + " ��ö����,����û���κ�ö��ֵ");
				}
			}

			@Override
			public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
				//��ȡö��valueֵ
				Integer value = (Integer)parameter.getValue();
				if(jdbcType == null){
					ps.setObject(i,value);
				}else {
					ps.setObject(i,value, jdbcType.TYPE_CODE);
				}
			}

			@Override
			public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
				//�ӽ��������,������ȡֵ
				Integer i = rs.getInt(columnName);
				return i == null ? null : getEnumuByValue(i);
			}

			@Override
			public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
				//�ӽ��������,λ�û�ȡֵ
				Integer i = rs.getInt(columnIndex);
				return i == null ? null : getEnumuByValue(i);
			}

			@Override
			public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
				//�洢����
				Integer i = cs.getInt(columnIndex);
				return i == null ? null : getEnumuByValue(i);
			}
			/**
			 * ����valuֵ,��ȡö�ٶ���
			 * @param value ���ݿ��д洢���Զ���value����
			 * @return ����value��Ӧ��ö����
			 */
			private E getEnumuByValue(Integer value) {
				for(E e : enums) {
					if(e.getValue().equals(value)) {
						return e;
					}
				}
				throw new IllegalArgumentException("δ֪��ö������:" + value + ",��˶�" + type.getSimpleName());
			}
		}


	
	# ע��
		<typeHandler handler="net.itaem.handler.UniversalHandler"  javaType="net.itaem.less.PersonType" jdbcType="TINYINT"/>  
		* jdbcType ֻ���� JdbcType ö��ֵ�е�һ��,��������ݿ������
		* javaType ��ʾҪת����JAVA����

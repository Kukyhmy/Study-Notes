-----------------------
MyBatis-��ҳ���		|
-----------------------
	# maven
		<dependency>
			<groupId>com.github.pagehelper</groupId>
			<artifactId>pagehelper</artifactId>
		</dependency>

-------------------------
MyBatis-PageRowBounds��ҳ|
-------------------------
	# mybatis����
		<plugin interceptor="com.github.pagehelper.PageInterceptor">
			<!-- ���� -->
			<property name="helperDialect" value="mysql"/>
			<!-- RowBounds�����offset������Ϊ��ҳ��page���� -->
			<property name="offsetAsPageNum" value="true"/>
			<!-- ��ҳ������������ֹ��Ϊҳ��ͷβ������������ռ�¼ -->
			<property name="reasonable" value="true"/>
			<!-- �� pageSize(limit) = 0 ����ҳ�룬ֱ�Ӽ��������еļ�¼ -->
			<property name="pageSizeZero" value="true"/>
			<!-- RowBounds ��Ϊ��ҳ����ʱ��Ҫ���ܼ�¼�� -->
			<property name="rowBoundsWithCount" value="true"/>
		</plugin>
	
	# ����

		// SQL�������˶���
		UserEntity userEntity = new UserEntity();
		
		// ҳ���ÿҳ��ʾ����
		PageRowBounds pageRowBounds = new PageRowBounds(2, 1);

		// �Ƿ�Ҫ�����ܼ�¼��
		pageRowBounds.setCount(true);
		
		List<UserEntity> users = this.userMapper.pageTest(userEntity ,pageRowBounds);
		
	
		* pageRowBounds ������
			{
				"count":true,			// �Ƿ�����ܼ�¼����
				"limit":1,				// ÿҳ��ʾ����
				"offset":2,				// ��ǰҳ��
				"total":3				// �ܼ�¼����
			}

-------------------------
MyBatis-��������	 |
-------------------------
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
	<settings>
		<!-- �Զ�ת��ʵ������Ժ������Ĺ����շ�-�»��ߣ� -->
		<setting name="mapUnderscoreToCamelCase" value="true" />
		<!-- Ĭ��ö�ٴ��� -->
		<setting name="defaultEnumTypeHandler" value="org.apache.ibatis.type.EnumOrdinalTypeHandler"/>
		<!-- �Զ�ӳ�䣬����δ֪�У�����δ֪�������ͣ��׳��쳣 
		<setting name="autoMappingUnknownColumnBehavior" value="FAILING"/>
		-->
		<!-- �Զ�ӳ�䣬�κθ��ӵĽ���� -->
		<!-- <setting name="autoMappingBehavior" value="FULL"/>  -->
	</settings>
	<typeAliases>
		<package name="com.quliao.core.domain"/>
	</typeAliases>
	<typeHandlers>
		<typeHandler handler="org.apache.ibatis.type.EnumTypeHandler" javaType="com.quliao.core.domain.enums.SysCode" jdbcType="VARCHAR"/>
	</typeHandlers>
	<plugins>
		<plugin interceptor="com.github.pagehelper.PageInterceptor">
			<!-- ���� -->
			<property name="helperDialect" value="mysql"/>
			<!-- RowBounds�����offset������Ϊ��ҳ��page���� -->
			<property name="offsetAsPageNum" value="true"/>
			<!-- ��ҳ������������ֹ��Ϊҳ��ͷβ������������ռ�¼ -->
			<property name="reasonable" value="true"/>
			<!-- �� pageSize(limit) = 0 ����ҳ�룬ֱ�Ӽ��������еļ�¼ -->
			<property name="pageSizeZero" value="true"/>
			<!-- RowBounds ��Ϊ��ҳ����ʱ��Ҫ���ܼ�¼�� -->
			<property name="rowBoundsWithCount" value="true"/>
		</plugin>
	</plugins>
</configuration>

-------------------------
MyBatis-PageHelper��ҳ	 |
-------------------------
	# ��̬����
		// �������򲻷�ҳ
		Page<E> PageHelper.orderBy(String string);

		// ��ʼ��ҳ���������ܼ�¼��
		Page<E> PageHelper.startPage(1, 100, false);
	
	# ʵ������
		* ֧����ʽ����

		Page<E> setOrderBy(String orderBy)
			* ���������ֶ�

		void setOrderByOnly(boolean orderByOnly)
			* �����Ƿ�ֻ���򣬲���ҳ
				

-------------------------
MyBatis-��̬�Ľ��������ֶ�|
-------------------------
	# ��̬�Ľ��������ֶ�
			/**
		 * ���������ֶ�
		 * 
		 * @param sorts
		 * @param orders
		 * @return
		 */
		public static String order(String[] columns, String[] orders) {

			if (columns == null || columns.length == 0 || orders == null || orders.length == 0) {
				return "";
			}

			if (columns.length != orders.length) {
				// ���뱣֤ÿ���ֶζ��������������
				throw new ServiceException(HttpStatus.BAD_REQUEST, "�����ֶκ�������Ա���һһ��Ӧ");
			}

			int length = columns.length;

			StringBuilder stringBuilder = new StringBuilder();

			for (int x = 0; x < length; x++) {

				String column = columns[x];
				String order = orders[x];

				// �ж������ƵĺϷ��ԣ���ֹSQLע�롣ֻ���ǡ���ĸ�����֣��»��ߡ�
				if (!column.matches("[A-Za-z0-9_]+")) {
					throw new ServiceException(HttpStatus.BAD_REQUEST, "�Ƿ��������ֶ����ƣ�" + column);
				}

				// �շ�ת��Ϊ�»���
				column = humpConversionUnderscore(column);

				order = order.toUpperCase();

				// �ж�������ԵĺϷ���
				if (!(order.equals("ASC") || order.equals("DESC"))) {
					throw new ServiceException(HttpStatus.BAD_REQUEST, "�Ƿ���������ԣ�" + column);
				}

				if (x != 0) {
					stringBuilder.append(", ");
				}
				stringBuilder.append("`" + column + "` " + order);
			}
			return stringBuilder.toString();
		}

		/**
		 * �շ�ת��Ϊ�»���
		 * 
		 * @param value
		 * @return
		 */
		public static String humpConversionUnderscore(String value) {
			StringBuilder stringBuilder = new StringBuilder();
			char[] chars = value.toCharArray();
			for (char charactor : chars) {
				if (Character.isUpperCase(charactor)) {
					stringBuilder.append("_");
					charactor = Character.toLowerCase(charactor);
				}
				stringBuilder.append(charactor);
			}
			return stringBuilder.toString();
		}
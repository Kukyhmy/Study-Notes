----------------------------
MyBatis-ע��				|
----------------------------
	@Param
		* ���ע��,�Ǳ�ʶ��Mapper�ӿڵ��β���
		* ��ʵ����˵,Mapper�ӿڵ��β�,�����Ƕ���򵥵���������,ͨ��ע������������,��mapper.xml�о�ʹ��ע���ʶ�������������������
		* ͨ�����ע��,��ָ����εĲ�����
		['Demo']
			public User queryByNameAndPass(
										@Param(value="userName")String userName,
										@Param(value="password")String password);

			<select id="queryByNameAndPass" resultType="User">
				SELECT * FROM tb_user WHERE user_name = #{userName} AND password = #{password}
			</select>
	
	@Insert
	@Update
	@Delete
	@Selct
		# ����ע��,һ�۾Ϳ�����
	
	@Result
	@Results

----------------------------
MyBatis-demo				|
----------------------------
@Repository
public interface FooMapper extends BaseMapper<FooEntity>{
	
	class FooSqlProvider extends BaseSqlProvider<FooEntity> {
		
	}
	
    //===================================
	//��ȡ��������
	@Options(useGeneratedKeys = true,keyProperty = "fooId",keyColumn = "foo_id")					
	@InsertProvider(type = FooSqlProvider.class,method = "create")
	//Ҳ���Ի�ȡ��������
//	@SelectKey(before = false,keyColumn = "foo_id",keyProperty = "fooId",resultType = Integer.class,statement = "SELECT LAST_INSERT_ID();")
	int create(FooEntity foo);


    //===================================
	@SelectProvider(type = FooSqlProvider.class,method = "queryByPrimaryKey")
	@ResultMap(value = "BASE_RESULT_MAP")
	FooEntity queryByPrimaryKey(Serializable primaryKey);

    @SelectProvider(type = FooSqlProvider.class,method = "queryByParamSelective")
    @ResultMap(value = "BASE_RESULT_MAP")
	FooEntity queryByParamSelectiveUnique(FooEntity fooEntity);
	
	@SelectProvider(type = FooSqlProvider.class,method = "queryByParamSelective")
	@Results(id = "BASE_RESULT_MAP",value = {
		@Result(id = true,column = "foo_id",property = "fooId"),
		@Result(column = "create_date",property = "createDate"),
		@Result(column = "modify_date",property = "modifyDate"),
		@Result(column = "create_user",property = "createUser"),
		@Result(column = "status",property = "status"),
		@Result(column = "sorted",property = "sorted"),
		@Result(column = "remark",property = "remark"),
	})
	List<FooEntity> queryByParamSelective(FooEntity foo);

    //===================================
	@UpdateProvider(type = FooSqlProvider.class,method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(FooEntity foo);

    @UpdateProvider(type = FooSqlProvider.class,method = "updateByPrimaryKey")
	int updateByPrimaryKey(FooEntity foo);

    //===================================
	@DeleteProvider(type = FooSqlProvider.class,method = "deleteByPrimaryKey")
	int deleteByPrimaryKey(Serializable deleteByPrimaryKey);
	
	@DeleteProvider(type = FooSqlProvider.class,method = "deleteByParamSelective")
	@ResultMap(value = "BASE_RESULT_MAP")
	int deleteByParamSelective(FooEntity fooEntity);
	
	@SelectProvider(type = FooSqlProvider.class,method = "queryByParamSelective")
	@ResultMap(value = "BASE_RESULT_MAP")
	PageList<FooEntity> queryByPage(FooEntity fooEntity,PageBounds pageBounds);
}




# Provider�Ľӿ�֧��һ������
	ProviderContext
		private final Class<?> mapperType; // mapper�ӿ�
		private final Method mapperMethod; // mapper����


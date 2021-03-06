/**
 * Created by KevinBlandy on 2018/3/28 13:49
 */
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {

    class UserSqlProvider extends BaseSqlProvider<UserEntity> {

    }

    @SelectProvider(type = UserSqlProvider.class,method = "queryByPrimaryKey")
    //@SelectKey(before = false,keyColumn = "user_id",keyProperty = "userId",resultType = Integer.class,statement = "SELECT LAST_INSERT_ID();")
    @Results(id = "BASE_RESULT_MAP",value = {
            @Result(id = true,column = "user_id",property = "userId"),
            @Result(column = "name",property = "name"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "email_verify",property = "emailVerify"),
            @Result(column = "phone_verify",property = "phoneVerify"),
            @Result(column = "gender",property = "gender"),
            @Result(column = "avatar",property = "avatar"),
            @Result(column = "age",property = "age"),
            @Result(column = "location",property = "location"),
            @Result(column = "company",property = "company"),
            @Result(column = "url",property = "url"),
            @Result(column = "github",property = "github"),
            @Result(column = "profile",property = "profile"),
            @Result(column = "rank",property = "rank"),
            @Result(column = "role",property = "role"),
            @Result(column = "create_user",property = "createUser"),
            @Result(column = "create_date",property = "createDate"),
            @Result(column = "modify_date",property = "modifyDate"),
            @Result(column = "status",property = "status"),
            @Result(column = "sorted",property = "sorted"),
            @Result(column = "remark",property = "remark"),
    })
    @Override
    UserEntity queryByPrimaryKey(Serializable primaryKey)throws Exception;

    @SelectProvider(type = UserSqlProvider.class,method = "queryByParamSelective")
    @ResultMap("BASE_RESULT_MAP")
    @Override
    UserEntity queryByParamSelectiveUnique(UserEntity entity)throws Exception;

    @SelectProvider(type = UserSqlProvider.class,method = "queryByParamSelective")
    @ResultMap("BASE_RESULT_MAP")
    @Override
    List<UserEntity> queryByParamSelective(UserEntity userEntity)throws Exception;

    @SelectProvider(type = UserSqlProvider.class,method = "queryByParamSelective")
    @ResultMap("BASE_RESULT_MAP")
    @Override
    PageList<UserEntity> queryByPage(UserEntity userEntity, PageBounds pageBounds)throws Exception;

    @Options(useGeneratedKeys = true,keyColumn = "user_id",keyProperty = "userId")
    @InsertProvider(type = UserSqlProvider.class,method = "create")
    @Override
    int create(UserEntity userEntity)throws Exception;

    @UpdateProvider(type = UserSqlProvider.class,method = "updateByPrimaryKeySelective")
    @Override
    int updateByPrimaryKeySelective(UserEntity userEntity)throws Exception;

    @UpdateProvider(type = UserSqlProvider.class,method = "updateByPrimaryKey")
    @Override
    int updateByPrimaryKey(UserEntity userEntity)throws Exception;

    @DeleteProvider(type = UserSqlProvider.class,method = "deleteByPrimaryKey")
    @Override
    int deleteByPrimaryKey(Serializable primaryKey)throws Exception;

    @DeleteProvider(type = UserSqlProvider.class,method = "deleteByParamSelective")
    @Override
    int deleteByParamSelective(UserEntity userEntity)throws Exception;
}

===============================================================
/**
 * @author KevinBlandy
 */
public abstract class BaseSqlProvider <T extends BaseEntity> {
	
	//????????????
	private Class<?> clazz;
	
	//?????????
	private String tableName;
	
	//...
	private String nickTableName;
	
	//????????????
	private List<Field> allFields = new ArrayList<>();
	
	//pk??????
	private List<Field> idFields = new ArrayList<>();
	
	//????????????
	private List<Field> ordinaryFields = new ArrayList<>();
	
	
	public BaseSqlProvider() {
		this.clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Entity entity = this.clazz.getAnnotation(Entity.class);
		if(entity == null) {
			throw new RuntimeException(this.clazz.getName() + ",?????????@Entity??????");
		}else {
			this.tableName = entity.value();
		}
		this.nickTableName = "`" + this.tableName + "`";
		Class<?> tempClass = clazz;
		while(tempClass != null) {
			//???????????????????????????
			this.allFields.addAll(Arrays.asList(tempClass.getDeclaredFields()));
			tempClass = tempClass.getSuperclass();
		}
		Iterator<Field> fieldIterator = this.allFields.iterator();
		while(fieldIterator.hasNext()) {
			Field field = fieldIterator.next();
			if(Modifier.isStatic(field.getModifiers()) || field.isAnnotationPresent(Ignore.class)){
				//???????????? & @Ignore
				fieldIterator.remove();
			}else {
				field.setAccessible(true);
				if(field.isAnnotationPresent(Id.class)) {
					this.idFields.add(field);
				}else {
					this.ordinaryFields.add(field);
				}
			}
		}
	}
	
	/**
	 * ??????????????????
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public String create() throws IllegalArgumentException, IllegalAccessException{
		SQL sql = new SQL();
		sql.INSERT_INTO(nickTableName);
		for(Field field : this.allFields) {
			sql.INTO_COLUMNS(underlineStyle(field.getName()));
		}
		for(Field field : this.allFields) {
			sql.INTO_VALUES("#{"+field.getName()+"}");
		}
		return sql.toString();
	}

	/**
	 * ??????pk?????????????????????
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public String queryByPrimaryKey()  throws IllegalArgumentException, IllegalAccessException {
		SQL sql = new SQL();
		sql.SELECT("*").FROM(this.nickTableName);
		for(Field field : this.idFields) {
			String fieldName = field.getName();
			sql.WHERE("`"+underlineStyle(fieldName)+"` = #{" + fieldName + "}");
		}
		return sql.toString();
	}
	
	/**
	 * ??????????????????,?????????????????????
	 * @param param
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 
	public String queryByParamSelectiveUnique(T param) throws IllegalArgumentException, IllegalAccessException {
		return this.queryByParamSelective(param);
	}*/
	
	/**
	 * ??????????????????????????????
	 * @param param
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public String queryByParamSelective(T param) throws IllegalArgumentException, IllegalAccessException {
		SQL sql = new SQL();
		sql.SELECT("*").FROM(this.nickTableName);
		if(param != null) {
			this.ifParamNotNull(this.allFields, param, fieldName -> {
				sql.WHERE("`"+underlineStyle(fieldName)+"` = #{" + fieldName + "}");
			});
		}
		return sql.toString();
	}
	
	/**
	 * ????????????????????????,????????????????????????
	 * @param param
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public String updateByPrimaryKeySelective(T param) throws IllegalArgumentException, IllegalAccessException{
		SQL sql = new SQL();
		sql.UPDATE(this.nickTableName);
		this.ifParamNotNull(this.ordinaryFields, param, fieldName -> {
			sql.SET("`"+underlineStyle(fieldName)+"` = #{" + fieldName + "}");
		});
		for(Field field : this.idFields){
			String fieldName = field.getName();
			sql.WHERE("`"+underlineStyle(fieldName)+"` = #{" + fieldName + "}");
		}
		return sql.toString();
	}
	
	/**
	 * ????????????????????????,??????????????????
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public String updateByPrimaryKey()  throws IllegalArgumentException, IllegalAccessException{
		SQL sql = new SQL();
		sql.UPDATE(this.nickTableName);
		for(Field field : this.ordinaryFields) {
			String fieldName = field.getName();
			sql.SET("`"+underlineStyle(fieldName)+"` = #{" + fieldName + "}");
		}
		for(Field field : this.idFields) {
			String fieldName = field.getName();
			sql.WHERE("`"+underlineStyle(fieldName)+"` = #{" + fieldName + "}");
		}
		return sql.toString();
	}
	
	/**
	 * ????????????,????????????
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public String deleteByPrimaryKey() throws IllegalArgumentException, IllegalAccessException {
		SQL sql = new SQL();
		sql.DELETE_FROM(this.nickTableName);
		for(Field field : this.idFields) {
			String fieldName = field.getName();
			sql.WHERE("`"+underlineStyle(fieldName)+"` = #{" + fieldName + "}");
		}
		return sql.toString();
	}
	
	/**
	 * ??????????????????????????????
	 * !!!???????????????????????????null,???????????????????????????
	 * @param param
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	
	public String deleteByParamSelective(T param) throws IllegalArgumentException, IllegalAccessException{
		SQL sql = new SQL();
		sql.DELETE_FROM(this.nickTableName);
		this.ifParamNotNull(this.allFields, param, fieldName -> {
			sql.WHERE("`"+underlineStyle(fieldName)+"` = #{" + fieldName + "}");
		});
		return sql.toString();
	}
	
	
	
	/**
	 * sql render
	 * @param fields
	 * @param param
	 * @param consumer
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private void ifParamNotNull(List<Field> fields,T param,Consumer<String> consumer) throws IllegalArgumentException, IllegalAccessException {
		for(Field field : fields) {
			if(field.get(param) != null) {
				consumer.accept(field.getName());
			}
		}
	}
	
	/**
	 * ??????????????????
	 * @param string
	 * @return
	 */
	private static String underlineStyle(String string) {
		StringBuilder sb = new StringBuilder();
		char[] chars = string.toCharArray();
		for(int x = 0;x < chars.length; x++) {
			if(Character.isUpperCase(chars[x])) {
				sb.append("_");
			}
			sb.append(chars[x]);
		}
		return sb.toString().toLowerCase();
	}
}

===============================================================
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {
	
	//?????????
	String value();
}

@Retention(RUNTIME)
@Target(FIELD)
public @interface Id {

}

@Retention(RUNTIME)
@Target(METHOD)
public @interface Ignore {

}


















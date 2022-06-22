---------------------
��������
---------------------
	@IdClass
		Class value();
		
		* ��ʶ��ʵ������. ָ��id�������ⲿ�������������(����������)
		* ��Ϊ�������������Ҫ�м�������
			1. ����ʵ�� Serializable
			2. ������ public �޲ι�����
			3. ���븲д hashCode equals ����(EntityMangerͨ��find����������Entityʱ,�Ǹ���equals�ķ���ֵ���жϵ�)
		
		// ʹ���û� user_id �� title ��Ϊ��������
		public class UserBlogKey implements Serializable {
			private Integer userId; 
			private String title;	
			// ���Թ��췽����getter/setter/equals/hashCode
		}

		@Entity
		@Table(name = "user_blog")
		@IdClass(value = UserBlogKey.class) // ָ������������
		public class UserBlog {
			// ָ���������������е��ֶ�����
			@Id
			@Column(name = "user_id", nullable = false)
			private Integer userId;
			// ָ���������������е��ֶ�����
			@Id
			@Column(name = "title", nullable = false)
			private String title;
			
			// �������ֶ�
			@Column(name = "name")
			private String name;  

			// ����getter/setter
		}

		CREATE TABLE `user_blog` (
		  `title` varchar(255) NOT NULL,
		  `user_id` int(11) NOT NULL,
		  `id` int(11) NOT NULL,
		  `name` varchar(255) DEFAULT NULL,
		  PRIMARY KEY (`title`,`user_id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
		
		interface UserBlogRepository extends JpaRepository<UserBlog, UserBlogKey>

---------------------
demo
---------------------
	import java.io.Serializable;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.IdClass;
	import javax.persistence.Table;

	@Entity
	@Table(name = "user_role")
	@IdClass(UserRole.Id.class)
	public class UserRole implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 9083244121513095387L;

		@javax.persistence.Id
		@Column(columnDefinition = "INT(11) unsigned COMMENT '�û�id'")
		private Integer userId;
		
		@javax.persistence.Id
		@Column(columnDefinition = "INT(11) unsigned COMMENT '�û�id'")
		private Integer roleId;

		public Integer getUserId() {
			return userId;
		}
		public Integer getRoleId() {
			return roleId;
		}
		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		
		public static class Id implements Serializable {
			private static final long serialVersionUID = 2424506186663199332L;
			private Integer userId;
			private Integer roleId;
			public Integer getUserId() {
				return userId;
			}
			public void setUserId(Integer userId) {
				this.userId = userId;
			}
			public Integer getRoleId() {
				return roleId;
			}
			public void setRoleId(Integer roleId) {
				this.roleId = roleId;
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
				result = prime * result + ((userId == null) ? 0 : userId.hashCode());
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Id other = (Id) obj;
				if (roleId == null) {
					if (other.roleId != null)
						return false;
				} else if (!roleId.equals(other.roleId))
					return false;
				if (userId == null) {
					if (other.userId != null)
						return false;
				} else if (!userId.equals(other.userId))
					return false;
				return true;
			}
		}
	}
	
	
	@NoRepositoryBean
	public interface BaseRepository <T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor <T>, QuerydslPredicateExecutor<T> {
	}
		
	public interface UserRoleRepository extends BaseRepository<UserRole, UserRole.Id> {
	}
	

	// ��������idɾ����ʽ1
	UserRole userRole = new UserRole();
	userRole.setRoleId(1);
	userRole.setUserId(1);
	this.userRoleService.delete(userRole);
	
	// ��������idɾ����ʽ2
	UserRole.Id id = new UserRole.Id();
	id.setRoleId(1);
	id.setUserId(1);
	this.userRoleService.deleteById(id);  // ���ɾ���ļ�¼�����ڣ�������쳣

	



import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

��myabtis�����ļ���������²������
	<plugins>
		<plugin interceptor="com.github.miemiedev.mybatis.paginator.OffsetLimitInterceptor">
			<property name="dialectClass" value="com.github.miemiedev.mybatis.paginator.dialect.MySQLDialect"/>
		</plugin>
	</plugins>
	* ָ�����ݿⷽ��



package com.kevin.blog.comm.utils;
import java.util.ArrayList;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
/**
 * ��ҳ����
 * */
public class PageUtils {
	/**
	 * ��ȡһ��PageBounds
	 * */
	public static PageBounds getPageBounds(int pageCode,int pageSize,Order...orders){
		PageBounds pageBounds = new PageBounds(pageCode,pageSize);
		if(orders != null && orders.length > 0){
			//����һ�����߶���������
			pageBounds.setOrders(Arrays.asList(orders));
		}
		//��Ҫ��ѯ������
		pageBounds.setContainsTotalCount(Boolean.TRUE);
		//��ֹ�첽��ѯ������
		pageBounds.setAsyncTotalCount(Boolean.FALSE);
		return pageBounds;
	}
	/**
	 * ��ȡһ���������
	 * sorts��orders�ֱ���������ֶ�,������Ĳ���.����Ӧ����һһ��Ӧ
	 */
	public Order[] getOrders(String[] sorts,String[] orders){
		List<Order> result = new ArrayList<Order>();
		if(!this.isEmpty(sorts)){
			if(this.isEmpty(orders)){
				//δ�����������,Ĭ��ȫ��Ϊ:DESC
				for(String sort : sorts){
					if(!isEmpty(sort)){
						result.add(this.getOrderDesc(sort));
					}
				}
			}else{
				//�����������
				for(int x = 0 ;x < sorts.length ; x++){
					if(x < orders.length){
						if("ASC".equalsIgnoreCase(orders[x])){
							result.add(this.getOrderAsc(sorts[x]));		//ASC����
						}else{
							result.add(this.getOrderDesc(sorts[x]));	//DESC����
						}
					}else{
						result.add(this.getOrderDesc(sorts[x]));		//sortsδ����������Բ���ȫ��Ĭ��Ϊ:DESC
					}
				}
			}
		}
		return result.toArray(new Order[result.size()]);
	}
	/**
	 * ��ȡһ��Order,��������
	 */
	public Order getOrderDesc(String field){
		return new Order(field,Direction.DESC,null);
	}
	/**
	 * ��ȡһ��Order,��������
	 */
	public Order getOrderAsc(String field){
		return new Order(field,Direction.ASC,null);
	}
}




��Ȼ��Ҫע����ǣ�ֻҪ���õ����첽��ѯ(page.setContainsTotalCount(true))��
��������ʹ�����̳߳أ�������ʹ��ʱ��Ҫ����������������Ա���ֹͣ����ʱ�ر��̳߳ء���Ҫ��web.xml�м���

<listener>  
    <listener-class>com.github.miemiedev.mybatis.paginator.CleanupMybatisPaginatorListener</listener-class>  
</listener>  


����maven�ֿ������ַ:
	<dependency>
		<groupId>com.github.miemiedev</groupId>
		<artifactId>mybatis-paginator</artifactId>
		<version>${mybatis-paginator.version}</version>
	</dependency>
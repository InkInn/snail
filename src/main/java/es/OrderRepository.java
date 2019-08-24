package es;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author rcli
 * Created on 2019-06-18.
 */
public interface OrderRepository extends ElasticsearchRepository<Order, Long>, OrderEsCommonRepository {

    Order findByUserNameAndSkuName(String userName, String skuName);

    /**
     * 使用Query注解指定查询语句
     *
     * @param userName
     * @param skuName
     * @return
     */
    //双引号和不加引号都可，不能是单引号
    //   @Query("{bool : {must : [ {field : {userName : ?}}, {field : {skuName : ?}} ]}}")   . //---   field查询已经废弃，可参考当前查询语法，已换成term查询
    @Query("{\"bool\" : {\"must\" : [ {\"term\" : {\"skuName\" : \"?1\"}}, {\"term\" : {\"userName\" : \"?0\"}} ]}}")
    //注意：需要替换的参数？需要加双引号；需要指定参数下标，从0开始
    Order findByUserNameAndSkuName2(String userName, String skuName);

}

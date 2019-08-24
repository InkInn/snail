package es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author rcli
 * Created on 2019-06-18.
 */

@Data
@Document(indexName = "test_es_order_index",type = "test_es_order_type")
public class Order {

    @Id
    private Long id;

    private String userName;

    private String skuName;

}

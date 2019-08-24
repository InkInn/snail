package es;

import lombok.Data;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * @author rcli
 * Created on 2019-06-18.
 */

@Data
public class OrderRepositoryImpl implements OrderEsCommonRepository {


    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public boolean createOrderIndex() {
        return elasticsearchTemplate.createIndex(Order.class);
    }
}

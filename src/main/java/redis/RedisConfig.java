package redis;

import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author rcli
 * Created on 2019-06-02.
 */
@Configuration
public class RedisConfig extends JCacheConfigurerSupport {
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("192.168.3.44", 6379);
        JedisClientConfiguration.JedisClientConfigurationBuilder builder = JedisClientConfiguration.builder();
        builder.connectTimeout(Duration.ofSeconds(30));
//        config.setPassword("jredis123456");
        return new JedisConnectionFactory(config,builder.build());
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, String> redis = new RedisTemplate<>();
        redis.setConnectionFactory(redisConnectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redis.setKeySerializer(stringRedisSerializer);
        redis.setValueSerializer(stringRedisSerializer);
        redis.setHashKeySerializer(stringRedisSerializer);
        redis.setHashValueSerializer(stringRedisSerializer);
        redis.afterPropertiesSet();
        return redis;
    }
}

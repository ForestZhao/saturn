//package com.zjs.saturn.common.redis;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//@Configuration
//public class RedisConfig {
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    @Value("${spring.redis.jedis.pool.max-idle}")
//    private int maxIdle;
//
//    @Value("${spring.redis.jedis.pool.max-wait}")
//    private long maxWaitMillis;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    @Value("${spring.redis.block-when-exhausted}")
//    private boolean  blockWhenExhausted;
//
//    @Value("${spring.redis.maxTotal}")
//    private Integer maxTotal;
//
//
//
//
//
//
//
//    /**
//     * JedisPoolConfig 连接池
//     * @return
//     */
//    @Bean
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        // 最大空闲数
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        // 连接池的最大数据库连接数
//        jedisPoolConfig.setMaxTotal(maxTotal);
//        // 最大建立连接等待时间
//        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//        return jedisPoolConfig;
//    }
//    /**
//     * 单机版配置
//     * @Title: JedisConnectionFactory
//     * @param @param jedisPoolConfig
//     * @param @return
//     * @return JedisConnectionFactory
//     * @throws
//     */
//    @Bean
//    public JedisConnectionFactory JedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
//        JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
//        //连接池
//        JedisConnectionFactory.setPoolConfig(jedisPoolConfig);
//        //IP地址
//        JedisConnectionFactory.setHostName(host);
//        //端口号
//        JedisConnectionFactory.setPort(6379);
//        //如果Redis设置有密码
//        //JedisConnectionFactory.setPassword(password);
//        //客户端超时时间单位是毫秒
//        JedisConnectionFactory.setTimeout(5000);
//        return JedisConnectionFactory;
//    }
//
//    /**
//     * 实例化 RedisTemplate 对象
//     *
//     * @return
//     */
//    @Bean
//    public RedisTemplate<String, Object> functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
//        return redisTemplate;
//    }
//    /**
//     * 设置数据存入 redis 的序列化方式,并开启事务
//     *
//     * @param redisTemplate
//     * @param factory
//     */
//    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
//        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        // 开启事务
//        redisTemplate.setEnableTransactionSupport(true);
//        redisTemplate.setConnectionFactory(factory);
//    }
//
//
//}

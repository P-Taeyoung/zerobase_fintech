package com.zerobase.api.config

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer


@Configuration
@EnableCaching
class RedisCacheConfig {

    @Bean
    fun redisCacheManager(cacheFactory: RedisConnectionFactory): CacheManager {
        val redisCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
            .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer()))
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(GenericJackson2JsonRedisSerializer()))
            .entryTtl(java.time.Duration.ofMinutes(10))

        return RedisCacheManager
            .RedisCacheManagerBuilder
            .fromConnectionFactory(cacheFactory)
            .cacheDefaults(redisCacheConfig)
        .build()
    }

}
package com.wapl.springredis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  Redis 설정 클래스
 */
@Configuration
public class RedissonConfig {
  @Value("#{'${redis.cluster.nodes:}'.split(',')}")
  private String[] clusterNodes;

  @Bean
  public RedissonClient redissonClient() {
    Config config = new Config();
    config.useClusterServers()
      .addNodeAddress(                "redis://127.0.0.1:7001",
        "redis://127.0.0.1:7002",
        "redis://127.0.0.1:7003",
        "redis://127.0.0.1:7101",
        "redis://127.0.0.1:7102",
        "redis://127.0.0.1:7103");
    return Redisson.create(config);
  }
}

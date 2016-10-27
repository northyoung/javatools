package com.d.work.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by young on 2016/10/22.
 */
interface RedisDataSource {

    public abstract ShardedJedis getRedisClient();

    public void returnResource(ShardedJedis shardedJedis);

    public void returnResource(ShardedJedis shardedJedis, boolean broken);

}

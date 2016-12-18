package com.d.work.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;
/**
 * Created by young on 2016/11/24.
 */
public class RedisClusterSpringTest {
    private static final Log log = LogFactory.getLog(RedisClusterSpringTest.class);

    public static void main(String[] args) {
        try{
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");

            context.start();
            JedisCluster jedisCluster = (JedisCluster) context.getBean("jedisCluster");
            int num = 100 ;
            String key = "ssy";
            String value = "";
            for(int i=0;i<=num ;i++){
                // 存数据
//                jedisCluster.set(key+i, "yingjun"+i);
//                jedisCluster.setex(key+i, 60, "yingjun"+i);

                // 取数据
                value = jedisCluster.get(key+i);
                log.info(key+i + "=" + value);

                // 删除数据
                //jedisCluster.del(key+i);
                //value = jedisCluster.get(key+i);
                //log.info(key+i + "=" + value);
            }
            context.stop();
        } catch (Exception e){
            log.error("==>RedisSpringTest context start error:", e);
        } finally {
            log.info("===>System.exit");
        }
    }
}

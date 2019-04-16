package test;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class testRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.90.3.118", 6379);
        jedis.auth("h3c.com!");
        Set<String> set = jedis.keys("TOPIC_CODE_PAY*");
        set.forEach(s -> {
            System.out.println(jedis.ttl(s));
        });
    }
}

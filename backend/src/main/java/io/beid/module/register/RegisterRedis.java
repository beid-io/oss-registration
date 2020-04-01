package io.beid.module.register;


import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;


public class RegisterRedis {

    private final Config config = new Config();
    private final RedissonClient redisson;
    private final RBucket<String> bucket;
    private final RMap<String, RegisterEntity> map;

    public RegisterRedis(final String address) {
        config.useSingleServer().setAddress(address);
        redisson = Redisson.create(config);
        bucket = redisson.getBucket("person");
        bucket.set("This is object value");
        map = redisson.getMap("simpleMap");
    }

    public void put(final RegisterEntity e) {
        map.fastPut(e.id, e);
    }

}

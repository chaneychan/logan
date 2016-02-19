package me.ele.logan.admin.service;

import javax.annotation.Resource;

import me.ele.ipd.redis.RedisClientProxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * <pre>
 *   User后台管理服务实现单元测试
 * </pre>
 *
 * @author qunxi.shao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class RedisClientTest {
	
	
	@Resource(name = "redis_data_pool")
    private RedisClientProxy redisClientProxy;
	
	
	@Test
	public void testRedisClient() throws Exception{
		
		String key = "appkey:method:version";
		redisClientProxy.set(key,1,1);
		Long  ff = redisClientProxy.incr("fdsf", 1);
		
		Object o  = redisClientProxy.get(key);
		System.out.println("========"+o);
	}

}

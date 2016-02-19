package me.ele.logan.admin.service;

import java.util.Date;

import me.ele.logan.admin.model.ApiLog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ApiLogServiceTest {

	
	@Autowired
	private ApiLogService apiLogService;
	
	
	@Test
	public void saveLog() throws Exception{
		
		ApiLog log = new ApiLog();
		
		log.setAppKey("1212");
		log.setClientIp("127.0.0.1");
		log.setCreateTime(new Date());
		log.setMethodName("queryOrders");
		log.setVersion("1.0");
		log.setCreator("admin");
		log.setRequestValue("[{id:1,name:1212}]");
		log.setResponseValue("[{dd:ff}]");
		log.setTime("12");
		log.setType(1);
		log.setCreatorId(1l);
		
		
		apiLogService.insert(log);
		
		
		
		
		
		
	}
}

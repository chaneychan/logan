package me.ele.logan.admin.service;

import java.util.Date;

import me.ele.logan.admin.model.BizLog;

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
public class BizLogServiceTest {
	
	
	@Autowired
	private BizLogService bziLogService;
	
	
	@Test
	public void saveLog() throws Exception{
		
		BizLog log = new BizLog();
		
		log.setBizCode("biz1111");
		log.setBizId(11l);
		log.setMethod("fdsfsdfs");
		
		log.setCreateTime(new Date());
		log.setVersion("1.0");
		log.setCreator("admin");
		log.setRequestValue("[{id:1,name:1212}]");
		log.setResponseValue("[{dd:ff}]");
		log.setTime("12");
		log.setType(1);
		log.setCreatorId(1l);
		log.setModuleId(1l);
		log.setStartTime(new Date());
		log.setEndTime(new Date());
		
		bziLogService.insert(log);
		
		
		
		
		
		
	}

}

package me.ele.logan.admin.service;

import java.util.Date;

import me.ele.logan.admin.dao.AppKeyDao;
import me.ele.logan.admin.model.ApiLog;
import me.ele.logan.admin.model.AppKey;

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
public class AppKeyServiceTest {

	
	
	@Autowired
	private AppKeyDao appKeyDao;
	
	@Autowired
	private AppKeyService appKeyServcie;
	
	@Test
	public void testAppKey() throws Exception{
		
		String appKey = "cQ5dy4VAe2"	;
		AppKey app = appKeyDao.selectByAppKey(appKey);
		System.out.println(app.getAppSecret());
		appKeyServcie.deleteRedisAppKey(appKey);
		appKeyServcie.selectByAppKey(appKey);
	}
}

package me.ele.logan.admin.service;

import java.util.Date;

import me.ele.logan.admin.dao.ApiMethodDao;
import me.ele.logan.admin.model.ApiMethod;

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
public class ApiMethodServiceTest {
	
	@Autowired
	private ApiMethodDao apiMethodDao;

	@Test
	public void saveMethod() throws Exception{
		
		ApiMethod method = new ApiMethod ();
		method.setBizConf("order,price1");
		method.setBizId(1l);
		method.setModuleId(1l);
		method.setCreateTime(new Date());
		method.setCreator("admin");
		method.setStatus(1);
		method.setMethodName("queryOrder");
		method.setVersion("2");
		method.setCreatorId(1l);
		method.setBizMethodName("http://breakfast.com/111.html");
		
		apiMethodDao.insert(method);
		
	}
	
	
	@Test
	public void queryMethod() throws Exception{
		
		ApiMethod method = new ApiMethod ();
		method.setMethodName("breakfast.openCitys");
		method.setVersion("2.0");
		
		ApiMethod apiMethod = apiMethodDao.selectDynamic(method);

		System.out.println("bizId:" + apiMethod.getBizId() +": "+ apiMethod.getBizConf());
	}
	
	
	

}

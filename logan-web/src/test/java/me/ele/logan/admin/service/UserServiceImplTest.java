package me.ele.logan.admin.service;

import me.ele.logan.admin.dao.UserDao;
import me.ele.logan.admin.model.User;
import me.ele.logan.admin.vo.UserVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rop.utils.RopUtils;

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
public class UserServiceImplTest {
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private UserService userService;
	/**
	 * 
	 * <pre>
	 * 保存用户信息
	 * </pre>
	 *
	 * @return
	 * @throws ItemServiceException
	 */
	@Test
	public void saveUser() throws Exception{
		User user = new User();
		user.setName("dianping");
		user.setDescription("dianping interface");
		user.setAddress("fds");
		user.setEmail("frankxi@126.com");
		
		user.setType(1);
		user.setStatus(1);
		
		
		user.setRate(1000000);
		userService.insert(user);
		
		
	};
	
	
	@Test
	public void queryUser() throws Exception{
		User user  = userDao.get(8l);
		System.out.println(user.getAddress());
	};
	
	
	@Test
	public void updateUser() throws Exception{
		UserVo user  = new UserVo();
		
		user.setType(1);
		user.setStatus(1);
		
		user.setDescription("dianping interface");
		user.setAddress("fds");
		user.setEmail("frankxi@126.com");
		
		user.setId(1l);
		user.setName("dianpin");
		user.setRate(10000);
		userService.update(user);
		
		System.out.println(user.getAddress());
	};
	
	
}

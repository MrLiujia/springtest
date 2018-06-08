package springtest.di.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
	
	private IUserDao userDao;
	
	private BCryptPasswordEncoder passwordEncoder;
	
	// spring会注入实现了IUserDao的组件
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Autowired
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void register(String username, String password) {
		System.out.println("检查用户名" + username + "是否存在...");
		if (userDao.usernameExists(username)) {
			System.out.println("注册失败，用户名" + username + "已存在");
		} else {
			System.out.println("加密明文密码...");
			String encodedPassword = passwordEncoder.encode(password);
			userDao.insert(username, encodedPassword);
		}
	}

}

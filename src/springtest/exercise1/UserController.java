package springtest.exercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 控制器专用，本质上同@Component
public class UserController {
	// OOP封装原则，协作时知道得越少越好，编写类时，暴露得越少越好
	private IUserService userService; // 依赖类型应该优先使用接口或者父类
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	public void register(String username, String password) {
		System.out.println("注册" + username + "...");
		
		// 外界在使用setPasswordEncoder篡改密码编码器，而这个方法是不应该暴露给外界的
		// 但是改为依赖IUserService接口后，编译器会报错，从而一定程度上阻止暴露
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(30);
//		userService.setPasswordEncoder(passwordEncoder); 
		
		userService.register(username, password);
	}
}

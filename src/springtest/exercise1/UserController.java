package springtest.exercise1;

public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	public void register(String username, String password) {
		System.out.println("注册" + username + "...");
		userService.register(username, password);
	}
}

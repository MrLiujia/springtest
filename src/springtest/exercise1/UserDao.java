package springtest.exercise1;

public class UserDao {

	/**
	 * 查询用户名是否已存在
	 * @param username
	 * @return 存在返回true，否则返回false
	 */
	public boolean usernameExists(String username) {
		return false;
	}

	public void insert(String username, String encodedPassword) {
		System.out.println("插入用户" + username + "(" + encodedPassword + ")");
	}

}

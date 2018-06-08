package springtest.di.ioc.annotation;

public interface IUserDao {

	/**
	 * 查询用户名是否已存在
	 * @param username
	 * @return 存在返回true，否则返回false
	 */
	public abstract boolean usernameExists(String username);

	public abstract void insert(String username, String encodedPassword);

}
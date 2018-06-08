package springtest.di.ioc.annotation;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao {

	@Override
	public boolean usernameExists(String username) {
		return false;
	}

	@Override
	public void insert(String username, String encodedPassword) {
		System.out.println("插入用户" + username + "(" + encodedPassword + ")");
	}

}

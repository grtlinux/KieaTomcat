package dao;

import logic.User;

public interface UserDao {

	public void create(User user);
	public User findByUserIdAndPassword(String userId, String password);
}

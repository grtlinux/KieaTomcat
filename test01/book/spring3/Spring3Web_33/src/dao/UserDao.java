package dao;

import logic.User;

public interface UserDao {

	public User findByUserIdAndPassword(String userId, String password);
}

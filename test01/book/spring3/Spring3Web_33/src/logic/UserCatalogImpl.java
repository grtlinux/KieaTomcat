package logic;

import dao.UserDao;

public final class UserCatalogImpl implements UserCatalog {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		return this.userDao.findByUserIdAndPassword(userId, password);
	}
}

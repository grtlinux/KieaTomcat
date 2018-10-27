package logic;

import dao.UserDao;

public final class UserCatalogImpl implements UserCatalog {

	private UserDao useDao;
	
	public void setUserDao(UserDao userDao) {
		this.useDao = userDao;
	}
	
	@Override
	public void entryUser(User user) {
		this.useDao.create(user);
	}
}

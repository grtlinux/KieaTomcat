package logic;

public final class ShopImpl implements Shop {

	private UserCatalog userCatalog;
	
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}
	
	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		return this.userCatalog.getUserByUserIdAndPassword(userId, password);
	}
}

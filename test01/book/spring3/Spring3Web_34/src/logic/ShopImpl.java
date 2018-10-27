package logic;

public final class ShopImpl implements Shop{

	private UserCatalog userCatalog;
	
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}
	
	@Override
	public void entryUser(User user) {
		this.userCatalog.entryUser(user);
	}
}

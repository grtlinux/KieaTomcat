package logic;

public interface UserCatalog {

	public void entryUser(User user);
	public User getUserByUserIdAndPassword(String userId, String password);
}

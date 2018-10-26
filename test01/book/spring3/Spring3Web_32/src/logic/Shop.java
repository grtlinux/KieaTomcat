package logic;

import java.util.List;

public interface Shop {

	public List<Item> getItemList();
	public Item getItemByItemId(Integer itemId);
}

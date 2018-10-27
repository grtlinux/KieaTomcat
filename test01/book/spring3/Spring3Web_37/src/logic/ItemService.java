package logic;

import java.io.InputStream;
import java.util.List;

public interface ItemService {

	public List<Item> getItemList();
	public Item getItemByItemId(Integer itemId);
	public List<Item> getItemByItemName(String itemName);
	public void entryItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(Item item);
	public InputStream getPicture(Integer itemId);
}

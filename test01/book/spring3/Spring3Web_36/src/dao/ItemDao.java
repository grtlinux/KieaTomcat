package dao;

import java.io.InputStream;
import java.util.List;

import logic.Item;

public interface ItemDao {

	public List<Item> findAll();
	public Item findByPrimaryKey(Integer itemId);
	public List<Item> findByItemName(String itemName);
	public void create(Item item);
	public void update(Item item);
	public void delete(Item item);
	public InputStream getPicture(Integer itemId);
}

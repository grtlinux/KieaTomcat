package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.Item;

public final class ItemDaoImpl implements ItemDao {

	private SimpleJdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	private static final String SELECT_ALL = "select item_id, item_name, price, description, picture_url from item";
	
	@Override
	public List<Item> findAll() {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.jdbcTemplate.query(ItemDaoImpl.SELECT_ALL, mapper);
	}

	private static final String SELECT_BY_PRIMARY_KEY = "select item_id, item_name, price, description, picture_url from item where item_id = ?";
	
	@Override
	public Item findByPrimaryKey(Integer itemId) {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.jdbcTemplate.queryForObject(ItemDaoImpl.SELECT_BY_PRIMARY_KEY, mapper, itemId);
	}

}

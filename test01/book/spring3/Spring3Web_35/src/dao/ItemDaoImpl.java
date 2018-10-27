package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import logic.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	private SimpleJdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public List<Item> findAll() {
		String query = " select item_id, item_name, price, description, picture_url from item";
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.jdbcTemplate.query(query, mapper);
	}

	@Override
	public Item findByPrimaryKey(Integer itemId) {
		String query = " select item_id, item_name, price, description, picture_url from item where item_id = ?";
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.jdbcTemplate.queryForObject(query, mapper, itemId);
	}

}

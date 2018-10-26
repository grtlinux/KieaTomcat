package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.User;

public final class UserDaoImpl implements UserDao {

	private SimpleJdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public User findByUserIdAndPassword(String userId, String password) {
		String query = ""
				+ " select"
				+ "    user_id,"
				+ "    password,"
				+ "    user_name,"
				+ "    postcode,"
				+ "    address,"
				+ "    email,"
				+ "    job,"
				+ "    birthday"
				+ " from"
				+ "    user_account"
				+ " where"
				+ "    user_id = ? and"
				+ "    password = ?"
				+ "";
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return this.jdbcTemplate.queryForObject(query, mapper, userId, password);
	}

}

package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import logic.User;

@Repository
public class UserDaoImpl implements UserDao {

	private SimpleJdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public void create(User user) {
		String query = ""
				+ " insert into user_account"
				+ " (user_id, user_name, password, postcode, address, email, job, birthday)"
				+ " values"
				+ " (:userId, :userName, :password, :postCode, :address, :email, :job, :birthDay)"
				+ "";
		SqlParameterSource source = new BeanPropertySqlParameterSource(user);
		this.jdbcTemplate.update(query, source);
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
				+ " where 1=1"
				+ "    and user_id = ?"
				+ "    and password = ?"
				+ "";
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return this.jdbcTemplate.queryForObject(query, mapper, userId, password);
	}

}

package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.User;

public final class UserDaoImpl implements UserDao {

	private SimpleJdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public void create(User user) {
		String query = ""
				+ " insert into user_account"
				+ " (user_id, user_name, password, postcode, address, email, job, birthday)"
				+ " values"
				+ " (:userId, :userName, :password, :postCode, :address, :email, :job, :birthDay)";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
		this.jdbcTemplate.update(query, parameterSource);
	}
}

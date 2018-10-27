package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import logic.Sale;

@Repository
public class SaleDaoImpl implements SaleDao {

	private SimpleJdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public void create(Sale sale) {
		String query = ""
				+ " insert into sale"
				+ " (sale_id, user_id, update_time)"
				+ " values"
				+ " (?,?,?)";
		this.jdbcTemplate.update(query
				, sale.getSaleId()
				, sale.getUser()
				, sale.getUpdateTime()
				);
	}

	@Override
	public Integer findMaxSaleId() {
		String query = " select max(sale_id) as sale_id from sale";
		return this.jdbcTemplate.queryForInt(query);
	}
}

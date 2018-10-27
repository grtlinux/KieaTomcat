package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import logic.SaleLine;

@Repository
public class SaleLineDaoImpl implements SaleLineDao {

	private SimpleJdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public void create(SaleLine saleLine) {
		String query = ""
				+ " insert into sale_line"
				+ " (sale_id, sale_line_id, item_id, quantity, update_time)"
				+ " values"
				+ " (?,?,?,?,?)";
		this.jdbcTemplate.update(query
				, saleLine.getSale().getSaleId()
				, saleLine.getSaleLineId()
				, saleLine.getItem().getItemId()
				, saleLine.getQuantity()
				, saleLine.getUpdateTime()
				);
	}
}

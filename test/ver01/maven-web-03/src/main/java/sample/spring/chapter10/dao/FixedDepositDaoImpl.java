package sample.spring.chapter10.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import sample.spring.chapter10.domain.FixedDepositDetails;

@Repository
public class FixedDepositDaoImpl implements FixedDepositDao {

	private List<FixedDepositDetails> list;
	
	public FixedDepositDaoImpl() {
		this.list = new ArrayList<FixedDepositDetails>();
		this.list.add(new FixedDepositDetails(1L, "10000", "24", "emp1@domain.com"));
		this.list.add(new FixedDepositDetails(2L, "20000", "34", "emp2@domain.com"));
		this.list.add(new FixedDepositDetails(3L, "30000", "26", "emp3@domain.com"));
		this.list.add(new FixedDepositDetails(4L, "40000", "22", "emp4@domain.com"));
		this.list.add(new FixedDepositDetails(5L, "15000", "12", "emp5@domain.com"));
	}
	
	@Override
	public List<FixedDepositDetails> getFixedDeposits() {
		return this.list;
	}

	@Override
	public void saveFixedDeposit(FixedDepositDetails fixedDepositDetails) {
		Random random = new Random();
		long id = random.nextInt();
		fixedDepositDetails.setId(id);
		this.list.add(fixedDepositDetails);
	}

	@Override
	public void closeFixedDeposit(int fixedDepositId) {
		for (FixedDepositDetails fixedDepositDetails : this.list) {
			if (fixedDepositDetails.getId() == fixedDepositId) {
				this.list.remove(fixedDepositDetails);
				break;
			}
		}
	}

	@Override
	public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
		for (FixedDepositDetails fixedDepositDetails : this.list) {
			if (fixedDepositDetails.getId() == fixedDepositId) {
				return fixedDepositDetails;
			}
		}
		
		return null;
	}

	@Override
	public void editFixedDeposit(FixedDepositDetails modifiedFixedDepositDetails) {
		for (FixedDepositDetails fixedDepositDetails : this.list) {
			if (fixedDepositDetails.getId() == modifiedFixedDepositDetails.getId()) {
				this.list.remove(fixedDepositDetails);
				break;
			}
		}
		this.list.add(modifiedFixedDepositDetails);
	}
}

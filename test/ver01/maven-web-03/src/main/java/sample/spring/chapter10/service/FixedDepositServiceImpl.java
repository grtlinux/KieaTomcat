package sample.spring.chapter10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.spring.chapter10.dao.FixedDepositDao;
import sample.spring.chapter10.domain.FixedDepositDetails;

@Service
public class FixedDepositServiceImpl implements FixedDepositService {

	@Autowired
	private FixedDepositDao fixedDepositDao;
	
	@Override
	public List<FixedDepositDetails> getFixedDetails() {
		return this.fixedDepositDao.getFixedDeposits();
	}

	@Override
	public void saveFixedDeposit(FixedDepositDetails fixedDepositDetails) {
		this.fixedDepositDao.saveFixedDeposit(fixedDepositDetails);
	}

	@Override
	public void closeFixedDeposit(int fixedDepositId) {
		this.fixedDepositDao.closeFixedDeposit(fixedDepositId);
	}

	@Override
	public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
		return this.fixedDepositDao.getFixedDeposit(fixedDepositId);
	}

	@Override
	public void editFixedDeposit(FixedDepositDetails fixedDepositDetails) {
		this.fixedDepositDao.editFixedDeposit(fixedDepositDetails);
	}
}

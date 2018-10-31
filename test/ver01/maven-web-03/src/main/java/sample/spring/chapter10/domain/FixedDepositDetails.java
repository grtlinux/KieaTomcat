package sample.spring.chapter10.domain;

public class FixedDepositDetails {

	private long id;              // id
	private String depositAmount; // 예금총액
	private String tenure;        // 제임기간
	private String email;         // 메일
	
	public FixedDepositDetails() {}
	public FixedDepositDetails(Long id, String depositAmount, String tenure, String email) {
		this.id = id;
		this.depositAmount = depositAmount;
		this.tenure = tenure;
		this.email = email;
	}
	
	//////////////////////////////////////////////////
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}
	public String getTenure() {
		return tenure;
	}
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	///////////////////////////////////////////////////
	
	public String toString() {
		return String.format("id: %d, deposit amount: %s, tenure: %s, email: %s"
				, this.id
				, this.depositAmount
				, this.tenure
				, this.email
				);
	}
}

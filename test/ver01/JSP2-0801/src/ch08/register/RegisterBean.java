package ch08.register;

public class RegisterBean {

	private String id;
	private String passwd;
	private String name;
	private String email;
	private String tel;
	
	////////////////////////////////////////
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		System.out.println(">>>>> getName(): " + this.name);
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println(">>>>> setName(): " + this.name);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}

package user;

public class UserDTO {
	private String userid;
	private String userpassword;
	private String useremail;
	private String useremailhash;
	private boolean  useremailchecked;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUseremailhash() {
		return useremailhash;
	}
	public void setUseremailhash(String useremailhash) {
		this.useremailhash = useremailhash;
	}
	public boolean isUseremailchecked() {
		return useremailchecked;
	}
	public void setUseremailchecked(boolean useremailchecked) {
		this.useremailchecked = useremailchecked;
	}
	
	//아무것도 담지 않는 생성자도 하나 생성
	public UserDTO() {
		
	}
	// 초기화 
	public UserDTO(String userid, String userpassword, String useremail, String useremailhash,
			boolean useremailchecked) {
		super();
		this.userid = userid;
		this.userpassword = userpassword;
		this.useremail = useremail;
		this.useremailhash = useremailhash;
		this.useremailchecked = useremailchecked;
	}
	
	
	
}

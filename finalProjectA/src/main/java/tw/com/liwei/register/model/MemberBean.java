package tw.com.liwei.register.model;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class MemberBean {
	private Integer memberId;	// 流水號
	private String accountId;	// 帳號
	private String password;
	private String memberName;	// 姓名
	private Date birth;
	private Byte gender;
	private String email;
//	private Blob photo1;
//	private Blob photo2;
	private String introduction;
	
	public MemberBean() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Blob getPhoto1() {
//		return photo1;
//	}
//
//	public void setPhoto1(Blob photo1) {
//		this.photo1 = photo1;
//	}
//
//	public Blob getPhoto2() {
//		return photo2;
//	}
//
//	public void setPhoto2(Blob photo2) {
//		this.photo2 = photo2;
//	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}

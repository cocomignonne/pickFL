package com.pickfl.member.model.vo;

import java.sql.Timestamp;

public class MemberVo {
	private int memberNo;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String emailHash;
	private boolean emailChecked;
	private String birth;
	private Timestamp joinDate;
	private String role;
	
	public MemberVo() {
		
	}

	public MemberVo(int memberNo, String id, String pwd, String name, String email, String emailHash,
			boolean emailChecked) {
		super();
		this.memberNo = memberNo;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.emailHash = emailHash;
		this.emailChecked = emailChecked;
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmailHash() {
		return emailHash;
	}
	public void setEmailHash(String emailHash) {
		this.emailHash = emailHash;
	}
	public boolean isEmailChecked() {
		return emailChecked;
	}
	public void setEmailChecked(boolean emailChecked) {
		this.emailChecked = emailChecked;
	}
	
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Timestamp getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MemberVo [memberNo=" + memberNo + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email
				+ ", emailHash=" + emailHash + ", emailChecked=" + emailChecked + ", birth=" + birth + ", joinDate="
				+ joinDate + ", role=" + role + "]";
	}
}

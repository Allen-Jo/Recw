package com.recw.member.vo;

import java.util.Date;

public class MemberVO {

	private String mem_num;
	private String mem_email;
	private String mem_password;
	private String mem_nickname;
	private Date mem_reg_date;
	private int mem_leveL;
	private String mem_key;

	public MemberVO() {
		super();
	}

	public MemberVO(String mem_num, String mem_email, String mem_password, String mem_nickname, Date mem_reg_date,
			int mem_leveL, String mem_key) {
		super();
		this.mem_num = mem_num;
		this.mem_email = mem_email;
		this.mem_password = mem_password;
		this.mem_nickname = mem_nickname;
		this.mem_reg_date = mem_reg_date;
		this.mem_leveL = mem_leveL;
		this.mem_key = mem_key;
	}

	public String getMem_num() {
		return mem_num;
	}

	public void setMem_num(String mem_num) {
		this.mem_num = mem_num;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_password() {
		return mem_password;
	}

	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}

	public String getMem_nickname() {
		return mem_nickname;
	}

	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}

	public Date getMem_reg_date() {
		return mem_reg_date;
	}

	public void setMem_reg_date(Date mem_reg_date) {
		this.mem_reg_date = mem_reg_date;
	}

	public int getMem_leveL() {
		return mem_leveL;
	}

	public void setMem_leveL(int mem_leveL) {
		this.mem_leveL = mem_leveL;
	}

	public String getMem_key() {
		return mem_key;
	}

	public void setMem_key(String mem_key) {
		this.mem_key = mem_key;
	}

	@Override
	public String toString() {
		return "MemberVO [mem_num=" + mem_num + ", mem_email=" + mem_email + ", mem_password=" + mem_password
				+ ", mem_nickname=" + mem_nickname + ", mem_reg_date=" + mem_reg_date + ", mem_leveL=" + mem_leveL
				+ ", mem_key=" + mem_key + "]";
	}

}

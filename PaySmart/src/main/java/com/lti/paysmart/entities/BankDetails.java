package com.lti.paysmart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROJ_BANK")
public class BankDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	@SequenceGenerator(name = "seqid-gen", sequenceName = "RTDS_ADSINPUT_SEQ" )
	@Column(name = "BANKDETAILS_ID")
	private int bankdetails_id;
	private String bank_name;
	private String acc_no;
	private String ifsc_code;
	

	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	public int getBankdetails_id() {
		return bankdetails_id;
	}


	public void setBankdetails_id(int bankdetails_id) {
		this.bankdetails_id = bankdetails_id;
	}


	public String getBank_name() {
		return bank_name;
	}


	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}


	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getAcc_no() {
		return acc_no;
	}


	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}

}

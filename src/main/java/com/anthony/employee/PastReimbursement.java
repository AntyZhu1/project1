package com.anthony.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "past_reimbursements")
public class PastReimbursement {
	
	@Id
	private int past_re_id;

	
	@Column(name = "past_emp_id", length = 100)
	private int past_emp_id;

	
	@Column(name = "past_type", length = 100)
	private String past_type;
	
	@Column(name = "past_amount", length = 100)
	private double past_amount;
	
	@Column(name = "past_desc", length = 100)
	private String past_desc;
	
	@Column(name = "past_date", length = 100)
	private String past_date;
	
	@Column(name= "past_approve_status", length = 100)
	private String past_approve_status;

	public int getPast_emp_id() {
		return past_emp_id;
	}

	public void setPast_emp_id(int past_emp_id) {
		this.past_emp_id = past_emp_id;
	}

	public int getPast_re_id() {
		return past_re_id;
	}

	public void setPast_re_id(int past_re_id) {
		this.past_re_id = past_re_id;
	}

	public String getPast_type() {
		return past_type;
	}

	public void setPast_type(String past_type) {
		this.past_type = past_type;
	}

	public double getPast_amount() {
		return past_amount;
	}

	public void setPast_amount(double past_amount) {
		this.past_amount = past_amount;
	}

	public String getPast_desc() {
		return past_desc;
	}

	public void setPast_desc(String past_desc) {
		this.past_desc = past_desc;
	}

	public String getPast_date() {
		return past_date;
	}

	public void setPast_date(String past_date) {
		this.past_date = past_date;
	}

	public String getPast_approve_status() {
		return past_approve_status;
	}

	public void setPast_approve_status(String past_approve_status) {
		this.past_approve_status = past_approve_status;
	}

	public PastReimbursement() {
		super();
	}

	public PastReimbursement(int past_re_id, int past_emp_id, String past_type, double past_amount, String past_desc,
			String past_date, String past_approve_status) {
		super();
		this.past_emp_id = past_emp_id;
		this.past_re_id = past_re_id;
		this.past_type = past_type;
		this.past_amount = past_amount;
		this.past_desc = past_desc;
		this.past_date = past_date;
		this.past_approve_status = past_approve_status;
	}

	@Override
	public String toString() {
		return "PastReimbursement [past_emp_id=" + past_emp_id + ", past_re_id=" + past_re_id + ", past_type="
				+ past_type + ", past_amount=" + past_amount + ", past_desc=" + past_desc + ", past_date=" + past_date
				+ ", past_approve_status=" + past_approve_status + "]";
	}

	
	
}


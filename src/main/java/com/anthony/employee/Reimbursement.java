package com.anthony.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "pending_reimbursements")
public class Reimbursement {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int re_id;
	
	@Column(name = "re_emp_id", length = 100)
	private int re_emp_id;
	
	@Column(name = "re_type", length = 100)
	private String re_type;
	
	@Column(name = "re_amount", length = 100)
	private double re_amount;
	
	@Column(name = "re_desc", length = 100)
	private String re_desc;
	
	@Column(name = "re_date", length = 100)
	private String re_date;

	public int getRe_id() {
		return re_id;
	}

	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}

	public int getRe_emp_id() {
		return re_emp_id;
	}

	public void setRe_emp_id(int re_emp_id) {
		this.re_emp_id = re_emp_id;
	}

	public String getRe_type() {
		return re_type;
	}

	public void setRe_type(String re_type) {
		this.re_type = re_type;
	}

	public double getRe_amount() {
		return re_amount;
	}

	public void setRe_amount(double re_amount) {
		this.re_amount = re_amount;
	}

	public String getRe_desc() {
		return re_desc;
	}

	public void setRe_desc(String re_desc) {
		this.re_desc = re_desc;
	}

	public String getRe_date() {
		return re_date;
	}

	public void setRe_date(String re_date) {
		this.re_date = re_date;
	}

	public Reimbursement(int re_emp_id, String re_type, double re_amount, String re_desc, String re_date) {
		super();
		
		this.re_emp_id = re_emp_id;
		this.re_type = re_type;
		this.re_amount = re_amount;
		this.re_desc = re_desc;
		this.re_date = re_date;
	}

	public Reimbursement() {
		super();
	}

	@Override
	public String toString() {
		return "Reimbursement [re_id=" + re_id + ", re_emp_id=" + re_emp_id + ", re_type=" + re_type + ", re_amount="
				+ re_amount + ", re_desc=" + re_desc + ", re_date=" + re_date + "]";
	}
	
	
	
}

package com.atedev.Bean;

import java.util.Date;

public class Student {
	private int sno;
	private String name;
	private Date dob, doj;
	public Student() {
		super();
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "StudentModel [sno=" + sno + ", name=" + name + ", dob=" + dob + ", doj=" + doj + "]";
	}
}

package com.ppp.grade.department.persistence;

public class DepartmentVO {
	private String 학과코드;
	private String 학과명;
	public String get학과코드() {
		return 학과코드;
	}
	public void set학과코드(String 학과코드) {
		this.학과코드 = 학과코드;
	}
	public String get학과명() {
		return 학과명;
	}
	public void set학과명(String 학과명) {
		this.학과명 = 학과명;
	}
	
	@Override
	public String toString(){
	    return "Deparment [ " + "학과코드 : " + 학과코드 + " 학과명 : " + 학과명 + " ]";
	}
}

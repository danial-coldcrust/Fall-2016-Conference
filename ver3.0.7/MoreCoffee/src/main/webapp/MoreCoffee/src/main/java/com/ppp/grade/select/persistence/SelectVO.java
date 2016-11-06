package com.ppp.grade.select.persistence;

public class SelectVO {
	private String 과목코드;
	private String 학번;
	
	public String get과목코드() {
		return 과목코드;
	}
	
	public void set과목코드(String 과목코드) {
		this.과목코드 = 과목코드;
	}

	public String get학번() {
		return 학번;
	}

	public void set학번(String 학번) {
		this.학번 = 학번;
	}

	@Override
	public String toString() {
		return "SubjectVO [ 과목코드:" + 과목코드 + ",학번:" + 학번 + "]";
	}

}
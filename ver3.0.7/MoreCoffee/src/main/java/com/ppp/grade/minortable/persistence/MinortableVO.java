package com.ppp.grade.minortable.persistence;

public class MinortableVO {
	String 복수전공학점;
	String 전공학점;
	String 학과코드;
	String 연도;

	public String get학과코드() {
		return 학과코드;
	}
	
	public void set학과코드(String 학과코드) {
		this.학과코드 = 학과코드;
	}
	
	public String get연도() {
		return 연도;
	}
	
	public void set연도(String 연도) {
		this.연도 = 연도;
	}
	
	public String get복수전공학점() {
		return 복수전공학점;
	}
	
	public void set복수전공학점(String 복수전공학점) {
		this.복수전공학점 = 복수전공학점;
	}

	public String get전공학점() {
		return 전공학점;
	}

	public void set전공학점(String 전공학점) {
		this.전공학점 = 전공학점;
	}
	
	@Override
	public String toString() {
		return "MinortableVO [ 학과코드:" + 학과코드 + ",연도:" + 연도 + 
				 ",전공학점:" + 전공학점+ ",복수전공학점:" + 복수전공학점+ "]";
		
	}
}
